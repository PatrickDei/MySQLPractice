CREATE TABLE IF NOT EXISTS Question (
  id identity,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  task VARCHAR(255) NOT NULL,
  answers VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS User (
  id identity,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS Authority (
  id identity,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS User_Authority (
  User_Id INT,
  Authority_Id INT,
  FOREIGN KEY (User_Id)
       REFERENCES User (id),
  FOREIGN KEY (Authority_Id)
       REFERENCES Authority (id));