create table users
(
    id         bigint auto_increment primary key,
    email      varchar(50),
    password   varchar(50),
    created_at datetime,
    update_at  datetime,
    deleted_at datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;