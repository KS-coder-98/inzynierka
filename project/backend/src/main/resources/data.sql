INSERT INTO conference_rooms_booking.conference_room (capacity, description, name)
VALUES (22, 'przytulna', 'A1'),
       (50, 'ciemna', 'A2'),
       (30, 'przechodnia', 'A3'),
       (40, 'luksusowa', 'A4'),
       (20, 'główna', 'A5'),
       (150, 'bardzo duża', 'A6'),
       (200, 'największa', 'A7');

INSERT INTO conference_rooms_booking.equipment (description, name, conference_room_id)
VALUES ('i5 8GB ramu', 'komputer stacjonarny', 1),
       ('70 calowy', 'rzutnik', 1),
       ('na kredę', 'tablica', 1),
       ('i7 18GB ramu', 'komputer stacjonarny', 2),
       ('100 calowy', 'rzutnik', 2),
       ('szara', 'tablica', 2),
       ('i5 8GB ramu', 'komputer stacjonarny', 3),
       ('na kredę', 'tablica', 3),
       ('i3 3GB ramu', 'komputer stacjonarny', 4),
       ('70 calowy', 'rzutnik', 4),
       ('na kredę', 'tablica', 4),
       ('i9 32GB ramu', 'komputer stacjonarny', 5),
       ('170 calowy', 'rzutnik', 5),
       ('na kredę', 'tablica', 5),
       ('i5 8GB ramu', 'komputer stacjonarny', 7),
       ('70 calowy', 'rzutnik', 7),
       ('na kredę', 'tablica', 7);

INSERT INTO conference_rooms_booking.user_contact (city, house_number, phone_area_code, phone_number, post_code,
                                                   street, street_number)
VALUES ('Lódź', 2, '+48', '506304507', '05-120', 'Wysoka', 2),
       ('Warszawa', 12, '+48', '506304507', '05-120', 'Nowa', 12),
       ('Poznań', 10, '+48', '506304507', '05-120', 'Karetowa', 22),
       ('Lódź', 11, '+48', '506304507', '05-120', 'Wysoka', 32),
       ('Warszawa', 13, '+48', '506304507', '05-120', 'Wąska', 42),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 42),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Karetowa', 21),
       ('Lódź', 15, '+48', '506304507', '05-120', 'Wysoka', 23),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 24),
       ('Warszawa', 12, '+48', '506304507', '05-120', 'Karetowa', 25),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 27),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Karetowa', 22),
       ('Lódź', 15, '+48', '506304507', '05-120', 'Wysoka', 23),
       ('Warszawa', 13, '+48', '506304507', '05-120', 'Wąska', 42),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Wąska', 23);

INSERT INTO conference_rooms_booking.user_details (date_of_birth, type_of_members)
VALUES ('2021-10-29', 'USER'),
       ('2000-11-20', 'USER'),
       ('1998-11-12', 'USER'),
       ('2001-03-13', 'USER'),
       ('2002-03-15', 'USER'),
       ('2002-04-17', 'USER'),
       ('2003-10-18', 'USER'),
       ('1983-03-20', 'USER'),
       ('1992-10-22', 'USER'),
       ('1990-11-23', 'USER'),
       ('1995-12-16', 'USER'),
       ('1998-12-17', 'ADMIN');



INSERT INTO conference_rooms_booking.user (email, first_name, last_name, nick, user_contact_id, user_details_id)
VALUES ('mail1@wp.pl', 'Piotr', 'Nowak', 'pnowy', 1, 1),
       ('mail2@wp.pl', 'Marek', 'Kowalski', 'pnowy', 2, 2),
       ('mail3@wp.pl', 'Alina', 'Rutkowski', 'pnowy', 3, 3),
       ('mail4@wp.pl', 'Katarzyna', 'Pęciak', 'pnowy', 4, 4),
       ('mail5@wp.pl', 'Wiesław', 'Mencel', 'pnowy', 5, 5),
       ('mail6@wp.pl', 'Norbert', 'Ruda', 'pnowy', 6, 6),
       ('mail7@wp.pl', 'Bartłomiej', 'Wilk', 'pnowy', 7, 7),
       ('mail8@wp.pl', 'Arek', 'Nowak', 'pnowy', 8, 8),
       ('mail9@wp.pl', 'Piotr', 'Kozłowki', 'pnowy', 9, 9),
       ('mail10@wp.pl', 'Angelika', 'Nowak', 'pnowy', 10, 10),
       ('user1@conferenceroombooking.onmicrosoft.com', 'Marek', 'Supeł', 'user1', 14, 11),
       ('JanKowalski@conferenceroombooking.onmicrosoft.com', 'Jan', 'Kowalski', 'Jan', 15, 12);


INSERT INTO conference_rooms_booking.reservation (id, end_time, name, start_time, conference_room_id, organiser_id)
VALUES (1, '2021-11-23 12:15:00', 'Konferencja o kwiatach', '2021-11-23 12:10:00', 1, 1),
       (2, '2021-11-23 16:25:00', 'AI -czy to jest przyszłość?', '2021-11-23 11:00:00', 2, 2),
       (3, '2021-11-24 15:00:00', 'Innowacje w przemyśle', '2021-11-24 11:00:00', 2, 3),
       (4, '2021-11-26 14:00:00', 'Hybryda, czy to się opłaca', '2021-11-26 18:00:00', 1, 5),
       (5, '2021-11-23 11:10:00', 'Uprawy ekologiczne', '2021-11-23 14:00:00', 3, 7),
       (6, '2021-11-25 11:00:00', 'Wstęp do javy 13', '2021-11-25 15:00:00', 5, 4),
       (7, '2021-11-23 19:15:00', 'Konferencja o kwiatach', '2021-11-23 17:10:00', 1, 11);