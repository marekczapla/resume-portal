delete from user where id < 5;

insert into user (id, user_name, password, is_active, roles) values
(1, 'foo', 'foo', true, 'USER'),
(2, 'bar', 'bar', true, 'USER');

delete from user_profile where id < 5;

insert into user_profile
(id, user_name, chosen_theme, summary, first_name, last_name, email, phone, designation) values
(1, 'foo', 1, 'User name foo', 'Rinkydink', 'Rivendell', 'r.rivendell@gmail.com', '500600700','Junior Backend Developer' ),
(2, 'bar', 2, 'User name bar', 'Bombadil', 'Crumplesack', 'b.crumplesack@gmail.com', '600700800', 'DevOps');

