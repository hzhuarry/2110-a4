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
		return this.cmp;
	}

	@Override
	public int size() {
		return this.heap.size();
	}

	@Override
	public E poll() throws NoSuchElementException {
		if(size()==0) {
			throw new NoSuchElementException();
		}
		swap(0,size()-1);
		E res=this.heap.remove(size()-1).val;
		this.index.remove(res);
		bubbleDown(0);
		return res;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if(this.size()==0) {
			throw new NoSuchElementException();
		}
		//else
		return this.heap.get(0).val;
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		if(this.index.containsKey(e)) {
			throw new IllegalArgumentException();
		}
		this.heap.add(new Node(e,p));
		this.index.put(e, this.size()-1);
		bubbleUp(this.size()-1);
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		int i= this.index.get(e);
		this.heap.get(i).priority=p;
		bubbleUp(i);
		bubbleDown(i);
		
	}
	
	private int parent(int i) {
		if(i<=0) {
			return -1;
		}
		return (i-1)/2;
	}
	private int left(int i) {
		return 2*i+1;
	}
	private int right(int i) {
		return 2*i+2;
	}
	private boolean hasLeft(int i) {
		return left(i)<size();
	}
	private boolean hasRight(int i) {
		return right(i)<size();
	}
	private void swap(int i,int j) {
		Node eI=this.heap.get(i);
		Node eJ=this.heap.get(j);
		
		this.heap.set(i, eJ);
		this.heap.set(j,eI);
		this.index.put(eI.val, j);
		this.index.put(eJ.val, i);
	}
	private int compare(int i,int j) {
		if(i<0&&j<0)
			return 0;
		if(i<0)
			return 1;
		if(j<0)
			return -1;
		if(i>=size()&&j>=size())
			return 0;
		if(i>=size())
			return -1;
		if(j>=size())
			return 1;
		return cmp.compare(this.heap.get(i).priority, this.heap.get(j).priority);
	}
	
	private void bubbleUp(int i) {
		while(compare(i,parent(i))>0) {
			swap(i,parent(i));
			i=parent(i);
		}
	}
	private void bubbleDown(int i) {
		while(compare(i,left(i))<0&&compare(i,right(i))<0) {
			int k=compare(right(i),left(i))>0?left(i):right(i);
			swap(i,k);
			i=k;
		}
	}
	
	@Override
	public String toString() {
		ArrayList<Node> ans = new ArrayList<>(heap);
		ans.sort(Comparator.naturalOrder());
		return ans.toString();
	}

}
