USE `bd_encuestas`;
INSERT INTO `bd_encuestas`.`encuesta`
	(`fecha_creacion`, `fecha_inicio`, `fecha_final`)
	VALUES
	('2023-05-14', '2023-06-10', '2023-10-21')
;

INSERT INTO `bd_encuestas`.`pregunta`
	(`id_encuesta_asignada`, `categoria`, `enunciado`)
	VALUES
	(1, 'seleccion unica', '¿Quién escribió La Odisea?'),
	(1, 'seleccion multiple', '¿Quién es el dios de la guerra?'),
	(1, 'respuesta abierta', '¿Qué opina sobre la realidad económica del país?'),
	(1, 'valoracion cualitativa', '¿Qué tan de acuerdo esta con la presidensia de Biden?'),
	(1, 'seleccion unica', '¿En qué año comenzó la II Guerra Mundial?'),
    (1, 'seleccion unica', '¿Cómo se llama el himno nacional de Francia?'),
    (1, 'seleccion unica', '¿Quién traicionó a Jesús?'),
    (1, 'seleccion unica', '¿Cuál es la capital de Croacia?'),
    (1, 'seleccion multiple', '¿En qué películas protagonisa Tom Holland?'),
    (1, 'seleccion unica', 'Si 50 es el 100%, ¿cuánto es el 90%?')
;

INSERT INTO `bd_encuestas`.`respuesta`
	(`id_pregunta_asignada`, `la_respuesta`)
	VALUES
	(1, 'Homero'),
	(2, 'Ares'),
	(2, 'Marte'),
	(2, 'Tyr'),
	(5, '1939'),
    (6, 'La Marsellesa'),
    (7, 'Judas'),
    (8, 'Zagred'),
    (9, 'Spider-Man'),
    (9, 'Cherry'),
    (9, 'Lo Imposible'),
    (10,'45')
;