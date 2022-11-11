delete from user where id < 5;

insert into user (id, user_name, password, is_active, roles) values
(1, 'rivendell', '1234', true, 'USER'),
(2, 'crumplesack', 'pass', true, 'USER');

delete from user_profile where id < 5;

insert into user_profile
(id, user_name, chosen_theme, summary, first_name, last_name, email, phone, designation) values
(1, 'Rivendell', '1', 'Rinkydink Rivendell - Junior Backend Developer with 1 year of experience', 'Rinkydink', 'Rivendell', 'r.rivendell@gmail.com', '500600700','Junior Backend Developer' ),
(2, 'Crumplesack', '2', 'Bombadil Crumplesack - DevOps with 2 years of experience', 'Bombadil', 'Crumplesack', 'b.crumplesack@gmail.com', '600700800', 'DevOps');

