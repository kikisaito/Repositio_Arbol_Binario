public class ArbolBinario {
    Nodo raiz = new Nodo();

    private static class Estadisticas {
        int totalParticipantes = 0;
        int sumaEdades = 0;
        int principiantes = 0;
        int intermedios = 0;
        int avanzados = 0;
    }

    public void setRaiz(Participante valor) {
        if (raiz.getDato() == null)
            raiz.setDato(valor);
        else
            System.out.println("La raíz ya está definida.");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean validarRaiz() {
        return raiz.getDato() != null;
    }


    public void preorden(Nodo raiz) {
        if (raiz != null) {
            Participante p = raiz.getDato();
            System.out.println("Matrícula: " + p.getMatricula()
                    + " | Categoría: " + p.getCategoria()
                    + " | Edad: " + p.getEdad());
            preorden(raiz.getIzq());
            preorden(raiz.getDer());
        }
    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            Participante p = raiz.getDato();
            System.out.println("Matrícula: " + p.getMatricula()
                    + " | Categoría: " + p.getCategoria()
                    + " | Edad: " + p.getEdad());
            inorden(raiz.getDer());
        }
    }

    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.getIzq());
            postorden(raiz.getDer());
            Participante p = raiz.getDato();
            System.out.println("Matrícula: " + p.getMatricula()
                    + " | Categoría: " + p.getCategoria()
                    + " | Edad: " + p.getEdad());
        }
    }

    public void visualizarRecorridos() {
        if (!validarRaiz()) {
            System.out.println("No hay participantes registrados.");
            return;
        }
        System.out.println("Recorrido Preorden:");
        preorden(raiz);
        System.out.println("\nRecorrido Inorden:");
        inorden(raiz);
        System.out.println("\nRecorrido Postorden:");
        postorden(raiz);
    }

    // ===== Método específico para mostrar solo matrícula + categoría =====
    public void visualizarParticipantes() {
        if (!validarRaiz()) {
            System.out.println("No hay participantes registrados.");
            return;
        }
        System.out.println("Listado de participantes (Inorden):");
        visualizarParticipantesInorden(raiz);
    }

    private void visualizarParticipantesInorden(Nodo raiz) {
        if (raiz != null) {
            visualizarParticipantesInorden(raiz.getIzq());
            Participante p = raiz.getDato();
            System.out.println("Matrícula: " + p.getMatricula()
                    + " | Categoría: " + p.getCategoria());
            visualizarParticipantesInorden(raiz.getDer());
        }
    }

    // ===== Inserción en el árbol, ordenado por matrícula =====
    public void insertarNodo(Nodo raiz, Participante objNuevo) {
        if (validarRaiz()) {
            if (objNuevo.getMatricula() < raiz.getDato().getMatricula()) {
                if (raiz.getIzq() == null) {
                    Nodo nodoNuevo = new Nodo(objNuevo);
                    raiz.setIzq(nodoNuevo);
                } else {
                    insertarNodo(raiz.getIzq(), objNuevo);
                }
            } else if (objNuevo.getMatricula() > raiz.getDato().getMatricula()) {
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(objNuevo);
                    raiz.setDer(nodoNuevo);
                } else {
                    insertarNodo(raiz.getDer(), objNuevo);
                }
            } else {
                System.out.println("Ya existe un participante con la matrícula " + objNuevo.getMatricula());
            }
        } else {
            System.out.println("Primero debes definir la raíz.");
        }
    }

    // ===== Búsqueda por matrícula (opcional, pero basado en el ejemplo) =====
    public void busqueda(Nodo raiz, int valorBuscado) {
        if (raiz == null) {
            System.out.println("No encontrado.");
            return;
        }

        if (valorBuscado < raiz.getDato().getMatricula()) {
            if (raiz.getIzq() == null) {
                System.out.println("No encontrado.");
            } else {
                busqueda(raiz.getIzq(), valorBuscado);
            }
        } else if (valorBuscado > raiz.getDato().getMatricula()) {
            if (raiz.getDer() == null) {
                System.out.println("No encontrado.");
            } else {
                busqueda(raiz.getDer(), valorBuscado);
            }
        } else {
            Participante p = raiz.getDato();
            System.out.println("Participante encontrado: Matrícula " + p.getMatricula()
                    + " | Categoría: " + p.getCategoria()
                    + " | Edad: " + p.getEdad());
        }
    }

    // ===== Estadísticas =====
    public void mostrarEstadisticas() {
        if (!validarRaiz()) {
            System.out.println("No hay participantes registrados.");
            return;
        }

        Estadisticas est = new Estadisticas();
        calcularEstadisticas(raiz, est);

        System.out.println("=== Estadísticas del concurso ===");
        System.out.println("Total de participantes: " + est.totalParticipantes);

        if (est.totalParticipantes > 0) {
            double promedio = (double) est.sumaEdades / est.totalParticipantes;
            System.out.printf("Promedio de edades: %.2f\n", promedio);
        }

        System.out.println("Participantes por categoría:");
        System.out.println(" - Principiante: " + est.principiantes);
        System.out.println(" - Intermedio: " + est.intermedios);
        System.out.println(" - Avanzado: " + est.avanzados);
    }

    private void calcularEstadisticas(Nodo raiz, Estadisticas est) {
        if (raiz != null) {
            calcularEstadisticas(raiz.getIzq(), est);

            Participante p = raiz.getDato();
            est.totalParticipantes++;
            est.sumaEdades += p.getEdad();

            String cat = p.getCategoria().toLowerCase();
            if (cat.equals("principiante")) {
                est.principiantes++;
            } else if (cat.equals("intermedio")) {
                est.intermedios++;
            } else if (cat.equals("avanzado")) {
                est.avanzados++;
            }

            calcularEstadisticas(raiz.getDer(), est);
        }
    }
}
