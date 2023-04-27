create table visitors
(
    id         serial,
    first_name varchar(16),
    last_name  varchar(25),
    quip       text
);

alter table visitors
    owner to dbajlm;

