#http://f.dataguru.cn/thread-14884-1-1.html
data<-read.csv("lajichong.csv",header=FALSE)
names(data)<-c("name","email","class")

#rule1:邮箱大小写混合
#rule2:邮箱纯数字
#rule3:邮箱与名字重叠率

#================================================
#分解email
cut_email<-function(email){
  df<-as.character(email)
  len<-length(data[,1])
  for(i in 1:len){
    df[i]<-strsplit(as.character(email),"@")[[i]][1]
  }
  df
}

#0非英文,1大写或者小写,2大小写混合
rule1<-function(email){
  df<-as.character(email)
  len<-length(data[,1])
  for(i in 1:len){
    df[i]<-length(grep("[A-Z]",str))+length(grep("[a-z]",str))
  }
  df
}

#1是纯数字,0不是纯数字
rule2<-function(str){
  len<-length(grep("^[0-9]*$",str))
  len
}
#================================================


#word <- c('sxmrFmwq@xxx.xxx')
#str<-cut_email(word)

data2<-cbind(data,email2=cut_email(data$email))
data2<-cbind(data2,rule1=rule1(data2$email2))





