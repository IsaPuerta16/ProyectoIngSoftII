// src/components/Dashboard.js
import React from 'react';
import { Box, Typography } from '@mui/material';

const Dashboard = () => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <Typography variant="h4" gutterBottom>
        Bienvenido al Dashboard
      </Typography>
      <Typography variant="body1">
        Aquí podrás ver un resumen de todas las actividades y estadísticas.
      </Typography>
    </Box>
  );
};

export default Dashboard;
