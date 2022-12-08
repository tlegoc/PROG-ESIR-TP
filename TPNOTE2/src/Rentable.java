package src;
public interface Rentable<T extends Rentable<T>> {
	/**
	 * @return un string unique qui identifie le Rentable
	 */
	public String getId();
}
