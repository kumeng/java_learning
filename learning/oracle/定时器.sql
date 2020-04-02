declare

jobno number;

begin dbms_job.submit(

　　jobno,--定时器ID，系统自动获得

　　'PRC_INSERT;', --what执行的过程名

　　 sysdate,--next_date,定时器开始执行的时间，这样写表示立即执行

　　'sysdate + 15/1440'--interval,设置定时器执行的频率，这样写每隔15分钟执行一次

);
commit; 
end;

--查看定时器
select * from user_jobs;
select * from all_jobs;

--移除定时器，ams  账户创建，就需要ams来移除，，如果brs移除会报异常ORA-23421
begin
dbms_job.remove(45);
commit;
end;

exec dbms_job.remove(83);--删除一个定时器
exec dbms_job.run(84);--运行一个定时器
exec DBMS_JOB.BROKEN(83,SYS.DIUTIL.INT_TO_BOOL(1));--停止一个定时器
exec DBMS_JOB.INTERVAL(84, 'sysdate + 60/1440');--改变一个定时器的执行频率成每隔一小时执行一次



 --每分钟执行

Interval => TRUNC(sysdate,’mi’) + 1 / (24*60)



--每天的凌晨2点执行

Interval => TRUNC(sysdate) + 1 +2 / (24)



--每周一凌晨2点执行

Interval => TRUNC(next_day(sysdate,2))+2/24 --星期一,一周的第二天



--每月1日凌晨2点执行

Interval =>TRUNC(LAST_DAY(SYSDATE))+1+2/24



--每季度的第一天凌晨2点执行

Interval => TRUNC(ADD_MONTHS(SYSDATE,3),'Q') + 2/24


--每半年定时执行

--例如：每年7月1日和1月1日凌晨2点

Interval => ADD_MONTHS(trunc(sysdate,'yyyy'),6)+2/24

-- 每年定时执行

--每年1月1日凌晨2点执行

Interval =>ADD_MONTHS(trunc(sysdate,'yyyy'),12)+2/24
