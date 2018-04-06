create datatable user_db;

CREATE TABLE user (
  id int(11) primary key AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  date datetime NOT NULL
) 