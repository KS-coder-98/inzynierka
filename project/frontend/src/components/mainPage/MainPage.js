import React, { useState, useEffect } from "react";
import { getUserByMail, getUserEventsByMail } from "../user/UserHelper";
import { getEmailFromStorage } from "../../handlerToLocalStorage";

import InfoUserDetails from "./InfoUserDetails";
import InfoUserContact from "./InfoUserContact";
import InfoUser from "./InfoUser";
import { Row, Col, Container } from "react-bootstrap";
import InfoUpcomingEvents from "./InfoUpcomingEvents";
import MySpinner from "../MySpinner";

const MainPage = () => {
  const [user, setUser] = useState();
  const [uncomingEvents, setUncomingEvents] = useState([]);

  useEffect(() => {
    setTimeout(() => {
      getUserByMail(getEmailFromStorage(), setUser);
      getUserEventsByMail(getEmailFromStorage(), setUncomingEvents);
    }, 250);
  }, []);

  return (
    <div>
      {user && uncomingEvents ? (
        <Container>
          <Row style={{ padding: "8px" }}>
            <Col>
              {uncomingEvents && <InfoUpcomingEvents events={uncomingEvents} />}
            </Col>
          </Row>
          <Row style={{ padding: "8px" }}>
            <Col style={{ margin: "auto" }}>
              <InfoUser user={user} />
            </Col>
            <Col style={{ margin: "auto" }}>
              {user.userDetails && <InfoUserDetails user={user.userDetails} />}
            </Col>
            <Col style={{ margin: "auto" }}>
              {user.userContact && <InfoUserContact user={user.userContact} />}
            </Col>
          </Row>
        </Container>
      ) : (
        <MySpinner />
      )}
    </div>
  );
};

export default MainPage;
