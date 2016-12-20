package turing;

import java.util.HashMap;

public class State<E> extends HashMap<Symbol<E>, Triple> {
	private static final long serialVersionUID = -244803072555594059L;

	private static class FinalState extends State<Object> {
		private static final long serialVersionUID = 6946878049943964342L;

		@Override
		public void enter(Cell<Object> cell) {
			return;
		}
	}

	public static State FINAL = new FinalState();

	public void enter(Cell<E> cell) {
		 System.out.print(this + "\t" + cell.symbol() + "\t");
		this.get(cell.symbol()).execute(cell);
	}
}
