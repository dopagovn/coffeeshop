'use client';

import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { StyledDatePicker } from "~/app/styles";

const DatePicker = () => {
  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <StyledDatePicker />
    </LocalizationProvider>
  )
}

export default DatePicker;