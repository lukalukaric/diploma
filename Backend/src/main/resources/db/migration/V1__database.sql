CREATE TABLE IF NOT EXISTS drzava(
    id SERIAL NOT NULL PRIMARY KEY,
    ime VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS posta(
    id SERIAL NOT NULL PRIMARY KEY,
    ime VARCHAR(45) NOT NULL,
    postnaStevilka INTEGER NOT NULL,
    TK_drzava INT not null
);

CREATE TABLE IF NOT EXISTS naslov(
    id SERIAL NOT NULL PRIMARY KEY,
    ulica VARCHAR(45) NOT NULL,
    hisnaStevilka VARCHAR(45) NOT NULL,
    TK_posta INT not null
);

CREATE TABLE IF NOT EXISTS organizator(
    id SERIAL NOT NULL PRIMARY KEY,
    ime VARCHAR(45) NOT NULL,
    TK_naslov INT not null
);

CREATE TABLE IF NOT EXISTS tecajOrganizator(
    id SERIAL NOT NULL PRIMARY KEY,
    TK_tecaj INT not null,
    TK_organizator INT not null
);

CREATE TABLE IF NOT EXISTS tecaj(
    id SERIAL NOT NULL PRIMARY KEY,
    ime VARCHAR(45) NOT NULL,
    cena DECIMAL NOT NULL,
    lokacija VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS tecajStudent(
    id SERIAL NOT NULL PRIMARY KEY,
    TK_tecaj INT not null,
    TK_student INT not null
);

CREATE TABLE IF NOT EXISTS student(
    id SERIAL NOT NULL PRIMARY KEY,
    ime VARCHAR(20) NOT NULL,
    priimek VARCHAR(45) NOT NULL,
    telefonskaStevilka VARCHAR(15) NOT NULL,
    email VARCHAR(30) NOT NULL,
    TK_naslov INT not null
);

ALTER TABLE posta
ADD CONSTRAINT posta_drzava
FOREIGN KEY (TK_drzava)
REFERENCES drzava(id);

ALTER TABLE naslov
ADD CONSTRAINT naslov_posta
FOREIGN KEY (TK_posta)
REFERENCES posta(id);

ALTER TABLE organizator
ADD CONSTRAINT organizator_naslov
FOREIGN KEY (TK_naslov)
REFERENCES naslov(id);

ALTER TABLE tecajOrganizator
ADD CONSTRAINT tecaj_organizator
FOREIGN KEY (TK_tecaj)
REFERENCES tecaj(id);

ALTER TABLE tecajOrganizator
ADD CONSTRAINT organizator_tecaj
FOREIGN KEY (TK_organizator)
REFERENCES organizator(id);

ALTER TABLE tecajStudent
ADD CONSTRAINT tecaj_student
FOREIGN KEY (TK_tecaj)
REFERENCES tecaj(id);

ALTER TABLE tecajStudent
ADD CONSTRAINT student_tecaj
FOREIGN KEY (TK_student)
REFERENCES student(id);

ALTER TABLE student
ADD CONSTRAINT student_naslov
FOREIGN KEY (TK_naslov)
REFERENCES naslov(id);