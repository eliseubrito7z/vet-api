CREATE TABLE IF NOT EXISTS `tb_cities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_o0fa2tlpksvcajabr7tky8tle` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_cities` (`id`, `name`) VALUES 
  (1, 'TRINDADE-PE'),
  (2, 'ARARIPINA-PE'),
  (3, 'OURICURI-PE');