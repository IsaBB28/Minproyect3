# Minproyect3
AUTORES: Isabella Bastidas Borrero 2040127
Daniel Enrique Echeverria Villa 2177465


PARA PODER USAR EL PROGRAMA ES NECESARIO CONECTARLO A UNA BASE DE DATOS  

*se debe agregar al netbeans en las librerias el archivo .JAR llamado "postgresql-42.6.0"
**se debe descargar el postgresql 16.1  https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
** colocar de contraseña "postgres"

*aqui dejo lo que se debe copiar cuando se cree la base de datos "directorio" 


CREATE TABLE IF NOT EXISTS public.persona
(
    identification character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    adress_one character varying COLLATE pg_catalog."default" NOT NULL,
    adress_two character varying COLLATE pg_catalog."default",
    person_type character varying COLLATE pg_catalog."default" NOT NULL,
    contact_number_one character varying COLLATE pg_catalog."default" NOT NULL,
    type_contact_number_one character varying COLLATE pg_catalog."default" NOT NULL,
    contact_number_two character varying COLLATE pg_catalog."default",
    type_contact_number_two character varying COLLATE pg_catalog."default",
    birthdate date NOT NULL,
    CONSTRAINT persona_pkey PRIMARY KEY (identification)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persona
    OWNER to postgres;


**despues de esto debe dar play


cuando aparezca la tabla se presiona clic derecho, hay que ir a view y seleccionar all rows
    
