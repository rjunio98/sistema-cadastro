# Sistema de Cadastro via CLI em Java

Este é um sistema simples de cadastro via CLI em Java. Ele permite que o usuário responda perguntas, armazene as respostas em um arquivo e execute operações adicionais, como listar usuários cadastrados, cadastrar novas perguntas no formulário, deletar perguntas do formulário e pesquisar usuários por nome, idade ou email.

## Funcionalidades

1. **Responder Perguntas:**
   - O sistema lê um arquivo `formulario.txt` contendo perguntas e permite ao usuário respondê-las, armazenando as respostas em um objeto.

2. **Salvar Respostas em Arquivo:**
   - As respostas são salvas em um arquivo com o formato `1-NOME.txt`, onde o nome é concatenado e convertido para letras maiúsculas.

3. **Menu Principal:**
   - Um menu principal oferece as seguintes opções:
     1. Cadastrar Usuário
     2. Listar Todos Usuários Cadastrados
     3. Cadastrar Nova Pergunta no Formulário
     4. Deletar Pergunta do Formulário
     5. Pesquisar Usuário por Nome, Idade ou Email

## Como Executar

### Pré-requisitos

- Certifique-se de ter o Java instalado em sua máquina.

### Execução

1. Clone este repositório:

    ```bash
    git clone https://seu-repositorio.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd sistema-cadastro-java
    ```

3. Compile o código-fonte:

    ```bash
    javac *.java
    ```

4. Execute o programa:

    ```bash
    java App
    ```

5. Siga as instruções no terminal para utilizar as funcionalidades do sistema.

## Estrutura do Projeto

- `App.java`: Ponto de entrada do programa.
- `MenuPrincipal.java`: Implementação do menu principal e operações relacionadas.
- `LeitorArquivo.java`: Leitura e escrita de perguntas e respostas em arquivo.
- `Usuario.java`: Classe que representa um usuário com respostas às perguntas.

