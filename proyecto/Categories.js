// src/components/Categories.js
import React, { useState, useEffect } from 'react';
import { Box, Button, TextField, Typography, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from '@mui/material';
import { createCategory, getCategories, deleteCategory } from '../services/categoryService';

const Categories = () => {
  const [categories, setCategories] = useState([]);
  const [categoryName, setCategoryName] = useState('');

  useEffect(() => {
    const fetchCategories = async () => {
      const categoriesData = await getCategories();
      setCategories(categoriesData);
    };
    fetchCategories();
  }, []);

  const handleCreateCategory = async () => {
    await createCategory({ name: categoryName });
    setCategoryName('');
    const updatedCategories = await getCategories();
    setCategories(updatedCategories);
  };

  const handleDeleteCategory = async (categoryId) => {
    await deleteCategory(categoryId);
    const updatedCategories = await getCategories();
    setCategories(updatedCategories);
  };

  return (
    <Box sx={{ flexGrow: 1, padding: 2 }}>
      <Typography variant="h4" gutterBottom>
        Categorías
      </Typography>
      <TextField 
        label="Nombre de la Categoría" 
        value={categoryName} 
        onChange={(e) => setCategoryName(e.target.value)} 
      />
      <Button onClick={handleCreateCategory} variant="contained" sx={{ ml: 2 }}>
        Agregar Categoría
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
            {categories.map((category) => (
              <TableRow key={category.id}>
                <TableCell>{category.id}</TableCell>
                <TableCell>{category.name}</TableCell>
                <TableCell>
                  <Button onClick={() => handleDeleteCategory(category.id)} color="error">
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

export default Categories;
