import CustomCard from "./CustomCard";
import UserContactLayout from "../user/UserContactLayout";

const InfoUserContact = ({ user }) => {
  return (
    <CustomCard
      bg="info"
      text="light"
      // tHeader="Dane"
      tTitle="Podstawowe informacje"
      content={<UserContactLayout userContact={user} />}
    />
  );
};

export default InfoUserContact;
