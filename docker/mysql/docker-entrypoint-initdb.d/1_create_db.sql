CREATE DATABASE IF NOT EXISTS pokemon;

CREATE TABLE IF NOT EXISTS user(
  id int(11) auto_increment,
  name VARCHAR(128) NOT NULL,
  password VARCHAR(256) NOT NULL,
  email VARCHAR(256) NOT NULL,
  admin_flag BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (id),
  UNIQUE KEY (email)
);

CREATE TABLE IF NOT EXISTS trainer(
    id int(11) PRIMARY KEY auto_increment,
    user_id int(11),
    trainer_name varchar(255) NOT NULL,
    winning_count int(11) DEFAULT 0,
    losing_count int(11) DEFAULT 0,
    battle_flg tinyint(1) NOT NULL DEFAULT false,
    FOREIGN KEY(user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS pocket_pk(
    id int(11) PRIMARY KEY auto_increment,
    trainer_id int(11),
    position int (11),
    pk_id int(11),
    UNIQUE (trainer_id, position),
    FOREIGN KEY(trainer_id) REFERENCES trainer(id)
);

CREATE TABLE IF NOT EXISTS history(
    id int(11) PRIMARY KEY auto_increment,
    win_trainer_id int(11),
    lose_trainer_id int(11),
    FOREIGN KEY(win_trainer_id) REFERENCES trainer(id),
    FOREIGN KEY(lose_trainer_id) REFERENCES trainer(id)
);