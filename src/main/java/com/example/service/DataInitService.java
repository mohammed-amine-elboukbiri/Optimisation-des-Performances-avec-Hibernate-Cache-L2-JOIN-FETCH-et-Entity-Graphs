package com.example.service;

import com.example.model.Auteur;
import com.example.model.Categorie;
import com.example.model.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

public class DataInitService {

    private final EntityManagerFactory emf;

    public DataInitService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void initData() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Création des catégories
            Categorie roman = new Categorie("Roman", "Récits littéraires explorant la condition humaine à travers des personnages fictifs");
            Categorie scienceFiction = new Categorie("Science-Fiction", "Univers futuristes et technologies avancées questionnant l'avenir de l'humanité");
            Categorie fantasy = new Categorie("Fantasy", "Mondes féeriques peuplés de créatures magiques et de héros légendaires");
            Categorie policier = new Categorie("Policier", "Intrigues criminelles et enquêtes menées par des détectives ou inspecteurs");
            Categorie biographie = new Categorie("Biographie", "Narration détaillée du parcours et de la vie d'une personnalité réelle");

            em.persist(roman);
            em.persist(scienceFiction);
            em.persist(fantasy);
            em.persist(policier);
            em.persist(biographie);

            // Création des auteurs et de leurs livres
            Auteur auteur1 = new Auteur("Dupont", "Marie", "marie.dupont@example.com");
            Livre livre1 = new Livre("L'Ombre du Temps", 2019, "9782253018765");
            livre1.setResume("Clara, une archéologue, découvre un manuscrit ancien qui bouleverse sa vision du monde.");
            livre1.addCategorie(roman);

            Livre livre2 = new Livre("Les Racines du Silence", 2021, "9782070453122");
            livre2.setResume("Un jeune médecin de campagne tente de percer le mystère entourant la disparition d'un village entier.");
            livre2.addCategorie(roman);

            auteur1.addLivre(livre1);
            auteur1.addLivre(livre2);

            Auteur auteur2 = new Auteur("Martin", "Sophie", "sophie.martin@example.com");
            Livre livre3 = new Livre("Nexus Omega", 2023, "9782070418934");
            livre3.setResume("Une intelligence artificielle consciente tente de comprendre ce qui la différencie de l'être humain.");
            livre3.addCategorie(scienceFiction);

            Livre livre4 = new Livre("Singularité", 2022, "9782290078934");
            livre4.setResume("Dans un monde où les machines ont surpassé l'intelligence humaine, un ingénieur tente de reprendre le contrôle.");
            livre4.addCategorie(scienceFiction);

            auteur2.addLivre(livre3);
            auteur2.addLivre(livre4);

            Auteur auteur3 = new Auteur("Lefebvre", "Thomas", "thomas.lefebvre@example.com");
            Livre livre5 = new Livre("Le Royaume des Cendres", 2020, "9782070634521");
            livre5.setResume("Un jeune elfe banni de son royaume doit forger des alliances improbables pour empêcher l'éveil d'un dieu oublié.");
            livre5.addCategorie(fantasy);

            Livre livre6 = new Livre("Les Chroniques de Valdor", 2018, "9782075198743");
            livre6.setResume("Un modeste fermier se retrouve mêlé à une quête épique pour retrouver une relique sacrée volée par un dragon ancestral.");
            livre6.addCategorie(fantasy);

            auteur3.addLivre(livre5);
            auteur3.addLivre(livre6);

            Auteur auteur4 = new Auteur("Christie", "Agatha", "agatha.christie@example.com");
            for (int i = 1; i <= 20; i++) {
                Livre livre = new Livre("Mystère " + i, 1920 + i, "978020000000" + i);
                livre.setResume("Un mystère à résoudre par Hercule Poirot ou Miss Marple.");
                livre.addCategorie(policier);
                auteur4.addLivre(livre);
            }

            em.persist(auteur1);
            em.persist(auteur2);
            em.persist(auteur3);
            em.persist(auteur4);

            em.getTransaction().commit();
            System.out.println("Données initialisées avec succès !");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Auteur> getAuteurs() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Auteur a", Auteur.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Categorie> getCategories() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
        } finally {
            em.close();
        }
    }
}