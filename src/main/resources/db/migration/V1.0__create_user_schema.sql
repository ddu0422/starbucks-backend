create table users
(
    id        bigint auto_increment primary key,
    email     varchar(50),
    password  varchar(50),
    createdAt date,
    updateAt  date,
    deletedAt date,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;