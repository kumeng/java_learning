declare

jobno number;

begin dbms_job.submit(

����jobno,--��ʱ��ID��ϵͳ�Զ����

����'PRC_INSERT;', --whatִ�еĹ�����

���� sysdate,--next_date,��ʱ����ʼִ�е�ʱ�䣬����д��ʾ����ִ��

����'sysdate + 15/1440'--interval,���ö�ʱ��ִ�е�Ƶ�ʣ�����дÿ��15����ִ��һ��

);
commit; 
end;

--�鿴��ʱ��
select * from user_jobs;
select * from all_jobs;

--�Ƴ���ʱ����ams  �˻�����������Ҫams���Ƴ��������brs�Ƴ��ᱨ�쳣ORA-23421
begin
dbms_job.remove(45);
commit;
end;

exec dbms_job.remove(83);--ɾ��һ����ʱ��
exec dbms_job.run(84);--����һ����ʱ��
exec DBMS_JOB.BROKEN(83,SYS.DIUTIL.INT_TO_BOOL(1));--ֹͣһ����ʱ��
exec DBMS_JOB.INTERVAL(84, 'sysdate + 60/1440');--�ı�һ����ʱ����ִ��Ƶ�ʳ�ÿ��һСʱִ��һ��



 --ÿ����ִ��

Interval => TRUNC(sysdate,��mi��) + 1 / (24*60)



--ÿ����賿2��ִ��

Interval => TRUNC(sysdate) + 1 +2 / (24)



--ÿ��һ�賿2��ִ��

Interval => TRUNC(next_day(sysdate,2))+2/24 --����һ,һ�ܵĵڶ���



--ÿ��1���賿2��ִ��

Interval =>TRUNC(LAST_DAY(SYSDATE))+1+2/24



--ÿ���ȵĵ�һ���賿2��ִ��

Interval => TRUNC(ADD_MONTHS(SYSDATE,3),'Q') + 2/24


--ÿ���궨ʱִ��

--���磺ÿ��7��1�պ�1��1���賿2��

Interval => ADD_MONTHS(trunc(sysdate,'yyyy'),6)+2/24

-- ÿ�궨ʱִ��

--ÿ��1��1���賿2��ִ��

Interval =>ADD_MONTHS(trunc(sysdate,'yyyy'),12)+2/24
