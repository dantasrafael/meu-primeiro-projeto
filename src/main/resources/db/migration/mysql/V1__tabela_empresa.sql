CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
	