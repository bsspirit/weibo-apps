#MySQL connection
library(RMySQL)

# conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="radmin", password="rfans")
# query <- dbGetQuery(conn, sql)
# dbDisconnect(conn)


query<-function(sql){
  conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="radmin", password="rfans")
  query <- dbGetQuery(conn, sql)
  dbDisconnect(conn)
  query
}