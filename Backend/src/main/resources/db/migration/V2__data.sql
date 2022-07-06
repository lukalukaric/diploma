INSERT INTO state (name)
VALUES ('testState');

INSERT INTO mail (name, postalcode, FK_state)
VALUES ('testMail', 1234, 1);

INSERT INTO address (street, houseNumber, FK_mail)
VALUES ('testStreet', '14c', 1);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('test', 'test1','123123123','email', 1);

INSERT INTO student (firstname, lastname, phonenumber, email, fk_address)
VALUES ('test2', 'test2','3333333', 'email', 1);