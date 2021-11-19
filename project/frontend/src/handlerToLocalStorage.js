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

export let setNickInStorage = (nick) => {
  localStorage.setItem("nick", nick);
};

export let getNickFromStorage = () => {
  return localStorage.getItem("nick");
};

export let isUserAdmin = () => {
  return localStorage.getItem("type_account");
};

export let setUserAsAdmin = () => {
  localStorage.setItem("type_account", "admin");
};

export let setUserAsUser = () => {
  localStorage.setItem("type_account", "user");
};
