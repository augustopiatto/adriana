CREATE DATABASE IF NOT EXISTS `adriana`;
USE `adriana`;

DROP TABLE IF EXISTS `calcado`;
DROP TABLE IF EXISTS `carro`;
DROP TABLE IF EXISTS `celular`;
DROP TABLE IF EXISTS `comida`;
DROP TABLE IF EXISTS `flor`;
DROP TABLE IF EXISTS `instrumento`;
DROP TABLE IF EXISTS `lampada`;
DROP TABLE IF EXISTS `livro`;
DROP TABLE IF EXISTS `menu`;
DROP TABLE IF EXISTS `porta`;
DROP TABLE IF EXISTS `teclado`;

CREATE TABLE `calcado` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`tamanho` TINYINT NOT NULL,
	`marca` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `carro` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`cor` CHAR(255) NOT NULL,
	`marca` CHAR(255) NOT NULL,
	`preco` BIGINT NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `celular` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`sistema_operacional` CHAR(255) NOT NULL,
	`marca` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `comida` (
    `nome` CHAR(255) NOT NULL UNIQUE,
    `sabor` CHAR(255) NOT NULL,
    `textura` CHAR(255) NOT NULL,
	PRIMARY KEY(`nome`)
);

CREATE TABLE `flor` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `cor` CHAR(255) NOT NULL,
    `estacao` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `instrumento` (
    `nome` CHAR(255) NOT NULL UNIQUE,
    `tipo` CHAR(255) NOT NULL,
    `tamanho` CHAR(255) NOT NULL,
	PRIMARY KEY(`nome`)
);

CREATE TABLE `lampada` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`voltagem` TINYINT NOT NULL,
    `tipo` CHAR(255) NOT NULL,
    `brilho` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `livro` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `titulo` CHAR(255) NOT NULL,
    `estilo` CHAR(255) NOT NULL,
    `capa` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `porta` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`altura` FLOAT NOT NULL,
    `cor` CHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);

CREATE TABLE `teclado` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`teclas` INTEGER NOT NULL,
    `tipo` CHAR(255) NOT NULL,
    `rgb` BOOLEAN NOT NULL,
	PRIMARY KEY(`id`)
);
