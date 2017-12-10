-- MySQL Script generated by MySQL Workbench
-- 12/10/17 14:48:10
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema default_schema
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hotel` ;

-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8 ;
USE `hotel` ;

-- -----------------------------------------------------
-- Table `hotel`.`rooms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`rooms` ;

CREATE TABLE IF NOT EXISTS `hotel`.`rooms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NOT NULL,
  `capacity` INT NOT NULL,
  `status` VARCHAR(25) NOT NULL,
  `section` VARCHAR(25) NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel`.`guests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`guests` ;

CREATE TABLE IF NOT EXISTS `hotel`.`guests` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(15) NOT NULL,
  `surname` VARCHAR(15) NOT NULL,
  `rooms_id` INT NOT NULL,
  PRIMARY KEY (`id`, `rooms_id`),
  INDEX `fk_room_id_idx` (`rooms_id` ASC),
  CONSTRAINT `fk_guests_rooms1`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `hotel`.`rooms` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel`.`services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`services` ;

CREATE TABLE IF NOT EXISTS `hotel`.`services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `price` DOUBLE NOT NULL,
  `section` VARCHAR(25) NOT NULL,
  `start_date` DATE NOT NULL,
  `final_date` DATE NOT NULL,
  `guests_id` INT NOT NULL,
  PRIMARY KEY (`id`, `guests_id`),
  INDEX `fk_services_guests1_idx` (`guests_id` ASC),
  CONSTRAINT `fk_services_guests1`
    FOREIGN KEY (`guests_id`)
    REFERENCES `hotel`.`guests` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel`.`registrations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hotel`.`registrations` ;

CREATE TABLE IF NOT EXISTS `hotel`.`registrations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `final_date` DATE NOT NULL,
  `rooms_id` INT NOT NULL,
  `guests_id` INT NOT NULL,
  PRIMARY KEY (`id`, `rooms_id`, `guests_id`),
  INDEX `fk_registrations_rooms1_idx` (`rooms_id` ASC),
  INDEX `fk_registrations_guests1_idx` (`guests_id` ASC),
  CONSTRAINT `fk_registrations_rooms`
    FOREIGN KEY (`rooms_id`)
    REFERENCES `hotel`.`rooms` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registrations_guests`
    FOREIGN KEY (`guests_id`)
    REFERENCES `hotel`.`guests` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
