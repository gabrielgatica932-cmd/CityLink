# CityLink: declaración de uso de inteligencia artificial

Materia: Programación I (2026) - Proyecto Integrador CityLink
Integrantes: Walter Gabriel Gatica, Axel Farías, Alexis Becerra, Tomas Litardo
Fecha: 19/11/2026

## 1. Herramienta utilizada

- Nombre: Claude, de Anthropic.
- Tipo de IA: asistente conversacional de inteligencia artificial generativa, basado en un modelo de lenguaje grande (LLM). Recibe texto, capturas de pantalla y archivos, y responde con explicaciones y código.
- Modalidad de uso: chat. No estuvo conectada al editor ni al repositorio: el equipo le enviaba consultas, capturas de errores y archivos, y después copiaba, adaptaba y probaba lo que respondía.
- Versión: Claude Sonnet 5.5.
- No se utilizaron otras herramientas de IA.

## 2. Para qué se usó

### 2.1 Recordar fundamentos

Se usó para repasar y entender conceptos de la materia con ejemplos del propio proyecto:

- Herencia y abstracción: qué es una clase abstracta, un método abstracto, extends y super.
- Interfaces de comportamiento: qué es una interfaz, implements, implementación simultánea de Rastreable y Facturable, y la diferencia con una clase abstracta.
- Polimorfismo puro: cómo calcular costos sin instanceof ni switch por tipo.
- Encapsulamiento: por qué los atributos son private y se accede con getters y setters.
- Palabras clave: final, static, @Override, this, enum, y la diferencia entre sobrescritura y sobrecarga.
- Excepciones: diferencia entre checked y unchecked, y el reparto en capas (throw en el modelo, throws en el gestor, try-catch solo en Main).

### 2.2 Estructuras y organización del proyecto

- Cómo organizar el proyecto en una sola carpeta, sin paquetes, y en qué orden crear los archivos según sus dependencias.
- Cómo separar las responsabilidades: el modelo no usa Scanner ni imprime, el gestor guarda y busca, y Main se ocupa de la pantalla y el teclado.
- Cómo trabajar con arreglos estáticos y contadores: límites de 50, 100 y 10 elementos, búsqueda lineal y eliminación desplazando los elementos para no dejar huecos.
- Cómo armar textos sin imprimir (StringBuilder y String.format) para respetar que el modelo no imprime.

### 2.3 Corrección de errores

Se enviaron capturas y archivos con errores del editor, y la IA ayudó a encontrar la causa:

- Constructor de Cliente que no coincidía con la llamada de Main (tipos distintos en código y teléfono).
- Método abstracto getTipo sin declarar en Pedido.
- Variable escrita con mayúscula distinta (PesoKg en lugar de pesoKg).
- Llaves mal ubicadas en el gestor, con líneas fuera de un método, y un método de búsqueda con tipo de retorno incorrecto.
- Una línea package en un proyecto que no usa paquetes.
- Un main vacío que hacía que el programa terminara al instante.
- Una comparación de un número entero con null.
- Una excepción que no se encontraba porque faltaba crear su archivo.

### 2.4 Inspiración

- Ideas para el diseño general: ciclo de estados del pedido con un enum, comisión del repartidor dentro de Repartidor, factura que combina costo, tiempo estimado y comisión.
- Estructura del menú de 12 opciones y una precarga con pedidos en distintos estados.
- Valores de ejemplo para capacidades, velocidades, costos y recargos. Esos números fueron propuestos como ejemplo y deben ajustarse a lo que pida el enunciado.

### 2.5 Propuestas de código

La IA también redactó propuestas de código (por ejemplo, la estructura de Main, de las clases del modelo y del gestor). Ese código fue revisado, adaptado y probado por el equipo antes de incorporarlo.

## 3. Cómo se validó el código

- Se compiló todo el proyecto con javac *.java y se resolvieron los errores que marcaba el editor.
- Se ejecutó el programa con los datos de la precarga (5 clientes, 3 repartidores y 8 pedidos) y se probó cada opción del menú.
- Se probaron los casos borde del enunciado: datos numéricos inválidos o vacíos, listas vacías, código duplicado, cupo lleno, eliminación de un cliente del medio del arreglo, capacidad excedida, estado inválido y facturar un pedido sin repartidor.
- Se verificó que el modelo y el gestor no usen Scanner ni System.out, y que el try-catch esté solo en Main.
- Se revisó el código línea por línea entre los integrantes.

## 4. Límites de la IA y responsabilidad del equipo

- La IA cometió errores (por ejemplo, textos con faltas de tipeo y valores inventados), por eso todo se revisó y se probó.
- Las decisiones finales y la integración de los archivos las tomó el equipo.
- Todo el código fue leído y entendido por los integrantes, quienes pueden explicar cualquier parte en la defensa oral.
