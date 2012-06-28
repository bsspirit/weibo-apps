#http://blog.revolutionanalytics.com/2009/01/create-beautiful-statistical-graphics-with-ggplot2.html
library(ggplot2)
#qplot(depth,..density..,data=diamonds,geom="histogram",xlim=c(58,68), binwidth=0.1,colour=cut)
#qplot(depth,..density..,data=diamonds,geom="freqpoly",xlim=c(58,68), binwidth=0.1,colour=cut)

depth_dist <- ggplot(diamonds, aes(depth)) + xlim(58, 68)
depth_dist + geom_histogram(aes(fill = cut), binwidth = 0.1,position = "fill")
