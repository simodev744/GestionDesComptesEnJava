public class Utilisateur extends Personne {
    private String email;
    private String motDePasse;
    private Role role;

    public Utilisateur(String nom, int age, String email, String motDePasse, Role role) {
        super(nom, age);
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
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
        return "Nom: " + getNom() + ", Âge: " + getAge() + ", Email: " + email + ", Rôle: " + role.getNomRole();
    }

}