DROP TABLE IF EXISTS person;
CREATE TABLE `person`
(
    `id`         INT                                NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50)                        NOT NULL,
    `last_name`  VARCHAR(50)                        NOT NULL,
    `version`    INT      DEFAULT 1                 NOT NULL,
    `added`      DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    `modified`   DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `person_firstname_lastname_unique` (`first_name`, last_name)
);