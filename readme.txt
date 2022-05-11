
//DB has only one table

CREATE TABLE IF NOT EXISTS public.book
(
    id integer NOT NULL DEFAULT nextval('book_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    author_name text COLLATE pg_catalog."default" NOT NULL,
    publish_date date NOT NULL,
    public_catalog boolean NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id)
)