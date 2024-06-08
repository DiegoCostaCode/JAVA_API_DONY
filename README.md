![logo2](https://github.com/DiegoCostaCode/JAVA_API_DONY/assets/142529378/60deafc1-b2ca-4258-9d84-106f18680d43)![Uploading l<svg width="543" height="158" viewBox="0 0 543 158" fill="none" xmlns="http://www.w3.org/2000/svg">
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

![Dony](https://github.com/DiegoCostaCode/JAVA_API_DONY/assets/142529378/36bc5b5b-1f51-48f6-8465-590bec9a312c)

##Video:

[https://youtu.be/JLEPBLLdj_0](https://youtu.be/JLEPBLLdj_0)

## APIs Consumidas

Dentro de services, existem as classes [`ConsultaCodBarrasAPI`](https://cosmos.bluesoft.com.br/?__cf_chl_tk=By_wxCptStMAJ0ZAZr8zd0Pl8x5XWIY0vjckvW0iKe8-1717732854-0.0.1.1-3732) que consulta e traz informações sobre o código de barras fornecido pelo usuário, e
[`NoticiasOceano`](https://newsapi.org/) que traz noticias em geral, mas que em nosso caso, setamos para trazes apenas noticias relacionadas ao tema do projeto. 

## Telas do Front-end até o momento:

A seguir estão as telas desenvolvidas até o momento para o front-end, as quais interagem com o back-end:

- Tela Principal:
- ![image](https://github.com/DiegoCostaCode/JAVA_API_DONY/assets/142529378/ea69c1d8-d7ad-4334-a7ea-f7484d5609f1)

- Seção com materiais reciclaveis, puxados da classe materiais:
- ![image](https://github.com/DiegoCostaCode/JAVA_API_DONY/assets/142529378/ae877204-f350-4c55-8f67-deaecd94b661)

- Seção com noticias, puxadas diretamente da classe de noticias:
- ![image](https://github.com/DiegoCostaCode/JAVA_API_DONY/assets/142529378/8027714e-0d34-4065-966e-549deb5128fb)
