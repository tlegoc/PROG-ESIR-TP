package tableau;

import types.Tableau;

public class Block<T> implements Tableau<T>{
	private types.Array<T> array;
	private int size;
	
	public Block(int capacity) {
		assert capacity > 0;
		this.array = new types.Array<T>(capacity);
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return size()==0;
	}

	@Override
	public boolean full() {
		return size()==array.length();
	}

	@Override
	public T get(int i) {
		assert 0<=i && i < size();
		return array.get(i);
	}

	@Override
	public void set(int i, T v) {
		assert 0<=i && i < size();
		array.set(i, (T) v);
	}

	@Override
	public void push_back(T x) {
		assert !full();
		array.set(size(), (T) x);
		this.size += 1;
	}

	@Override
	public void pop_back() {
		assert !empty();
		this.size -= 1;
	}
	
	public String toString() {
		String s = "[ ";
		for(int i=0; i<size(); i++) {
			s+=this.get(i).toString()+" ";
		}
		return s+"]";
	}

}
