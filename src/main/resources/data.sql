INSERT INTO status(name) VALUES ('Pendiente');
INSERT INTO status(name) VALUES ('Aceptado');
INSERT INTO status(name) VALUES ('Rechazado');

INSERT INTO personality(name) VALUES ('Estricto');
INSERT INTO personality(name) VALUES ('Aventurero');
INSERT INTO personality(name) VALUES ('Divertido');
INSERT INTO personality(name) VALUES ('Sociable');
INSERT INTO personality(name) VALUES ('Conservador');


INSERT INTO race(name) VALUES ('Akita');
INSERT INTO race(name) VALUES ('Alaskan Malamute');
INSERT INTO race(name) VALUES ('Bichón');
INSERT INTO race(name) VALUES ('Bobtail ');
INSERT INTO race(name) VALUES ('Boston Terrier');
INSERT INTO race(name) VALUES ('Boxer');
INSERT INTO race(name) VALUES ('Bull Terrier');
INSERT INTO race(name) VALUES ('Bulldog');
INSERT INTO race(name) VALUES ('Chihuahua');
INSERT INTO race(name) VALUES ('Cocker');
INSERT INTO race(name) VALUES ('Dálmata');
INSERT INTO race(name) VALUES ('Dóberman');
INSERT INTO race(name) VALUES ('Husky');
INSERT INTO race(name) VALUES ('Labrador');
INSERT INTO race(name) VALUES ('Lebrel');
INSERT INTO race(name) VALUES ('Mastín ');
INSERT INTO race(name) VALUES ('Pastor Alemán');
INSERT INTO race(name) VALUES ('Pastor Australiano');
INSERT INTO race(name) VALUES ('Pastor Ucraniano');
INSERT INTO race(name) VALUES ('Pitbull American Terrier');
INSERT INTO race(name) VALUES ('Pug');
INSERT INTO race(name) VALUES ('Rottweiler');
INSERT INTO race(name) VALUES ('San Bernardo');
INSERT INTO race(name) VALUES ('Schnauzer');
INSERT INTO race(name) VALUES ('Shih Tzu');
INSERT INTO race(name) VALUES ('Terranova');
INSERT INTO race(name) VALUES ('Volpino Italiano');
INSERT INTO race(name) VALUES ('Whippet ');
INSERT INTO race(name) VALUES ('Yorkshire Terrier');
INSERT INTO race(name) VALUES ('Otra Raza');

INSERT INTO district(name) VALUES ('Breña');
INSERT INTO district(name) VALUES ('Carabayllo');
INSERT INTO district(name) VALUES ('Chaclacayo');
INSERT INTO district(name) VALUES ('Chorrillos');
INSERT INTO district(name) VALUES ('Cieneguilla');
INSERT INTO district(name) VALUES ('Comas');
INSERT INTO district(name) VALUES ('El Agustino');
INSERT INTO district(name) VALUES ('Independencia');
INSERT INTO district(name) VALUES ('Jesús María');
INSERT INTO district(name) VALUES ('La Molina');
INSERT INTO district(name) VALUES ('La Victoria');
INSERT INTO district(name) VALUES ('Lima');
INSERT INTO district(name) VALUES ('Lince');
INSERT INTO district(name) VALUES ('Los Olivos');
INSERT INTO district(name) VALUES ('Lurigancho');
INSERT INTO district(name) VALUES ('Lurín');
INSERT INTO district(name) VALUES ('Magdalena del Mar');
INSERT INTO district(name) VALUES ('Miraflores');
INSERT INTO district(name) VALUES ('Pachacamac');
INSERT INTO district(name) VALUES ('Pucusana');
INSERT INTO district(name) VALUES ('Pueblo Libre');
INSERT INTO district(name) VALUES ('Puente Piedra');
INSERT INTO district(name) VALUES ('Punta Hermosa');
INSERT INTO district(name) VALUES ('Punta Negra');
INSERT INTO district(name) VALUES ('Rimac');
INSERT INTO district(name) VALUES ('San Bartolo');
INSERT INTO district(name) VALUES ('San Borja');
INSERT INTO district(name) VALUES ('San Isidro');
INSERT INTO district(name) VALUES ('San Juan de Lurigancho');
INSERT INTO district(name) VALUES ('San Juan de Miraflores');
INSERT INTO district(name) VALUES ('San Luis');
INSERT INTO district(name) VALUES ('San Martín de Porres');
INSERT INTO district(name) VALUES ('San Miguel');
INSERT INTO district(name) VALUES ('Santa Anita');
INSERT INTO district(name) VALUES ('Santa María del Mar');
INSERT INTO district(name) VALUES ('Santa Rosa');
INSERT INTO district(name) VALUES ('Santiago de Surco');
INSERT INTO district(name) VALUES ('Surquillo');
INSERT INTO district(name) VALUES ('Villa El Salvador');
INSERT INTO district(name) VALUES ('Villa María del Triunfo');

INSERT INTO character(name) VALUES ('Sociable');
INSERT INTO character(name) VALUES ('Calmado');
INSERT INTO character(name) VALUES ('Agresivo');
INSERT INTO character(name) VALUES ('Tímido');
INSERT INTO character(name) VALUES ('Dominante');
INSERT INTO character(name) VALUES ('Docil');

INSERT INTO time(time,value) VALUES ('15 minutos','0.25');
INSERT INTO time(time,value) VALUES ('30 minutos', '0.5');
INSERT INTO time(time,value) VALUES ('45 minutos','0.75');
INSERT INTO time(time,value) VALUES ('1 hora','1.0');
INSERT INTO time(time,value) VALUES ('1 hora y 15 minutos','1.25');
INSERT INTO time(time,value) VALUES ('1 hora y 30 minutos','1.5');
INSERT INTO time(time,value) VALUES ('1 hora y 45 minutos','1.75');
INSERT INTO time(time,value) VALUES ('2 horas','2.0');
INSERT INTO time(time,value) VALUES ('2 horas y 15 minutos','2.25');
INSERT INTO time(time,value) VALUES ('2 horas y 30 minutos','2.5');
INSERT INTO time(time,value) VALUES ('2 horas y 45 minutos','2.75');
INSERT INTO time(time,value) VALUES ('3 horas','3.0');


INSERT INTO owner(last_Names, password, email, address, date_Of_Birth, first_Names,id_District)VALUES ('Parvina', '123', 'maria@gmail.com', 'Los claveles', '12/08/1990', 'Maria', 1);
INSERT INTO owner(last_Names, password, email, address, date_Of_Birth, first_Names,id_District)VALUES ('Prado', '456', 'juan@gmail.com', 'el tambo', '01/08/1980', 'Juan', 5);
INSERT INTO owner(last_Names, password, email, address, date_Of_Birth, first_Names,id_District)VALUES ('Chavez', '159', 'Pablo@gmail.com', 'N°123', '08/10/1987', 'Pablo', 1);
INSERT INTO owner(last_Names, password, email, address, date_Of_Birth, first_Names,id_District)VALUES ('Rosales', '753', 'Miriam@gmail.com', 'las hormigas N° 147', '15/04/1989', 'Miriam', 11);

INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Prado', 'Soy estudiante de la carrera de Ingeniería Insdustrial -  UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','sandra@gmail.com', 'Calle 334 las palmas', '10/08/1999', '10.0', 'Sandra', 1, 2);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Reyes', 'Soy estudiante de la carrera de Ingeniería Industrial, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','marcos@gmail.com', 'Calle 334 las palmas', '10/08/2000', '15.0', 'Marcos', 10, 1);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Perez', 'Soy estudiante de la carrera de Ingeniería Insdustrial -  UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','jean@gmail.com', 'Calle 334 las palmas', '10/08/1999', '12.0', 'Jean', 1, 2);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Alvarado', 'Soy estudiante de la carrera Arquitectura de la UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','dennis@gmail.com', 'Calle 334 las palmas', '10/08/2000', '15.0', 'Dennis', 10, 1);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Tineo', 'Soy estudiante de la carrera de Musica -  UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','pablo@gmail.com', 'Calle 334 las palmas', '10/08/1999', '14.0', 'Pablo', 2, 2);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Rosales', 'Soy estudiante de la carrera Ingenieria Civil, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','ruth@gmail.com', 'Calle 334 las palmas', '10/08/2000', '20.0', 'Ruth', 10, 1);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('De la Cruz', 'Soy estudiante de la carrera de Ingeniería Insdustrial -  UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','camila@gmail.com', 'Calle 334 las palmas', '10/08/1999', '20.0', 'Camila', 1, 2);
INSERT INTO walker(last_Names,description,password,email,address, date_Of_Birth, cost_Service,first_Names, id_District, id_Personality)VALUES ('Robles', 'Soy estudiante de la carrera de Ingeniería de Sistemas de información de la UPC, me encantan los animales y en mis tiempo libres me gusta sacarlos a pasear', '123','rodrigo@gmail.com', 'Calle 334 las palmas', '10/08/1998', '15.0', 'Rodrigo', 10, 1);



INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Doky', 'Es jugueton','12/02/20', 1,1,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Canela', 'Es jugueton','12/02/20', 1,2,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Concovo', 'Es jugueton','12/02/20', 1,3,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Thor', 'Es jugueton','12/02/20', 1,4,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Loky', 'Es jugueton','12/02/20', 1,2,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Heracles', 'Es jugueton','12/02/20', 1,3,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Lucas', 'Es jugueton','12/02/20', 1,3,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Aquiles', 'Es jugueton','12/02/20', 1,1,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Loky', 'Es jugueton','12/02/20', 1,2,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Heracles', 'Es jugueton','12/02/20', 1,3,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Lucas', 'Es jugueton','12/02/20', 1,3,1);
INSERT INTO dog(name,description,date_Of_Birth,id_Character,id_Race,id_Owner)VALUES ('Aquiles', 'Es jugueton','12/02/20', 1,1,1);

INSERT INTO feedback(comment,rating,id_owner,id_walker) VALUES('excelente paseador',5,1,2);


INSERT INTO service_request(date_service, start_time, time_limit, total_service_cost, id_owner, id_status, id_time, id_walker) VALUES ( '12/02/22', '10', '10:15', 1, 1, 2, 1, 2);

