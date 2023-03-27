CREATE TABLE IF NOT EXISTS `tb_reports` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `approved` bit(1) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `payment_value` int DEFAULT NULL,
  `title` varchar(70) NOT NULL,
  `type` int NOT NULL,
  `approver` bigint DEFAULT NULL,
  `created_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlugj7g9dr95wv5s5pvcj0ll3o` (`approver`),
  KEY `FKoh2engbwhk68t2u6arxiic1yj` (`created_by`),
  CONSTRAINT `FKlugj7g9dr95wv5s5pvcj0ll3o` FOREIGN KEY (`approver`) REFERENCES `tb_staff` (`id`),
  CONSTRAINT `FKoh2engbwhk68t2u6arxiic1yj` FOREIGN KEY (`created_by`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;