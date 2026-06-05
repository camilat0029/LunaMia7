DROP DATABASE IF EXISTS `LunaMia`;

CREATE DATABASE `LunaMia`;

CREATE TABLE IF NOT EXISTS `LunaMia`.`MateriaPrima` (
  `id_estoque` INT AUTO_INCREMENT NOT NULL,
  `unidadeMedida` ENUM('metro', 'centimetro', 'litro', 'milimetro', 'unidade') NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `cor` VARCHAR(45) NULL,
  `qntDisponivel` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
   `usuario_email` VARCHAR(255),
  `qntPorUnidade` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_estoque`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Cliente` (
  `id_cliente` INT AUTO_INCREMENT NOT NULL,
  `nomeCliente` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(13) NULL,
  `email` VARCHAR(64) NULL,
  PRIMARY KEY (`id_cliente`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Perfil_Usuario` (
  `email` VARCHAR(64) NOT NULL,
  `fotoPerfil` VARCHAR(1000) NULL,
  `senha` VARCHAR(12) NOT NULL,
  `nrTelefone` VARCHAR(15) NULL,
  `nomeUsuario` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `precoHora` DECIMAL(10,2) NOT NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `estado` VARCHAR(50) NOT NULL,
  `percentualLucro` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`email`, `nomeUsuario`));

CREATE TABLE IF NOT EXISTS `LunaMia`.`Orcamento` (
  `id_orcamento` INT AUTO_INCREMENT NOT NULL,
  `tituloPedido` VARCHAR(45) NOT NULL,
  `statusPedido` ENUM('concluido', 'andamento', 'pendente') NOT NULL,
  `precoHora` DECIMAL(10,2) NOT NULL,
  `percentualLucro` DECIMAL(10,2) NOT NULL,
  `quantHrs` INT NOT NULL,
  `quantDiasPedido` INT NOT NULL,
  `Perfil_Usuario_email` VARCHAR(64) NOT NULL,
  `Perfil_Usuario_nomeUsuario` VARCHAR(50) NOT NULL,
  `Cliente_id_cliente` INT NOT NULL,
  `valorAdicional` DECIMAL(10,2) NULL,
  `valorGastos` DECIMAL(10,2) NOT NULL,
  `valorSemLucro` DECIMAL(10,2) NOT NULL,
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
  `formaPagam` VARCHAR(45) NULL,
  `dataPrevisaoEnt` DATE NULL,
  `dataConfirmacao` DATE NULL,
  `id_orcamento` INT NOT NULL,
  `valorVenda` DECIMAL(10,2) not null,
  `lucroTotalObtido` DECIMAL(10,2) not null,
   
  PRIMARY KEY (`id_orcamento`),
  CONSTRAINT `fk_Confirmação_de_orcaçamento_Orcamento`
    FOREIGN KEY (`id_orcamento`)
    REFERENCES `Orcamento` (`id_orcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `LunaMia`.`OrcamentoProduto` (
  `id_orcamento` INT NOT NULL,
  `id_estoque` INT NOT NULL,
  `quantidade` INT NOT NULL,
 
  PRIMARY KEY (`id_estoque`, `id_orcamento`),
  INDEX `fk_Confirmacao_de_orcamento_has_MateriaPrima_MateriaPrima_idx` (`id_estoque` ASC),
  INDEX `fk_Confirmacao_de_orcamento_has_MateriaPrima_Confirmacao__idx` (`id_orcamento` ASC),
  CONSTRAINT `fk_Confirmacao_de_orcamento_has_MateriaPrima_Confirmacao_de1`
    FOREIGN KEY (`id_orcamento`)
    REFERENCES `LunaMia`.`Confirmacao_de_orcamento` (`id_orcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Confirmacao_de_orcamento_has_MateriaPrima_MateriaPrima1`
    FOREIGN KEY (`id_estoque`)
    REFERENCES `LunaMia`.`MateriaPrima` (`id_estoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
   
    use lunamia;
   
    insert into Perfil_Usuario
    values ('camila.t29@aluno.ifsc.edu.br', null, '29102007', '(47) 99988-7766', 'camila.t29', 'Camila', 20, 'Gaspar', 'SC', 5),
    ('emanuela.z@aluno.ifsc.edu.br', null, '22112007', '(47) 99955-4433', 'emanuela.z', 'Emanuela', 30, 'Ilhota', 'SC', 30),
    ('lara.cs@aluno.ifsc.edu.br', null, '16022008', '(47) 99987-6543', 'lara.cs', 'Lara', 25, 'Gaspar', 'SC',  3);
   
    insert into MateriaPrima
    values(null, 'metro', 10, 'Circulo', 'azul', 5, 'Linha', 'camila.t29@aluno.ifsc.edu.br', 100),
    (null, 'metro', 15, 'Circulo2', 'azul2', 10, 'Linha2', 'camila.t29@aluno.ifsc.edu.br', 200),
    (null, 'centimetro', 20, 'Circulo3', 'azul3', 15, 'Linha3', 'camila.t29@aluno.ifsc.edu.br',300),
    (null, 'milimetro', 25, 'Circulo4', 'azul4', 20, 'Linha4', 'camila.t29@aluno.ifsc.edu.br', 400),
    (null, 'metro', 30, 'Circulo5', 'azul5', 25, 'Linha5', 'camila.t29@aluno.ifsc.edu.br', 500),
    (null, 'metro', 35, 'Circulo6', 'azul6', 30, 'Linha6', 'camila.t29@aluno.ifsc.edu.br', 600),
    (null, 'metro', 40, 'Circulo7', 'azul7', 35, 'Linha7', 'camila.t29@aluno.ifsc.edu.br', 700);
   
    select * from Cliente;
    
    