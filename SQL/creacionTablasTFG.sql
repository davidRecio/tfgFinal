

CREATE TABLE `usuario` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `url` varchar(40) DEFAULT NULL,
  `nombre` varchar(40) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `aptitudes` varchar(200) DEFAULT NULL,
  `intereses` varchar(200) DEFAULT NULL,
  `nivelconcentracion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `formulario` (
  `idformulario` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `tipo` varchar(1) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idformulario`),
  KEY `id_usuario_formulario_idx` (`idUsuario`),
  CONSTRAINT `id_usuario_formulario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `nota` (
  `idnota` int(11) NOT NULL,
  `url` varchar(300) CHARACTER SET utf8 NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `asignatura` varchar(300) CHARACTER SET utf8 NOT NULL,
  `tiempoEstudio` int(11) NOT NULL,
  `tiempoRecomendado` int(11) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `riesgo` int(11) DEFAULT NULL,
  `tipo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idnota`),
  KEY `idUsuario_notas_idx` (`idUsuario`),
  CONSTRAINT `idUsuario_notas` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pregunta` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `contenido` varchar(400) CHARACTER SET utf8 NOT NULL,
  `imagen` longtext,
  `tipo` varchar(1) CHARACTER SET utf8 NOT NULL DEFAULT 'C',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=latin1;

CREATE TABLE `respuesta` (
  `idrespuesta` int(11) NOT NULL,
  `idPregunta` int(11) NOT NULL,
  `idformulario` int(11) NOT NULL,
  `valor` varchar(3) NOT NULL,
  PRIMARY KEY (`idrespuesta`),
  KEY `idPregunta_respuesta_idx` (`idPregunta`),
  KEY `idFormulario_idx` (`idformulario`),
  CONSTRAINT `idFormulario` FOREIGN KEY (`idformulario`) REFERENCES `formulario` (`idformulario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idPregunta_respuesta` FOREIGN KEY (`idPregunta`) REFERENCES `pregunta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

