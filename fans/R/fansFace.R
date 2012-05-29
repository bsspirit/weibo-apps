#星图，我的粉丝属性脸谱

library(RMySQL)
library(aplpack)

#uid<-1999250817
#path<-paste("image/face/",uid,".png",sep="")

sql<-paste("SELECT u.screen_name,u.followers_count,u.friends_count,u.statuses_count,u.followers_count+u.friends_count+u.statuses_count as total",
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "order by total desc",
           "limit 16")
print(sql)
conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

png(file=path)
faces(query[,2:5],labels=as.character(query$screen_name), main="粉丝的笑脸")
dev.off();