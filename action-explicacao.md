## Workflow
Um workflow é o arquivo YAML completo (como o ci.yml que se encontra no repositório) que define o pipeline de automação, especificando quando ele deve ser executado, quantos jobs ele possui (como o checkout, build, test, package e deploy), e como esses jobs se relacionam.

## Action
Já uma action é uma unidade individual e reutilizável de funcionalidade que executa uma tarefa específica dentro de um step do workflow, como actions/checkout@v3 que faz o download do código do repositório e actions/setup-java@v3 que configura o ambiente Java. 
No caso do projeto DevCalc, a action actions/setup-java@v3 possui internamente um arquivo action.yml que define suas entradas possíveis (como java-version e distribution), suas saídas, e os comandos que executa para configurar o Java no runner. 
 
No meu workflow, a action é chamada através do uses: actions/setup-java@v3 e recebe parâmetros específicos via seção with: - definindo java-version: '17' e distribution: 'adopt'. 
Essa separação permite que eu reutilize a mesma action em diferentes jobs (build, test e package) sem precisar reescrever a lógica de configuração do Java, mantendo o código limpo e modular no pipeline.
