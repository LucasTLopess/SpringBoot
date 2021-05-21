CREATE DATABASE IF NOT EXISTS
notificacao;
USE notificacao;

CREATE TABLE Mensagem (
    id INTEGER auto_increment KEY UNIQUE NOT NULL,
    id_Cliente INTEGER NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    Data TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP
);


SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;
