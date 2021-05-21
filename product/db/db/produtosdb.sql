CREATE DATABASE IF NOT EXISTS
produto;
USE produto;

CREATE TABLE produtos (
    id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(150),
    descricao varchar(255),
    preco INTEGER(30),
    sku VARCHAR(20),
    categorias_id INTEGER(30)
);

CREATE TABLE categorias (
    id INTEGER PRIMARY KEY auto_increment,
    nome VARCHAR(255)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

INSERT INTO `produto`.`categorias` (`id`, `nome`) VALUES ('1', 'Eletronico');
INSERT INTO `produto`.`categorias` (`id`, `nome`) VALUES ('2', 'Eletrodomestico');
INSERT INTO `produto`.`categorias` (`id`, `nome`) VALUES ('3', 'Movel');
INSERT INTO `produto`.`categorias` (`id`, `nome`) VALUES ('4', 'Celular');
INSERT INTO `produto`.`categorias` (`id`, `nome`) VALUES ('5', 'Brinquedo');

INSERT INTO `produto`.`produtos` (`id`, `nome`, `descricao`, `preco`, `sku`, `categorias_id`) VALUES ('1', 'Galaxy', 'Galaxy S8', '500', '123cod', '4');
INSERT INTO `produto`.`produtos` (`id`, `nome`, `descricao`, `preco`, `sku`, `categorias_id`) VALUES ('2', 'Iphone', 'Iphone 8', '3000', '124cod', '4');

