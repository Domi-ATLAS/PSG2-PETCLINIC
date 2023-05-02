-- One admin user, named admin1 with passwor 4dm1n and authority admin
INSERT INTO users(username,password,enabled,plan) VALUES ('admin1','4dm1n',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin');
-- One owner user, named owner1 with passwor 0wn3r
INSERT INTO users(username,password,enabled,plan) VALUES ('owner1','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (2,'owner1','owner');
-- One vet user, named vet1 with passwor v3t
INSERT INTO users(username,password,enabled,plan) VALUES ('vet1','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (3,'vet1','veterinarian');

INSERT INTO users(username,password,enabled,plan) VALUES ('Guaje','1111',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (4,'Guaje','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner2','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (5,'owner2','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner3','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (6,'owner3','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner4','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (7,'owner4','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner5','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (8,'owner5','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner6','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (9,'owner6','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner7','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (10,'owner7','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner8','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (11,'owner8','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('owner9','0wn3r',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (12,'owner9','owner');

INSERT INTO users(username,password,enabled,plan,prefered_currency) VALUES ('David','1111',TRUE,'ADVANCED','BTC');
INSERT INTO authorities(id,username,authority) VALUES (13,'David','owner');

INSERT INTO users(username,password,enabled,plan) VALUES ('vet2','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (14,'vet2','veterinarian');

INSERT INTO users(username,password,enabled,plan) VALUES ('vet3','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (15,'vet3','veterinarian');

INSERT INTO users(username,password,enabled,plan) VALUES ('vet4','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (16,'vet4','veterinarian');

INSERT INTO users(username,password,enabled,plan) VALUES ('vet5','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (17,'vet5','veterinarian');

INSERT INTO users(username,password,enabled,plan) VALUES ('vet6','v3t',TRUE,'BASIC');
INSERT INTO authorities(id,username,authority) VALUES (18,'vet6','veterinarian');

INSERT INTO vets(id, first_name,last_name, username) VALUES (1, 'James', 'Carter', 'vet1');
INSERT INTO vets(id, first_name,last_name, username) VALUES (2, 'Helen', 'Leary', 'vet2');
INSERT INTO vets(id, first_name,last_name, username) VALUES (3, 'Linda', 'Douglas', 'vet3');
INSERT INTO vets(id, first_name,last_name, username) VALUES (4, 'Rafael', 'Ortega', 'vet4');
INSERT INTO vets(id, first_name,last_name, username) VALUES (5, 'Henry', 'Stevens', 'vet5');
INSERT INTO vets(id, first_name,last_name, username) VALUES (6, 'Sharon', 'Jenkins', 'vet6');

INSERT INTO specialties VALUES (1, 'radiologia');
INSERT INTO specialties VALUES (2, 'cirugia');
INSERT INTO specialties VALUES (3, 'odontologia');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);
INSERT INTO vet_specialties VALUES (1, 2);

INSERT INTO types VALUES (1, 'gato');
INSERT INTO types VALUES (2, 'perro');
INSERT INTO types VALUES (3, 'lagarto');
INSERT INTO types VALUES (4, 'serpiente');
INSERT INTO types VALUES (5, 'pajaro');
INSERT INTO types VALUES (6, 'hamster');

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'owner1');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'owner2');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'owner3');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'owner4');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'owner5');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'owner6');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'owner7');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'owner8');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'owner9');
INSERT INTO owners VALUES (9, 'David', 'Reyes', '2749 Blackhawk Trail', 'Madison', '6085559435', 'David');
INSERT INTO owners VALUES (11, 'Juan Jesus', 'Campos', '2335 Independence La.', 'Waunakee', '6085555487', 'Guaje');

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (9, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (11, 'Pizarro', '2010-03-09', 5, 9);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (12, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (13, 'Sly', '2012-06-08', 1, 10);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (14, 'Pelu', '2010-06-24', 2, 11);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (15, 'Messi', '2012-06-08', 1, 11);

INSERT INTO visits(id,pet_id,visit_date,description) VALUES (1, 7, '2013-01-01', 'vacuna contra la rabia');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (2, 8, '2013-01-02', 'vacuna contra la rabia');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (3, 8, '2013-01-03', 'castrado');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'esterilizado');

INSERT INTO cause(id, name, description, budget_target, non_profit_organization, is_closed) 
VALUES (1, 'CausaEjemplo1', 'Para recaudar dinero para escuela', 320.0, 'ZarrinONG', FALSE);

INSERT INTO donation (id, amount, message, donor_name, date) VALUES (1, 300.0, 'Para la PlayStation5', 'Paquito el chocolatero', '2023-01-05');

INSERT INTO cause_donations (cause_id, donations_id) VALUES (1,1);

INSERT INTO adoption_request(id,message,author_id,pet_id,selected_response_id) VALUES(1,'Hola',3,3,null);

INSERT INTO adoption_response(id,description,owner_id) VALUES(1,'Hola',11);

INSERT INTO adoption_request_responses(adoption_request_id,responses_id) VALUES(1,1);

