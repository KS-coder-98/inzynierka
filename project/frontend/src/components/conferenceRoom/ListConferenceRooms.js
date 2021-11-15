import React, { useEffect, useState } from "react";
import ConferenceRoom from "./ConferenceRoom";
import { getAllConferenceRooms } from "./ConferenceRoomHelper";
import ConferenceRoomLayout from "./ConferenceRoomLayout";

const ListConferenceRooms = () => {
  const [conRooms, setConRooms] = useState([]);

  useEffect(() => {
    getAllConferenceRooms(setConRooms);
    console.log(conRooms);
  }, []);

  return (
    <div>
      {conRooms.map((conRoom) => (
        <ConferenceRoomLayout
          key={conRoom.id}
          id={conRoom.id}
          name={conRoom.name}
          description={conRoom.description}
          capacity={conRoom.capacity}
        />
      ))}
    </div>
  );
};

export default ListConferenceRooms;
