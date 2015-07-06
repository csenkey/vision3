# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customers (
  id                        varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  telephone                 varchar(255),
  birthday                  timestamp,
  zip                       varchar(255),
  town                      varchar(255),
  address                   varchar(255),
  constraint pk_customers primary key (id))
;

create sequence customers_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists customers;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists customers_seq;

