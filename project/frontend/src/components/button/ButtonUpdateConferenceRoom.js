import React from "react";
import { Button } from "react-bootstrap";
import { updateConferenceRoom } from "../conferenceRoom/ConferenceRoomHelper";

const ButtonUpdateConferenceRoom = ({ id, name, capacity, description }) => {
  const clickHandler = (e) => {
    updateConferenceRoom({ id, name, capacity, description });
  };

  return (
    <div>
      <Button variant="primary" type="submit" onClick={clickHandler}>
        Zapisz
      </Button>
    </div>
  );
};

export default ButtonUpdateConferenceRoom;
