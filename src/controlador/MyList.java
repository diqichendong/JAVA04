/*
 * Clase MyList
 */
package controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int counter;
    private Node<E> actualNode;

    public MyList() {
        this.firstNode = null;
        this.lastNode = null;
        this.counter = 0;
    }

    public void showMyList() {
        Node<E> temporary = this.firstNode;
        while (temporary != null) {
            System.out.println(temporary.getMain());
            temporary = temporary.getNextNode();
        }
    }

    /**
     * Añadir un nuevo nodo a la lista
     *
     * @param p Objeto a añadir
     */
    public void add(E p) {
        Node<E> newNode = new Node(p);
        if (this.firstNode == null) {
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.actualNode = newNode;
        } else {
            newNode.setPrevNode(this.lastNode);
            this.lastNode.setNextNode(newNode);
            this.lastNode = newNode;
        }
        this.counter++;
    }

    /**
     * Eliminar un nodo de la lista
     *
     * @param target Nodo a eliminar
     */
    public void delete(Node<E> target) {
        Node<E> aux = this.firstNode;

        while (aux != target) {
            aux = aux.getNextNode();
        }

        if (!aux.isFirstNode() && counter >= 1) {
            aux.getPrevNode().setNextNode(aux.getNextNode());
        } else {
            firstNode = aux.getNextNode();
        }

        if (!aux.isLastNode() && counter >= 1) {
            aux.getNextNode().setPrevNode(aux.getPrevNode());
        } else {
            lastNode = aux.getPrevNode();
        }

        counter--;
    }

    /**
     * Obtener el contenido de un nodo
     *
     * @param number Número del nodo
     * @return Contenido del nodo
     */
    public E get(int number) {
        Node<E> aux = this.firstNode;

        while (aux.getIndex() != number) {
            aux = aux.getNextNode();
        }

        return aux.getMain();
    }

    /**
     * Obtener el contenido de un nodo
     *
     * @param number Número del nodo
     * @return Contenido del nodo
     */
    public Node<E> getNode(int number) {
        Node<E> aux = this.firstNode;

        while (aux.getIndex() != number) {
            aux = aux.getNextNode();
        }

        return aux;
    }

    /**
     * Obtener el nodo actual de la lista
     *
     * @return Nodo actual
     */
    public Node<E> getActualNode() {
        return actualNode;
    }
    
    public void setActualNode(Node n) {
        this.actualNode = n;
    }

    /**
     * Pasar al siguiente nodo
     */
    public void next() {
        this.actualNode = this.actualNode.getNextNode();
    }

    /**
     * Volver al anterior nodo
     */
    public void prev() {
        this.actualNode = this.actualNode.getPrevNode();
    }

    public int getCouter() {
        return this.counter;
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }
    
    public Node<E> getLastNode() {
        return lastNode;
    }

    /**
     * Comprueba si existe un nodo por su indice
     *
     * @param index Índice del nodo que queremos buscar
     * @return true si existe, false si no.
     */
    public boolean existe(int index) {
        boolean res = false;
        Node aux = this.firstNode;

        while (aux != null) {
            if (aux.getIndex() == index) {
                res = true;
                break;
            }
            aux = aux.getNextNode();
        }

        return res;
    }

    /**
     * Intecambiar dos nodos
     *
     * @param n1 Nodo a intercambiar
     * @param n2 Nodo a intercambiar
     */
    public void intercambiar(Node n1, Node n2) {
        E aux = (E) n1.getMain();
        int aux2 = n1.getIndex();

        n1.setMain(n2.getMain());
        n1.setIndex(n2.getIndex());
        n2.setMain(aux);
        n2.setIndex(aux2);
    }

    /**
     * Ordena la lista ascendentemente por el índice de los nodos
     */
    public void sort() {
        int n = this.counter;
        boolean cambiado;
        do {
            cambiado = false;
            Node a = this.firstNode;
            Node b = a.getNextNode();

            for (int i = 1; i < n; i++) {
                if (a.getIndex() > b.getIndex()) {
                    intercambiar(a, b);

                    cambiado = true;
                }

                a = a.getNextNode();
                b = b.getNextNode();
            }
            n--;
        } while (cambiado);
    }

    /**
     * Guarda los objetos de que contienen los nodos en un fichero
     *
     * @param directory Directorio de guardado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void save(File directory) throws FileNotFoundException, IOException {
        String path = directory.getAbsolutePath();
        System.out.println(path);
        FileOutputStream fos = new FileOutputStream(path + "/empleados.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Node aux = this.firstNode;

        while (aux != null) {
            oos.writeObject(aux.getMain());
            aux = aux.getNextNode();
        }

        oos.flush();
        oos.close();
        fos.close();
    }

    /**
     * Cargar empleados de un fichero
     * @param file fichero
     * @return Lista de los empleados leidos
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public List<E> load(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        List<E> res = new ArrayList<E>();
        
        FileInputStream fis = new FileInputStream(new File(file.getAbsolutePath()));
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                res.add((E) ois.readObject());
            }
        } catch (EOFException ex) {}

        ois.close();
        fis.close();
        
        return res;
    }
    
    /**
     * Obtener una Collection List de la lista
     * @return 
     */
    public List<E> getList() {
        List<E> res = new ArrayList();
        Node aux = this.getFirstNode();
        
        while(aux != null) {
            res.add((E)aux.getMain());
            aux = aux.getNextNode();
        }
        
        return res;
    }

    // Inner class
    public class Node<E> {

        private Node<E> nextNode;
        private Node<E> prevNode;
        private E main;
        private int index;

        public Node(E p) {
            this.nextNode = null;
            this.prevNode = null;
            this.main = p;
        }

        public Node<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getPrevNode() {
            return this.prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }

        public E getMain() {
            return main;
        }

        public void setMain(E p) {
            this.main = p;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * Indica si el nodo actual es el primer nodo
         *
         * @return true si es el primer nodo, false si no
         */
        public boolean isFirstNode() {
            return firstNode == this;
        }

        /**
         * Indica si el nodo actual es el último nodo
         *
         * @return true si es el último nodo, false si no
         */
        public boolean isLastNode() {
            return lastNode == this;
        }
    }
}
