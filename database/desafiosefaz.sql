-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 15-Fev-2020 às 20:38
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `desafiosefaz`
--
CREATE DATABASE IF NOT EXISTS `desafiosefaz` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `desafiosefaz`;

DELIMITER $$
--
-- Procedimentos
--
DROP PROCEDURE IF EXISTS `PessoaCreate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaCreate` (`pNome` VARCHAR(255), `pEmail` VARCHAR(255), `pSenha` VARCHAR(255))  begin
	start transaction;
	insert into pessoa (nome, email , senha) values (pNome,pEmail,pSenha);
    commit;
end$$

DROP PROCEDURE IF EXISTS `PessoaDate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaDate` (`pidPessoa` VARCHAR(255))  begin
	select pessoa.nome, pessoa.email
    from pessoa  where pessoa.idPessoa = pidPessoa;
end$$

DROP PROCEDURE IF EXISTS `PessoaDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaDelete` (`pidPessoa` VARCHAR(255))  begin
	start transaction;
    delete telefone from telefone where telefone.idPessoa = pidPessoa;
	delete pessoa from pessoa where pessoa.idPessoa = pidPessoa;
    commit;
end$$

DROP PROCEDURE IF EXISTS `PessoaList`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaList` ()  begin
	select pessoa.nome, pessoa.email from pessoa;
end$$

DROP PROCEDURE IF EXISTS `PessoaLogin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaLogin` (`pEmail` VARCHAR(255), `pSenha` VARCHAR(255))  begin
	select pessoa.idPessoa, pessoa.nome, pessoa.email
    from pessoa  where pessoa.email = pEmail and pessoa.senha = pSenha;
end$$

DROP PROCEDURE IF EXISTS `PessoaUpdade`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PessoaUpdade` (`pidPessoa` VARCHAR(255), `pNome` VARCHAR(255), `pEmail` VARCHAR(255), `pSenha` VARCHAR(255))  begin
	start transaction;
    update pessoa set nome= pNome, email = pEmail, senha = pSenha where pessoa.idPessoa = pidPessoa;
    
    commit;
end$$

DROP PROCEDURE IF EXISTS `TelefoneCreate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TelefoneCreate` (`pEmail` VARCHAR(255), `pDdd` VARCHAR(255), `pNumero` VARCHAR(255), `pTipo` VARCHAR(255))  begin
	start transaction;
    savepoint safepoint;    
    select idPessoa from pessoa where pessoa.email =pEmail into @idPessoa;  
	insert into telefone (idPessoa, ddd, numero, tipo) values (@idPessoa,pDdd, pNumero,pTipo);
    commit;
end$$

DROP PROCEDURE IF EXISTS `TelefoneDate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TelefoneDate` (`pidPessoa` VARCHAR(255), `pidTelefone` VARCHAR(255))  begin
	select telefone.ddd, telefone.numero, telefone.tipo from telefone 
    inner join pessoa on pessoa.idPessoa = telefone.idPessoa where pessoa.idPessoa = pidPessoa and telefone.idTelefone = pidTelefone ;
end$$

DROP PROCEDURE IF EXISTS `TelefoneDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TelefoneDelete` (`pidPessoa` VARCHAR(255), `pidTelefone` VARCHAR(255))  begin
    delete telefone from telefone inner join pessoa on pessoa.idPessoa = telefone.idPessoa 
    where pessoa.idPessoa = pidPessoa and telefone.idTelefone = pidTelefone ;     
   
end$$

DROP PROCEDURE IF EXISTS `TelefoneList`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TelefoneList` (`pidPessoa` VARCHAR(255))  begin
	select telefone.idTelefone, telefone.ddd, telefone.numero, telefone.tipo from telefone 
    inner join pessoa on pessoa.idPessoa = telefone.idPessoa where pessoa.idPessoa = pidPessoa;
end$$

DROP PROCEDURE IF EXISTS `TelefoneUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TelefoneUpdate` (`pidPessoa` VARCHAR(255), `pidTelefone` VARCHAR(255), `pDdd` VARCHAR(255), `pNumero` VARCHAR(255), `pTipo` VARCHAR(255))  begin
	start transaction;
	update telefone 
    set ddd= pDdd, numero = pNumero, tipo = pTipo where telefone.idPessoa = pidPessoa and telefone.idTelefone =pidTelefone;
    commit;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE `telefone` (
  `idtelefone` int(11) NOT NULL,
  `idpessoa` int(11) NOT NULL,
  `ddd` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idpessoa`),
  ADD UNIQUE KEY `idpessoa_UNIQUE` (`idpessoa`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Índices para tabela `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`idtelefone`,`idpessoa`),
  ADD UNIQUE KEY `idtelefone_UNIQUE` (`idtelefone`),
  ADD KEY `fk_telefone_pessoa1_idx` (`idpessoa`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idpessoa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `telefone`
--
ALTER TABLE `telefone`
  MODIFY `idtelefone` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `fk_telefone_pessoa1` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
