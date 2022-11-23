package tableau;

import types.Tableau;

public class Tableau2x<T> implements Tableau<T> {
	private Block<T> tab;
	
	public Tableau2x(int capacity) {
		this.tab = new Block<T>(capacity);
	}

	@Override
	public int size() {
		return tab.size();
	}

	@Override
	public boolean empty() {
		return tab.empty();
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public T get(int i) {
		return tab.get(i);
	}

	@Override
	public void set(int i, T v) {
		tab.set(i, v);
	}

	@Override
	public void push_back(T x) {
		if(tab.full()) {
			Block<T> newTab = new Block<>(tab.size()*2);
			for(int i=0; i<tab.size(); i++) {
				newTab.push_back(tab.get(i));
			}
			tab = newTab;
		}
		tab.push_back(x);
	}

	@Override
	public void pop_back() {
		tab.pop_back();
	}
	
	public String toString() {
		String s = "[ ";
		for(int i=0; i<size(); i++) {
			s+=this.get(i).toString()+" ";
		}
		return s+"]";
	}


}
