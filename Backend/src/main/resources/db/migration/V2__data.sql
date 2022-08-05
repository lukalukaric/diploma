
-- DRZAVA

INSERT INTO drzava (ime)
VALUES ('Slovenija');

INSERT INTO drzava (ime)
VALUES ('Avstrija');

INSERT INTO drzava (ime)
VALUES ('Nemčija');

-- POSTA

INSERT INTO posta (ime, postnaStevilka, TK_drzava)
VALUES ('Maribor', 2000, 1);

INSERT INTO posta (ime, postnaStevilka, TK_drzava)
VALUES ('Ljubljana', 1000, 1);

INSERT INTO posta (ime, postnaStevilka, TK_drzava)
VALUES ('Celje', 3000, 1);

INSERT INTO posta (ime, postnaStevilka, TK_drzava)
VALUES ('Salzburg', 5020, 2);

INSERT INTO posta (ime, postnaStevilka, TK_drzava)
VALUES ('Berlin', 10115, 3);

-- NASLOV

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Poštna ulica', '123', 1);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Koroška cesta', '12', 1);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Čopova ulica', '26', 2);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Miklošičeva ulica', '31', 3);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Monchsberg', '34', 4);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Franz. Str.', '65', 5);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Ljubljanska', '24', 1);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Monchsberg', '123', 4);

INSERT INTO naslov (ulica, hisnaStevilka, TK_posta)
VALUES ('Franz. Str.', '12', 5);

-- STUDENT

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Luka', 'Novak','031123456','luka.novak@gmail.com', 1);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Matej', 'Horvat','040333222', 'matejhorvat1@email.com', 2);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Maja', 'Kovač','041232454', 'majak123@gmail.com', 3);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Nina', 'Kos','051234123', 'kosnina@hotmail.com', 4);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Tobias', 'Gruber','+431234567890', 'tobiasgruber@gmail.com', 5);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Otto', 'Schumacher','+4930901820.', 'otto.s@gmail.com', 6);

INSERT INTO student (ime, priimek, telefonskaStevilka, email, TK_naslov)
VALUES ('Špela', 'Novak','031323455','spelanovak@gmail.com', 1);

-- ORGANIZATOR

INSERT INTO organizator (ime, TK_naslov)
VALUES ('Tečaji d.o.o', 7);

INSERT INTO organizator (ime, TK_naslov)
VALUES ('Course Salzburg d.d.', 8);

INSERT INTO organizator (ime, TK_naslov)
VALUES ('Course DE', 9);

-- TECAJ

INSERT INTO tecaj (ime, cena, lokacija)
VALUES ('Programiranje za začetnike', 100.00, 'FERI Maribor');

INSERT INTO tecaj (ime, cena, lokacija)
VALUES ('Napredno Programiranje', 250.00, 'Univerza v Mariboru');

INSERT INTO tecaj (ime, cena, lokacija)
VALUES ('Podatkovne baze', 100.00, 'Univerzitetna Knjižnica Maribor');

INSERT INTO tecaj (ime, cena, lokacija)
VALUES ('Programiranje mikrokrmilnikov', 300.00, 'TPC City');

-- TECAJ ORGANIZATOR

INSERT INTO tecajOrganizator (TK_tecaj, TK_organizator)
VALUES (1, 1);

INSERT INTO tecajOrganizator (TK_tecaj, TK_organizator)
VALUES (2, 1);

INSERT INTO tecajOrganizator (TK_tecaj, TK_organizator)
VALUES (3, 2);

INSERT INTO tecajOrganizator (TK_tecaj, TK_organizator)
VALUES (4, 3);

-- TECAJ STUDENT

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (1, 1);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (1, 2);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (1, 4);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (1, 5);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (2, 1);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (2, 3);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (2, 5);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (3, 6);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (3, 1);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (4, 5);

INSERT INTO tecajStudent (TK_tecaj, TK_student)
VALUES (4, 7);
