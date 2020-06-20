package a4;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E,P> implements PriorityQueue<E,P> {

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
