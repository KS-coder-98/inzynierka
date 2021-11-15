import React, { useState, useEffect } from "react";
import { getTokenFromStorage } from "../handlerToLocalStorage";

const Meetings = () => {
  const [meetings, setmeetings] = useState([]);

  useEffect(() => {
    const fetchTasks = async () => {
      const token = getTokenFromStorage();
      console.log(token);

      await fetch("http://localhost:8080/equipment/3", {
        headers: {
          "Content-type": "application/json; charset=UTF-8",
          Authorization: token,
        },
      })
        .then((response) => response.json())
        .then((e) => {
          let temp = {
            id: e.id,
            text: e.name,
            day: e.description,
            reminder: false,
          };
          setmeetings([temp]);
          console.log(meetings);
        })
        .catch((e) => console.log(e));
    };

    fetchTasks();
  }, []);

  return (
    <div>
      <p>rezerwace</p>
    </div>
  );
};

export default Meetings;
