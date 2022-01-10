import React from "react";
import Select from "./Select";
import Input from "./Input";

export default function PaginationForm() {
  return (
    <React.Fragment>
      <div className="flex justify-start flex-row items-start mb-4">
        <Select
          name="choice"
          label="Filtriranje po pojedinom polju"
          placeholder="Odaberite polje za pretragu"
          options={[
            "Wildcard",
            "Marka",
            "Model",
            "Velicina",
            "Godin proizvodnje",
            "Materijal",
          ]}
          getOptionValue={(option) => option}
          getOptionLabel={(option) => option}
          className="mr-2"
        />
        <Input name="term" label="Polje za pretragu" className="mr-2" />
      </div>
    </React.Fragment>
  );
}
