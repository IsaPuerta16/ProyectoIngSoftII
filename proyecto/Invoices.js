// src/components/Invoices.js
import React, { useState, useEffect } from 'react';
import { Box, Button, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { getInvoices, deleteInvoice } from '../services/invoiceService';

const Invoices = () => {
  const [invoices, setInvoices] = useState([]);

  useEffect(() => {
    const fetchInvoices = async () => {
      const invoicesData = await getInvoices();
      setInvoices(invoicesData);
    };
    fetchInvoices();
  }, []);

  const handleDeleteInvoice = async (invoiceId) => {
    await deleteInvoice(invoiceId);
    const updatedInvoices = await getInvoices();
    setInvoices(updatedInvoices);
  };

  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Facturas
      </Typography>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Cliente</TableCell>
              <TableCell>Monto</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {invoices.map((invoice) => (
              <TableRow key={invoice.id}>
                <TableCell>{invoice.id}</TableCell>
                <TableCell>{invoice.clientName}</TableCell>
                <TableCell>{invoice.amount}</TableCell>
                <TableCell>
                  <Button onClick={() => handleDeleteInvoice(invoice.id)} color="error">
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

export default Invoices;
