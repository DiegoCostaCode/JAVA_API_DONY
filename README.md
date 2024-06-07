# DONY - GS FIAP (em desenvolvimento)

## Descrição do Projeto

O DONY é um projeto desenvolvido em Java com o objetivo de realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados Oracle. Este projeto é integrado com um front-end e recebe requisições desse front-end para recuperar informações do banco de dados e também para inserir novas informações.

## Como Rodar o Projeto

Para executar o projeto, siga os passos abaixo:

1. Certifique-se de ter o Java instalado em sua máquina. Se não tiver, você pode baixá-lo no site oficial da Oracle.
2. Clone o repositório do projeto.
3. Abra o projeto em uma IDE de sua preferência.
4. Navegue até a classe principal e execute a aplicação.
5. A aplicação estará rodando na porta 8080 do seu localhost.

## Endpoints

A seguir estão os endpoints disponíveis na aplicação:

- `/usuario`: Adiciona e lê todos cadastros.
- `/reciclagem`: Adiciona e lê todos itens cadastrados por usuários e verificados na API.
- `/material`: Adiciona e lê os materiais cadastrados.
- `/noticia`: lê todos as noticias e noticias especificas.
- `/projeto`: Lê todos os projetos cadastrados, e projetos especificos.
- `/instituicao`: Lê todos os cadastros de instituiçoes.

## Diagrama de Classes UML

Veja o diagrama de classes do projeto [aqui](link para o diagrama de classes).

## APIs Consumidas

Dentro da infraestrutura do projeto, há uma classe chamada `FakeCompanyService` responsável por consumir uma API de empresas fictícias. Também há uma classe para gerar QR codes usando outra API.

## Telas do Front-end

A seguir estão as telas desenvolvidas para o front-end, as quais interagem com o back-end:

- Tela Principal
- Tela de Denúncias
- Tela de Registrar Denúncia
- Tela de Doações
- Tela de Login
- Tela de Cadastro

## Arquivo de Logs

O projeto possui um arquivo chamado `logs.log` que armazena todos os logs gerados pela aplicação. Caso ocorra algum erro, é possível verificar esse arquivo para identificar o problema. O arquivo está localizado na pasta `logs` dentro do projeto.
