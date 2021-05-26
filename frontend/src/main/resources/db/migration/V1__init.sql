-- create table users_tbl
-- (
--     id_fld       bigint       not null auto_increment unique,
--     nickname_fld varchar(255) not null,
--     username_fld varchar(255) not null unique,
--     password_fld varchar(255) not null,
--     primary key (id_fld)
-- );
--
-- create table task_lists_tbl
-- (
--     id_fld    bigint         not null auto_increment unique,
--     title_fld varchar(65535) not null,
--     primary key (id_fld)
-- );

create table tasks_tbl
(
    id_fld         bigint not null auto_increment,
--     owner_id_fld     bigint not null,
--     task_list_id_fld bigint,
--     priority_fld     int    not null,
--     status_fld       int    not null,
    deadline_fld   date,
    quickly_fld    boolean,
    important_fld  boolean,
    title_fld      varchar(65535),
    text_fld       varchar(65535),
    created_at_fld datetime,
    updated_at_fld datetime,
    primary key (id_fld)
--     foreign key (owner_id_fld) references users_tbl (id_fld),
--     foreign key (task_list_id_fld) references task_lists_tbl (id_fld)
);

-- create table delegated_tasks_tbl
-- (
--     task_id_fld     bigint not null,
--     executor_id_fld bigint not null,
--     foreign key (task_id_fld) references tasks_tbl (id_fld),
--     foreign key (executor_id_fld) references users_tbl (id_fld)
-- )