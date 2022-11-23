package util;

public class Couple<T1, T2> {
    private T1 premier;
    private T2 second;

    public Couple(T1 premier, T2 second) {
        this.premier = premier;
        this.second = second;
    }

    public T1 getFirst() {
        return premier;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 premier) {
        this.premier = premier;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public String toString() {
        return "(" + premier + ", " + second + ")";
    }

    public boolean equals(Couple c) {
        //equals prend en compte le type des objets premier et second
        //On a donc pas besoin de le vérifie nous même
        return premier.equals(c.premier) && second.equals(c.second);
    }
}
