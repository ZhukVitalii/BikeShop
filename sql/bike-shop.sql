CREATE DATABASE  IF NOT EXISTS `velikone` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `velikone`;
-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: velikone
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

LOCK TABLES `DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('17.02.2020_zhuk_vs_modify_frames_id','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',1,'EXECUTED','7:dcd320adf5bc04693975fd67c7e32cf9','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_add_manufacturer','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',2,'EXECUTED','7:bf98d034bf6cebea3b555c919bbfaa82','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_add_to_frame','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',3,'EXECUTED','7:2df599eaf40b823af2c69e34209f66e9','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_FK_handlebar','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',4,'EXECUTED','7:1acbe8cb030f64d36e31f1b1eb091ae2','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_INDEX_handlebar','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',5,'EXECUTED','7:ab0ea9f156e4e10e7888363ed13fa224','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_change_column_handlebar','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',6,'EXECUTED','7:c6aa4dfd57e13eaca86031910b2680e1','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_FK_brake_handle','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',7,'EXECUTED','7:94ad1bdd42dd6c83d37257f586b0a490','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_INDEX_brake_handle','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',8,'EXECUTED','7:e84a7aabc6b8914d32fd769974cef290','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('17.02.2020_zhuk_vs_remove_change_column_brake_handle','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-17 19:04:54',9,'EXECUTED','7:33ae820df6b971f8bab6a6a2be313ba3','sql','',NULL,'3.5.4',NULL,NULL,'1959094014'),('18.02.2020_zhuk_vs_remove_FK_frame','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-19 14:00:29',10,'EXECUTED','7:3bfb78155a8b1bcf5e3773101634b050','sql','',NULL,'3.5.4',NULL,NULL,'2113629232'),('18.02.2020_zhuk_vs_remove_INDEX_frame','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-19 14:00:29',11,'EXECUTED','7:b6e1f4d903da4e62c8a9a60e851d6a3e','sql','',NULL,'3.5.4',NULL,NULL,'2113629232'),('17.02.2020_zhuk_vs_remove_change_column_frame','zhuk_vs','db/changelog/db.changelog-master.yaml','2020-02-19 14:00:29',12,'EXECUTED','7:f862c3b08aa20a8c62ebdcab2b97fdca','sql','',NULL,'3.5.4',NULL,NULL,'2113629232'),('21.02.2020_modify_frame_sise_types','zhuk_vs','/db/changelog/changes/db.changelog-create-db.xml','2020-03-03 15:32:23',13,'EXECUTED','7:664e129ad717e03c0283f1870a7251d9','sql','',NULL,'3.5.4',NULL,NULL,'3242343536'),('21.02.2020_create_table_frame_sizes','zhuk_vs','/db/changelog/changes/db.changelog-create-db.xml','2020-03-03 15:32:23',14,'EXECUTED','7:22d76818aaa3893938a790b88489d169','sql','',NULL,'3.5.4',NULL,NULL,'3242343536'),('21.02.2020_insert_to_frame_sise_types','zhuk_vs','/db/changelog/changes/db.changelog-insert.xml','2020-03-03 15:32:23',15,'EXECUTED','7:bf8c05eace4f521f2075fc4cdff66fb5','insert tableName=frame_size_type','',NULL,'3.5.4',NULL,NULL,'3242343536'),('21.02.2020_insert_to_frame_size_types','zhuk_vs','/db/changelog/changes/db.changelog-insert.xml','2020-03-03 15:32:23',16,'EXECUTED','7:d39e87fac67e2646ae0df96e5f0c2a07','insert tableName=frame_size_type; insert tableName=frame_size_type','',NULL,'3.5.4',NULL,NULL,'3242343536'),('21.02.2020_insert_into_frame_sizes','zhuk_vs','/db/changelog/changes/db.changelog-test-insert.xml','2020-03-03 15:32:23',17,'EXECUTED','7:cea8a616c445bce3be18f7001e9b5938','sql','',NULL,'3.5.4',NULL,NULL,'3242343536');
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

LOCK TABLES `DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `axis_diams`
--

DROP TABLE IF EXISTS `axis_diams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `axis_diams` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `axis_diams`
--

LOCK TABLES `axis_diams` WRITE;
/*!40000 ALTER TABLE `axis_diams` DISABLE KEYS */;
INSERT INTO `axis_diams` VALUES (1,'9'),(2,'10'),(3,'12'),(4,'14'),(5,'15'),(6,'20');
/*!40000 ALTER TABLE `axis_diams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `axis_lengths`
--

DROP TABLE IF EXISTS `axis_lengths`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `axis_lengths` (
  `id` bigint(20) NOT NULL,
  `length` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `axis_lengths`
--

LOCK TABLES `axis_lengths` WRITE;
/*!40000 ALTER TABLE `axis_lengths` DISABLE KEYS */;
INSERT INTO `axis_lengths` VALUES (1,'145 мм'),(2,'109 мм');
/*!40000 ALTER TABLE `axis_lengths` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_derailleurs`
--

DROP TABLE IF EXISTS `back_derailleurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_derailleurs` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `back_sproc_max_id` bigint(20) DEFAULT NULL,
  `back_sproc_min_id` bigint(20) DEFAULT NULL,
  `back_sproc_num_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `pow_length_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgxyjyk9aaes0qdkrh1kyf4g3p` (`back_sproc_max_id`),
  KEY `FKin2gr20yw64577yaobygbl15w` (`back_sproc_min_id`),
  KEY `FKds0d5w4hl54pwdn0q17hs46qt` (`back_sproc_num_id`),
  KEY `FKhbml9i3fn5enk3vubyw7k2vp9` (`maker_id`),
  KEY `FK96pbvv4kvr5g9e7bbhcqsu4j7` (`pow_length_id`),
  CONSTRAINT `FK96pbvv4kvr5g9e7bbhcqsu4j7` FOREIGN KEY (`pow_length_id`) REFERENCES `paw_lengths` (`id`),
  CONSTRAINT `FKds0d5w4hl54pwdn0q17hs46qt` FOREIGN KEY (`back_sproc_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FKgxyjyk9aaes0qdkrh1kyf4g3p` FOREIGN KEY (`back_sproc_max_id`) REFERENCES `back_sprocket_maxs` (`id`),
  CONSTRAINT `FKhbml9i3fn5enk3vubyw7k2vp9` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKin2gr20yw64577yaobygbl15w` FOREIGN KEY (`back_sproc_min_id`) REFERENCES `back_sprocket_mins` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_derailleurs`
--

LOCK TABLES `back_derailleurs` WRITE;
/*!40000 ALTER TABLE `back_derailleurs` DISABLE KEYS */;
INSERT INTO `back_derailleurs` VALUES (1,701,'Чорний','Задня перекидка Shimano RD-M390 ACERA black',' Алюміній/сталь/пластик','Shimano RD-M390 ACERA',680,'Shimano_RD-M390_ACERA','/resources/images/back_derailleur_shimano_rd-m390.jpg','290 г',13,2,4,2,3),(2,702,'Чорний','Задня перекидка Sram x-5',' Алюміній/сталь/пластик','Sram x-5',680,'Sram_x-5','/resources/images/back_derailleur_sram-x-5.jpg','290 г',14,2,4,1,3),(3,703,'Чорний','Задня перекидка Shimano RD-M360 ACERA black',' Алюміній/пластик','Shimano RD-M360 ACERA',450,'Shimano_RD-M360_ACERA','/resources/images/back_derailleur_shimano_rd-m-360.jpg','290 г',14,2,3,2,2);
/*!40000 ALTER TABLE `back_derailleurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_gear_kass`
--

DROP TABLE IF EXISTS `back_gear_kass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_gear_kass` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `back_spr_max_id` bigint(20) DEFAULT NULL,
  `back_spr_min_id` bigint(20) DEFAULT NULL,
  `back_spr_num_id` bigint(20) DEFAULT NULL,
  `back_spr_size_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30jgoqqby2kfc0ut7kfu85jvs` (`back_spr_max_id`),
  KEY `FKkfpfceq9ttvg3abc9ebk9u7d` (`back_spr_min_id`),
  KEY `FKtfc6pulsjj6f5r80ossmmdmv7` (`back_spr_num_id`),
  KEY `FKh3slmrmnjridjkdhei87mftne` (`back_spr_size_id`),
  KEY `FKeakh5bqjrqtxkq6bwyc82l3gs` (`maker_id`),
  CONSTRAINT `FK30jgoqqby2kfc0ut7kfu85jvs` FOREIGN KEY (`back_spr_max_id`) REFERENCES `back_sprocket_maxs` (`id`),
  CONSTRAINT `FKeakh5bqjrqtxkq6bwyc82l3gs` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKh3slmrmnjridjkdhei87mftne` FOREIGN KEY (`back_spr_size_id`) REFERENCES `back_sprocket_sizes` (`id`),
  CONSTRAINT `FKkfpfceq9ttvg3abc9ebk9u7d` FOREIGN KEY (`back_spr_min_id`) REFERENCES `back_sprocket_mins` (`id`),
  CONSTRAINT `FKtfc6pulsjj6f5r80ossmmdmv7` FOREIGN KEY (`back_spr_num_id`) REFERENCES `back_sprocket_numbers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_gear_kass`
--

LOCK TABLES `back_gear_kass` WRITE;
/*!40000 ALTER TABLE `back_gear_kass` DISABLE KEYS */;
INSERT INTO `back_gear_kass` VALUES (1,501,'Срібло','Полегшена касета Shimano для 9 швидкісних трасмісій.','Сталь','Shimano CS-HG300-9',600,' Shimano_CS-HG300-9','/resources/images/backSprocketKas_Shimano_9.jpg',14,2,4,9,2),(2,502,'Срібло','Полегшена касетa CS-HG41 для 8 швидкісних трасмісій','Сталь','Shimano Alivio CS-HG51 11-28 ',500,'Shimano_Alivio_CS-HG51_11-28 ','/resources/images/backSprocketKas_Shimano_8.jpg',8,2,3,7,2),(3,503,'Срібло',' Касета Sram PG-990 11-34 9 зірок','Сталь','Sram PG-990',600,'Sram_PG-990','/resources/images/backSprocketKas_Sram_9.jpg',14,2,4,9,1);
/*!40000 ALTER TABLE `back_gear_kass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_gear_trs`
--

DROP TABLE IF EXISTS `back_gear_trs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_gear_trs` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `back_spr_max_id` bigint(20) DEFAULT NULL,
  `back_spr_min_id` bigint(20) DEFAULT NULL,
  `back_spr_num_id` bigint(20) DEFAULT NULL,
  `back_spr_size_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl7kt0j0lh6k4r3b3y59b1edb0` (`back_spr_max_id`),
  KEY `FKbvvgbiweo8v85ryguiaa1cn9d` (`back_spr_min_id`),
  KEY `FKd82t3319slohrtrk6ex71ynsm` (`back_spr_num_id`),
  KEY `FKdfvw008kcd2sofhqufmf22tsp` (`back_spr_size_id`),
  KEY `FKbvh2c1w9hh4io3xgnoef96kfj` (`maker_id`),
  CONSTRAINT `FKbvh2c1w9hh4io3xgnoef96kfj` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKbvvgbiweo8v85ryguiaa1cn9d` FOREIGN KEY (`back_spr_min_id`) REFERENCES `back_sprocket_mins` (`id`),
  CONSTRAINT `FKd82t3319slohrtrk6ex71ynsm` FOREIGN KEY (`back_spr_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FKdfvw008kcd2sofhqufmf22tsp` FOREIGN KEY (`back_spr_size_id`) REFERENCES `back_sprocket_sizes` (`id`),
  CONSTRAINT `FKl7kt0j0lh6k4r3b3y59b1edb0` FOREIGN KEY (`back_spr_max_id`) REFERENCES `back_sprocket_maxs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_gear_trs`
--

LOCK TABLES `back_gear_trs` WRITE;
/*!40000 ALTER TABLE `back_gear_trs` DISABLE KEYS */;
INSERT INTO `back_gear_trs` VALUES (1,601,'Чорний','Трещітка Shimano MF-TZ31 MEGA RANGE 14-34, 7 зірок, для некасетний втулок','Сталь','Shimano MF-TZ31 MEGA RANGE',350,'Shimano_MF-TZ31_MEGA_RANGE','/resources/images/backGearTr_Shimano_7.jpg',14,5,2,29,2);
/*!40000 ALTER TABLE `back_gear_trs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_hubs`
--

DROP TABLE IF EXISTS `back_hubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_hubs` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `axis_diam_id` bigint(20) DEFAULT NULL,
  `axis_length_id` bigint(20) DEFAULT NULL,
  `spr_num_id` bigint(20) DEFAULT NULL,
  `spr_type_id` bigint(20) DEFAULT NULL,
  `bearing_type_id` bigint(20) DEFAULT NULL,
  `brakes_type_id` bigint(20) DEFAULT NULL,
  `fix_type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rot_fix_id` bigint(20) DEFAULT NULL,
  `spoke_num_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt8r588e6n0ctab55l029uxlfy` (`axis_diam_id`),
  KEY `FK84knji0b539cqsmkjksyg1kgn` (`axis_length_id`),
  KEY `FKiwsw8qdbenlfn8x16nh8ogwg2` (`spr_num_id`),
  KEY `FKt5s41ll11arsrdu8qljeh6eow` (`spr_type_id`),
  KEY `FKonyeskljoesnwyhjuvj7f5gbx` (`bearing_type_id`),
  KEY `FKj9p6xram0r00u406b3kw6r038` (`brakes_type_id`),
  KEY `FKo3pp1qae8jks8uwq0sggd0g9y` (`fix_type_id`),
  KEY `FKbiq1tj43vqo12smmhyg29d7gw` (`maker_id`),
  KEY `FKikct4qc2fc3qk9kt9v67hipxk` (`rot_fix_id`),
  KEY `FKt63tgi6c6o8xh71xkbnrl8jwo` (`spoke_num_id`),
  CONSTRAINT `FK84knji0b539cqsmkjksyg1kgn` FOREIGN KEY (`axis_length_id`) REFERENCES `axis_lengths` (`id`),
  CONSTRAINT `FKbiq1tj43vqo12smmhyg29d7gw` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKikct4qc2fc3qk9kt9v67hipxk` FOREIGN KEY (`rot_fix_id`) REFERENCES `rotor_fix_types` (`id`),
  CONSTRAINT `FKiwsw8qdbenlfn8x16nh8ogwg2` FOREIGN KEY (`spr_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FKj9p6xram0r00u406b3kw6r038` FOREIGN KEY (`brakes_type_id`) REFERENCES `brakes_types` (`id`),
  CONSTRAINT `FKo3pp1qae8jks8uwq0sggd0g9y` FOREIGN KEY (`fix_type_id`) REFERENCES `hum_fix_types` (`id`),
  CONSTRAINT `FKonyeskljoesnwyhjuvj7f5gbx` FOREIGN KEY (`bearing_type_id`) REFERENCES `bearing_types` (`id`),
  CONSTRAINT `FKt5s41ll11arsrdu8qljeh6eow` FOREIGN KEY (`spr_type_id`) REFERENCES `back_sprocket_types` (`id`),
  CONSTRAINT `FKt63tgi6c6o8xh71xkbnrl8jwo` FOREIGN KEY (`spoke_num_id`) REFERENCES `spoke_numbers` (`id`),
  CONSTRAINT `FKt8r588e6n0ctab55l029uxlfy` FOREIGN KEY (`axis_diam_id`) REFERENCES `axis_diams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_hubs`
--

LOCK TABLES `back_hubs` WRITE;
/*!40000 ALTER TABLE `back_hubs` DISABLE KEYS */;
INSERT INTO `back_hubs` VALUES (1,2001,'Чорний','Універсальні дискові втулки SRAM MTB 506 для MTB','Алюмінієвий корпус, стальний барабан','SRAM MTB 506',1000.3,'SRAM_MTB_506','/resources/images/back_hub_Sram.jpg','420г',1,1,3,1,2,2,1,2,1,2);
/*!40000 ALTER TABLE `back_hubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_sprocket_maxs`
--

DROP TABLE IF EXISTS `back_sprocket_maxs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_sprocket_maxs` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_sprocket_maxs`
--

LOCK TABLES `back_sprocket_maxs` WRITE;
/*!40000 ALTER TABLE `back_sprocket_maxs` DISABLE KEYS */;
INSERT INTO `back_sprocket_maxs` VALUES (1,'21'),(2,'22'),(3,'23'),(4,'24'),(5,'25'),(6,'26'),(7,'27'),(8,'28'),(9,'29'),(10,'30'),(11,'31'),(12,'32'),(13,'33'),(14,'34'),(15,'35'),(16,'36');
/*!40000 ALTER TABLE `back_sprocket_maxs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_sprocket_mins`
--

DROP TABLE IF EXISTS `back_sprocket_mins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_sprocket_mins` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_sprocket_mins`
--

LOCK TABLES `back_sprocket_mins` WRITE;
/*!40000 ALTER TABLE `back_sprocket_mins` DISABLE KEYS */;
INSERT INTO `back_sprocket_mins` VALUES (1,'10'),(2,'11'),(3,'12'),(4,'13'),(5,'14'),(6,'15'),(7,'16');
/*!40000 ALTER TABLE `back_sprocket_mins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_sprocket_numbers`
--

DROP TABLE IF EXISTS `back_sprocket_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_sprocket_numbers` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_sprocket_numbers`
--

LOCK TABLES `back_sprocket_numbers` WRITE;
/*!40000 ALTER TABLE `back_sprocket_numbers` DISABLE KEYS */;
INSERT INTO `back_sprocket_numbers` VALUES (1,'6'),(2,'7'),(3,'8'),(4,'9'),(5,'10'),(6,'11');
/*!40000 ALTER TABLE `back_sprocket_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_sprocket_sizes`
--

DROP TABLE IF EXISTS `back_sprocket_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_sprocket_sizes` (
  `id` bigint(20) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_sprocket_sizes`
--

LOCK TABLES `back_sprocket_sizes` WRITE;
/*!40000 ALTER TABLE `back_sprocket_sizes` DISABLE KEYS */;
INSERT INTO `back_sprocket_sizes` VALUES (1,'10-24'),(2,'10-42'),(3,'11-21'),(4,'11-23'),(5,'11-25'),(6,'11-26'),(7,'11-28'),(8,'11-30'),(9,'11-34'),(10,'11-36'),(11,'11-40'),(12,'11-42'),(13,'12-21'),(14,'12-22'),(15,'12-23'),(16,'12-24'),(17,'12-25'),(18,'12-26'),(19,'12-27'),(20,'12-32'),(21,'12-36'),(22,'13-23'),(23,'13-24'),(24,'13-25'),(25,'13-26'),(26,'13-28'),(27,'14-25'),(28,'14-28'),(29,'14-34');
/*!40000 ALTER TABLE `back_sprocket_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `back_sprocket_types`
--

DROP TABLE IF EXISTS `back_sprocket_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `back_sprocket_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `back_sprocket_types`
--

LOCK TABLES `back_sprocket_types` WRITE;
/*!40000 ALTER TABLE `back_sprocket_types` DISABLE KEYS */;
INSERT INTO `back_sprocket_types` VALUES (1,'Під касету'),(2,'Під трещітку');
/*!40000 ALTER TABLE `back_sprocket_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bearing_types`
--

DROP TABLE IF EXISTS `bearing_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bearing_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bearing_types`
--

LOCK TABLES `bearing_types` WRITE;
/*!40000 ALTER TABLE `bearing_types` DISABLE KEYS */;
INSERT INTO `bearing_types` VALUES (1,'Промислові'),(2,'Насипні');
/*!40000 ALTER TABLE `bearing_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike_types`
--

DROP TABLE IF EXISTS `bike_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bike_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike_types`
--

LOCK TABLES `bike_types` WRITE;
/*!40000 ALTER TABLE `bike_types` DISABLE KEYS */;
INSERT INTO `bike_types` VALUES (1,'MTB'),(2,'SHOSSE'),(3,'CITY');
/*!40000 ALTER TABLE `bike_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bracket_axis_lengths`
--

DROP TABLE IF EXISTS `bracket_axis_lengths`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bracket_axis_lengths` (
  `id` bigint(20) NOT NULL,
  `length` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bracket_axis_lengths`
--

LOCK TABLES `bracket_axis_lengths` WRITE;
/*!40000 ALTER TABLE `bracket_axis_lengths` DISABLE KEYS */;
INSERT INTO `bracket_axis_lengths` VALUES (1,'107'),(2,'110'),(3,'113'),(4,'117'),(5,'118'),(6,'120'),(7,'121'),(8,'122'),(9,'126'),(10,'127'),(11,'123'),(12,'108');
/*!40000 ALTER TABLE `bracket_axis_lengths` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bracket_diams`
--

DROP TABLE IF EXISTS `bracket_diams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bracket_diams` (
  `id` bigint(20) NOT NULL,
  `wide` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bracket_diams`
--

LOCK TABLES `bracket_diams` WRITE;
/*!40000 ALTER TABLE `bracket_diams` DISABLE KEYS */;
INSERT INTO `bracket_diams` VALUES (1,'68'),(2,'73'),(3,'83'),(4,'100');
/*!40000 ALTER TABLE `bracket_diams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bracket_types`
--

DROP TABLE IF EXISTS `bracket_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bracket_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bracket_types`
--

LOCK TABLES `bracket_types` WRITE;
/*!40000 ALTER TABLE `bracket_types` DISABLE KEYS */;
INSERT INTO `bracket_types` VALUES (1,'Square'),(2,'Octalink'),(4,'ISIS'),(5,'Truvativ PowerSpline'),(6,'Truvativ Howitzer');
/*!40000 ALTER TABLE `bracket_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brackets`
--

DROP TABLE IF EXISTS `brackets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brackets` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `axisMaterial` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `bearing_type_id` bigint(20) DEFAULT NULL,
  `brac_axis_length_id` bigint(20) DEFAULT NULL,
  `bracket_type_id` bigint(20) DEFAULT NULL,
  `bracket_wide_id` bigint(20) DEFAULT NULL,
  `carving_type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd3m57xie4l36umwrs0mi6ylpp` (`bearing_type_id`),
  KEY `FKkef6vfc25eb30fa7erx4ie5g` (`brac_axis_length_id`),
  KEY `FKej74rtr908yp9n6xhqbsnsy64` (`bracket_type_id`),
  KEY `FKmliwvwtokw7162xg0977djcia` (`bracket_wide_id`),
  KEY `FKqmm6m88em7vx7jtlsq6xdnm1d` (`carving_type_id`),
  KEY `FKh8q07p62odryd8wr8luq1iihn` (`maker_id`),
  CONSTRAINT `FKd3m57xie4l36umwrs0mi6ylpp` FOREIGN KEY (`bearing_type_id`) REFERENCES `bearing_types` (`id`),
  CONSTRAINT `FKej74rtr908yp9n6xhqbsnsy64` FOREIGN KEY (`bracket_type_id`) REFERENCES `bracket_types` (`id`),
  CONSTRAINT `FKh8q07p62odryd8wr8luq1iihn` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKkef6vfc25eb30fa7erx4ie5g` FOREIGN KEY (`brac_axis_length_id`) REFERENCES `bracket_axis_lengths` (`id`),
  CONSTRAINT `FKmliwvwtokw7162xg0977djcia` FOREIGN KEY (`bracket_wide_id`) REFERENCES `bracket_diams` (`id`),
  CONSTRAINT `FKqmm6m88em7vx7jtlsq6xdnm1d` FOREIGN KEY (`carving_type_id`) REFERENCES `carving_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brackets`
--

LOCK TABLES `brackets` WRITE;
/*!40000 ALTER TABLE `brackets` DISABLE KEYS */;
INSERT INTO `brackets` VALUES (-6,306,'Сталь','Чорний','Каретка Shimano BB-ES300 OCTALINK,BSA 73MM-118,','Shimano BB-ES300 OCTALINK',350,'Shimano_BB-ES300_OCTALINK_73MM-118','/resources/images/bracketOctalink73.jpg',1,5,2,2,1,2),(-5,305,'Сталь','Чорний','Каретка Shimano BB-ES300 OCTALINK,BSA 68MM-113,','Shimano BB-ES300 OCTALINK',350,'Shimano_BB-ES300_OCTALINK_68MM-113','/resources/images/bracketOctalink68.jpg',1,3,2,1,1,2),(-4,304,'Сталь','Чорний','Недорога надійна каретка з фірмовим шліцевим кріпленням.','TRUVATIV POWER SPLINE 73х118',750,'TRUVATIV_POWER_SPLINE_118/73','/resources/images/bracketTruvativ73.jpg',1,5,5,2,1,5),(-3,303,'Сталь','Чорний','Недорога надійна каретка з фірмовим шліцевим кріпленням.','TRUVATIV POWER SPLINE 68х108',750,'TRUVATIV_POWER_SPLINE_108/68','/resources/images/bracketTruvativ68.jpg',1,12,5,1,1,5),(1,301,'Сталь','Чорний','Картридж каретки Shimano Alivio BB-UN26 BSA 117 мм','Shimano Alivio BB-UN26 68x117',306,'Shimano_Alivio_BB-UN26_68','/resources/images/bracketShimano68.jpg',1,4,1,1,1,2),(2,302,'Сталь','Чорний','Картридж каретки Shimano Alivio BB-UN26 BSA 73х123 мм','Shimano Alivio BB-UN26 73x123',350,'Shimano_Alivio_BB-UN26_73','/resources/images/bracketShimano73.jpg',1,11,1,2,1,2);
/*!40000 ALTER TABLE `brackets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_disc_hydraulics`
--

DROP TABLE IF EXISTS `brake_disc_hydraulics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_disc_hydraulics` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `brakeWeight` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `materialHandle` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rotorWeight` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `brake_liquid_id` bigint(20) DEFAULT NULL,
  `length_line_id` bigint(20) DEFAULT NULL,
  `loc_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rotor_diam_id` bigint(20) DEFAULT NULL,
  `rotor_fix_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhglyyesqmq4xj37uqbbmx5yk` (`brake_liquid_id`),
  KEY `FK5aer1octax66mumu56jpwfw56` (`length_line_id`),
  KEY `FKmcuvdw4fyus1a1e65rhmo6o1i` (`loc_id`),
  KEY `FKgc9ed4lc4glcqm4qbnstmu731` (`maker_id`),
  KEY `FKg57fum7pfmiho0gqkkuwy81kf` (`rotor_diam_id`),
  KEY `FKdkqthkxs15ylfsbnodckt7r0w` (`rotor_fix_type_id`),
  CONSTRAINT `FK5aer1octax66mumu56jpwfw56` FOREIGN KEY (`length_line_id`) REFERENCES `length_hydrolines` (`id`),
  CONSTRAINT `FKdkqthkxs15ylfsbnodckt7r0w` FOREIGN KEY (`rotor_fix_type_id`) REFERENCES `rotor_fix_types` (`id`),
  CONSTRAINT `FKg57fum7pfmiho0gqkkuwy81kf` FOREIGN KEY (`rotor_diam_id`) REFERENCES `rotor_diams` (`id`),
  CONSTRAINT `FKgc9ed4lc4glcqm4qbnstmu731` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKmcuvdw4fyus1a1e65rhmo6o1i` FOREIGN KEY (`loc_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FKqhglyyesqmq4xj37uqbbmx5yk` FOREIGN KEY (`brake_liquid_id`) REFERENCES `brake_liquids` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_disc_hydraulics`
--

LOCK TABLES `brake_disc_hydraulics` WRITE;
/*!40000 ALTER TABLE `brake_disc_hydraulics` DISABLE KEYS */;
INSERT INTO `brake_disc_hydraulics` VALUES (1,1101,'311 г','Чорний','Дисковий гидравлічний тормоз Tektro DRACO 2-F-180 передній \nз двупоршневим принципом дії.Адаптер та ротор TR 180-8 в комплекті',' ','Алюміній','Tektro DRACO 2-F-180',1369,'110 г','Tektro_DRACO_2-F-180','/resources/images/tektro-Disc-Hydraulik-Front.jpg',1,1,1,3,4,1),(2,1102,'311 г','Чорний','Дисковый гидравлический тормоз Tektro Draco 2-F-160 задній\nвелосипедний гидравлічний тормоз с двупоршневим принципом дії\nтормозная ручка під 2 пальці\nметало-керамічні колодки\nрегулювання ходу ручки\nадаптер AQ1.0 та ротор TR 160-8 в комплекті',' ','Алюміній','Tektro DRACO 2-F-180',1400,'110 г','Tektro_DRACO_2-F-160','/resources/images/tektro-Disc-Hydraulik-back.jpg',1,10,2,3,4,1),(3,1103,'350 г','Чорний','Дисковый гидравлический тормоз комплект Shimano M4050 задній ',' ','Дюраль','Shimano M4050',1200,'110 г','Shimano_M4050','/resources/images/brake_Shimano_Hydro_Back.jpg',1,12,2,1,4,1);
/*!40000 ALTER TABLE `brake_disc_hydraulics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_disc_mechaniks`
--

DROP TABLE IF EXISTS `brake_disc_mechaniks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_disc_mechaniks` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `brakeWeight` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `materialBrake` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rotorWeight` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `loc_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rotor_diam_id` bigint(20) DEFAULT NULL,
  `rotor_fix_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc4iq6j9qh4uonx79igf75uo1c` (`loc_id`),
  KEY `FK1sse1lqfjpwglrvfgvabdury3` (`maker_id`),
  KEY `FKsfeb3006it4e4xlb1sngew3rv` (`rotor_diam_id`),
  KEY `FK4a4mxwwstxhihof19uny32bm` (`rotor_fix_type_id`),
  CONSTRAINT `FK1sse1lqfjpwglrvfgvabdury3` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FK4a4mxwwstxhihof19uny32bm` FOREIGN KEY (`rotor_fix_type_id`) REFERENCES `rotor_fix_types` (`id`),
  CONSTRAINT `FKc4iq6j9qh4uonx79igf75uo1c` FOREIGN KEY (`loc_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FKsfeb3006it4e4xlb1sngew3rv` FOREIGN KEY (`rotor_diam_id`) REFERENCES `rotor_diams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_disc_mechaniks`
--

LOCK TABLES `brake_disc_mechaniks` WRITE;
/*!40000 ALTER TABLE `brake_disc_mechaniks` DISABLE KEYS */;
INSERT INTO `brake_disc_mechaniks` VALUES (1,1104,'315','Сірий','Передній тормоз дисковий механічний AVID BB7 160мм.',' ','AVID BB7 передній 160мм',2069,'110 г','AVID_BB7_160','/resources/images/brakes_avid_mech_front.jpg',1,4,2,1),(2,1105,'310','Чорний','Передній тормоз дисковий механічний Tektro Aquila  160мм.',' ','Tektro Aquila передній 160мм',850,'110 г','Tektro_Aquila_160','/resources/images/tektro-Disc-Mech-Front.jpg',1,3,2,1),(3,1106,'315','Сірий','Задній тормоз дисковий механічний AVID BB7 160мм.',' ','AVID BB7 задній 160мм',2069,'110 г','AVID_BB7_160_back','/resources/images/brakes_avid_mech_front.jpg',2,4,2,1),(4,1107,'310','Чорний','Задній тормоз дисковий механічний Tektro Aquila  160мм.',' ','Tektro Aquila задній 160мм',850,'110 г','Tektro_Aquila_160_back','/resources/images/tektro-Disc-Mech-Front.jpg',2,3,2,1);
/*!40000 ALTER TABLE `brake_disc_mechaniks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_handle_compatibilitys`
--

DROP TABLE IF EXISTS `brake_handle_compatibilitys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_handle_compatibilitys` (
  `id` bigint(20) NOT NULL,
  `comp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_handle_compatibilitys`
--

LOCK TABLES `brake_handle_compatibilitys` WRITE;
/*!40000 ALTER TABLE `brake_handle_compatibilitys` DISABLE KEYS */;
INSERT INTO `brake_handle_compatibilitys` VALUES (1,'Дискові гідравлічні'),(2,'Дискові механічні'),(3,'Ободні(V-brake)'),(4,'Механічні дискові/ободні');
/*!40000 ALTER TABLE `brake_handle_compatibilitys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_handle_locations`
--

DROP TABLE IF EXISTS `brake_handle_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_handle_locations` (
  `id` bigint(20) NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_handle_locations`
--

LOCK TABLES `brake_handle_locations` WRITE;
/*!40000 ALTER TABLE `brake_handle_locations` DISABLE KEYS */;
INSERT INTO `brake_handle_locations` VALUES (1,'Ліва'),(2,'Права'),(3,'Комплект');
/*!40000 ALTER TABLE `brake_handle_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_handle_wides`
--

DROP TABLE IF EXISTS `brake_handle_wides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_handle_wides` (
  `id` bigint(20) NOT NULL,
  `wide` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_handle_wides`
--

LOCK TABLES `brake_handle_wides` WRITE;
/*!40000 ALTER TABLE `brake_handle_wides` DISABLE KEYS */;
INSERT INTO `brake_handle_wides` VALUES (1,'2 пальці'),(2,'3 пальці'),(3,'4 пальці');
/*!40000 ALTER TABLE `brake_handle_wides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_handles`
--

DROP TABLE IF EXISTS `brake_handles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_handles` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `materialCorp` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `compatibility` enum('DISC_HYDRO','DISC_MECH','V_BRAKE','DISC_MECH_V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `location` enum('LEFT','RIGHT','SET') DEFAULT NULL,
  `wide` varchar(255) DEFAULT NULL,
  `handlebar_diam` double DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK10lo1pmbeb45tqhgqn335ke9s` (`maker_id`),
  CONSTRAINT `FK10lo1pmbeb45tqhgqn335ke9s` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_handles`
--

LOCK TABLES `brake_handles` WRITE;
/*!40000 ALTER TABLE `brake_handles` DISABLE KEYS */;
INSERT INTO `brake_handles` VALUES (1,1111,'Чорний','SHIMANO BL - R3000 SORA гальмівна ручка на прямой руль BL-R3000 права','Пластик','Алюміній','SHIMANO BL - R3000 SORA',305,'SHIMANO_BL-R3000_SORA_R','/resources/images/shimano_Handle.jpg','320','DISC_MECH_V_BRAKE','RIGHT','2',4,1),(2,1112,'Чорний','SHIMANO BL - R3000 SORA гальмівна ручка на прямой руль BL-R3000 ліва','Пластик','Алюміній','SHIMANO BL - R3000 SORA',305,'SHIMANO_BL-R3000_SORA_L','/resources/images/shimano_HandleL.jpg','320','DISC_MECH_V_BRAKE','LEFT','2',4,1),(3,1113,'Чорний',' SHIMANO BL-M421 комплект гальмівних ручок','Пластик','Алюміній',' SHIMANO BL-M421',400,' SHIMANO_BL-M421','/resources/images/shimano_Handle_Coml.jpg','220','DISC_MECH_V_BRAKE','SET','2',4,1);
/*!40000 ALTER TABLE `brake_handles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_liquids`
--

DROP TABLE IF EXISTS `brake_liquids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_liquids` (
  `id` bigint(20) NOT NULL,
  `liq` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_liquids`
--

LOCK TABLES `brake_liquids` WRITE;
/*!40000 ALTER TABLE `brake_liquids` DISABLE KEYS */;
INSERT INTO `brake_liquids` VALUES (1,'Мінеральне масло');
/*!40000 ALTER TABLE `brake_liquids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brake_vbrakes`
--

DROP TABLE IF EXISTS `brake_vbrakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brake_vbrakes` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `loc_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsnns18h0umwutq7r1d6cvtgng` (`loc_id`),
  KEY `FKisk7003csneuo8i6p0n63maqh` (`maker_id`),
  CONSTRAINT `FKisk7003csneuo8i6p0n63maqh` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKsnns18h0umwutq7r1d6cvtgng` FOREIGN KEY (`loc_id`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brake_vbrakes`
--

LOCK TABLES `brake_vbrakes` WRITE;
/*!40000 ALTER TABLE `brake_vbrakes` DISABLE KEYS */;
INSERT INTO `brake_vbrakes` VALUES (1,1108,'Чорний',' Тормоз задній Shimano Deore V-brake BR-T610, картридж колодки S70C +SMVBRKL.','','Shimano Deore V-brake BR-T610 задній',503,'Shimano_Deore_V-brake_BR-T610','/resources/images/shimano_v_brake_Back.jpg',2,1),(2,1109,'Сріблястий',' Тормоз передній SHIMANO ALIVIO BR-T4000, картридж колодки S70C +SMVBRKL.','','SHIMANO ALIVIO BR-T4000 передній',403,'SHIMANO_ALIVIO_BR-T4000','/resources/images/shimano_v_brake_Front.jpg',1,1),(3,1110,'Чорний',' Тормоз  V-BRAKE TEKTRO M530','','TEKTRO M530 передній/задній',206.4,'TEKTRO_M530','/resources/images/tektro-vBrake.jpg',4,3);
/*!40000 ALTER TABLE `brake_vbrakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brakes`
--

DROP TABLE IF EXISTS `brakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brakes` (
  `id` bigint(20) NOT NULL,
  `brake_type` enum('DISC','V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `brake_sub_type` enum('HYDRAULIC','MECHANIK') DEFAULT NULL,
  `article` bigint(20) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `materialHandle` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rotor_weight` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `brake_liquid` varchar(255) DEFAULT NULL,
  `length_line` double DEFAULT NULL,
  `location` enum('FRONT','BACK','UNIVERSAL','SET') DEFAULT 'SET',
  `maker_id` bigint(20) DEFAULT NULL,
  `rotor_diam` double DEFAULT NULL,
  `rotor_fix_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_brakes_manufacturer` (`maker_id`),
  CONSTRAINT `FK_brakes_manufacturer` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brakes`
--

LOCK TABLES `brakes` WRITE;
/*!40000 ALTER TABLE `brakes` DISABLE KEYS */;
INSERT INTO `brakes` VALUES (1,'DISC','HYDRAULIC',1101,'311 г','Чорний','Дисковий гидравлічний тормоз Tektro DRACO 2-F-180 передній \nз двупоршневим принципом дії.Адаптер та ротор TR 180-8 в комплекті',' ','Алюміній','Tektro DRACO 2-F-180',1369,'110 г','Tektro_DRACO_2-F-180','/resources/images/tektro-Disc-Hydraulik-Front.jpg','Мінеральне масло',700,'SET',3,140,'6 болтів'),(2,'DISC','HYDRAULIC',1102,'311 г','Чорний','Дисковый гидравлический тормоз Tektro Draco 2-F-160 задній\nвелосипедний гидравлічний тормоз с двупоршневим принципом дії\nтормозная ручка під 2 пальці\n метало-керамічні колодки \n регулювання ходу ручки адаптер AQ1.0 та ротор TR 160-8 в комплекті',' ','Алюміній','Tektro DRACO 2-F-180',1400,'110 г','Tektro_DRACO_2-F-160','/resources/images/tektro-Disc-Hydraulik-back.jpg','Мінеральне масло',700,'SET',3,140,'6 болтів'),(3,'DISC','HYDRAULIC',1103,'350 г','Чорний','Дисковый гидравлический тормоз комплект Shimano M4050 задній ',' ','Дюраль','Shimano M4050',1200,'110 г','Shimano_M4050','/resources/images/brake_Shimano_Hydro_Back.jpg','Мінеральне масло',700,'SET',1,160,'CenterLock Shimano'),(4,'DISC','MECHANIK',1107,'310','Чорний','Задній тормоз дисковий механічний Tektro Aquila  160мм.',' ',NULL,'Tektro Aquila задній 160мм',850,'110 г','Tektro_Aquila_160_back','/resources/images/tektro-Disc-Mech-Front.jpg',NULL,NULL,'FRONT',3,170,'6 болтів'),(5,'DISC','MECHANIK',1104,'315','Сірий','Передній тормоз дисковий механічний AVID BB7 160мм.',' ',NULL,'AVID BB7 передній 160мм',2069,'110 г','AVID_BB7_160','/resources/images/brakes_avid_mech_front.jpg',NULL,NULL,'SET',4,170,'6 болтів'),(6,'DISC','MECHANIK',1105,'310','Чорний','Передній тормоз дисковий механічний Tektro Aquila  160мм.',' ',NULL,'Tektro Aquila передній 160мм',850,'110 г','Tektro_Aquila_160','/resources/images/tektro-Disc-Mech-Front.jpg',NULL,NULL,'SET',3,140,'6 болтів'),(7,'DISC','MECHANIK',1106,'315','Сірий','Задній тормоз дисковий механічний AVID BB7 160мм.',' ',NULL,'AVID BB7 задній 160мм',2069,'110 г','AVID_BB7_160_back','/resources/images/brakes_avid_mech_front.jpg',NULL,NULL,'BACK',4,140,'6 болтів'),(8,'V_BRAKE',NULL,1108,'110','Чорний',' Тормоз задній Shimano Deore V-brake BR-T610, картридж колодки S70C +SMVBRKL.','',NULL,'Shimano Deore V-brake BR-T610 задній',503,NULL,'Shimano_Deore_V-brake_BR-T610','/resources/images/shimano_v_brake_Back.jpg',NULL,NULL,'FRONT',1,NULL,NULL),(9,'V_BRAKE',NULL,1109,'110','Сріблястий',' Тормоз передній SHIMANO ALIVIO BR-T4000, картридж колодки S70C +SMVBRKL.','',NULL,'SHIMANO ALIVIO BR-T4000 передній',403,NULL,'SHIMANO_ALIVIO_BR-T4000','/resources/images/shimano_v_brake_Front.jpg',NULL,NULL,'SET',1,NULL,NULL),(10,'V_BRAKE',NULL,1110,'115','Чорний',' Тормоз  V-BRAKE TEKTRO M530','',NULL,'TEKTRO M530 передній/задній',206.4,NULL,'TEKTRO_M530','/resources/images/tektro-vBrake.jpg',NULL,NULL,'SET',3,NULL,NULL);
/*!40000 ALTER TABLE `brakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brakes_types`
--

DROP TABLE IF EXISTS `brakes_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brakes_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brakes_types`
--

LOCK TABLES `brakes_types` WRITE;
/*!40000 ALTER TABLE `brakes_types` DISABLE KEYS */;
INSERT INTO `brakes_types` VALUES (1,'Дискові'),(2,'V-Brake'),(3,'Дискові/V-Brake');
/*!40000 ALTER TABLE `brakes_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carving_types`
--

DROP TABLE IF EXISTS `carving_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carving_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carving_types`
--

LOCK TABLES `carving_types` WRITE;
/*!40000 ALTER TABLE `carving_types` DISABLE KEYS */;
INSERT INTO `carving_types` VALUES (1,'BSA, 1.37 in x 24 TPI');
/*!40000 ALTER TABLE `carving_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chain_element_numbers`
--

DROP TABLE IF EXISTS `chain_element_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chain_element_numbers` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chain_element_numbers`
--

LOCK TABLES `chain_element_numbers` WRITE;
/*!40000 ALTER TABLE `chain_element_numbers` DISABLE KEYS */;
INSERT INTO `chain_element_numbers` VALUES (1,'118'),(2,'116'),(3,'114');
/*!40000 ALTER TABLE `chain_element_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chains`
--

DROP TABLE IF EXISTS `chains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chains` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `back_spr_num_id` bigint(20) DEFAULT NULL,
  `elem_num_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbju2ds0giljacal69xh92xris` (`back_spr_num_id`),
  KEY `FKsx9r4v1j4wm8qkwltckcit9x1` (`elem_num_id`),
  KEY `FK6sr93rur9tsb1kqcir0fchwxv` (`maker_id`),
  CONSTRAINT `FK6sr93rur9tsb1kqcir0fchwxv` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKbju2ds0giljacal69xh92xris` FOREIGN KEY (`back_spr_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FKsx9r4v1j4wm8qkwltckcit9x1` FOREIGN KEY (`elem_num_id`) REFERENCES `chain_element_numbers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chains`
--

LOCK TABLES `chains` WRITE;
/*!40000 ALTER TABLE `chains` DISABLE KEYS */;
INSERT INTO `chains` VALUES (1,901,'','Ланцюг Shimano Deore XT CN-HG93 9 швидкостей 118 ланок.\nОсобливості:\n• Конструкція Super Narrow HG;\n• Технологія HG запровадила виконання фасок на внутрішніх пластинах для оптимізації якості перемикання на касетах HG;\n• Довговічність забезпечується за рахунок термообробки роликів, штифтів і пластин;\n• Для зниження зносу використані нікельовані зовнішні ланки;\n• Особлива, асиметрична конструкція пластин для оптимальної роботи перемикання як спереду так і ззаду;\n• Особлива конструкція пластин для мінимального забруднення і максимально швидкого очищення від бруду;\n• Жорсткі допуски ланцюга забезпечують її довговічність, надійність і безвідмовне перемикання при використанні 9-швидкісної касети із зменшеним зазором між зірочками.',' ','Shimano Deore XT CN-HG93',690,'Shimano_Deore_XT_CN-HG93','/resources/images/chain_shimano_9.jpg','304 г.',4,1,2),(2,902,'','Ланцюг Shimano Deore CN-HG54 10 швидкостей 116 ланок.\n• Технологія HG запровадила виконання фасок на внутрішніх пластинах для оптимізації якості перемикання на касетах HG;\n• Довговічність забезпечується за рахунок термообробки роликів, штифтів і пластин.',' ','Shimano Deore CN-HG54',850,'Shimano_Deore_CN-HG54','/resources/images/chain_shimano_10.jpg','304 г.',5,2,2),(3,903,'','Ланцюг Sram PC 971 9 швидкостей 114 ланок + замок PowerLink Gold',' ','Sram PC 971',540,'Sram_PC_971','/resources/images/chain_Sram_9.jpg','298 г.',4,3,1);
/*!40000 ALTER TABLE `chains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collar_diams`
--

DROP TABLE IF EXISTS `collar_diams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collar_diams` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collar_diams`
--

LOCK TABLES `collar_diams` WRITE;
/*!40000 ALTER TABLE `collar_diams` DISABLE KEYS */;
INSERT INTO `collar_diams` VALUES (1,'28.6'),(2,'31.8'),(3,'34.9'),(4,'38.2');
/*!40000 ALTER TABLE `collar_diams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `components`
--

DROP TABLE IF EXISTS `components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `components` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `components`
--

LOCK TABLES `components` WRITE;
/*!40000 ALTER TABLE `components` DISABLE KEYS */;
/*!40000 ALTER TABLE `components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cord_types`
--

DROP TABLE IF EXISTS `cord_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cord_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cord_types`
--

LOCK TABLES `cord_types` WRITE;
/*!40000 ALTER TABLE `cord_types` DISABLE KEYS */;
INSERT INTO `cord_types` VALUES (1,'Сталь');
/*!40000 ALTER TABLE `cord_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crank_lengths`
--

DROP TABLE IF EXISTS `crank_lengths`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crank_lengths` (
  `id` bigint(20) NOT NULL,
  `length` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crank_lengths`
--

LOCK TABLES `crank_lengths` WRITE;
/*!40000 ALTER TABLE `crank_lengths` DISABLE KEYS */;
INSERT INTO `crank_lengths` VALUES (1,'165'),(2,'170'),(3,'172.5'),(4,'175'),(5,'177.5'),(6,'180');
/*!40000 ALTER TABLE `crank_lengths` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cranks`
--

DROP TABLE IF EXISTS `cranks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cranks` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `crankMaterial` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sprocketMaterial` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `back_sproc_num_id` bigint(20) DEFAULT NULL,
  `bike_type_id` bigint(20) DEFAULT NULL,
  `bracket_type_id` bigint(20) DEFAULT NULL,
  `crank_length_id` bigint(20) DEFAULT NULL,
  `front_spr_max_id` bigint(20) DEFAULT NULL,
  `front_spr_min_id` bigint(20) DEFAULT NULL,
  `front_sproc_num_id` bigint(20) DEFAULT NULL,
  `front_spr_size_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasfom9g7oye1v62cqgnpgyo4d` (`back_sproc_num_id`),
  KEY `FKn1yqs18d22jm7ouvehwhq7d5n` (`bike_type_id`),
  KEY `FKggreuoo7miiqv2f10ybyjn3pc` (`bracket_type_id`),
  KEY `FK23jhnhm0mowfn3rhlwkk4fx5i` (`crank_length_id`),
  KEY `FK51jjp7k4avtgx8bb869qq3oft` (`front_spr_max_id`),
  KEY `FKa5mikjfac8k25v25b51fxdquq` (`front_spr_min_id`),
  KEY `FK39w3imkprl01ejs64kkn1ycut` (`front_sproc_num_id`),
  KEY `FKcuhd7yof6e861qnxymntrm0my` (`front_spr_size_id`),
  KEY `FKcnv9lqchj3ykuoaridwtrku2e` (`maker_id`),
  CONSTRAINT `FK23jhnhm0mowfn3rhlwkk4fx5i` FOREIGN KEY (`crank_length_id`) REFERENCES `crank_lengths` (`id`),
  CONSTRAINT `FK39w3imkprl01ejs64kkn1ycut` FOREIGN KEY (`front_sproc_num_id`) REFERENCES `front_sprocket_numbers` (`id`),
  CONSTRAINT `FK51jjp7k4avtgx8bb869qq3oft` FOREIGN KEY (`front_spr_max_id`) REFERENCES `front_sprocket_maxs` (`id`),
  CONSTRAINT `FKa5mikjfac8k25v25b51fxdquq` FOREIGN KEY (`front_spr_min_id`) REFERENCES `front_sprocket_mins` (`id`),
  CONSTRAINT `FKasfom9g7oye1v62cqgnpgyo4d` FOREIGN KEY (`back_sproc_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FKcnv9lqchj3ykuoaridwtrku2e` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKcuhd7yof6e861qnxymntrm0my` FOREIGN KEY (`front_spr_size_id`) REFERENCES `front_sprocket_sizes` (`id`),
  CONSTRAINT `FKggreuoo7miiqv2f10ybyjn3pc` FOREIGN KEY (`bracket_type_id`) REFERENCES `bracket_types` (`id`),
  CONSTRAINT `FKn1yqs18d22jm7ouvehwhq7d5n` FOREIGN KEY (`bike_type_id`) REFERENCES `bike_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cranks`
--

LOCK TABLES `cranks` WRITE;
/*!40000 ALTER TABLE `cranks` DISABLE KEYS */;
INSERT INTO `cranks` VALUES (1,401,'Чорни','Алюміній','Ковані шатуни S600. Підходят для групп X4 и X5.','TRUVATIV X-5 GXP 10 L170',1968,'Алюміній','TRUVATIV_X-5_GXP_10_L170','/resources/images/crank_Truvativ.jpg',4,1,5,2,3,1,3,1,5),(2,402,'Чорни','Алюміній','Шатуни  SHIMANO FC-M371-L 48х36х26T, 175мм',' SHIMANO FC-M371-L',1500,'Алюміній',' SHIMANO_FC-M371-L_48х36х26T','/resources/images/crank_Shimano_Sqare.jpg',4,1,1,4,5,3,3,5,2),(3,403,'Чорни','Алюміній','Шатуни  Shimano FC-M361, 175мм, 42X32X22','Shimano FC-M361',900,'Алюміній','Shimano_FC-M361','/resources/images/crank_Shimano8.jpg',3,1,1,4,2,1,3,3,2);
/*!40000 ALTER TABLE `cranks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customusers`
--

DROP TABLE IF EXISTS `customusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customusers` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgft8r5tmsq1xfxn91etixc8m4` (`role_id`),
  CONSTRAINT `FKgft8r5tmsq1xfxn91etixc8m4` FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customusers`
--

LOCK TABLES `customusers` WRITE;
/*!40000 ALTER TABLE `customusers` DISABLE KEYS */;
INSERT INTO `customusers` VALUES (1,NULL,'admin',NULL,'admin',NULL,0);
/*!40000 ALTER TABLE `customusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etrto_sizes`
--

DROP TABLE IF EXISTS `etrto_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etrto_sizes` (
  `id` bigint(20) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etrto_sizes`
--

LOCK TABLES `etrto_sizes` WRITE;
/*!40000 ALTER TABLE `etrto_sizes` DISABLE KEYS */;
INSERT INTO `etrto_sizes` VALUES (1,'559 x 17');
/*!40000 ALTER TABLE `etrto_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forks`
--

DROP TABLE IF EXISTS `forks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forks` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `move` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stTubeLength` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `brake_type` enum('DISC','V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `tybe_d_id` bigint(20) DEFAULT NULL,
  `whells_d_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6igtcp5jj0eyt9o4j03cypm5c` (`type_id`),
  KEY `FK6sbhlnp2jigbe42sgplq3ycdf` (`maker_id`),
  KEY `FKajh5qjkk7yl0mwpo7ivuqbqds` (`tybe_d_id`),
  KEY `FKaog8ecjcmj6mpbq4s8k457baq` (`whells_d_id`),
  CONSTRAINT `FK6igtcp5jj0eyt9o4j03cypm5c` FOREIGN KEY (`type_id`) REFERENCES `bike_types` (`id`),
  CONSTRAINT `FK6sbhlnp2jigbe42sgplq3ycdf` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKajh5qjkk7yl0mwpo7ivuqbqds` FOREIGN KEY (`tybe_d_id`) REFERENCES `tube_diameters` (`id`),
  CONSTRAINT `FKaog8ecjcmj6mpbq4s8k457baq` FOREIGN KEY (`whells_d_id`) REFERENCES `wheels_diams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forks`
--

LOCK TABLES `forks` WRITE;
/*!40000 ALTER TABLE `forks` DISABLE KEYS */;
INSERT INTO `forks` VALUES (1,101,'Чорний','Вилка велосипедна Rock Shox XC 30 100','Матеріал ніг:Сталь,Матеріал корони:	Кований алюміній 6061 T-6,Матеріал штанів:	Магнієвий сплав','100','Rock Shox XC 30 100',3968.4,'200','Rock_Shox_XC_30_100','/resources/images/rock-shox-xc-30-tk-29.jpg','3401',1,'V_BRAKE',3,1,5),(2,102,'Чорний','Вилка велосипедна Suntour XCT V4 P',' Матеріал ніг: сталь з хромовим покриттям,матеріал штанів: алюміній;','100','Suntour XCT V4 P',2000,'200','Suntour_XCT_V4_P','/resources/images/suntour-XCT-V4.jpg','2500',1,'DISC',4,1,2),(3,103,'Білий','Вилка велосипедна Suntour XCM HLO','Корона: алюміній, матеріал ніг: сталь з хромовим покриттям, матеріал штанів: алюміній;','100','Suntour XCM HLO',3000,'200','Suntour_XCM_HLO','/resources/images/suntour-xcm-sr-hlo.jpg','2600',1,'UNIVERSAL',4,1,2),(4,104,'Білий','Вилка MARZOCCHI 2010 DIRT JUMPER 2','Матеріал ніг: сталь з хромовим покриттям, матеріал штанів: алюміній;','100','MARZOCCHI 2010 DIRT JUMPER 2',6010,'200','MARZOCCHI_2010_DIRT_JUMPER_2','/resources/images/marzocchi_2010_dirt_jumper2.jpg','2450',1,'DISC',2,1,2);
/*!40000 ALTER TABLE `forks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frame_size_type`
--

DROP TABLE IF EXISTS `frame_size_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frame_size_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frame_size_type`
--

LOCK TABLES `frame_size_type` WRITE;
/*!40000 ALTER TABLE `frame_size_type` DISABLE KEYS */;
INSERT INTO `frame_size_type` VALUES (1,'M'),(2,'L'),(3,'S'),(4,'XS'),(5,'XL'),(6,'XXL');
/*!40000 ALTER TABLE `frame_size_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frame_sizes`
--

DROP TABLE IF EXISTS `frame_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frame_sizes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `frame_id` bigint(20) NOT NULL,
  `size_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `size_id` (`size_id`),
  KEY `frame_size_ibfc_1` (`frame_id`),
  CONSTRAINT `frame_size_ibfc_1` FOREIGN KEY (`frame_id`) REFERENCES `frames` (`id`),
  CONSTRAINT `frame_size_ibfc_2` FOREIGN KEY (`size_id`) REFERENCES `frame_size_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frame_sizes`
--

LOCK TABLES `frame_sizes` WRITE;
/*!40000 ALTER TABLE `frame_sizes` DISABLE KEYS */;
INSERT INTO `frame_sizes` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,1),(5,4,2),(6,3,3);
/*!40000 ALTER TABLE `frame_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frames`
--

DROP TABLE IF EXISTS `frames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frames` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `bike_type_id` bigint(20) DEFAULT NULL,
  `bracket_wide` double DEFAULT NULL,
  `brakes_type_id` bigint(20) DEFAULT NULL,
  `headset_type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `trunk_id` bigint(20) DEFAULT NULL,
  `tube_diam_id` bigint(20) DEFAULT NULL,
  `under_sad_diam_id` bigint(20) DEFAULT NULL,
  `whells_d_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlaskqv5rei4onh7g63ddqe9ju` (`bike_type_id`),
  KEY `FKa1ecc2yxsyspvxtm1kq8lnlgi` (`brakes_type_id`),
  KEY `FKsf32bll04fxmitdeutb0l1rmv` (`headset_type_id`),
  KEY `FKdm69xku4q2ooaeg7sj3mtcfyw` (`maker_id`),
  KEY `FKb4e5xkqyjyjgti0foyg9wut0j` (`trunk_id`),
  KEY `FK318u1q2y1se37j7eiek00ejho` (`tube_diam_id`),
  KEY `FKdlqi4df51ountq9q0u9qf3amb` (`under_sad_diam_id`),
  KEY `FKdi96u8yehfl8275iirt5bvko2` (`whells_d_id`),
  CONSTRAINT `FK318u1q2y1se37j7eiek00ejho` FOREIGN KEY (`tube_diam_id`) REFERENCES `tube_diameters` (`id`),
  CONSTRAINT `FKa1ecc2yxsyspvxtm1kq8lnlgi` FOREIGN KEY (`brakes_type_id`) REFERENCES `brakes_types` (`id`),
  CONSTRAINT `FKb4e5xkqyjyjgti0foyg9wut0j` FOREIGN KEY (`trunk_id`) REFERENCES `trunk_bindings` (`id`),
  CONSTRAINT `FKdi96u8yehfl8275iirt5bvko2` FOREIGN KEY (`whells_d_id`) REFERENCES `wheels_diams` (`id`),
  CONSTRAINT `FKdlqi4df51ountq9q0u9qf3amb` FOREIGN KEY (`under_sad_diam_id`) REFERENCES `under_saddle_tubes` (`id`),
  CONSTRAINT `FKdm69xku4q2ooaeg7sj3mtcfyw` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKlaskqv5rei4onh7g63ddqe9ju` FOREIGN KEY (`bike_type_id`) REFERENCES `bike_types` (`id`),
  CONSTRAINT `FKsf32bll04fxmitdeutb0l1rmv` FOREIGN KEY (`headset_type_id`) REFERENCES `headset_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frames`
--

LOCK TABLES `frames` WRITE;
/*!40000 ALTER TABLE `frames` DISABLE KEYS */;
INSERT INTO `frames` VALUES (1,1,'Чорний','Рама Giant ATX PRO black\nВелосипедная рама Giant ATX PRO из сплава ALUXX делает ее хорошим выбором для любителей кросс-кантри. Только под дисковые тормоза.','Алюміній','Giant ATX PRO',3698.2,'Giant_ATX','/resources/images/giant_atx_pro_black_7382.jpg','14589 г',1,2,1,1,11,2,1,12,2),(2,2,'Чорний','Рама Giant ATX PRO black\nВелосипедная рама Giant ATX PRO из сплава ALUXX делает ее хорошим выбором для любителей кросс-кантри. Только под дисковые тормоза.','Алюміній','Giant ATX',5999,'Giant_ATX','/resources/images/frame_Giant_26.jpg','12000 г',1,1,1,1,1,1,1,12,2),(3,3,'Чорний','Amoeba','Алюміній','Amoeba',5000.6,'Amoeba','/resources/images/giant_atx_pro_black_7382.jpg','30000 г',1,2,1,1,1,2,1,12,2),(4,7,'Чорний','Trek','Алюміній','Track 29',18000,NULL,'/resources/images/frame_Track29.jpg','30000 г',2,2,1,1,27,2,1,12,5);
/*!40000 ALTER TABLE `frames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_derailleur_fix_types`
--

DROP TABLE IF EXISTS `front_derailleur_fix_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_derailleur_fix_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_derailleur_fix_types`
--

LOCK TABLES `front_derailleur_fix_types` WRITE;
/*!40000 ALTER TABLE `front_derailleur_fix_types` DISABLE KEYS */;
INSERT INTO `front_derailleur_fix_types` VALUES (1,'Хомут'),(2,'Braze-on'),(3,'E-type');
/*!40000 ALTER TABLE `front_derailleur_fix_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_derailleurs`
--

DROP TABLE IF EXISTS `front_derailleurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_derailleurs` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `chainLine` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `back_sproc_num_id` bigint(20) DEFAULT NULL,
  `collar_diam_id` bigint(20) DEFAULT NULL,
  `fix_type_id` bigint(20) DEFAULT NULL,
  `front_spr_max_id` bigint(20) DEFAULT NULL,
  `front_spr_min_id` bigint(20) DEFAULT NULL,
  `front_sproc_num_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `teeth_capasity_id` bigint(20) DEFAULT NULL,
  `traction_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17bkohf5cbekvr5efl306rcu3` (`back_sproc_num_id`),
  KEY `FK1ug0ecyjhwuflemcgxmaiw2u2` (`collar_diam_id`),
  KEY `FKk775jx5mxu5uwpgy4yb6y7dv6` (`fix_type_id`),
  KEY `FKnhemrtt7w3hmeqppjtvkt0yl3` (`front_spr_max_id`),
  KEY `FKoifkq8u4bofbqa5scsop205ov` (`front_spr_min_id`),
  KEY `FK9otfx3que4uxud8v979lt1auc` (`front_sproc_num_id`),
  KEY `FKjn2umtl0ys2t7ca86lx19wnwq` (`maker_id`),
  KEY `FK34f0o7aieds1x4hafn4k3iu7u` (`teeth_capasity_id`),
  KEY `FKkfa530d7bjpilaehm7qvgxrb0` (`traction_type_id`),
  CONSTRAINT `FK17bkohf5cbekvr5efl306rcu3` FOREIGN KEY (`back_sproc_num_id`) REFERENCES `back_sprocket_numbers` (`id`),
  CONSTRAINT `FK1ug0ecyjhwuflemcgxmaiw2u2` FOREIGN KEY (`collar_diam_id`) REFERENCES `collar_diams` (`id`),
  CONSTRAINT `FK34f0o7aieds1x4hafn4k3iu7u` FOREIGN KEY (`teeth_capasity_id`) REFERENCES `teethcapasitys` (`id`),
  CONSTRAINT `FK9otfx3que4uxud8v979lt1auc` FOREIGN KEY (`front_sproc_num_id`) REFERENCES `front_sprocket_numbers` (`id`),
  CONSTRAINT `FKjn2umtl0ys2t7ca86lx19wnwq` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKk775jx5mxu5uwpgy4yb6y7dv6` FOREIGN KEY (`fix_type_id`) REFERENCES `front_derailleur_fix_types` (`id`),
  CONSTRAINT `FKkfa530d7bjpilaehm7qvgxrb0` FOREIGN KEY (`traction_type_id`) REFERENCES `traction_types` (`id`),
  CONSTRAINT `FKnhemrtt7w3hmeqppjtvkt0yl3` FOREIGN KEY (`front_spr_max_id`) REFERENCES `front_sprocket_maxs` (`id`),
  CONSTRAINT `FKoifkq8u4bofbqa5scsop205ov` FOREIGN KEY (`front_spr_min_id`) REFERENCES `front_sprocket_mins` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_derailleurs`
--

LOCK TABLES `front_derailleurs` WRITE;
/*!40000 ALTER TABLE `front_derailleurs` DISABLE KEYS */;
INSERT INTO `front_derailleurs` VALUES (1,801,' ','Чорний','Передня перекидка Shimano FD-TY500','Штампована сталь','Shimano FD-TY500',450,'Shimano_FD-TY500','/resources/images/frontDerShimano.jpg','200',2,3,1,2,2,3,2,NULL,3),(2,802,' ','Чорний','Передня перекидка Shimano FD-M8000-H DEORE XT, 3X11 HIGH CLAMP, SIDE-SWING, передня тяга, 34,9/31,8мм адапт.','Штампована сталь','Shimano FD-M8000-H DEORE XT',968.8,'Shimano_FD-M8000-H_DEORE_XT','/resources/images/frontDer_Shimano_11.jpg','230',6,3,1,2,2,3,2,NULL,1),(3,803,' ','Чорний','Передня перекидка SRAM X-5 3X10 LC 31/34 DP','Алюміній 6061 серії','SRAM X-5 3X10',800,'SRAM_X-5_3X10','/resources/images/frontDer_Sram_10.jpg','230',5,3,1,2,2,3,1,NULL,2),(4,804,' ','Чорний','Передня перекидка SUN RACE M97 22/32/44T DIAM34.9 ','Алюміній','SUN RACE M97',300,'SUN_RACE_M97','/resources/images/frontDer_SunRace_9.jpg','230',4,3,1,2,3,3,3,NULL,3);
/*!40000 ALTER TABLE `front_derailleurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_hubs`
--

DROP TABLE IF EXISTS `front_hubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_hubs` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `axis_diam_id` bigint(20) DEFAULT NULL,
  `axis_length_id` bigint(20) DEFAULT NULL,
  `bearing_type_id` bigint(20) DEFAULT NULL,
  `brakes_type_id` bigint(20) DEFAULT NULL,
  `fix_type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rot_fix_id` bigint(20) DEFAULT NULL,
  `spoke_num_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhrjtwgver3eeifg9v6gcx9wl6` (`axis_diam_id`),
  KEY `FK5qcp1opggs6gr6u2u6aeb3fnt` (`axis_length_id`),
  KEY `FK7sgaqdn670hrbu8y3omuwj61l` (`bearing_type_id`),
  KEY `FK79vmixeog2lmhqn3lssgvvpco` (`brakes_type_id`),
  KEY `FK3ov42a8jtwjs9y80uqojwfc8s` (`fix_type_id`),
  KEY `FK4dmpbekldtteod6gqv55b1m0s` (`maker_id`),
  KEY `FK773cn47pubbusu2wgwcuidgnt` (`rot_fix_id`),
  KEY `FKqe8dk8mgp6gpsn3cigodrbp5v` (`spoke_num_id`),
  CONSTRAINT `FK3ov42a8jtwjs9y80uqojwfc8s` FOREIGN KEY (`fix_type_id`) REFERENCES `hum_fix_types` (`id`),
  CONSTRAINT `FK4dmpbekldtteod6gqv55b1m0s` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FK5qcp1opggs6gr6u2u6aeb3fnt` FOREIGN KEY (`axis_length_id`) REFERENCES `axis_lengths` (`id`),
  CONSTRAINT `FK773cn47pubbusu2wgwcuidgnt` FOREIGN KEY (`rot_fix_id`) REFERENCES `rotor_fix_types` (`id`),
  CONSTRAINT `FK79vmixeog2lmhqn3lssgvvpco` FOREIGN KEY (`brakes_type_id`) REFERENCES `brakes_types` (`id`),
  CONSTRAINT `FK7sgaqdn670hrbu8y3omuwj61l` FOREIGN KEY (`bearing_type_id`) REFERENCES `bearing_types` (`id`),
  CONSTRAINT `FKhrjtwgver3eeifg9v6gcx9wl6` FOREIGN KEY (`axis_diam_id`) REFERENCES `axis_diams` (`id`),
  CONSTRAINT `FKqe8dk8mgp6gpsn3cigodrbp5v` FOREIGN KEY (`spoke_num_id`) REFERENCES `spoke_numbers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_hubs`
--

LOCK TABLES `front_hubs` WRITE;
/*!40000 ALTER TABLE `front_hubs` DISABLE KEYS */;
INSERT INTO `front_hubs` VALUES (1,2101,'Чорний','Втулка передня Novatec D041SB 32H QR black','Матеріал корпусу - алюміній, матеріал осі - хромомолюбденова сталь','Novatec D041SB 32H QR black',650,'Novatec_D041SB_32H_QR_black','/resources/images/frontHub_Novatek.jpg','216 г',1,2,1,1,1,3,1,2);
/*!40000 ALTER TABLE `front_hubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_sprocket_maxs`
--

DROP TABLE IF EXISTS `front_sprocket_maxs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_sprocket_maxs` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_sprocket_maxs`
--

LOCK TABLES `front_sprocket_maxs` WRITE;
/*!40000 ALTER TABLE `front_sprocket_maxs` DISABLE KEYS */;
INSERT INTO `front_sprocket_maxs` VALUES (1,'36'),(2,'42'),(3,'44'),(4,'46'),(5,'48');
/*!40000 ALTER TABLE `front_sprocket_maxs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_sprocket_mins`
--

DROP TABLE IF EXISTS `front_sprocket_mins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_sprocket_mins` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_sprocket_mins`
--

LOCK TABLES `front_sprocket_mins` WRITE;
/*!40000 ALTER TABLE `front_sprocket_mins` DISABLE KEYS */;
INSERT INTO `front_sprocket_mins` VALUES (1,'22'),(2,'24'),(3,'26'),(4,'28');
/*!40000 ALTER TABLE `front_sprocket_mins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_sprocket_numbers`
--

DROP TABLE IF EXISTS `front_sprocket_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_sprocket_numbers` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_sprocket_numbers`
--

LOCK TABLES `front_sprocket_numbers` WRITE;
/*!40000 ALTER TABLE `front_sprocket_numbers` DISABLE KEYS */;
INSERT INTO `front_sprocket_numbers` VALUES (1,'1'),(2,'2'),(3,'3');
/*!40000 ALTER TABLE `front_sprocket_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `front_sprocket_sizes`
--

DROP TABLE IF EXISTS `front_sprocket_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `front_sprocket_sizes` (
  `id` bigint(20) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `front_sprocket_sizes`
--

LOCK TABLES `front_sprocket_sizes` WRITE;
/*!40000 ALTER TABLE `front_sprocket_sizes` DISABLE KEYS */;
INSERT INTO `front_sprocket_sizes` VALUES (1,'22-32-44'),(2,'22-36'),(3,'22-32-42'),(4,'28-38-48'),(5,'26-36-48');
/*!40000 ALTER TABLE `front_sprocket_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grips`
--

DROP TABLE IF EXISTS `grips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grips` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `length` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlhxjlhbtjolgs8yt4w5vok57q` (`maker_id`),
  CONSTRAINT `FKlhxjlhbtjolgs8yt4w5vok57q` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grips`
--

LOCK TABLES `grips` WRITE;
/*!40000 ALTER TABLE `grips` DISABLE KEYS */;
INSERT INTO `grips` VALUES (1,1501,'білий','Ручки руля з високим рифленням для застереження від вислизування руля з рук','120мм','високоякісна гума','Giant SOLE-O LOCK-ON',355,'giant_sole','/resources/images/grips_Giant.jpg','125 г',4),(2,1502,'білий/сріблястий','Ергономічні грипси з яскравим дизайном','135 мм','Kraton','BBB ERGOFIX BHG-17 silver',655,'grips_bbb','/resources/images/grips_BBB.jpg','125 г',1);
/*!40000 ALTER TABLE `grips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handlebar_diameters`
--

DROP TABLE IF EXISTS `handlebar_diameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `handlebar_diameters` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handlebar_diameters`
--

LOCK TABLES `handlebar_diameters` WRITE;
/*!40000 ALTER TABLE `handlebar_diameters` DISABLE KEYS */;
INSERT INTO `handlebar_diameters` VALUES (1,'22.2'),(2,'25.4'),(3,'26.0'),(4,'31.8'),(5,'35.0');
/*!40000 ALTER TABLE `handlebar_diameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handlebars`
--

DROP TABLE IF EXISTS `handlebars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `handlebars` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `handlebarHeight` varchar(255) DEFAULT NULL,
  `handlebarWide` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `handlebar_diam` double DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdhfmqqhksu4i7b19cgktot0ws` (`type_id`),
  KEY `FK875mj2d585kokrt6si1qddsce` (`maker_id`),
  CONSTRAINT `FK875mj2d585kokrt6si1qddsce` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKdhfmqqhksu4i7b19cgktot0ws` FOREIGN KEY (`type_id`) REFERENCES `bike_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handlebars`
--

LOCK TABLES `handlebars` WRITE;
/*!40000 ALTER TABLE `handlebars` DISABLE KEYS */;
INSERT INTO `handlebars` VALUES (1,1201,'чорний','Велосипедне кермо, вигнутої форми, виготовлене з алюмінієвого сплаву 6061 PG ','3 см','640 мм','алюмінієвий сплав 6061 PG','KLS CROSS Riser',758,'KLS_CROSS_Riser','/resources/images/handlebar_KLS.jpg','350 г',1,2,7),(2,1202,'чорний','Велосипедне кермо Giant для кросс-кантрі','3 см','620 мм','алюміній','Giant RISER 31.8x620 мм black',600,'Giant_RISER','/resources/images/handlebar_Giant.jpg','350 г',1,4,4);
/*!40000 ALTER TABLE `handlebars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headset_types`
--

DROP TABLE IF EXISTS `headset_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headset_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headset_types`
--

LOCK TABLES `headset_types` WRITE;
/*!40000 ALTER TABLE `headset_types` DISABLE KEYS */;
INSERT INTO `headset_types` VALUES (1,'Інтегрована'),(2,'Інтегровани конус'),(3,'Напів-інтегрована'),(4,'Напів-інтегрована конус'),(5,'Різьбова'),(6,'Неінтегрована'),(7,'Неінтегрована конус');
/*!40000 ALTER TABLE `headset_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headsets`
--

DROP TABLE IF EXISTS `headsets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headsets` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `diam_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK938r4tec856jajget4p83oaix` (`type_id`),
  KEY `FKb9x8u9te9njgt48euq7oawxa9` (`maker_id`),
  KEY `FKge0y6kchwr5gva5r866iqvlkf` (`diam_id`),
  CONSTRAINT `FK938r4tec856jajget4p83oaix` FOREIGN KEY (`type_id`) REFERENCES `headset_types` (`id`),
  CONSTRAINT `FKb9x8u9te9njgt48euq7oawxa9` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKge0y6kchwr5gva5r866iqvlkf` FOREIGN KEY (`diam_id`) REFERENCES `tube_diameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headsets`
--

LOCK TABLES `headsets` WRITE;
/*!40000 ALTER TABLE `headsets` DISABLE KEYS */;
INSERT INTO `headsets` VALUES (1,1701,'білий','Рульові колонки HQBC - це оптимальне співвідношення ціни / якості. Виготовляються з високоякісного алюмінієвого сплаву і сталі,\n що володіють високою довговічністю і надійністю.\n Невелика висота рульової не порушує загального дизайну рами, і додає агресивності.','алюміній/сталь','HQBC Cheks Al/Fe 1-1/8\"',400.1,'Висота колонки: 16,1 мм','HQBC_Cheks_Al_Fe','/resources/images/rulova-kolonka-hqbc-cheks-alfe-1-18.jpg',3,6,1);
/*!40000 ALTER TABLE `headsets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2),(2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hub`
--

DROP TABLE IF EXISTS `hub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hub` (
  `id` bigint(20) NOT NULL,
  `location` enum('FRONT','BACK','UNIVERSAL','SET') DEFAULT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `axis_diam` int(11) DEFAULT NULL,
  `axis_length` int(11) DEFAULT NULL,
  `sprocket_number` int(11) DEFAULT NULL,
  `cogset_type` enum('FREEWHEEL','CASSETTE') DEFAULT NULL,
  `bearing_type` varchar(255) DEFAULT NULL,
  `brake_type` enum('DISC','V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `hub_binding_type` enum('SKEWER','SCREW_NUT') DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rot_fix_id` bigint(20) DEFAULT NULL,
  `spoke_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_manufacturer` (`maker_id`),
  KEY `FK_rotor_fix_type` (`rot_fix_id`),
  CONSTRAINT `FK_manufacturer` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FK_rotor_fix_type` FOREIGN KEY (`rot_fix_id`) REFERENCES `rotor_fix_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hub`
--

LOCK TABLES `hub` WRITE;
/*!40000 ALTER TABLE `hub` DISABLE KEYS */;
INSERT INTO `hub` VALUES (1,'BACK',2001,'Чорний','Універсальні дискові втулки SRAM MTB 506 для MTB','Алюмінієвий корпус, стальний барабан','SRAM MTB 506',1000.3,'SRAM_MTB_506','/resources/images/back_hub_Sram.jpg','420г',10,100,7,'CASSETTE','промислові підшипники','DISC','SKEWER',2,1,32),(2,'FRONT',2101,'Чорний','Втулка передня Novatec D041SB 32H QR black','Матеріал корпусу - алюміній, матеріал осі - хромомолюбденова сталь','Novatec D041SB 32H QR black',650,'Novatec_D041SB_32H_QR_black','/resources/images/frontHub_Novatek.jpg','216 г',10,100,NULL,NULL,'промислові підшипники','DISC','SKEWER',3,1,32);
/*!40000 ALTER TABLE `hub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hum_fix_types`
--

DROP TABLE IF EXISTS `hum_fix_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hum_fix_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hum_fix_types`
--

LOCK TABLES `hum_fix_types` WRITE;
/*!40000 ALTER TABLE `hum_fix_types` DISABLE KEYS */;
INSERT INTO `hum_fix_types` VALUES (1,'Під ексцентрик'),(2,'Під болти');
/*!40000 ALTER TABLE `hum_fix_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inner_tube_diameters`
--

DROP TABLE IF EXISTS `inner_tube_diameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inner_tube_diameters` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inner_tube_diameters`
--

LOCK TABLES `inner_tube_diameters` WRITE;
/*!40000 ALTER TABLE `inner_tube_diameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `inner_tube_diameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `length_hydrolines`
--

DROP TABLE IF EXISTS `length_hydrolines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `length_hydrolines` (
  `id` bigint(20) NOT NULL,
  `length` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `length_hydrolines`
--

LOCK TABLES `length_hydrolines` WRITE;
/*!40000 ALTER TABLE `length_hydrolines` DISABLE KEYS */;
INSERT INTO `length_hydrolines` VALUES (1,'700'),(2,'750'),(3,'800'),(4,'900'),(5,'1000'),(6,'1100'),(7,'1200'),(8,'1300'),(9,'1400'),(10,'1500'),(11,'1600'),(12,'1700'),(13,'1800');
/*!40000 ALTER TABLE `length_hydrolines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `id` bigint(20) NOT NULL,
  `local` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Передні'),(2,'Задні'),(3,'Комплект(Передній + Задній)'),(4,'Передні/Задні');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (24,'Alex Rims'),(16,'Amoeba'),(4,'Avid'),(14,'BBB'),(9,'Cannondale'),(10,'Fox'),(11,'Giant'),(17,'HQBC'),(23,'Kellis'),(12,'Kellys'),(18,'KLS'),(6,'Marzocchi'),(21,'Mavik'),(25,'Maxxis'),(20,'Novatek'),(22,'Race Face'),(7,'RockShox '),(5,'RST'),(13,'Scott'),(1,'Shimano'),(8,'SR Suntour'),(2,'Sram'),(19,'Sun Race'),(3,'Tektro'),(27,'Track'),(15,'Truvativ'),(26,'Velo');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nipples`
--

DROP TABLE IF EXISTS `nipples`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nipples` (
  `id` bigint(20) NOT NULL,
  `nipple` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nipples`
--

LOCK TABLES `nipples` WRITE;
/*!40000 ALTER TABLE `nipples` DISABLE KEYS */;
INSERT INTO `nipples` VALUES (1,'Автомобільний');
/*!40000 ALTER TABLE `nipples` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paw_lengths`
--

DROP TABLE IF EXISTS `paw_lengths`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paw_lengths` (
  `id` bigint(20) NOT NULL,
  `length` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paw_lengths`
--

LOCK TABLES `paw_lengths` WRITE;
/*!40000 ALTER TABLE `paw_lengths` DISABLE KEYS */;
INSERT INTO `paw_lengths` VALUES (1,'Коротка'),(2,'Середня'),(3,'Довга');
/*!40000 ALTER TABLE `paw_lengths` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedal_types`
--

DROP TABLE IF EXISTS `pedal_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedal_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedal_types`
--

LOCK TABLES `pedal_types` WRITE;
/*!40000 ALTER TABLE `pedal_types` DISABLE KEYS */;
INSERT INTO `pedal_types` VALUES (1,'Платформа'),(2,'Контактні'),(3,'Контактні з платформою');
/*!40000 ALTER TABLE `pedal_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedals`
--

DROP TABLE IF EXISTS `pedals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedals` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sizes` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `bearing_type_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `pedal_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm7w3ymrjangxn6eflaao9fmhu` (`bearing_type_id`),
  KEY `FK57tu4cfu1675ke20po9lr3oqy` (`maker_id`),
  KEY `FKea05fnlj10qa7acimpqvfwvv7` (`pedal_type_id`),
  CONSTRAINT `FK57tu4cfu1675ke20po9lr3oqy` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKea05fnlj10qa7acimpqvfwvv7` FOREIGN KEY (`pedal_type_id`) REFERENCES `pedal_types` (`id`),
  CONSTRAINT `FKm7w3ymrjangxn6eflaao9fmhu` FOREIGN KEY (`bearing_type_id`) REFERENCES `bearing_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedals`
--

LOCK TABLES `pedals` WRITE;
/*!40000 ALTER TABLE `pedals` DISABLE KEYS */;
INSERT INTO `pedals` VALUES (1,1001,'Чорний','Педалі Giant AC МТБ, сумісні з тукліпсами','Алюміній, сталь','Giant AC',560.31,'','Giant_AC','/resources/images/pedal_Giant_MTB.jpg','235 г',2,4,1),(2,1002,'Чорний','Педалі BBB BPD-17 CLASSICRIDE, зубчаста рама','Алюміній, сталь','BBB BPD-17 CLASSICRIDE',400,'','BBB_BPD-17_CLASSICRIDE','/resources/images/pedals_BBB.jpg','235 г',1,6,1),(3,1003,'Чорний','Педалі Shimano PD-M520 MTB SPD','Алюміній, сталь','Shimano PD-M520 MTB SPD',950.3,'','Shimano_PD-M520_MTB_SPD','/resources/images/perals_Shimano_Contact.jpg','250 г',1,2,2);
/*!40000 ALTER TABLE `pedals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rim_heights`
--

DROP TABLE IF EXISTS `rim_heights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rim_heights` (
  `id` bigint(20) NOT NULL,
  `height` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rim_heights`
--

LOCK TABLES `rim_heights` WRITE;
/*!40000 ALTER TABLE `rim_heights` DISABLE KEYS */;
/*!40000 ALTER TABLE `rim_heights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rim_wides`
--

DROP TABLE IF EXISTS `rim_wides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rim_wides` (
  `id` bigint(20) NOT NULL,
  `wide` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rim_wides`
--

LOCK TABLES `rim_wides` WRITE;
/*!40000 ALTER TABLE `rim_wides` DISABLE KEYS */;
INSERT INTO `rim_wides` VALUES (1,'15'),(2,'17'),(3,'19'),(4,'21'),(5,'23'),(6,'24.6');
/*!40000 ALTER TABLE `rim_wides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rims`
--

DROP TABLE IF EXISTS `rims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rims` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `brake_type` enum('DISC','V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `etrto_size` varchar(255) DEFAULT NULL,
  `inner_tube_diam` double DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `nipple` varchar(255) DEFAULT NULL,
  `rim_height` double DEFAULT NULL,
  `rim_wide` double DEFAULT NULL,
  `spoke_number` int(11) DEFAULT NULL,
  `wheels_diam_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg8dqt6ipwu4b76q2eo4lnowyj` (`type_id`),
  KEY `FK1c6tnxneruebemfyu2a8lujh3` (`maker_id`),
  KEY `FKiyl8hpi3371el41f3dwxrtei1` (`wheels_diam_id`),
  CONSTRAINT `FK1c6tnxneruebemfyu2a8lujh3` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKg8dqt6ipwu4b76q2eo4lnowyj` FOREIGN KEY (`type_id`) REFERENCES `bike_types` (`id`),
  CONSTRAINT `FKiyl8hpi3371el41f3dwxrtei1` FOREIGN KEY (`wheels_diam_id`) REFERENCES `wheels_diams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rims`
--

LOCK TABLES `rims` WRITE;
/*!40000 ALTER TABLE `rims` DISABLE KEYS */;
INSERT INTO `rims` VALUES (1,1801,'Чорний','Обід KLS Draft DSC 29\" AV 32 отвори','Алюміній','KLS Draft DSC 29\" AV 32',550,'KLS_Draft_DSC_29_AV_32','/resources/images/rim_AlexRims_29.jpg','572 г',1,'DISC',NULL,NULL,8,'1',NULL,3,2,5),(2,1802,'Чорний','Обід Mavic XM117 Disc ','Алюміній','Mavic XM117 Disc ',650,'Mavic_XM117_Disc ','/resources/images/rim-mavic_26.jpg','457 г',1,'DISC','1',NULL,4,'1',NULL,2,3,2);
/*!40000 ALTER TABLE `rims` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotor_diams`
--

DROP TABLE IF EXISTS `rotor_diams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotor_diams` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotor_diams`
--

LOCK TABLES `rotor_diams` WRITE;
/*!40000 ALTER TABLE `rotor_diams` DISABLE KEYS */;
INSERT INTO `rotor_diams` VALUES (1,'140'),(2,'160'),(3,'170'),(4,'180'),(5,'185'),(6,'200'),(7,'203');
/*!40000 ALTER TABLE `rotor_diams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotor_fix_types`
--

DROP TABLE IF EXISTS `rotor_fix_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rotor_fix_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotor_fix_types`
--

LOCK TABLES `rotor_fix_types` WRITE;
/*!40000 ALTER TABLE `rotor_fix_types` DISABLE KEYS */;
INSERT INTO `rotor_fix_types` VALUES (1,'6 болтів'),(2,'CenterLock Shimano');
/*!40000 ALTER TABLE `rotor_fix_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spoke_numbers`
--

DROP TABLE IF EXISTS `spoke_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spoke_numbers` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spoke_numbers`
--

LOCK TABLES `spoke_numbers` WRITE;
/*!40000 ALTER TABLE `spoke_numbers` DISABLE KEYS */;
INSERT INTO `spoke_numbers` VALUES (1,'28'),(2,'32'),(3,'36'),(4,'16'),(5,'20'),(6,'24');
/*!40000 ALTER TABLE `spoke_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spokes`
--

DROP TABLE IF EXISTS `spokes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spokes` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `diameter` varchar(255) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs4972mo4bmci3gyr8lpdfubuj` (`maker_id`),
  CONSTRAINT `FKs4972mo4bmci3gyr8lpdfubuj` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spokes`
--

LOCK TABLES `spokes` WRITE;
/*!40000 ALTER TABLE `spokes` DISABLE KEYS */;
INSERT INTO `spokes` VALUES (1,2201,'Чорний','Спиці 255 мм з ніпелями','2 мм','255 мм','Сталь','Спиці 255 мм',9,'спиці_255_мм_velo','/resources/images/spoke_255.jpg',11);
/*!40000 ALTER TABLE `spokes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stems`
--

DROP TABLE IF EXISTS `stems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stems` (
  `id` bigint(20) NOT NULL,
  `angle` varchar(255) DEFAULT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `length` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `diam_id` bigint(20) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `tube_diam_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpjhmmn4xyj8xgdug2xl0vetej` (`diam_id`),
  KEY `FKeexegfh2qlabhhgeax4xpbbik` (`maker_id`),
  KEY `FKeg00wlnmws4firrjg90hxxnpf` (`tube_diam_id`),
  CONSTRAINT `FKeexegfh2qlabhhgeax4xpbbik` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKeg00wlnmws4firrjg90hxxnpf` FOREIGN KEY (`tube_diam_id`) REFERENCES `tube_diameters` (`id`),
  CONSTRAINT `FKpjhmmn4xyj8xgdug2xl0vetej` FOREIGN KEY (`diam_id`) REFERENCES `handlebar_diameters` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stems`
--

LOCK TABLES `stems` WRITE;
/*!40000 ALTER TABLE `stems` DISABLE KEYS */;
INSERT INTO `stems` VALUES (1,'7',1301,'білий','Винос виготовлений з алюмінієвого сплаву 6061-Т6','130 мм','алюміній марки 6061-Т6','KLS Master',450.3,'KLS_Master','/resources/images/stem-kls-master.jpg',4,7,1),(2,'7',1302,'Чорний','Винос руля для гірських та кросових велосипедів','90 мм','кований алюміній','Giant ALLOY',500,'Giant_ALLOY','/resources/images/stem_Giant.jpg',4,4,1);
/*!40000 ALTER TABLE `stems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teethcapasitys`
--

DROP TABLE IF EXISTS `teethcapasitys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teethcapasitys` (
  `id` bigint(20) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teethcapasitys`
--

LOCK TABLES `teethcapasitys` WRITE;
/*!40000 ALTER TABLE `teethcapasitys` DISABLE KEYS */;
/*!40000 ALTER TABLE `teethcapasitys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tire_types`
--

DROP TABLE IF EXISTS `tire_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tire_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tire_types`
--

LOCK TABLES `tire_types` WRITE;
/*!40000 ALTER TABLE `tire_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `tire_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tire_wides`
--

DROP TABLE IF EXISTS `tire_wides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tire_wides` (
  `id` bigint(20) NOT NULL,
  `wide` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tire_wides`
--

LOCK TABLES `tire_wides` WRITE;
/*!40000 ALTER TABLE `tire_wides` DISABLE KEYS */;
INSERT INTO `tire_wides` VALUES (1,'2.0');
/*!40000 ALTER TABLE `tire_wides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tires`
--

DROP TABLE IF EXISTS `tires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tires` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `cord_type` varchar(255) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `tire_type` varchar(255) DEFAULT NULL,
  `tire_wide` double DEFAULT NULL,
  `size_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe0y4q4l0w6r0klrtfirmtq06c` (`maker_id`),
  KEY `FKgldsp0f4j75g4a642opqyr0vd` (`size_id`),
  CONSTRAINT `FKe0y4q4l0w6r0klrtfirmtq06c` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKgldsp0f4j75g4a642opqyr0vd` FOREIGN KEY (`size_id`) REFERENCES `wheels_diams` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tires`
--

LOCK TABLES `tires` WRITE;
/*!40000 ALTER TABLE `tires` DISABLE KEYS */;
INSERT INTO `tires` VALUES (1,1901,'Чорний','Покришка Minion DH Front 26X2.35, 60TPI, MAXXPRO, 60A','MINION DH F',360.3,'MINION_DH_F','/resources/images/tire_Maxxis_26.jpg','1',10,NULL,1,2);
/*!40000 ALTER TABLE `tires` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traction_types`
--

DROP TABLE IF EXISTS `traction_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traction_types` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traction_types`
--

LOCK TABLES `traction_types` WRITE;
/*!40000 ALTER TABLE `traction_types` DISABLE KEYS */;
INSERT INTO `traction_types` VALUES (1,'Верхня тяга'),(2,'Нижня тяга'),(3,'Універсальна тяга');
/*!40000 ALTER TABLE `traction_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trunk_bindings`
--

DROP TABLE IF EXISTS `trunk_bindings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trunk_bindings` (
  `id` bigint(20) NOT NULL,
  `trunk` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trunk_bindings`
--

LOCK TABLES `trunk_bindings` WRITE;
/*!40000 ALTER TABLE `trunk_bindings` DISABLE KEYS */;
INSERT INTO `trunk_bindings` VALUES (1,'Є'),(2,'Відсутнє');
/*!40000 ALTER TABLE `trunk_bindings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tube_diameters`
--

DROP TABLE IF EXISTS `tube_diameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tube_diameters` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tube_diameters`
--

LOCK TABLES `tube_diameters` WRITE;
/*!40000 ALTER TABLE `tube_diameters` DISABLE KEYS */;
INSERT INTO `tube_diameters` VALUES (1,'1 1/8'),(2,'1 1/8 - 1 1/4'),(3,'1 1/8 - 1.5'),(4,'1'),(5,'1.5'),(6,'1 1/5 - 1 1/8');
/*!40000 ALTER TABLE `tube_diameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `under_saddle_tubes`
--

DROP TABLE IF EXISTS `under_saddle_tubes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `under_saddle_tubes` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `under_saddle_tubes`
--

LOCK TABLES `under_saddle_tubes` WRITE;
/*!40000 ALTER TABLE `under_saddle_tubes` DISABLE KEYS */;
INSERT INTO `under_saddle_tubes` VALUES (1,'25.0'),(2,'25.4'),(3,'25.6'),(4,'26.4'),(5,'26.8'),(6,'27.0'),(7,'27.2'),(8,'28.6'),(9,'29.6'),(10,'30.0'),(11,'30.4'),(12,'30.6'),(13,'30.8'),(14,'30.9'),(15,'31.0'),(16,'31.2'),(17,'31.4'),(18,'31.6'),(19,'32.0'),(20,'34.9');
/*!40000 ALTER TABLE `under_saddle_tubes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `userRoleEnum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (0,'ADMIN'),(1,'USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wheels`
--

DROP TABLE IF EXISTS `wheels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wheels` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `description` longtext,
  `hub_description` longtext,
  `hub_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rim_description` longtext,
  `rim_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `brake_type` enum('DISC','V_BRAKE','UNIVERSAL') DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  `rim_wide` double DEFAULT NULL,
  `spoke_number` int(11) DEFAULT NULL,
  `wheels_diam` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `location` enum('FRONT','BACK','UNIVERSAL','SET') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8b0hkfxtx366i8aec2jub25i3` (`type_id`),
  KEY `FKt3or2sblu0bo4okscq2x2v55h` (`maker_id`),
  CONSTRAINT `FK8b0hkfxtx366i8aec2jub25i3` FOREIGN KEY (`type_id`) REFERENCES `bike_types` (`id`),
  CONSTRAINT `FKt3or2sblu0bo4okscq2x2v55h` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wheels`
--

LOCK TABLES `wheels` WRITE;
/*!40000 ALTER TABLE `wheels` DISABLE KEYS */;
INSERT INTO `wheels` VALUES (1,201,'Комплект коліс Shimano WH-MT15-A МТВ 29˝ QR Center Lock чорний','Тип кріплення: ексцентрик QR (QuickRelease) (QR);\n• Підшипники: \"конус-чашка\" (насипний);\n• Кількість отворів: 28/28;\n• Діаметр осі: 9/10 мм (передня/задня);\n• Ширина втулки (OLD): 100/135 мм (передня/задня);\n• Тип гальм: дискові (CenterLock);\n• Колір: чорний.',' ','Shimano WH-MT15-A МТВ 29˝',4900,'Матеріал ободів: алюміній;\n• Тип ободів: клінчер;\n• Розмір ободів: 622 x 19C (29\");\n• Кількість отворів: 28/28;\n• Висота обода: 19 мм;\n• Ширина обода: 24.6 мм;\n• Колір: чорний.',' ','Shimano_WH-MT15-A_МТВ_29','/resources/images/wheel_shimano_29.jpg',1,'DISC',1,6,1,'5',NULL,NULL,NULL,NULL),(2,202,'Комплект коліс 27,5\" Mavic Crossride Disc 650b.,15/12X142ММ ВІСЬ, INTL, ПАРА','\n• Кількість отворів: 24/24;\n• Матерiал корпуса: алюмиiнiй;\n• Колір: чорний.',' ','Mavic Crossride Disc 650b',7000,'Матеріал ободів: алюміній;\n• Розмір ободів: 650 x 19mm;\n• Кількість отворів: 24/24;\n• Колір: чорний.',' ','Mavic_Crossride_Disc_650b','/resources/images/wheel_Mavic_27_5.jpg',1,'DISC',4,3,6,'3',NULL,NULL,NULL,NULL),(3,203,'Комплект колiс Shimano WH-MT15-A МТВ 26\"','Тип кріплення: ексцентрик QR (QuickRelease) (QR);\n• Підшипники: \"конус-чашка\" (насипний);\n• Кількість отворів: 28/28;\n• Діаметр осі: 9/10 мм (передня/задня);\n• Ширина втулки (OLD): 100/135 мм (передня/задня);\n• Тип гальм: дискові (CenterLock);\n• Колір: чорний.',' ','Shimano WH-MT15-A МТВ 26˝',4600,'Матеріал ободів: алюміній;\n• Тип ободів: клінчер;\n• Розмір ободів: 559 x 19C (26\");\n• Кількість отворів: 28/28;\n• Висота обода: 19 мм;\n• Ширина обода: 24.6 мм;\n• Колір: чорний.',' ','Shimano_WH-MT15-A_МТВ_26','/resources/images/wheel_shimano_26.jpg',1,'DISC',1,6,1,'2',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `wheels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wheels_diams`
--

DROP TABLE IF EXISTS `wheels_diams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wheels_diams` (
  `id` bigint(20) NOT NULL,
  `diam` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wheels_diams`
--

LOCK TABLES `wheels_diams` WRITE;
/*!40000 ALTER TABLE `wheels_diams` DISABLE KEYS */;
INSERT INTO `wheels_diams` VALUES (1,'24'),(2,'26'),(3,'27.5'),(4,'28'),(5,'29'),(6,'20');
/*!40000 ALTER TABLE `wheels_diams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `windings`
--

DROP TABLE IF EXISTS `windings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `windings` (
  `id` bigint(20) NOT NULL,
  `article` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` longtext,
  `length` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `way` varchar(255) DEFAULT NULL,
  `wide` varchar(255) DEFAULT NULL,
  `maker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhm4ugd3e7fckm196nnsjbsq3b` (`maker_id`),
  CONSTRAINT `FKhm4ugd3e7fckm196nnsjbsq3b` FOREIGN KEY (`maker_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `windings`
--

LOCK TABLES `windings` WRITE;
/*!40000 ALTER TABLE `windings` DISABLE KEYS */;
INSERT INTO `windings` VALUES (1,1601,'білий','Призначена для обмотування дорожних рулів. Має клеєвий нижній шар.','1900 мм','вспінений каучук EVA','HQBC CARBOOK',630,'HQBC_CARBOOK','/resources/images/obmotka-rulya-hqbc-carbook.jpg','30 мм',6);
/*!40000 ALTER TABLE `windings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-08 15:11:01