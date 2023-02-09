CREATE TABLE users (
    id serial not null,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(100) not null
);