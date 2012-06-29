library(ggplot2)

uid<-1999250817
sql<-paste("SELECT u.screen_name,u.followers_count,u.friends_count,u.statuses_count,u.followers_count/u.friends_count as bt,u.gender, u.province",
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "order by followers_count asc")
source("util/db.R")

#len<-c(0,200,500,2000,10000,1000000,10000000)
#hist<-table(cut(query$followers_count,br=len))
#data<-as.data.frame(hist)

# len<-c(0,200,500,2000,10000,50000)
# hist<-table(cut(query$statuses_count,br=len))

max<-query$followers_count[length(query$followers_count)]
depth_dist <- ggplot(query, aes(bt)) + xlim(0, 3)
depth_dist + geom_histogram(aes(fill=gender), binwidth=0.05, position="fill")

depth_dist <- ggplot(diamonds, aes(depth)) + xlim(58, 68)
depth_dist + geom_histogram(aes(fill = cut), binwidth = 0.1,position = "fill")