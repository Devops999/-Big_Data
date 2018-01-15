REGISTER '/home/hduser/piggybanks.jar';
DEFINE CSVExcelStorage org.apache.pig.piggybank.storage.CSVExcelStorage;


data = LOAD '/home/hduser/mergerTest/merge.csv' Using CSVExcelStorage() as (s_no:int,case_status:chararray,soc_name:chararray,job_title:chararray,full_time_positioon:chararray,prevailing_wage:int,year:chararray,worksite:chararray,longitute:double,latitute:double);
--dump data;

noheader = filter data by $0>1;
--dump filtering;

cleansed = filter noheader by $4 matches '.*DATA ENGINEER.*' and $7 matches '2011';
a = group cleansed by $8;
step_a = foreach a generate '2011' ,group,COUNT($1);
step_b = order step_a by $2 desc;
answer_2011 = limit step_b 1;
dump answer_2011;
