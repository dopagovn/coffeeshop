'use client';
import { StyledButton } from "~/app/styles";

const Button = ({ children, variant, sx }) => {
  return (
    <StyledButton sx={sx} variant={variant}>{children}</StyledButton>
  )
};

export default Button;