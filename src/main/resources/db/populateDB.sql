DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM votes;
DELETE FROM restaurants;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '{noop}admpassword'),
       ('User1', 'user1@gmail.com', '{noop}password'),
       ('User2', 'user2@gmail.com', '{noop}password'),
       ('User3', 'user3@gmail.com', '{noop}password'),
       ('User4', 'user4@gmail.com', '{noop}password'),
       ('User5', 'user5@gmail.com', '{noop}password'),
       ('User6', 'user6@gmail.com', '{noop}password'),
       ('User7', 'user7@gmail.com', '{noop}password'),
       ('User8', 'user8@gmail.com', '{noop}password'),
       ('User9', 'user9@gmail.com', '{noop}password'),
       ('User10', 'user10@gmail.com', '{noop}password');

INSERT INTO user_roles (role, user_id)
VALUES ('ADMIN', 100000),
       ('USER', 100001),
       ('USER', 100002),
       ('USER', 100003),
       ('USER', 100004),
       ('USER', 100005),
       ('USER', 100006),
       ('USER', 100007),
       ('USER', 100008),
       ('USER', 100009),
       ('USER', 100010);

INSERT INTO restaurants (name)
VALUES ('Итальянский ресторан'),
       ('Суши бар'),
       ('Китайский ресторан');

INSERT INTO dishes (name, price, date, restaurant)
VALUES ('Паста', 890, '2020-07-05', 100011),
        ('Спагетти', 486, '2020-07-03', 100011),
        ('Пицца', 562, '2020-07-04', 100011),
        ('Лазанья', 740, '2020-07-03', 100011),
        ('Роллы калифорния', 430, '2020-07-05', 100012),
        ('Суши с тунцом', 490, '2020-07-05', 100012),
        ('Сашими', 640, '2020-07-07', 100012),
        ('Сяке', 620, '2020-07-05', 100012),
        ('Лапша', 730, '2020-07-05', 100013),
        ('Утра по пекински', 1500, '2020-07-04', 100013),
        ('Димсамы', 350, '2020-07-04', 100013),
        ('Китайский суп', 520, '2020-07-05', 100013);

INSERT INTO votes (restaurant, user, date_time)
VALUES (100011, 100001, '2020-07-03 10:00:00'),
       (100012, 100003, '2020-07-05 10:30:00'),
       (100013, 100002, '2020-07-04 10:25:00'),
       (100012, 100006, '2020-07-05 12:20:00'),
       (100011, 100005, '2020-07-03 12:45:00'),
       (100012, 100004, '2020-07-05 13:17:00'),
       (100012, 100010, '2020-07-05 14:10:00'),
       (100013, 100007, '2020-07-04 13:20:00'),
       (100012, 100008, '2020-07-04 14:30:00'),
       (100013, 100003, '2020-07-04 13:27:00');
