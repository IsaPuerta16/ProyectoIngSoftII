// src/components/Products.js
import React, { useState, useEffect } from 'react';
import { Box, Button, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { createProduct, getProducts, deleteProduct } from '../services/productService';

const Products = () => {
  const [products, setProducts] = useState([]);
  const [productName, setProductName] = useState('');

  useEffect(() => {
    const fetchProducts = async () => {
      const productsData = await getProducts();
      setProducts(productsData);
    };
    fetchProducts();
  }, []);

  const handleCreateProduct = async () => {
    await createProduct({ name: productName });
    setProductName('');
    const updatedProducts = await getProducts();
    setProducts(updatedProducts);
  };

  const handleDeleteProduct = async (productId) => {
    await deleteProduct(productId);
    const updatedProducts = await getProducts();
    setProducts(updatedProducts);
  };

  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Productos
      </Typography>
      <TextField 
        label="Nombre del Producto" 
        value={productName} 
        onChange={(e) => setProductName(e.target.value)} 
      />
      <Button onClick={handleCreateProduct} variant="contained" sx={{ ml: 2 }}>
        Agregar Producto
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
            {products.map((product) => (
              <TableRow key={product.id}>
                <TableCell>{product.id}</TableCell>
                <TableCell>{product.name}</TableCell>
                <TableCell>
                  <Button onClick={() => handleDeleteProduct(product.id)} color="error">
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

export default Products;
