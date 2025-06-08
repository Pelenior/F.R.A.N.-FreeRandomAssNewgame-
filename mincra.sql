-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2025 a las 13:02:23
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mincra`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ataques`
--

CREATE TABLE `ataques` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ataques`
--

INSERT INTO `ataques` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Curar', 'Ataque de sanación exclusivo para protagonistas'),
(2, 'Huir', 'Ataque para escapar exclusivo para protagonistas'),
(3, 'Por si Espada', 'Ataque básico con espada'),
(4, 'Arco', '7 de daño, pero tienes que recargar para usar otra vez'),
(5, 'Ataque Crítico', '0-15 de daño'),
(8, 'Hacha', '5 de daño'),
(9, 'Poción de Fuerza', 'Incrementa el daño del siguiente ataque en +4 de daño'),
(10, 'Maldición de Wither', 'Reduce la vida del enemigo en un 20% de su vida actual. Solo se puede usar una vez cada 3 turnos'),
(12, 'Tricotada', '2 de daño x 3 veces'),
(13, 'Ataque huevo', '4 de daño y +1 pollo'),
(14, 'Llamada de pollos', 'Te cubres de pollos y la siguiente vez que te ataquen, harás 4x el nº de pollos que tengas'),
(32, 'Puñetazo', 'Golpe básico con el puño'),
(33, 'Mordisco', 'Mordisco que puede causar infección'),
(34, 'Infección', 'Causa daño progresivo'),
(35, 'Puñetazo', 'Golpe básico con el puño'),
(36, 'Flecha', 'Dispara una flecha al objetivo'),
(37, 'Skele-Ton', 'Invoca un minion esqueleto'),
(38, 'Tss', 'Siseo del creeper antes de explotar'),
(39, 'Tss Tss', 'Siseo intensificado del creeper'),
(40, 'Explosión', 'Explosión que causa daño en área'),
(41, 'Espada', '3 de daño'),
(42, 'Ballesta', 'Disparo a distancia con ballesta'),
(43, 'Saqueo', 'Ataque de saqueo del pillager'),
(44, 'Hachazo', 'Golpe fuerte con hacha'),
(45, 'Carga', 'Ataque rápido de carga'),
(46, 'Carga Crítica', 'Carga con golpe crítico'),
(47, 'Invocación', 'Evocador invoca criaturas'),
(48, 'Cocodrilos', 'Evocador llama cocodrilos aliados'),
(49, 'Tótem de inmortalidad', 'Evocador usa tótem para evitar muerte'),
(50, 'Cabezazo', 'Golpe fuerte con la cabeza'),
(51, 'Mega Carga', 'Carga poderosa'),
(52, 'Desesperación', 'Ataque de alta desesperación'),
(53, 'Mega Mordisco', 'Gran mordisco'),
(54, 'Aliento de Dragón', 'Aliento de dragón que causa fuego'),
(55, 'Enderman', 'Teletransporte para confundir'),
(56, 'Hueso', 'Lanzamiento de hueso'),
(57, 'Gaster Blaster', 'Ráfaga de energía poderosa'),
(58, 'Sans Dance', 'Baile confuso'),
(59, 'Pollo', 'Picotazo rápido'),
(60, 'Despilfarro', 'Desgasta la resistencia enemiga'),
(61, 'Pectorales', 'Picotazo fuerte en el pecho'),
(62, 'Espadazo Corrupto', 'Golpe poderoso con espada corrupta'),
(63, 'Flecha Corrupta', 'Disparo con flecha corrupta'),
(64, 'Ataque Crítico Corrupto', 'Golpe crítico corrupto potente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enemigos`
--

CREATE TABLE `enemigos` (
  `nombre` varchar(50) NOT NULL,
  `vidaMax` double DEFAULT NULL,
  `defensa` double DEFAULT NULL,
  `fuerza` double DEFAULT NULL,
  `velocidad` double DEFAULT NULL,
  `idAscii` int(11) DEFAULT NULL,
  `isRaid` tinyint(1) DEFAULT NULL,
  `isBoss` tinyint(1) DEFAULT NULL,
  `isSteve` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `enemigos`
--

INSERT INTO `enemigos` (`nombre`, `vidaMax`, `defensa`, `fuerza`, `velocidad`, `idAscii`, `isRaid`, `isBoss`, `isSteve`) VALUES
('Coronel Sanders', 50, 5, 0, 5, 0, 0, 1, 0),
('Creeper', 15, 0, 0, 5, 0, 0, 0, 0),
('Dragon', 50, 5, 0, 5, 0, 0, 1, 0),
('Esqueleto', 15, 0, 0, 2, 0, 0, 0, 0),
('EvilSteve', 30, 5, 0, 5, 0, 0, 0, 1),
('Evoker', 15, 0, 0, 4, 0, 1, 0, 0),
('Pillager', 20, 1, 0, 3, 0, 1, 0, 0),
('Ravager', 30, 4, 0, 2, 0, 1, 1, 0),
('Sans', 1, 0, 0, 10, 0, 0, 1, 0),
('Vindicator', 20, 2, 0, 3, 0, 1, 0, 0),
('Zombie', 20, 1, 0, 1, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `nombre` varchar(50) NOT NULL,
  `contraseña` varchar(24) NOT NULL,
  `idAscii` int(11) DEFAULT NULL,
  `Puntuacion` int(11) NOT NULL,
  `Rank` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`nombre`, `contraseña`, `idAscii`, `Puntuacion`, `Rank`) VALUES
('', '', 99, 849, 'A-RANK'),
('Aitana', '1234', NULL, 0, ''),
('Bombardeen a Diego', 'BombardeenADiego', NULL, 0, ''),
('fran', 'flan', 99, 0, ''),
('John', '', 5, 0, ''),
('lol', 'lol', 3, 0, ''),
('Luna', '1234', NULL, 0, ''),
('Null', 'null', 3, 0, ''),
('Pelayo', '1234', 11, 1113, 'S-RANK');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajes`
--

CREATE TABLE `personajes` (
  `nombre` varchar(50) NOT NULL,
  `tipo` enum('protagonista','enemigo') NOT NULL,
  `vidaMax` double DEFAULT NULL,
  `defensa` double DEFAULT NULL,
  `fuerza` double DEFAULT NULL,
  `velocidad` double DEFAULT NULL,
  `idAscii` int(11) DEFAULT NULL,
  `karma` tinyint(1) DEFAULT NULL,
  `isRaid` tinyint(1) DEFAULT NULL,
  `isBoss` tinyint(1) DEFAULT NULL,
  `isSteve` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personajes`
--

INSERT INTO `personajes` (`nombre`, `tipo`, `vidaMax`, `defensa`, `fuerza`, `velocidad`, `idAscii`, `karma`, `isRaid`, `isBoss`, `isSteve`) VALUES
('Alex', 'protagonista', 30, 0, 0, 1, 3, 1, NULL, NULL, NULL),
('Chicken Little', 'protagonista', 15, 0, 0, 3.5, 4, 0, NULL, NULL, NULL),
('Coronel Sanders', 'enemigo', 50, 5, 0, 5, 0, NULL, 0, 1, 0),
('Creeper', 'enemigo', 15, 0, 0, 5, 0, NULL, 0, 0, 0),
('Dragon', 'enemigo', 50, 5, 0, 5, 0, NULL, 0, 1, 0),
('Esqueleto', 'enemigo', 15, 0, 0, 2, 0, NULL, 0, 0, 0),
('EvilSteve', 'enemigo', 30, 5, 0, 5, 0, NULL, 0, 0, 1),
('Evoker', 'enemigo', 15, 0, 0, 4, 0, NULL, 1, 0, 0),
('Pillager', 'enemigo', 20, 1, 0, 3, 0, NULL, 1, 0, 0),
('Ravager', 'enemigo', 30, 4, 0, 2, 0, NULL, 1, 0, 0),
('Sans', 'enemigo', 1, 0, 0, 10, 0, NULL, 0, 1, 0),
('Steve', 'protagonista', 20, 0, 1, 3, 2, 0, NULL, NULL, NULL),
('Vindicator', 'enemigo', 20, 2, 0, 3, 0, NULL, 1, 0, 0),
('Zombie', 'enemigo', 20, 1, 0, 1, 0, NULL, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `protagonistas`
--

CREATE TABLE `protagonistas` (
  `nombre` varchar(50) NOT NULL,
  `vidaMax` double DEFAULT NULL,
  `defensa` double DEFAULT NULL,
  `fuerza` double DEFAULT NULL,
  `velocidad` double DEFAULT NULL,
  `idAscii` int(11) DEFAULT NULL,
  `karma` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `protagonistas`
--

INSERT INTO `protagonistas` (`nombre`, `vidaMax`, `defensa`, `fuerza`, `velocidad`, `idAscii`, `karma`) VALUES
('Alex', 30, 0, 0, 1, 3, 1),
('Chicken Little', 15, 0, 0, 3.5, 4, 0),
('Steve', 20, 0, 1, 3, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_ataques`
--

CREATE TABLE `relacion_ataques` (
  `personaje_nombre` varchar(50) NOT NULL,
  `ataque_id` int(11) NOT NULL,
  `tipo_personaje` enum('protagonista','enemigo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `relacion_ataques`
--

INSERT INTO `relacion_ataques` (`personaje_nombre`, `ataque_id`, `tipo_personaje`) VALUES
('Alex', 8, 'protagonista'),
('Alex', 9, 'protagonista'),
('Alex', 10, 'protagonista'),
('Chicken Little', 12, 'protagonista'),
('Chicken Little', 13, 'protagonista'),
('Chicken Little', 14, 'protagonista'),
('Coronel Sanders', 59, 'enemigo'),
('Coronel Sanders', 60, 'enemigo'),
('Coronel Sanders', 61, 'enemigo'),
('Creeper', 38, 'enemigo'),
('Creeper', 39, 'enemigo'),
('Creeper', 40, 'enemigo'),
('Dragón', 53, 'enemigo'),
('Dragón', 54, 'enemigo'),
('Dragón', 55, 'enemigo'),
('Esqueleto', 35, 'enemigo'),
('Esqueleto', 36, 'enemigo'),
('Esqueleto', 37, 'enemigo'),
('EvilSteve', 62, 'enemigo'),
('EvilSteve', 63, 'enemigo'),
('EvilSteve', 64, 'enemigo'),
('Evoker', 47, 'enemigo'),
('Evoker', 48, 'enemigo'),
('Evoker', 49, 'enemigo'),
('Pillager', 41, 'enemigo'),
('Pillager', 42, 'enemigo'),
('Pillager', 43, 'enemigo'),
('Ravager', 50, 'enemigo'),
('Ravager', 51, 'enemigo'),
('Ravager', 52, 'enemigo'),
('Sans', 56, 'enemigo'),
('Sans', 57, 'enemigo'),
('Sans', 58, 'enemigo'),
('Steve', 3, 'protagonista'),
('Steve', 4, 'protagonista'),
('Steve', 5, 'protagonista'),
('Vindicator', 44, 'enemigo'),
('Vindicator', 45, 'enemigo'),
('Vindicator', 46, 'enemigo'),
('Zombie', 32, 'enemigo'),
('Zombie', 33, 'enemigo'),
('Zombie', 34, 'enemigo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `enemigos`
--
ALTER TABLE `enemigos`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `personajes`
--
ALTER TABLE `personajes`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `protagonistas`
--
ALTER TABLE `protagonistas`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `relacion_ataques`
--
ALTER TABLE `relacion_ataques`
  ADD PRIMARY KEY (`personaje_nombre`,`ataque_id`),
  ADD KEY `ataque_id` (`ataque_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ataques`
--
ALTER TABLE `ataques`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `relacion_ataques`
--
ALTER TABLE `relacion_ataques`
  ADD CONSTRAINT `fk_relacion_ataques_personaje` FOREIGN KEY (`personaje_nombre`) REFERENCES `personajes` (`nombre`) ON DELETE CASCADE,
  ADD CONSTRAINT `relacion_ataques_ibfk_1` FOREIGN KEY (`ataque_id`) REFERENCES `ataques` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
