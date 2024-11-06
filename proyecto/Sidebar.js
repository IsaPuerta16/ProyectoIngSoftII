// src/components/Reports.js
import React from 'react';
import { Box, Typography } from '@mui/material';

const Reports = () => {
  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Informes
      </Typography>
      <Typography variant="body1">
        Aquí podrás generar y ver informes sobre tus actividades.
      </Typography>
    </Box>
  );
};

export default Reports;
