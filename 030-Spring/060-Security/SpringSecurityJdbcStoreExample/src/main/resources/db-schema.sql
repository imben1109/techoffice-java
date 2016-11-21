create table if not exists users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(50) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

delete from authorities;
delete from users;

insert into users values ('user', 'passsowrd', true) ;
insert into authorities values ('user', 'ADMIN') ;

commit;