USE test;
DROP TABLE IF EXISTS part;
-- create table
CREATE TABLE part
  (
    Id INT(30) not null AUTO_INCREMENT PRIMARY KEY,
    Name varchar(30) not null,
    Need varchar(30) not null,
    Quant varchar(30) not null

  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO part(Name,Need,Quant) VALUES ('MotherBoard ASUS','Yes','5');
INSERT INTO part(Name,Need,Quant) VALUES ('HDD SEAGATE','Yes','7');
INSERT INTO part(Name,Need,Quant) VALUES ('Sound Card Espada','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Video Card','Yes','6');
INSERT INTO part(Name,Need,Quant) VALUES ('CPU','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Case lighting','No','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Case','Yes','5');
INSERT INTO part(Name,Need,Quant) VALUES ('USB flash','No','10');
INSERT INTO part(Name,Need,Quant) VALUES ('SSD','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Memory DDR4 2Gb','Yes','5');
INSERT INTO part(Name,Need,Quant) VALUES ('Memory DDR3 4Gb','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Memory DDR4 8Gb','Yes','0');
INSERT INTO part(Name,Need,Quant) VALUES ('MotherBoard','Yes','5');
INSERT INTO part(Name,Need,Quant) VALUES ('HDD','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Sound Card','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('MotherBoard GIGABYTE','Yes','5');
INSERT INTO part(Name,Need,Quant) VALUES ('HDD TOSHIBA','Yes','4');
INSERT INTO part(Name,Need,Quant) VALUES ('Mouse ','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('MotherBoard MSI','Yes','0');
INSERT INTO part(Name,Need,Quant) VALUES ('HDD ORIENT','Yes','1');
INSERT INTO part(Name,Need,Quant) VALUES ('Sound Card ASUS','Yes','1');
INSERT INTO part(Name,Need,Quant) VALUES ('WIFI Router','No','5');
INSERT INTO part(Name,Need,Quant) VALUES ('HDD TRANSCEND','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Keyboard','Yes','10');
INSERT INTO part(Name,Need,Quant) VALUES ('Video Camera','Yes','5');

