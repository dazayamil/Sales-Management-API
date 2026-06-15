# User Stories

---

## HU-01 — Iniciar sesión
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** iniciar sesión con mis credenciales **para** acceder al sistema según mi rol.

**Reglas de negocio:**
- El username y password son obligatorios.
- El sistema devuelve un token JWT para usar en los demás endpoints.

**Criterios de aceptación:**

Escenario 1: inicio de sesión exitoso
- DADO: un usuario registrado con username "juan" y password "1234"
- CUANDO: ingresa sus credenciales y presiona "iniciar sesión"
- ENTONCES: el sistema devuelve un token JWT válido

Escenario 2: credenciales incorrectas
- DADO: un usuario con username "juan" y password incorrecta "0000"
- CUANDO: ingresa sus credenciales y presiona "iniciar sesión"
- ENTONCES: el sistema informa que las credenciales son inválidas

Escenario 3: campos vacíos
- DADO: un usuario que no completa username o password
- CUANDO: presiona "iniciar sesión"
- ENTONCES: el sistema informa que los campos son obligatorios

**Detalles técnicos:**
- Endpoint: POST /api/auth/login
- Autorización: pública
- Response exitoso: 200 OK + JWT token
- Response fallido: 401 Unauthorized / 400 Bad Request

---

## HU-02 — Crear usuario
**Como** ADMIN autenticado **quiero** crear un nuevo usuario **para** darle acceso al sistema.

**Reglas de negocio:**
- Solo el rol ADMIN puede crear usuarios.
- El username y password son obligatorios.
- El rol es obligatorio (ADMIN o EMPLOYEE).
- Los usuarios no se eliminan físicamente, se dan de baja (soft delete).

**Criterios de aceptación:**

Escenario 1: creación exitosa
- DADO: un usuario con username "maria", password "1234", rol "EMPLOYEE"
- CUANDO: el ADMIN completa los datos y presiona "crear usuario"
- ENTONCES: el sistema crea el usuario e informa al ADMIN

Escenario 2: campos vacíos
- DADO: un formulario con username vacío
- CUANDO: el ADMIN presiona "crear usuario"
- ENTONCES: el sistema informa que el username es obligatorio

Escenario 3: username ya existente
- DADO: un username "maria" que ya existe en el sistema
- CUANDO: el ADMIN intenta crear otro usuario con el mismo username
- ENTONCES: el sistema informa que el username ya está en uso

**Detalles técnicos:**
- Endpoint: POST /api/v1/users
- Autorización: ADMIN
- Response exitoso: 201 Created
- Response fallido: 400 Bad Request / 409 Conflict

---

## HU-03 — Listar usuarios
**Como** ADMIN autenticado **quiero** ver el listado de usuarios registrados **para** gestionar el equipo del negocio.

**Reglas de negocio:**
- Solo el rol ADMIN puede ver el listado de usuarios.
- No se muestran usuarios dados de baja (soft delete).

**Criterios de aceptación:**

Escenario 1: listado exitoso
- DADO: usuarios registrados y activos en el sistema
- CUANDO: el ADMIN accede al listado de usuarios
- ENTONCES: el sistema muestra todos los usuarios activos

Escenario 2: sin usuarios registrados
- DADO: ningún usuario activo en el sistema
- CUANDO: el ADMIN accede al listado
- ENTONCES: el sistema devuelve una lista vacía

**Detalles técnicos:**
- Endpoint: GET /api/v1/users
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 401 Unauthorized / 403 Forbidden

---

## HU-04 — Ver usuario por ID
**Como** ADMIN autenticado **quiero** ver el detalle de un usuario **para** consultar su información.

**Reglas de negocio:**
- Solo el rol ADMIN puede consultar un usuario por ID.

**Criterios de aceptación:**

Escenario 1: usuario encontrado
- DADO: un usuario con ID 3 registrado en el sistema
- CUANDO: el ADMIN consulta el usuario con ID 3
- ENTONCES: el sistema devuelve los datos de ese usuario

Escenario 2: usuario no encontrado
- DADO: un ID 99 que no existe en el sistema
- CUANDO: el ADMIN consulta ese ID
- ENTONCES: el sistema informa que el usuario no existe

**Detalles técnicos:**
- Endpoint: GET /api/v1/users/{id}
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-05 — Editar usuario
**Como** ADMIN autenticado **quiero** editar los datos de un usuario **para** mantener la información actualizada.

**Reglas de negocio:**
- Solo el rol ADMIN puede editar usuarios.
- El username y rol son obligatorios.

**Criterios de aceptación:**

Escenario 1: edición exitosa
- DADO: un usuario con ID 3 registrado en el sistema
- CUANDO: el ADMIN modifica el username y presiona "guardar"
- ENTONCES: el sistema actualiza los datos e informa al ADMIN

Escenario 2: usuario no encontrado
- DADO: un ID 99 que no existe en el sistema
- CUANDO: el ADMIN intenta editarlo
- ENTONCES: el sistema informa que el usuario no existe

Escenario 3: campos obligatorios vacíos
- DADO: un formulario con username vacío
- CUANDO: el ADMIN presiona "guardar"
- ENTONCES: el sistema informa que el campo es obligatorio

**Detalles técnicos:**
- Endpoint: PUT /api/v1/users/{id}
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 400 Bad Request / 404 Not Found

---

## HU-06 — Dar de baja usuario
**Como** ADMIN autenticado **quiero** dar de baja a un usuario **para** revocar su acceso al sistema.

**Reglas de negocio:**
- Solo el rol ADMIN puede dar de baja usuarios.
- El usuario no se elimina físicamente, se marca como inactivo (soft delete).
- El historial de ventas del usuario se conserva.

**Criterios de aceptación:**

Escenario 1: baja exitosa
- DADO: un usuario activo con ID 3
- CUANDO: el ADMIN da de baja al usuario con ID 3
- ENTONCES: el sistema marca al usuario como inactivo e informa al ADMIN

Escenario 2: usuario no encontrado
- DADO: un ID 99 que no existe
- CUANDO: el ADMIN intenta dar de baja ese ID
- ENTONCES: el sistema informa que el usuario no existe

**Detalles técnicos:**
- Endpoint: DELETE /api/v1/users/{id}
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-07 — Crear producto
**Como** ADMIN autenticado **quiero** crear un producto nuevo **para** mantener actualizado mi catálogo.

**Reglas de negocio:**
- Solo el rol ADMIN puede crear productos.
- El nombre, categoría y precio son obligatorios.
- El precio no puede ser 0, negativo o nulo.

**Criterios de aceptación:**

Escenario 1: creación exitosa
- DADO: un producto con nombre "A", categoría "JEANS", precio 2000
- CUANDO: el ADMIN completa los datos y presiona "crear producto"
- ENTONCES: el sistema crea el producto e informa al ADMIN

Escenario 2: campos vacíos
- DADO: un formulario con nombre vacío
- CUANDO: el ADMIN presiona "crear producto"
- ENTONCES: el sistema informa que el nombre es obligatorio

Escenario 3: precio inválido
- DADO: un precio de 0 o negativo
- CUANDO: el ADMIN presiona "crear producto"
- ENTONCES: el sistema informa que el precio debe ser mayor a 0

**Detalles técnicos:**
- Endpoint: POST /api/v1/products
- Autorización: ADMIN
- Response exitoso: 201 Created
- Response fallido: 400 Bad Request

---

## HU-08 — Listar productos
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** ver el listado de productos disponibles **para** seleccionarlos al registrar una venta.

**Reglas de negocio:**
- No se muestran productos dados de baja (soft delete).

**Criterios de aceptación:**

Escenario 1: listado exitoso
- DADO: productos activos registrados en el sistema
- CUANDO: el usuario accede al listado de productos
- ENTONCES: el sistema muestra todos los productos activos

Escenario 2: sin productos registrados
- DADO: ningún producto activo en el sistema
- CUANDO: el usuario accede al listado
- ENTONCES: el sistema devuelve una lista vacía

**Detalles técnicos:**
- Endpoint: GET /api/v1/products
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 401 Unauthorized

---

## HU-09 — Ver producto por ID
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** ver el detalle de un producto **para** consultar su información.

**Criterios de aceptación:**

Escenario 1: producto encontrado
- DADO: un producto con ID 5 registrado en el sistema
- CUANDO: el usuario consulta el producto con ID 5
- ENTONCES: el sistema devuelve los datos de ese producto

Escenario 2: producto no encontrado
- DADO: un ID 99 que no existe
- CUANDO: el usuario consulta ese ID
- ENTONCES: el sistema informa que el producto no existe

**Detalles técnicos:**
- Endpoint: GET /api/v1/products/{id}
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-10 — Editar producto
**Como** ADMIN autenticado **quiero** editar un producto **para** mantener actualizado mi catálogo.

**Reglas de negocio:**
- Solo el rol ADMIN puede editar productos.
- El nombre, categoría y precio son obligatorios.
- El precio no puede ser 0, negativo o nulo.

**Criterios de aceptación:**

Escenario 1: edición exitosa
- DADO: un producto con ID 5 registrado en el sistema
- CUANDO: el ADMIN modifica el precio y presiona "guardar"
- ENTONCES: el sistema actualiza el producto e informa al ADMIN

Escenario 2: producto no encontrado
- DADO: un ID 99 que no existe
- CUANDO: el ADMIN intenta editarlo
- ENTONCES: el sistema informa que el producto no existe

Escenario 3: precio inválido
- DADO: un precio de 0 ingresado en el formulario
- CUANDO: el ADMIN presiona "guardar"
- ENTONCES: el sistema informa que el precio debe ser mayor a 0

**Detalles técnicos:**
- Endpoint: PUT /api/v1/products/{id}
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 400 Bad Request / 404 Not Found

---

## HU-11 — Dar de baja producto
**Como** ADMIN autenticado **quiero** dar de baja un producto **para** mantener actualizado mi catálogo.

**Reglas de negocio:**
- Solo el rol ADMIN puede dar de baja productos.
- El producto no se elimina físicamente (soft delete).
- Los SaleItems que referencian ese producto conservan su precio registrado.

**Criterios de aceptación:**

Escenario 1: baja exitosa
- DADO: un producto activo con ID 5
- CUANDO: el ADMIN da de baja el producto con ID 5
- ENTONCES: el sistema marca el producto como inactivo e informa al ADMIN

Escenario 2: producto no encontrado
- DADO: un ID 99 que no existe
- CUANDO: el ADMIN intenta dar de baja ese ID
- ENTONCES: el sistema informa que el producto no existe

**Detalles técnicos:**
- Endpoint: DELETE /api/v1/products/{id}
- Autorización: ADMIN
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-12 — Crear venta
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** registrar una nueva venta **para** mantener el registro de ventas actualizado.

**Reglas de negocio:**
- La venta debe tener al menos un item.
- La forma de pago es obligatoria.
- El total se calcula automáticamente.
- La venta queda asociada al usuario autenticado.
- El estado inicial es COMPLETED.

**Criterios de aceptación:**

Escenario 1: creación exitosa
- DADO: una venta con 2 items, forma de pago CASH
- CUANDO: el usuario completa los datos y presiona "registrar venta"
- ENTONCES: el sistema registra la venta, calcula el total e informa al usuario

Escenario 2: sin items
- DADO: una venta sin items cargados
- CUANDO: el usuario presiona "registrar venta"
- ENTONCES: el sistema informa que la venta debe tener al menos un item

Escenario 3: sin forma de pago
- DADO: una venta con items pero sin forma de pago seleccionada
- CUANDO: el usuario presiona "registrar venta"
- ENTONCES: el sistema informa que la forma de pago es obligatoria

**Detalles técnicos:**
- Endpoint: POST /api/v1/sales
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 201 Created
- Response fallido: 400 Bad Request

---

## HU-13 — Listar ventas
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** ver el listado de ventas **para** consultar el historial de operaciones.

**Criterios de aceptación:**

Escenario 1: listado exitoso
- DADO: ventas registradas en el sistema
- CUANDO: el usuario accede al listado de ventas
- ENTONCES: el sistema muestra todas las ventas registradas

Escenario 2: sin ventas registradas
- DADO: ninguna venta en el sistema
- CUANDO: el usuario accede al listado
- ENTONCES: el sistema devuelve una lista vacía

**Detalles técnicos:**
- Endpoint: GET /api/v1/sales
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 401 Unauthorized

---

## HU-14 — Ver venta por ID
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** ver el detalle de una venta **para** consultar sus items y total.

**Criterios de aceptación:**

Escenario 1: venta encontrada
- DADO: una venta con ID 10 registrada en el sistema
- CUANDO: el usuario consulta la venta con ID 10
- ENTONCES: el sistema devuelve el detalle completo de la venta con sus items

Escenario 2: venta no encontrada
- DADO: un ID 99 que no existe
- CUANDO: el usuario consulta ese ID
- ENTONCES: el sistema informa que la venta no existe

**Detalles técnicos:**
- Endpoint: GET /api/v1/sales/{id}
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-15 — Editar venta
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** editar una venta **para** corregir errores de carga.

**Reglas de negocio:**
- Solo se pueden editar ventas en estado COMPLETED.
- El total se recalcula automáticamente al editar.

**Criterios de aceptación:**

Escenario 1: edición exitosa
- DADO: una venta en estado COMPLETED con ID 10
- CUANDO: el usuario modifica la forma de pago y presiona "guardar"
- ENTONCES: el sistema actualiza la venta e informa al usuario

Escenario 2: venta no editable
- DADO: una venta en estado CANCELED con ID 10
- CUANDO: el usuario intenta editarla
- ENTONCES: el sistema informa que la venta no puede editarse

Escenario 3: venta no encontrada
- DADO: un ID 99 que no existe
- CUANDO: el usuario intenta editarla
- ENTONCES: el sistema informa que la venta no existe

**Detalles técnicos:**
- Endpoint: PUT /api/v1/sales/{id}
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 400 Bad Request / 404 Not Found

---

## HU-16 — Cancelar venta
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** cancelar una venta **para** anularla sin perder el historial.

**Reglas de negocio:**
- Una venta cancelada no puede editarse.
- La venta no se elimina físicamente del sistema.

**Criterios de aceptación:**

Escenario 1: cancelación exitosa
- DADO: una venta en estado COMPLETED con ID 10
- CUANDO: el usuario cancela la venta con ID 10
- ENTONCES: el sistema marca la venta como CANCELED e informa al usuario

Escenario 2: venta no encontrada
- DADO: un ID 99 que no existe
- CUANDO: el usuario intenta cancelarla
- ENTONCES: el sistema informa que la venta no existe

**Detalles técnicos:**
- Endpoint: PATCH /api/v1/sales/{id}/status
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 404 Not Found

---

## HU-17 — Ver reporte diario
**Como** usuario autenticado (ADMIN o EMPLOYEE) **quiero** ver el reporte de ventas de un día específico **para** conocer el total vendido y el desglose por método de pago.

**Reglas de negocio:**
- La fecha es obligatoria.
- El reporte muestra solo ventas en estado COMPLETED.

**Criterios de aceptación:**

Escenario 1: reporte exitoso
- DADO: ventas registradas el día 2026-06-15
- CUANDO: el usuario consulta el reporte del día 2026-06-15
- ENTONCES: el sistema devuelve el total vendido, cantidad de ventas y desglose por método de pago

Escenario 2: sin ventas en la fecha
- DADO: ninguna venta registrada el día 2026-06-15
- CUANDO: el usuario consulta el reporte de ese día
- ENTONCES: el sistema devuelve total 0 y lista vacía

Escenario 3: fecha no ingresada
- DADO: una consulta sin fecha
- CUANDO: el usuario intenta ver el reporte
- ENTONCES: el sistema informa que la fecha es obligatoria

**Detalles técnicos:**
- Endpoint: GET /api/v1/sales/daily-report?date=2026-06-15
- Autorización: ADMIN, EMPLOYEE
- Response exitoso: 200 OK
- Response fallido: 400 Bad Request