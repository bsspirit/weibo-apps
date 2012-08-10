# http://www.wentrue.net/blog/?p=86
# R程序调试–DEBUG R
# 1、browser(): 在脚本文件适当的位置插入browser()，重新载入模块，运行，程序会在该行中断。命令：n: step; c: continue; where: print the call back; q: quit; enter: last command；
# 2、traceback(): 运行最后的出错信息；
# 3、定义一个全局变量捕捉中间数据信息，比如一个全局变量a，可以在函数内a<<-***来给全局变量赋值；
# 4、设定options(warn=1)，即时提示warning信息，不设置则警告信息会在程序执行完毕之后才会输出；
# 5、try() 和tryCatch()是两个很好的处理error的函数；
# 6、warning()输出一个警告信息，stop()函数终止程序运行并退出，geterrmessage()得到最后一次出错信息。

# for(i in 1:10){
#   browser()
#   print(i/0)
# }
#traceback()

debug(mean.default)
mean(1:10)

# lm(y ~ x)
# traceback()