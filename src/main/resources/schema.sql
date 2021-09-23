DROP TABLE IF EXISTS USER;

create table USER
(
    id           bigint       not null auto_increment,
    login_id     varchar(25)  not null,
    password     varchar(25)  not null,
    email        varchar(100) not null,
    phone_number varchar(25)  not null,
    created_at   TIMESTAMP    not null DEFAULT CURRENT_TIMESTAMP,
    deleted_at   TIMESTAMP    null,
    updated_at   TIMESTAMP    not null DEFAULT CURRENT_TIMESTAMP,
    is_deleted   BOOLEAN      not null DEFAULT false,

    PRIMARY KEY (id)
)