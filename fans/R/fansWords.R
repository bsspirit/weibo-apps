#粉丝名称云:(粉丝的名称,粉丝的粉丝数)
#http://www.dataguru.cn/article-873-1.html
rm(list=ls())

library(wordcloud)
library(RMySQL)

uid=2587998071
sql=paste("select u.screen_name as screen,followers_count as fans", 
        "from t_user_relate r, t_user u",
        "where r.uid=", uid ," and u.uid=r.fansid", 
        "order by fans desc limit 50")

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query = dbGetQuery(conn, sql)
dbDisconnect(conn)
png(file=paste("image/cloud/",uid,".png",sep=""))
wordcloud(query$screen, query$fans, min.freq=1,scale=c(4,1), max.words=50, random.order=FALSE, colors=terrain.colors(50,1))
dev.off()

