import CustomCard from "./CustomCard";
import UserDetailsLayout from "../user/UserDetailsLayout";

const InfoUserDetails = ({ user }) => {
  return (
    <CustomCard
      bg="info"
      text="light"
      tHeader="Dane"
      tTitle="Podstawowe informacje"
      content={<UserDetailsLayout userDetails={user} />}
    />
  );
};

export default InfoUserDetails;
