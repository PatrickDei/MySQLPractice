DELETE FROM Question;

INSERT INTO Question (id, title, description, task, answers) VALUES (1,'Question 1', 'Select every column from table Question', 'SELECT __ FROM __', '*, Question');
INSERT INTO Question (id, title, description, task, answers) VALUES (2,'Question 2', 'Select every column', 'SELECT __ FROM __', '*, Question');
INSERT INTO Question (id, title, description, task, answers) VALUES (3,'Question 3', 'Select every column', 'SELECT __ FROM __', '*, Question');


INSERT INTO User (id, username, password, first_name, last_name) VALUES (1, 'user', '$2a$10$E0Q/oijh4HPf55KXRI6X1.QK8Q5ivvNXFWEkLUqjzGO.Nt3eSaFzu', 'Patrick', 'Deisinger');
INSERT INTO User (id, username, password, first_name, last_name) VALUES (2, 'admin', '$2a$12$XOsVBKD3dPukGGwKBIJq0eLhuBVgkGYVAdlo/Zevd9SxNWPRUZErq', 'Administrator', 'Admin');
INSERT INTO User (id, username, password, first_name, last_name) VALUES (3, 'creator', '$2a$12$us1tT/VUkb1gCcRQbQNOOeBbnvBk9xJtHHEF0te4ygI1VZ1YffvgO', 'Creator', 'Creator');

INSERT INTO Authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO Authority (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO Authority (id, name) VALUES (3, 'ROLE_CREATOR');

INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (1, 2);
INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (2, 1);
INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (3, 3);

INSERT INTO User_Question (User_Id, Question_Id) VALUES (2, 1);