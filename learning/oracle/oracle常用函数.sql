--oracle�����ַ���������
select lower('SFdfT'),upper('SFdfT'),ltrim('SFdfT','SF'),rtrim('SFdfT','fT')
,replace('dkhfdg','d','dd'),instr('dkhfdg','d'),substr('dkhfdg',3,2),concat('fd','fg')  from dual;
ͳ�ư����ַ��� ����
select REGEXP_COUNT('1,2,6,8,7,9',',') from dual   5

---oracle�������ֺ���
select abs(-34) 
,mod(10,3) --ȡ����
,round(100.665,2) --��������
,round(100.665)
,trunc(100.665,2) --�ض�
,trunc(100.665)
from dual;
--ת������

select to_char(sysdate,'yyyy-mm-dd hh24:MI:ss'),to_char(2343.345,'99999.9'),to_number('243.45')
,to_date('2018-03-23 10:03:55','yyyy-mm-dd hh24:MI:ss')
 from  dual;

--Oracle  �������ں���
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

-- �ۺϺ��� 
max min  count    sum avg 
--�ַ���������
	--����ƴ���ַ���
select listagg��a.code,','�� within group (order by a.code) from tams_caas.company a 
--��������
nvl(exp1,exp2) ��expΪnull  ����exp2
nvl2(exp1,exp2,exp3) ��expΪnull  ����exp2 ���򷵻� exp3
decode(value,if1,then1,if2,then2,..,else) ��value���� �� value = if1 ���� then1 �������Ƶ�n  .����ƥ���򷵻�else
