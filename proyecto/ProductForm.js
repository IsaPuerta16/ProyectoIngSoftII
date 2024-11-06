import React, { useState } from 'react';

function ProductForm() {
  const [nombre, setNombre] = useState('');
  const [precio, setPrecio] = useState('');
  const [stock, setStock] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    // Lógica para enviar los datos al backend
    console.log({ nombre, precio, stock });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Agregar Producto</h2>
      <input
        type="text"
        placeholder="Nombre"
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
      />
      <input
        type="number"
        placeholder="Precio"
        value={precio}
        onChange={(e) => setPrecio(e.target.value)}
      />
      <input
        type="number"
        placeholder="Stock"
        value={stock}
        onChange={(e) => setStock(e.target.value)}
      />
      <button type="submit">Guardar Producto</button>
    </form>
  );
}

export default ProductForm;
