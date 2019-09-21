CREATE TABLE user(
    id int(11) PRIMARY KEY auto_increment,
    user_name varchar(255) NOT NULL,
    winning_count int(11) DEFAULT 0,
    losing_count int(11) DEFAULT 0,
    battle_flg tinyint(1) NOT NULL DEFAULT false
);

CREATE TABLE pocket_pk(
    id int(11) PRIMARY KEY auto_increment,
    user_id int(11),
    position int (11),
    pk_id int(11),
    UNIQUE (user_id, position),
    FOREIGN KEY(user_id) REFERENCES user(id)
);

CREATE TABLE history(
    id int(11) PRIMARY KEY auto_increment,
    win_user_id int(11),
    lose_user_id int(11),
    FOREIGN KEY(win_user_id) REFERENCES user(id),
    FOREIGN KEY(lose_user_id) REFERENCES user(id)
);