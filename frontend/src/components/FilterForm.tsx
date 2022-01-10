import React from "react";
import Select from "./Select";
import Input from "./Input";

export default function FilterForm() {
  return (
    <React.Fragment>
      <div className="flex flex-row items-center mx-2 mt-6">
        Prikaži{" "}
        {" "}
        unosa
      </div>
      <div className="flex flex-row space-x-2 mx-2">
        <Select
          name="choice"
          label="Filtriranje po pojedinom polju:"
          placeholder="Odaberite polje"
          options={[
            "Wildcard",
            "Marka",
            "Model",
            "Spol",
            "Velicina",
            "Godina proizvodnje",
            "Materijal",
            "Vrsta",
            "Visina đona",
            "Tip zatvaranja",
            "Boje"
          ]}
          getOptionValue={(option) => option}
          getOptionLabel={(option) => option}
          className="mr-2"
        />
        <Input name="term" label="Polje za pretragu:" className="mr-2" />
      </div>
    </React.Fragment>
  );
}
