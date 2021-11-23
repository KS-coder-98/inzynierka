import {
  getEmailFromStorage,
  getNickFromStorage,
  getTokenFromStorage,
  setUserAsUser,
  setUserAsAdmin,
} from "./handlerToLocalStorage";

export let sayHello = async () => {
  const token = getTokenFromStorage();
  let url =
    "http://localhost:8080/user/hello/?mail=" +
    getEmailFromStorage() +
    "&nick=" +
    getNickFromStorage();
  console.log(url);
  await fetch(url, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((isAdmin) => {
      isAdmin ? setUserAsAdmin() : setUserAsUser();
    });
};

//id in url
export let getObjectById = async (id, setter, url) => {
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

export let getAllObject = async (setter, url) => {
  const token = getTokenFromStorage();
  await fetch(url, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((e) => {
      setter(e);
    });
};

export let get = async (url) => {
  const token = getTokenFromStorage();
  await fetch(url, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  });
};

export let getAllObjectPromise = async (setter, url) => {
  const token = getTokenFromStorage();
  await fetch(url, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((e) => {
      setter(e.content);
    });
};

export let getObjectBySthAsParam = async (nameId, id, setter, url) => {
  const token = getTokenFromStorage();
  await fetch(url + "?" + nameId + "=" + id, {
    headers: {
      "Content-type": "application/json; charset=UTF-8",
      Authorization: token,
    },
  })
    .then((response) => response.json())
    .then((e) => {
      setter(e);
    });
};
