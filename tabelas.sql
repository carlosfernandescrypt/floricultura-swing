CREATE DATABASE floricultura;

USE floricultura;

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(15)
);

CREATE TABLE produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

CREATE TABLE encomendas (
    id_encomenda INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    local_entrega VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE encomendas_produtos (
    id_encomenda INT,
    id_produto INT,
    PRIMARY KEY (id_encomenda, id_produto),
    FOREIGN KEY (id_encomenda) REFERENCES encomendas(id_encomenda),
    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);
