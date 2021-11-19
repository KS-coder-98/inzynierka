import { getObjectById, getAllObject } from "../../comunication";

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
