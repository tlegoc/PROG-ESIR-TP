package tableau;

import types.Tableau;

public class TableauBlock<T> implements Tableau<T>{
	private Tableau2x<Block<T>> tab;
	private int blockCapacity;
	
	
	public TableauBlock(int capacityTab, int capacityBlock) {
		this.tab = new Tableau2x<Block<T>>(capacityTab);
		this.blockCapacity = capacityBlock;
	}
	
	public TableauBlock(int capacityTab) {
		this(capacityTab, 128);
	}
	@Override
	public int size() {
		if(tab.empty()) return 0;
		return ((tab.size()-1)*blockCapacity)+ getLastBlock().size();
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
		return ((Block<T>)tab.get(i/blockCapacity)).get(i%blockCapacity);
	}

	@Override
	public void set(int i, T v) {
		((Block<T>)tab.get(i/blockCapacity)).set(i%blockCapacity, v);
	}

	@Override
	public void push_back(T x) {
		if(tab.empty() || getLastBlock().full()) {
			Block<T> nBlock = new Block<T>(blockCapacity);
			nBlock.push_back(x);
			tab.push_back(nBlock);
		}else {
			getLastBlock().push_back(x);
		}
	}

	@Override
	public void pop_back() {
		if(getLastBlock().size()==1) {
			tab.pop_back();
		}else {
			getLastBlock().pop_back();
		}
	}
	
	private Block<T> getLastBlock(){
		return ((Block<T>) tab.get(tab.size()-1));
	}

}
