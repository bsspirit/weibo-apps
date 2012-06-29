#粉丝增长曲线
#uid<-1999250817
#path<-paste("image/increase/",uid,".png",sep="")

library(ggplot2)
sql<-paste("SELECT date,count,type FROM t_user_increase t ", 
        "where t.uid=", uid , "order by date asc")

source("util/db.R")

query<-rbind(c(20120601,0,'fans'),c(20120601,0,'friends'),c(20120601,0,'status'),query)
p<-ggplot(query, aes(x=date,y=count))
p<-p+geom_line(aes(group=type,colour=type))+geom_point(alpha=0.8,size=2,colour='red')
#p<-p+geom_text(aes(label=count),colour="red",size=4,data=query)
p<-p+ylab("数量") + xlab("记录日期")
p<-p+scale_colour_manual("统计变量",values=c('fans'='orange','friends'='green','status'='blue'),labels=c('粉丝数','关注数','微博数'))
p<-p+opts(title="我的微博增长",legend.title=theme_text(size=20, face="bold"),legend.text=theme_text(size=16))
p<-p+opts(axis.title.x=theme_text(size=16),axis.title.y=theme_text(size=16))
p<-p+opts(plot.title = theme_text(size=20, lineheight=30, face="bold"))
ggsave(path, width=8, height=10, dpi=70)
