library(maps)
library(mapdata)
library(maptools)

uid<-1999250817
path<-paste("image/map/",uid,".png",sep="")

sql<-paste("select u.uid,p.longitude ,p.latitude",
           "from t_user_relate r , t_provinces p, t_user u",
           "where r.uid=",uid," and u.uid=r.fansid and u.province=p.pid and u.city=p.cid")

library(RMySQL)
conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="radmin", password="rfans")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

map<-readShapePoly('data/bou2_4p.shp')
#city<-read.csv("data/city.csv", header=TRUE)

png(file=path,width=600, height=500)
par(mar=rep(0,4))
plot(map,col="white", ylim = c(18, 54),main="我的粉丝地图",width=600,height=800);
#points(city$jd, city$wd, pch = 19, cex=0.8, col='blue')

points(query$longitude,query$latitude,pch=19,cex=0.5,col='red')
points(query$longitude,query$latitude,pch=19,cex=5,col='#90a0ff0A')
#text(200, 50, "我的粉丝地图", col="blue", cex=1.2)
dev.off()