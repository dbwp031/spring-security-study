CREATE TABLE IF NOT EXISTS `ch11`.`user` (
    `username` VARCHAR(45) NULL,
    `password` TEXT NULL,
    PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `ch11`.`otp`(
    `username` VARCHAR(45) NOT NULL,
    `code` VARCHAR(45) NULL,
    PRIMARY KEY (`username`)
);