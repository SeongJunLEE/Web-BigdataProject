#
output_total_1<-read.csv("output_total_1.csv",header = F,na.strings=c("NA", ""))
output_total_2<-read.csv("output_total_2.csv",header = F,na.strings=c("NA", ""))
#
output_total_final<-rbind(output_total_1,output_total_2)
#
write.csv(output_total_final,"C:/Users/eunsol/Desktop/preprocessing/output_total_final.csv")
###파일불러오기
output_total_final<-read.csv("output_total_final.csv",header = F,na.strings=c("NA", ""))
exchange<-read.csv("exchange.csv",header = F,na.strings=c("NA", ""))
#칼럼이름
names(output_total_final)<-c("serial","title","year","duration","genres","budget","director_name","actor_1_name","actor_2_name","actor_3_name","actor_1_starmeter","actor_2_starmeter","actor_3_starmeter","actor_1_likes","actor_2_likes","actor_3_likes","director_likes","ratings","ratingCounts","movie_likes","writer_likes")
names(exchange)<-c("country","describe","rate")

#\n -> 공백
budget$budget<-gsub("\n","",budget$budget)
#(estimated) -> 공백
budget$budget<-gsub("estimated","",budget$budget)
budget$budget<-gsub("[[:punct:]]$","",budget$budget)
budget$budget<-gsub("[[:punct:]]$","",budget$budget)
#혻 -> 공백
budget$budget<-gsub("혻","",budget$budget)
#첫번째? -> $
budget$budget<-gsub("^[[:punct:]]","$",budget$budget)
#짙 -> GBP
budget$budget<-gsub("짙","GBP",budget$budget)
#메모장에서... ? -> 공백 , $K -> 공백 , 띄어쓰기 삭제 
write.csv(budget,"C:/Users/eunsol/Desktop/preprocessing/budget_00.csv",row.names=FALSE)
####
budget<-read.csv("budget_00.csv",header = F,na.strings=c("NA", ""))
names(budget)<-c("serial","budget")
#
install.packages("stringr")
library(stringr)
budgets_ex <- data.frame(col1=c("001","002","003"), col2=c("ARS1.2K","BDT11","USD1.3MM"))
budget_ex <- budgets_ex[1,2]#[row,column]
###--------------------------------------------------------------------
#budget<-as.character(budget)
budget <- na.omit(budget)
budgets_exchanged <- data.frame(matrix(nrow=nrow(budget), ncol=2))

for(n in 1:nrow(budget)){
budget_ex <- budget[n,2]
  
    country_ex <- str_extract(budget_ex,"[A-Z][A-Z][A-Z]")
    
    budget_ex<-gsub(country_ex, "", budget_ex)
    
    K_ex <- str_extract(budget_ex,"K$")
    MM_ex <- str_extract(budget_ex,"MM$")
    
      if (is.na(K_ex)){
  
      }else if (K_ex == "K"){
        budget_ex<-gsub(K_ex, "", budget_ex)
        aaaa <- as.character(budget_ex)
        num_ex <- as.numeric(aaaa)
        result <- num_ex*1000
      }else{
        
      }
      
      if (is.na(MM_ex)){
   
      }else if (MM_ex == "MM"){
        budget_ex<-gsub(MM_ex, "", budget_ex)
        aaaa <- as.character(budget_ex)
        num_ex <- as.numeric(aaaa)
        result <- num_ex*1000000
      }else{
        
      }
    
    rate_row <- exchange[exchange$country==country_ex,]
    rate <- as.numeric(as.character(rate_row[1,3]))
    
    result <- result*rate
    serial <- as.character(budget[n,1])
    print(serial)
    print(result)
    
    budgets_exchanged[n,1] <- serial
    budgets_exchanged[n,2] <- result

}

write.csv(budgets_exchanged,"C:/Users/eunsol/Desktop/preprocessing/budget_01.csv",row.names=FALSE)

###--------------------------------------------------------------------

#sql
install.packages("sqldf")
library(sqldf)
budget1 <- sqldf("select serial,budget from output_total_final where serial='tt2994440'")

budget<-sqldf("select serial,budget from output_total_final")
#


