# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Integración de seguridad en backend de e-commerce**.

| | |
|---|---|
| Tema | E2E prod pool v2 1790308207 |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con capas estándar (dominio, aplicación, infraestructura) |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web n/a
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-security n/a
- io.jsonwebtoken:jjwt-api 0.11.5
- io.jsonwebtoken:jjwt-impl 0.11.5
- io.jsonwebtoken:jjwt-jackson 0.11.5
- org.postgresql:postgresql n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.springframework.security:spring-security-test n/a

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de riesgos y vulnerabilidades**: Documento que lista y categoriza los riesgos y vulnerabilidades identificados.
- **Fase 2 — Implementación de validaciones de seguridad**: Código que implementa las validaciones de seguridad en los puntos críticos del sistema.
- **Fase 3 — Manejo de excepciones**: Código que implementa un manejo robusto de excepciones en el sistema.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/ecommerce/domain/exception/AuthenticationException.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/infrastructure/security/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/main/java/com/ecommerce/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- [ ] `src/test/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilterTest.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (6)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java` — `com.ecommerce.application.usecase.PaymentUseCase`
      El import com.ecommerce.application.usecase.PaymentUseCase usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java` — `com.ecommerce.domain.model.Payment`
      El import com.ecommerce.domain.model.Payment usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java` — `com.ecommerce.infrastructure.repository.ProductJpaRepository`
      El import com.ecommerce.infrastructure.repository.ProductJpaRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/ecommerce/infrastructure/config/GlobalExceptionHandler.java` — `AuthenticationException.getMessage`
      Se invoca `getMessage` sobre `AuthenticationException`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/infrastructure/controller/ProductController.java` — `ProductUseCase.updateProduct`
      Se invoca `updateProduct` sobre `ProductUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java` — `Product.getStock`
      Se invoca `getStock` sobre `Product`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (20)

- `pom.xml`
- `src/main/java/com/ecommerce/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/ecommerce/domain/exception/ProductNotFoundException.java`
- `src/main/java/com/ecommerce/domain/exception/PaymentFailedException.java`
- `src/main/java/com/ecommerce/domain/exception/AuthenticationException.java`
- `src/main/java/com/ecommerce/domain/model/Product.java`
- `src/main/java/com/ecommerce/domain/model/User.java`
- `src/main/java/com/ecommerce/domain/port/ProductRepository.java`
- `src/main/java/com/ecommerce/infrastructure/config/GlobalExceptionHandler.java`
- `src/main/java/com/ecommerce/infrastructure/adapter/ProductValidator.java`
- `src/main/java/com/ecommerce/infrastructure/security/SecurityConfig.java`
- `src/main/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilter.java`
- `src/main/java/com/ecommerce/infrastructure/security/JwtTokenUtil.java`
- `src/main/java/com/ecommerce/infrastructure/controller/ProductController.java`
- `src/main/java/com/ecommerce/infrastructure/controller/PaymentController.java`
- `src/main/java/com/ecommerce/infrastructure/adapter/ProductRepositoryAdapter.java`
- `src/main/java/com/ecommerce/application/usecase/ProductUseCase.java`
- `src/test/java/com/ecommerce/infrastructure/controller/ProductControllerTest.java`
- `src/test/java/com/ecommerce/infrastructure/security/JwtAuthenticationFilterTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/ecommerce`
- `src/main/java/com/ecommerce/domain`
- `src/main/java/com/ecommerce/domain/exception`
- `src/main/java/com/ecommerce/domain/model`
- `src/main/java/com/ecommerce/domain/port`
- `src/main/java/com/ecommerce/application`
- `src/main/java/com/ecommerce/application/usecase`
- `src/main/java/com/ecommerce/infrastructure`
- `src/main/java/com/ecommerce/infrastructure/adapter`
- `src/main/java/com/ecommerce/infrastructure/config`
- `src/main/java/com/ecommerce/infrastructure/controller`
- `src/main/java/com/ecommerce/infrastructure/security`
- `src/main/resources`
- `src/test/java/com/ecommerce`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con capas estándar (dominio, aplicación, infraestructura)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter backend, Especialidad spring, Tecnología java, Senior L2
- Brecha que el reto ataca: comprueba riesgos y vulnerabilidades (owasp top 10, cwe), integrar manejo de excepciones y validaciones de seguridad

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
