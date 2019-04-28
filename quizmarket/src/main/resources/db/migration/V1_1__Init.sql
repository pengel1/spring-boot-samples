DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(80) NOT NULL,
  name varchar(80) NOT NULL,
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