CREATE TABLE postulantes (
    id_postulante                   INTEGER NOT NULL,
    estado_inscrito                 VARCHAR2(20 CHAR) NOT NULL,
    num_cedula_identidad            VARCHAR2(9 CHAR) NOT NULL,
    fecha_de_nacimiento             DATE NOT NULL,
    primer_apellido                 VARCHAR2(20 CHAR) NOT NULL,
    segundo_apellido                VARCHAR2(20 CHAR) NOT NULL,
    nombres                         VARCHAR2(30 CHAR) NOT NULL,
    nacionalidad                    VARCHAR2(20 CHAR) NOT NULL,
    estado_civil                    CHAR(1 CHAR) NOT NULL,
    certificado_permanencia         CHAR(1),
    fecha_certificado_permanencia   DATE,
    es_separado_de_hecho            CHAR(1) NOT NULL,
    titulo                          VARCHAR2(30)
);

ALTER TABLE postulantes ADD CONSTRAINT postulante_pk PRIMARY KEY (id_postulante );

ALTER TABLE postulantes ADD CONSTRAINT rut_postu_unique UNIQUE (num_cedula_identidad);


CREATE SEQUENCE postulantes_seq START WITH 1;

CREATE OR REPLACE TRIGGER postulante_bir 
BEFORE INSERT ON postulantes 
FOR EACH ROW

BEGIN
  SELECT postulantes_seq.NEXTVAL
  INTO   :new.id_postulante
  FROM   dual;
END;

CREATE TABLE cuentas_ahorros_viviendas (
    num_cuenta             INTEGER NOT NULL,
    saldo                  INTEGER NOT NULL,
    fecha_apertura         DATE NOT NULL,
    nombre_banco           VARCHAR2(30 CHAR) NOT NULL,
    tipo_cuenta_bancaria   VARCHAR2(20 CHAR) NOT NULL,
    id_del_postulante      INTEGER NOT NULL references postulantes(id_postulante)
);

ALTER TABLE cuentas_ahorros_viviendas ADD CONSTRAINT cuentas_ahorros_viviendas_pk PRIMARY KEY ( num_cuenta );

ALTER TABLE cuentas_ahorros_viviendas ADD CONSTRAINT cuentas_postu_unique UNIQUE (id_del_postulante);


-----NUEVAS

Create Table DATOS_DE_CONTACTOS (
    telefono_trabajo    INTEGER,
    telefono_movil      INTEGER NOT NULL,
    email               VARCHAR2(50 CHAR) NOT NULL,
    telefono_domicilio  INTEGER,
    codigo_postal       INTEGER NOT NULL,
    id_postulante       INTEGER NOT NULL references postulantes(id_postulante)
);

ALTER TABLE DATOS_DE_CONTACTOS ADD CONSTRAINT datos_postu_unique UNIQUE (id_postulante);

Create Table DIRECCION (
    calle               VARCHAR2(100 CHAR) NOT NULL,
    numero              SMALLINT NOT NULL,
    bloc                VARCHAR2(10 CHAR),
    departamento        SMALLINT,
    manzana             VARCHAR2(10 CHAR),
    sitio               VARCHAR2(10 CHAR),
    region              NUMBER(3) NOT NULL,
    comuna              VARCHAR2(20 CHAR) NOT NULL,
    localidad           VARCHAR2(20 CHAR) NOT NULL,
    poblacion           VARCHAR2(20 CHAR) NOT NULL,
    id_postulante       INTEGER NOT NULL references postulantes(id_postulante)
    
);

ALTER TABLE DIRECCION ADD CONSTRAINT dir_postu_unique UNIQUE (id_postulante);


