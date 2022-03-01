create table linkshortener.users (
    "id" SERIAL PRIMARY KEY,
    "name" varchar(36) not null,
    "password" varchar(100) not null
);
