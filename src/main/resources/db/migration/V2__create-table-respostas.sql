create table respostas (
    id bigint not null auto_increment,
    mensagem varchar(1000) not null,
    topico varchar(100) not null,
    data_criacao datetime not null default current_timestamp,
    autor varchar(255) not null,

    primary key(id)
);