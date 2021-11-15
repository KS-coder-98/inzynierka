export let setTokenInStorage = (token) => {
  localStorage.setItem("token", token);
};

export let getTokenFromStorage = () => {
  return "Bearer " + localStorage.getItem("token");
};
