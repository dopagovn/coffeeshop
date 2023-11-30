'use client';

const { StyledTextField } = require("~/app/styles");

const TextField = ({ variant, sx, name, placeholder, onChange, type, label }) => {
  return (
    <StyledTextField name={name} type={type} onChange={onChange} label={label || name} placeholder={placeholder} sx={sx} variant={variant} />
  )
}

export default TextField;