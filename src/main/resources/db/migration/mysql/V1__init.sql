create table todo 
(
id integer not null auto_increment, 
description varchar(255), 
is_done boolean not null, 
target_date timestamp, 
username varchar(255), 
primary key (id)
);