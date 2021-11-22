import UpcomingEventsLayoudt from "./UpcomingEventsLayout";
import React, { useEffect, useState } from "react";

const EventMapper = ({ events }) => {
  const [event, setEvent] = useState([]);

  useEffect(() => {
    if (events) setEvent(events);
  }, [events]);
  return (
    <div>
      {Array.isArray(event) &&
        event.map((e) => (
          <UpcomingEventsLayoudt
            key={e.startTime + e.conferenceRoom.name}
            event={e}
          />
        ))}
    </div>
  );
};

export default EventMapper;
