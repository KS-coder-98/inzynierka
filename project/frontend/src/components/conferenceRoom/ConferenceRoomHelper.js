import {
  getObjectById,
  getAllObjectPromise,
  updateObj,
} from "../../comunication";

export let getConferenceRoomById = async (id, setConferenceRoom) => {
  getObjectById(
    id,
    setConferenceRoom,
    "http://localhost:8080/conference-room/"
  );
};

export let getAllConferenceRooms = async (setConferenceRoom) => {
  getAllObjectPromise(
    setConferenceRoom,
    "http://localhost:8080/conference-room/"
  );
};

export let updateConferenceRoom = async (conferenceRoom) => {
  updateObj("http://localhost:8080/conference-room/update", conferenceRoom);
};
