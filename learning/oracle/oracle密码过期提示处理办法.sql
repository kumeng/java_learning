sqlplus
sys
as sysdba



--1-- �鿴�û���proifle���ĸ���һ����default��
SELECT username,PROFILE FROM dba_users;
--2--�鿴ָ����Ҫ�ļ�(��default)��������Ч�����ã�
SELECT * FROM dba_profiles s WHERE s.profile='DEFAULT' AND resource_name='PASSWORD_LIFE_TIME';

--3--��������Ч����Ĭ�ϵ�180���޸ĳɡ������ơ���
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;
--�޸�֮����Ҫ���������ݿ⣬��������Ч��
--4
 --�޸ĺ󣬻�û�б���ʾORA-28002������ʻ�����������ͬ������ʾ;
 --�Ѿ�����ʾ���ʻ������ٸ�һ�����룬�������£�
--$sqlplus / as sysdba
alter user username identified by orcl123 --<ԭ��������> ----���û�������

--oracle11g��������resource_limit��������Ϊfalse����true��������Ч�ڶ�����Ч�ģ����Ա���ͨ�����Ϸ�ʽ�����޸ġ����ϵ��ʻ��������ʵ��ʹ�õ��ʻ������ġ�
