/*第1步：创建数据表空间    D:\oracledbf文件夹必须存在 */

create tablespace user2  

logging  

datafile 'C:\app\Administrator\oradata\orcl\user2_data.dbf'

size 50m  

autoextend on  

next 50m maxsize 20480m  

extent management local;  


/*第2步：创建临时表空间  */

create temporary tablespace user2_temp  

tempfile 'C:\app\Administrator\oradata\orcl\user2_temp.dbf'

size 50m  

autoextend on  

next 50m maxsize 20480m  

extent management local; 


/*第3步：创建用户并指定表空间  */

create user username2 identified by pwd456  
/* 指定默认数据表空间 */
default tablespace user2  
/* 指定默认临时表空间 */
temporary tablespace user2_temp  
;

修改用户表空间
alter   user username2  default tablespace USERS;




/*第4步：给用户授予权限  
DBA: 拥有全部特权，是系统最高权限，只有DBA才可以创建数据库结构。
RESOURCE:拥有Resource权限的用户只可以创建实体，不可以创建数据库结构。
CONNECT:拥有Connect权限的用户只可以登录Oracle，不可以创建实体，不可以创建数据库结构。
对于普通用户：授予connect, resource权限。
对于DBA管理用户：授予connect，resource, dba权限。
*/

grant connect,resource to username2;
grant dba to username2;


/*删除用户及数据*/

drop user zcbase cascade;
/*删除表空间*/
DROP TABLESPACE ZCBASE_TBS  INCLUDING CONTENTS AND DATAFILES;

--DROP temporary  TABLESPACE ZCBASE_TBS_temp   INCLUDING CONTENTS AND DATAFILES;
DROP   TABLESPACE ZCBASE_TBS_temp   INCLUDING CONTENTS AND DATAFILES;
commit;






/*查看表空间和临时表空间使用情况*/

select *

  from (Select a.tablespace_name as user_data,

               to_char(a.bytes / 1024 / 1024, '999,999') "表空间总(M)",

               to_char(b.bytes / 1024 / 1024, '999,999.99') "空闲空间(M)",

               to_char(a.bytes / 1024 / 1024 - b.bytes / 1024 / 1024,

                       '999,999.99') "已使用空间(M)",

               to_char((1 - b.bytes / a.bytes) * 100, '99.99') || '%' "使用比"

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
/*查看用户信息，表空间信息*/
select * from dba_users;
select * from dba_tablespaces;


/* 增加数据文件，并设置自动扩展*/

alter tablespace ZCBASE_TBS add datafile 'c:\oracledbf\ZCBASE_TBS_data.dbf' size 1024m autoextend on next 50m maxsize 200m;
alter tablespace ZCBASE_TBS add datafile 'C:\app\Administrator\oradata\orcl\user2_data.dbf' size 1024m autoextend on next 50m maxsize 200m;
 'C:\app\Administrator\oradata\orcl\user2_temp.dbf'
2/* 增加数据文件，并设置为无限扩展*/

alter tablespace ZCBASE_TBS add datafile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\DPP_DATE02.DBF' size 1024m autoextend on next 50m maxsize  unlimited;



/*重新分配数据文件大小*/

alter database datafile 'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\SYSAUX01.DBF' resize 500m;
2/*重新分配临时表空间数据文件大小*/

alter database tempfile  'D:\ORACLE\PRODUCT\10.2.0\ORADATA\ORCL\TEMP01.DBF' resize 500M;


