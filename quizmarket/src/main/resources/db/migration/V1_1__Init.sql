DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(80) NOT NULL,
  name varchar(80) NOT NULL,
  PRIMARY KEY (id)
)
 ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE user (
   id bigint(20) NOT NULL AUTO_INCREMENT,
   first_name varchar(80) NOT NULL,
   last_name varchar(80) NOT NULL,
   email varchar(80) NOT NULL,
   image varchar(255) NOT NULL,
   PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE quiz (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(80) NOT NULL,
    description varchar(255) NOT NULL,
    author_id bigint(20) NOT NULL AUTO_INCREMENT,
    FOREIGN KEY fk_author(author_id)
    REFERENCES user(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*   INSERTS  */
INSERT INTO catalog(name, description) VALUES('Design', 'DUH');
INSERT INTO catalog(name, description) VALUES('Programming', 'DUH');
INSERT INTO catalog(name, description) VALUES('Marketing', 'DUH');
INSERT INTO catalog(name, description) VALUES('Science', 'DUH');
INSERT INTO catalog(name, description) VALUES('Math', 'DUH');
INSERT INTO catalog(name, description) VALUES('History', 'DUH');