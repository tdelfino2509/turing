package turing;

public class Symbol<E> {
	private static class BlankSymbol extends Symbol {
		private BlankSymbol() {
			// singleton
		}

		public Object value() {
			return new Object();
		}

		public boolean equals(Symbol otherSymbol) {
			return this == otherSymbol;
		}

		public String toString() {
			return "BLANK";
		}

		public int hashCode() {
			return 0;
		}
	}

	public static final Symbol BLANK = new BlankSymbol();

	private E value;

	private Symbol() {

	}

	public Symbol(E value) {
		this.value = value;
	}

	public E value() {
		return this.value;
	}

	@Override
	public boolean equals(Object otherSymbol) {
		return this.value.equals(((Symbol<E>) otherSymbol).value());
	}

	public int hashCode() {
		return value.hashCode();
	}

	public String toString() {
		return value.toString();
	}
}
