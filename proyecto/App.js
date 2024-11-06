import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Sidebar from './components/Sidebar';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Dashboard from './components/Dashboard';
import Categories from './components/Categories';
import Clients from './components/Clients';
import Invoices from './components/Invoices';
import Products from './components/Products';
import Taxes from './components/Taxes';
import Reports from './components/Reports';
import { Container, Box, CssBaseline, ThemeProvider, createTheme } from '@mui/material';

const theme = createTheme();

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Router>
        <Box sx={{ display: 'flex', flexDirection: 'column', height: '100vh' }}>
          <Navbar /> {/* Barra de navegación agregada aquí */}
          <Box sx={{ display: 'flex', flexGrow: 1 }}>
            <Sidebar />
            <Container maxWidth="lg" sx={{ mt: 4, mb: 4 }}>
            <Routes>
              <Route path="/" element={<Dashboard />} />
              <Route path="/categories" element={<Categories />} />
              <Route path="/clients" element={<Clients />} />
              <Route path="/invoices" element={<Invoices />} />
              <Route path="/products" element={<Products />} />
              <Route path="/taxes" element={<Taxes />} />
              <Route path="/reports" element={<Reports />} />
            </Routes>
          </Container>
          </Box>
          <Footer /> {/* Footer agregado aquí */}
        </Box>
      </Router>
    </ThemeProvider>
  );
}

export default App;
