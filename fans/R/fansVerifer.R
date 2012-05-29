#饼图，我的有效粉丝V认证比例
library(RMySQL) 
#uid=1999250817
#path="../R/image/v/" #"/home/conan/app/weibo-apps/fans/R/"  

sql<-paste("SELECT count(u.verified) as count,u.verified",
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "group by verified")

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

total<-sum(query$count)
t<-which(query$verified=="t")
f<-which(query$verified=="f")

query$verified[t]<-paste("V认证",round(query$count[t]/total*100,digits=1),"%")
query$verified[f]<-paste("未认证",round(query$count[f]/total*100,digits=1),"%")

png(file=path)
pie(query$count,labels=query$verified,clockwise=TRUE,radius=1,border="white",col=c('blue','red'),main="我的有效粉丝V认证比例")
dev.off()
