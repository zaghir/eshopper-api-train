insert into compagnie_ferroviaire (id, nom) values (1, 'RATP'), (2, 'SNCF');

insert into gare (id, nom, ville) values 
(1, 'Saint-Lazare', 'Paris'), 
(2, 'Montparnasse', 'Paris'), 
(3, 'Gare du Nord', 'Paris'),
(4, 'Gare de Lyon', 'Paris'),
(5, 'La Défense', 'Puteaux')
;

/*insert into reservation_train (nb_passagers, type_siege) values (1, 'classe unique');*/

insert into trajet (id, classe_voyage, date_heure_depart, date_heure_arrivee, nb_places, numero, type_train) values
(1, 'Classe unique', '2019-10-09 08:34:00', '2019-10-09 08:47:00', 1, 488011, 'RER A');

update trajet set gare_depart = (select id from gare where nom = 'La Défense') where numero = 488011;
update trajet set gare_arrivee = (select id from gare where nom = 'Gare de Lyon') where numero = 488011;
update trajet set compagnie_ferroviaire = (select id from compagnie_ferroviaire where nom = 'RATP') where numero = 488011;