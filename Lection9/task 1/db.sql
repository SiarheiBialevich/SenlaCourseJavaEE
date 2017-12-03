CREATE SCHEMA IF NOT EXISTS lection_9
  DEFAULT CHARACTER SET utf8;
USE lection_9;

CREATE TABLE IF NOT EXISTS lection_9.product (
  maker VARCHAR(10) NOT NULL,
  model VARCHAR(50) NOT NULL PRIMARY KEY,
  type  VARCHAR(50) NOT NULL
)
  ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS lection_9.pc (
  code  INT         NOT NULL PRIMARY KEY,
  model VARCHAR(50) NOT NULL,
  speed SMALLINT    NOT NULL,
  ram   SMALLINT    NOT NULL,
  hd    REAL        NOT NULL,
  cd    VARCHAR(10),
  price DECIMAL,
  FOREIGN KEY (model) REFERENCES product (model)
)
  ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS lection_9.laptop (
  code   INT         NOT NULL PRIMARY KEY,
  model  VARCHAR(50) NOT NULL,
  speed  SMALLINT    NOT NULL,
  ram    SMALLINT    NOT NULL,
  hd     REAL        NOT NULL,
  price  DECIMAL,
  screen TINYINT     NOT NULL,
  FOREIGN KEY (model) REFERENCES product (model)
)
  ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS lection_9.printer (
  code  INT         NOT NULL PRIMARY KEY,
  model VARCHAR(50) NOT NULL,
  color CHAR(1)     NOT NULL,
  type  VARCHAR(10) NOT NULL,
  price DECIMAL,
  FOREIGN KEY (model) REFERENCES product (model)
)
  ENGINE InnoDB;