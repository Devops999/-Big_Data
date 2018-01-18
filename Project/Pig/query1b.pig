--REGISTER '/home/hduser/piggybanks.jar';
--DEFINE CSVExcelStorage org.apache.pig.piggybank.storage.CSVExcelStorage;
--data = LOAD '/user/hive/warehouse/h1b_final' Using CSVExcelStorage()as

data = LOAD '/user/hive/warehouse/h1b_final' Using PigStorage() as (s_no:int,case_status:chararray,employer_name:chararray,soc_name:chararray,job_title:chararray,full_time_positioon:chararray,prevailing_wage:int,year:chararray,worksite:chararray,longitute:double,latitute:double);


jobtitles = FOREACH data GENERATE year,job_title,case_status,worksite;
--dump jobtitles;

--filtering = filter data by $0>1;

query = filter jobtitles by year == '2016';

a = group query by $1;
--dump a;
--limits = limit a 8;
--dump limits;

--limits = limit a 8;
--dump limits;

counting = foreach a generate group, COUNT($1);

--limits = limit a 8;
--dump limits;


--dump counting;



year2 = filter jobtitles by year == '2015';
a = group year2 by $1;
count2 = foreach a generate group, COUNT($1);
--dump count2;



year3 = filter jobtitles by year == '2014';
a = group year3 by $1;
count3 = foreach a generate group,COUNT($1);
--dump count3;


year4 = filter jobtitles by  year == '2013';
a =  group year4 by $1;
count4 = foreach a generate group,COUNT($1);


year5 = filter jobtitles by year =='2012';
a = group year5 by $1;
count5 = foreach a generate group,COUNT($1);

year6 = filter jobtitles by year == '2011';
a = group year6 by $1;
count6 = foreach a generate group,COUNT($1);

joined = join counting by $0,count2 by $0,count3 by $0,count4 by $0,count5 by $0,count6 by $0;
--dump joined;


growth = foreach joined generate $0,(float)($1-$3)*100/$3,
(float)($3-$5)*100/$5,
(float)($5-$7)*100/$7,
(float)($7-$9)*100/$9,
(float)($9-$11)*100/$11;

averagegrowth = foreach growth generate $0,($1+$2+$3+$4+$5)/5;


desce = order averagegrowth by $1 desc;

answer = limit desce 5;
dump answer;
--dump growth;







