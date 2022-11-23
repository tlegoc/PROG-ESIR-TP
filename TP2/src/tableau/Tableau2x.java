package tableau;

import types.Tableau;

public class Tableau2x<T> implements Tableau<T> {
    //Tableau2x est un tableau qui double sa taille quand il est plein

    private T[] tab;
    private int size;
    private int capacity;

    public Tableau2x(int capacity) {
        assert capacity > 0 : "Cannot create a block with a negative or null capacity";

        //On initialise les valeurs de notre classe.
        this.capacity = capacity;
        this.size = 0;
        this.tab = (T[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public boolean full() {
        //Le tableau n'est jamais cense etre plein, on renvoie toujours faux
        return false;
    }

    public T get(int i) {
        //L'index du get doit obligatoirement etre compris entre 0 et la taille du tableau.
        //Sinon on recevra une valeur nulle/une erreur
        assert i >= 0 && i < this.size : "Index out of bounds";
        return this.tab[i];
    }

    public void set(int i, T v) {
        //L'index du set doit obligatoirement etre compris entre 0 et la taille du tableau.
        //On ne peut set qu'une valeur qui existe deja
        assert i >= 0 && i < this.size : "Index out of bounds";
        this.tab[i] = v;
    }

    public void push_back(T x) {
        //On ajoute notre valeur a la fin du tableau
        this.tab[this.size] = x;
        this.size++;

        //En augmentant la taille du tableau a la fin de chaque push_back, on s'assure
        //Qu'il y a toujours de la place quoi qu'il arrive
        //On pourrais faire la verification avant d'ajouter la valeur, ca marche aussi

        //Si le tableau est plein, on double sa taille
        //On ne peut pas utiliser full() car ce tableau n'est jamais cense etre plein, on
        //Utilise donc les variables internes pour savoir si c'est le cas, si oui on augmente
        if (this.size == this.capacity) {
            //On augmente la taille
            this.capacity *= 2;
            //On cree un nouveau tableau de la bonne taille
            T[] newTab = (T[]) new Object[this.capacity];

            //On copie les valeurs de l'ancien tableau dans le nouveau
            for (int i = 0; i < this.size; i++) {
                newTab[i] = this.tab[i];
            }

            //On remplace
            this.tab = newTab;
        }
    }

    public void pop_back() {
        //On ne peut pas enlever a un tableau vide
        assert size > 0 : "Cannot pop an empty array";
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
            s += this.tab[i];
            if (i != this.size - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
