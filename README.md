### 1. 🌐 README.md (Raiz do Repositório)

# 🎓 Sistema Acadêmico Integrado: Performance e Segurança

## Status do Projeto
| Componente | Plataforma | Status | Link Público |
| :--- | :--- | :--- | :--- |
| **API REST (Backend)** | Render | ✅ Online | `https://sistema-academico-fullstack.onrender.com` |
| **Site (Frontend)** | Vercel | ✅ Online | `https://sistema-academico-fullstack.vercel.app` |

## Visão Geral e Conquistas
Este projeto é a implementação full stack de um sistema acadêmico, com foco rigoroso em segurança, observabilidade e escalabilidade.

- **🚀 Performance Comprovada:** O sistema demonstrou **0.00% de taxa de erro** sob estresse (100 usuários simultâneos).
- **🔒 Segurança Ativa:** Configuração de Basic Auth e regras de CORS para proteção da API.
- **🔗 Infraestrutura Complexa:** Deploy bem-sucedido de um aplicativo Java (Gradle) em um ambiente Dockerizado (Render).

## 🛠️ Stack Tecnológico
- **Backend:** Spring Boot 3, Java 17, Spring Security.
- **Observabilidade:** Prometheus & Grafana (Docker).
- **Testes:** Apache JMeter.
- **Frontend:** React, Vite, Axios.
### 2. 💻 README.md (Pasta /backend)
Este é o seu relatório de engenharia, destacando a complexidade do deploy e os resultados do teste.


# Backend: Relatório Técnico e API REST

## 🎯 Objetivo
Prover uma API robusta com persistência de dados (Relacionamento N:N) e garantir que a aplicação possa ser monitorada e estressada em produção.

## 🔒 Segurança e Acesso
- **Mecanismo:** Autenticação Básica (Basic Auth).
- **Credenciais de Teste:** Usuário: `admin` / Senha: `123`.
- **Documentação (Swagger/OpenAPI):** Acessível em `http://localhost:8080/swagger-ui/index.html`.

## 📈 Resultados de Teste de Carga (JMeter)

O teste de stress validou que a API mantém o desempenho sob pressão (100 usuários x 5 loops).

[Up<?xml version="1.0" encoding="UTF-8"?>
<jmeterTestPlan version="1.2" properties="5.0" jmeter="5.6.3">
  <hashTree>
    <TestPlan guiclass="TestPlanGui" testclass="TestPlan" testname="Test Plan">
      <elementProp name="TestPlan.user_defined_variables" elementType="Arguments" guiclass="ArgumentsPanel" testclass="Arguments" testname="User Defined Variables">
        <collectionProp name="Arguments.arguments"/>
      </elementProp>
    </TestPlan>
    <hashTree>
      <ThreadGroup guiclass="ThreadGroupGui" testclass="ThreadGroup" testname="Thread Group">
        <intProp name="ThreadGroup.num_threads">100</intProp>
        <intProp name="ThreadGroup.ramp_time">10</intProp>
        <boolProp name="ThreadGroup.same_user_on_next_iteration">true</boolProp>
        <stringProp name="ThreadGroup.on_sample_error">continue</stringProp>
        <elementProp name="ThreadGroup.main_controller" elementType="LoopController" guiclass="LoopControlPanel" testclass="LoopController" testname="Loop Controller">
          <stringProp name="LoopController.loops">5</stringProp>
          <boolProp name="LoopController.continue_forever">false</boolProp>
        </elementProp>
      </ThreadGroup>
      <hashTree>
        <AuthManager guiclass="AuthPanel" testclass="AuthManager" testname="HTTP Authorization Manager">
          <collectionProp name="AuthManager.auth_list">
            <elementProp name="" elementType="Authorization">
              <stringProp name="Authorization.url"></stringProp>
              <stringProp name="Authorization.username">admin</stringProp>
              <stringProp name="Authorization.password">123</stringProp>
              <stringProp name="Authorization.domain"></stringProp>
              <stringProp name="Authorization.realm"></stringProp>
            </elementProp>
          </collectionProp>
          <boolProp name="AuthManager.controlledByThreadGroup">false</boolProp>
        </AuthManager>
        <hashTree/>
        <HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="HTTP Request">
          <stringProp name="HTTPSampler.domain">localhost</stringProp>
          <stringProp name="HTTPSampler.port">8080</stringProp>
          <stringProp name="HTTPSampler.protocol">http</stringProp>
          <stringProp name="HTTPSampler.path">/alunos</stringProp>
          <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
          <stringProp name="HTTPSampler.method">GET</stringProp>
          <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
          <boolProp name="HTTPSampler.postBodyRaw">false</boolProp>
          <elementProp name="HTTPsampler.Arguments" elementType="Arguments" guiclass="HTTPArgumentsPanel" testclass="Arguments" testname="User Defined Variables">
            <collectionProp name="Arguments.arguments"/>
          </elementProp>
        </HTTPSamplerProxy>
        <hashTree/>
        <ResultCollector guiclass="ViewResultsFullVisualizer" testclass="ResultCollector" testname="View Results Tree">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <timestamp>true</timestamp>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <xml>false</xml>
              <fieldNames>true</fieldNames>
              <responseHeaders>false</responseHeaders>
              <requestHeaders>false</requestHeaders>
              <responseDataOnError>false</responseDataOnError>
              <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>
              <assertionsResultsToSave>0</assertionsResultsToSave>
              <bytes>true</bytes>
              <sentBytes>true</sentBytes>
              <url>true</url>
              <threadCounts>true</threadCounts>
              <idleTime>true</idleTime>
              <connectTime>true</connectTime>
            </value>
          </objProp>
          <stringProp name="filename"></stringProp>
        </ResultCollector>
        <hashTree/>
        <ResultCollector guiclass="SummaryReport" testclass="ResultCollector" testname="Summary Report">
          <boolProp name="ResultCollector.error_logging">false</boolProp>
          <objProp>
            <name>saveConfig</name>
            <value class="SampleSaveConfiguration">
              <time>true</time>
              <latency>true</latency>
              <timestamp>true</timestamp>
              <success>true</success>
              <label>true</label>
              <code>true</code>
              <message>true</message>
              <threadName>true</threadName>
              <dataType>true</dataType>
              <encoding>false</encoding>
              <assertions>true</assertions>
              <subresults>true</subresults>
              <responseData>false</responseData>
              <samplerData>false</samplerData>
              <xml>false</xml>
              <fieldNames>true</fieldNames>
              <responseHeaders>false</responseHeaders>
              <requestHeaders>false</requestHeaders>
              <responseDataOnError>false</responseDataOnError>
              <saveAssertionResultsFailureMessage>true</saveAssertionResultsFailureMessage>
              <assertionsResultsToSave>0</assertionsResultsToSave>
              <bytes>true</bytes>
              <sentBytes>true</sentBytes>
              <url>true</url>
              <threadCounts>true</threadCounts>
              <idleTime>true</idleTime>
              <connectTime>true</connectTime>
            </value>
          </objProp>
          <stringProp name="filename"></stringProp>
        </ResultCollector>
        <hashTree/>
      </hashTree>
    </hashTree>
  </hashTree>
</jmeterTestPlan>
loading Summary Report.jmx…]()


| Métrica | Performance |
| :--- | :--- |
| **Taxa de Erro** | **0.00%** (Nenhuma falha de servidor) |
| **Tempo Médio de Resposta** | 74 ms (Excelente latência) |
| **Vazão (Throughput)** | 49.1 requisições/segundo |

## ☁️ Deploy no Render (Instruções Finais)

A compilação e execução são automatizadas no Render, que utiliza a seguinte sequência de comandos para lidar com o projeto Gradle:

- **Build/Run Command:** (Comando combinado para superar a limitação do Docker)
  `cp -r . /tmp/app && cd /tmp/app && ./gradlew clean build && java -jar build/libs/*.jar`

### Como Monitorar Localmente (Opcional)
1.  **Pré-requisito:** Backend rodando (`./gradlew bootRun`).
2.  Na pasta Docker, execute: `docker compose up`
3.  **Acessos:** Grafana (`http://localhost:3000`), Prometheus (`http://localhost:9090`).
### 3. 🌐 README.md (Pasta /frontend)
Este README foca na conexão final e na usabilidade do site.


# Frontend: Interface Web (React/Vite)

## 💡 Usabilidade e Conexão

A interface permite o cadastro e a visualização imediata de alunos, provando que a comunicação segura entre o domínio Vercel e a API Render foi estabelecida com sucesso.

- **Tecnologia:** React, Vite (Javascript) e Axios.
- **Conexão Final:** O site está programado para consumir a API REST pública do Render (HTTPS).

## 🔌 Detalhes da Conexão
- **URL Base:** `https://sistema-academico-fullstack.onrender.com`
- **Segurança:** O Axios envia as credenciais `admin/123` em cada requisição (Basic Auth).

## 🚀 Como Rodar Localmente
1.  **Instalação:** Na pasta `/frontend`, execute `npm install`.
2.  **Execução:** Execute `npm run dev`.

## ☁️ Deploy no Vercel
O site está publicado publicamente no Vercel e está funcionalmente conectado à API:

- **Link Público Final:** `https://sistema-academico-fullstack.vercel.app`
- **Configuração:** O deploy utiliza `Root Directory: frontend`.
