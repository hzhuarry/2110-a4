package a4;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Heap<E,P> implements PriorityQueue<E,P> {
	
	private Comparator<? super P> cmp;
	
	private class Node implements Comparable<Node>{
		E val;
		P priority;
		public Node(E v,P p) {
			this.val=v;
			this.priority=p;
		}
		@Override
		public int compareTo(Heap<E, P>.Node o) {
			return cmp.compare(this.priority,o.priority);
		}
		public String toString() {
			return val+" ("+priority+")";
		}
	}
	private ArrayList<Node> heap;
	
	//heap[index[o]].val.equals(0)
	private HashMap<E,Integer> index;
	
	public Heap(Comparator<P> c) {
		this.cmp=c;
		this.heap=new ArrayList<Node>();
		this.index=new HashMap<E,Integer>();
	}
	
	@Override
	public Comparator<? super P> comparator() {
		throw new NotImplementedError();
	}

	@Override
	public int size() {
		throw new NotImplementedError();
	}

	@Override
	public E poll() throws NoSuchElementException {
		throw new NotImplementedError();
	}

	@Override
	public E peek() throws NoSuchElementException {
		throw new NotImplementedError();
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		throw new NotImplementedError();
		
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		throw new NotImplementedError();
		
	}

}
