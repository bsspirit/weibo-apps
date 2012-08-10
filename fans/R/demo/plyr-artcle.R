#http://www.dataguru.cn/article-1981-1.html

time_cost <- data.frame(Task = c("1.Clarify Demand", "2.Model Selection", "3.Get Data", "4.Data Cleaning", "5.Analyzing", "6.Report"), Time_ideal = c(0.1, 0.3, 0.1, 0.1, 0.3, 0.1), Time_real = c(0.2, 0.05, 0.2, 0.3, 0.05, 0.2))
library(ggplot2) 
library(gridExtra) 
library(scales)
g1 <- ggplot(data = time_cost, aes(x = Task, y = Time_ideal, fill = Time_ideal)) + geom_bar() + coord_flip() + geom_text(aes(label = paste(round(Time_ideal * 100, 2), "%"), y = Time_ideal/2)) + scale_y_continuous(labels = percent) + scale_fill_continuous(low = "deepskyblue1", high = "deepskyblue3") + scale_x_discrete(limits = rev(levels(time_cost$Task)))
g2 <- ggplot(data = time_cost, aes(x = Task, y = Time_real, fill = Time_real)) + geom_bar() + coord_flip() + geom_text(aes(label = paste(round(Time_real * 100, 2), "%"), y = Time_real/2)) + scale_y_continuous(labels = percent) + scale_fill_continuous(low = "skyblue2", high = "chocolate3") + scale_x_discrete(limits = rev(levels(time_cost$Task)))
grid.arrange(g1, g2, nrow = 1)

#http://www.cerebralmastication.com/2009/08/a-fast-intro-to-plyr-for-r/
# install.packages("plyr") #run this if you don't have the package already
library(plyr)

#make some example data
dd<-data.frame(matrix(rnorm(216),72,3),c(rep("A",24),rep("B",24),rep("C",24)),c(rep("J",36),rep("K",36)))
colnames(dd) <- c("v1", "v2", "v3", "dim1", "dim2")

#ddply is the plyr function
ddply(dd, c("dim1","dim2"), function(df)mean(df$v1))
ddply(dd, c("dim1","dim2"), function(df)c(mean(df$v1),mean(df$v2),mean(df$v3),sd(df$v1),sd(df$v2),sd(df$v3)))
