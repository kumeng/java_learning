/**
 * 用户表
 */
create table basic_users
(
id number primary key,
username varchar2(50),
psncode  varchar2(50),
sex      varchar2(2),
age      number,
idcard   varchar2(30),
phone    varchar2(20)
);
/**
 * 账户表
 */
create table basic_account
(
id number primary key,
loginname varchar2(50),
pwd  varchar2(100)
);
/**
 * 用户账户关系表
 */
create table  basic_user1account
(
userid number,
accountid number
);
alter table basic_user1account
add primary key    (userid,accountid);

/**
 * 系统组件-序列表
 */
create table BASIC_SEQS
(
id number(8) primary key,
seq_name varchar2(200) not null,
seq_tablename varchar2(200),
seq_currno  number(8) not null,
seq_step    number(4) not null
);
alter table BASIC_SEQS add constraint  unique_seqname unique(seq_name);

create sequence seq_basicseqs;