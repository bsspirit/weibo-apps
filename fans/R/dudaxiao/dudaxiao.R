#分别计算概率

# #大小
# big<-0.5
# small<-0.5
# #三个一样的
# triple<-1/216
# #三个一样的任一个
# triple6<-triple*6
# #二个一样的
# double<-18/216


size<-6
n<-3
count<-size^n
node<-44

dataset<-function(size,n){
  sum<-size*n
  df<-data.frame(NA,NA,NA,NA)
  names(df)<-c('x1','x2','x3','result');
  df<-df[-1,]
  for(i in 1:size){
    for(j in 1:size){
      for(k in 1:size){
        for(s in 1:sum){
          if(i+j+k==s){
            print(paste(i,j,k,'=',s,collapse=''))
            df<-rbind(df,data.frame(x1=i,x2=j,x3=k,result=s))
          }  
        }
      }
    }
  }
  df
}

df<-dataset(size,n)
big<-sum(df$result>=11 & df$result<=17)/count
small<-sum(df$result>=4 & df$result<=10)/count

triple1<-sum(df$x1==1 & df$x2==1 & df$x3==1)/count
triple2<-sum(df$x1==2 & df$x2==2 & df$x3==2)/count
triple3<-sum(df$x1==3 & df$x2==3 & df$x3==3)/count
triple4<-sum(df$x1==4 & df$x2==4 & df$x3==4)/count
triple5<-sum(df$x1==5 & df$x2==5 & df$x3==5)/count
triple6<-sum(df$x1==6 & df$x2==6 & df$x3==6)/count
triple<-triple1+triple3+triple3+triple4+triple5+triple6

double1<-sum((df$x1==1 | df$x2==1) & (df$x1==1 | df$x3==1) & (df$x2==1 | df$x3==1))/count
double2<-sum((df$x1==2 | df$x2==2) & (df$x1==2 | df$x3==2) & (df$x2==2 | df$x3==2))/count
double3<-sum((df$x1==3 | df$x2==3) & (df$x1==3 | df$x3==3) & (df$x2==3 | df$x3==3))/count
double4<-sum((df$x1==4 | df$x2==4) & (df$x1==4 | df$x3==4) & (df$x2==4 | df$x3==4))/count
double5<-sum((df$x1==5 | df$x2==5) & (df$x1==5 | df$x3==5) & (df$x2==5 | df$x3==5))/count
double6<-sum((df$x1==6 | df$x2==6) & (df$x1==6 | df$x3==6) & (df$x2==6 | df$x3==6))/count

sum4<-sum(df$result==4)/count
sum5<-sum(df$result==5)/count
sum6<-sum(df$result==6)/count
sum7<-sum(df$result==7)/count
sum8<-sum(df$result==8)/count
sum9<-sum(df$result==9)/count
sum10<-sum(df$result==10)/count
sum11<-sum(df$result==11)/count
sum12<-sum(df$result==12)/count
sum13<-sum(df$result==13)/count
sum14<-sum(df$result==14)/count
sum15<-sum(df$result==15)/count
sum16<-sum(df$result==16)/count
sum17<-sum(df$result==17)/count

count12<-sum(df$x1==1 & (df$x2==2 | df$x3==2))*3/count
count13<-sum(df$x1==1 & (df$x2==3 | df$x3==3))*3/count
count14<-sum(df$x1==1 & (df$x2==4 | df$x3==4))*3/count
count15<-sum(df$x1==1 & (df$x2==5 | df$x3==5))*3/count
count16<-sum(df$x1==1 & (df$x2==6 | df$x3==6))*3/count
count23<-sum(df$x1==2 & (df$x2==3 | df$x3==3))*3/count
count24<-sum(df$x1==2 & (df$x2==4 | df$x3==4))*3/count
count25<-sum(df$x1==2 & (df$x2==5 | df$x3==5))*3/count
count26<-sum(df$x1==2 & (df$x2==6 | df$x3==6))*3/count
count34<-sum(df$x1==3 & (df$x2==4 | df$x3==4))*3/count
count35<-sum(df$x1==3 & (df$x2==5 | df$x3==5))*3/count
count36<-sum(df$x1==3 & (df$x2==6 | df$x3==6))*3/count
count45<-sum(df$x1==4 & (df$x2==5 | df$x3==5))*3/count
count46<-sum(df$x1==4 & (df$x2==6 | df$x3==6))*3/count
count56<-sum(df$x1==5 & (df$x2==6 | df$x3==6))*3/count


name<-c("big","small","triple1","triple2","triple3","triple4","triple5","triple6","double1","double2","double3","double4","double5","double6","triple","sum4","sum5","sum6","sum7","sum8","sum9","sum10","sum11","sum12","sum13","sum14","sum15","sum16","sum17",
        "count12","count13","count14","count15","count16","count23","count24","count25","count26","count34","count35","count36","count45","count46","count56")
rule1<-c(1,1,150,150,150,150,150,150,8,8,8,8,8,8,24,50,18,14,12,8,6,6,6,6,8,12,14,18,50,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5)
rule2<-c(1/1,1/1,1/150,1/150,1/150,1/150,1/150,1/150,1/8,1/8,1/8,1/8,1/8,1/8,1/24,1/50,1/18,1/14,1/12,1/8,1/6,1/6,1/6,1/6,1/8,1/12,1/14,1/18,1/50,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5,1/5)
prob<-c(big,small,triple1,triple2,triple3,triple4,triple5,triple6,double1,double2,double3,double4,double5,double6,triple,sum4,sum5,sum6,sum7,sum8,sum9,sum10,sum11,sum12,sum13,sum14,sum15,sum16,sum17,
        count12,count13,count14,count15,count16,count23,count24,count25,count26,count34,count35,count36,count45,count46,count56)

df2<-data.frame(name,rule1,rule2,prob,bit=df2$rule/df2$prob)
df2[order(df2$bit),]

