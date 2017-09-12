# Solving the Class Responsibility Assignment Case (TTC2016) with Henshin and a Genetic Algorithm #

A solution for a [case](https://github.com/martin-fleck/cra-ttc2016) in the [Transformation Tool Contest 2016](http://www.transformation-tool-contest.eu/).

## How to use this repository? ##

### Download output models and logs ###

You can find the output models and logs (providing the runtime in milliseconds) from our experiments in the *[results](https://bitbucket.org/ttc16/ttc16/src/efe209cbe7daf63cf96402b452df47ae496cfaf1/ttc16-solution/results/?at=master)* directory. There are four main sub-folders.

* *best_of*: Best produced output model for each of the input models *TTC_InputRDG_A-E* 
* *init1-50_20i*t: Initialization. 3 alternative strategies. 20 iterations, 5 individuals per population, 10 runs.
    * Recommended configuration: *runconfig_ONE_CLASS_PER_FEATURE*
* *mutation_10it*: Mutation. 4 combinable strategies, 16 combinations in total. 10 iterations, 5 individuals per population, 10 runs.
    * Recommended configuration: *runConfig_4 (JSC,MSF,RS)*
* *crossover_20it*. Crossover 3 alternative strategies + no-op strategy. 20 iterations, 5 individuals per population, 10 runs.
    * Recommended configuration: *conConfig_1 (classWithBestCohesionCrossover)*

Please note that we provide output models and runtimes from *all* tested configurations to show the variety of the configuration space. Optimality is best evaluated by only considering the output models for the recommended configurations.

### Install and use our tool ###

Set-up

* Download and install the [Eclipse Modeling Tools, Mars 2](http://www.eclipse.org/downloads/packages/eclipse-modeling-tools/mars2) distribution. We do not claim any support for earlier Eclipse versions.
* Install the **cra.ttc16_1.0.0** plugin in your Eclipse. This plugin contains the required meta-model with its generated API. To install this plug-in, 
    * download the file  **cra.ttc16_1.0.0.jar** from the folder [ttc16-solution/dropin](https://bitbucket.org/ttc16/ttc16/src/960f57914285dbf930c8610a9068e3a1bf6bc7fa/ttc16-solution/dropin/?at=master) of the repository,
    * move the downloaded file to the **drop-ins** folder of your Eclipse instance.
    * restart Eclipse.
* Check out the **ttc16-solution** project from this repository to your local workspace. The project should now compile automatically without errors.

Usage

* For a simple start, use the **Runner.java** class in the **solution** package. This class contains the code to run our solution on five input models, *TTC_InputRDG_A-E,* with our recommended configuration. Right-click on the class and select *Run as -> Java Application*.
* To reproduce our experiments, use the different runner classes in the **solution.runner** source package. 

### View and edit the transformation rules ###
* To view and edit the transformation rules, you need to install Henshin first. Use the release update site from the [Henshin website](https://www.eclipse.org/henshin/install.php)
* You can now open the **.henshin** and **.henshin_diagram** files contained in the **transformations** folder of the *ttc16-solution* project.

### Additional how-tos ####

* Check the **howtos** folder for additional manuals. The PDFs found here are the same as those found on the desktop in the TTC2016 SHARE installation.