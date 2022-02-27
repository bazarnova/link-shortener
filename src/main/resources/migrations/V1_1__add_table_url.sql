create schema if not exists linkshortener;

create table linkshortener.urls (
    "id" SERIAL PRIMARY KEY,
    "long_url" varchar(2084),
    "short_url" varchar(40),
    "created_date" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    "updated_date" timestamp WITH TIME ZONE
);
