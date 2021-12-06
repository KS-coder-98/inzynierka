import React, { useState, useEffect } from "react";
import { Form, Row, Col } from "react-bootstrap";
import ButtonUpdateConferenceRoom from "../button/ButtonUpdateConferenceRoom";

const FormConferenceRoom = ({ conRoom, disabled }) => {
  let [name, setName] = useState(conRoom.name);
  let [capacity, setCapacity] = useState(conRoom.capacity);
  let [description, setDescription] = useState(conRoom.description);

  useEffect(() => {
    setName(conRoom.name);
    setDescription(conRoom.description);
    setCapacity(conRoom.capacity);
  }, [conRoom]);

  return (
    <div>
      <Form>
        <fieldset disabled={disabled}>
          <Row>
            <Col>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Nazwa</Form.Label>
                <Form.Control
                  type="text"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Max liczba osób</Form.Label>
                <Form.Control
                  type="number"
                  value={capacity}
                  onChange={(e) => setCapacity(e.target.value)}
                />
              </Form.Group>
            </Col>
          </Row>
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Opis</Form.Label>
            <Form.Control
              type="text"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
          </Form.Group>
          <ButtonUpdateConferenceRoom
            id={conRoom.id}
            name={name}
            capacity={capacity}
            description={description}
          />
        </fieldset>
      </Form>
    </div>
  );
};

export default FormConferenceRoom;
