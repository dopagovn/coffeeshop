import styled from "@emotion/styled";
import { Button, ButtonBase, FormHelperText, InputLabel, TextField } from "@mui/material";
import { DesktopDatePicker, PickersCalendarHeaderClasses } from "@mui/x-date-pickers";

export const StyledButton = styled(Button)(() => ({
  '&.MuiButton-root': {
  },
  '&.MuiButton-outlined': {
    color: '#805E44',
    fontWeight: 600,
    borderColor: '#805E44',
    background: 'none',
    borderRadius: 10,
  },
  '&.MuiButton-text': {
    color: '#805E44',
    borderRadius: 10,
  },
  '&.MuiButton-contained': {
    color: '#FFFFFF',
    borderRadius: 10,
    background: '#805E44',
    fontFamily: "Source Code Pro, monospace",
  }
}))

export const StyledTextField = styled(TextField, InputLabel, FormHelperText)(() => ({
  '& .MuiInputLabel-root': {
    fontFamily: "Source Code Pro, monospace",
    fontWeight: 600,
    '&.Mui-focused': {
      fontFamily: "Source Code Pro, monospace",
      color: '#805E44',
    }
  },
  '& .MuiFilledInput-root:after': {
    borderBottom: '2px solid #805E44',
  },
  '& .MuiInput-root': {
    fontFamily: "Source Code Pro, monospace",
    fontWeight: 600,
    color: '#805E44'
  },
  '& .MuiInput-root:after': {
    borderBottom: '2px solid #805E44',
  },
  '& .Mui-focused .MuiOutlinedInput-notchedOutline': {
    borderColor: '#805E44 !important',
  }
}));

export const StyledDatePicker = styled(DesktopDatePicker, PickersCalendarHeaderClasses, ButtonBase)(() => ({
  '& .MuiPickersDay-root.Mui-selected': {
    backgroundColor: '#805E44',
    color: '#FFF',
    fontWeight: 600,
    fontFamily: "Source Code Pro, monospace",
  },
}))
