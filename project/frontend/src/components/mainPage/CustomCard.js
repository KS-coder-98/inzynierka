import React from "react";
import { Card } from "react-bootstrap/";

const CustomCard = ({ bg, text, tHeader, tTitle, content }) => {
  return (
    <Card bg={bg} text={text}>
      <Card.Header>{tHeader}</Card.Header>
      <Card.Body>
        <Card.Title>{tTitle}</Card.Title>
        <Card.Text>{content}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default CustomCard;
