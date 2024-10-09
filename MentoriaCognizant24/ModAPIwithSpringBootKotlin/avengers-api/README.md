# Avengers API

Esta documentação descreve a API de gerenciamento de Vingadores criada seguindo a aula do professor Jether Rodrigues no Bootcamp da Cognizant pela DIO de agosto a outubro de 2024. A API permite realizar operações CRUD (Criar, Ler, Atualizar, Deletar) em informações de Vingadores e foi desenvolvida seguindo o conceito de arquitetura hexagonal, promovendo uma separação clara entre a lógica de negócio e as interfaces externas.

Para mais detalhes sobre o projeto original, acesse o repositório no GitHub: [DIO Avengers API](https://github.com/General-Studies/dio-avengers-api).

## Estrutura do Projeto

A API é estruturada em diferentes pacotes, cada um com sua responsabilidade:

- **Request**: Contém as classes de requisição para a API.
- **Response**: Contém as classes de resposta da API.
- **Resource**: Define os endpoints da API e gerencia as operações.
- **Domain**: Contém a lógica de negócio e a interface do repositório.
- **Repository**: Implementações concretas de acesso a dados.

## Endpoints da API

A API expõe os seguintes endpoints principais:

### 1. Obter todos os Vingadores
- **Método**: `GET`
- **Endpoint**: `/v1/api/avenger`
- **Descrição**: Retorna uma lista de todos os Vingadores.

### 2. Obter detalhes de um Vingador
- **Método**: `GET`
- **Endpoint**: `/v1/api/avenger/{id}/detail`
- **Descrição**: Retorna detalhes de um Vingador específico pelo ID.

### 3. Criar um novo Vingador
- **Método**: `POST`
- **Endpoint**: `/v1/api/avenger`
- **Corpo da Requisição**:
  ```json
  {
      "nick": "string",
      "person": "string",
      "description": "string",
      "history": "string"
  }
  ```
- **Descrição**: Cria um novo Vingador e retorna seus detalhes.

### 4. Atualizar um Vingador
- **Método**: `PUT`
- **Endpoint**: `/v1/api/avenger/{id}`
- **Corpo da Requisição**:
  ```json
  {
      "nick": "string",
      "person": "string",
      "description": "string",
      "history": "string"
  }
  ```
- **Descrição**: Atualiza um Vingador existente pelo ID.

### 5. Deletar um Vingador
- **Método**: `DELETE`
- **Endpoint**: `/v1/api/avenger/{id}`
- **Descrição**: Deleta um Vingador específico pelo ID.

## Modelos de Dados

### AvengerRequest
Representa a estrutura de dados para criar ou atualizar um Vingador.

### AvengerResponse
Representa a estrutura de dados retornada ao usuário após operações.

### Avenger
Classe principal que contém a lógica de negócio relacionada aos Vingadores.

## Exemplos de Uso com Postman

1. **Criar um Vingador**:
   - Método: `POST`
   - URL: `http://localhost:8080/v1/api/avenger`
   - Corpo:
   ```json
   {
       "nick": "Iron Man",
       "person": "Tony Stark",
       "description": "Genius billionaire",
       "history": "Created the Iron Man suit"
   }
   ```

2. **Obter todos os Vingadores**:
   - Método: `GET`
   - URL: `http://localhost:8080/v1/api/avenger`

3. **Atualizar um Vingador**:
   - Método: `PUT`
   - URL: `http://localhost:8080/v1/api/avenger/1`
   - Corpo:
   ```json
   {
       "nick": "Iron Man",
       "person": "Anthony Stark",
       "description": "Genius billionaire playboy philanthropist",
       "history": "Created the Iron Man suit and led the Avengers"
   }
   ```

4. **Deletar um Vingador**:
   - Método: `DELETE`
   - URL: `http://localhost:8080/v1/api/avenger/1`

## Conclusão

A API Avengers oferece uma maneira simples e eficiente de gerenciar informações sobre os Vingadores, permitindo a criação, leitura, atualização e exclusão de dados através de endpoints RESTful. A arquitetura hexagonal garante uma separação clara entre a lógica de negócio e as interações externas. Utilize ferramentas como Postman para interagir com a API de forma intuitiva.
