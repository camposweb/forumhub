create table topicos (
    id bigint not null auto_increment,
    titulo varchar(1000) not null,
    mensagem varchar(1000) not null,
    data_criacao datetime not null default current_timestamp,
    status tinyint not null default 1,
    autor varchar(255) not null,
    curso varchar(255) not null,

    primary key(id)
);