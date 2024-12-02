# Sistema de Gestão de Floricultura

Flores Belas é uma floricultura que trabalha com entregas de flores e presentes. Nas datas especiais, há um acúmulo de encomendas e entregas e, para agilizar esse processo, será desenvolvido um software no ambiente Web. A sua missão será elaborar um modelo conceitual do banco de dados da floricultura.

## Vídeo demonstrando a aplicação
[![Aplicação de gerenciamento de floricultura utilizando Java e Swing](https://img.youtube.com/vi/DxhtRmpmJfA/0.jpg)](https://www.youtube.com/watch?v=DxhtRmpmJfA)


---

## Diagramas

### Diagrama de Classes
![Diagrama de Classes](https://github.com/carlosfernandescrypt/floricultura-swing/blob/main/imgs/diagrama_classes.png)  
![Diagrama de Classes](https://github.com/carlosfernandescrypt/floricultura-swing/blob/main/imgs/UML%20class.png)

### Diagrama de Casos de Uso
![Diagrama de Casos de Uso](https://github.com/carlosfernandescrypt/floricultura-swing/blob/main/imgs/diagrama_caso_de_uso.png)

---

## Modelos do Banco de Dados

### Modelo Lógico
![Modelo Lógico](https://github.com/carlosfernandescrypt/floricultura-swing/blob/main/imgs/modelo_l%C3%B3gico)

### Modelo Conceitual
![Modelo Conceitual](https://github.com/carlosfernandescrypt/floricultura-swing/blob/main/imgs/UML%20class(1).png)

---

## Visão Geral do Sistema

O sistema desenvolvido é uma aplicação Java para gerenciar clientes, produtos e encomendas de uma loja de floricultura. Ele utiliza o banco de dados MySQL para armazenar informações, a biblioteca Swing para a interface gráfica e JDBC para a conexão com o banco de dados. A interface permite cadastrar e listar clientes, produtos e encomendas.

---

## Fluxo do Sistema

### Cadastro de Dados
- **Cliente**: Permite adicionar clientes com informações de nome, endereço e telefone.  
- **Produto**: Registra produtos com tipo e preço.  
- **Encomenda**: Insere encomendas vinculadas a clientes, com local de entrega.  

### Listagem de Dados
Os dados de clientes, produtos e encomendas podem ser visualizados em tabelas, organizadas em uma janela secundária da interface gráfica.

### Interface Gráfica
- Tela principal com botões para cada funcionalidade (cadastrar ou listar dados).  
- Uso de caixas de diálogo para entrada de informações no momento do cadastro.  

---

## Estrutura do Código

### Pacotes e Classes

- `org.example`: Pacote principal contendo todas as classes da aplicação.  
- **DBConnection**: Gerencia a conexão com o banco de dados.  
- **Cliente**, **Produto**, **Encomenda**: Modelos para armazenar dados de clientes, produtos e encomendas, respectivamente.  
- **Cadastro**: Classes para registrar dados no banco (**CadastroCliente**, **CadastroProduto**, **CadastroEncomenda**).  
- **Listar**: Classes para buscar e exibir dados do banco (**ListarClientes**, **ListarProdutos**, **ListarEncomendas**).  
- **TelaPrincipal**: Interface gráfica do sistema.  

---

### Funcionamento das Classes

#### **DBConnection**
- Gera conexões com o banco de dados MySQL.  
- Configuração da URL, usuário e senha no método `getConnection()`.  

#### **Modelos (Cliente, Produto, Encomenda)**
- Contêm atributos para os dados correspondentes.  
- Incluem construtores, getters e setters.  

#### **Cadastro de Dados**

- **CadastroCliente**:  
  Registra um cliente no banco de dados.  
  Executa um `INSERT` na tabela `clientes`.

- **CadastroProduto**:  
  Registra um produto no banco de dados.  
  Executa um `INSERT` na tabela `produtos`.

- **CadastroEncomenda**:  
  Verifica a existência do cliente pelo `id_cliente`.  
  Caso exista, registra a encomenda na tabela `encomendas`.

#### **Listagem de Dados**

- **ListarClientes**:  
  Consulta todos os registros na tabela `clientes`.  
  Cria objetos `Cliente` para cada registro.

- **ListarProdutos**:  
  Consulta todos os registros na tabela `produtos`.  
  Cria objetos `Produto` para cada registro.

- **ListarEncomendas**:  
  Consulta os registros de encomendas relacionados a clientes.  
  Cria objetos `Encomenda` associados a objetos `Cliente`.

#### **TelaPrincipal**
- Exibe a interface gráfica da aplicação.  
- Inclui botões para executar as funcionalidades de cadastro e listagem.  
- Usa tabelas (`JTable`) para exibir os dados consultados.

---

## Fluxo de Execução

1. O usuário abre a aplicação via `TelaPrincipal`.  
2. Escolhe uma das opções:  
   - **Cadastrar Cliente/Produto/Encomenda**:  
     - Insere dados via caixas de diálogo.  
     - Os dados são enviados para o banco de dados por meio das classes de cadastro.  
   - **Listar Dados**:  
     - Abre uma nova janela com tabelas exibindo os registros existentes no banco.  
3. A interação com o banco de dados é feita através de JDBC.

---

## Estrutura do Banco de Dados

### Tabela `clientes`
- `id_cliente` (INT, PK)  
- `nome` (VARCHAR)  
- `endereco` (VARCHAR)  
- `telefone` (VARCHAR)  

### Tabela `produtos`
- `id_produto` (INT, PK)  
- `tipo` (VARCHAR)  
- `preco` (DOUBLE)  

### Tabela `encomendas`
- `id_encomenda` (INT, PK)  
- `id_cliente` (INT, FK para `clientes`)  
- `local_entrega` (VARCHAR)
