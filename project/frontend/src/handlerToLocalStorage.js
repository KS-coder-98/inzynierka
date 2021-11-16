export let setTokenInStorage = (token) => {
  localStorage.setItem("token", token);
};

export let getTokenFromStorage = () => {
  return "Bearer " + localStorage.getItem("token");
};

export let setEmailInStorage = (mail) => {
  localStorage.setItem("mail", mail);
};

export let getEmailFromStorage = () => {
  return localStorage.getItem("mail");
};

export let setNickInStorage = (mail) => {
  localStorage.setItem("nick", mail);
};

export let getNickFromStorage = () => {
  return localStorage.getItem("nick");
};
