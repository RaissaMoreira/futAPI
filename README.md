# :coffee: RestAPI em Java - disciplina de Desenvolvimento Web  :coffee:

### Desenvolvido por Mateus Enrick Pitura, Carlos Eduardo Varela e Raissa Mayara Moreira

O sistema foi desenvolvido para gerenciar Jogadores e pagamentos mensais, incluindo operações CRUD (Criar, Ler, Atualizar e Excluir).

## Estrutura de Endpoints
### :pushpin: Rotas de Jogadores

### 1. Criar Jogador

-   **Endpoint**: `/jogador`
-   **Método**: `POST`
-   **Descrição**: Cria um novo jogador no sistema.
-   **Corpo da Requisição**:
    `{
      "cod_jogador": 1,
      "nome": "Nome do Jogador",
      "email": "email@example.com",
      "datanasc": "YYYY-MM-DD"
    }` 
    
### 2. Buscar Jogador por ID

-   **Endpoint**: `/jogador/{id}`
-   **Método**: `GET`
-   **Descrição**: Retorna as informações de um jogador com o ID especificado.
    
### 3. Buscar Jogador por Nome

-   **Endpoint**: `/jogador/buscar`
-   **Método**: `GET`
-   **Descrição**: Busca jogadores cujo nome contém a string especificada.

### 4. Listar Todos os Jogadores

-   **Endpoint**: `/jogador/`
-   **Método**: `GET`
-   **Descrição**: Retorna uma lista de todos os jogadores cadastrados no sistema.
 
 ### 5. Atualizar Informações do Jogador

-   **Endpoint**: `/jogador/{id}`
-   **Método**: `PUT`
-   **Descrição**: Atualiza as informações de um jogador existente.
-   **Corpo da Requisição** (pode conter campos parciais):
    `{
      "nome": "Novo Nome",
      "email": "novoemail@example.com",
      "datanasc": "YYYY-MM-DD"
    }` 

### 6. Excluir Jogador

-   **Endpoint**: `/jogador/{id}`
-   **Método**: `DELETE`
-   **Descrição**: Remove um jogador do sistema.

### :pushpin: Rotas de Pagamentos
### 1. Criar Pagamento

-   **Endpoint**: `/pagamento`
-   **Método**: `POST`
-   **Descrição**: Registra um novo pagamento para um jogador no sistema.
-   **Corpo da Requisição**:
    `{
      "cod_pagamento": 1,
      "ano": 2024,
      "mes": 10,
      "valor": 500.00,
      "cod_jogador": 1
    }` 

### 2. Buscar Pagamento por ID

-   **Endpoint**: `/pagamento/{id}`
-   **Método**: `GET`
-   **Descrição**: Retorna as informações de um pagamento com o ID especificado.

### 3. Listar Todos os Pagamentos

-   **Endpoint**: `/pagamento/`
-   **Método**: `GET`
-   **Descrição**: Retorna uma lista de todos os pagamentos registrados no sistema.

### 4. Atualizar Informações de Pagamento

-   **Endpoint**: `/pagamento/{id}`
-   **Método**: `PUT`
-   **Descrição**: Atualiza as informações de um pagamento existente.
-   **Corpo da Requisição** (pode conter campos parciais):
    `{
      "ano": 2025,
      "mes": 11,
      "valor": 600.00,
      "cod_jogador": 1
    }` 

### 5. Excluir Pagamento

-   **Endpoint**: `/pagamento/{id}`
-   **Método**: `DELETE`
-   **Descrição**: Remove um pagamento do sistema.
