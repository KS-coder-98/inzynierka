import React from "react";
import { Card, ListGroup, Col } from "react-bootstrap";

const ConferenceRoomLayout = ({ id, name, description, capacity }) => {
  return (
    <div>
      <Col>
        <Card style={{ width: "18rem" }}>
          <ListGroup variant="flush">
            <Card.Header>Name: {name}</Card.Header>
            <ListGroup.Item>Id: {id}</ListGroup.Item>
            <ListGroup.Item>Description: {description}</ListGroup.Item>
            <ListGroup.Item>Capacity: {capacity}</ListGroup.Item>
          </ListGroup>
        </Card>
      </Col>
    </div>
  );
};

export default ConferenceRoomLayout;
