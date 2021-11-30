import React, { useState, useEffect } from "react";
import { Col, Container, Row, Spinner } from "react-bootstrap";
import MySpinner from "../MySpinner";
import { getAllEvents } from "./EventHelper";
import OneMeeting from "./OneMeeting";

const Meetings = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    setTimeout(() => {
      getAllEvents(setEvents);
    }, 150);
  }, []);

  return (
    <div>
      {events.length ? (
        <Container fluid>
          <Row className="justify-content-md-center">
            {events.map((e) => (
              <Col
                lg={3}
                md={5}
                style={{ marginTop: "15px" }}
                key={e.startTime + e.conferenceRoom.name}
              >
                <OneMeeting event={e} />
              </Col>
            ))}
          </Row>
        </Container>
      ) : (
        <MySpinner />
      )}
    </div>
  );
};

export default Meetings;
