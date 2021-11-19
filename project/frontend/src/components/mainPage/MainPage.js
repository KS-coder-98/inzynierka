import React, { useState, useEffect } from "react";
import { getUserByMail } from "../user/UserHelper";
import { getEmailFromStorage } from "../../handlerToLocalStorage";

import InfoUserDetails from "./InfoUserDetails";
import InfoUserContact from "./InfoUserContact";
import InfoUser from "./InfoUser";
import { Row, Col, Spinner, Container } from "react-bootstrap";

const MainPage = () => {
  const [user, setUser] = useState();

  useEffect(() => {
    getUserByMail(getEmailFromStorage(), setUser);
  }, []);

  return (
    <div>
      {user ? (
        <Container fluid style={{ padding: "10px" }}>
          <Row>
            <Col style={{ margin: "auto" }}>
              <InfoUser user={user} />
            </Col>
            <Col style={{ margin: "auto" }}>
              <InfoUserDetails user={user.userDetails} />
            </Col>
            <Col style={{ margin: "auto" }}>
              <InfoUserContact user={user.userContact} />
            </Col>
          </Row>
        </Container>
      ) : (
        <Spinner
          animation="border"
          style={{ height: "100px", width: "100px", margin: "100px" }}
        />
      )}
    </div>
  );
};

export default MainPage;
