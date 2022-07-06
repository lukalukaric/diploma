CREATE TABLE IF NOT EXISTS state(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS mail(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    postalcode INTEGER NOT NULL,
    FK_state INT not null
);

CREATE TABLE IF NOT EXISTS address(
    id SERIAL NOT NULL PRIMARY KEY,
    street VARCHAR(45) NOT NULL,
    houseNumber VARCHAR(45) NOT NULL,
    FK_mail INT not null
);

CREATE TABLE IF NOT EXISTS organizer(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    FK_address INT not null
);

CREATE TABLE IF NOT EXISTS courseOrganizer(
    id SERIAL NOT NULL PRIMARY KEY,
    FK_course INT not null,
    FK_organizer INT not null
);

CREATE TABLE IF NOT EXISTS course(
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    price DECIMAL NOT NULL,
    place VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS courseStudent(
    id SERIAL NOT NULL PRIMARY KEY,
    FK_course INT not null,
    FK_student INT not null
);

CREATE TABLE IF NOT EXISTS student(
    id SERIAL NOT NULL PRIMARY KEY,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    email VARCHAR(20) NOT NULL,
    FK_address INT not null
);

ALTER TABLE mail
ADD CONSTRAINT mail_state
FOREIGN KEY (FK_state)
REFERENCES state(id);

ALTER TABLE address
ADD CONSTRAINT address_mail
FOREIGN KEY (FK_mail)
REFERENCES mail(id);

ALTER TABLE organizer
ADD CONSTRAINT organizer_address
FOREIGN KEY (FK_address)
REFERENCES address(id);

ALTER TABLE courseOrganizer
ADD CONSTRAINT course_organizer
FOREIGN KEY (FK_course)
REFERENCES course(id);

ALTER TABLE courseOrganizer
ADD CONSTRAINT organizer_course
FOREIGN KEY (FK_organizer)
REFERENCES organizer(id);

ALTER TABLE courseStudent
ADD CONSTRAINT course_student
FOREIGN KEY (FK_course)
REFERENCES course(id);

ALTER TABLE courseStudent
ADD CONSTRAINT student_course
FOREIGN KEY (FK_student)
REFERENCES student(id);

ALTER TABLE student
ADD CONSTRAINT student_address
FOREIGN KEY (FK_address)
REFERENCES address(id);