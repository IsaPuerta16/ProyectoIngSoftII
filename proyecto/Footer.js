// src/components/Footer.js
import React from 'react';
import { Box, Typography } from '@mui/material';

const Footer = () => {
  return (
    <Box sx={{ mt: 'auto', p: 2, textAlign: 'center', backgroundColor: '#f8f9fa' }}>
      <Typography variant="body2" color="text.secondary">
        © 2024 Sistema de Facturación
      </Typography>
    </Box>
  );
};

export default Footer;
