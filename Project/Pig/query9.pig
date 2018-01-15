data = load '/niit/merge.csv' using PigStorage() as (s_no:int,
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

--limits = limit data 5;
--dump limits;

groups = group data by $2;
total = foreach groups generate group, COUNT(data.$1);


certified = filter data by $1 == 'CERTIFIED';
groups = group certified by $2;
counting = foreach groups generate group,COUNT(certified.$1);

certWithdrawn = filter data by $1 == 'CERTIFIED-WITHDRAWN';
groups = group certWithdrawn by $2;
counts = foreach groups generate group,COUNT(certWithdrawn.$1);

joined = join counts by $0,counting by $0,total by $0;

generates = foreach joined generate $0,$1,$3,$5;

--limits = limit generates 5;
--dump limits;

sucess = foreach generates generate $0,(float)($1+$2)/($3),$3;
outputs = filter sucess by $1>70 and $2>1000;
final = order outputs by $1 DESC;
dump final;


