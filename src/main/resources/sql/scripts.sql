create database db_allergies;

use db_allergies;

create table allergy_master(
                               id int(3) auto_increment primary key,
                               allergy_name varchar(120) not null);

insert allergy_master (allergy_name) values ('Skin Allergy'), ('Food Allergy'), ('Dust Allergy'), ('Light Allergy'), ('Insect Allergy'), ('Latex Allergy'), ('Mold Allergy'), ('Pollen Allergy');

select * from allergy_master;
