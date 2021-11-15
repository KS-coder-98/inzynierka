import React from "react";

const ConferenceRoomLayout = ({ id, name, description, capacity }) => {
  return (
    <div>
      <p>Id: {id}</p>
      <p>Name: {name}</p>
      <p>Description: {description}</p>
      <p>Capacity: {capacity}</p>
    </div>
  );
};

export default ConferenceRoomLayout;
