library(ggplot2)
library(plyr)

####################################################################################################

yaxis = function() {
  # y axis labels
  longticks = c(F, F, F, F, F, F, F, F, T)
  shortticks = 2:10
  range = 0:4
  
  ooms = 10^range
  
  ybreaks = as.vector(shortticks %o% ooms)
  
  emptylabels = rep(c(""), each=8)
  longticklabels = c(10, 100, 1000, 10000, 100000)
  
  ylabels = c()
  for (longticklabel in longticklabels) {
    ylabels = c(ylabels, emptylabels, longticklabel)
  }
  
  print(ybreaks)
  print(ylabels)
  
  list(ybreaks = ybreaks, ylabels = ylabels)
}

####################################################################################################

width = 5
height = 3

results = read.csv(file = "results.csv")
results$time = results$time / 10^3
#results$category <- revalue(results$input, c("A"="1", "B"="1", "C"="1", "D"="2", "E"="2"))

yaxis = yaxis()
ybreaks = yaxis$ybreaks
ylabels = yaxis$ylabels

# pt = ggplot(results) +
#   geom_boxplot(aes(x = input, y = time)) +
#   xlab("Input model") + 
#   ylab("Execution time [s]") + 
#   ggtitle("Execution times of the design space exploration") +
#   facet_wrap(~ category, drop = T, scales = "free", ncol = 5) +
#   theme_bw()
# print(pt)
# ggsave(file = "results-times.pdf", width = width, height = height, device = cairo_pdf)

p = ggplot(results, aes(x = input, y = time, color = tool)) + 
  geom_point() +
  ggtitle("Execution times of the design space exploration") +
  scale_y_log10(breaks = ybreaks, labels = ylabels) +
  theme_bw() +
  xlab("Input model") + 
  ylab("Execution time [s]")
#  stat_summary(fun.y = median,
#               fun.ymin = median,
#            fun.ymax = median,
#            color = "red",
#            geom = "crossbar", width = 0.3)
print(p)
ggsave(file = "results-times.pdf", width = width, height = height, device = cairo_pdf)

pc = ggplot(results) +
  geom_boxplot(aes(x = input, y = CRA.Index, fill = tool)) +
  xlab("Input model") + 
  ylab("CRA-Index") + 
  ggtitle("Values of the CRA-Index") +
  theme_bw()
print(pc)
ggsave(file = "results-cra.pdf", width = width, height = height, device = cairo_pdf)


prettify = function(df) {
  df$minutes = floor(df$time / 60)
  df$seconds = floor(df$time %% 60)
  df$millis  = floor((df$time %% 1) * 1000)
  df
}

vars = c("tool", "input")

# calculate median values
results.medians = ddply(
  .data = results,
  .variables = vars,
  .fun = colwise(median)
)
prettify(results.medians)

# calculate min values
results.mins = ddply(
  .data = results,
  .variables = vars,
  .fun = colwise(min)
)
prettify(results.mins)

# calculate min values
results.maxes = ddply(
  .data = results,
  .variables = vars,
  .fun = colwise(max)
)
prettify(results.maxes)
