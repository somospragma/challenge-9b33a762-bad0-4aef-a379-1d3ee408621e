# Integración de seguridad en backend de e-commerce

El sistema de backend de un e-commerce necesita integrar un manejo robusto de excepciones y validaciones de seguridad para mitigar riesgos y vulnerabilidades según OWASP Top 10 y CWE. El sistema interactúa con múltiples componentes, incluyendo el motor de búsqueda de productos, el sistema de pagos y el servicio de autenticación. Debes asegurar que las solicitudes de los usuarios sean validadas y que las excepciones sean manejadas de manera segura y consistente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | E2E prod pool v2 1790308207 |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de riesgos y vulnerabilidades

**Objetivo:** Enumerar y categorizar los riesgos y vulnerabilidades del sistema según OWASP Top 10 y CWE.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Analiza el sistema de backend y enumera los posibles riesgos y vulnerabilidades.
- Clasifica estos riesgos y vulnerabilidades según OWASP Top 10 y CWE.

**Entregable:** Documento que lista y categoriza los riesgos y vulnerabilidades identificados.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los flujos de datos entre componentes y los puntos de entrada del sistema.
- Investiga las categorías de OWASP Top 10 y CWE relevantes para sistemas de e-commerce.

</details>

### Fase 2: Implementación de validaciones de seguridad

**Objetivo:** Integrar validaciones de seguridad en los puntos críticos del sistema.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica los puntos críticos donde se deben aplicar validaciones de seguridad.
- Implementa las validaciones necesarias para mitigar los riesgos identificados en la fase anterior.

**Entregable:** Código que implementa las validaciones de seguridad en los puntos críticos del sistema.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la validación de entradas de usuario y la integridad de los datos.
- Aplica principios de seguridad como la autenticación y la autorización.

</details>

### Fase 3: Manejo de excepciones

**Objetivo:** Implementar un manejo robusto de excepciones para asegurar la estabilidad y seguridad del sistema.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identifica los posibles tipos de excepciones que pueden ocurrir en el sistema.
- Implementa un manejo de excepciones que garantice la estabilidad y seguridad del sistema en caso de fallos.

**Entregable:** Código que implementa un manejo robusto de excepciones en el sistema.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la propagación de excepciones y la recuperación de fallos.
- Aplica principios de tolerancia a fallos y resiliencia.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los riesgos y vulnerabilidades según OWASP Top 10 y CWE?
- **paraQueSirve**: ¿Para qué sirven las validaciones de seguridad en el sistema?
- **comoSeUsa**: ¿Cómo se aplican las validaciones de seguridad en los puntos críticos del sistema?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar validaciones de seguridad y manejo de excepciones?
- **queDecisionesImplica**: ¿Qué decisiones implica el diseño de un sistema robusto de manejo de excepciones?

## Criterios de Evaluacion

- Identificación correcta de riesgos y vulnerabilidades según OWASP Top 10 y CWE.
- Implementación efectiva de validaciones de seguridad en los puntos críticos del sistema.
- Manejo robusto de excepciones que garantiza la estabilidad y seguridad del sistema.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
