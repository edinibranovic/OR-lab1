export type Boja = {
  id: number;
  naziv: string;
};

export type Obuca = {
  id: number;
  marka: string;
  model: string;
  spol: string;
  velicina: number;
  godproizvodnje: number;
  materijal: string;
  vrsta: string;
  visinadona: string;
  tipzatvaranja: string;
  boje: Boja[];
};

export type Term = {
  term: string;
  choice: string;
  number: string;
};
