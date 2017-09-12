# TTC'16 The Class Responsibility Assignment Case - SIGMA solution

## Prerequisites

- [SBT - simple build tool](http://www.scala-sbt.org/download.html)

## Running the solution

```sh
$ ./build.sh
$ java [<optional parameters>] -jar target/scala-2.11/ttc16-cra-sigma_2.11-1.0-one-jar.jar <input> <output>
or
$ ./run.sh <model directory> [<optional parameters>] # to run multiple models capturing some statistics
eg.
$ ./run.sh models # runs CRA on all models in models directory and
```

where optional parameters are:
- `-Dalgorithm=<value>` (default = NSGAIII)
- `-DnumRuns=<value>` (default = 10)
- `-DpopulationSize=<value>` (default = 64)
- `-DmaxEvaluations=<value>` (default = 10000)

The result of the `run.sh` is generated in `outputs` directory. Next to the models, it contains a CSV file (result.csv) which for each input model outputs:

- model name
- cohesion ration
- coupling ration
- CRA index
- execution time

There is also an `.out` file per model which records the standard output of the transformation process.

## Re-generating SIGMA support for the EMF model

Shall the EMF model change, these are the steps to regenerate the EMF support for SIGMA:

```sh
$ sbt
...
> consoleQuick
> :load generate-sigma-support.scala-console
```

## Sample Results

The experiment was executed on 3,1 GHz Intel Core i7, 16GB RAM macBook Pro:

```sh
$ ./run.sh models
```

| Model          | Cohesion | Coupling | CRA   | Time [s] | Runs |
|----------------|----------|----------|-------|----------|------|
| TTC_InputRDG_A | 4        | 1        | 3     | 10       | 10   |
| TTC_InputRDG_B | 6.67     | 2.58     | 4.08  | 13       | 10   |
| TTC_InputRDG_C | 4.99     | 2.57     | 2.41  | 39       | 10   |
| TTC_InputRDG_D | 9.36     | 8.50     | 0.87  | 91       | 10   |
| TTC_InputRDG_E | 7.14     | 16.25    | -9.11 | 1416     | 10   |

_Note: that the time is the total time of all the 10 runs._

```sh
$ ./run.sh additional-models -DnumRuns=1
```

| Model          | Cohesion | Coupling | CRA     | Time [s] | Runs |
|----------------|----------|----------|---------|----------|------|
| TTC_InputRDG_F | 9.87     | 39.37    | -29.50  | 234      | 1    |   
| TTC_InputRDG_G | 9.76     | 369.44   | -359.68 | 1213     | 1    |
