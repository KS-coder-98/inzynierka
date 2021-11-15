import { getTokenFromStorage } from "../../handlerToLocalStorage";

export let getConferenceRoomById = async (id, setConferenceRoom) => {
  getObjectById(
    id,
    setConferenceRoom,
    "http://localhost:8080/conference-room/"
  );
};

export let getAllConferenceRooms = async (setConferenceRoom) => {
  getAllObject(setConferenceRoom, "http://localhost:8080/conference-room/");
};

let getObjectById = async (id, setter, url) => {
  const token = getTokenFromStorage();
  await fetch(url + id, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((e) => {
      console.log(e);
      setter(e);
    });
};

let getAllObject = async (setter, url) => {
  const token = getTokenFromStorage();
  await fetch(url, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((e) => {
      console.log(e.content);
      setter(e.content);
    });
};
