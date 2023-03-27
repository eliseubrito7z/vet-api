CREATE TABLE IF NOT EXISTS `tb_staff` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) DEFAULT NULL,
  `base_salary` int NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `on_duty` bit(1) NOT NULL,
  `weekly_work_load` int DEFAULT NULL,
  `work_load_completed` int DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6gpyore2l3ir2ui0jxum3ejyt` (`cpf`),
  UNIQUE KEY `UK_hfjwdqubb4nlamvw0h5jeqoe9` (`email`),
  KEY `FK4gp0ag1qb0unxfspvvqa2itpf` (`role_id`),
  CONSTRAINT `FK4gp0ag1qb0unxfspvvqa2itpf` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_staff` (`id`, `avatar_url`, `base_salary`, `cpf`, `created_at`, 
`email`, `full_name`, `on_duty`, `weekly_work_load`, 
`work_load_completed`, `role_id`) VALUES 
(1, 
'https://github.com/eliseubrito7z.png',
20000000,
'51117623025',
'2018-09-28 00:00:00.000000',
'eliseubrito@gmail.com',
'Eliseu Brito DEV',
b'0',
2400,
null,
1
);