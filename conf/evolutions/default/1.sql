# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  id                        varchar(255) not null,
  store_id                  varchar(255) not null,
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
  customer_id               varchar(255) not null,
  name                      varchar(255),
  constraint pk_previous_glass primary key (id))
;

create table store (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_store primary key (id))
;

create table user (
  username                  varchar(255) not null,
  password                  varchar(255),
  name                      varchar(255),
  store_id                  varchar(255),
  constraint pk_user primary key (username))
;

create sequence customer_seq;

create sequence previous_glass_seq;

create sequence store_seq;

create sequence user_seq;

alter table customer add constraint fk_customer_store_1 foreign key (store_id) references store (id) on delete restrict on update restrict;
create index ix_customer_store_1 on customer (store_id);
alter table previous_glass add constraint fk_previous_glass_customer_2 foreign key (customer_id) references customer (id) on delete restrict on update restrict;
create index ix_previous_glass_customer_2 on previous_glass (customer_id);
alter table user add constraint fk_user_store_3 foreign key (store_id) references store (id) on delete restrict on update restrict;
create index ix_user_store_3 on user (store_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists customer;

drop table if exists previous_glass;

drop table if exists store;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists customer_seq;

drop sequence if exists previous_glass_seq;

drop sequence if exists store_seq;

drop sequence if exists user_seq;

