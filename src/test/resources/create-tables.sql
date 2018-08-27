DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id          INT          NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255) NOT NULL,
  age         INT          NOT NULL,
  email       varchar(255) NOT NULL
);