create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE type (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      name varchar(64) not null,
                      color varchar(64) not null,
                      PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE news (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      name varchar(64) not null,
                      s_description varchar(255),
                      l_description varchar(255),
                      PRIMARY KEY (id)
) engine=MyISAM;