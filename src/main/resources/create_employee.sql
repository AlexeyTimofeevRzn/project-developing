create table employee
(
    id        bigserial
        constraint employee_pk
            primary key,
    login     varchar(36) not null,
    password  varchar(255),
    name      varchar(36) not null,
    surname   varchar(36) not null,
    birthdate date
);

alter table employee
    owner to postgres;

create unique index employee_id_uindex
    on employee (id);

create unique index employee_login_uindex
    on employee (login);

