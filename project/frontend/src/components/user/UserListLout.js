import React from "react";
import CustomTable from "../CustomTable";

const UserListLout = ({ user }) => {
  const temp = [
    { key: "Imie", val: user.firstName },
    { key: "Nazwisko", val: user.lastName },
    { key: "Nick", val: user.nick },
    { key: "Mail", val: user.email },
  ];

  return <CustomTable date={temp} variant="dark" />;
};

export default UserListLout;
