import React, { useEffect, useState } from "react";

import { Container, Row } from "react-bootstrap";
import { getAllConferenceRooms } from "../conferenceRoom/ConferenceRoomHelper";
import ReservationConferenceRoomLayout from "../conferenceRoom/ReservationConferenceRoomLayout";

const ListRoomsToReservation = () => {
  //conRoom -> conferenceRoom
  const [conRooms, setConRooms] = useState();

  useEffect(() => {
    setTimeout(getAllConferenceRooms(setConRooms), 150);
  }, []);

  return (
    <div>
      <Container>
        <Row xs={1} md={2} lg={4}>
          {conRooms && conRooms.length > 0 ? (
            conRooms.map((conRoom) => (
              <ReservationConferenceRoomLayout
                key={conRoom.id}
                id={conRoom.id}
                name={conRoom.name}
                description={conRoom.description}
                capacity={conRoom.capacity}
                type={"details"}
              />
            ))
          ) : (
            <p>brak wynikow</p>
          )}
        </Row>
      </Container>
    </div>
  );
};

export default ListRoomsToReservation;
