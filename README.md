# Projet docker

---

### Projet par JUILIEN Arnaud et BURY Antoine

---

### Le projet

Ce projet à pour but de stocker des chaines de caractères ainsi que la même chaine signée via l'algorithme **Sha256**.

Pour ce faire, nous avons développé une **API RESTful** avec le framework **SpringBoot** connecté à une base de donnée **Redis**.
L'application devait cependant pourvoir tourner uniquement via un contenaire **Docker** avec un stockage persistent entre ces derniers.

---

### Utilisation de l'application

#### Docker

Vous pouvez instancier et lancer un contenaire Docker en lançant la commande `docker compose build` suivi de `docker compose up` dans le repertoire du repository.

Suite à cela vous aurez accès à l'API via le port 8085.

#### Swagger

Un swagger est mis à disposition pour avoir une documentation en ligne. Pour y acceder lancer le contenaire puis aller à l'adresse http://localhost:8085/swagger-ui.html.

Vous aurez la possibilité de tester les requêtes en cliquant sur une des sections puis sur **Try it out** en haut à droite.

#### Test requête Post

Cliquez sur la section **POST** puis **Try it out**.
Dans le **request body** entrez un **id** valide/libre puis une chaine de caractère.
Cliquez sur **Execute** et plus bas vous aurez la requête **curl**, le code html de la réponse et finalement le **response body** qui contiendra votre chaine et la même chaine signée correspondant à l'entitée dans redis.

#### Test requête Post

Cliquez sur la section **GET** puis **Try it out**.
Dans la section **Parameters** entrez un **id** valide (par exemple l'id utilisé précédement).
Cliquez sur **Execute** et plus bas vous aurez la requête **curl**, le code html de la réponse et finalement le **response body** qui contiendra votre chaine et la même chaine signée correspondant à l'entitée dans redis.
