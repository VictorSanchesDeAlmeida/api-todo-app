# API Todo App

A API Todo App é uma aplicação simples desenvolvida com Spring Boot, permitindo a gestão de usuários e suas tarefas (todos). Ela oferece rotas para criar, ler, atualizar e excluir usuários e suas tarefas.

## Endpoints

### Usuários

- **GET /user**
  - **Descrição**: Obtém todos os usuários.
  - **Resposta**: Retorna uma lista de todos os usuários registrados.
  - **Status**: 200 OK

- **POST /user**
  - **Descrição**: Cria um novo usuário.
  - **Requisição**: Envia um objeto `User` no corpo da requisição.
  - **Resposta**: Retorna os dados do usuário criado.
  - **Status**: 201 Created

- **PUT /user/{id}**
  - **Descrição**: Atualiza as informações de um usuário específico.
  - **Requisição**: Envia um objeto `User` no corpo da requisição.
  - **Parâmetros**: `id` (ID do usuário)
  - **Resposta**: Retorna os dados do usuário atualizado.
  - **Status**: 200 OK

- **DELETE /user/{id}**
  - **Descrição**: Exclui um usuário específico.
  - **Parâmetros**: `id` (ID do usuário)
  - **Resposta**: Retorna uma mensagem de confirmação da exclusão.
  - **Status**: 200 OK ou 500 Internal Server Error

### Tarefas (Todos)

- **GET /user/{id}/todo**
  - **Descrição**: Obtém todas as tarefas (todos) de um usuário específico.
  - **Parâmetros**: `id` (ID do usuário)
  - **Resposta**: Retorna uma lista de tarefas do usuário.
  - **Status**: 200 OK

- **GET /user/{id}/todo/{idTodo}**
  - **Descrição**: Obtém os detalhes de uma tarefa específica de um usuário.
  - **Parâmetros**: `id` (ID do usuário), `idTodo` (ID da tarefa)
  - **Resposta**: Retorna os detalhes da tarefa especificada.
  - **Status**: 200 OK

- **POST /user/{id}/todo**
  - **Descrição**: Cria uma nova tarefa para um usuário específico.
  - **Requisição**: Envia um objeto `TodoDTO` no corpo da requisição.
  - **Parâmetros**: `id` (ID do usuário)
  - **Resposta**: Retorna os dados da tarefa criada.
  - **Status**: 201 Created

- **PUT /user/{id}/todo/{idTodo}**
  - **Descrição**: Atualiza uma tarefa específica de um usuário.
  - **Requisição**: Envia um objeto `Todo` no corpo da requisição.
  - **Parâmetros**: `id` (ID do usuário), `idTodo` (ID da tarefa)
  - **Resposta**: Retorna os dados da tarefa atualizada.
  - **Status**: 200 OK

- **DELETE /user/{id}/todo/{idTodo}**
  - **Descrição**: Exclui uma tarefa específica de um usuário.
  - **Parâmetros**: `id` (ID do usuário), `idTodo` (ID da tarefa)
  - **Resposta**: Retorna uma mensagem de confirmação da exclusão.
  - **Status**: 200 OK ou 500 Internal Server Error

## Exemplos de Requisição

### Criar Usuário

**POST /user**

```json
{
  "name": "John Doe",
  "password": "********"
}
```
### Criar Tarefa

**POST /user/{idUser}/todo**

```json
{
  "title": "Jogar",
  "description": "Jogar xadrez",
  "completed": false
}
