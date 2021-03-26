create database club char set utf8mb4;
use club;
CREATE TABLE user
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number`   VARCHAR(20) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    `name`     VARCHAR(50) NOT NULL,
    `type`     INT         NOT NULL,
    `phone`    BIGINT      NOT NULL
) charset utf8mb4
  character set utf8mb4;
INSERT INTO `club`.`user` (`number`, `password`, `name`, `type`, `phone`)
VALUES ('vas23', '981002', '李国通', '1', '13418958563');

create table societies
(
    id           int         not null auto_increment primary key,
    sName        varchar(20) not null unique,
    association  int         not null,
    introduction text        not null,
    date         datetime    not null,
    founder      varchar(20) not null,
    instructor   varchar(20) not null,
    status       varchar(4)  not null,
    money        double      not null
) char set utf8mb4
  character set utf8mb4;

create table societiesType
(
    id       int         not null primary key,
    typeName varchar(50) not null unique
) char set utf8mb4
  character set utf8mb4;

create table societiesPersonnel
(
    sId  int      not null,
    uId  int      not null,
    job  int      not null,
    date datetime not null,
    primary key (`sId`, `uId`, `job`)
) char set utf8mb4
  character set utf8mb4;

create table societiesJobType
(
    id       int         not null primary key,
    typeName varchar(50) not null unique
);

create table activity
(
    id         int         not null auto_increment,
    sId        int         not null,
    name       varchar(50) not null,
    principal  varchar(50) not null,
    type       int         not null,
    location   text        not null,
    startTime  datetime    not null,
    endTime    datetime    not null,
    instructor varchar(20),
    primary key (`id`, `sId`)
) char set utf8mb4
  character set utf8mb4;

create table activityType
(
    id           int         not null primary key,
    typeName     varchar(50) not null unique,
    introduction text        not null,
    value        double      not null
) char set utf8mb4
  character set utf8mb4;

create table activityPeople
(
    id     int         not null,
    number varchar(20) not null,
    primary key (`id`, `number`)
) char set utf8mb4
  character set utf8mb4;

create table photo
(
    id           int         not null primary key auto_increment,
    name         varchar(50) not null,
    number       varchar(20) not null,
    introduction text,
    date         datetime    not null
) char set utf8mb4
  character set utf8mb4;

create table task
(
    id           int         not null primary key auto_increment,
    name         varchar(50) not null,
    sId          int         not null,
    publisher    varchar(50) not null,
    number       varchar(20) not null,
    introduction text,
    date         datetime    not null
) char set utf8mb4
  character set utf8mb4;

create table funding
(
    id           int         not null primary key auto_increment,
    money        double      not null,
    dNumber      varchar(20),
    sId          int         not null,
    introduction text        not null,
    dDate        datetime,
    uNumber      varchar(20) not null,
    uDate        datetime    not null,
    status       varchar(4)  not null
) char set utf8mb4
  character set utf8mb4;