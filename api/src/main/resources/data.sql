DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS utilisateurs;
DROP TABLE IF EXISTS homeopathie;


CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);
 
INSERT INTO employees (first_name, last_name, mail, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');
  
CREATE TABLE utilisateurs (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  mail_utilisateur VARCHAR(250) NOT NULL
);

INSERT INTO utilisateurs (mail_utilisateur) VALUES
  ('admin@admin.admin');
  
CREATE TABLE homeopathie(
	id INT AUTO_INCREMENT  PRIMARY KEY,
  	nom_homeopathie VARCHAR(250) NOT NULL,
  	description_homeopathie VARCHAR(250) NOT NULL
);

INSERT INTO homeopathie (nom_homeopathie,description_homeopathie) VALUES
  ('Homéoplasmine', 'irritations de la peau'),
  ('Arnica MONTANA', 'utilisé en traumatologie, en cardiologie, et dans les troubles du comportement.'),
  ('Somnispray Mélatonine','pour les troubles du sommeil.'),
  ('Arnigel gel','indiqué dans le traitement des hématomes (bosses), ecchymoses (bleus), contusions (coups).'),
  ('NUX VOMICA','pour la Constipation, le ballonnements ou indigestion');
  