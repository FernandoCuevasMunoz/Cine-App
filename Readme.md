# 🎬 CineApp - Sistema de Cine por Consola

## 📌 Descripción

CineApp es una aplicación de consola desarrollada en **Java**, que simula un sistema básico de gestión de cine.

Permite:
- Crear clientes
- Visualizar cartelera
- Comprar entradas
- Consultar entradas adquiridas

El proyecto aplica los principios fundamentales de la **Programación Orientada a Objetos (POO)**.

---

## 🎯 Objetivo

Desarrollar un sistema que modele el funcionamiento de un cine, utilizando:

- Clases y objetos
- Herencia
- Encapsulación
- Polimorfismo
- Colecciones (`List`)
- Control de flujo (condicionales y bucles)

---

## 🧠 Conceptos aplicados

✔ Clases y objetos  
✔ Encapsulación  
✔ Herencia (`Client` extiende `Person`)  
✔ Polimorfismo (`List<Person>`)  
✔ Colecciones (`ArrayList`)  
✔ Validaciones de negocio  
✔ Menú interactivo por consola  

---

## 📁 Estructura del proyecto


src/

├── app/

│ └── Main.java

├── model/

│ ├── Person.java

│ ├── Client.java

│ ├── Movie.java

│ ├── Showtime.java

│ └── Ticket.java

├── service/

│ └── CinemaService.java

└── util/

└── InputUtil.java


---

## 🧩 Modelado del sistema

### 👤 Person
Clase base que representa una persona.

- `name`
- `getName()`

---

### 👥 Client (hereda de Person)

Representa un cliente del cine.

- Lista de entradas (`List<Ticket>`)
- Métodos para agregar y mostrar entradas

---

### 🎥 Movie

Representa una película.

- `title`
- `genres`
- `duration`
- Método para mostrar información

---

### 🕒 Showtime

Representa una función de cine.

- `Movie movie`
- `String timeTable`
- `int cinemaRoomCapacity`
- `List<Ticket> soldTickets`

Funcionalidades:
- Validar asientos
- Verificar disponibilidad
- Vender entradas

---

### 🎟 Ticket

Representa una entrada comprada.

- Cliente
- Función
- Número de asiento

---

## ⚙️ Funcionalidades principales

### 1. Crear cliente
Permite registrar un nuevo cliente evitando duplicados.

### 2. Ver cartelera
Muestra todas las funciones disponibles.

### 3. Comprar entrada
Permite:
- Seleccionar cliente
- Seleccionar función
- Elegir asiento
- Validar disponibilidad

### 4. Ver entradas del cliente
Muestra todas las entradas compradas por un cliente.

---

## 🚫 Reglas del sistema

- No se pueden vender entradas si no hay asientos disponibles
- No se puede vender el mismo asiento dos veces
- Se valida que el número de asiento sea correcto
- Se evita crear clientes duplicados
