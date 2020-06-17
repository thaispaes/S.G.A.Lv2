-- -------------- Portuguese ----------------- == ---------- English --------------------------- --
-- --------------------------------------------------------------------------------------------- --
-- Autor: Hylan José  == Author: Hylan José ---------------------------------------------------- --
-- Versão: 1.0 == Version: 1.0 ----------------------------------------------------------------- -- 
-- Conexão com o Sistema de Genrenciamento de Dados == Connection to the Data Management System- --
-- --------------------------------------------------------------------------------------------- --
-- Criando o Banco de Dados == Creating the database ------------------------------------------- --
-- --------------------------------------------------------------------------------------------- --
create database DBbiblio;
-- ---------------------------------------------- --
-- Selecionando o Banco de Dados == Selecting the database
-- ---------------------------------------------- --
use DBbiblio;
-- ---------------------------------------------------- --
-- Criando a tabela TBUser == Creating the TBUser table --
-- ---------------------------------------------------- --
-- -------------------------------------------------------------------------------------- --
-- para adminitração do sistema de gerenciamento == for management system administration
-- -------------------------------------------------------------------------------------- --
create table TBUser(
id int not null primary key auto_increment,
nome varchar(100),
loguin varchar(100) not null,
senha varchar(100) not null,
tipo varchar(15) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ------------------------------------------------------ --
--  Deletando a tabela TUser == Deleting the TUser table  --
-- ------------------------------------------------------ --
drop table TBUser;
-- -------------------------------------------------------------------------------------------------- --
--  Inserindo um adminitrador para teste no sistema == Inserting a test administrator into the system --
-- -------------------------------------------------------------------------------------------------- --
insert into TBUser(nome,loguin,senha,tipo) values('Administrador','admin','admin','User');
-- ------------------------------------------------------------ --
--   Criando a Tabela de Livros == Creating the Book Table      --
-- ------------------------------------------------------------ --
create table TBLivros(
idlivro int not null primary key auto_increment,
nomelivro varchar(100) not null,
autorlivro varchar(100) not null,
editoratlivro varchar(100) not null,
quantidadelivro varchar(100),
imagelivro longblob
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- -------------------------------------------------------------- --
--  Deletando a tabela TBLivros ==  Deleting the TBLivros table   --
-- -------------------------------------------------------------- --
drop table TBlivros;
-- --------------------------------------------------------------------------------------------------------------- --
-- Criando a Tabela de Clientes (Alunos/ Professores/etc) == Creating the Client Table (Students / Teachers / etc) --
-- --------------------------------------------------------------------------------------------------------------- --
create table TBCliente(
idcli int not null primary key auto_increment,
nomecli varchar(100) not null,
matriculacli varchar(100),
emailcli varchar(100),
fonecli varchar(100) not null,
enderecocli varchar(200),
cidadecli varchar(70) not null,
modulocli varchar(100),
seriecli varchar(50),
cursocli varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ---------------------------------------------------------------------------------------- --
-- ----------- Deletando a tabela TBCliente == Deleting the TBClientes table -------------- --
-- ---------------------------------------------------------------------------------------- --
drop table TBCliente;
-- ------------------------------------------------------------------------------ --
-- ------------ Criando a Tabela de Aluguel == Creating rent table -------------- --
-- ------------------------------------------------------------------------------ --
create table TBAluguel(
idaluguel bigint not null auto_increment,
dataaluguel date, 
idlivro int,
idcli int,
primary key (idaluguel),
foreign key (idlivro) references TBLivros(idlivro),
foreign key (idcli) references TBCliente(idcli)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- -------------------------------------------------------------------------------------- --
-- ----------- Deletando a tabela TBAluguel == Deleting the TBAluguel table ------------- --
-- -------------------------------------------------------------------------------------- --
drop table tbaluguel;
-- -----------------------------------------------------
