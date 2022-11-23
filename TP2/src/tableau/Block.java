package tableau;

import types.Array;
import types.Tableau;

public class Block<T> implements Tableau<T> {
    
    
    private Array<T> tab;
    private int size;
    private int capacity;
    
    public Block(int capacity) {
        assert capacity > 0 : "Cannot create a block with a negative or null capacity";

        //On initialise les valeurs de notre classe.
        this.capacity = capacity;
        this.size = 0;
        this.tab = new Array<T>(capacity);
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean empty() {
        return this.size == 0;
    }
    
    public boolean full() {
        return this.size == this.capacity;
    }
    
    public T get(int i) {
        //L'index du get doit obligatoirement etre compris entre 0 et la taille du tableau.
        //Sinon on recevra une valeur nulle/une erreur
        assert i >= 0 && i < this.size : "Index out of bounds";
        return this.tab.get(i);
    }
    
    public void set(int i, T v) {
        //L'index du set doit obligatoirement etre compris entre 0 et la taille du tableau.
        //On ne peut set qu'une valeur qui existe deja, sinon on utilise push_back
        assert i >= 0 && i < this.size : "Index out of bounds";
        this.tab.set(i, v);
    }
    
    public void push_back(T x) {
        //On ne peut pas ajouter a un tableau plein
        assert size < capacity : "Cannot push_back on a full block";
        //On ajoute la valeur a la fin du tableau
        this.tab.set(size, x);
        //On oublie pas d'augmenter la taille
        this.size++;
    }
    
    public void pop_back() {
        //On ne peut pas enlever a un tableau vide
        assert size > 0 : "Cannot pop an empty block";
        //Pas besoin de supprimer la valeur, en reduisant size on evite de la prendre en compte
        this.size--;
        //Alternativement on pourrais faire tab.set(size, null);
        //ATTENTION: JE PROPOSE DE FAIRE tab.set(size,null) APRES AVOIR FAIT this.size--
        //Rappel: Un tableau de taille 9 aura les valeurs de 0 a 8. Ici on a fais size-- donc
        //size = 8, au quel cas le tab.set(size, null) fonctionne.
        //Si on faisait tab.set(size, null) puis size-- on aurait une erreur (size etant egal a 9)
    }
    
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.size; i++) {
            s += this.tab.get(i) + ", ";
        }
        s += "]";
        return s;
    }
}
