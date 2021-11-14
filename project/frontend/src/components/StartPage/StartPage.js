import React from "react";
import { SignInButton } from "../nav/SignInButton";

const StartPage = () => {
  return (
    <div className="container">
      <div className="row">
        <h2>Witaj w systemie do rezerwacji auli konferencyjnych</h2>
      </div>
      <div class="row">
        <SignInButton />
      </div>
    </div>
  );
};

export default StartPage;
