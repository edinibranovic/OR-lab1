import React, { useEffect, useState } from "react";
import PageContainer from "../components/PageContainer";
import cx from "classnames";
import * as yup from "yup";
import IconButton from "../components/IconButton";
import { CloudDownloadIcon } from "@heroicons/react/solid";
import { Obuca, Term } from "../types";
import { Formik, FormikProps } from "formik";
import FilterForm from "../components/FilterForm";
import Title from "../components/Title";
import Button from "../components/Button";
import CsvDownload from "react-json-to-csv";
import { useAuth0 } from "@auth0/auth0-react";

export default function DataTable() {
  const [obuce, setObuca] = useState<Obuca[]>([]);
  const [number, setNumber] = useState(5);
  const [page, setPage] = useState(1);
  const [buttons, setButtons] = useState([
    <Button
      label=""
      className="bg-gray-100 text-gray-800"
      onClick={() => setNumber(3)}
    />,
  ]);
  const [searchTerm, setSearchTerm] = useState("");
  const [find, setFind] = useState(false);
  const [filter, setFilter] = useState("");
  const [all, setAll] = useState(false);
  const { isAuthenticated, loginWithRedirect } = useAuth0();

  const downloadJSON = async () => {
    const fileName = "obuca";
    const json = JSON.stringify(obuce);
    const blob = new Blob([json], { type: "application/json" });
    const href = URL.createObjectURL(blob);
    const link = document.createElement("a");
    link.href = href;
    link.download = fileName + ".json";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };

  const validationSchema = yup.object().shape({
    term: yup.string().optional(),
    choice: yup.string().optional(),
    number: yup.string().optional(),
  });

  const columnClass = cx({
    "px-4 py-2 text-gray-500 text-center text-sm": true,
  });

  const columnContentClass = cx({
    "px-4 py-2 text-left bg-gray-50 text-gray-800": true,
  });

  useEffect(() => {
    fetch("/obuce")
      .then((data) => data.json())
      .then((obuce) => setObuca(obuce));
  }, [all]);

  useEffect(() => {
    fetch("/obuce/" + filter + "/" + searchTerm, {})
      .then((data) => {
        if (data.ok) {
          return data.json();
        } else {
          throw new Error("Can't fetch this right now.");
        }
      })
      .then((obuce) => setObuca(obuce))
      .catch((error) => {
        console.log(error);
      });
  }, [find, filter, searchTerm]);

  useEffect(() => {
    setButtons([]);
    for (let i = 0; i < obuce.length / number; i++) {
      let mark = (i + 1).toString();
      setButtons((buttons) => [
        ...buttons,
        <div className="flex flex-col">
          <Button
            className="bg-gray-50 px-3 py-2 hover:bg-gray-100 text-gray-700"
            label={mark}
            onClick={() => setPage(i + 1)}
          />
        </div>,
      ]);
    }
  }, [number, obuce.length]);

  const onSubmit = (values: Term) => {
    if (values.term === "") {
      setAll(!all);
      setSearchTerm("");
    } else {
      setSearchTerm(values.term);
      setPage(1);
      switch (values.choice) {
        case "Wildcard":
          setFilter("wildcard");
          setFind(!find);
          break;
        case "Marka":
          setFilter("marka");
          setFind(!find);
          break;
        case "Model":
          setFilter("model");
          setFind(!find);
          break;
        case "Spol":
          setFilter("spol");
          setFind(!find);
          break;
        case "Velicina":
          setFilter("velicina");
          setFind(!find);
          break;
        case "Godina proizvodnje":
          setFilter("godproizvodnje");
          setFind(!find);
          break;
        case "Materijal":
          setFilter("materijal");
          setFind(!find);
          break;
        case "Visina đona":
          setFilter("visinadona");
          setFind(!find);
          break;
        case "Tip zatvaranja":
          setFilter("tipzatvaranja");
          setFind(!find);
          break;
        case "Boje":
          setFilter("boje");
          setFind(!find);
      }
    }
    switch (values.number) {
      case "3":
        setNumber(3);
        setPage(1);
        break;
      case "5":
        setNumber(5);
        setPage(1);
        break;
      case "10":
        setNumber(10);
        setPage(1);
        break;
    }
  };

  if (!isAuthenticated) {
    return <div>{loginWithRedirect()}</div>;
  }

  return (
    <PageContainer>
      <div className="text-lg items-center my-3 font-light">
        <Title text="Obuća OR LAB4" className="text-2xl" />
      </div>
      <div className="flex justify-between flex-row items-start w-full mt-1">
        <Formik
          initialValues={{ term: "", choice: "", number: "5" } as Term}
          onSubmit={onSubmit}
          validationSchema={validationSchema}
        >
          {({ handleSubmit }: FormikProps<any>) => (
            <form
              onChange={handleSubmit}
              className="flex justify-between flex-row items-start self-start w-full px-2"
            >
              <FilterForm />
            </form>
          )}
        </Formik>
      </div>
      <table className="table table-striped w-full">
        <thead className="bg-gray-100">
          <tr>
            <th className={columnClass}> ID</th>
            <th className={columnClass}> Marka</th>
            <th className={columnClass}> Model</th>
            <th className={columnClass}> Spol</th>
            <th className={columnClass}> Veličina</th>
            <th className={columnClass}> Godina proizvodnje</th>
            <th className={columnClass}> Materijal</th>
            <th className={columnClass}> Vrsta</th>
            <th className={columnClass}> Visina đona </th>
            <th className={columnClass}> Tip zatvaranja</th>
          </tr>
        </thead>
        <tbody>
          {obuce.map(
            (obuca) =>
              ((obuce.indexOf(obuca) + 1 <= number && page === 1) ||
                (obuce.indexOf(obuca) + 1 > number &&
                  page !== 1 &&
                    obuce.indexOf(obuca) + 1 <= page * number &&
                    obuce.indexOf(obuca) + 1 > number * (page - 1))) && (
                <tr key={obuca.id}>
                  <td className={columnContentClass}>{obuca.id}</td>
                  <td className={columnContentClass}>{obuca.marka}</td>
                  <td className={columnContentClass}>{obuca.model}</td>
                  <td className={columnContentClass}>{obuca.spol}</td>
                  <td className={columnContentClass}>{obuca.velicina}</td>
                  <td className={columnContentClass}>{obuca.godproizvodnje}</td>
                  <td className={columnContentClass}>{obuca.materijal}</td>
                  <td className={columnContentClass}>{obuca.vrsta}</td>
                  <td className={columnContentClass}>{obuca.visinadona}</td>
                  <td className={columnContentClass}>{obuca.tipzatvaranja}</td>
                </tr>
              )
          )}
        </tbody>
      </table>
      <div className="flex flex-row w-full justify-between px-6 bg-gray-50 items-center">
        <div className="flex flex-row space-x-2">
          <IconButton
            className="bg-gray-400 hover:bg-gray-500"
            label="Preuzmi JSON"
            onClick={downloadJSON}
            icon={CloudDownloadIcon}
          />

          <CsvDownload data={obuce} filename="obuce.csv">
            <IconButton
              className="bg-gray-400 hover:bg-gray-500"
              label="Preuzmi CSV"
              onClick={() => {}}
              icon={CloudDownloadIcon}
            />
          </CsvDownload>
        </div>
        <div className="flex items-start flex-row my-4 space-x-5">
          {buttons}
        </div>
      </div>
    </PageContainer>
  );
}
