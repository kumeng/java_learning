--oracle常用字符串处理函数
select lower('SFdfT'),upper('SFdfT'),ltrim('SFdfT','SF'),rtrim('SFdfT','fT')
,replace('dkhfdg','d','dd'),instr('dkhfdg','d'),substr('dkhfdg',3,2),concat('fd','fg')  from dual;
统计包含字符串 个数
select REGEXP_COUNT('1,2,6,8,7,9',',') from dual   5

---oracle常用数字函数
select abs(-34) 
,mod(10,3) --取余数
,round(100.665,2) --四舍五入
,round(100.665)
,trunc(100.665,2) --截断
,trunc(100.665)
from dual;
--转换函数

select to_char(sysdate,'yyyy-mm-dd hh24:MI:ss'),to_char(2343.345,'99999.9'),to_number('243.45')
,to_date('2018-03-23 10:03:55','yyyy-mm-dd hh24:MI:ss')
 from  dual;

--Oracle  常用日期函数
select add_months(to_date('2018-03-23','yyyy-mm-dd'),2)
, add_months(to_date('2018-03-23','yyyy-mm-dd'),-2)
,round(to_date('2018-03-23 10:03:55','yyyy-mm-dd hh24:MI:ss'))
,round(to_date('2018-03-23 21:03:55','yyyy-mm-dd hh24:MI:ss'))
,trunc(to_date('2018-03-23 10:03:55','yyyy-mm-dd hh24:MI:ss'))
,trunc(to_date('2018-03-23 21:03:55','yyyy-mm-dd hh24:MI:ss'))
from dual;

select last_day(sysdate) from dual;

select sysdate,extract(YEAR from sysdate),extract(MONTH from sysdate),extract(DAY from sysdate)
 from dual;
 
select months_between(to_date('2018-04-23 09:40:10','yyyy-mm-dd hh24:MI:ss'), add_months(to_date('2018-03-23','yyyy-mm-dd'),3)) from dual;

select trunc(sysdate) from  dual;
select trunc(sysdate)+(interval '1' second) from  dual;
select trunc(sysdate)+(interval '1' minute) from  dual;
select trunc(sysdate)+(interval '1' hour) from  dual;
select trunc(sysdate)+(interval '1' DAY) from  dual;
select trunc(sysdate)+(interval '1' MONTH) from  dual;
select trunc(sysdate)+(interval '1' YEAR) from  dual;

-- 聚合函数 
max min  count    sum avg 
--字符串处理函数
	--竖向拼接字符列
select listagg（a.code,','） within group (order by a.code) from tams_caas.company a 
--其他函数
nvl(exp1,exp2) 若exp为null  返回exp2
nvl2(exp1,exp2,exp3) 若exp为null  返回exp2 否则返回 exp3
decode(value,if1,then1,if2,then2,..,else) 对value编码 若 value = if1 返回 then1 依次类推到n  .都不匹配则返回else
