create table linkshortener.users (
    "id" bigint PRIMARY KEY,
    "uuid" varchar(36),
    "secret_key" varchar(100)
);
