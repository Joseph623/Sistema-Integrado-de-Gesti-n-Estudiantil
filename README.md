# 🎓 Sistema Integrado de Gestión Estudiantil

Este proyecto es una aplicación educativa desarrollada en Java con formularios (Java Swing), que permite gestionar de manera integrada la información **académica, administrativa, médica y de asistencia** de los estudiantes, conectando múltiples bases de datos.

---

## 🚀 Tecnologías Utilizadas

| Tecnología        | Propósito                                      |
|-------------------|-----------------------------------------------|
| Java Swing        | Desarrollo de interfaces gráficas (GUI)       |
| MySQL             | Gestión de estudiantes, cursos y notas        |
| PostgreSQL        | Matrícula y pagos                             |
| MongoDB           | Registro de fichas médicas                    |
| Cassandra (Astra) | Registro de asistencia diaria                 |
| Redis             | Historial de actividad del usuario            |
| Git + GitHub      | Control de versiones y publicación del código |


---

## 🧩 Módulos del Sistema

- **Módulo Académico (MySQL):** Estudiantes, cursos y calificaciones.
- **Módulo Administrativo (PostgreSQL):** Matrícula por ciclo y pagos.
- **Módulo Médico (MongoDB):** Estado físico y emocional de cada alumno.
- **Módulo de Asistencia (Cassandra):** Asistencia diaria por fecha y hora.
- **Interfaz Unificada:** Todo en una misma aplicación con Java Swing.

---

## 🧪 Pruebas Realizadas

- 200 estudiantes generados
- 20 cursos registrados
- 1,000 notas simuladas
- 500 asistencias registradas
- 150 fichas médicas
- Tiempos de respuesta por módulo: entre 0.18 y 0.65 segundos

---

## 📦 Librerías externas (.jar)

Asegurarse de agregar las siguientes dependencias para el correcto funcionamiento del sistema:

- astra-db-java-1.0.0.jar
- bson-5.5.1.jar
- jackson-core-2.15.2.jar
- jackson-databind-2.15.2.jar
- jackson-annotations-2.15.2.jar
- jackson-datatype-jsr310-2.15.2.jar
- jedis-5.1.3.jar
- mongodb-driver-core-5.5.1.jar
- mongodb-driver-sync-5.5.1.jar
- mysql-connector-j-9.3.0.jar
- postgresql-42.7.7.jar
- retry4j-0.15.0.jar
- RojeruSan.full_9.6.jar
- slf4j-api-2.0.9.jar
- slf4j-simple-2.0.9.jar
  

## ⚙️ Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Joseph623/Sistema-Integrado-de-Gesti-n-Estudiantil.git
