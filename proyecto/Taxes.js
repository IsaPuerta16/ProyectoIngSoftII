// src/components/Taxes.js
import React, { useState, useEffect } from 'react';
import { Box, Button, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { createTax, getTaxes, deleteTax } from '../services/taxService';

const Taxes = () => {
  const [taxes, setTaxes] = useState([]);
  const [taxName, setTaxName] = useState('');
  const [taxRate, setTaxRate] = useState('');

  useEffect(() => {
    const fetchTaxes = async () => {
      const taxesData = await getTaxes();
      setTaxes(taxesData);
    };
    fetchTaxes();
  }, []);

  const handleCreateTax = async () => {
    await createTax({ name: taxName, rate: taxRate });
    setTaxName('');
    setTaxRate('');
    const updatedTaxes = await getTaxes();
    setTaxes(updatedTaxes);
  };

  const handleDeleteTax = async (taxId) => {
    await deleteTax(taxId);
    const updatedTaxes = await getTaxes();
    setTaxes(updatedTaxes);
  };

  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Impuestos
      </Typography>
      <TextField 
        label="Nombre del Impuesto" 
        value={taxName} 
        onChange={(e) => setTaxName(e.target.value)} 
      />
      <TextField 
        label="Tasa (%)" 
        value={taxRate} 
        onChange={(e) => setTaxRate(e.target.value)} 
        type="number" 
        sx={{ ml: 2 }} 
      />
      <Button onClick={handleCreateTax} variant="contained" sx={{ ml: 2 }}>
        Agregar Impuesto
      </Button>
      <TableContainer component={Paper} sx={{ mt: 2 }}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Nombre</TableCell>
              <TableCell>Tasa</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {taxes.map((tax) => (
              <TableRow key={tax.id}>
                <TableCell>{tax.id}</TableCell>
                <TableCell>{tax.name}</TableCell>
                <TableCell>{tax.rate}</TableCell>
                <TableCell>
                  <Button onClick={() => handleDeleteTax(tax.id)} color="error">
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

export default Taxes;
