data = load '/niit/merge.csv'  USING PigStorage() as 
(s_no:int,
case_status:chararray,
employer_name:chararray,
soc_name:chararray,
job_title:chararray,
full_time_position:chararray,
prevailing_wage:int,
year:chararray,
worksite:chararray,
longitute:double,
latitute:double);

--limits = limit data  5;
--dump limits;

groups = group data by $7;
total = foreach groups generate group,COUNT(data.$1);

--limits = limit total  5;
--dump limits;
group2 = group data by ($7,$1);
countyears = foreach group2 generate group,group.$0,COUNT($1);

--limits = limit countyears  5;
--dump limits;

joined = join countyears by $1,total by $0;

ans = foreach joined generate FLATTEN($0),(float)($2*100)/$4,$2;
dump ans;


--limits = limit joined  5;
--dump limits;


