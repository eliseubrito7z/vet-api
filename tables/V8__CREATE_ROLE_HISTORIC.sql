CREATE TABLE IF NOT EXISTS `tb_role_historic` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `base_salary` int NOT NULL,
  `started_in` datetime(6) NOT NULL,
  `weekly_work_load` int NOT NULL,
  `promoted_by` bigint DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `staff_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71ixaabjbdkq2x6s802xawvr1` (`promoted_by`),
  KEY `FKiu3hmqk9pfhg7affmbvn0caby` (`role_id`),
  KEY `FK7jm7fxyl3bg5hw4k10g6uww0s` (`staff_id`),
  CONSTRAINT `FK71ixaabjbdkq2x6s802xawvr1` FOREIGN KEY (`promoted_by`) REFERENCES `tb_staff` (`id`),
  CONSTRAINT `FK7jm7fxyl3bg5hw4k10g6uww0s` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`),
  CONSTRAINT `FKiu3hmqk9pfhg7affmbvn0caby` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
