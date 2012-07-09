#粉丝雷达图
#uid<-1999250817
#path<-paste("image/rado/",uid,".png",sep="")
source("util/db.R")

normal<-function(data){
    k<-c(0,10,100,500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,15000,20000,25000,30000,35000,40000,
            45000,50000,55000,60000,65000,70000,75000,80000,85000,90000,95000,100000,120000,140000,160000,
            180000,200000,250000,300000,350000,400000,450000,500000,550000,600000,650000,700000,750000,800000,
            850000,900000,950000,1000000,1100000,1200000,1300000,1400000,1500000,1600000,1700000,1800000,1900000,
            2000000,3000000,3500000,4000000,4500000,5000000,5500000,6000000,6500000,7000000,7500000,8000000,8500000,
            9000000,9500000,10000000,11000000,12000000,13000000,14000000,15000000,16000000,17000000,18000000,19000000)
    d<-data
    for(i in 2:length(k)){
        d[which(data>=k[i-1] & data<k[i])]<-i
    };d
}

sql<-paste("SELECT u1.screen_name,u1.followers_count,u1.friends_count,u1.statuses_count,u1.followers_count+u1.friends_count as total",
        "FROM t_user u1",
        "where u1.uid=",uid,
        "union",
        "SELECT u.screen_name,u.followers_count,u.friends_count,u.statuses_count,u.followers_count+u.friends_count as total",
        "FROM t_user u, t_user_relate r",
        "where r.uid=",uid," and u.uid=r.fansid",
        #"order by followers_count desc",
        "limit 16")
query<-query(sql)

png(file=path)
par(mar=c(0,2,4,2))
palette(rainbow(5, s = 0.6, v = 0.75))
df<-data.frame(query$screen_name,normal(query$followers_count),normal(query$friends_count),normal(query$statuses_count))
stars(df[,2:4],full=TRUE,len=0.9, key.loc=c(1.5, 0),nrow=6,ncol=4,
        draw.segments=TRUE,radius=TRUE, col.stars=1:10,#axes=TRUE,
        labels=as.character(df[,1]),ylim=c(3.8,14),main="粉丝雷达")
legend(3, 5,horiz=TRUE,legend=c("粉丝数","关注数","微博数"),cex=0.9,lwd=1,pch=19,col=c(1:10), border=FALSE)
dev.off();
