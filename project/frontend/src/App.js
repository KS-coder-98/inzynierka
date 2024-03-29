import "./App.css";
import {
  AuthenticatedTemplate,
  UnauthenticatedTemplate,
  useMsal,
} from "@azure/msal-react";
import React from "react";

import StartPage from "./components/StartPage/StartPage";
import MyNavbar from "./components/nav/MyNavbar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Meetings from "./components/event/Meetings";
import { useEffect } from "react";
import { loginRequest } from "./authConfig";
import {
  setEmailInStorage,
  setNickInStorage,
  setTokenInStorage,
} from "./handlerToLocalStorage";
import ListConferenceRooms from "./components/conferenceRoom/ListConferenceRooms";
import ConferenceRoom from "./components/conferenceRoom/ConferenceRoom";

import { sayHello } from "./comunication";
import MainPage from "./components/mainPage/MainPage";
import ReservationPage from "./components/reservation/ReservationPage";
import ListRoomsToReservation from "./components/reservation/ListRoomsToReservation";

/**
 * Renders information about the signed-in user or a button to retrieve data about the user
 */
const ProfileContent = () => {
  const { instance, accounts } = useMsal();

  useEffect(() => {
    setToken();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  function setToken() {
    // Silently acquires an access token which is then attached to a request for MS Graph data
    instance
      .acquireTokenSilent({
        ...loginRequest,
        account: accounts[0],
      })
      .then((response) => {
        setTokenInStorage(response.accessToken);
        setEmailInStorage(accounts[0].username);
        setNickInStorage(accounts[0].name);
        sayHello();
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
            <Route path="/" element={<MainPage />} />
            <Route path="/metings" element={<Meetings />} />
            <Route path="/conference-rooms" element={<ListConferenceRooms />} />
            <Route path="/conference-room/:id" element={<ConferenceRoom />} />
            <Route path="/reservations" element={<ListRoomsToReservation />} />
            <Route path="/reservation/:id" element={<ReservationPage />} />
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
