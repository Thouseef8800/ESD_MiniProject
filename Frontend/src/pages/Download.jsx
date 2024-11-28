import { useState } from "react";
import axios from "axios";
import { useLocation } from "react-router-dom";

const Download = () => {
  const location = useLocation();
  const email = location.state?.email;
  const [selectedMonth, setSelectedMonth] = useState("");
  const [errorMessage, setErrorMessage] = useState(null);

  const months = [
    { name: "January", value: 1 },
    { name: "February", value: 2 },
    { name: "March", value: 3 },
    { name: "April", value: 4 },
    { name: "May", value: 5 },
    { name: "June", value: 6 },
    { name: "July", value: 7 },
    { name: "August", value: 8 },
    { name: "September", value: 9 },
    { name: "October", value: 10 },
    { name: "November", value: 11 },
    { name: "December", value: 12 },
  ];

  const handleMonthChange = (event) => {
    setSelectedMonth(event.target.value);
  };

  const handleDownload = async () => {
    if (!selectedMonth) {
      setErrorMessage("Please select a month!");
      return;
    }

    if (!email) {
      setErrorMessage("Email is not provided. Please log in.");
      return;
    }

    try {
      const token = JSON.parse(localStorage.getItem("jwtToken"));
      if (!token) {
        setErrorMessage("User is not authenticated. Please log in.");
        return;
      }

      const response = await axios.get("http://localhost:8080/download", {
        params: { email, month: selectedMonth },
        headers: {
          Authorization: `Bearer ${token}`,
        },
        responseType: "blob",
      });

      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement("a");
      link.href = url;
      link.setAttribute("download", `SalaryReport-${selectedMonth}.pdf`);
      document.body.appendChild(link);
      link.click();

      setErrorMessage(null);
    } catch (error) {
      console.error("Error downloading PDF:", error);
      if (error.response) {
        setErrorMessage("Failed to download the PDF. Please try again.");
      } else {
        setErrorMessage("An unexpected error occurred.");
      }
    }
  };

  return (
    <div className="container">
      <h2>Download Monthly Salary Report</h2>
      {errorMessage && <p className="text-danger">{errorMessage}</p>}
      <div className="form-group">
        <label htmlFor="month">Select Month:</label>
        <select
          id="month"
          className="form-control"
          value={selectedMonth}
          onChange={handleMonthChange}
        >
          <option value="">--Select a Month--</option>
          {months.map((month) => (
            <option key={month.value} value={month.value}>
              {month.name}
            </option>
          ))}
        </select>
      </div>
      <button
        className="btn btn-primary mt-3"
        onClick={handleDownload}
        disabled={!selectedMonth}
      >
        Download PDF
      </button>
    </div>
  );
};

export default Download;
