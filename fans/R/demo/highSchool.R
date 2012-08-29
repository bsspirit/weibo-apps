#高考志愿分析
library(arules)
data<-read.transactions("hightSchool.csv",format="basket");
inspect(data)

freq=eclat(data,parameter=list(support=0.01))
summary(freq)

rules=apriori(data,parameter=list(support=0.01,confidence=0.2))
inspect(rules)
summary(rules)

