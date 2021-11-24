import React from "react";
import { Button } from "react-bootstrap";
import { cancelReservation } from "../event/EventHelper";

const ButtonCancelReservation = ({ idEvent }) => {
  const clickHandler = () => {
    cancelReservation(idEvent);
    window.location.reload();
  };

  return (
    <div>
      <Button variant="warning" onClick={clickHandler}>
        Anuluj udział
      </Button>
    </div>
  );
};

export default ButtonCancelReservation;
