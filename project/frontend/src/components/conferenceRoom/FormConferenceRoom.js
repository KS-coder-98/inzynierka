import React from "react";
import { Form, Button, Row, Col } from "react-bootstrap";

const FormConferenceRoom = ({ conRoom, disabled }) => {
  return (
    <div>
      <Form>
        <fieldset disabled={disabled}>
          <Row>
            <Col>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Nazwa</Form.Label>
                <Form.Control type="text" placeholder={conRoom.name} />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Max liczba osób</Form.Label>
                <Form.Control type="number" placeholder={conRoom.capacity} />
              </Form.Group>
            </Col>
          </Row>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Opis</Form.Label>
            <Form.Control type="text" placeholder={conRoom.description} />
          </Form.Group>
          <Button variant="primary" type="submit">
            Zapisz
          </Button>
        </fieldset>
      </Form>
    </div>
  );
};

export default FormConferenceRoom;
