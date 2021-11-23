import { getAllObject } from "../../comunication";

export let getAllEvents = async (setEvent) => {
  await getAllObject(setEvent, "http://localhost:8080/reservation/all");
};
