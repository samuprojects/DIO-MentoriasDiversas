# Tutorial Rest Kafka

## Descrição

Este projeto foi desenvolvido como parte da aula DIO Cognizant 2024, baseada na aula do professor Rodrigo Tavares. O projeto original pode ser encontrado [aqui](https://github.com/expertos-tech/dio-tutorial-kafka). Ele implementa uma API REST usando Spring Boot que se comunica com Kafka e um microserviço que consome mensagens do Kafka e as salva em um banco de dados H2.

## Estrutura do Projeto

- **API REST**: `tutorial-rest-kafka`
- **Microserviço Kafka**: `tutorial-microservico-kafka`

## Tecnologias Utilizadas

- Spring Boot
- Spring Kafka
- Lombok
- H2 Database

## Requisitos

- Java 17
- Docker (para levantar o Kafka)
- Postman para testes

## Levantando o Kafka com Docker

1. **Inicie o Kafka com Docker**:
   - Execute o seguinte comando para levantar o Kafka e Zookeeper:
     ```bash
     docker-compose up -d
     ```
   - Certifique-se de ter o `docker-compose.yml` configurado corretamente para Kafka e Zookeeper.

2. **Crie o tópico**:
   - Configuração do docker no link original  [aqui](https://github.com/expertos-tech/dio-tutorial-kafka)
     

## Executando a Aplicação

1. **Inicie a API REST**:
   - Navegue até o diretório `tutorial-rest-kafka` e execute:
     ```bash
     ./mvnw spring-boot:run
     ```

2. **Inicie o Microserviço**:
   - Navegue até o diretório `tutorial-microservico-kafka` e execute:
     ```bash
     ./mvnw spring-boot:run
     ```

## Testando a API REST com Postman

1. **Abra o Postman**.
   
2. **Crie uma nova requisição**:
   - Selecione o método **POST**.
   - Insira a URL:
     ```
     http://localhost:8080/api/salva-pedido
     ```

3. **Configuração do Corpo da Requisição**:
   - Selecione a opção **Body**.
   - Escolha o tipo **raw** e o formato **JSON**.
   - Insira um JSON no seguinte formato:
     ```json
     {
         "codigo": "123",
         "NomeProduto": "Produto Exemplo",
         "valor": 99.99
     }
     ```

4. **Envie a Requisição**:
   - Clique no botão **Send**.

5. **Verifique a Resposta**:
   - Você deve receber uma resposta com o status 200 e a mensagem `"Sucesso"`.

## Monitorando Mensagens com Kafka Tool

- Utilize o [Kafka Tool](http://www.kafkatool.com/) para acompanhar as mensagens enviadas e recebidas no Kafka, garantindo que os eventos estão sendo processados corretamente.

## Verificando os Dados no Microserviço

- Para verificar se o pedido foi salvo no banco de dados H2, acesse a console do H2:
  
  http://localhost:8080/h2-console

- Utilize as seguintes credenciais para acessar:
  - **JDBC URL**: `jdbc:h2:mem:testdb`
  - **User Name**: `sa`
  - **Password**: `password`

- Execute uma consulta SQL na tabela `pedidos`:
  ```sql
  SELECT * FROM pedidos;
  ```

## Melhorias Futuras

O projeto pode ser aprimorado na classe `PedidoData` e outras funcionalidades podem ser implementadas conforme as necessidades.

## Conclusão

Este projeto é um exemplo prático de como implementar uma API REST que interage com Kafka e um microserviço que consome essas mensagens. Sinta-se à vontade para explorar e modificar o código conforme necessário.