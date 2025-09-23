-- V2: Migrations para adicionar a colina de RANK na tabela de cadastros

ALTER TABLE tb_register
ADD COLUMN rank VARCHAR(255);