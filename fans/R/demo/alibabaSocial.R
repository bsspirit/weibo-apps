#http://cos.name/2011/04/exploring-renren-social-network/
library(igraph)

data<-read.csv(file="alibabaSocial.csv",header=FALSE)
data[,2]<-as.character(data[,2])
data[,4]<-as.character(data[,4])
p<-data.frame(id=data[,4],name=data[,3])
g<-graph.data.frame(data,directed=FALSE,vertices=p)

