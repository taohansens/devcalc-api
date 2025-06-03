[![CI Pipeline](https://github.com/taohansens/devcalc-api/actions/workflows/ci.yml/badge.svg)](https://github.com/taohansens/devcalc-api/actions/workflows/ci.yml)

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

## Workflows Automatizados

O projeto utiliza **GitHub Actions** para gerenciar os pipelines de **Integração Contínua (CI)** e **Entrega Contínua (CD)**. Abaixo estão as etapas automatizadas configuradas no workflow.

### Gatilhos
O pipeline é executado automaticamente nos seguintes eventos:
- **Push**: Qualquer commit enviado para a branch `main`.
- **Pull Request**: Abertura ou atualização de pull requests que modificam arquivos no diretório `src/`.
- **Execução Manual**: O workflow pode ser acionado manualmente pela interface do GitHub utilizando o evento `workflow_dispatch`.

### Etapas do Pipeline
1. **Checkout**
   - Faz o download do repositório.
2. **Build**
   - Configura o ambiente com **Java 17** e compila o projeto usando o comando `mvn clean install`.
3. **Test**
   - Executa os testes automatizados definidos no projeto com `mvn test`.
4. **Package**
   - Gera o arquivo `.jar` da aplicação usando o comando `mvn package`.
5. **Deploy**
   - Exibe a mensagem `Deploy realizado com sucesso` para simular o processo de entrega contínua.

### Visualização do Workflow
As dependências entre os jobs garantem que os passos sejam executados na ordem correta:
- `Test` depende de `Build`.
- `Package` depende de `Build` e `Test`.
- `Deploy` depende de `Package`.

Os workflows garantem a validação do código e o empacotamento antes de qualquer entrega, facilitando a integração contínua.

### Como Executar Manualmente
1. Acesse a aba **Actions** no GitHub.
2. Selecione o workflow **CI Pipeline**.
3. Clique em **Run Workflow** e escolha a branch para iniciar a execução manualmente.

## Workflows Secundários

Além do pipeline principal de CI/CD, o projeto também inclui o workflow **Show Message Pipeline**, que é responsável por exibir uma mensagem simples como parte do fluxo de trabalho.

### Gatilhos
O workflow é executado automaticamente nos seguintes eventos:
- **Push**: Qualquer commit enviado para a branch `main`.
- **Pull Request**: Abertura ou atualização de pull requests na branch `main`.

### Etapas do Workflow
1. **Checkout**
   - Faz o download do código do repositório.
2. **Print Message**
   - Exibe a mensagem: `Pipeline iniciado com sucesso`.


--------
### TP2

[![CI Pipeline](https://github.com/taohansens/devcalc-api/actions/workflows/ci.yml/badge.svg)](https://github.com/taohansens/devcalc-api/actions/workflows/ci.yml)


No commit ec032d10a5b78c0ed19191ca97ba41656581226e, foi introduzido um erro proposital:
```
   - name: Package with Maven
      run: exit 1
```

O erro foi detectado através da aba Actions no GitHub. Em que foi possível ver o workflow que falhou, expandir o Job, e analisar o log que consta:
```
Package with Maven 0s
Run exit 1
  exit 1
  shell: /usr/bin/bash -e {0}
  env:
    JAVA_HOME: /opt/hostedtoolcache/Java_Adopt_jdk/17.0.15-6/x64
    JAVA_HOME_17_X64: /opt/hostedtoolcache/Java_Adopt_jdk/17.0.15-6/x64
Error: Process completed with exit code 1.
```
Após identificar o erro, o comando incorreto foi corrigido no arquivo ci.yml, e o novo commit realizado com a correção.

### Execução Automática / Manual
A execução automática do pipeline ocorre sempre que há um push/pull na branch main, garantindo que todas as alterações 
no código passem imediatamente pelo fluxo de CI/CD. 

Já a execução manual via botão "Run workflow" permite um controle mais refinado, possibilitando testes 
específicos sem necessidade de um commit, além da configuração de parâmetros adicionais, como execução seletiva de testes, 
como foi feito com o linting/test com inputs.

Enquanto a verificação automática favorece a automação e a consistência na integração contínua, o acionamento manual é mais flexível, 
sendo útil para depuração e análise detalhada antes da incorporação das mudanças no repositório.