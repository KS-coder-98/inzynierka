import React, { useEffect, useState } from "react";
import { getAllConferenceRooms } from "./ConferenceRoomHelper";
import ConferenceRoomLayout from "./ConferenceRoomLayout";
import { Container, Row } from "react-bootstrap";

const ListConferenceRooms = () => {
  //conRoom -> conferenceRoom
  const [conRooms, setConRooms] = useState([]);

  useEffect(() => {
    setTimeout(520, getAllConferenceRooms(setConRooms));
    setTimeout(1000, console.log(conRooms));
  }, []);

  return (
    <div>
      <Container>
        <Row xs={1} md={2} lg={4}>
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
      </Container>
    </div>
  );
};

export default ListConferenceRooms;
