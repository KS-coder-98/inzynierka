import React from "react";
import { useEffect, useState } from "react";
import { getConferenceRoomById } from "./ConferenceRoomHelper";
import ConferenceRoomLayout from "./ConferenceRoomLayout";
import Equipment from "./Equipment";
import { Row, Col, Container } from "react-bootstrap";
import { useParams } from "react-router-dom";
import FormConferenceRoom from "./FormConferenceRoom";

const ConferenceRoom = () => {
  //conRoom -> conferenceRoom
  const [conRoom, setConRoom] = useState({});
  const [disabled, setDeisabled] = useState(true);

  // Get ID from URL
  const conferenceRoomId = useParams().id;

  useEffect(() => {
    getConferenceRoomById(conferenceRoomId, setConRoom);
  }, []);

  return (
    <div>
      <Container fluid="md">
        <Row style={{ margin: "100px 0", fontSize: "20px" }}>
          <Col md={6} sm={12}>
            <ConferenceRoomLayout
              id={conRoom.id}
              name={conRoom.name}
              description={conRoom.description}
              capacity={conRoom.capacity}
              type={"form"}
              setDisabledForm={setDeisabled}
              disabledForm={disabled}
            />
          </Col>
          <Col md={6} sm={12}>
            <FormConferenceRoom conRoom={conRoom} disabled={disabled} />
          </Col>
        </Row>

        {conRoom.equipment && (
          <Row>
            <h2>Wyposarzenie</h2>
            {conRoom.equipment.map((equipment) => (
              <Col style={{ margin: "30px 0", fontSize: "18px" }}>
                <Equipment
                  key={equipment.id}
                  id={equipment.id}
                  name={equipment.name}
                  desc={equipment.description}
                />
              </Col>
            ))}
          </Row>
        )}
      </Container>
    </div>
  );
};

export default ConferenceRoom;
