import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GestionDesComptes {
    private ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private ArrayList<Role> roles = new ArrayList<>();

    public GestionDesComptes() {
        roles.add(new Role("Administrateur"));
        roles.add(new Role("Employé"));
        roles.add(new Role("Client"));
    }

    public void ajouterUtilisateur() {
        Scanner sc = new Scanner(System.in);

        String nom;
        do {
            System.out.println("Nom  : ");
            nom = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z]+$", nom)) {
                System.out.println("Nom invalide. Le nom doit contenir uniquement des lettres et des espaces.");
            }
        } while (!Pattern.matches("^[A-Za-z ]+$", nom));

        int age;
        do {
            System.out.println("Age (entre 18 et 120 ans) : ");
            while (!sc.hasNextInt()) {
                System.out.println("Âge invalide. Entrez un nombre.");
                sc.next();
            }
            age = sc.nextInt();
            sc.nextLine();
            if (age < 18 || age > 120) {
                System.out.println("Âge invalide. L'âge doit être compris entre 18 et 120 ans.");
            }
        } while (age < 18 || age > 120);

        String email;
        do {
            System.out.println("Email (format valide requis) : ");
            email = sc.nextLine();
            if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email)) {
                System.out.println("Email invalide. Entrez une adresse email valide.");
            }
        } while (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email));

        String motDePasse;
        do {
            System.out.println("Mot de passe : ");
            motDePasse = sc.nextLine();
            if (!Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", motDePasse)) {
                System.out.println("Mot de passe invalide. Il doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre, et un caractère spécial.");
            }
        } while (!Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", motDePasse));

        System.out.println("Choisir un rôle : ");
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(i + 1 + ". " + roles.get(i).getNomRole());
        }
        int choixRole = sc.nextInt();

        Utilisateur utilisateur = new Utilisateur(nom, age, email, motDePasse, roles.get(choixRole - 1));
        utilisateurs.add(utilisateur);

        System.out.println("Utilisateur ajouté avec succès! Id: " + utilisateur.getId());
    }

    public void afficherUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("Aucun utilisateur n'est enregistré ");
            return;
        }
        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur);
        }
    }

    public void rechercherUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'Id de l'utilisateur à rechercher : ");
        int id = sc.nextInt();

        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                System.out.println(utilisateur);
                return;
            }
        }
        System.out.println("Utilisateur non trouvé.");
    }

    public void modifierUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'Id  de l'utilisateur à modifier : ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() == id) {
                System.out.println("Modifier Email (actuel: " + utilisateur.getEmail() + ") : ");
                String email = sc.nextLine();
                utilisateur.setEmail(email);

                System.out.println("Modifier Mot de passe (actuel: " + utilisateur.getMotDePasse() + ") : ");
                String motDePasse = sc.nextLine();
                utilisateur.setMotDePasse(motDePasse);

                System.out.println("Modifier le role (actuel: " + utilisateur.getRole().getNomRole() + ") : ");
                for (int i = 0; i < roles.size(); i++) {
                    System.out.println(i + 1 + ". " + roles.get(i).getNomRole());
                }

                int choixRole = sc.nextInt();
                utilisateur.setRole(roles.get(choixRole - 1));

                System.out.println("Utilisateur modifié avec succès.");
                return;
            }
        }
        System.out.println("Utilisateur non trouvé.");
    }

    public void supprimerUtilisateur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez l'ID de l'utilisateur à supprimer : ");
        int id = sc.nextInt();

        for (int i = 0; i < utilisateurs.size(); i++) {
            if (utilisateurs.get(i).getId() == id) {
                utilisateurs.remove(i);
                System.out.println("Utilisateur supprimé avec succès.");
                return;
            }
        }
        System.out.println("Utilisateur non trouvé.");
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
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}

