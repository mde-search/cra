import os
import pandas
import matplotlib
matplotlib.use('PDF')
import matplotlib.pyplot as plotter
import numpy

valuestep=1
values=20

matplotlib.rcParams['xtick.labelsize'] = 14
matplotlib.rcParams['ytick.labelsize'] = 14

def plotdata(data_collections, output_file, extension):
    plotter.clf()
    plotter.cla()
    fig = plotter.figure(1)
    ax = fig.add_subplot(111)
    bp = ax.boxplot(data_collections)
    xtickNames = plotter.setp(ax, xticklabels=range(valuestep, values+1, valuestep))
    ymin, ymax = mM(data_collections)
    ax.set_ylim([ymin-1, ymax+1])
    ax.tick_params(axis='both', direction='out')
    ax.get_xaxis().tick_bottom()
    ax.get_yaxis().tick_left()
    ax.set_ylabel("CRA-Index", fontsize=14)
    ax.set_xlabel("Iterations", fontsize=14)
    median = bp['medians'][-1].get_ydata()
    print str(median[0]).replace(".", "_")
    fig.savefig(output_file+"-"+str(median[0]).replace(".", "_")+"."+extension, bbox_inches='tight')

def mM(L):
    mi = min(min(x) for x in L)
    ma = max(max(x) for x in L)
    return mi, ma

if __name__=="__main__":
    colnames = ['classes', 'cohesion', 'coupling', 'fitness']

    for subdir, dirs, files in os.walk(os.getcwd()):
        cra_values = []
        for filename in files:
            if filename.endswith("metrics.csv"):
                data = pandas.read_csv(os.path.join(subdir, filename), names=colnames)
                data.fitness.pop(0)
                cra_values.append(pandas.to_numeric(data.fitness.tolist()[:-1][valuestep-1::valuestep]))
        if len(cra_values) > 0:
            print subdir
            print cra_values
            plotdata(zip(*cra_values), subdir + "plot", "pdf")
