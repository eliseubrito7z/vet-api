CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `role` (`id`, `description`) VALUES 
    (1, 'CEO'),
    (2, 'GENERAL_MANAGER'),
    (3, 'MANAGER'),
    (4, 'VETERINARY'),
    (5, 'ASSISTANT'),
    (6, 'INTERN');
