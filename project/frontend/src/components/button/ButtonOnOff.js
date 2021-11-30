import React, { useState } from "react";
import { Button } from "react-bootstrap";

const ButtonOnOff = ({ disabledForm, setDisabledForm }) => {
  const [text, setText] = useState("Edytuj");
  const [theme, setTheme] = useState("danger");

  const clickHandler = () => {
    setDisabledForm(!disabledForm);
    if (text === "Edytuj") {
      setText("Zablokuj edycję");
      setTheme("secondary");
    } else {
      setText("Edytuj");
      setTheme("danger");
    }
  };
  return (
    <div>
      {" "}
      <Button variant={theme} onClick={clickHandler}>
        {text}
      </Button>
    </div>
  );
};

export default ButtonOnOff;
