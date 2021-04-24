create database club char set utf8mb4;
use club;

CREATE TABLE societies
(
    id           INT         NOT NULL AUTO_INCREMENT primary key,
    sName        VARCHAR(20) NOT NULL,
    association  INT         NOT NULL,
    introduction TEXT        NOT NULL,
    date         DATETIME    NOT NULL,
    founder      VARCHAR(20) NOT NULL,
    instructor   VARCHAR(20) NOT NULL,
    status       VARCHAR(4)  NOT NULL,
    money        DOUBLE      NOT NULL,
    unique index (`sName`, `association`)
) CHAR SET UTF8MB4
  CHARACTER SET UTF8MB4;

create table societiesType
(
    id       int         not null primary key,
    typeName varchar(50) not null unique
) char set utf8mb4
  character set utf8mb4;

create table societiesPersonnel
(
    sId    int      not null,
    uId    int      not null,
    job    int      not null,
    date   datetime not null,
    status int      not null default 0,
    primary key (`sId`, `uId`, `job`)
) char set utf8mb4
  character set utf8mb4;

create table societiesJobType
(
    id       int         not null primary key,
    typeName varchar(50) not null unique
) char set utf8mb4
  character set utf8mb4;

create table activity
(
    id           int         not null auto_increment,
    sId          int         not null,
    name         varchar(50) not null,
    principal    varchar(50) not null,
    type         int         not null,
    location     text        not null,
    startTime    datetime    not null,
    endTime      datetime    not null,
    instructor   varchar(20),
    introduction text,
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
    publisher    int         not null,
    number       int         not null,
    introduction text,
    date         datetime    not null,
    status       int         not null,
    type         int         not null
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

create table userInfo
(
    id        int         not null primary key auto_increment,
    number    VARCHAR(20) NOT NULL UNIQUE,
    password  VARCHAR(50) NOT NULL,
    name      VARCHAR(50) NOT NULL,
    className VARCHAR(50) NOT NULL,
    type      INT         NOT NULL,
    phone     BIGINT      NOT NULL
) char set utf8mb4
  character set utf8mb4;

INSERT INTO `club`.`userInfo` (`number`, `password`, `name`, `className`, `type`, `phone`)
VALUES ('admin', 'admin', '李国通', '17软件5班', '1', '13418958563');


INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('1', '计算机学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('2', '管理学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('3', '外国语学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('4', '财经学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('5', '艺术学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('6', '机电学院');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('7', '学术类社团');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('8', '人文类社团');
INSERT INTO `club`.`societiestype` (`id`, `typeName`)
VALUES ('9', '运动类社团');

INSERT INTO `club`.`societiesjobtype` (`id`, `typeName`)
VALUES ('1', '社员');
INSERT INTO `club`.`societiesjobtype` (`id`, `typeName`)
VALUES ('2', '社长');
INSERT INTO `club`.`societiesjobtype` (`id`, `typeName`)
VALUES ('3', '指导老师');
