import React from "react";
import { Card, ListGroup, Col } from "react-bootstrap";
import ButtonOnOff from "../button/ButtonOnOff";
import ButtonRoomDetails from "../button/ButtonRoomDetails";

const ConferenceRoomLayout = ({
  id,
  name,
  description,
  capacity,
  type,
  disabledForm,
  setDisabledForm,
}) => {
  return (
    <div>
      <Col>
        <Card style={{ width: "20rem", margin: "10px" }}>
          <ListGroup variant="flush">
            <Card.Header>Nazwa: {name}</Card.Header>
            <ListGroup.Item>Identyfikator: {id}</ListGroup.Item>
            <ListGroup.Item>Opis: {description}</ListGroup.Item>
            <ListGroup.Item>Max liczba osób: {capacity}</ListGroup.Item>
            {type === "details" && (
              <ListGroup.Item>
                <ButtonRoomDetails roomId={id} />
              </ListGroup.Item>
            )}
            {type === "form" && (
              <ButtonOnOff
                disabledForm={disabledForm}
                setDisabledForm={setDisabledForm}
              />
            )}
          </ListGroup>
        </Card>
      </Col>
    </div>
  );
};

export default ConferenceRoomLayout;
