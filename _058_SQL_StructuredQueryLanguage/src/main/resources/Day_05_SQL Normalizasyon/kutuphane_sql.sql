-- This script was generated by the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.kitap
(
    kitap_id serial NOT NULL,
    isbn character varying(50) NOT NULL,
    kitap_no character varying(25),
    kitap_adi character varying(150) NOT NULL,
    yazar_id integer,
    yayin_tarihi date,
    kitap_turu_id integer,
    kiralik_durumu boolean,
    PRIMARY KEY (kitap_id)
);

CREATE TABLE IF NOT EXISTS public.yazar
(
    yazar_id serial NOT NULL,
    yazar_no character varying(50),
    kitap_yazari character varying(50),
    PRIMARY KEY (yazar_id)
);

CREATE TABLE IF NOT EXISTS public.tur
(
    tur_id serial NOT NULL,
    kitap_turu_no character varying(50) NOT NULL,
    kitap_turu_adi character varying(50) NOT NULL,
    PRIMARY KEY (tur_id)
);

CREATE TABLE IF NOT EXISTS public.odunc
(
    odunc_id serial NOT NULL,
    kitap_id integer,
    uye_id integer,
    odunc_tarihi date,
    odunc_suresi integer,
    teslim_tarihi date,
    PRIMARY KEY (odunc_id)
);

CREATE TABLE IF NOT EXISTS public.uye
(
    uye_id serial NOT NULL,
    uye_isim character varying(50) NOT NULL,
    uye_soyisim character varying(50) NOT NULL,
    email character varying(50),
    cinsiyet boolean,
    elindeki_kitap_sayisi integer,
    dogum_tarihi date,
    PRIMARY KEY (uye_id)
);

ALTER TABLE IF EXISTS public.kitap
    ADD FOREIGN KEY (yazar_id)
    REFERENCES public.yazar (yazar_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.kitap
    ADD FOREIGN KEY (kitap_turu_id)
    REFERENCES public.tur (tur_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.odunc
    ADD FOREIGN KEY (kitap_id)
    REFERENCES public.kitap (kitap_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.odunc
    ADD FOREIGN KEY (uye_id)
    REFERENCES public.uye (uye_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;