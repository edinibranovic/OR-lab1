import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import {
  HomeIcon,
  TableIcon,
  LoginIcon,
  LogoutIcon,
  UserCircleIcon,
  RefreshIcon,
} from "@heroicons/react/solid";
import IconButton from "./IconButton";
import { useAuth0 } from "@auth0/auth0-react";
import CsvDownload from "react-json-to-csv";
import { Obuca } from "../types";

export default function Navbar() {
  const history = useHistory();
  const { isAuthenticated, user, loginWithRedirect, logout } = useAuth0();
  const [obuce, setobuce] = useState<Obuca[]>([]);

  useEffect(() => {
    fetch("/obuce")
      .then((data) => data.json())
      .then((obuce) => setobuce(obuce));
  }, []);

  const downloadJSON = async () => {
    const fileName = "obuce";
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

  return (
    <div className="bg-indigo-600 flex justify-start flex-col h-screen w-60 p-3">
      <div className="text-white text-lg mb-4 text-center">
        obuce Dataset
        {isAuthenticated && (
          <p className="text-sm">Bok, {user?.name}!</p>
        )}
      </div>
      <IconButton
        icon={HomeIcon}
        label="Početna"
        onClick={() => history.push("/")}
      />
      <IconButton
        icon={TableIcon}
        label="Tablica"
        onClick={() => history.push("/tablica")}
      />
      {isAuthenticated ? (
        <>
          <CsvDownload data={obuce} filename="obuca.csv">
            <IconButton
              icon={RefreshIcon}
              label="Osvježi preslike"
              className="w-full bg-indigo-600 hover:bg-indigo-500"
              onClick={downloadJSON}
            />
          </CsvDownload>
          <IconButton
            icon={UserCircleIcon}
            label="Profil"
            onClick={() => history.push("/profile")}
          />
          <IconButton
            icon={LogoutIcon}
            label="Logout"
            onClick={() =>
              logout({ returnTo: window.location.origin, localOnly: true })
            }
          />
        </>
      ) : (
        <IconButton
          icon={LoginIcon}
          label="Odjava"
          onClick={() => loginWithRedirect()}
        />
      )}
    </div>
  );
}
