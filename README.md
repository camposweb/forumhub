# Projeto Fórum HUB

### Proposta do projeto

---

Este projeto foi um desafio (Challenge) proposto na capacitação ONE - Oracle Next Education, promovida pela Oracle 
com a Alura, no qual foi desenvolvida uma API REST de fórum, com as seguintes funcionalidades: Cadastrar tópico, listar,
atualizar e deletar, além de listar um tópico em específico pelo seu id. Decidi realizar os commits pela
especificação [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/), uma conversão
simples para utilizar nas mensagens de commit.

### Tecnologias utilizadas

---

![Spring Badge](https://img.shields.io/badge/Spring-6DB33F?logo=spring&logoColor=fff&style=for-the-badge)
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)
![Spring Security Badge](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=fff&style=for-the-badge)
![MySQL Badge](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge)
![JSON Web Tokens Badge](https://img.shields.io/badge/JSON%20Web%20Tokens-000?logo=jsonwebtokens&logoColor=fff&style=for-the-badge)
![Flyway Badge](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=fff&style=for-the-badge)
![Swagger Badge](https://img.shields.io/badge/Swagger-85EA2D?logo=swagger&logoColor=000&style=for-the-badge)

Rotas da aplicação:

Listagem de todos os tópicos

GET - http://localhos:8080/topicos

Listagem detalhada de cada tópico

GET - http://localhos:8080/topicos/{id}

Atualização do tópico específico

PUT - http://localhos:8080/topicos

Deletar tópico específico

DELETE - http://localhos:8080/topicos/{id}


### Banco de dados

Recomendo instalar o [Docker](https://www.docker.com/products/docker-desktop/) para utilizar o banco de dados MySQL.
Com o Docker instalado segue o script para executar um container MySQL:

````docker
docker container run --name my-sql -v my_sql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=admin -p 3306:3306 -d mysql:latest
````

### Variáveis de ambiente

---

Criei uma variável de ambiente, pois não é recomendável utilizar chaves de acesso de forma explícita seja ele em softwares
no modo desenvolvimento quanto em produção.

Links para configurar variáveis de ambiente:

[link 1](https://www.baeldung.com/intellij-idea-environment-variables)

[link 2](https://www.jetbrains.com/help/objc/add-environment-variables-and-program-arguments.html)