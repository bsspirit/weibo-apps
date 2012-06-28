library(ggplot2)

uid<-1999250817
sql<-paste("SELECT u.screen_name,u.followers_count,u.gender, u.province",
           "FROM t_user u, t_user_relate r",
           "where r.uid=",uid," and u.uid=r.fansid",
           "order by followers_count asc")

source("util/db.R")

#len<-c(0,200,500,2000,10000,1000000,10000000)
#hist<-table(cut(query$followers_count,br=len))
#data<-as.data.frame(hist)

max<-query$followers_count[length(query$followers_count)]
depth_dist <- ggplot(query, aes(followers_count*100/max+1)) #+ xlim(58, 68)
depth_dist + geom_histogram(aes(fill=gender), binwidth=10, position="fill")

depth_dist <- ggplot(diamonds, aes(depth)) + xlim(58, 68)
depth_dist + geom_histogram(aes(fill = cut), binwidth = 0.1,position = "fill")