import UserListLout from "../user/UserListLout";
import CustomCard from "./CustomCard";

import React from "react";

const InfoUser = ({ user }) => {
  return (
    <CustomCard
      bg="success"
      text="light"
      // tHeader="Dane"
      tTitle="Podstawowe informacje"
      content={<UserListLout user={user} />}
    />
  );
};

export default InfoUser;
