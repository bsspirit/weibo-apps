#互粉社交网络图
uid<-1999250817
#path<-paste("image/face/",uid,".png",sep="")

sql<-paste("select r.uid a,r.fansid b",
           "from t_user_relate r",
           "where r.uid=",uid," or r.fansid=",uid,
           "order by r.uid asc")

#            select uid,screen_name from t_user 
#            where uid in(1999250817);
source("util/db.R")

library(igraph)
d<-query
# data<-read.csv(file="social.csv",header=FALSE)
# d<-data[order(data$V1),]
g<-graph.data.frame(d,directed=FALSE)
#V(g)$name <- c("A","B","C","D","E","F")
V(g)$label <- V(g)$name
g2<-simplify(g)
plot(g2,vertex.size=1, vertex.label=NA,edge.color=grey(0.5))
