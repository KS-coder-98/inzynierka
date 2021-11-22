import TwoColumnTable from "../TwoColumnTable";

const UpcomingEventsLayout = ({ event }) => {
  const temp = [
    { key: "Lokalizacja", val: event.conferenceRoom.name },
    { key: "Nazwa", val: event.name },
    { key: "Początek wydarzenia", val: event.startTime },
    { key: "Koniec wydarzenia", val: event.endTime },
  ];

  return <TwoColumnTable date={temp} variant="dark" />;
};

export default UpcomingEventsLayout;
