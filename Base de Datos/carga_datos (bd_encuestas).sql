USE `bd_encuestas`;
INSERT INTO `bd_encuestas`.`encuesta`
	(`id_encuesta`, `fecha_creacion`, `fecha_inicio`, `fecha_final`)
	VALUES
	(1, '2023-05-14', '2023-06-10', '2023-10-21')
;

INSERT INTO `bd_encuestas`.`pregunta`
	(`id_pregunta`, `id_encuesta_asignada`, `categoria`, `enunciado`)
	VALUES
	(1, 1, 'seleccion unica', '¿Quién escribió La Odisea?'),
	(2, 1, 'seleccion multiple', '¿Quién es el dios de la guerra?'),
	(3, 1, 'respuesta abierta', '¿Qué opina sobre la realidad económica del país?'),
	(4, 1, 'valoracion cualitativa', '¿Qué tan de acuerdo esta con la presidensia de Biden?'),
	(5, 1, 'seleccion unica', '¿En qué año comenzó la II Guerra Mundial?'),
    (6, 1, 'seleccion unica', '¿Cómo se llama el himno nacional de Francia?'),
    (7, 1, 'seleccion unica', '¿Quién traicionó a Jesús?'),
    (8, 1, 'seleccion unica', '¿Cuál es la capital de Croacia?'),
    (9, 1, 'seleccion multiple', '¿En qué películas protagonisa Tom Holland?'),
    (10, 1, 'seleccion unica', 'Si 50 es el 100%, ¿cuánto es el 90%?')
;

INSERT INTO `bd_encuestas`.`respuesta`
	(`id_respuesta`, `id_pregunta_asignada`, `la_respuesta`)
	VALUES
	(1, 1, 'Homero'),
	(2, 2, 'Ares'),
	(3, 2, 'Marte'),
	(4, 2, 'Tyr'),
	(5, 5, '1939'),
    (6, 6, 'La Marsellesa'),
    (7, 7, 'Judas'),
    (8, 8, 'Zagred'),
    (9, 9, 'Spider-Man'),
    (10, 9, 'Cherry'),
    (11, 9, 'Lo Imposible'),
    (12, 10,'45')
;
