create table if not exists users_roles
(
    user_id integer,
    role_id integer,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);