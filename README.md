# API de Biblioteca (Spring Boot)

API REST para gerenciar livros, desenvolvida na atividade **07 - Spring Web** (FATEC).

## Tecnologias
- Java 17
- Spring Boot 4.1.2 (Spring Web, Spring Data JPA, Validation)
- PostgreSQL
- Maven

## Banco de dados
Banco `db_biblioteca` no PostgreSQL. A tabela `livro` é criada automaticamente pelo Hibernate (`spring.jpa.hibernate.ddl-auto=update`) quando a aplicação sobe.

## Entidade Livro
| Campo | Tipo | Restrição |
|-------|------|-----------|
| id | Long | chave primária, gerada automaticamente |
| titulo | String | não nulo |
| autor | String | não nulo |
| isbn | String | único e não nulo |
| ano | int | - |

## Endpoints (`/livros`)
| Método | Rota | Descrição | Status |
|--------|------|-----------|--------|
| POST | /livros | Cria um livro | 201 Created |
| GET | /livros | Lista todos os livros | 200 OK |
| GET | /livros/{id} | Busca um livro por id | 200 OK / 404 Not Found |
| PUT | /livros/{id} | Atualiza um livro | 200 OK / 404 Not Found |
| DELETE | /livros/{id} | Remove um livro | 204 No Content / 404 Not Found |


## Como rodar
1. Criar o banco `db_biblioteca` no PostgreSQL.
2. Ajustar usuário e senha em `src/main/resources/application.properties`.
3. Executar a classe `ApibibliotecaApplication`.
4. A API fica disponível em `http://localhost:8080/livros`.
