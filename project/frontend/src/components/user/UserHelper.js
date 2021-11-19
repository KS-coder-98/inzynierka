import { getObjectBySthAsParam } from "../../comunication";

export let getUserByMail = async (id, setUser) => {
  getObjectBySthAsParam(
    "mail",
    id,
    setUser,
    "http://localhost:8080/user/byEmail/"
  );
};
