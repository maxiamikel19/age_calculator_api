AGE CALCULATOR API

Uma REST API que permite criar cadastro de pessoas (User) informando os atributos solicitados como: name, email, burthDate, gender para efetuar o catastro exitosamente se o email nao se encontra cadastrado anteriormente na tabela users_tb.
Com um usuario cadastrad, usando o email ou o userId, a API retorna um detalhe dos dados do usuario incluindo seu idade en ano, mes e dia.

TECNOLOGIAS
- JAVA (Spring Boot) V-17
- Lombook
- Spring validation
- Spring web
- spring Data JPA
- Spring boot dev-tools
- MYSQL
- Git
- BRUNO (Para teste)

  USAGE
  - clonar o projeto: https://github.com/maxiamikel19/age_calculator_api
  - criar o banco de dados: age_calculator_db
  - execute o projeto

  ENDPOINTS
  -  POST: http://localhost:8080/api/v1/users
  -  GET: http://localhost:8080/api/v1/users/infos?criteria=amikel@maxi.com OU http://localhost:8080/api/v1/users/infos?criteria=2f47e033-5e64-4e27-950e-c43a72a2ff91
 
  TESTE

   -  POST: http://localhost:8080/api/v1/users
  ![image](https://github.com/user-attachments/assets/373a0a2a-9c95-48bf-b231-9cc2fde3959f)

-  GET: http://localhost:8080/api/v1/users/infos?criteria=amikel@maxi.com
-  ![image](https://github.com/user-attachments/assets/12489848-e47a-4c63-9d47-d4f766389b9e)
- GET:  http://localhost:8080/api/v1/users/infos?criteria=2f47e033-5e64-4e27-950e-c43a72a2ff91
- ![image](https://github.com/user-attachments/assets/a6453aae-7a2d-4058-b836-d3e04a8d261d)


