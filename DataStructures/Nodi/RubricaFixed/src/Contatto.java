public class Contatto {
    public String cognome;
    public String nome;
    public String telefono;
    public String email;

    public Contatto(String cog, String nom, String tel, String mail) {
        this.cognome = cog;
        this.nome = nom;
        this.telefono = tel;
        this.email = mail;
    }

    public String getChiaveOrdinamento() {
        return (this.cognome.toLowerCase() + this.nome.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s | Tel: %-15s | Email: %s",
                cognome, nome, telefono, email);
    }
}