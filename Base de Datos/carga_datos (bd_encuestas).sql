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
	(`id_pregunta_asignada`, `la_respuesta`, `correcto`)
	VALUES
	(1, 'Homero', TRUE),
    (1, 'Aquiles', FALSE),
    (1, 'Aristoteles', FALSE),
    (1, 'Miguelangelo', FALSE),
	(2, 'Ares', TRUE),
	(2, 'Marte', TRUE),
	(2, 'Tyr', TRUE),
    (2, 'Atreus', FALSE),
	(5, '1939', TRUE),
    (5, '1945', FALSE),
    (5, '1911', FALSE),
    (5, '1926', FALSE),
    (6, 'La Marsellesa', TRUE),
    (6, 'Dernière danse', FALSE),
    (6, 'Francesca', FALSE),
    (6, 'La Boxeuse Amoureuse', FALSE),
    (7, 'Pedro', FALSE),
    (7, 'Simón', FALSE),
    (7, 'Judas', TRUE),
    (7, 'Mateo', FALSE),
    (8, 'Bern', FALSE),
    (8, 'Bucarest', FALSE),
    (8, 'Riga', FALSE),
    (8, 'Zagred', TRUE),
    (9, 'Spider-Man', TRUE),
    (9, 'Exit', FALSE),
    (9, 'Cherry', TRUE),
    (9, 'Lo Imposible', TRUE),
    (10, '49', FALSE),
    (10,'45', TRUE),
    (10, '40', FALSE),
    (10, '63', FALSE)
;
