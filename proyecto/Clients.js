// src/components/Clients.js
import React, { useState, useEffect } from 'react';
import { Box, Button, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { createClient, getClients, deleteClient } from '../services/clientService';

const Clients = () => {
  const [clients, setClients] = useState([]);
  const [clientName, setClientName] = useState('');

  useEffect(() => {
    const fetchClients = async () => {
      const clientsData = await getClients();
      setClients(clientsData);
    };
    fetchClients();
  }, []);

  const handleCreateClient = async () => {
    await createClient({ name: clientName });
    setClientName('');
    const updatedClients = await getClients(); // Actualizar la lista de clientes
    setClients(updatedClients);
  };

  const handleDeleteClient = async (clientId) => {
    await deleteClient(clientId);
    const updatedClients = await getClients();
    setClients(updatedClients);
  };

  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Clientes
      </Typography>
      <TextField 
        label="Nombre del Cliente" 
        value={clientName} 
        onChange={(e) => setClientName(e.target.value)} 
      />
      <Button onClick={handleCreateClient} variant="contained" sx={{ ml: 2 }}>
        Agregar Cliente
      </Button>
      <TableContainer component={Paper} sx={{ mt: 2 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Nombre</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {clients.map((client) => (
              <TableRow key={client.id}>
                <TableCell>{client.id}</TableCell>
                <TableCell>{client.name}</TableCell>
                <TableCell>
                  <Button onClick={() => handleDeleteClient(client.id)} color="error">
                    Eliminar
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
};

export default Clients;
