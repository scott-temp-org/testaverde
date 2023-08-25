DROP TABLE users if exists
;

create table users (
  id number primary key,
  name varchar(50),
  email varchar(100),
  password varchar(50),
  admin_role char(1)
);

