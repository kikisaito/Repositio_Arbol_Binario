public class Nodo {
    private Participante dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(Participante dato) {
        this.dato = dato;
    }

    public Nodo() { }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public Participante getDato() {
        return dato;
    }

    public void setDato(Participante dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo nodo) {
        this.izq = nodo;
    }

    public void setDer(Nodo nodo) {
        this.der = nodo;
    }
}
