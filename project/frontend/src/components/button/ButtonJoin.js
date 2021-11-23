import React from "react";
import { Button } from "react-bootstrap";
import { joinToEvent } from "../event/EventHelper";

const ButtonJoin = ({ idEvent }) => {
  const clickHandler = () => {
    joinToEvent(idEvent);
    window.location.reload();
  };

  return (
    <div>
      <Button variant="success" onClick={clickHandler}>
        Dołącz
      </Button>
    </div>
  );
};

export default ButtonJoin;
