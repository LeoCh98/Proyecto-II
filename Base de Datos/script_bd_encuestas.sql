SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bd_encuestas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bd_encuestas` ;

-- -----------------------------------------------------
-- Schema bd_encuestas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_encuestas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `bd_encuestas` ;

-- -----------------------------------------------------
-- Table `bd_encuestas`.`encuesta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_encuestas`.`encuesta` ;

CREATE TABLE IF NOT EXISTS `bd_encuestas`.`encuesta` (
  `id_encuesta` INT NOT NULL AUTO_INCREMENT,
  `fecha_creacion` TIMESTAMP NULL,
  `fecha_inicio` TIMESTAMP NULL,
  `fecha_final` TIMESTAMP NULL,
  PRIMARY KEY (`id_encuesta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `bd_encuestas`.`pregunta`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `bd_encuestas`.`pregunta` ;

CREATE TABLE IF NOT EXISTS `bd_encuestas`.`pregunta` (
	`id_pregunta` INT NOT NULL AUTO_INCREMENT,
    `id_encuesta_asignada` INT NULL,
    `categoria` VARCHAR(25) NULL,
    `enunciado` VARCHAR(125) NULL,
    PRIMARY KEY (`id_pregunta`),
  INDEX `fk_encuestas_encuesta_idx` (`id_encuesta_asignada` ASC) VISIBLE,
  CONSTRAINT `fk_encuestas_encuesta`
    FOREIGN KEY (`id_encuesta_asignada`)
    REFERENCES `bd_encuestas`.`encuesta` (`id_encuesta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `bd_encuestas`.`respuesta`
-- -----------------------------------------------------

DROP TABLE IF EXISTS `bd_encuestas`.`respuesta` ;

CREATE TABLE IF NOT EXISTS `bd_encuestas`.`respuesta` (
	`id_respuesta` INT NOT NULL AUTO_INCREMENT,
    `id_pregunta_asignada` INT NULL,
    `la_respuesta` VARCHAR(200) NULL,
    PRIMARY KEY (`id_respuesta`),
  INDEX `fk_encuestas_pregunta_idx` (`id_pregunta_asignada` ASC) VISIBLE,
  CONSTRAINT `fk_encuestas_pregunta`
    FOREIGN KEY (`id_pregunta_asignada`)
    REFERENCES `bd_encuestas`.`pregunta` (`id_pregunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;