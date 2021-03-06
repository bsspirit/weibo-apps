#我的粉丝云(取排名前150位)
#http://www.dataguru.cn/article-873-1.html

library(wordcloud)
source("util/db.R")

#uid<-1999250817
#path<-paste("image/cloud/",uid,".png",sep="")

sql<-paste("select u.screen_name as screen,followers_count as fans", 
        "from t_user_relate r, t_user u",
        "where r.uid=", uid ," and u.uid=r.fansid", 
        "order by fans desc limit 150")
query<-query(sql)

png(file=path)
wordcloud(query$screen, query$fans, min.freq=1,scale=c(4,1), max.words=50, random.order=FALSE, colors=terrain.colors(50,1),main="我的粉丝云(取排名前50位)")
dev.off()
