CREATE TABLE IF NOT EXISTS `tb_user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKwei10c42xhnvb2150cg5ojwi` (`role_id`),
  KEY `FKpn4njnr07hiiam9pg4pp3xan7` (`user_id`),
  CONSTRAINT `FKpn4njnr07hiiam9pg4pp3xan7` FOREIGN KEY (`user_id`) REFERENCES `tb_users` (`id`),
  CONSTRAINT `FKwei10c42xhnvb2150cg5ojwi` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tb_user_role` (`user_id`, `role_id`) VALUES (1, 1)