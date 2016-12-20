
--Table: users
CREATE TABLE users (
  id       SERIAL PRIMARY KEY ,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);


--Table: roles
CREATE TABLE roles (
  id   SERIAL PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
);

--Table for mapping user and roles : user_roles
CREATE TABLE user_roles(
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (user_id,role_id)
);


--Insert
INSERT INTO users(username,password) VALUES ('testtesttest', '"$2a$11$qmWcVLvRFqoEwazbw83FHuT9f1W9vtoVsDcBX9jxRX7PN.desyNZG"');

INSERT INTO roles(name) VALUES ('ROLE_USER');
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);