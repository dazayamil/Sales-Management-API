# Sequence Diagram — DELETE /api/v1/products/{id}
### HU-11 — Dar de baja producto

```mermaid
sequenceDiagram
    actor Cliente
    participant Filter as JwtAuthFilter
    participant Controller as ProductController
    participant Service as ProductServiceImpl
    participant Repository as ProductRepository
    participant DB as Base de datos

    Cliente->>Filter: DELETE /api/v1/products/{id} (Bearer token)
    
    alt token inválido
        Filter-->>Cliente: 401 Unauthorized
    else token válido — rol EMPLOYEE
        Filter->>Controller: rol verificado
        Controller-->>Cliente: 403 Forbidden
    else token válido — rol ADMIN
        Filter->>Controller: deleteProduct(id)
        Controller->>Service: deleteProduct(id)
        Service->>Repository: findByIdAndActiveTrue(id)
        Repository->>DB: SELECT * FROM product WHERE id = ? AND active = true
        
        alt producto no encontrado
            DB-->>Repository: vacío
            Repository-->>Service: Optional.empty()
            Service-->>Controller: ProductNotFoundException
            Controller-->>Cliente: 404 Not Found
        else producto encontrado
            DB-->>Repository: Product
            Repository-->>Service: Optional<Product>
            Service->>Service: product.setActive(false)
            Service->>Repository: save(product)
            Repository->>DB: UPDATE product SET active = false
            DB-->>Repository: Product actualizado
            Repository-->>Service: void
            Service-->>Controller: void
            Controller-->>Cliente: 200 OK
        end
    end
```