INSERT INTO pokemon.user (id, name, password, email, admin_flag)
VALUES (1, 'かどぅー', '{bcrypt}$2a$10$yb4.of5g.WSnYzTcvlJKYenC8HXYcLwo74Y4MdEMyk8lwunjoZbna',
        'test@gmail.com', 0);

INSERT INTO pokemon.trainer (id, user_id, trainer_name, winning_count, losing_count, battle_flg)
VALUES (1, 1, '鈴木けんぞう', 0, 0, 0);
INSERT INTO pokemon.trainer (id, user_id, trainer_name, winning_count, losing_count, battle_flg)
VALUES (2, 1, '疾風迅雷のナイトハルト', 0, 0, 1);

INSERT INTO pokemon.pocket_pk (id, trainer_id, position, pk_id)
VALUES (1, 1, 0, 3);
INSERT INTO pokemon.pocket_pk (id, trainer_id, position, pk_id)
VALUES (2, 1, 1, 6);
INSERT INTO pokemon.pocket_pk (id, trainer_id, position, pk_id)
VALUES (3, 1, 2, 9);
INSERT INTO pokemon.pocket_pk (id, trainer_id, position, pk_id)
VALUES (4, 1, 3, 149);
INSERT INTO pokemon.pocket_pk (id, trainer_id, position, pk_id)
VALUES (5, 1, 4, 151);