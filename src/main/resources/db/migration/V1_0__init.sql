-- Table: public.order_item

-- DROP TABLE public.order_item;

CREATE SEQUENCE public.orders_order_id_seq
INCREMENT 1
START 1
MINVALUE 1
MAXVALUE 9223372036854775807
CACHE 1;

CREATE TABLE public.orders
(
    order_id bigint NOT NULL DEFAULT nextval('orders_order_id_seq'::regclass),
user_id bigint NOT NULL,
total_amount double precision NOT NULL,
payment_type character varying COLLATE pg_catalog."default" NOT NULL,
CONSTRAINT orders_pkey PRIMARY KEY (order_id)
);

CREATE TABLE public.order_types
(
    order_type character varying COLLATE pg_catalog."default" NOT NULL,
    order_type_description character varying COLLATE pg_catalog."default",
    order_type_sla integer NOT NULL,
    CONSTRAINT order_types_pkey PRIMARY KEY (order_type)
);


CREATE TABLE public.order_item
(
    order_id bigint NOT NULL,
    item_id bigint NOT NULL,
    item_quantity integer NOT NULL,
    item_price double precision NOT NULL,
    billing_address character varying COLLATE pg_catalog."default" NOT NULL,
    shipping_address character varying COLLATE pg_catalog."default" NOT NULL,
    order_status character varying COLLATE pg_catalog."default" NOT NULL,
    order_type character varying COLLATE pg_catalog."default" NOT NULL,
    shipping_node character varying COLLATE pg_catalog."default" NOT NULL,
    expected_delivery_date date NOT NULL,
    actual_delivery_date date NOT NULL,
    CONSTRAINT order_item_pkey PRIMARY KEY (item_id, order_id),
CONSTRAINT order_item_fk FOREIGN KEY (order_id)
REFERENCES public.orders (order_id) MATCH SIMPLE
  ON UPDATE NO ACTION
        ON DELETE NO ACTION,
CONSTRAINT order_type_fk FOREIGN KEY (order_type)
REFERENCES public.order_types (order_type) MATCH SIMPLE
  ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
