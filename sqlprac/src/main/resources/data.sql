DELETE FROM Question;

INSERT INTO Question (id, title, description, task, answers) VALUES (1,'Question 1', 'Select every column from table Question', 'SELECT __ FROM __', '*, Question');
INSERT INTO Question (id, title, description, task, answers) VALUES (2,'Question 2', 'Select every column', 'SELECT __ FROM __', '*, Question');
INSERT INTO Question (id, title, description, task, answers) VALUES (3,'Question 3', 'Select every column', 'SELECT __ FROM __', '*, Question');


INSERT INTO User (id, username, password, first_name, last_name) VALUES (1, 'user', '$2y$12$s5aIBe/DZYHAs/TxGNQPU.wCg6osGK0L4cGmIC.1zvEFg9A/HSb8i', 'Patrick', 'Deisinger');
INSERT INTO User (id, username, password, first_name, last_name) VALUES (2, 'admin', '$2y$12$WWCm2WJSeKl/x01SvhR6MO94M50YkCrm.WAjP5AymC4dXh2fvKlwe', 'Administrator', 'Admin');
INSERT INTO User (id, username, password, first_name, last_name) VALUES (3, 'creator', '$2y$12$Rzc74rOMKsENRYwZOY9lZ.JW1OQPKnCCz4xBX1Gg4XYbtymvhlja6', 'Creator', 'Creator');

INSERT INTO Authority (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO Authority (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO Authority (id, name) VALUES (3, 'ROLE_CREATOR');

INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (1, 2);
INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (2, 1);
INSERT INTO User_Authority (User_Id, Authority_Id) VALUES (3, 3);

INSERT INTO User_Question (User_Id, Question_Id) VALUES (2, 1);