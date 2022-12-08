package src;
public interface Renter<T extends Rentable<T>> {
    /**
     * Recoit un Rentable
     * @param rentable le Rentable a ajoute
     */
    public void drop(T rentable);

    /**
     * Loue une Rentable
     * @return Une instance de Rentable
     */
    public T rent();
}
