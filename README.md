# tp_Classroom

# Application de gestion d'école en microservices avec Eureka et Spring Cloud Gateway

## Sommaire
- [Présentation](#présentation)
- [Architecture](#architecture)
- [Technologies utilisées](#technologies-utilisées)
- [Démarrage des services](#démarrage-des-services)
- [Configuration de la Gateway](#configuration-de-la-gateway)
- [Liste des microservices et endpoints](#liste-des-microservices-et-endpoints)
    - [Service Gateway](#service-gateway)
    - [Service Étudiant](#service-étudiant)
    - [Service Professeur](#service-professeur)
    - [Service Classe](#service-classe)
- [Exemples de requêtes](#exemples-de-requêtes)
- [Contributeurs](#contributeurs)


---

## Présentation

Cette application est un système de gestion d'école développé en architecture microservices avec Spring Boot.  
Elle permet de gérer les étudiants, professeurs, classes via plusieurs microservices indépendants.  
La découverte de services est assurée par Eureka Server, tandis que Spring Cloud Gateway joue le rôle de point d’entrée unique (API Gateway).

---

## Architecture

- **Eureka Server** : Registre de services pour la découverte dynamique.
- **Spring Cloud Gateway** : Point d’entrée unique, gère le routage vers les microservices.
- **Microservices métiers** :
    - Service Étudiant
    - Service Professeur
    - Service Classe

Chaque microservice s’enregistre automatiquement auprès d’Eureka et communique via des API REST synchrones.

n'oubliez pas que les micro service ont été testé avec une BDD en interne, il vous faudra donc les lier aux votres dans le dossier application.propperties de cette facon :


spring.datasource.url=jdbc:mysql://localhost/VOTRE BDD
spring.datasource.username= #######
spring.datasource.password= #######
spring.jpa.hibernate.ddl-auto=update


---

## Technologies utilisées

- Java 21
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- Maven (gestion de projet)
- Base de données relationnelle pour chaque microservice
- REST API JSON
- Lombok (facilite la gestion des POJOs)

---

## Démarrage des services

Chaque microservice est un projet Spring Boot autonome.  
La séquence recommandée pour démarrer :

1. **Eureka Server**
   ```bash
   cd eurekaserver
   ./mvnw spring-boot:run

2. Gateway
   cd gateway
   ./mvnw spring-boot:run

3. Services métier (Étudiant, Professeur, Classe).
   Démarrer chaque service dans un terminal distinct :

cd service-etudiant
./mvnw spring-boot:run

cd service-professeur
./mvnw spring-boot:run

cd service-classe
./mvnw spring-boot:run


---

## Configuration de la Gateway
La Gateway est configurée pour router les requêtes vers les microservices en fonction du chemin d’URL.
Exemple de routes dans application.yml :
spring:
cloud:
gateway:
routes:
- id: etudiant-service
uri: lb://service-etudiant
predicates:
- Path=/etudiants/**
- id: professeur-service
uri: lb://service-professeur
predicates:
- Path=/professeurs/**
- id: classe-service
uri: lb://service-classe
predicates:
- Path=/classes/**


---

## Liste des microservices et endpoints

---

### Service Gateway

Point d’entrée unique, aucune API métier exposée directement.

---

### Service Etudiant

Méthode
Endpoint
Description
GET
/étudiants
Liste tous les étudiants
GET
/étudiants/{id}
Récupère un étudiant par ID
POST
/etudiants
Crée un nouvel étudiant
DELETE
/etudiants/{id}
Supprime un étudiant

{
"id": 1,
"nom": "Dupont",
"prenom": "Jean",
"dateNaissance": "2000-01-01"
}

---

### Service Professeur

Méthode
Endpoint
Description
GET
/professeurs
Liste tous les professeurs
GET
/professeurs/{id}
Récupère un professeur par ID
POST
/professeurs
Crée un nouveau professeur
PUT
/professeurs/{id}
Met à jour un professeur
DELETE
/professeurs/{id}
Supprime un professeur

{
"id": 1,
"nom": "Martin",
"prenom": "Claire",
"dateNaissance": "1980-05-12"
}


---

### Service Classe

Méthode
Endpoint
Description
GET
/classes
Liste toutes les classes
GET
/classes/{id}
Récupère une classe par ID
POST
/classes
Crée une nouvelle classe
PUT
/classes/{id}
Met à jour une classe
DELETE
/classes/{id}
Supprime une classe


{
"id": 1,
"professeur": {
"id": 2,
"nom": "Martin",
"prenom": "Claire"
},
"etudiants": [
{
"id": 1,
"nom": "Dupont",
"prenom": "Jean"
},
{
"id": 3,
"nom": "Lemoine",
"prenom": "Sophie"
}
]
}


---

Exemples de requêtes (json)
---

### Exemple : Ajouter un étudiant


POST http://localhost:8080/etudiants

{
"nom": "Dupont",
"prenom": "Jean",
"dateNaissance": "2000-01-01"
}

Réponse
{
"id": 1,
"nom": "Dupont",
"prenom": "Jean",
"dateNaissance": "2000-01-01"
}

---

### Exemple : Récupérer la liste des professeurs

GET http://localhost:8080/professeurs
Réponse
[
{
"id": 2,
"nom": "Martin",
"prenom": "Claire",
"dateNaissance": "1980-05-12"
}
]

---

## Contributeurs

Vincent BEAUSSIRE, 
Anthoine FRANCOIS


