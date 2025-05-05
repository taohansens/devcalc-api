# DevCalc API

## Objetivo do Projeto
A **DevCalc** é uma API REST desenvolvida com **Spring Boot**, que disponibiliza operações matemáticas simples. Este projeto tem como objetivo validar o funcionamento de pipelines automatizados com **GitHub Actions**, proporcionando um ambiente prático para a implementação de **CI/CD**.

## Ferramenta de Build
A aplicação utiliza **Maven** como ferramenta de build e gerenciamento de dependências. Com Maven, garantimos um processo automatizado de compilação, testes e empacotamento da API.

## Como Executar Localmente

### Pré-requisitos
Antes de iniciar a API, certifique-se de ter instalado:
- **Java 17** ou superior
- **Maven**
- **Git** (para versionamento do código)

### Passos para execução
1. **Clone o repositório**
   ```bash
   git clone https://github.com/taohansens/devcalc-api.git
   cd devcalc-api
   ```

2. **Compilar o projeto**
   ```bash
   mvn clean package
   ```

3. **Executar a API**
   ```bash
   mvn spring-boot:run
   ```

4. **Testar os Endpoints**
   Após iniciar a aplicação, você pode testá-la acessando as seguintes URLs:
    - `GET /add?a=10&b=5` → Retorna `15`
    - `GET /subtract?a=10&b=5` → Retorna `5`
    - `GET /multiply?a=10&b=5` → Retorna `50`
    - `GET /divide?a=10&b=5` → Retorna `2`

## Estrutura do Projeto
A organização do código segue a estrutura padrão do **Spring Boot**:
```
devcalc-api
└── src
    ├── main
    │   └── java
    │       └── com.devcalc
    |           ├── controllers
    |           |   └── CalculatorController.java
    |           ├── services
    |           |   └── CalculatorService.java
    │           └── DevCalcApplication.java
    └── test
        └── java
            └── com.devcalc
               ├── DevCalcApplicationTests.java
               └── CalculatorServiceTest.java
```

Test Workflow: README EDITADO / Não deve executar