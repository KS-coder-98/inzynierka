import React, { useEffect, useState } from "react";
import { Navbar, Nav, Container, NavDropdown } from "react-bootstrap";
import { isUserAdmin } from "../../handlerToLocalStorage";
import { SignOutButton } from "./SignOutButton";

const MyNavbar = ({ username }) => {
  const [isAdmin, setIsAdmin] = useState();

  useEffect(() => {
    setTimeout(() => {
      setIsAdmin(isUserAdmin);
    }, 150);
  }, []);

  return (
    <Navbar bg="dark" expand="lg" variant="dark">
      <Container>
        <Navbar.Brand href="#home">Conference room booking system</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/">Panel główny</Nav.Link>
            <Nav.Link href="/metings">Wydarzenia</Nav.Link>
            {isAdmin === "admin" && (
              <NavDropdown title="Zarządzaj" id="basic-nav-dropdown">
                <NavDropdown.Item href="/reservations">
                  Dodaj rezerwację
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.2">
                  Dodaj salę
                </NavDropdown.Item>
                <NavDropdown.Item href="/conference-rooms">
                  Edytuj salę
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.3">
                  Edytuj użytkownika
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Dodaj użytkownika
                </NavDropdown.Item>
              </NavDropdown>
            )}
          </Nav>
          <Nav>
            <Navbar.Text>
              <a href="#login">{username}</a>
            </Navbar.Text>
            <Nav.Link href="#features">
              <SignOutButton />
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default MyNavbar;
