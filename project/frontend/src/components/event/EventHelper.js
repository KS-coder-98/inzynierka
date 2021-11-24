import { getAllObject, get } from "../../comunication";
import { getEmailFromStorage } from "../../handlerToLocalStorage";

export let getAllEvents = async (setEvent) => {
  await getAllObject(setEvent, "http://localhost:8080/reservation/all");
};

export let joinToEvent = async (idEvent) => {
  let url =
    "http://localhost:8080/reservation/join/?reservationId=" +
    idEvent +
    "&mail=" +
    getEmailFromStorage();
  await get(url);
};

export let cancelReservation = async (idEvent) => {
  let url =
    "http://localhost:8080/reservation/cancel-reservation/?reservationId=" +
    idEvent +
    "&mail=" +
    getEmailFromStorage();
  await get(url);
};

export let deleteReservation = async (idEvent) => {
  let url =
    "http://localhost:8080/reservation/delete/?reservationId=" + idEvent;
  await get(url);
};

// localhost:8080/reservation/join/?reservationId=2&mail=mail5@wp.pl
