create table blogposts
(
    id             serial,
    uname          varchar(16),
    post_content   text,
    post_date_time timestamp,
    post_title     varchar(30)
);

alter table blogposts
    owner to dbajlm;

