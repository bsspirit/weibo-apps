#粉丝增长曲线

#uid<-2816038140#1999250817
#path<-paste("image/increase/",uid,".png",sep="")

## path1<-paste("image/increase/fans-",uid,".png",sep="")
## path2<-paste("image/increase/friends-",uid,".png",sep="")
## path3<-paste("image/increase/status-",uid,".png",sep="")

sql<-paste("SELECT date,count,type FROM t_user_increase t ", 
        "where t.uid=", uid , "order by date asc")

library(RMySQL)
conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="radmin", password="rfans")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

label <- function(counts){
    label<-counts
    label[which(counts>=1000000)]<-paste(round(counts[which(counts>=1000000)]/1000000),'m',sep="")
    label[which(counts>=1000 & counts<1000000)]<-paste(round(counts[which(counts>=1000 & counts<1000000)]/1000),'k',sep="")
    label
}

png(file=path,height=800)
par(mfrow=c(3,1),cex=1)
fans<-query[which(query['type']=='fans'),c(1,2)]
fans<-rbind(c(20120601,0),fans)
plot(fans,type="b",lwd=1,xlab="记录日期",ylab="粉丝数量",col="red",xlim=c(20120601,10+max(fans[["date"]])),ylim=c(0,1.5*max(fans[["count"]])),main="粉丝数增长")
text(fans[["date"]], fans[["count"]]-max(fans[["count"]])/7, label(fans[["count"]]),  col = "blue")

friends<-query[which(query['type']=='friends'),c(1,2)]
friends<-rbind(c(20120601,0),friends)
plot(friends,type="b",lwd=1,xlab="记录日期",ylab="关注数量",col="orange",xlim=c(20120601,10+max(friends[["date"]])),ylim=c(0,1.5*max(friends[["count"]])),main="关注数增长")
text(friends[["date"]], friends[["count"]]-max(friends[["count"]])/7, label(friends[["count"]]),  col = "black")

status<-query[which(query['type']=='status'),c(1,2)]
status<-rbind(c(20120601,0),status)
plot(status,type="b",lwd=1,xlab="记录日期",ylab="发微博数量",col="blue",xlim=c(20120601,10+max(status[["date"]])),ylim=c(0,1.5*max(status[["count"]])),main="发微博数增长")
text(status[["date"]], status[["count"]]-max(status[["count"]])/7, label(status[["count"]]),  col = "red")
dev.off()

