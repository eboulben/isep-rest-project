CREATE DATABASE IF NOT EXISTS `rest_tweets`;

DROP TABLE IF EXISTS `rest_tweets`.`tweets`;

CREATE TABLE `rest_tweets`.`tweets` (
  `id`        BIGINT      NOT NULL AUTO_INCREMENT UNIQUE,
  `id_tweets` BIGINT      NOT NULL,
  `id_author` BIGINT      NOT NULL,
  `author`    VARCHAR(50) NOT NULL,
  `message`   VARCHAR(250),
  `date`      DATETIME,
  PRIMARY KEY (`id`)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;