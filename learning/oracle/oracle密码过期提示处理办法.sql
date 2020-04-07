sqlplus
sys
as sysdba



--1-- 查看用户的proifle是哪个，一般是default：
SELECT username,PROFILE FROM dba_users;
--2--查看指定概要文件(如default)的密码有效期设置：
SELECT * FROM dba_profiles s WHERE s.profile='DEFAULT' AND resource_name='PASSWORD_LIFE_TIME';

--3--将密码有效期由默认的180天修改成“无限制”：
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;
--修改之后不需要重启动数据库，会立即生效。
--4
 --修改后，还没有被提示ORA-28002警告的帐户不会再碰到同样的提示;
 --已经被提示的帐户必须再改一次密码，举例如下：
--$sqlplus / as sysdba
alter user username identified by orcl123 --<原来的密码> ----不用换新密码

--oracle11g启动参数resource_limit无论设置为false还是true，密码有效期都是生效的，所以必须通过以上方式进行修改。以上的帐户名请根据实际使用的帐户名更改。
