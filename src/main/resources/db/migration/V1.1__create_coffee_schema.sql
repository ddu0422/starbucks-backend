create table coffees
(
    id           bigint auto_increment primary key,
    name         varchar(100),
    english_name varchar(100),
    description  text,
    image_url    text,
    price        int,
    created_at   datetime,
    update_at    datetime,
    deleted_at   datetime
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table status
(
    id        bigint auto_increment primary key,
    coffee_id bigint,
    ice       boolean,
    hot       boolean
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;