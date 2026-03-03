#  Hibernate Performance Optimization

### EhCache • JOIN FETCH • Entity Graph • N+1 Problem

##  Description

Ce repository a pour objectif d'optimiser les performances d'une application
utilisant **Hibernate/JPA** en appliquant plusieurs techniques avancées
:

-   Activation du **cache de second niveau (L2 Cache)** avec **EhCache**
-   Analyse et mesure des performances avant et après optimisation
-   Identification et résolution du problème **N+1**
-   Utilisation de **JOIN FETCH**
-   Utilisation des **Entity Graphs**
-   Comparaison de l'impact des différentes stratégies d'optimisation

------------------------------------------------------------------------

##  Objectifs pédagogiques

✔ Configurer et activer le cache de second niveau dans Hibernate\
✔ Comprendre le fonctionnement du cache L2\
✔ Détecter les requêtes N+1 dans les logs Hibernate\
✔ Optimiser les requêtes avec `JOIN FETCH`\
✔ Utiliser les `EntityGraph` pour contrôler le chargement des relations\
✔ Mesurer et comparer les performances

------------------------------------------------------------------------

##  Technologies utilisées

-   Java
-   Hibernate ORM
-   JPA
-   EhCache
-   Maven 
-   Base de données (MySQL)

------------------------------------------------------------------------

## 🔥 Problèmes traités

### 1️⃣ Problème N+1

Le problème N+1 survient lorsqu'une requête principale déclenche
plusieurs requêtes supplémentaires pour charger des relations.

**Solution utilisée :**

``` java
SELECT e FROM Employe e JOIN FETCH e.projets;
```

------------------------------------------------------------------------

### 2️⃣ Cache de second niveau (L2 Cache)

Activation du cache Hibernate avec EhCache pour réduire : - Le nombre de
requêtes SQL - Le temps de réponse - La charge sur la base de données

Configuration via : - `hibernate.cfg.xml` - `ehcache.xml` - Annotations
`@Cacheable` et `@Cache`

------------------------------------------------------------------------

### 3️⃣ Entity Graph

Utilisation des Entity Graphs pour contrôler dynamiquement le chargement
des associations sans modifier les requêtes JPQL.

Exemple :

``` java
@EntityGraph(attributePaths = {"projets"})
List<Employe> findAll();
```

------------------------------------------------------------------------

## Video du Resultat




    