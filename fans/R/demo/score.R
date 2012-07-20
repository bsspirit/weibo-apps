#排名算法
#http://www.dataguru.cn/article-1812-1.html
#http://www.dataguru.cn/article-1814-1.html
#http://www.dataguru.cn/article-1813-1.html

#一、Delicious
#单位时间内用户投票数进行排名
#它按照“过去60分钟内被收藏的次数”进行排名。每过60分钟，就统计一次。
#优点:比较简单、容易部署、内容更新相当快；
#缺点:一方面，排名变化不够平滑，前一个小时还排名靠前的内容，往往第二个小时就一落千丈，另一方面，缺乏自动淘汰旧项目的机制，某些热门内容可能会长期占据排行榜前列。


#二、Hacker News
#score=(p-1)/(T+2)^G
#P表示帖子的得票数，减去1是为了忽略发帖人的投票。
#T表示距离发帖的时间（单位为小时），加上2是为了防止最新的帖子导致分母过小（之所以选择2，可能是因为从原始文章出现在其他网站，到转贴至Hacker News，平均需要两个小时）。
#G表示”重力因子”（gravityth power），即将帖子排名往下拉的力量，默认值为1.8，后文会详细讨论这个值。

hacker.news<-function(p,T,G) (p-1)/(T+2)^G

G<-1.8
T<-c(1:24)
p<-c(29,59,199)

plot(hacker.news(29,T,1.8),ylim=c(0,10))
points(hacker.news(59,T,1.8))
points(hacker.news(199,T,1.8))