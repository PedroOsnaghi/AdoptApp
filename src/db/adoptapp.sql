use adoptapp;
INSERT INTO `usuario`(id,created_at, domicilio, email, imagen, nombre, password, presentacion, update_at, updated) VALUES (2,'2023-05-25 04:58:10.323000',NULL,'user@test','default.jpg','User Test','MTIzNA==',NULL,'2023-05-25 04:58:10.323000',_binary '\0'),
							 (3,'2023-05-25 04:58:10.323000',NULL,'user2@test','default.jpg','User2 Test','MTIzNA==',NULL,'2023-05-25 04:58:10.323000',_binary '\0'),
                              (4,'2023-05-25 04:58:10.323000',NULL,'user3@test','default.jpg','User3 Test','MTIzNA==',NULL,'2023-05-25 04:58:10.323000',_binary '\0');
INSERT INTO `mascota` VALUES (1,'1684958523727_7.jpg','hembra','2023-05-01 09:00:00.000000','Olimpia','Jugueton/a',0.5,'Bichon Maltes','Cuenta con Libreta de vacunacion al dia','perro',2),(2,'1685004091117_2.jpg','hembra',NULL,'Nina','Amoroso/a',0.5,'gatito','desparacitada y vacunada','gato',2);
							
INSERT INTO `publicacion` (id,bio,ciudad,create_at,direccion,disponibilidad,estado,latitud,longitud,provincia,mascota_id) VALUES (29,'Bichón Maltés es un perro pequeño originario de Italia que se caracteriza por su aspecto de ternura, ya que presume un cuerpo diminuto, de aproximadamente 23 cm de altura. Busca un hogar donde le den toda la atencion y cariño.','Villa Luzuriaga','2023-05-25 05:04:31.910000','Miguel Cané 1856, B1753FRL Villa Luzuriaga, Provincia de Buenos Aires, Argentina','De lunes a viernes a partir de las 14 hasta las 21 hs','disponible','-35','-59','Provincia de Buenos Aires',1),(30,' curiosos por naturaleza, así que es normal que explore cada rincón de tu hogar y escoja sus favoritos para dormir. Con seguridad tu cama se volverá su lugar especial para descansar por la mañana o la tarde debido a la comodidad y todo el espacio que pose','Isidro Casanova','2023-05-25 17:42:28.246000','Jorge Newbery 555, B1765BAK Isidro Casanova, Provincia de Buenos Aires, Argentina','Todos los dias a partir de las 18hs','disponible','-34.72109459999999','-58.581215','Provincia de Buenos Aires',2);
INSERT INTO `imagen` VALUES (37,'1684958671917_7.jpg',29),(38,'1684958671926_8.jpg',29),(39,'1684958671934_9.jpg',29),(40,'1684958671943_10.webp',29),(41,'1685004148255_1.webp',30),(42,'1685004148262_2.jpg',30),(43,'1685004148265_2.jpg',30);







