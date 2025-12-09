public class Participante {
    private int matricula;
    private String categoria;
    private int edad;

    public Participante(int matricula, String categoria, int edad) {
        this.matricula = matricula;
        this.categoria = categoria;
        this.edad = edad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
