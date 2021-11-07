INSERT INTO conference_rooms_booking.conference_room (capacity, description, name)
VALUES (22, 'przytulna', 'A1'),
       (50, 'ciemna', 'A2'),
       (30, 'przechodnia', 'A3'),
       (40, 'luksusowa', 'A4'),
       (20, 'glowan', 'A5'),
       (150, 'bardzo duża', 'A6'),
       (200, 'najwieksza', 'A7');

INSERT INTO conference_rooms_booking.equipment (description, name, conference_room_id)
VALUES ('i5 8GB ramu', 'komputer stacjonarny', 1),
       ('70 calowy', 'żutnik', 1),
       ('na krede', 'tablica', 1),
       ('i7 18GB ramu', 'komputer stacjonarny', 2),
       ('100 calowy', 'żutnik', 2),
       ('szara', 'tablica', 2),
       ('i5 8GB ramu', 'komputer stacjonarny', 3),
       ('na krede', 'tablica', 3),
       ('i3 3GB ramu', 'komputer stacjonarny', 4),
       ('70 calowy', 'żutnik', 4),
       ('na krede', 'tablica', 4),
       ('i9 32GB ramu', 'komputer stacjonarny', 5),
       ('170 calowy', 'żutnik', 5),
       ('na krede', 'tablica', 5),
       ('i5 8GB ramu', 'komputer stacjonarny', 7),
       ('70 calowy', 'żutnik', 7),
       ('na krede', 'tablica', 7);

INSERT INTO conference_rooms_booking.user_contact (city, house_number, phone_area_code, phone_number, post_code,
                                                   street, street_number)
VALUES ('Lódź', 2, '+48', '506304507', '05-120', 'Wysoka', 2),
       ('Warszawa', 12, '+48', '506304507', '05-120', 'Nowa', 12),
       ('Poznań', 10, '+48', '506304507', '05-120', 'Karetowa', 22),
       ('Lódź', 11, '+48', '506304507', '05-120', 'Wysoka', 32),
       ('Warszawa', 13, '+48', '506304507', '05-120', 'Waska', 42),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 42),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Karetowa', 21),
       ('Lódź', 15, '+48', '506304507', '05-120', 'Wysoka', 23),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 24),
       ('Warszawa', 12, '+48', '506304507', '05-120', 'Karetowa', 25),
       ('Poznań', 12, '+48', '506304507', '05-120', 'Wysoka', 27),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Karetowa', 22),
       ('Lódź', 12, '+48', '506304507', '05-120', 'Waska', 23);

INSERT INTO conference_rooms_booking.user_details (date_of_birth, type_of_members)
VALUES ('2021-10-29', 'normal'),
       ('2000-11-20', 'normal'),
       ('1998-11-12', 'normal'),
       ('2001-03-13', 'normal'),
       ('2002-03-15', 'normal'),
       ('2002-04-17', 'normal'),
       ('2003-10-18', 'normal'),
       ('1983-03-20', 'normal'),
       ('1992-10-22', 'normal'),
       ('1990-11-23', 'normal');

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
       ('mail10@wp.pl', 'Angelika', 'Nowak', 'pnowy', 10, 10);