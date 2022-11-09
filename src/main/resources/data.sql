delete from user where id < 5;

insert into user (id, user_name, password, is_active, roles) values
(1, 'foo', 'foo', true, 'USER'),
(2, 'bar', 'bar', true, 'USER');