<h1 align="center">LiterAlura Challenge</h1>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-22+-blue.svg">
  <img alt="Maven" src="https://img.shields.io/badge/Maven-3.0-blue.svg">
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-3.3.0-brightgreen.svg">
  <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-16.3-blue.svg">
  <img alt="Status do Projeto" src="https://img.shields.io/badge/status-Concluded-green">
</p>

<p align="justify">This project was a challenge proposed by the Oracle team in partnership with Alura. It works like a library, you can add new books, search for the ones you already have, look up the authors of the books you have and more.</p>

## How to Clone Properly
Before you can run the project you'll need the following technologies and dependencies:
  - [Java 22](https://www.java.com/pt-BR/download/) at least;
  - [Spring Boot](https://start.spring.io/);
  - JPA (Java Persistence API);
  - Jackson (for deserialization of JSON);
  - [Database (PostgreSQL)](https://www.postgresql.org/download/);
  - [Maven](https://maven.apache.org/download.cgi);
    
Clone the repository
    
  ```bash
  git clone git@github.com:dyonneEberty/literAlura_Java.git
  ```

Configure the PostgreSQL database:
   - Create a database named "literalura"
   - In the file application.properties, `src/main/resources/application.properties`, you'll find [environment variables](https://vercel.com/docs/projects/environment-variables). You can either add those to your pc, setting your own information, or replace them with your info directly (I don't recomend this option if you want to post your project after finished because it will leak your infos but if you only wanna have fun it's much simpler). 

## Features
  - Add a book to the library
  - Show list of books registered
  - Show list of authors registered
  - Show list of authors that were/are alive in ... year
  - Show list of books in ... language

## Your Turn
Here I'll add some other features that have been suggested by the Alura team. If you want to test your Java skills, go ahead and try to implement them.
- Top 10 most downloaded books;
- Search author by name;
- List authors with other queries, such as date of birth, date of death, you choose;

## Demo

-

## Badge
Badge that indicates that I have finished the challenge.

![badge literalura]()
