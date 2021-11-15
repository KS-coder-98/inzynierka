import "./App.css";
import {
  AuthenticatedTemplate,
  UnauthenticatedTemplate,
  useMsal,
} from "@azure/msal-react";
import React from "react";

import StartPage from "./components/StartPage/StartPage";
import MyNavbar from "./components/nav/MyNavbar";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Redirect,
} from "react-router-dom";
import Meetings from "./components/Meetings";
import { useEffect } from "react";
import { loginRequest } from "./authConfig";

// import StartPage from "./components/StartPage/StartPage";

/**
 * Renders information about the signed-in user or a button to retrieve data about the user
 */
const ProfileContent = () => {
  const { instance, accounts } = useMsal();

  useEffect(() => {
    setToken();
  }, []);

  function setToken() {
    // Silently acquires an access token which is then attached to a request for MS Graph data
    instance
      .acquireTokenSilent({
        ...loginRequest,
        account: accounts[0],
      })
      .then((response) => {
        localStorage.setItem("token", response.accessToken);
      });
  }

  return (
    <>
      <MyNavbar username={accounts[0].name}></MyNavbar>
    </>
  );
};

/**
 * If a user is authenticated the ProfileContent component above is rendered. Otherwise a message indicating a user is not authenticated is rendered.
 */
const MainContent = () => {
  return (
    <div className="App">
      <AuthenticatedTemplate>
        <ProfileContent />
        <Router>
          <Routes>
            <Route path="/metings" element={<Meetings />} />
          </Routes>
        </Router>
      </AuthenticatedTemplate>

      <UnauthenticatedTemplate>
        <StartPage />
      </UnauthenticatedTemplate>
    </div>
  );
};

function App() {
  return (
    <div className="App">
      <MainContent />
    </div>
  );
}

export default App;
