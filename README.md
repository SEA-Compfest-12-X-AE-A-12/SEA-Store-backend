# SEA-Store-backend

## API Documentation
1. Run Application
2. Visit URL `/swagger-ui.html`

## Run All Compile and Unit Tests
1. Run `mvn clean test`

## Trello:
https://trello.com/invite/b/GTMA2kHG/3bed0222c3450ff616cbd3d33814918e/x-%C3%A6-a-12-sea-store

## Technology Stack:
* Frontend: 
    * React
* Database: 
    * PostgreSQL
* Backend: 
    * Java Spring Boot
* CICD:
    * Github Actions: Maven, Code Formatter
    * Setup: Github
* Deployment:
   * Frontend: Netlify 
   * Backend: Heroku
* API Documentation:
   * Swagger: https://xaea12-backend.herokuapp.com/swagger-ui.html


## Clean Architecture:
### Overview:
	* usecase
	* delivery
	* repository
	* entity
	* config

### Detail:
```sh
├───.github
│   └───workflows
├───.idea
│   └───libraries
├───.mvn
│   └───wrapper
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───compfest
│   │   │           └───sea
│   │   │               ├───config
│   │   │               │   ├───security
│   │   │               │   │   └───jwt
│   │   │               │   └───swagger
│   │   │               ├───delivery
│   │   │               │   ├───category
│   │   │               │   ├───merchant
│   │   │               │   ├───product
│   │   │               │   ├───proposal
│   │   │               │   └───user
│   │   │               ├───entity
│   │   │               │   ├───category
│   │   │               │   ├───merchant
│   │   │               │   │   ├───model
│   │   │               │   │   └───payload
│   │   │               │   ├───product
│   │   │               │   │   ├───model
│   │   │               │   │   └───payload
│   │   │               │   ├───proposal
│   │   │               │   │   ├───model
│   │   │               │   │   └───payload
│   │   │               │   └───user
│   │   │               │       ├───model
│   │   │               │       └───payload
│   │   │               ├───exception
│   │   │               ├───repository
│   │   │               │   ├───merchant
│   │   │               │   ├───product
│   │   │               │   ├───proposal
│   │   │               │   └───user
│   │   │               └───usecase
│   │   │                   ├───category
│   │   │                   ├───merchant
│   │   │                   ├───product
│   │   │                   ├───proposal
│   │   │                   └───user
│   │   └───resources
│   └───test
│       └───java
│           └───com
│               └───compfest
│                   └───sea
│                       └───usecase
│                           ├───product
│                           └───user
```
## Design pattern:
* Strategy Pattern: 
	* Memungkinkan implementasi yang berbeda, misalnya untuk UserDAO bisa menggunakan DB ataupun ArrayList
	* ada nya interface untuk fleksibilitas implementasi pada usecase, repository, delivery
* Adapter Pattern: Melakukan konversi payload API menjadi model
* Facade Pattern: Dengan Frontend menaggil API Backend maka tidak perlu implement logic tersendiri.


## ERD:
https://app.diagrams.net/#G1IgjAsZHqagA8ys0IG7MbAC27fgLjANMK
