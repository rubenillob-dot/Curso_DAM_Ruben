
#### 🗺️ Mapa de Clases y Atributos

| Clase | Tipo | Atributos Principales | Relación / Propósito |
| :--- | :--- | :--- | :--- |
| **RecursoFutbol** | Abstracta | `id`, `titulo`, `anio`, `copiasDisponibles` | Clase Padre (Base) |
| **PartidoHistorico**| Subclase | `competicion`, `mvp` | Hereda de RecursoFutbol |
| **RevistaFutbol** | Subclase | `editorial`, `numeroEdicion` | Hereda de RecursoFutbol |
| **Socio** | Entidad | `dni`, `nombre` | Usuario del sistema |
| **Prestamo** | Entidad | `socio`, `recurso`, `fechaP`, `fechaD` | Une un Socio con un Recurso |



