DROP TABLE ACCIDENTE;
DROP TABLE ASISTENTES;
DROP TABLE CAPACITACION;
DROP TABLE VENTAS;
DROP TABLE CHEQUEOS;
DROP TABLE CHEQUEOVISITA;
DROP TABLE ADMINISTRATIVOS;
DROP TABLE PROFESIONALES;
DROP TABLE USUARIOS;
DROP TABLE CLIENTE;
drop table pagoclientes;
DROP TABLE visita;

--CREACION DE TABLAS Y MODELO RELACIONAL--

create table cliente (
rutcliente number(9) not null,
nombres varchar2(30)not null,
apellidos varchar2 (30)not null,
telefono varchar2(20) not null,
afp varchar2 (30),
sistemasalud number(2),
direccion varchar2(70),
comuna varchar2(50),
edad number(3) not null,
constraint Cliente_pk primary key (rutcliente));

create table Capacitacion (
idcapacitacion number(9) not null,
fecha date,
hora date,
lugar varchar2(50) not null,
duracion number(3),
cantidadasistentes number(5) not null,
Cliente_rutcliente number(9) not null,
CONSTRAINT Capacitacion_Cliente_FK FOREIGN KEY(Cliente_rutcliente) REFERENCES cliente,
CONSTRAINT Capacitacion_PK PRIMARY KEY (idcapacitacion));

create table Asistentes(
idasistente number(9) not null,
nombres varchar2(100) not null,
edad number(3) not null,
Capacitacion_idcapacitacion number(9) not null,
CONSTRAINT Asistentes_Capacitacion_FK foreign key(Capacitacion_idcapacitacion) REFERENCES Capacitacion,
CONSTRAINT Asistentes_PK primary key (idasistente));

create table VISITA (
    IDVISITA NUMBER(9) not null,
    VISFECHA DATE not null,
    VISHORA DATE,
    VISLUGAR VARCHAR2(50) not null,
    VISCOMENTARIOS VARCHAR2(250),
    CLIENTE_RUTCLIENTE NUMBER(9) not null,
    CONSTRAINT IDVISITA_pk primary key (IDVISITA),
    CONSTRAINT VISITA_Cliente_fk FOREIGN key(CLIENTE_RUTCLIENTE) REFERENCES CLIENTE);
    
CREATE TABLE ACCIDENTE (
    idaccidente NUMBER(9),
    accifecha DATE NOT NULL,
    accihora DATE NOT NULL,
    accilugar VARCHAR2(150) not null,
    acciorigen VARCHAR2(100)not null,
    acciconsecuencias VARCHAR2(100),
    Cliente_rutcliente NUMBER(9),
    CONSTRAINT ACCIDENTE_PK primary key (idaccidente),
    CONSTRAINT ACCIDENTE_CLIENTE_FK FOREIGN key(CLIENTE_RUTCLIENTE) REFERENCES CLIENTE);
    
CREATE TABLE CHEQUEOS (
idchequeo NUMBER,
nombrechequeo VARCHAR2 (75) NOT NULL,
cliente_rutcliente number(9) not null,
CONSTRAINT Chequeo_pk PRIMARY KEY (idchequeo),
CONSTRAINT Chequeo_Cliente_FK FOREIGN KEY(cliente_rutcliente) REFERENCES cliente);

CREATE TABLE CHEQUEOVISITA (
idchequeovisita NUMBER,
estado VARCHAR2 (75) NOT NULL,
chequeovisita_idvisita NUMBER (9) NOT NULL,
CHECK (estado IN('Se Cumple','Se Cumple C/Obs','No se cumple')),
CONSTRAINT Chequeovisita_pk PRIMARY KEY (idchequeovisita),
CONSTRAINT Chequeovisita_visita_FK FOREIGN KEY (chequeovisita_idvisita) REFERENCES visita);

CREATE TABLE administrativos (
rutadmi VARCHAR2(20),
nombre VARCHAR2(30) NOT NULL,
apellidos VARCHAR2(30) NOT NULL,
correo VARCHAR2(50) NOT NULL,
area VARCHAR2(30) NOT NULL,
CONSTRAINT administrativos_pk PRIMARY KEY (rutadmi));

CREATE TABLE profesionales (
rutprof VARCHAR2(20),
nombre VARCHAR2(30) NOT NULL,
apellidos VARCHAR2(30) NOT NULL,
telefono VARCHAR2(50) NOT NULL,
titulo VARCHAR2(30) NOT NULL,
proyecto VARCHAR2(30) NOT NULL,
CONSTRAINT profesionales_pk PRIMARY KEY (rutprof));


CREATE TABLE Usuarios (
idusuario number(9),
nombre VARCHAR2(30) NOT NULL,
apellidos VARCHAR2(30) NOT NULL,
fecha_nacimiento DATE,
rutusuario VARCHAR2 (10) NOT NULL,
cliente_rutcliente number(9),
administrativos_rutadmi VARCHAR2(20),
profesionales_rutprof VARCHAR2(20),
CONSTRAINT Usuario_pk PRIMARY KEY (idusuario),
CONSTRAINT Usuarios_Cliente_FK FOREIGN KEY(cliente_rutcliente) REFERENCES cliente,
CONSTRAINT Usuarios_Administrativos_FK FOREIGN KEY(administrativos_rutadmi) REFERENCES administrativos,
CONSTRAINT Usuarios_Profesionales_FK FOREIGN KEY(profesionales_rutprof) REFERENCES profesionales);


CREATE TABLE PAGOCLIENTE (
idpago NUMBER(9),
fechadepago date not null,
montodepago NUMBER not null,
mesdepago NUMBER not null,
añodepago NUMBER not null,
cliente_rutcliente number(9) NOT NULL,
CONSTRAINT Pagocliente_pk PRIMARY KEY (idpago),
CONSTRAINT Pagocliente_Cliente_FK FOREIGN KEY(cliente_rutcliente) REFERENCES cliente);

CREATE TABLE asesoria (
idasesorias NUMBER,
fecharealizacion date not null,
motivo VARCHAR2(100) not null,
prof_rutprof VARCHAR2(20),
CONSTRAINT Asesoria_pk PRIMARY KEY (idasesorias),
CONSTRAINT Asesoria_profesional_FK FOREIGN KEY(prof_rutprof) REFERENCES profesionales);

CREATE TABLE mejoras (
idmejoras NUMBER,
titulodeactividad VARCHAR2(100) not null,
descripcion VARCHAR2(100) not null,
plazo number not null,
mejoras_idasesorias number,
CONSTRAINT Mejoras_pk PRIMARY KEY (idmejoras),
CONSTRAINT Mejoras_asesoria_FK FOREIGN KEY(mejoras_idasesorias) REFERENCES asesoria);


--CREACION DE DISPARADORES Y SECUENCIAS--

CREATE SEQUENCE capa_seq;

CREATE OR REPLACE TRIGGER capa_bir
BEFORE INSERT ON capacitacion 
FOR EACH ROW
WHEN (new.idcapacitacion IS NULL)
BEGIN
 SELECT capa_seq.NEXTVAL
 INTO :new.idcapacitacion
 FROM dual;
END;

CREATE SEQUENCE asist_seq;

CREATE OR REPLACE TRIGGER asist_bir
BEFORE INSERT ON asistentes 
FOR EACH ROW
WHEN (new.idasistente IS NULL)
BEGIN
 SELECT asist_seq.NEXTVAL
 INTO :new.idasistente
 FROM dual;
END;

CREATE SEQUENCE pagos_seq;

CREATE OR REPLACE TRIGGER pagos_bir
BEFORE INSERT ON pagocliente 
FOR EACH ROW
WHEN (new.idpago IS NULL)
BEGIN
 SELECT pagos_seq.NEXTVAL
 INTO :new.idpago
 FROM dual;
END;

--INSERCION DE DATOS--


--CLIENTE 1--
insert into cliente values(2333888,'Jose','Marchant',214536987,'modelo', 1,'Los Almendros 2309','La Pintana', 35);
insert into cliente values(4658731,'Pablo','Perez',521478693,'provida', 1,'Los carezos 872','valparaiso', 28);
insert into cliente values(5327461,'Juana','Molina',845967125,'Habitat', 2,'Rancagua 297','valparaiso', 45);
commit;

--CAPACITACION 2--
INSERT INTO "CAPACITACION" (FECHA, HORA, LUGAR, DURACION, cantidadasistentes,cliente_rutcliente ) VALUES (TO_DATE('23/10/2020','dd/mm/yy'),to_date('13:00','hh24:mi'), 'Puente Alto', '130','45',2333888);
INSERT INTO "CAPACITACION" (FECHA, HORA, LUGAR, DURACION, cantidadasistentes,cliente_rutcliente ) VALUES (TO_DATE('15/11/2020','dd/mm/yy'),to_date('11:00','hh24:mi'), 'Cajon del Maipo', '180','63',4658731);
INSERT INTO "CAPACITACION" (FECHA, HORA, LUGAR, DURACION, cantidadasistentes,cliente_rutcliente ) VALUES (TO_DATE('26/09/2020','dd/mm/yy'),to_date('09:00','hh24:mi'),'vitacura','90','100',5327461);
commit;

--ASISTENTES 3--
INSERT INTO "ASISTENTES" (NOMBRES,EDAD,CAPACITACION_IDCAPACITACION) VALUES ('Mariana Marchesse','35',1);
INSERT INTO "ASISTENTES" (NOMBRES,EDAD,CAPACITACION_IDCAPACITACION) VALUES ('Mariela Montenegro','40',2);
INSERT INTO "ASISTENTES" (NOMBRES,EDAD,CAPACITACION_IDCAPACITACION) VALUES ('Lorena Morales','28',3);
commit;

--VISITA 4--
insert into visita values(1,TO_DATE('29-07-2020','dd/mm/yy'),to_date('13:00','hh24:mi'),'providencia','todo en orden',2333888);
insert into visita values(2,TO_DATE('18-09-2020','dd/mm/yy'),to_date('16:00','hh24:mi'),'santiago','Un accidente',4658731);
insert into visita values(3,TO_DATE('07-11-2020','dd/mm/yy'),to_date('18:00','hh24:mi'),'la florida','baja asistencia',5327461);
commit;

--ACCIDENTE 5--
INSERT INTO "ACCIDENTE" (IDACCIDENTE,ACCIFECHA,ACCIHORA,ACCILUGAR,ACCIORIGEN,ACCICONSECUENCIAS,CLIENTE_RUTCLIENTE) VALUES (1,TO_DATE('24/05/2020','dd/mm/yy'),to_date('09:00','hh24:mi'),'EN LA MICRO','CAMINO AL TRABAJO','ESGUINCE BRAZO DERECHO',2333888);
INSERT INTO "ACCIDENTE" (IDACCIDENTE,ACCIFECHA,ACCIHORA,ACCILUGAR,ACCIORIGEN,ACCICONSECUENCIAS,CLIENTE_RUTCLIENTE) VALUES (2,TO_DATE('15/09/2020','dd/mm/yy'),to_date('18:00','hh24:mi'),'EN AUTO','CAMINO A LA CASA','CONTUSION',4658731);
INSERT INTO "ACCIDENTE" (IDACCIDENTE,ACCIFECHA,ACCIHORA,ACCILUGAR,ACCIORIGEN,ACCICONSECUENCIAS,CLIENTE_RUTCLIENTE) VALUES (3,TO_DATE('28/10/2020','dd/mm/yy'),to_date('15:00','hh24:mi'),'EN LA MICRO','CAMINO AL TRABAJO','ESGUINCE BRAZO DERECHO',5327461);
commit;

------CHEQUEOS 6----
INSERT INTO "CHEQUEOS" (IDCHEQUEO,NOMBRECHEQUEO,CLIENTE_RUTCLIENTE) VALUES (1,'MIKE',2333888);
INSERT INTO "CHEQUEOS" (IDCHEQUEO,NOMBRECHEQUEO,CLIENTE_RUTCLIENTE) VALUES (2,'JAMES',4658731);
INSERT INTO "CHEQUEOS" (IDCHEQUEO,NOMBRECHEQUEO,CLIENTE_RUTCLIENTE) VALUES (3,'VEGETA',5327461);
commit;

--- CHEQUEOVISITA 7---
INSERT INTO "CHEQUEOVISITA" (IDCHEQUEOVISITA,ESTADO,CHEQUEOVISITA_IDVISITA) VALUES (1,'Se Cumple',1);
INSERT INTO "CHEQUEOVISITA" (IDCHEQUEOVISITA,ESTADO,CHEQUEOVISITA_IDVISITA) VALUES (2,'No se cumple',2);
INSERT INTO "CHEQUEOVISITA" (IDCHEQUEOVISITA,ESTADO,CHEQUEOVISITA_IDVISITA) VALUES (3,'No se cumple',3);
commit;

--- ADMINISTRATIVOS 8---

INSERT INTO "ADMINISTRATIVOS" (RUTADMI,NOMBRE,APELLIDOS,CORREO,AREA) VALUES (208783651,'ERIKA','RAMIREZ ORTEGA','ERIK.A@GMAIL.COM','SALUD');
INSERT INTO "ADMINISTRATIVOS" (RUTADMI,NOMBRE,APELLIDOS,CORREO,AREA) VALUES (198745678,'MARK','JOHNOSON PARIS','MARKJ@OUTLOOK.COM','DEPORTE');
INSERT INTO "ADMINISTRATIVOS" (RUTADMI,NOMBRE,APELLIDOS,CORREO,AREA) VALUES (188253629,'MARCO','ANTONIO SOLIS','MARKITOSOLITO@GMAIL.COM','INFORMATICA');
commit;

---PROFESIONALES 9---

INSERT INTO "PROFESIONALES" (RUTPROF,NOMBRE,APELLIDOS,TELEFONO,TITULO,PROYECTO) VALUES (208783651,'SONYA','CABEZAS BILCHES',94483773,'ENFERMERA','UMBRELLA');
INSERT INTO "PROFESIONALES" (RUTPROF,NOMBRE,APELLIDOS,TELEFONO,TITULO,PROYECTO) VALUES (168726948,'YASUO','UZUMAKI OMAEWA',97653993,'ING COMERCIAL','KATANA');
INSERT INTO "PROFESIONALES" (RUTPROF,NOMBRE,APELLIDOS,TELEFONO,TITULO,PROYECTO) VALUES (112683019,'MOHAMED','ALI HERRERA',89483187,'ED FISICA','BOXEO');
commit;

--USUARIOS 10--
--USUARIO CLIENTE--
insert into usuarios (idusuario,nombre,apellidos,fecha_nacimiento,rutusuario,cliente_rutcliente,administrativos_rutadmi,profesionales_rutprof) values(1,'Jose','Marchant',TO_DATE('12-12-1989','dd/mm/yy'),2333888,2333888,NULL,NULL);
--USUARIO ADMINISTRATIVO--
insert into usuarios (idusuario,nombre,apellidos,fecha_nacimiento,rutusuario,cliente_rutcliente,administrativos_rutadmi,profesionales_rutprof) values(2,'ERIKA','RAMIREZ ORTEGA',TO_DATE('25-09-1986','dd/mm/yy'),208783651,NULL,208783651,NULL);
--USUARIO PROFESIONAL--
insert into usuarios (idusuario,nombre,apellidos,fecha_nacimiento,rutusuario,cliente_rutcliente,administrativos_rutadmi,profesionales_rutprof) values(3,'MOHAMED','ALI HERRERA',TO_DATE('29-07-1990','dd/mm/yy'),112683019,NULL,NULL,112683019);
commit;

--PAGOCLIENTE 11--
insert into pagocliente values(1,TO_DATE('29-07-2020','dd/mm/yy'),3000000,7,2020,2333888);
insert into pagocliente values(2,TO_DATE('28-08-2020','dd/mm/yy'),8000000,8,2020,4658731);
insert into pagocliente values(3,TO_DATE('27-09-2020','dd/mm/yy'),5000000,9,2020,5327461);
commit;

--ASESORIA 12--
INSERT INTO asesoria (IDASESORIAS, FECHAREALIZACION, MOTIVO, PROF_RUTPROF) VALUES (1,TO_DATE('02/11/2020','dd/mm/yy'),'Financiera',208783651);
INSERT INTO asesoria (IDASESORIAS, FECHAREALIZACION, MOTIVO, PROF_RUTPROF) VALUES (2,TO_DATE('12/10/2020','dd/mm/yy'),'Salud',168726948);
INSERT INTO asesoria (IDASESORIAS, FECHAREALIZACION, MOTIVO, PROF_RUTPROF) VALUES (3,TO_DATE('13/09/2020','dd/mm/yy'),'Educacion',112683019);
commit;

--MEJORAS 13--
INSERT INTO  MEJORAS values(1,'flujo de caja','mejoramiento del flujo de caja',120,1);
INSERT INTO  MEJORAS values(2,'seguridad','mejoras de seguridad',90,2);
INSERT INTO  MEJORAS values(3,'Rentabilidad','reduccion de costos',68,3);
commit;


--CONSULTAS DEL MODELO RELACIONAL--

/* a)Realice una consulta que permita listar todas las capacitaciones de un cliente en
particular, indicando el nombre completo, la edad y el correo electrónico de los
asistentes.*/
SELECT
  (c.nombres || ' ' || c.apellidos) as nombre_completo,
  c.edad,
  a.nombres
FROM  cliente c
JOIN capacitacion k 
ON c.rutcliente = k.cliente_rutcliente 
join asistentes a 
on k.idcapacitacion = a.capacitacion_idcapacitacion
where rutcliente=2333888;

/* b)Realice una consulta que permita desplegar todas las visitas en terreno realizadas a los
clientes que sean de la comuna de Valparaíso. Por cada visita debe indicar todos los
chequeos que se hicieron en ella, junto con el estado de cumplimiento de cada uno.*/
SELECT 
c.comuna,
v.idvisita,
cv.idchequeovisita,
cv.estado
FROM cliente c
JOIN visita v
ON c.rutcliente = v.cliente_rutcliente
JOIN chequeovisita cv
on v.idvisita = cv.chequeovisita_idvisita
where c.comuna = 'valparaiso';

/* c)Realice una consulta que despliegue los accidentes registrados para todos los clientes,
indicando los datos de detalle del accidente, y el nombre, apellido, RUT y teléfono del
cliente al que se asocia dicha situación.*/
SELECT
    c.nombres || ' ' || c.apellidos as nombre_clte,
    c.rutcliente,
    c.telefono,
    a.acciorigen,
    a.acciconsecuencias
FROM cliente c
JOIN accidente a
ON c.rutcliente = a.cliente_rutcliente;





    

