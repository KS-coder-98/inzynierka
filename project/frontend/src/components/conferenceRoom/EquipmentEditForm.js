import React, { useState } from "react";
import { Form, Button, Row, Col } from "react-bootstrap";
import { updateEquipment } from "./ConferenceRoomHelper";

const EquipmentEditForm = ({ equipment, edit, setEdit }) => {
  let id = equipment.id;
  let [name, setName] = useState(equipment.name);
  let [desc, setDesc] = useState(equipment.desc);

  const editHandler = () => {
    setEdit(!edit);
  };

  const submitHandler = () => {
    updateEquipment({ id, name, description: desc });
  };

  return (
    <div>
      <Form>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Nazwa</Form.Label>
          <Form.Control
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Opis</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            type="text"
            value={desc}
            onChange={(e) => setDesc(e.target.value)}
          />
        </Form.Group>
        <Row>
          <Col>
            <Button variant="success" type="submit" onClick={submitHandler}>
              Zapisz
            </Button>
          </Col>
          <Col>
            <Button variant="danger" onClick={editHandler}>
              Anuluj
            </Button>
          </Col>
        </Row>
      </Form>
    </div>
  );
};

export default EquipmentEditForm;
