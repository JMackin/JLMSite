create type roles as enum ('REGUSER', 'BIGUSER', 'JLMMASTER');

create table users
(
    id         serial,
    uname      varchar(16) not null
        unique,
    email      varchar(45) not null
        unique,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    password   bytea       not null,
    enabled    boolean,
    role       roles
);

alter table users
    owner to dbajlm;

