CREATE TABLE IF NOT EXISTS Question (
  id identity,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  task VARCHAR(255) NOT NULL,
  answers VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));