import React, { useState } from "react";
import CustomCard from "../mainPage/CustomCard";
import { Col, Row, Button } from "react-bootstrap";
import { Pen, XLg } from "react-bootstrap-icons";
import { deleteEquipment } from "./ConferenceRoomHelper";
import EquipmentEditForm from "./EquipmentEditForm";

const Equipment = ({ id, name, desc }) => {
  const [edit, setEdit] = useState(false);

  const deleteHandler = () => {
    deleteEquipment(id);
    window.location.reload();
  };

  const editHandler = (e) => {
    setEdit(!edit);
    e.preventDefault();
  };

  return (
    <>
      {edit ? (
        <EquipmentEditForm
          equipment={{ id, name, desc }}
          edit={edit}
          setEdit={setEdit}
        />
      ) : (
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
                  <Button variant="outline-warning" onClick={editHandler}>
                    <Pen />
                  </Button>
                </Col>
                <Col>
                  <Button variant="outline-danger" onClick={deleteHandler}>
                    <XLg />
                  </Button>
                </Col>
              </Row>
            </>
          }
        />
      )}
    </>
  );
};

export default Equipment;
