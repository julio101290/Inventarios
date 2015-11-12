-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-11-2015 a las 22:32:20
-- Versión del servidor: 5.6.25
-- Versión de PHP: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `INVEN`
--
CREATE DATABASE IF NOT EXISTS `INVEN` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `INVEN`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `PA_ActualizaCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_ActualizaCliente`(IN `Cliente` BIGINT, IN `Nombres` VARCHAR(200), IN `Apellidos` VARCHAR(200), IN `Ciudad` VARCHAR(200), IN `Telefono` VARCHAR(200), IN `RFC` VARCHAR(200), IN `FechaNacimiento` DATE, IN `Estado` VARCHAR(200), IN `Municipio` VARCHAR(200), IN `CodigoPostal` VARCHAR(200), IN `LugarNacimiento` VARCHAR(1000), IN `Direccion` VARCHAR(1000))
    MODIFIES SQL DATA
UPDATE `Clientes` SET 
`Nombres`=Nombres
,`Apellidos`=Apellidos
,`Direccion`=Direccion
,`Ciudad`=Ciudad
,`Telefono`=Telefono
,`RFC`=RFC
,`FechaNacimiento`=FechaNacimiento
,`Estado`=Estado
,`Municipio`=Municipio
,`CodigoPostal`=CodigoPostal
,`LugarNacimiento`=LugarNacimiento

WHERE idCliente=Cliente$$

DROP PROCEDURE IF EXISTS `PA_CuantosClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_CuantosClientes`(IN `Busqueda` VARCHAR(200))
    READS SQL DATA
    DETERMINISTIC
BEGIN

SELECT COUNT(*) as cuantos
FROM `INVEN`.`Clientes`
where Nombres LIKE CONCAT('%',Busqueda,'%')
	  or	Nombres LIKE CONCAT('%',Busqueda,'%')
      or	Apellidos LIKE CONCAT('%',Busqueda,'%')
      or	Direccion LIKE CONCAT('%',Busqueda,'%')
      or	Ciudad LIKE CONCAT('%',Busqueda,'%')
      or	Telefono LIKE CONCAT('%',Busqueda,'%')
      or	RFC LIKE CONCAT('%',Busqueda,'%')
      or	Estado LIKE CONCAT('%',Busqueda,'%');

END$$

DROP PROCEDURE IF EXISTS `PA_EliminarCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_EliminarCliente`(IN `idCliente1` BIGINT)
    NO SQL
delete 
FROM Clientes 
WHERE idCliente=idCliente1$$

DROP PROCEDURE IF EXISTS `PA_LeeCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_LeeCliente`(IN `cliente` BIGINT)
SELECT right(`Clientes`.`idCliente`,5) as idCliente,
    `Clientes`.`Nombres`,
    `Clientes`.`Apellidos`,
    `Clientes`.`Direccion`,
    `Clientes`.`Ciudad`,
    `Clientes`.`Telefono`,
    `Clientes`.`RFC`,
    `Clientes`.`FechaNacimiento`,
    `Clientes`.`Estado`,
    `Clientes`.`Municipio`,
    `Clientes`.`CodigoPostal`,
    `Clientes`.`LugarNacimiento`
FROM `INVEN`.`Clientes`
WHERE idCliente=cliente$$

DROP PROCEDURE IF EXISTS `PA_LeeClientes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PA_LeeClientes`(IN `desde` BIGINT, IN `cuantos` BIGINT, IN `Busqueda` VARCHAR(200))
BEGIN

SELECT right(`Clientes`.`idCliente`,5) as idCliente,
    `Clientes`.`Nombres`,
    `Clientes`.`Apellidos`,
    `Clientes`.`Direccion`,
    `Clientes`.`Ciudad`,
    `Clientes`.`Telefono`,
    `Clientes`.`RFC`,
    `Clientes`.`FechaNacimiento`,
    `Clientes`.`Estado`,
    `Clientes`.`Municipio`,
    `Clientes`.`CodigoPostal`
FROM `INVEN`.`Clientes`
where Nombres LIKE CONCAT('%',Busqueda,'%')
	  or	Nombres LIKE CONCAT('%',Busqueda,'%')
      or	Apellidos LIKE CONCAT('%',Busqueda,'%')
      or	Direccion LIKE CONCAT('%',Busqueda,'%')
      or	Ciudad LIKE CONCAT('%',Busqueda,'%')
      or	Telefono LIKE CONCAT('%',Busqueda,'%')
      or	RFC LIKE CONCAT('%',Busqueda,'%')
      or	Estado LIKE CONCAT('%',Busqueda,'%')
limit desde,cuantos;


END$$

DROP PROCEDURE IF EXISTS `sp_InsertaCliente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_InsertaCliente`(IN `Nombres` VARCHAR(200), IN `Apellidos` VARCHAR(200), IN `Direccion` VARCHAR(200), IN `Ciudad` VARCHAR(200), IN `Telefono` VARCHAR(200), IN `RFC` VARCHAR(10), IN `FechaNacimiento` VARCHAR(200), IN `Estado` VARCHAR(200), IN `Municipio` VARCHAR(200), IN `CodigoPostal` VARCHAR(200), IN `LugarNacimiento` VARCHAR(1000))
BEGIN
 
    INSERT INTO `Clientes`
    (
    `Nombres`,
    `Apellidos`,
    `Direccion`,
    `Ciudad`,
    `Telefono`,
    `RFC`,
    `FechaNacimiento`,
    `Estado`,
    `Municipio`,
    `CodigoPostal`,
    `LugarNacimiento`
        )
    VALUES
    (
    Nombres,
    Apellidos,
    Direccion,
    ciudad,
    Telefono,
    RFC,
    FechaNacimiento,
    Estado,
    Municipio,
    CodigoPostal,
    LugarNacimiento
    );
 
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
CREATE TABLE IF NOT EXISTS `Clientes` (
  `idCliente` bigint(20) unsigned zerofill NOT NULL,
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
  `LugarNacimiento` varchar(2000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Clientes`
--

UPDATE `Clientes` SET `idCliente` = 00000000000000000007,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000007;
UPDATE `Clientes` SET `idCliente` = 00000000000000000008,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000008;
UPDATE `Clientes` SET `idCliente` = 00000000000000000010,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000010;
UPDATE `Clientes` SET `idCliente` = 00000000000000000011,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000011;
UPDATE `Clientes` SET `idCliente` = 00000000000000000012,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000012;
UPDATE `Clientes` SET `idCliente` = 00000000000000000013,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000013;
UPDATE `Clientes` SET `idCliente` = 00000000000000000014,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000014;
UPDATE `Clientes` SET `idCliente` = 00000000000000000015,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000015;
UPDATE `Clientes` SET `idCliente` = 00000000000000000016,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000016;
UPDATE `Clientes` SET `idCliente` = 00000000000000000017,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000017;
UPDATE `Clientes` SET `idCliente` = 00000000000000000018,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000018;
UPDATE `Clientes` SET `idCliente` = 00000000000000000019,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000019;
UPDATE `Clientes` SET `idCliente` = 00000000000000000020,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000020;
UPDATE `Clientes` SET `idCliente` = 00000000000000000021,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000021;
UPDATE `Clientes` SET `idCliente` = 00000000000000000022,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000022;
UPDATE `Clientes` SET `idCliente` = 00000000000000000023,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000023;
UPDATE `Clientes` SET `idCliente` = 00000000000000000024,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000024;
UPDATE `Clientes` SET `idCliente` = 00000000000000000025,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000025;
UPDATE `Clientes` SET `idCliente` = 00000000000000000026,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000026;
UPDATE `Clientes` SET `idCliente` = 00000000000000000027,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '0000-00-00',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000027;
UPDATE `Clientes` SET `idCliente` = 00000000000000000028,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000028;
UPDATE `Clientes` SET `idCliente` = 00000000000000000029,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = 's',`LugarNacimiento` = '0' WHERE `Clientes`.`idCliente` = 00000000000000000029;
UPDATE `Clientes` SET `idCliente` = 00000000000000000030,`Nombres` = 'cesar',`Apellidos` = 'julio',`Direccion` = 'as',`Ciudad` = 's',`Telefono` = 's',`RFC` = 'asd',`FechaNacimiento` = '2015-11-01',`Estado` = 's',`Municipio` = 's',`CodigoPostal` = '0',`LugarNacimiento` = 'Los Mochis' WHERE `Clientes`.`idCliente` = 00000000000000000030;
UPDATE `Clientes` SET `idCliente` = 00000000000000000031,`Nombres` = 'NOmbre',`Apellidos` = 'Apellidos',`Direccion` = 'Domicilio',`Ciudad` = 'Ciudad',`Telefono` = 'Telefono',`RFC` = 'RFC',`FechaNacimiento` = '2006-10-14',`Estado` = 'Estado',`Municipio` = 'Municipio',`CodigoPostal` = '0',`LugarNacimiento` = 'asdasdasd' WHERE `Clientes`.`idCliente` = 00000000000000000031;
UPDATE `Clientes` SET `idCliente` = 00000000000000000032,`Nombres` = 'NOmbre',`Apellidos` = 'Apellidos',`Direccion` = 'Domicilio',`Ciudad` = 'Ciudad',`Telefono` = 'Telefono',`RFC` = 'RFC',`FechaNacimiento` = '2006-10-14',`Estado` = 'Estado',`Municipio` = 'Municipio',`CodigoPostal` = '0',`LugarNacimiento` = 'asdasdasd' WHERE `Clientes`.`idCliente` = 00000000000000000032;
UPDATE `Clientes` SET `idCliente` = 00000000000000000033,`Nombres` = 'NOmbre',`Apellidos` = 'Apellidos',`Direccion` = 'Domicilio',`Ciudad` = 'Ciudad',`Telefono` = 'Telefono',`RFC` = 'RFC',`FechaNacimiento` = '2006-10-14',`Estado` = 'Estado',`Municipio` = 'Municipio',`CodigoPostal` = '0',`LugarNacimiento` = 'asdasdasd' WHERE `Clientes`.`idCliente` = 00000000000000000033;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
CREATE TABLE IF NOT EXISTS `Usuarios` (
  `idUsuario` bigint(20) unsigned NOT NULL,
  `Usuario` varchar(300) NOT NULL,
  `Contra` varchar(300) NOT NULL,
  `Grupo` mediumint(9) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Usuarios`
--

UPDATE `Usuarios` SET `idUsuario` = 1,`Usuario` = 'Julio',`Contra` = 'Cesar',`Grupo` = 1 WHERE `Usuarios`.`idUsuario` = 1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  ADD UNIQUE KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Clientes`
--
ALTER TABLE `Clientes`
  MODIFY `idCliente` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `idUsuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
