create table linkshortener.statistics (
    "id" SERIAL PRIMARY KEY,
    "short_link" varchar(40),
    "opened_dt" TIMESTAMP WITH TIME ZONE,
    "cnt" INTEGER
);


