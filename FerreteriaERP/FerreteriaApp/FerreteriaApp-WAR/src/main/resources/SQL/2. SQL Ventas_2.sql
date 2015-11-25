-- Table: maestro.cliente

-- DROP TABLE maestro.cliente;

CREATE TABLE maestro.cliente
(
  id serial NOT NULL,
  nombre character varying(100),
  tipo_documento integer,
  numero_documento character varying(50),
  ciudad_id integer,
  direccion character varying(150),
  telefono character varying(50),
  celular character varying(50),
  contacto character varying(50),
  CONSTRAINT "PK_cliente" PRIMARY KEY (id),
  CONSTRAINT "FK_cliente_municipio" FOREIGN KEY (ciudad_id)
      REFERENCES maestro.municipio (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_cliente_tipo_identificacion" FOREIGN KEY (tipo_documento)
      REFERENCES maestro.tipo_identificacion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE maestro.cliente
  OWNER TO postgres;

-- Table: maestro.tipo_pago

-- DROP TABLE maestro.tipo_pago;

CREATE TABLE maestro.tipo_pago
(
  id serial NOT NULL,
  descripcion character varying(30),
  importe integer,
  CONSTRAINT pk_tipo_pago PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE maestro.tipo_pago
  OWNER TO ferremauros_web;


-- Table: maestro.tipo_venta

-- DROP TABLE maestro.tipo_venta;

CREATE TABLE maestro.tipo_venta
(
  id serial NOT NULL,
  descripcion character varying(20),
  CONSTRAINT "PK_tipo_venta" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE maestro.tipo_venta
  OWNER TO ferremauros_web;

-- Table: transaccional.venta

-- DROP TABLE transaccional.venta;

CREATE TABLE transaccional.venta
(
  id serial NOT NULL,
  numero_remision integer,
  numero_factura integer,
  aplica_iva boolean,
  subtotal double precision,
  total_iva double precision,
  total double precision,
  fecha_factura timestamp without time zone,
  cliente_id integer,
  tipo_venta_id integer,
  tipo_pago_id integer,
  fecha_vencimiento timestamp without time zone,
  total_importe double precision,
  CONSTRAINT "PK_venta" PRIMARY KEY (id),
  CONSTRAINT "FK_venta_cliente" FOREIGN KEY (cliente_id)
      REFERENCES maestro.cliente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_venta_tipo_pago" FOREIGN KEY (tipo_pago_id)
      REFERENCES maestro.tipo_pago (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_venta_tipo_venta" FOREIGN KEY (tipo_venta_id)
      REFERENCES maestro.tipo_venta (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE transaccional.venta
  OWNER TO ferremauros_web;

-- Table: transaccional.detalle_venta

-- DROP TABLE transaccional.detalle_venta;

CREATE TABLE transaccional.detalle_venta
(
  id serial NOT NULL,
  venta_id integer,
  producto_id integer,
  cantidad integer,
  aplica_iva boolean,
  iva_incluido boolean,
  precio integer,
  total double precision,
  CONSTRAINT "PK_detalle_venta" PRIMARY KEY (id),
  CONSTRAINT "FK_detalle_venta_producto" FOREIGN KEY (producto_id)
      REFERENCES maestro.producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_detalle_venta_venta" FOREIGN KEY (venta_id)
      REFERENCES transaccional.venta (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE transaccional.detalle_venta
  OWNER TO ferremauros_web;

COPY tipo_pago (id, descripcion, importe) FROM stdin;
1	Efectivo	0
2	Tarjeta Codensa	7
3	Tarjeta Credito	4
4	Tarjeta Debito	2
\.



COPY tipo_venta (id, descripcion) FROM stdin;
2	Remision
1	Venta mostrador
3	Factura
\.
