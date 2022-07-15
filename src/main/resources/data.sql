INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_USER');

insert into products(category,name,photo_urls,price,quantity,status) values ('Ropa','Iron Man','https://m.media-amazon.com/images/I/71PcOY-v3UL._AC_UX679_.jpg','9.00','100',1);
insert into products(category,name,photo_urls,price,quantity,status) values ('Ropa','Superman','https://m.media-amazon.com/images/I/71X5x-fceuL._AC_UX679_.jpg','8.00','100',1);
insert into products(category,name,photo_urls,price,quantity,status) values ('Ropa','Hulk','https://m.media-amazon.com/images/I/61kq1vC0SWL._AC_UX679_.jpg','11.00','100',1);

insert into users(email,first_name,last_name,password,phone,user_status,username) values ('admin@todo1.com','Pepito','Perez','admin','0987654321',1,'admin');
insert into users(email,first_name,last_name,password,phone,user_status,username) values ('user@todo1.com','Juanito','Peralta','user','0987654321',1,'user');

insert into user_roles(user_id,role_id) values (1,1);
insert into user_roles(user_id,role_id) values (2,2);
