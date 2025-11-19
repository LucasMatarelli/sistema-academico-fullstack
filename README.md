### 1. 📂 README.md (Raiz do Repositório)
Crie este arquivo na pasta principal do seu projeto.

Markdown

# [cite_start]🎓 Prática Avaliativa: Sistema Acadêmico Full Stack [cite: 16]

## 🎯 Objetivo
[cite_start]Desenvolver uma aplicação web full stack, segura e monitorada, utilizando Spring Boot 3 e React, com foco na arquitetura de microsserviços e na escalabilidade[cite: 18, 24].

## 🛠️ Tecnologias Principais
- [cite_start]**Backend:** Spring Boot 3 [cite: 26] (Java 17, Gradle)
- [cite_start]**Frontend:** React, Vite [cite: 79, 80]
- [cite_start]**Segurança:** Spring Security [cite: 30, 56] (Basic Auth)
- [cite_start]**Banco de Dados:** H2 Database (em memória) [cite: 34]
- [cite_start]**Monitoramento:** Prometheus e Grafana (via Docker) [cite: 47, 49, 103]
- [cite_start]**Testes de Carga:** Apache JMeter [cite: 66]
- [cite_start]**Deploy:** Render (API) [cite: 83] [cite_start]e Vercel (Site) [cite: 84]

## 🗺️ Estrutura do Projeto
- **/backend:** Contém o código da API, segurança, JPA e arquivos Docker.
- **/frontend:** Contém o código da interface web React/Vite.
### 2. 🖥️ README.md (Pasta /backend)
Este é o seu relatório técnico que comprova os testes e o deploy .

Markdown

# Backend: API Sistema Acadêmico (Java/Spring Boot 3)

## [cite_start]🚀 Como Rodar Localmente [cite: 139]

1. **Pré-requisitos:** Java JDK 17+, Docker Desktop.
2. **Execução:** Abra o terminal na pasta `/backend` e execute:
   ```bash
   ./gradlew bootRun
🔒 Segurança e Documentação 


Autenticação: O sistema utiliza Basic Authentication.

Credenciais de Teste: Usuário: admin / Senha: 123.

Documentação (Swagger/OpenAPI): Acessível em http://localhost:8080/swagger-ui/index.html.

📊 Monitoramento com Prometheus e Grafana 

O monitoramento de métricas do Spring Actuator é configurado via Docker Compose.


Execução: No terminal, navegue até a pasta /backend e execute: docker compose up


Acessos: Grafana  (http://localhost:3000) e Prometheus  (http://localhost:9090).


🔨 Testes de Carga e Stress (Apache JMeter) 


O teste simula o acesso simultâneo ao endpoint /alunos para avaliar a estabilidade e escalabilidade.


Configuração: O arquivo Summary Report.jmx simula 100 usuários com 10 segundos de ramp-up em 5 loops  (Total: 500 requisições).



Endpoint Testado: http://localhost:8080/alunos (Método GET).


Credenciais Utilizadas: admin / 123.

Resultado Obtido (Comprovado):

Taxa de Erro: 0.00%

Tempo Médio de Resposta: ~74 ms (Excelente desempenho)

☁️ Deploy no Render 

A API está publicada publicamente e acessível pela internet.

Link Público: https://sistema-academico-fullstack.onrender.com

Comando de Início (Docker Command):

Bash

/bin/sh -c "cd /opt/render/project/src && sh ./gradlew clean build && java -jar build/libs/*.jar"
📚 Referências 

Spring Boot Docs, Spring Security Docs, Prometheus Docs.


***

### 3. 🌐 README.md (Pasta /frontend)

Este arquivo detalha o cliente web e o deploy no Vercel [cite: 145-150].

```markdown
# Frontend: Interface Web (React/Vite)

## 💻 Tecnologias Utilizadas [cite: 147]

- React, Vite (Javascript) [cite: 79, 80]
- Axios (Cliente HTTP para comunicação com a API)

## 🚀 Como Rodar Localmente [cite: 148]

1.  **Pré-requisitos:** Node.js (LTS).
2.  **Execução:** No terminal, na pasta `/frontend`, execute:
    ```bash
    npm install
    npm run dev
    ```

## 🌐 Consumo da API [cite: 149]

O site consome a API REST pública do Backend (hospedado no Render).

- **URL Base Final:** `https://sistema-academico-fullstack.onrender.com`
- **Autenticação:** O Axios envia as credenciais `admin/123`  em todas as requisições.

## ☁️ Deploy no Vercel [cite: 84, 150]

O Frontend está publicado publicamente no Vercel e conectado ao link final da API.

- **Link Público Final:** `https://sistema-academico-fullstack.vercel.app`
- **Configuração:** O deploy foi configurado com `Root Directory: frontend`.
