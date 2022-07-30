
-- STATE

INSERT INTO state (name)
VALUES ('Slovenija');

INSERT INTO state (name)
VALUES ('Avstrija');

INSERT INTO state (name)
VALUES ('Nemčija');

-- MAIL

INSERT INTO mail (name, postcode, FK_state)
VALUES ('Maribor', 2000, 1);

INSERT INTO mail (name, postcode, FK_state)
VALUES ('Ljubljana', 1000, 1);

INSERT INTO mail (name, postcode, FK_state)
VALUES ('Celje', 3000, 1);

INSERT INTO mail (name, postcode, FK_state)
VALUES ('Salzburg', 5020, 2);

INSERT INTO mail (name, postcode, FK_state)
VALUES ('Berlin', 10115, 3);

-- ADDRESS

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Poštna ulica', '123', 1);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Koroška cesta', '12', 1);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Čopova ulica', '26', 2);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Miklošičeva ulica', '31', 3);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Monchsberg', '34', 4);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Franz. Str.', '65', 5);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Ljubljanska', '24', 1);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Monchsberg', '123', 4);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('Franz. Str.', '12', 5);

-- STUDENT

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Luka', 'Novak','031123456','luka.novak@gmail.com', 1);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Matej', 'Horvat','040333222', 'matejhorvat1@email.com', 2);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Maja', 'Kovač','041232454', 'majak123@gmail.com', 3);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Nina', 'Kos','051234123', 'kosnina@hotmail.com', 4);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Tobias', 'Gruber','+431234567890', 'tobiasgruber@gmail.com', 5);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Otto', 'Schumacher','+4930901820.', 'otto.s@gmail.com', 6);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('Špela', 'Novak','031323455','spelanovak@gmail.com', 1);

-- ORGANIZER

INSERT INTO organizer (name, FK_address)
VALUES ('Tečaji d.o.o', 7);

INSERT INTO organizer (name, FK_address)
VALUES ('Course Salzburg d.d.', 8);

INSERT INTO organizer (name, FK_address)
VALUES ('Course DE', 9);

-- COURSE

INSERT INTO course (name, price, place)
VALUES ('Programiranje za začetnike', 100.00, 'FERI Maribor');

INSERT INTO course (name, price, place)
VALUES ('Napredno Programiranje', 250.00, 'Univerza v Mariboru');

INSERT INTO course (name, price, place)
VALUES ('Podatkovne baze', 100.00, 'Univerzitetna Knjižnica Maribor');

INSERT INTO course (name, price, place)
VALUES ('Programiranje mikrokrmilnikov', 300.00, 'TPC City');

-- COURSE ORGANIZER

INSERT INTO courseorganizer (FK_course, FK_organizer)
VALUES (1, 1);

INSERT INTO courseorganizer (FK_course, FK_organizer)
VALUES (2, 1);

INSERT INTO courseorganizer (FK_course, FK_organizer)
VALUES (3, 2);

INSERT INTO courseorganizer (FK_course, FK_organizer)
VALUES (4, 3);

-- COURSE STUDENT

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (1, 1);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (1, 2);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (1, 4);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (1, 5);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (2, 1);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (2, 3);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (2, 5);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (3, 6);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (3, 1);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (4, 5);

INSERT INTO coursestudent (FK_course, FK_student)
VALUES (4, 7);
