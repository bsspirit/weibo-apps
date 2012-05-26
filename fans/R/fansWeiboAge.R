#柱状图，我的粉丝微博年龄

library(RMySQL) 
#table(cut(sample(100),br=c(0,50,60,70,100)))

uid=1999250817
sql<-paste("select elt(interval(DATEDIFF(now(),u.created_at),0, 100,200,300,400,500,600,700,800,900,1000,10000), ",
        "'100','100-200','200-300','300-400','400-500','500-600','600-700','700-800','800-900','900-1000', '1000') as age,", 
        "count(DATEDIFF(now(),created_at)) as count", 
        "FROM t_user u, t_user_relate r",
        "where r.uid=1999250817 and u.uid=r.fansid", 
        "group by elt(interval(DATEDIFF(now(),u.created_at), 0, 100,200,300,400,500,600,700,800,900,1000,10000),",
        " '100','100-200','200-300','300-400','400-500','500-600','600-700','700-800','800-900','900-1000', '1000')") 

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")
query <- dbGetQuery(conn, sql)
dbDisconnect(conn)

query$age[which(query$age==100)]='小于100'
query$age[which(query$age==1000)]='大于1000'
labels=paste(query$age,"天")

png(file=path)
par(mar=c(5,8,4,2))
barplot(query$count,horiz=TRUE,xlab="粉丝数量",las=1,
        col=terrain.colors(11,1), cex.names=0.8,names.arg=labels,
        space=0.4, axisnames=TRUE, xlim=c(0,1.5*max(query$count)),main="我的粉丝微博年龄")

percent=round(query$count/sum(query$count)*100)
text(query$count+4, seq(1,22,2)*0.7+0.2, paste(percent,"%"),  col = "blue")
dev.off()

