# Business Rules

## Products
- Solo el rol ADMIN puede crear, editar o eliminar productos.
- El nombre, categoría y precio son obligatorios.
- El precio no puede ser 0, negativo o nulo.
- Los productos no se eliminan físicamente, se dan de baja (soft delete).

## Users
- Solo el rol ADMIN puede crear, editar o eliminar usuarios.
- Los usuarios no se eliminan físicamente, se dan de baja (soft delete).

## Sales
- Una venta debe tener al menos un item (producto).
- Una venta debe estar asociada a un usuario autenticado y registrado en el sistema.
- La forma de pago es obligatoria (CASH, TRANSFER, CARD).
- El total de la venta se calcula automáticamente en base a los items y sus precios.
- Solo se pueden editar ventas en estado COMPLETED.
- Una venta no puede ser eliminada físicamente del sistema.

## Sale Status
- **COMPLETED:** la venta fue registrada exitosamente y es válida.
- **CANCELED:** la venta fue anulada. Queda registrada en el sistema pero no es válida.
  Solo el rol ADMIN o EMPLOYEE pueden cancelar una venta.