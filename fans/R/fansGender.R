#饼图，我的有效粉丝性别比例

#uid=1999250817
#path<-paste(uid,'.png')
#path="../R/image/v/" #"/home/conan/app/weibo-apps/fans/R/" 

sql<-paste("SELECT count(u.gender) as count,u.gender", 
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "group by u.gender")

library(RMySQL)
conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="radmin", password="rfans")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

total<-sum(query$count)
f<-which(query$gender=="f")
m<-which(query$gender=="m")

query$gender[f]<-paste("Female\n",round(query$count[f]/total*100,digits=1),"%")
query$gender[m]<-paste("Male\n",round(query$count[m]/total*100,digits=1),"%")

main<-"My Fans's Gender Precentage"
png(file=path)
pie(query$count,labels=query$gender,clockwise=TRUE,radius=1,border="white",col=c('blue','red'),main=main)
dev.off()

