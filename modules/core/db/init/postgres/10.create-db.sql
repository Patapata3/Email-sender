-- begin EMAILSENDER_RECEIVER
create table EMAILSENDER_RECEIVER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    LETTER_ID uuid not null,
    --
    primary key (ID)
)^
-- end EMAILSENDER_RECEIVER
-- begin EMAILSENDER_LETTER
create table EMAILSENDER_LETTER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE varchar(255) not null,
    CONTENT varchar(255) not null,
    --
    primary key (ID)
)^
-- end EMAILSENDER_LETTER
