--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: boja; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.boja (
    id integer NOT NULL,
    boja character varying(15)
);


ALTER TABLE public.boja OWNER TO postgres;

--
-- Name: ima; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ima (
    bojaid integer NOT NULL,
    obucaid integer NOT NULL
);


ALTER TABLE public.ima OWNER TO postgres;

CREATE TABLE public.obuca (
    id integer NOT NULL,
    marka character varying(20) NOT NULL,
    model character varying(20) NOT NULL,
    spol character varying(3) NOT NULL,
    velicina integer NOT NULL,
    godProizvodnje integer NOT NULL,
    materijal character varying(15) NOT NULL,
    vrsta character varying(30) NOT NULL,
    visinaDona character varying(10) NOT NULL,
    tipZatvaranja character varying(10) NOT NULL
);

ALTER TABLE public.obuca OWNER TO postgres;

--
-- Data for Name: boja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.boja (id, boja) FROM stdin; 
1   Bijela
2   Crna
3   Plava
4   Crvena
5   Zuta
6   Zelena
7   Narancasta
8   Ljubicasta
9   Ruzicasta
10  Zlatna
11  Siva
\.


--
-- Data for Name: ima; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ima (bojaid, obucaid) FROM stdin; 
1   1
1   7
1   8
1   9
1   10
2   2
2   9
2   10
3   3
3   10
4   2
5   5
6   4
6   5
7   5
7   4
7   7
8   6
8   7
9   7
10  1
11  8
\.


--
-- Data for Name: obuca; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.obuca (id, marka, model, spol, velicina, godProizvodnje, materijal, vrsta, visinaDona, tipZatvaranja) FROM stdin; 
1   Nike    Air Force    M    45    2017    Koza    Casual Tenisice    Visok    Vezice
2   Nike    Air Max      Z    40    2016    Tekstil Sportske Tenisice  Visok    Vezice
3   Nike    Air Jordan   M    48    2003    Koza    Sportske Tenisice  Visok    Vezice
4   Adidas  Gazelle      UNI  42    2012    Sintetika    Casual Tenisice    Srednji    Vezice
5   Adidas  Spezial      M    44    2010    Sintetika    Casual Tenisice    Nizak      Vezice
6   Puma    Rider        Z    41    2020    Najlon       Casual Tenisice    Srednji    Vezice
7   Puma    Smash        UNI  43    2020    Najlon       Casual Tenisice    Srednji    Vezice
8   New Balance    NYCM  Z    42    2015    Sintetika    Tenisice za trcanje    Srednji     Vezice
9   Karl Lagerfeld Volt Aktiv    M    47    2019    Najlon    Sandale    Nizak    Otvoreno
10  Umbro          Medusae 3     M    46    2021    Koza      Kopacke    Visok    Bez vezica
\.


--
-- Name: boja boja_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boja 
    ADD CONSTRAINT boja_pk PRIMARY KEY (id);


--
-- Name: ima ima_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ima 
    ADD CONSTRAINT ima_pk PRIMARY KEY (bojaid, obucaid);


--
-- Name: obuca obuca_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.obuca 
    ADD CONSTRAINT obuca_pk PRIMARY KEY (id);


--
-- Name: ima_bojaid_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ima 
    ADD CONSTRAINT ima_bojaid_fk FOREIGN KEY (bojaid) REFERENCES public.boja(id);


--
-- Name: ima_obucaid_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ima 
    ADD CONSTRAINT ima_obucaid_fk FOREIGN KEY (obucaid) REFERENCES public.obuca(id);


--
-- PostgreSQL database dump complete
--
