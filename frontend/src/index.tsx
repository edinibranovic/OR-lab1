import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

import { Auth0Provider } from "@auth0/auth0-react";
import authConfig from "./config.json";

type CacheLocation = "memory" | "localstorage";

type config = {
  domain: string;
  clientId: string;
  audience: string;
  redirectUri: string;
  useRefreshTokens: boolean;
  cacheLocation: CacheLocation;
};

const providerConfig: config = {
  domain: authConfig.domain,
  clientId: authConfig.clientId,
  audience: authConfig.audience,
  redirectUri: window.location.origin,
  useRefreshTokens: true,
  cacheLocation: "localstorage",
};

ReactDOM.render(
  <React.StrictMode>
    <Auth0Provider {...providerConfig}>
      <App />
    </Auth0Provider>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
