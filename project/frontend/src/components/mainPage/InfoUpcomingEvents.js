import CustomCard from "./CustomCard";
import EventMapper from "./EventMapper";

const InfoUpcomingEvents = ({ events }) => {
  return (
    <CustomCard
      bg="danger"
      text="light"
      //   tHeader="Najbliższe wydarzenie"
      tTitle="Najbliższe wydarzenie"
      content={<EventMapper events={events} />}
    />
  );
};

export default InfoUpcomingEvents;
