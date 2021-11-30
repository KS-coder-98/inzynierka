import React from "react";
import { Button } from "react-bootstrap";

const ButtonRoomDetails = ({ roomId }) => {
  return (
    <div>
      <Button href={"conference-room/" + roomId}>Edytuj</Button>
    </div>
  );
};

export default ButtonRoomDetails;
