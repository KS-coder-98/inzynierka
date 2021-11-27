import React from "react";
import { Card, ListGroup, Col, Button } from "react-bootstrap";

const ConferenceRoomLayout = ({ id, name, description, capacity }) => {
  return (
    <div>
      <Col>
        <Card style={{ width: "18rem", margin: "10px" }}>
          <ListGroup variant="flush">
            <Card.Header>Nazwa: {name}</Card.Header>
            <ListGroup.Item>Identyfikator: {id}</ListGroup.Item>
            <ListGroup.Item>Opis: {description}</ListGroup.Item>
            <ListGroup.Item>Max liczba osób: {capacity}</ListGroup.Item>
            <ListGroup.Item>
              <Button>Szegóły</Button>
            </ListGroup.Item>
          </ListGroup>
        </Card>
      </Col>
    </div>
  );
};

export default ConferenceRoomLayout;
