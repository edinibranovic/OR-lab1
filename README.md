# 1. OR laboratorijska vježba 

Tema: Obuća

Licencija: Creative Commons Zero v1.0 Universal

Autor: Edin Ibranović

Verzija skupa podataka: 1.0

Baza podataka: PostgreSQL 13.3

Jezik u kojemu se nalaze podaci: hrvatski, engleski

Datum Predaje: 2.11.2021

Datum zadnjih izmjena: 2.11.2021

Entiteti i pripadajući atributi:

    OBUCA
        id - jedinstvena oznaka, INT, primarni ključ
        marka - proizvođač obuće, VARCHAR(20)
        model - naziv kolekcije kojoj obuća pripada, VARCHAR(20)
        spol - spol osoba kojima je obuća namijenjena, VARCHAR(3)
        velicina - EU velicina obuće, INT
        godProizvodnje - godina izlaska na tržište, INT
        materijal - glavni gradivni materijal, VARCHAR(15)
        vrsta - aktivnost kojoj je obuća namijenjena, VARCHAR(30)
        visinaDona - opis visine đona, VARCHAR(10)
        tipZatvaranja - način na koji se obuća zatvara, VARCHAR(10)
        
    BOJA
        id - jedinstvena oznaka, INT, primarni ključ
        boja - naziv boje, VARCHAR(15)
        
    IMA
    - postoji jer OBUCA i BOJA imaju many-to-many povezanost
    - par obuće može imati jednu ili više različitih boja, dok jedna boja može biti u jednom ili više parova obuće
        bojaid - strani ključ koji referencira id boje, INT
        obucaid - strani ključ koji označava id obuće, INT
