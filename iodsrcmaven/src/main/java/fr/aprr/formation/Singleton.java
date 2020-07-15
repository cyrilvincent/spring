package fr.aprr.formation;

public class Singleton {

    private static Singleton instance = null;

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton(); // Lent
        }
        return instance;
    }

    private Singleton() {
        // LENT
        // Plutôt en lecture
        // Typiquement de charger un fichier de configuration
    }
}
