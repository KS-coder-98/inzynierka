import React from "react";
import { Button } from "react-bootstrap";
import { deleteReservation } from "../event/EventHelper";

const ButtonDeleteReservation = ({ idEvent }) => {
  const clickHandler = () => {
    deleteReservation(idEvent);
    window.location.reload();
  };
  return (
    <div>
      <Button variant="danger" onClick={clickHandler}>
        Anulaj wydarzenie
      </Button>
    </div>
  );
};

export default ButtonDeleteReservation;
