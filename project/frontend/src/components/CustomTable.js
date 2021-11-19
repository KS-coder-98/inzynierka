import React from "react";
import { Table } from "react-bootstrap";

const CustomTable = ({ date, variant }) => {
  return (
    <Table striped bordered hover variant={variant}>
      <tbody>
        {date.map((e) => (
          <tr key={e.key + e.val}>
            <td>{e.key}</td>
            <td>{e.val ? e.val : "brak informacji"}</td>
          </tr>
        ))}
      </tbody>
    </Table>
  );
};

export default CustomTable;
