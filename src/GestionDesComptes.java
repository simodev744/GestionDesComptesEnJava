import java.util.ArrayList;
import java.util.Scanner;

public class GestionDesComptes {
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();
    public GestionDesComptes(){
        roles.add(new Role("Administrateur"));
        roles.add(new Role("Employé"));
        roles.add(new Role("Client"));
    }

    public void ajouterUtilisateur() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nom: ");
        String nom = sc.nextLine();

        System.out.println("Âge: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Email: ");
        String email = sc.nextLine();

        System.out.println("Mot de passe: ");
        String motDePasse = sc.nextLine();

        System.out.println("Choisir un rôle: ");
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(i + 1 + ". " + roles.get(i).getNomRole());
        }
        int choixRole = sc.nextInt();

        Utilisateur utilisateur = new Utilisateur(nom, age, email, motDePasse, roles.get(choixRole - 1));
        utilisateurs.add(utilisateur);

        System.out.println("Utilisateur ajouté avec succès!");
    }

    public void afficherUtilisateurs() {
        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur);
        }
    }

    public void rechercherUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom de l'utilisateur à rechercher: ");
        String nom = sc.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNom().equalsIgnoreCase(nom)) {
                System.out.println(utilisateur);
                return;
            }
        }
        System.out.println("Utilisateur non trouvé.");
    }

    public void modifierUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom de l'utilisateur à modifier: ");
        String nom = sc.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Modifier Email (actuel: " + utilisateur.getEmail() + "): ");
                String email = sc.nextLine();
                utilisateur.setEmail(email);

                System.out.println("Modifier Mot de passe (actuel: " + utilisateur.getMotDePasse() + "): ");
                String motDePasse = sc.nextLine();
                utilisateur.setMotDePasse(motDePasse);

                System.out.println("Modifier le rôle (actuel: " + utilisateur.getRole().getNomRole() + "): ");
                for (int i = 0; i < roles.size(); i++) {
                    System.out.println(i + 1 + ". " + roles.get(i).getNomRole());
                }
                int choixRole = sc.nextInt();
                utilisateur.setRole(roles.get(choixRole - 1));

                System.out.println("Utilisateur modifié");
                return;
            }
        }
        System.out.println("Utilisateur non trouvé");
    }

    public void supprimerUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom de l'utilisateur à supprimer: ");
        String nom = sc.nextLine();

        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getNom().equalsIgnoreCase(nom)) {
                utilisateurs.remove(i);
                System.out.println("Utilisateur supprimé");
                return;
            }
        }
        System.out.println("Utilisateur non trouvé");
    }

    public static void main(String[] args) {
        GestionDesComptes gestion = new GestionDesComptes();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
                System.out.println("1. Ajouter un utilisateur");
                System.out.println("2. Rechercher un utilisateur");
                System.out.println("3. Modifier un utilisateur");
                System.out.println("4. Supprimer un utilisateur");
                System.out.println("5. Afficher les utilisateurs");
            System.out.println("6. Quitter");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    gestion.ajouterUtilisateur();
                    break;
                case 2:
                    gestion.rechercherUtilisateur();
                    break;
                case 3:
                    gestion.modifierUtilisateur();
                    break;
                case 4:
                    gestion.supprimerUtilisateur();
                    break;
                case 5:
                    gestion.afficherUtilisateurs();
                    break;
                case 6:
                    System.out.println("Au revoir");
                    return;
            }
        }
    }
}