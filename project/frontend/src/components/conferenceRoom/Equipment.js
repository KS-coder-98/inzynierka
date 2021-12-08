import React from "react";
import CustomCard from "../mainPage/CustomCard";
import { Col, Row, Button } from "react-bootstrap";
import { Pen, XLg } from "react-bootstrap-icons";
import { deleteEquipment } from "./ConferenceRoomHelper";

const Equipment = ({ id, name, desc }) => {
  const clickHandler = () => {
    deleteEquipment(id);
    window.location.reload();
  };

  return (
    <div>
      <CustomCard
        bg="light"
        text="dark"
        tTitle={name.toUpperCase()}
        content={
          <>
            <Row>
              <Col> Id</Col>
              <Col>{id}</Col>
            </Row>
            <Row>
              <Col>Opis</Col>
              <Col>{desc}</Col>
            </Row>
            <Row>
              <Col>
                <Button variant="outline-warning">
                  <Pen />
                </Button>
              </Col>
              <Col>
                <Button variant="outline-danger" onClick={clickHandler}>
                  <XLg />
                </Button>
              </Col>
            </Row>
          </>
        }
      />
    </div>
  );
};

export default Equipment;
