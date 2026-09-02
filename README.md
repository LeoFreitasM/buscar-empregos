# 🔎 Buscar Empregos

**API para busca automatizada de vagas de emprego**

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

---

## 📋 Sobre o projeto

O **Buscar Empregos** é uma API REST desenvolvida com **Java 21 e Spring Boot**, criada para facilitar a busca por oportunidades de emprego através da integração com **APIs externas**.

A aplicação realiza consultas de vagas disponíveis na **Gupy**, processa as informações retornadas e disponibiliza os dados das oportunidades.

O projeto utiliza **MySQL** para persistência dos dados e **Docker Compose** para executar e configurar a aplicação e o banco de dados de forma integrada.

---

## ✨ Funcionalidades

### 🔎 Busca de vagas

- Consulta de vagas através da API da Gupy
- Busca por nome do cargo
- Processamento das informações retornadas pela API externa
- Disponibilização dos dados das oportunidades

### 💾 Persistência

- Armazenamento das vagas encontradas
- Persistência utilizando MySQL
- Utilização do Spring Data JPA para acesso aos dados

### 🔗 Integração com API externa

- Consumo de API externa
- Conversão dos dados recebidos para objetos Java
- Processamento das respostas utilizando Spring Boot

### 🐳 Docker

- Containerização da aplicação
- Containerização do banco de dados MySQL
- Orquestração dos serviços utilizando Docker Compose
- Configuração do ambiente de execução de forma padronizada

---

## 🛠️ Tecnologias

| **Camada** | **Tecnologias** |
| --------------------- | ------------------------------------------------------------- |
| **Backend** | Java 21, Spring Boot, Spring Web, Spring Data JPA |
| **Persistência** | JPA / Hibernate, MySQL |
| **Build** | Maven |
| **Integração** | API REST da Gupy |
| **Containerização** | Docker, Docker Compose |
| **Configuração** | Variáveis de ambiente |
| **Versionamento** | Git / GitHub |

---

## 🏗️ Arquitetura

A aplicação segue uma estrutura organizada em camadas, separando as responsabilidades do sistema.

```text
buscar-empregos/
├── src/
│   └── main/
│       ├── java/
│       │   └── ...
│       └── resources/
│
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

### Fluxo da aplicação

```text
        Gupy API
            ↓
     Spring Boot API
            ↓
       Processamento
            ↓
      Spring Data JPA
            ↓
          MySQL
```

---

## 🔌 Integração com a Gupy

A aplicação realiza consultas à API da Gupy para obter oportunidades de emprego.

Exemplo de consulta:

```http
GET /api/v1/jobs?jobName=Desenvolvedor%20Junior
```

A resposta da API externa é recebida pela aplicação, convertida para objetos Java e processada de acordo com as regras definidas no projeto.

Essa integração permite que a aplicação utilize dados reais de oportunidades disponíveis na plataforma.

---

## 🗄️ Banco de dados

O projeto utiliza **MySQL** para armazenar as informações das vagas encontradas.

A comunicação com o banco é realizada utilizando:

- Spring Data JPA
- Hibernate
- MySQL

As informações de conexão são configuradas através de **variáveis de ambiente**, evitando deixar credenciais diretamente no código-fonte.

Exemplo:

```properties
MYSQL_DB_URL
MYSQL_DB_USERNAME
MYSQL_DB_PASSWORD
```

---

## 🐳 Docker

A aplicação utiliza **Docker** para padronizar o ambiente de execução.

O projeto possui:

```text
Dockerfile
docker-compose.yml
```

O `Dockerfile` é responsável pela criação da imagem da aplicação, enquanto o `docker-compose.yml` permite executar a aplicação juntamente com o banco de dados MySQL.

### Executando com Docker Compose

Certifique-se de que o Docker Desktop esteja em execução.

Depois, execute:

```bash
docker compose up --build
```

Para executar os containers em segundo plano:

```bash
docker compose up --build -d
```

Para verificar os containers:

```bash
docker compose ps
```

Para visualizar os logs:

```bash
docker compose logs -f
```

Para parar os serviços:

```bash
docker compose down
```

---

## ☕ Executando localmente

### Pré-requisitos

- JDK 21+
- Maven
- MySQL
- Docker Desktop (opcional caso queira executar sem Docker)

### Backend

Clone o projeto:

```bash
git clone https://github.com/LeoFreitasM/buscar-empregos.git
```

Acesse a pasta:

```bash
cd search-for-jobs
```

Configure as variáveis de ambiente necessárias para conexão com o MySQL.

Depois execute:

```bash
mvn spring-boot:run
```

Ou gere o `.jar`:

```bash
mvn clean package
```

E execute:

```bash
java -jar target/buscar-empregos-0.0.1-SNAPSHOT.jar
```

---

## 📡 API

A aplicação disponibiliza endpoints REST para interação com os dados das oportunidades.

Exemplo de fluxo:

```text
Cliente
   ↓
Spring Boot
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```

A aplicação também realiza comunicação com serviços externos para obtenção das oportunidades.

---

## 🎯 Objetivo do projeto

O projeto foi desenvolvido com o objetivo de aplicar conhecimentos de **desenvolvimento Backend com Java e Spring Boot**, integração com APIs externas, persistência de dados e containerização.

A ideia surgiu de uma necessidade real: **automatizar a busca por oportunidades de emprego**.

Durante o desenvolvimento, a aplicação foi utilizada para buscar vagas reais na Gupy.

Inclusive, **esta própria oportunidade foi encontrada através da API desenvolvida neste projeto.** 🚀

---


## 👨‍💻 Autor

**Leonardo Freitas**

Projeto desenvolvido para estudo e aplicação prática de conceitos de desenvolvimento **Backend com Java, Spring Boot, APIs REST, MySQL e Docker**.
