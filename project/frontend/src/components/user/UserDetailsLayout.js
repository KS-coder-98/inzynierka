import React from "react";
import TwoColumnTable from "../TwoColumnTable";

const UserDetailsLayout = ({ userDetails }) => {
  const temp = [
    { key: "Data urodzenia", val: userDetails.dateOfBirth },
    { key: "Typ konta", val: userDetails.typeOfMembers },
  ];
  return <TwoColumnTable date={temp} variant="dark" />;
};

export default UserDetailsLayout;
