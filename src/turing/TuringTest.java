package turing;

public class TuringTest {

	public static void main(String args[]) {
		Cell<Integer> startCell = new Cell(Symbol.BLANK);

		writeOnes(startCell, 3);
		System.out.println("Initial tape:");
		printTape(startCell);
		System.out.println("Execution...");
		multiply(startCell);
		System.out.println("Final tape:");
		printTape(startCell);
	}

	public static void add() {

	}

	public static Symbol<Integer> symbol(int n) {
		return new Symbol<Integer>(n);
	}

	public static void multiply(Cell<Integer> startCell) {
		State<Integer> findOne = new State<Integer>() {
			public String toString() {
				return "findOne";
			}
		};
		State<Integer> moveToEnd = new State<Integer>() {
			public String toString() {
				return "moveToEnd";
			}
		};
		State<Integer> moveToStart = new State<Integer>() {
			public String toString() {
				return "moveToStart";
			}
		};
		State<Integer> cleanUp = new State<Integer>() {
			public String toString() {
				return "cleanUp";
			}
		};

		findOne.put(Symbol.BLANK, new Triple(Symbol.BLANK, Direction.LEFT,
				cleanUp));
		findOne.put(symbol(1),
				new Triple(symbol(2), Direction.RIGHT, moveToEnd));
		findOne.put(symbol(2), new Triple(symbol(2), Direction.RIGHT, findOne));
		findOne.put(symbol(3), new Triple(symbol(3), Direction.RIGHT, findOne));

		moveToEnd.put(Symbol.BLANK, new Triple(symbol(3), Direction.LEFT,
				moveToStart));
		moveToEnd.put(symbol(1), new Triple(symbol(1), Direction.RIGHT,
				moveToEnd));
		moveToEnd.put(symbol(2), new Triple(symbol(2), Direction.RIGHT,
				moveToEnd));
		moveToEnd.put(symbol(3), new Triple(symbol(3), Direction.RIGHT,
				moveToEnd));

		moveToStart.put(Symbol.BLANK, new Triple(Symbol.BLANK, Direction.RIGHT,
				findOne));
		moveToStart.put(symbol(1), new Triple(symbol(1), Direction.LEFT,
				moveToStart));
		moveToStart.put(symbol(2), new Triple(symbol(2), Direction.RIGHT,
				findOne));
		moveToStart.put(symbol(3), new Triple(symbol(3), Direction.LEFT,
				moveToStart));

		cleanUp.put(Symbol.BLANK, new Triple(Symbol.BLANK, Direction.STAY,
				State.FINAL));
		cleanUp.put(symbol(2), new Triple(symbol(1), Direction.LEFT, cleanUp));
		cleanUp.put(symbol(3), new Triple(symbol(1), Direction.LEFT, cleanUp));

		findOne.enter(startCell);

	}

	public static void printTape(Cell<?> cell) {
		while (cell.symbol() != Symbol.BLANK) {
			System.out.print(cell.symbol().value());
			cell = cell.moveRight();
		}
		System.out.println();
	}

	public static void writeOnes(Cell<Integer> cell, int x) {
		if (x > 0) {
			cell.writeSymbol(symbol(1));
			cell = cell.moveRight();
			writeOnes(cell, x - 1);
			return;
		}
		return;
	}
}
