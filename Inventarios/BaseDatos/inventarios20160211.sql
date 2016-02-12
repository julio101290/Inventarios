CREATE DATABASE  IF NOT EXISTS `INVEN` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `INVEN`;
-- MySQL dump 10.16  Distrib 10.1.10-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: INVEN
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clientes` (
  `idCliente` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(100) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Ciudad` varchar(45) DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `RFC` varchar(45) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Municipio` varchar(45) DEFAULT NULL,
  `CodigoPostal` varchar(45) DEFAULT NULL,
  `LugarNacimiento` varchar(2000) NOT NULL,
  UNIQUE KEY `idCliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
REPLACE INTO `Clientes` VALUES (00000000000000000008,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000017,'cesar','julio','as','s','s','asd','2015-01-01','','','',''),(00000000000000000020,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000022,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000023,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000024,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000025,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000026,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000027,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000028,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000029,'cesar','julio','as','s','s','asd','2015-01-01','s','s','s','0'),(00000000000000000030,'cesar','julio','as','s','s','asd','2015-01-01','s','s','0','Los Mochis'),(00000000000000000034,'Mariela','Salomon','Domicilio','jjr','0000000','RFC','1990-07-27','','','','');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estados`
--

DROP TABLE IF EXISTS `Estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estados` (
  `idPais` bigint(20) unsigned NOT NULL,
  `idEstado` bigint(20) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(800) NOT NULL,
  UNIQUE KEY `Estado` (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estados`
--

LOCK TABLES `Estados` WRITE;
/*!40000 ALTER TABLE `Estados` DISABLE KEYS */;
REPLACE INTO `Estados` VALUES (1,1,'CHIHUAHUA'),(2,3,''),(2,4,''),(1,6,'asd'),(1,7,'dasq'),(1,8,'dasdad'),(1,9,'qweqw'),(1,10,'qweqwe'),(1,11,'123'),(1,12,'123');
/*!40000 ALTER TABLE `Estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GruposUsuarios`
--

DROP TABLE IF EXISTS `GruposUsuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GruposUsuarios` (
  `IdGrupoUsuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(200) NOT NULL,
  `accesoUsuarios` tinyint(1) DEFAULT '0',
  `accesoGrupos` tinyint(1) DEFAULT '0',
  `accesoClientes` tinyint(1) DEFAULT '0',
  `accesoArticulos` tinyint(1) DEFAULT '0',
  `accesoConfiguracion` tinyint(1) DEFAULT '0',
  `accesoInventario` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`IdGrupoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GruposUsuarios`
--

LOCK TABLES `GruposUsuarios` WRITE;
/*!40000 ALTER TABLE `GruposUsuarios` DISABLE KEYS */;
REPLACE INTO `GruposUsuarios` VALUES (2,'PRUEBAS',1,1,1,1,1,1),(9,'Administrador',0,0,0,0,0,0),(10,'Supervisor',1,1,1,1,1,1),(11,'Desarrollador',1,0,0,0,0,1),(12,'Inventario',1,0,0,0,0,1),(21,'s',1,1,1,1,1,1),(22,'1',0,0,0,0,1,0),(23,'2',0,1,0,0,0,0),(24,'3',1,0,0,0,0,0),(25,'4',0,0,1,0,0,0),(26,'5',0,0,0,1,0,0),(27,'6',0,0,0,0,0,1);
/*!40000 ALTER TABLE `GruposUsuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paises`
--

DROP TABLE IF EXISTS `Paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Paises` (
  `idPais` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paises`
--

LOCK TABLES `Paises` WRITE;
/*!40000 ALTER TABLE `Paises` DISABLE KEYS */;
REPLACE INTO `Paises` VALUES (1,'MEXICO'),(2,'Estados Unidos Americanos');
/*!40000 ALTER TABLE `Paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `idUsuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(300) NOT NULL,
  `Contra` varchar(300) NOT NULL,
  `Grupo` mediumint(9) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `Usuario` (`Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
REPLACE INTO `Usuarios` VALUES (1,'Julio','Cesar',2,'adas'),(3,'asad','123',10,'asad'),(4,'123','123',13,'123'),(5,'1231','123',2,'1231'),(9,'123123','12312',12,'123123'),(10,'12312','123',12,'12312'),(11,'asd','asd',12,'asd'),(12,'','',2,'');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-11 23:08:26
