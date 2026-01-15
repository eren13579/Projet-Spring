CREATE DATABASE sabackend;

CREATE TABLE CLIENT (
    ID integer primary key AUTO_INCREMENT,
    EMAIL varchar(50)
);

CREATE TABLE SENTIMENT (
    ID integer primary key AUTO_INCREMENT,
    TEXT varchar(50),
    TYPE varchar(10),
    CLIENT_ID integer,
    CONSTRAINT client_fk FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(ID)
);
