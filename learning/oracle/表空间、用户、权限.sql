/*��1�����������ݱ�ռ�    D:\oracledbf�ļ��б������ */

create tablespace user2  

logging  

datafile 'C:\app\Administrator\oradata\orcl\user2_data.dbf'

size 50m  

autoextend on  

next 50m maxsize 20480m  

extent management local;  


/*��2����������ʱ��ռ�  */

create temporary tablespace user2_temp  

tempfile 'C:\app\Administrator\oradata\orcl\user2_temp.dbf'

size 50m  

autoextend on  

next 50m maxsize 20480m  

extent management local; 


/*��3���������û���ָ����ռ�  */

create user username2 identified by pwd456  
/* ָ��Ĭ�����ݱ�ռ� */
default tablespace user2  
/* ָ��Ĭ����ʱ��ռ� */
temporary tablespace user2_temp  
;

�޸��û���ռ�
alter   user username2  default tablespace USERS;




/*��4�������û�����Ȩ��  
DBA: ӵ��ȫ����Ȩ����ϵͳ���Ȩ�ޣ�ֻ��DBA�ſ��Դ������ݿ�ṹ��
RESOURCE:ӵ��ResourceȨ�޵��û�ֻ���Դ���ʵ�壬�����Դ������ݿ�ṹ��
CONNECT:ӵ��ConnectȨ�޵��û�ֻ���Ե�¼Oracle�������Դ���ʵ�壬�����Դ������ݿ�ṹ��
������ͨ�û�������connect, resourceȨ�ޡ�
����DBA�����û�������connect��resource, dbaȨ�ޡ�
*/

grant connect,resource to username2;
grant dba to username2;


/*ɾ���û�������*/

drop user zcbase cascade;
/*ɾ����ռ�*/
DROP TABLESPACE ZCBASE_TBS  INCLUDING CONTENTS AND DATAFILES;

--DROP temporary  TABLESPACE ZCBASE_TBS_temp   INCLUDING CONTENTS AND DATAFILES;
DROP   TABLESPACE ZCBASE_TBS_temp   INCLUDING CONTENTS AND DATAFILES;
commit;






/*�鿴��ռ����ʱ��ռ�ʹ�����*/

select *

  from (Select a.tablespace_name as user_data,

               to_char(a.bytes / 1024 / 1024, '999,999') "��ռ���(M)",

               to_char(b.bytes / 1024 / 1024, '999,999.99') "���пռ�(M)",

               to_char(a.bytes / 1024 / 1024 - b.bytes / 1024 / 1024,

                       '999,999.99') "��ʹ�ÿռ�(M)",

               to_char((1 - b.bytes / a.bytes) * 100, '99.99') || '%' "ʹ�ñ�"

          from (select tablespace_name, sum(bytes) bytes

                  from dba_data_files

                 group by tablespace_name) a,

               (select tablespace_name, sum(bytes) bytes

                  from dba_free_space

                 group by tablespace_name) b

         where a.tablespace_name = b.tablespace_name

        union all

        select c.tablespace_name as user_data,

               to_char(c.bytes / 1024 / 1024, '999,999') total_bytes,

               to_char((c.bytes - d.bytes_used) / 1024 / 1024, '999,999.99') free_bytes,

               to_char(d.bytes_used / 1024 / 1024, '999,999.99') use_bytes,

               to_char(d.bytes_used * 100 / c.bytes, '99.99') || '%' use

          from (select tablespace_name, sum(bytes) bytes

                  from dba_temp_files

                 group by tablespace_name) c,

               (select tablespace_name, sum(bytes_cached) bytes_used

                  from v$temp_extent_pool

                 group by tablespace_name) d

         where c.tablespace_name = d.tablespace_name)

 order by user_data
;
/*�鿴�û���Ϣ����ռ���Ϣ*/
select * from dba_users;
select * from dba_tablespaces;


/* ���������ļ����������Զ���չ*/

alter tablespace ZCBASE_TBS add datafile 'c:\oracledbf\ZCBASE_TBS_data.dbf' size 1024m autoextend on next 50m maxsize 200m;
alter tablespace ZCBASE_TBS add datafile 'C:\app\Administrator\oradata\orcl\user2_data.dbf' size 1024m autoextend on next 50m maxsize 200m;
 'C:\app\Administrator\oradata\orcl\user2_temp.dbf'
2/* ���������ļ���������Ϊ������չ*/

alter tablespace ZCBASE_TBS add datafile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\DPP_DATE02.DBF' size 1024m autoextend on next 50m maxsize  unlimited;



/*���·��������ļ���С*/

alter database datafile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\SYSAUX01.DBF' resize 500m;
2/*���·�����ʱ��ռ������ļ���С*/

alter database tempfile  'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\TEMP01.DBF' resize 500M;


