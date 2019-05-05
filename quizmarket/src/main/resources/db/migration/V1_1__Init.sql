DROP TABLE IF EXISTS catalog;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS quiz;
DROP TABLE IF EXISTS user;

CREATE TABLE catalog (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(80) NOT NULL,
  description varchar(80) NOT NULL,
  PRIMARY KEY (id)
)
 ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE user (
   id bigint(20) NOT NULL AUTO_INCREMENT,
   first_name varchar(80) NOT NULL,
   last_name varchar(80) NOT NULL,
   email varchar(80) NOT NULL,
   image varchar(255) NOT NULL,
   token varchar(255) NOT NULL,
   PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE quiz (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(80) NOT NULL,
    description varchar(255) NOT NULL,
    author_id bigint(20) NOT NULL,
    FOREIGN KEY fk_author(author_id)
    REFERENCES user(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE question (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    question varchar(1000) NOT NULL,
    optionA varchar(1000) NOT NULL,
    optionB varchar(1000) NOT NULL,
    optionC varchar(1000),
    optionD varchar(1000),
    correct varchar(2) NOT NULL,
    quiz_id bigint(20) NOT NULL,
    FOREIGN KEY fk_quizid(quiz_id)
    REFERENCES quiz(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
    PRIMARY KEY (id)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*   INSERTS  */
INSERT INTO catalog(name, description) VALUES('Design', 'DUH');
INSERT INTO catalog(name, description) VALUES( 'Programming', 'DUH');
INSERT INTO catalog(name, description) VALUES('Marketing', 'DUH');
INSERT INTO catalog(name, description) VALUES('Science', 'DUH');
INSERT INTO catalog(name, description) VALUES('Math', 'DUH');
INSERT INTO catalog(name, description) VALUES('History', 'DUH');

INSERT INTO user(first_name, last_name, email, image, token) VALUES('Paul', 'Engel', 'pengel1@gmail.com',
                                                                    'http://image.com', 'token');

INSERT INTO quiz(title, description, author_id) VALUES ('Quiz 1', 'Example Quiz 1',
                                                        (SELECT id FROM user WHERE email = 'pengel1@gmail.com'));
INSERT INTO quiz(title, description, author_id) VALUES ('Quiz 2', 'Example Quiz 2',
                                                        (SELECT id FROM user WHERE email = 'pengel1@gmail.com'));

INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 1', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                        (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 2', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 3', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 4', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 5', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 6', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 7', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 8', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 9', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));
INSERT INTO question(question, optionA, optionB,
                     optionC, optionD, correct, quiz_id) VALUES ('Question 10', 'optionA', 'optionB',
                                                                 'optionC', 'optionD','A',
                                                                 (SELECT id FROM quiz WHERE title = 'Quiz 1'));