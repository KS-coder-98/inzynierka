import React from "react";
import TwoColumnTable from "../TwoColumnTable";

const UserContactLayout = ({ userContact }) => {
  const temp = [
    { key: "Miasto", val: userContact.city },
    { key: "Ulica", val: userContact.street },
    { key: "Nr domu", val: userContact.houseNumber },
    { key: "Nr ulicy", val: userContact.streetNumber },
    { key: "Kod Pocztowy", val: userContact.postCode },
    { key: "Telefon", val: userContact.phoneNumber },
    { key: "Nr kierunkowy", val: userContact.phoneAreaCode },
  ];

  return <TwoColumnTable date={temp} variant="dark" />;
};

export default UserContactLayout;
