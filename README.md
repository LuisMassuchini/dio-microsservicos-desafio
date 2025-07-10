# Desafio Técnico de Microsserviços - DIO

![Status](https://img.shields.io/badge/status-concluído-brightgreen)

## 📜 Descrição do Projeto
Este projeto foi desenvolvido como parte de um desafio técnico da plataforma DIO. O objetivo foi criar uma arquitetura de microsserviços utilizando Spring Boot e Spring Cloud para simular um sistema de catálogo de produtos e pedidos, seguindo as melhores práticas de desenvolvimento e comunicação entre serviços.

## 🏛️ Arquitetura Proposta
A arquitetura do sistema é composta por quatro serviços principais que se comunicam de forma síncrona, com um ponto de entrada único através de um API Gateway.

*(Dica: Adicione a imagem do desafio aqui! Crie uma pasta `images` no seu projeto, coloque o arquivo de imagem nela e use a linha abaixo).*
`![Arquitetura](images/nome-da-sua-imagem.png)`

## ✨ Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Cloud:**
  - Spring Cloud Gateway (API Gateway)
  - Spring Cloud OpenFeign (Cliente HTTP declarativo)
  - Netflix Eureka (Service Discovery)
- **Spring Boot Starter Security** (Segurança baseada em Token)
- **H2 Database** (Banco de dados em memória)
- **Lombok**
- **Maven/Gradle**

## ▶️ Como Executar o Projeto

#### **Pré-requisitos:**
- Java 21 (ou superior) instalado
- Git instalado
- Sua IDE de preferência (ex: IntelliJ, VS Code)
- Ferramenta para testes de API (ex: Postman, Insomnia)

#### **Passos para Execução:**
1. Clone o repositório:
   ```bash
   git clone [https://github.com/Luismassuchini/dio-microsservicos-desafio.git](https://github.com/SeuUsuario/dio-microsservicos-desafio.git)
   ```

2. Na sua IDE, inicie as aplicações na seguinte ordem:
   1. `eureka-server`
   2. `product-catalog`
   3. `order-simulator`
   4. `api-gateway`

3. Verifique o painel do Eureka em `http://localhost:8761` para confirmar que todos os serviços estão com o status `UP`.

## 📡 Endpoints da API
Todas as requisições devem ser feitas através do **API Gateway** na porta **8765** e devem conter o cabeçalho de autorização.

**Cabeçalho Obrigatório:**
- **Key:** `Authorization`
- **Value:** `Bearer dio-desafio-token-secreto-123`

| Funcionalidade | Método | URL (via Gateway) | Corpo (Body) de Exemplo |
| :--- |:--- |:--- |:--- |
| Criar um Produto | `POST` | `/product-catalog/produtos` | `{ "name": "Mouse Gamer", "description": "...", "price": 250.0 }` |
| Listar Produtos | `GET` | `/product-catalog/produtos` | N/A |
| Buscar Produto por ID | `GET` | `/product-catalog/produtos/{id}` | N/A |
| Simular um Pedido | `POST` | `/order-simulator/pedidos` | `{ "productIds": [1, 2] }` |


## 👨‍💻 Autor
Desenvolvido por **[Luís Felipe Fortes Massuchini]**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/luis-massuchini/)
[![Perfil DIO](https://img.shields.io/badge/Perfil%20na%20DIO-333?style=for-the-badge)](https://www.dio.me/users/luis_massuchini)
