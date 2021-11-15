import React from "react";
import { useEffect, useState } from "react";
import { getConferenceRoomById } from "./ConferenceRoomHelper";
import ConferenceRoomLayout from "./ConferenceRoomLayout";

const ConferenceRoom = () => {
  //conRoom -> conferenceRoom
  const [conRoom, setConRoom] = useState({});

  useEffect(() => {
    getConferenceRoomById(1, setConRoom);
  }, []);

  return (
    <div>
      <ConferenceRoomLayout
        id={conRoom.id}
        name={conRoom.name}
        description={conRoom.description}
        capacity={conRoom.capacity}
      />
    </div>
  );
};

export default ConferenceRoom;
