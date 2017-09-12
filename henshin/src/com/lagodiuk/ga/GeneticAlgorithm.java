/*******************************************************************************
 * Copyright 2012 Yuriy Lagodiuk
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.lagodiuk.ga;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import architectureCRA.ClassModel;
import logging.Logger;
import solution.ClassModelSolution;
import solution.Utility;

public class GeneticAlgorithm<C extends Chromosome<C>, T extends Comparable<T>> {

	private static final int ALL_PARENTAL_CHROMOSOMES = Integer.MAX_VALUE;

	private class ChromosomesComparator implements Comparator<C> {

		private final Map<C, T> cache = new WeakHashMap<C, T>();

		@Override
		public int compare(C chr1, C chr2) {
			T fit1 = this.fit(chr1);
			T fit2 = this.fit(chr2);
			int ret = fit1.compareTo(fit2);
			return ret;
		}

		public T fit(C chr) {
			T fit = this.cache.get(chr);
			if (fit == null) {
				fit = GeneticAlgorithm.this.fitnessFunc.calculate(chr);
				this.cache.put(chr, fit);
			}
			return fit;
		};

		public void clearCache() {
			this.cache.clear();
		}
	}

	private final ChromosomesComparator chromosomesComparator;

	private final Fitness<C, T> fitnessFunc;

	private Population<C> population;

	// listeners of genetic algorithm iterations (handle callback afterwards)
	private final List<IterartionListener<C, T>> iterationListeners = new LinkedList<IterartionListener<C, T>>();

	private boolean terminate = false;

	// number of parental chromosomes, which survive (and move to new
	// population)
	private int parentChromosomesSurviveCount = ALL_PARENTAL_CHROMOSOMES;

	private int iteration = 0;

	protected int getFitnessThreshold;

	private ClassModel rdg;

	public GeneticAlgorithm(Population<C> population, Fitness<C, T> fitnessFunc, ClassModel rdg) {
		this.rdg = rdg;
		this.population = population;
		this.fitnessFunc = fitnessFunc;
		this.chromosomesComparator = new ChromosomesComparator();
		this.population.sortPopulationByFitness(this.chromosomesComparator);
	}

	public void evolve() {
		int parentPopulationSize = this.population.getSize();

		Population<C> newPopulationOfOriginalsAndMutants = new Population<C>();

		for (int i = 0; (i < parentPopulationSize) && (i < this.parentChromosomesSurviveCount); i++) {
			newPopulationOfOriginalsAndMutants.addChromosome(this.population.getChromosomeByIndex(i));
		}

		// add mutants to new population
		for (int i = 0; i < parentPopulationSize; i++) {
			C chromosome = this.population.getChromosomeByIndex(i);
			C mutated = chromosome.mutate();


			newPopulationOfOriginalsAndMutants.addChromosome(mutated);
		}
		
		
		Population<C> finalePopulationOfEvolution = new Population<C>();
		for (int i = 0; i < newPopulationOfOriginalsAndMutants.getSize(); i++) {
			finalePopulationOfEvolution.addChromosome(newPopulationOfOriginalsAndMutants.getChromosomeByIndex(i));
		}
		
		finalePopulationOfEvolution.sortPopulationByFitness(this.chromosomesComparator);
		for (int i = 0; i < parentPopulationSize; i++) {
//			System.err.println("CROSSOVERING: "+i+"/"+newPopulationOfOriginalsAndMutants.getSize());
			C otherChromosome = newPopulationOfOriginalsAndMutants.getRandomChromosome();
			List<C> crossovered = newPopulationOfOriginalsAndMutants.getChromosomeByIndex(i).crossover(Utility.getClassModelCopy(rdg), otherChromosome);			
			for (C c : crossovered) {
				finalePopulationOfEvolution.addChromosome(c);
			}
		}
		
		
		finalePopulationOfEvolution.sortPopulationByFitness(this.chromosomesComparator);
//		newPopulation.trim(parentPopulationSize); //superfluous

		Population<C> resultOfNewPopulation = new Population<C>();
		
		// best 10%
		int numberOfBestIndividuums = 1 + (int)    Math.round( 0.1 * parentPopulationSize);
		for(int i = 0; i<parentPopulationSize; i++){
			if(i<numberOfBestIndividuums){
				resultOfNewPopulation.addChromosome(finalePopulationOfEvolution.getChromosomeByIndex(i));				
			} else{				
				resultOfNewPopulation.addChromosome(finalePopulationOfEvolution.getRandomChromosome());
			}
		}
		
		this.population = resultOfNewPopulation;
	}


	public void evolve(int count) {
		this.terminate = false;

		ClassModelSolution bestCMS = null;
		for (int i = 0; i < count; i++) {
			System.err.println("EVOLUTION: "+i);
			if (this.terminate) {
				break;
			}
			this.evolve();
			// intrusion ->>
			C best = this.getBest();
			bestCMS = (ClassModelSolution) best;
//			Logger.storeUnitApplication(bestCMS.getLastMutation()); //not possible due to first mutation, then crossover, then CRA calculation
			Logger.storeModelInfo(bestCMS.getClassModel());
			// <<- intrusion
			this.iteration = i;
			for (IterartionListener<C, T> l : this.iterationListeners) {
				l.update(this);
			}
		}
		fixResult();
		Logger.storeModelInfo(bestCMS.getClassModel());
	}

	public int getIteration() {
		return this.iteration;
	}

	public void terminate() {
		fixResult();
		this.terminate = true;
	}

	public Population<C> getPopulation() {
		return this.population;
	}

	public C getBest() {
		return this.population.getChromosomeByIndex(0);
	}

	public C getWorst() {
		return this.population.getChromosomeByIndex(this.population.getSize() - 1);
	}

	public void setParentChromosomesSurviveCount(int parentChromosomesCount) {
		this.parentChromosomesSurviveCount = parentChromosomesCount;
	}

	public int getParentChromosomesSurviveCount() {
		return this.parentChromosomesSurviveCount;
	}

	public void addIterationListener(IterartionListener<C, T> listener) {
		this.iterationListeners.add(listener);
	}

	public void removeIterationListener(IterartionListener<C, T> listener) {
		this.iterationListeners.remove(listener);
	}

	public T fitness(C chromosome) {
		return this.chromosomesComparator.fit(chromosome);
	}

	public void clearCache() {
		this.chromosomesComparator.clearCache();
	}

	private void fixResult() {
		for(C c : population){
			if(c instanceof ClassModelSolution){
				fixSolution(c);				
			}
		}
	}
	
	private void fixBestSolution() {
		
	}

	private void fixSolution(C c) {
		ClassModelSolution anyCMS = (ClassModelSolution) c; 
		Utility.deleteEmptyClasses(anyCMS.getClassModel());			
		Utility.doNameFix(anyCMS.getClassModel());
	}
}
