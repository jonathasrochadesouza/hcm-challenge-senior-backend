# HCM CHALLENGE (Senior Sistemas) - Backend.

Senior Labs challenge, desafio 'software engineer'.

## Exemplo do funcionamento do código

## Instalação e configuração

1. Clone o repositório em sua máquina
2. Abra o projeto com uma IDE de sua preferência (utilizei Intellij Community)
3. A configuração com o banco de dados `MongoDB` não necessita ser alterado, visto que o `MongoDB` está em cloud
4. Atualize o Maven dos projetos, caso seja necessário
5. Configurando o `Apache Kafka`
   1. Verifique se você já tem o docker em sua máquina
   2. Verifique se é possível rodar o docker em sua máquina
   3. No projeto existe um arquivo chamado, `docker-compose.yml`
   4. Abra um prompt, git bash ou power shell (aconselhado) no diretório que se encontra o `docker-compose.yml` e rode o comando ```docker-compose up -d```
   5. Feito isso o docker deve iniciar. É possível verificar se o docker está rodando o Kafka, através do próprio terminal ou utilizando o docker desktop

## Não tenho o docker instalado?

## Executando o backend

Exemplo utilizando o Intellij!

1. Execute o projeto apenas após ter sido feita a `Instalação e configuração`
2. Rode o projeto referente a producer, executando a classe AplicacaoProducer
3. Rode o projeto referente a consumer, executando a classe AplicacaoConsumer

⚠ Obs: Perceba que será necessário rodar/executar dois projetos, sendo eles o projeto referente a producer e o projeto refente a consumer.
Isto se faz necessário visto a arquitetura que estamos utilizando (Arquitetura orientada a eventos).

## O problema, abordagem e solução (resumo)

### `Problema`

O sistema de ponto HCM, tem milhares colaboradores de diversas empresas do Brasil, marcando o ponto ao mesmo tempo.
Isso visto que os colaboradores marcam o ponto aproximadamente no mesmo horário (entrada às 08:00h da manhã, saída às 12:00h, e assim sucessivamente, nos outros 'horários ideais').

Em aproximandamente 5 minutos, a maioria dos colaboradores já registrarão o ponto nos 'horários ideais'.

O sistema HCM deve se conectar com um sistema legado, para possibilitar passar as informações da marcação de ponto.
O sistema legado tem uma resposta lenta.

Está é uma parte do problema entregue. Acredito ser a mais importante, a qual dei mais prioridade!

## Desenhos/Diagramas

Marcação de pontos (fluxo)
![](https://github.com/jonathasrochadesouza/hcm-challenge-senior-backend/git_assets_readme/hcm_challenge_diagram.png)

Ideação da arquitetura orientada a eventos
![](https://github.com/jonathasrochadesouza/hcm-challenge-senior-backend/git_assets_readme/hcm_challenge_arquitetura.png)

## Executando Aplicação (back + front)

![](https://github.com/jonathasrochadesouza/hcm-challenge-senior-backend/git_assets_readme/hcm-challenge-gif-eventos-marcacao-de-ponto.gif)

## Frontend

Acesse o projeto do frontend no github [aqui!](https://github.com/jonathasrochadesouza/hcm-challenge-senior-frontend)

## Saiba Mais

### `Tecnologias`
* Java openJdk Version 18.0.1
* Apache Kafka
* MongoDb 
* Spring Boot 2.7.0

### `Ferramentas`

* Intellij Community Edition 2022.1
* Offset Explorer 2.0
* MongoDB Compass
* DBVisualzer 13.0.4
* Mongosh 1.5.0
* MongoDB Atlas
* Docker Desktop 4.6.0
* Docker (Client version 20.10.13)
* Whimsical Web

### `Dependências`

* Spring Web (Web)
* Spring Data JPA (SQL)
  * Spring Data
  * Hibernate
* Spring Data MongoDB (NOSQL)
* Spring Boot DevTools (Developer Tools)
* Logback
* Slf4j
* Lombok
* Kafka 2.13
* Hibernate Validator
* Maven Resources Plugin

## `Projeto desenvolvido por Jonathas Rocha`
