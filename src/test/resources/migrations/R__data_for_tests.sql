truncate linkshortener.users CASCADE;
truncate linkshortener.links CASCADE;


insert into linkshortener.users
(id, name, password) values
(default, 'Aa1', 'aaa111'),
(default, 'Bb2', 'bbb222'),
(default, 'Cc3', 'ccc333')
;


insert into linkshortener.links
( id, url, short_url, created_dt, exp_dt, created_by) values
(default, 'https://www.google.com/', '4pxw0g', '2022-02-27 20:00',  '2022-02-26 20:00', (select id from linkshortener.users where name = 'Aa1')),
(default, 'https://www.google.com/', 'wewja4', '2022-01-27 20:00',  '2022-03-28 20:00', (select id from linkshortener.users where name = 'Bb2')),
(default, 'https://www.google.com/', 'g416be', '2020-02-27 20:00',  '2022-03-28 20:00', (select id from linkshortener.users where name = 'Cc3'))
;
