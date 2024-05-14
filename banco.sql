CREATE DATABASE IF NOT EXISTS `biblioteca`;
USE `biblioteca`;

CREATE TABLE IF NOT EXISTS `livro` (
	`livId` INT NOT NULL AUTO_INCREMENT,
	`livTitulo` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`livId`)
);

CREATE TABLE IF NOT EXISTS `usuario` (
	`usuid` INTEGER NOT NULL AUTO_INCREMENT,
	`usuNome` VARCHAR(30) NOT NULL,
	`usuSexo` VARCHAR(30) NOT NULL,
	`usologin` VARCHAR(30) NOT NULL,
	`usuSenha` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`usuId`)
);

CREATE TABLE IF NOT EXISTS `reserva` (
	`resId` INTEGER NOT NULL AUTO_INCREMENT,
	`resStatus` VARCHAR(80) NOT NULL,
	`livId` INTEGER NOT NULL,
	PRIMARY KEY (`resId`),
	FOREIGN KEY (`livId`) REFERENCES tb_cor(`cor_id`),
);

INSERT INTO
  `usuarior`(`usuNome`, `usuSexo`, `usulogin`,`usuSenha`)
VALUES
  ("Caio"),
  ("M"),
  ("c"),
  ("123");

