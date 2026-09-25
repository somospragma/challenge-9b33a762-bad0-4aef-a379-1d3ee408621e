# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/ecommerce/domain/exception/AuthenticationException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/ecommerce/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/test/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilterTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java` — `com.ecommerce.application.usecase.PaymentUseCase`: El import com.ecommerce.application.usecase.PaymentUseCase usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java` — `com.ecommerce.domain.model.Payment`: El import com.ecommerce.domain.model.Payment usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java` — `com.ecommerce.infrastructure.repository.ProductJpaRepository`: El import com.ecommerce.infrastructure.repository.ProductJpaRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/ecommerce/infrastructure/config/GlobalExceptionHandler.java` — `AuthenticationException.getMessage`: Se invoca `getMessage` sobre `AuthenticationException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/infrastructure/controller/ProductController.java` — `ProductUseCase.updateProduct`: Se invoca `updateProduct` sobre `ProductUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java` — `Product.getStock`: Se invoca `getStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter backend, Especialidad spring, Tecnología java, Senior L2

### Brecha de conocimiento
comprueba riesgos y vulnerabilidades (owasp top 10, cwe), integrar manejo de excepciones y validaciones de seguridad

### Reto
- Tema: E2E prod pool v2 1790308207
- Seniority: senior-l2
- Tipo: practical
- Título: Integración de seguridad en backend de e-commerce
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de riesgos y vulnerabilidades — objetivo: Enumerar y categorizar los riesgos y vulnerabilidades del sistema según OWASP Top 10 y CWE. — entregable (NO resolver): Documento que lista y categoriza los riesgos y vulnerabilidades identificados.
- Fase 2: Implementación de validaciones de seguridad — objetivo: Integrar validaciones de seguridad en los puntos críticos del sistema. — entregable (NO resolver): Código que implementa las validaciones de seguridad en los puntos críticos del sistema.
- Fase 3: Manejo de excepciones — objetivo: Implementar un manejo robusto de excepciones para asegurar la estabilidad y seguridad del sistema. — entregable (NO resolver): Código que implementa un manejo robusto de excepciones en el sistema.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.ecommerce</groupId>
    <artifactId>ecommerce-backend</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>ecommerce-backend</name>
    <description>Backend para sistema de e-commerce con seguridad y manejo de excepciones</description>

    <properties>
        <java.version>21</java.version>
        <spring-boot.version>3.5.6</spring-boot.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- PostgreSQL -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/ecommerce/Application.java ===
package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .maxAge(3600);
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: ecommerce-backend
  datasource:
    url: jdbc:postgresql://localhost:5432/ecommerce_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  security:
    user:
      name: admin
      password: admin
      roles: ADMIN

server:
  port: 8080
  error:
    include-message: always
    include-binding-errors: always
    include-stacktrace: on_param
    include-exception: false

logging:
  level:
    root: INFO
    org.springframework.web: DEBUG
    org.hibernate: ERROR
    com.ecommerce: DEBUG

jwt:
  secret: ${JWT_SECRET:defaultSecretKeyForDevelopmentOnlyChangeInProduction}
  expiration: 86400000 # 24 hours in milliseconds

// === ARCHIVO: src/main/java/com/ecommerce/domain/exception/ProductNotFoundException.java ===
package com.ecommerce.domain.exception;

import java.util.UUID;

/**
 * Excepción lanzada cuando un producto no se encuentra en el sistema.
 * Se utiliza para indicar que la operación no puede completarse debido a la ausencia del recurso.
 */
public class ProductNotFoundException extends RuntimeException {

    private final UUID productId;

    /**
     * Constructor con el ID del producto que no se encontró.
     * @param productId El ID del producto que no existe.
     */
    public ProductNotFoundException(UUID productId) {
        super("Producto con ID " + productId + " no encontrado.");
        this.productId = productId;
    }

    /**
     * Constructor con mensaje personalizado y el ID del producto.
     * @param message Mensaje descriptivo del error.
     * @param productId El ID del producto que no existe.
     */
    public ProductNotFoundException(String message, UUID productId) {
        super(message);
        this.productId = productId;
    }

    /**
     * Obtiene el ID del producto que no se encontró.
     * @return El ID del producto.
     */
    public UUID getProductId() {
        return productId;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/domain/exception/PaymentFailedException.java ===
package com.ecommerce.domain.exception;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Excepción lanzada cuando falla el procesamiento de un pago.
 * Contiene detalles sobre el intento de pago para facilitar el seguimiento y la recuperación.
 */
public class PaymentFailedException extends RuntimeException {

    private final UUID paymentId;
    private final BigDecimal amount;
    private final String reason;

    /**
     * Constructor con detalles del pago fallido.
     * @param paymentId El ID del intento de pago.
     * @param amount El monto del pago.
     * @param reason La razón del fallo.
     */
    public PaymentFailedException(UUID paymentId, BigDecimal amount, String reason) {
        super("Pago con ID " + paymentId + " falló: " + reason + ". Monto: " + amount);
        this.paymentId = paymentId;
        this.amount = amount;
        this.reason = reason;
    }

    /**
     * Obtiene el ID del intento de pago.
     * @return El ID del pago.
     */
    public UUID getPaymentId() {
        return paymentId;
    }

    /**
     * Obtiene el monto del pago.
     * @return El monto.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Obtiene la razón del fallo.
     * @return La razón del fallo.
     */
    public String getReason() {
        return reason;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/domain/exception/AuthenticationException.java ===
package com.ecommerce.domain.exception;

/**
 * Excepción lanzada cuando falla la autenticación de un usuario.
 * Superficie de práctica para que el participante implemente el manejo adecuado.
 */
public class AuthenticationException extends RuntimeException {

    /**
     * Constructor con mensaje descriptivo.
     * @param message Mensaje que describe el error de autenticación.
     */
    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa raíz.
     * @param message Mensaje que describe el error.
     * @param cause Causa raíz del error.
     */
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/domain/model/Product.java ===
package com.ecommerce.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    @NotNull
    private UUID id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    private String description;
    @NotNull
    private String category;

    public Product() {
    }

    public Product(UUID id, String name, BigDecimal price, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'" +
                ", price=" + price +
                ", description='" + description + '\'" +
                ", category='" + category + '\'" +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/domain/model/User.java ===
package com.ecommerce.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;

public class User {
    @NotNull
    private UUID id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotNull
    private String password;

    public User() {
    }

    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'" +
                ", email='" + email + '\'" +
                ", password='" + password + '\'" +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/domain/port/ProductRepository.java ===
package com.ecommerce.domain.port;

import com.ecommerce.domain.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(UUID id);
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/config/GlobalExceptionHandler.java ===
package com.ecommerce.infrastructure.config;

import com.ecommerce.domain.exception.ProductNotFoundException;
import com.ecommerce.domain.exception.PaymentFailedException;
import com.ecommerce.domain.exception.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<String> handlePaymentFailedException(PaymentFailedException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/adapter/ProductValidator.java ===
package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Product;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ValidProduct, Product> {

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context) {
        if (product == null) {
            return false;
        }
        if (product.getName() == null || product.getName().isEmpty()) {
            return false;
        }
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/security/SecurityConfig.java ===
package com.ecommerce.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Stub para que el estudiante implemente
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        // Stub para que el estudiante implemente
        return null;
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilter.java ===
package com.ecommerce.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (header!= null && header.startsWith("Bearer ")) {
            jwtToken = header.substring(7);
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            } catch (Exception e) {
                // Handle token parsing exception
            }
        }

        if (username!= null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                var usernamePasswordAuthenticationToken = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                       .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/security/JwtTokenUtil.java ===
package com.ecommerce.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private final Key key;

    public JwtTokenUtil(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String subject) {
        return Jwts.builder()
               .setSubject(subject)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
               .signWith(key, SignatureAlgorithm.HS256)
               .compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) &&!isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/controller/ProductController.java ===
package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.usecase.ProductUseCase;
import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    @Autowired
    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productUseCase.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) throws ProductNotFoundException {
        return ResponseEntity.ok(productUseCase.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productUseCase.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product) throws ProductNotFoundException {
        return ResponseEntity.ok(productUseCase.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) throws ProductNotFoundException {
        productUseCase.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java ===
package com.ecommerce.infrastructure.controller;

import com.ecommerce.application.usecase.PaymentUseCase;
import com.ecommerce.domain.exception.PaymentFailedException;
import com.ecommerce.domain.model.Payment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @Autowired
    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Payment> processPayment(@Valid @RequestBody Payment payment) {
        try {
            Payment processedPayment = paymentUseCase.processPayment(payment);
            return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
        } catch (PaymentFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java ===
package com.ecommerce.infrastructure.adapter;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import com.ecommerce.infrastructure.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productJpaRepository.findById(id).map(productEntity -> new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        ));
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(productEntity -> new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getStock()
        )).toList();
    }

    @Override
    public Product save(Product product) {
        var productEntity = new com.ecommerce.infrastructure.repository.ProductEntity(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
        var savedEntity = productJpaRepository.save(productEntity);
        return new Product(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getDescription(),
                savedEntity.getPrice(),
                savedEntity.getStock()
        );
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }
}

// === ARCHIVO: src/main/java/com/ecommerce/application/usecase/ProductUseCase.java ===
package com.ecommerce.application.usecase;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

// === ARCHIVO: src/test/java/com/ecommerce/infrastructure/controller/ProductControllerTest.java ===
package com.ecommerce.infrastructure.controller;

import com.ecommerce.domain.model.Product;
import com.ecommerce.domain.port.ProductRepository;
import com.ecommerce.infrastructure.controller.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product(UUID.randomUUID(), "Test Product", 100.0);
        when(productRepository.findById(any(UUID.class))).thenReturn(java.util.Optional.of(product));

        mockMvc.perform(get("/products/{id}", product.getId())
                       .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
    }
}

// === ARCHIVO: src/test/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilterTest.java ===
package com.ecommerce.infrastructure.security;

import com.ecommerce.infrastructure.security.JwtAuthenticationFilter;
import com.ecommerce.infrastructure.security.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class JwtAuthenticationFilterTest {

    @Mock
    private JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDoFilterInternal() throws ServletException, IOException {
        // TODO: Implement test logic
    }
}
```
