package prog2.model;

public class Client implements InClient {

    private String nom, dni;

    /**
     * Constructor de client
     * @param nom_
     * @param dni_
     */
    public Client(String nom_, String dni_){
        this.nom = nom_;
        this.dni = dni_;
    }

    /**
     *Getters
     */
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDni() {
        return dni;
    }

    /**
     *Setters
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Retorna un string de l'informació del client
     * @return retorna el nom del client amb el seu dni
     */
    @Override
    public String toString(){
        return nom + " amb DNI: " + dni +". ";
    }
}
