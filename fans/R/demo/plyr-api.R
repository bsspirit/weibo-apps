# one<-ozone[1,1,]
# month<-ordered(rep(1:12,length=72))
# model<-rlm(one~month-1)
# deseas<-resid(model)
# deseasf<-function(value) rlm(value~month-1)
# models<-aaply(ozone,1:2,deseasf)
# deseas<-aaply(models,1:2,resid)

# e.g.1
# for loops
models<-as.list(rep(NA,24*24))
dim(models)<-c(24*24)
deseas <- array(NA, c(24, 24, 72)) 
dimnames(deseas) <- dimnames(ozone) 

for (i in seq_len(24)) {
  for(j in seq_len(24)) {
    mod <- deseasf(ozone[i, j, ])
    models[[i, j]] <- mod
    deseas[i, j, ] <- resid(mod)
  }
}

#apply functions
models <- apply(ozone, 1:2, deseasf)
resids_list <- lapply(models, resid)
resids <- unlist(resids_list)
dim(resids) <- c(72, 24, 24)
deseas <- aperm(resids, c(2, 3, 1))
dimnames(deseas) <- dimnames(ozone)

