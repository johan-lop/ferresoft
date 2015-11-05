-- DROP TABLE maestro.tipo_pago;

CREATE TABLE maestro.tipo_pago
(
  id serial NOT NULL,
  descripcion character varying(30),
  iporte integer,
  CONSTRAINT pk_tipo_pago PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE maestro.tipo_pago
  OWNER TO ferremauros_web;