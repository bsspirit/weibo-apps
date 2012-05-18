#饼图，我的有效粉丝性别比例
rm(list=ls())

library(RMySQL) 

uid=1999250817
sql<-paste("SELECT count(u.gender) as count,u.gender", 
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "group by u.gender")

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

total<-sum(query$count)
f<-which(query$gender=="f")
m<-which(query$gender=="m")

query$gender[f]<-paste("女",round(query$count[f]/total*100,digits=1),"%")
query$gender[m]<-paste("男",round(query$count[m]/total*100,digits=1),"%")

png(file=paste("image/gender/",uid,".png",sep=""))
pie(query$count,labels=query$gender,clockwise=TRUE,radius=1,border="white",col=c('blue','red'),main="我的有效粉丝性别比例")
dev.off()
