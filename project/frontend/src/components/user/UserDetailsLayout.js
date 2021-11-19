import React from "react";
import CustomTable from "../CustomTable";

const UserDetailsLayout = ({ userDetails }) => {
  const temp = [
    { key: "Data urodzenia", val: userDetails.dateOfBirth },
    { key: "Typ konta", val: userDetails.typeOfMembers },
  ];
  return <CustomTable date={temp} variant="dark" />;
};

export default UserDetailsLayout;
