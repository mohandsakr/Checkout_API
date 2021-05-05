CREATE TABLE `checkout`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL,
  `last_name` VARCHAR(255) NULL,
  `balance` DOUBLE NULL,
  `Payment_Method_id` INT NULL,
  `pin` VARCHAR(255) NULL,
  `card_number`  VARCHAR(255)  NULL,
  PRIMARY KEY (`id`));
  
