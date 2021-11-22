import { getObjectBySthAsParam } from "../../comunication";

export let getUserByMail = async (id, setUser) => {
  await getObjectBySthAsParam(
    "mail",
    id,
    setUser,
    "http://localhost:8080/user/byEmail/"
  );
};

export let getUserEventsByMail = async (id, setUserEvent) => {
  await getObjectBySthAsParam(
    "mail",
    id,
    setUserEvent,
    "http://localhost:8080/reservation/user-reservation"
  );
};
