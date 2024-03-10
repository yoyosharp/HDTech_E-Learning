drop database if exists hdtech_e_learning;
create database hdtech_e_learning charset utf8mb4;
use hdtech_e_learning;

create table if not exists roles(
	id bigint auto_increment,
    name varchar(50),
    primary key(id)
);

create table if not exists users(
	id bigint auto_increment,
    email varchar(50),
    user_name varchar(255),
    password varchar(60),
    photo text,
    role_id bigint,
    status tinyint,
    primary key(id),
    foreign key(role_id) references roles(id)
);

create table if not exists categories(
	id bigint auto_increment,
    name varchar(255),
    photo text,
    registered int,
    primary key(id)
);

create table if not exists courses(
	id bigint auto_increment,
    name varchar(255),
    photo text,
    registered int,
    category_id bigint,
    description text,
    primary key(id),
    foreign key(category_id) references categories(id)
);

create table if not exists enrollment(
	id bigint auto_increment,
    user_id bigint,
    course_id bigint,
    `date` date,
    primary key(id),
    foreign key(user_id) references users(id),
    foreign key(course_id) references courses(id)
);

create table if not exists lectures(
	id bigint auto_increment,
    name varchar(255),
    photo text,
    course_id bigint,
    primary key(id),
    foreign key(course_id) references courses(id)
);

create table if not exists completed_lectures(
	id bigint auto_increment,
    user_id bigint,
    lecture_id bigint,
    primary key(id),
    foreign key(lecture_id) references lectures(id),
    foreign key(user_id) references users(id)
);

show tables;
