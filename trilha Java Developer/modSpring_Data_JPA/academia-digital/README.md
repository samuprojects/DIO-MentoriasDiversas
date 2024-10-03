# Documentação da API - Academia

Este projeto é uma API para gerenciar alunos, avaliações físicas e matrículas em uma academia.

É continuação do projeto iniciado com a professora Camila no [Projeto Base](https://github.com/cami-la/academia-digital).

Foi incluído o restante das sugestões de métodos como update e delete, além de uma camada básica de segurança observada em outros módulos da trilha Java da DIO.

(Utilizar no postman a autenticação  admin / admin nos testes).

## Endpoints

A API possui três principais entidades: **Aluno**, **Avaliação Física** e **Matrícula**. Abaixo estão as instruções para testar cada uma delas usando o Postman.

### 1. Alunos

#### **Create (POST)**
- **Endpoint:** `/alunos`
- **Método:** POST
- **Corpo da requisição (JSON):**
  ```json
  {
    "nome": "João Silva",
    "cpf": "12345678909",
    "bairro": "Centro",
    "dataDeNascimento": "1990-01-01"
  }


#### **Read (GET)**
- **Endpoint:** `/alunos`
- **Método:** GET
- **Parâmetro opcional:** `dataDeNascimento`
  - Exemplo: `/alunos?dataDeNascimento=1990-01-01`

#### **Read por ID (GET)**
- **Endpoint:** `/alunos/{id}`
- **Método:** GET
- **Exemplo:** `/alunos/1`

#### **Update (PUT)**
- **Endpoint:** `/alunos/{id}`
- **Método:** PUT
- **Corpo da requisição (JSON):**
  ```json
  {
    "nome": "João da Silva",
    "bairro": "Zona Sul"
  }
  ```

#### **Delete (DELETE)**
- **Endpoint:** `/alunos/{id}`
- **Método:** DELETE
- **Exemplo:** `/alunos/1`

---

### 2. Avaliações Físicas

#### **Create (POST)**
- **Endpoint:** `/avaliacoes`
- **Método:** POST
- **Corpo da requisição (JSON):**
  ```json
  {
    "alunoId": 1,
    "peso": 70.5,
    "altura": 1.75
  }
  ```

#### **Read (GET)**
- **Endpoint:** `/avaliacoes`
- **Método:** GET

#### **Read por ID (GET)**
- **Endpoint:** `/avaliacoes/{id}`
- **Método:** GET
- **Exemplo:** `/avaliacoes/1`

#### **Update (PUT)**
- **Endpoint:** `/avaliacoes/{id}`
- **Método:** PUT
- **Corpo da requisição (JSON):**
  ```json
  {
    "peso": 72.0,
    "altura": 1.76
  }
  ```

#### **Delete (DELETE)**
- **Endpoint:** `/avaliacoes/{id}`
- **Método:** DELETE
- **Exemplo:** `/avaliacoes/1`

---

### 3. Matrículas

#### **Create (POST)**
- **Endpoint:** `/matriculas`
- **Método:** POST
- **Corpo da requisição (JSON):**
  ```json
  {
    "alunoId": 1
  }
  ```

#### **Read (GET)**
- **Endpoint:** `/matriculas`
- **Método:** GET
- **Parâmetro opcional:** `bairro`

#### **Read por ID (GET)**
- **Endpoint:** `/matriculas/{id}`
- **Método:** GET
- **Exemplo:** `/matriculas/1`

#### **Update (PUT)**
- **Endpoint:** `/matriculas/{id}`
- **Método:** PUT
- **Corpo da requisição (JSON):**
  ```json
  {
    "alunoId": 1
  }
  ```

#### **Delete (DELETE)**
- **Endpoint:** `/matriculas/{id}`
- **Método:** DELETE
- **Exemplo:** `/matriculas/1`

---

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou sugestões!
