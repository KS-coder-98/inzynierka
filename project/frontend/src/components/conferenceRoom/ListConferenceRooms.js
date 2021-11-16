import React, { useEffect, useState } from "react";
import ConferenceRoom from "./ConferenceRoom";
import { getAllConferenceRooms } from "./ConferenceRoomHelper";
import ConferenceRoomLayout from "./ConferenceRoomLayout";
import { Row } from "react-bootstrap";

const ListConferenceRooms = () => {
  const [conRooms, setConRooms] = useState([]);

  useEffect(() => {
    getAllConferenceRooms(setConRooms);
    console.log(conRooms);
  }, []);

  return (
    <div>
      <Row xs={2} md={4} lg={5}>
        {conRooms.map((conRoom) => (
          <ConferenceRoomLayout
            key={conRoom.id}
            id={conRoom.id}
            name={conRoom.name}
            description={conRoom.description}
            capacity={conRoom.capacity}
          />
        ))}
      </Row>
    </div>
  );
};

export default ListConferenceRooms;