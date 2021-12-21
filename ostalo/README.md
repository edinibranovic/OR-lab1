3. OR laboratorijska vježba 

Tema: Obuća

Licencija: Creative Commons Zero v1.0 Universal

Autor: Edin Ibranović

Verzija skupa podataka: 1.0

Baza podataka: PostgreSQL

Jezik u kojemu se nalaze podaci: hrvatski, engleski

Datum Predaje: 21.12.2021

Datum zadnjih izmjena: 21.12.2021

Entiteti i pripadajući atributi:
    OBUCA
        id - jedinstvena oznaka, INT, primarni ključ
        marka - proizvođač obuće, text
        model - naziv kolekcije kojoj obuća pripada, text
        spol - spol osoba kojima je obuća namijenjena, text
        velicina - EU velicina obuće, INT
        godProizvodnje - godina izlaska na tržište, INT
        materijal - glavni gradivni materijal, text
        vrsta - aktivnost kojoj je obuća namijenjena, text
        visinaDona - opis visine đona, text
        tipZatvaranja - način na koji se obuća zatvara, text

    BOJA
        id - jedinstvena oznaka, INT, primarni ključ
        naziv - naziv boje, text

    IMA
    - postoji jer OBUCA i BOJA imaju many-to-many povezanost
    - par obuće može imati jednu ili više različitih boja, dok jedna boja može biti u jednom ili više parova obuće
        bojaid - strani ključ koji referencira id boje, INT
        obucaid - strani ključ koji označava id obuće, INT