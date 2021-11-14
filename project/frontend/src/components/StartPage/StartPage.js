import React from "react";
import "./../StartPage/startPage.css";
import { Button } from "react-bootstrap";

const StartPage = () => {
  return (
    <div className="container myClass">
      <div className="row">
        <h2>Witaj w systemie do rezerwacji auli konferencyjnych</h2>
      </div>
      <div class="row">
        <Button>Zalogój się</Button>
      </div>
    </div>
  );
};

export default StartPage;
