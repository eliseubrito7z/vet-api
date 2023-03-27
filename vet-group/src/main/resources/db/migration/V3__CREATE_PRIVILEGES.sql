CREATE TABLE IF NOT EXISTS `privilege` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `privilege` (`id`, `description`) VALUES 
    (1, 'CREATE'),
    (2, 'DELETE'),
    (3, 'READ');