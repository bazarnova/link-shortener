create schema if not exists linkshortener;

create table linkshortener.links (
    "id" SERIAL PRIMARY KEY,
    "url" varchar(2084) not null,
    "short_url" varchar(40) not null,
    "created_dt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP not null,
    "exp_dt" timestamp,
    "created_by" bigint
);
