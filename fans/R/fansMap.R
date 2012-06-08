library(maps)
library(mapdata)
library(maptools)

#uid<-1999250817
#path<-paste("image/map/",uid,".png",sep="")

sql<-paste("select u.uid,p.longitude ,p.latitude,p.pid,(select p2.name from t_provinces p2 where p2.pid=p.pid and p2.cid=1000) as pname",
           "from t_user_relate r , t_provinces p, t_user u",
           "where r.uid=",uid," and p.pid!=400 and u.uid=r.fansid and u.province=p.pid and u.city=p.cid")

source("util/db.R")

png(file=path,width=600,height=1000)
par(mfrow=c(2,1),cex=0.8,mar=rep(4,4))

#画中国地图
map<-readShapePoly('data/bou2_4p.shp')
#city<-read.csv("data/city.csv", header=TRUE)

plot(map,col="#EAEAEA", ylim = c(18, 54),,main="我的粉丝分布图");
#points(city$jd, city$wd, pch = 19, cex=0.8, col='blue')

mtext("我的粉丝地图",side=3,col="black",cex=2)
points(query$longitude,query$latitude,pch=19,cex=0.5,col='red')
points(query$longitude,query$latitude,pch=19,cex=5,col='#90a0ff0A')


#画饼图
library(plotrix)
pnamet<-table(factor(query$pname))
percent<-round(pnamet/length(query$pid)*100)
label <- paste(names(percent), percent, "%", sep="")
pie(percent,labels=label,clockwise=TRUE,radius=1,col=rainbow(20))
#pie3D(percent,labels=label,radius=1,explode=0.5,main="我的粉丝分布图")
dev.off()