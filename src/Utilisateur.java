public class Utilisateur extends Personne {
    private static int compteurId = 1;
    private int id;
    private String email;
    private String motDePasse;
    private Role role;

    public Utilisateur(String nom, int age, String email, String motDePasse, Role role) {
        super(nom, age);
        this.id = compteurId++;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + getNom() + ", Âge: " + getAge() + ", Email: " + email + ", Rôle: " + role.getNomRole();
    }
}
