/*create table [IF NOT EXISTS] hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE [IF NOT EXISTS] type (
                      id BIGINT NOT NULL AUTOINCREMENT,
                      name varchar(64) not null,
                      color varchar(64) not null,
                      PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE [IF NOT EXISTS] news (
                      id BIGINT NOT NULL AUTOINCREMENT,
                      name varchar(64) not null,
                      shortDescription varchar(255),
                      longDescription varchar(255),
                      PRIMARY KEY (id)
) engine=MyISAM;*/