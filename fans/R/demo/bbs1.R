#对bbs的文章质量进行分析
library(ggplot2)
bbs<-read.csv("bbs.csv",header=TRUE)

#计算时间差
diffdays<-function(dates) as.numeric(difftime(Sys.Date(),as.Date(dates)),units="days")
#时间差标准化
normaldays<-function(dates) {
  dates[which(dates>0 & dates<=5)]=2
  dates[which(dates>5)]=3
  dates[which(dates==0)]=1
  dates
}
#求总分并排序
score<-function(data){
  score<-(data$reply*3+data$view)*data$dates
  result<-cbind(data,score)
  result[order(-result$score),]
}
dates<-normaldays(diffdays(bbs$create))
bbs2<-cbind(bbs,dates)
result<-score(bbs2)
head(result)

#帖子质量出图
p<-ggplot(result,aes(x=view,y=reply,fill=create,colour=create))
p<-p+geom_point(size=4,alpha=0.5)
p<-p+geom_text(aes(y=reply+3,label=substr(title,0,10)),data=head(result),size=4)
p<-p+ylab("回复量") + xlab("浏览量")
p
#ggsave('bss1.png', width=8, height=10, dpi=70)
