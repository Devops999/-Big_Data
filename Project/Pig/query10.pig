data = LOAD '/user/hive/warehouse/h1b_final' Using PigStorage() as (s_no:int,case_status:chararray,employer_name:chararray,soc_name:chararray,job_title:chararray,full_time_positioon:chararray,prevailing_wage:int,year:chararray,worksite:chararray,longitute:double,latitute:double);


--jobtitles = FOREACH data GENERATE year,job_title,case_status,worksite;
--dump jobtitles;

--filtering = filter data by $0>1;

--query = filter jobtitles by year == '2016';

a = group data by $7;
--dump a;
limits = limit a 8;
dump limits;

