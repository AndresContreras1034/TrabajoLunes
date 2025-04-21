package co.edu.unipiloto.estdatos.tallerheap.mundo;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {

    private ArrayList<T> elementos;
    private Comparator<T> comparador;

    public Heap(Comparator<T> comparador) {
        this.comparador = comparador;
        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
        subir(elementos.size() - 1);
    }

    public T obtener() {
        return estaVacio() ? null : elementos.get(0);
    }

    public T retirar() {
        if (estaVacio()) return null;

        T raiz = elementos.get(0);
        T ultimo = elementos.remove(elementos.size() - 1);

        if (!estaVacio()) {
            elementos.set(0, ultimo);
            bajar(0);
        }

        return raiz;
    }

    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    public ArrayList<T> aLista() {
        return new ArrayList<>(elementos);
    }

    private void subir(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;
            if (comparador.compare(elementos.get(indice), elementos.get(padre)) < 0) break;
            intercambiar(indice, padre);
            indice = padre;
        }
    }

    private void bajar(int indice) {
        int tam = elementos.size();
        while (true) {
            int izq = 2 * indice + 1;
            int der = 2 * indice + 2;
            int mayor = indice;

            if (izq < tam && comparador.compare(elementos.get(izq), elementos.get(mayor)) > 0)
                mayor = izq;

            if (der < tam && comparador.compare(elementos.get(der), elementos.get(mayor)) > 0)
                mayor = der;

            if (mayor == indice) break;

            intercambiar(indice, mayor);
            indice = mayor;
        }
    }

    private void intercambiar(int i, int j) {
        T tmp = elementos.get(i);
        elementos.set(i, elementos.get(j));
        elementos.set(j, tmp);
    }
}
