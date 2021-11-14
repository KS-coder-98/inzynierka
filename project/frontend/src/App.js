import "./App.css";
import {
  AuthenticatedTemplate,
  UnauthenticatedTemplate,
  useMsal,
} from "@azure/msal-react";
import React from "react";

import StartPage from "./components/StartPage/StartPage";
import MyNavbar from "./components/nav/MyNavbar";
// import StartPage from "./components/StartPage/StartPage";

/**
 * Renders information about the signed-in user or a button to retrieve data about the user
 */
const ProfileContent = () => {
  const { instance, accounts } = useMsal();

  return (
    <>
      <MyNavbar username={accounts[0].name}></MyNavbar>
      <h5 className="card-title">Welcome {accounts[0].name}</h5>
      {console.log(accounts)}
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
