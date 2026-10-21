# Sequence Diagrams

## Products

### GET /api/v1/products — getAllProducts

```mermaid
sequenceDiagram
    actor Cliente
    participant Controller as ProductController
    participant Service as ProductServiceImpl
    participant Repository as ProductRepository
    participant DB as Base de datos

    Cliente->>Controller: GET /api/v1/products (Bearer token)
    Controller->>Service: getAllProducts()
    Service->>Repository: findAllByActiveTrue()
    Repository->>DB: SELECT * FROM product WHERE active = true
    DB-->>Repository: List<Product>
    Repository-->>Service: List<Product>
    Service->>Service: mapper.toResponseDTOList()
    Service-->>Controller: List<ProductResponseDTO>
    Controller-->>Cliente: 200 OK + List<ProductResponseDTO>
```