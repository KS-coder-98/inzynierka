import React from "react";
import { Button } from "react-bootstrap";

const ButtonRoomReservations = ({ roomId }) => {
  return (
    <div>
      <Button href={"reservation/" + roomId}>Zarządzaj rezerwacjami</Button>
    </div>
  );
};

export default ButtonRoomReservations;
