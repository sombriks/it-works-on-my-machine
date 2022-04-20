--liquibase formatted sql

-- changeset sombriks:2022-04-19-23-42_initial-schema.sql

create table todo_list(
  id serial not null,
  title varchar(255) not null,
  created_at timestamp default now(),
  updated_at timestamp,
  primary key (id)
);

create table todo_item(
  id serial not null,
  title varchar(255) not null,
  completed boolean not null default false,
  todo_list_id integer not null,
  created_at timestamp default now(),
  updated_at timestamp,
  primary key (id),
  foreign key (todo_list_id) references todo_list(id) on delete cascade
);

-- rollback drop table todo_item;
-- rollback drop table todo_list;
