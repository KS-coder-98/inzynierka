import React, { useState, useEffect } from "react";
import { Button, Col, Row } from "react-bootstrap";
import { getEmailFromStorage } from "../../handlerToLocalStorage";
import CustomCard from "../mainPage/CustomCard";

const OneMeeting = ({ event }) => {
  const [freeSeats, setFreeSeats] = useState(
    event.conferenceRoom.capacity - event.eventMembers.length
  );

  const [emailStorage, setEmailStorage] = useState(getEmailFromStorage());

  const [isRegistered, setIsRegistered] = useState(true);

  const [isOrganiser, setIsOrganiser] = useState();

  const [colorOfTheme, setColorOfTheme] = useState({});

  useEffect(() => {
    setIsRegistered(checkIsRegistered());
    setIsOrganiser(checkIsOrganiser());
    setColorOfTheme(choseColorOfTheme());
  }, [isRegistered, isOrganiser]);

  const checkIsRegistered = () => {
    const found = event.eventMembers.find(
      (user) => user.email === emailStorage
    );
    return found == null ? false : true;
  };

  const checkIsOrganiser = () => {
    return event.organiser.email === emailStorage;
  };

  const choseColorOfTheme = () => {
    if (isOrganiser) return { bg: "dark", textColor: "white" };
    else if (isRegistered) return { bg: "secondary", textColor: "white" };
    else return { bg: "light", textColor: "dark" };
  };

  return (
    <CustomCard
      bg={colorOfTheme.bg}
      text={colorOfTheme.textColor}
      tTitle={event.name}
      content={
        <>
          <Row>
            <Col> Start</Col>
            <Col>{event.startTime}</Col>
          </Row>
          <Row>
            <Col>Koniec</Col>
            <Col>{event.endTime}</Col>
          </Row>
          <Row>
            <Col>Lokalizacja</Col>
            <Col>{event.conferenceRoom.name}</Col>
          </Row>
          <Row>
            <Col>Ilość wolnych mjesc</Col>
            <Col>{freeSeats}</Col>
          </Row>
          <Row>
            <Col>Organizator</Col>
            <Col>
              {event.organiser.firstName} {event.organiser.lastName}
            </Col>
          </Row>
          <Row>
            <Col style={{ marginTop: "20px" }}>
              {!isOrganiser && isRegistered && (
                <Button variant="warning">Anuluj udział</Button>
              )}
              {isOrganiser && (
                <Button variant="danger">Anulaj wydarzenie</Button>
              )}
              {!isOrganiser && !isRegistered && (
                <Button variant="success">Dołącz</Button>
              )}
            </Col>
          </Row>
        </>
      }
    />
  );
};

export default OneMeeting;
