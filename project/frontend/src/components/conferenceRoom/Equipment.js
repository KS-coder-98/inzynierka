import React from "react";
import CustomCard from "../mainPage/CustomCard";
import { Col, Row } from "react-bootstrap";
import { Pen, XLg } from "react-bootstrap-icons";

const Equipment = ({ id, name, desc }) => {
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
                <Pen />
              </Col>
              <Col>
                <XLg />
              </Col>
            </Row>
          </>
        }
      />
    </div>
  );
};

export default Equipment;
