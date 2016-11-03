insert into user(id,email,first_name,last_name, admin, password) values (0,'peter@example.com','Peter','X', true, 'password');
insert into user(id,email,first_name,last_name, admin, password) values (1,'andrew@example.com','Andrew','Y', false, 'password');

insert into message(id,created,to_id,from_id,summary,priority,text) values (100,'2014-07-10 10:00:00',1,0,'Hello Andrew',0,'This message is from Peter');
insert into message(id,created,to_id,from_id,summary,priority,text) values (101,'2014-07-10 14:00:00',1,0,'How are you Andrew?',0,'This message is from Peter');
insert into message(id,created,to_id,from_id,summary,priority,text) values (102,'2014-07-11 22:00:00',1,0,'Is this secure?',0,'This message is from Peter');

insert into message(id,created,to_id,from_id,summary,priority,text) values (110,'2014-07-12 10:00:00',0,1,'Hello Peter',0,'This message is from Andrew');
insert into message(id,created,to_id,from_id,summary,priority,text) values (111,'2014-07-12 10:00:00',0,1,'Greetings Peter',0,'This message is from Andrew');
insert into message(id,created,to_id,from_id,summary,priority,text) values (112,'2014-07-12 10:00:00',0,1,'Is this secure?',0,'This message is from Andrew');
