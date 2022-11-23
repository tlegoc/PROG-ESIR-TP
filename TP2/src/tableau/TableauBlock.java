package tableau;

import types.Tableau;

public class TableauBlock<T> implements Tableau<T> {
    //TableauBlock est un tableau qui est compose de plusieurs blocks de taille fixe


    /*
     * PETIT MEMO
     * 
     * size/blockCapacity + 1 = nombre de blocks utilise
     * size/blockCapacity = index du dernier block
     * size%blockCapacity = index de la derniere case 
     * 
     * capacity/blockCapacity + 1 = nombre de blocks
     * 
     * si i est l'index d'un element
     * i/blockCapacity = index du block dans lequel se trouve l'element
     * i%blockCapacity = index de l'element dans le block
     */

    private Block<T>[] tab;
    //Nombre d'elements
    private int size;
    //Taille max actuelle
    private int capacity;
    //Taille max d'un block
    private int blockCapacity;

    public TableauBlock(int capacity, int blockCapacity) {
        assert capacity > 0 : "Cannot create a block with a negative or null capacity";
        assert blockCapacity > 0 : "Cannot create a block with a negative or null capacity";

        //On initialise les valeurs de notre classe.
        this.capacity = capacity;
        this.size = 0;
        this.blockCapacity = blockCapacity;
        //On cree notre tableau de blocks
        //Attention: On ne peut pas faire new Block<T>[capacity] car on ne peut pas instancier un tableau de type generique (cherchez pas)
        //Du coup je cree un tableau block sans type et je fais un cast en Block<T>[]
        //Un cast c'est le truc en parenthese, exemple, si je fais (int) 3.13 ca transforme un flottant (3.13 ici) en int (donc 3)
        //LES CASTS NE MARCHENT PAS TOUJOURS, utilisez les que si vous etes sur que la conversion est possible
        //Exemple: (int) Block[2] va TOUJOURS crasher
        this.tab = (Block<T>[]) new Block[capacity/blockCapacity + 1];

        //On initialise les blocks, creer un tableau ne suffit pas
        for (int i = 0; i < this.tab.length; i++) {
            this.tab[i] = new Block<T>(blockCapacity);
        }
    }

    public TableauBlock(int capacity) {
        this(capacity, 128);
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
        //i/blockCapacity donne le block dans lequel se trouve l'element
        //i%blockCapacity donne l'index dans le block
        //Example, j'ai un blockCapacity de 10 et je veux le 15eme element
        //15/10 = 1 donc je vais chercher dans le block 1
        //15%10 = 5 donc je vais chercher l'element 5 dans le block 1
        return this.tab[i/blockCapacity].get(i%blockCapacity);
    }

    public void set(int i, T v) {
        //L'index du set doit obligatoirement etre compris entre 0 et la taille du tableau.
        //On ne peut set qu'une valeur qui existe deja
        assert i >= 0 && i < this.size : "Index out of bounds";
        //cf get
        this.tab[i/blockCapacity].set(i%blockCapacity, v);
    }

    public void push_back(T x) {
        //Si le dernier tableau est plein, on ajoute un block
        if (tab[capacity/blockCapacity].full()) {
            //On augmente la capacite
            capacity += blockCapacity;
            //de meme que i/blockCapacity donne le block dans lequel se trouve l'element
            //capacity/blockCapacity + 1 donne le nombre de blocks
            //Le plus un est important, exemple j'ai un blockCapacity de 10 et une capacite de 8,
            //8/10 = 0, on ne peux pas creer zero blocks
            Block<T>[] newTab = (Block<T>[]) new Block[capacity/blockCapacity + 1];

            //On copie les valeurs de l'ancien tableau dans le nouveau
            for (int i = 0; i < this.tab.length; i++) {
                newTab[i] = this.tab[i];
            }
            this.tab = newTab;

            //On initialise un nouveau block a la fin du tableau
            this.tab[capacity/blockCapacity] = new Block<T>(blockCapacity);
        }

        //On ajoute une valeur a la fin du tableau
        tab[size/blockCapacity].push_back(x);
        size++;
    }

    public void pop_back() {
        //On ne peut pas enlever a un tableau vide
        assert size > 0 : "Cannot pop an empty array";
        //On reduis la taille
        this.size--;
        //On precise au dernier block UTILISE qu'il a une valeur en moins
        this.tab[size/blockCapacity].pop_back();
    } 

    //toString  
    public String toString() {
        String s = "[";
        for (int i = 0; i < this.size; i++) {
            s += this.get(i);
            if (i != this.size - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
