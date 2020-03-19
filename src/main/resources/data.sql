DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer
(
    id      serial PRIMARY KEY NOT NULL,
    name            character varying,
    active_day_points smallint

);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    code          serial PRIMARY KEY NOT NULL,
    name          character varying  NOT NULL,
    cost          smallint           NOT NULL


);
insert into customer
values (1, 'James L. Aumiller',100),
       (2, 'Jason V. Capps',200),
       (3, 'Joshua Y. Pearson',0);

insert into product
values (1, 'Hatlam',10),
(2, 'Phys Fintone',20),
(3, 'New-Sing',30),
(4, 'Biolam',40),
(5, 'Kanstock',50);
-- TODO clean up db

