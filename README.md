# Sales Management API

API REST backend para la gestión de ventas y productos en comercios de indumentaria.
Desarrollada con Java 21 y Spring Boot 3.

---

## 🧩 Problema del negocio

Muchos pequeños comercios continúan registrando sus ventas de forma manual en cuadernos
o planillas en papel. Este proceso dificulta el acceso a la información, aumenta el riesgo
de pérdida de datos y vuelve más complejo el análisis del negocio.

En una tienda de ropa, cada venta se registra manualmente indicando la fecha, los productos
vendidos, el importe y la forma de pago. Consultar ventas históricas, calcular ingresos o
generar reportes implica revisar grandes cantidades de registros de forma manual.

---

## 🎯 Objetivo del sistema

Digitalizar el proceso de gestión de ventas, permitiendo registrar, editar y consultar
ventas de forma rápida y segura. El sistema facilita el cálculo automático de totales
y la generación de reportes, proporcionando información confiable para la toma de
decisiones y reduciendo errores operativos.

**Beneficios principales:**
- Eliminación del registro manual en papel
- Centralización de la información de ventas
- Menor riesgo de pérdida o deterioro de datos
- Consulta rápida de ventas históricas
- Cálculo automático de totales
- Reportes diarios, semanales y mensuales
- Control de acceso por roles
- Mayor trazabilidad de las operaciones

---

## 👥 Usuarios del sistema

El sistema es accesible desde cualquier navegador web con conexión a internet.
Los usuarios ingresan con sus credenciales y acceden a las funcionalidades
según su rol:

| Rol      | Descripción                                                   |
|----------|---------------------------------------------------------------|
| ADMIN    | Gestiona productos, usuarios y ventas. Accede a reportes.    |
| EMPLOYEE | Registra y edita ventas. Consulta productos y sus ventas.    |

---

## 📦 Funcionalidades principales (v1)

- Autenticación con JWT
- CRUD de usuarios (con soft delete)
- CRUD de productos (con soft delete)
- Registro y edición de ventas
- Consulta de ventas con filtros por fecha, empleado y estado
- Cambio de estado de una venta (completada, cancelada, reembolsada)
- Cálculo automático de totales
- Reporte diario: total vendido, cantidad de ventas y desglose por método de pago

---

## 🚀 Tecnologías

- Java 21
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- Lombok / MapStruct
- Maven
- MySQL

---

## 🏗 Arquitectura

Arquitectura en capas:

Controller → Service → Repository → Database

Spring Security actúa como capa transversal, interceptando cada request
antes de llegar al Controller para validar autenticación y autorización.

---

## 📈 Proyección a futuro

- Soporte multi-local: cada comercio gestiona sus propios usuarios, productos y ventas
- Reportes semanales y mensuales
- Integración con ARCA (AFIP)
- Frontend web (consume esta API)
- Containerización con Docker para despliegue multi-tenant

---

## 📚 Documentación técnica

La documentación completa se encuentra en la carpeta `/docs`:

- Diagrama entidad-relación
- Diagrama UML
- Reglas de negocio
- Diseño de endpoints
- Historias de usuario

---

## 👨‍💻 Desarrollador

**Yamil Daza Rospilloso**  
Backend Developer | Java & Spring Boot

📧 Email: dazayamil07@gmail.com
🔗 LinkedIn: linkedin.com/in/yamil-daza