DROP DATABASE IF EXISTS `LunaMia`;

CREATE DATABASE `LunaMia`;

CREATE TABLE IF NOT EXISTS `LunaMia`.`ProdutoEstoque` (
  `id_estoque` INT AUTO_INCREMENT NOT NULL,
  `unidadeMedida` ENUM('metro', 'centimetro', 'litro', 'mililitro', 'unidade') NOT NULL,
  `valor` DECIMAL NOT NULL,
  `marca` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `qntDisponivel` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `qntPorUnidade` DECIMAL NOT NULL,
  PRIMARY KEY (`id_estoque`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Cliente` (
  `id_cliente` INT AUTO_INCREMENT NOT NULL,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id_cliente`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Perfil_Usuario` (
  `email` VARCHAR(64) NOT NULL,
  `fotoPerfil` MEDIUMBLOB NULL,
  `senha` VARCHAR(12) NOT NULL,
  `nrTelefone` VARCHAR(13) NOT NULL,
  `nomeUsuario` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `precoHora` DECIMAL NOT NULL,
  `endereco` VARCHAR(200) NOT NULL,
  `percentualLucro` DECIMAL NOT NULL,
  PRIMARY KEY (`email`, `nomeUsuario`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Orcamento` (
  `id_orcamento` INT AUTO_INCREMENT NOT NULL,
  `tituloPedido` VARCHAR(45) NOT NULL,
  `statusPedido` ENUM('Concluido', 'Andamento', 'Pendente') NOT NULL,
  `precoHora` DECIMAL NOT NULL,
  `quantHrs` DECIMAL NOT NULL,
  `quantDiasPedido` INT NOT NULL,
  `Perfil_Usuario_email` VARCHAR(64) NOT NULL,
  `Perfil_Usuario_nomeUsuario` VARCHAR(50) NOT NULL,
  `Cliente_id_cliente` INT NOT NULL,
  `descricao` VARCHAR(500) NULL,
  PRIMARY KEY (`id_orcamento`),
  
  INDEX `fk_Orcamento_Perfil_Usuario1_idx` (`Perfil_Usuario_email` ASC) ,
  INDEX `fk_Orcamento_Perfil_Usuario1_idy` (`Perfil_Usuario_nomeUsuario` ASC) ,
  INDEX `fk_Orcamento_Cliente1_idx` (`Cliente_id_cliente` ASC) ,
  CONSTRAINT `fk_Orcamento_Perfil_Usuario1`
    FOREIGN KEY (`Perfil_Usuario_email`, `Perfil_Usuario_nomeUsuario`)
    REFERENCES `LunaMia`.`Perfil_Usuario` (`email`, `nomeUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_Cliente1`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `LunaMia`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `LunaMia`.`Confirmacao_de_orcamento` (
  `formaPagam` INT NOT NULL,
  `dataPrevisaoEnt` VARCHAR(45) NULL,
  `dataConfirmacao` VARCHAR(45) NOT NULL,
  `id_orcamento` INT NOT NULL,
  `valorVenda` float not null,
  `lucroTotalObtido` float not null,
   
  PRIMARY KEY (`id_orcamento`),
  CONSTRAINT `fk_Confirmação_de_orcaçamento_Orcamento`
    FOREIGN KEY (`id_orcamento`)
    REFERENCES `Orcamento` (`id_orcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `LunaMia`.`OrcamentoProduto` (
  `id_orcamento` INT NOT NULL,
  `id_estoque` INT NOT NULL,
  PRIMARY KEY (`id_estoque`, `id_orcamento`),
  INDEX `fk_Confirmacao_de_orcamento_has_ProdutoEstoque_ProdutoEstoq_idx` (`id_estoque` ASC),
  INDEX `fk_Confirmacao_de_orcamento_has_ProdutoEstoque_Confirmacao__idx` (`id_orcamento` ASC),
  CONSTRAINT `fk_Confirmacao_de_orcamento_has_ProdutoEstoque_Confirmacao_de1`
    FOREIGN KEY (`id_orcamento`)
    REFERENCES `LunaMia`.`Confirmacao_de_orcamento` (`id_orcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Confirmacao_de_orcamento_has_ProdutoEstoque_ProdutoEstoque1`
    FOREIGN KEY (`id_estoque`)
    REFERENCES `LunaMia`.`ProdutoEstoque` (`id_estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION); 
    
    use lunamia;
    
    insert into Perfil_Usuario
    values ('camila.t29@aluno.ifsc.edu.br', null, '29102007', '(47)999887766', 'camila.t29', 'Camila', 20, 'Rua A, 1', 5),
    ('emanuela.z@aluno.ifsc.edu.br', null, '22112007', '(47)999554433', 'emanuela.z', 'Emanuela', 30, 'Rua B, 2', 30),
    ('lara.cs@aluno.ifsc.edu.br', null, '16022008', '(47)999876543', 'lara.cs', 'Lara', 25, 'Rua C, 3', 3);