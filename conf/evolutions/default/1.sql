# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  id                        varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  birthday                  timestamp,
  zip                       varchar(255),
  town                      varchar(255),
  address                   varchar(255),
  constraint pk_customer primary key (id))
;

create table previous_glass (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_previous_glass primary key (id))
;

create sequence customer_seq;

create sequence previous_glass_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists customer;

drop table if exists previous_glass;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists customer_seq;

drop sequence if exists previous_glass_seq;

