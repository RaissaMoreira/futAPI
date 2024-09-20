CREATE DATABASE futapi;

CREATE TABLE Jogador (
    cod_jogador SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(60) NOT NULL,
    datanasc DATE NOT NULL
);