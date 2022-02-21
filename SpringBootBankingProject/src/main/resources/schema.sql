DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS users;

create table customer(
cust_id bigint auto_increment primary key,
dob date,
name varchar(100) not null);

create table account(
account_no bigint auto_increment primary key,
doa date,
balance double,
account_type text,
cust_id bigint,
foreign key (cust_id) references customer(cust_id)); 

create table users(
username varchar(100) primary key,
password text,
active bit,
roles text);





