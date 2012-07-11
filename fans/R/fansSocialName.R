#粉丝社交网络图
#1)粉丝关系中 粉丝多的颜色加重 粉丝少的颜色相对较浅

library(igraph)
source("util/db.R")
source("util/map.R")

#uid<-1829368964#1999250817
#path<-paste("image/social/",uid,"_name.png",sep="")

sql<-paste(
"select u.uid as fansid,u.screen_name screen",
"from t_user u",
"where u.uid=",uid,
"union",
"select r.fansid as fansid,u.screen_name screen",
"from t_user_relate r,t_user u",
"where r.uid=",uid,"and r.fansid=u.uid",
"and u.followers_count>200 and friends_count>200 and u.statuses_count>200",
"limit 60")

q1<-query(sql)

for(i in q1[1]){
  ids<-paste(i,sep="",collapse=",")
}

sql<-paste("select uid,fansid",
"from t_user_relate",
"where fansid in (",ids,")")
q2<-query(sql)

fans<-rbind(uid,q1)
data<-q2[which(q2$uid %in% fans$fansid),]

uname<-q1$screen[which(q1$fansid==uid)]

png(file=path,width=600,height=600)
# d<-query
# # data<-read.csv(file="social.csv",header=FALSE)
# # d<-data[order(data$V1),]
g<-graph.data.frame(data,directed=FALSE)
V(g)$label <- key(q1,V(g)$name)#V(g)$label <- V(g)$name
g2<-simplify(g)
plot(g2,vertex.size=3,edge.color=grey(0.6),
     main=paste("@",uname,"的社交关系图",sep=""))
dev.off()

