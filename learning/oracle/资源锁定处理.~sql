
select l.session_id,o.owner,o.object_name

from v$locked_object l,dba_objects o

where l.object_id=o.object_id
;
--²é¿´Ëø
select t2.username,t2.sid,t2.serial#,t2.logon_time

from v$locked_object t1,v$session t2

where t1.session_id=t2.sid order by t2.logon_time;

--ÐÞ¸ÄËø

--alter system kill session 'sid,serial#';
alter system kill session '156,54817'


156  54817 
282      26495
282   
