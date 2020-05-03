CREATE TABLE public.videogame
(
    id serial NOT NULL,
    title character varying NOT NULL,
    editor character varying NOT NULL,
    year integer NOT NULL,
    url character varying,
    PRIMARY KEY (id)
);

ALTER TABLE public.videogame
    OWNER to postgres;
	
CREATE TABLE public.console
(
    id serial NOT NULL,
    name character varying,
    PRIMARY KEY (id)
);

ALTER TABLE public.console
    OWNER to postgres;
	
CREATE TABLE public.videogame_customer
(
    videogameid bigint,
    consoleid bigint,
    PRIMARY KEY (videogameid, consoleid)
);

ALTER TABLE public.videogame_customer
    OWNER to postgres;
	
ALTER TABLE public.videogame_customer
    ADD CONSTRAINT videogame FOREIGN KEY (videogameid)
    REFERENCES public.videogame (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX fki_videogame
    ON public.videogame_customer(videogameid);
	
ALTER TABLE public.videogame_customer
    ADD CONSTRAINT console FOREIGN KEY (consoleid)
    REFERENCES public.console (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
CREATE INDEX fki_console
    ON public.videogame_customer(consoleid);