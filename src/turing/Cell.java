package turing;

public class Cell<E> {
	private class LeftCell<E> extends Cell<E> {

		private LeftCell(Cell<E> rightCell) {
			super(null, rightCell);
		}

		@Override
		public Cell<E> moveLeft() {
			Cell<E> newLeftCell = new LeftCell<E>(new Cell(Symbol.BLANK));
			Cell<E> newThisCell = new Cell<E>(super.symbol);
			newThisCell.setLeftCell(newLeftCell);
			newThisCell.setRightCell(this.moveRight());
			newLeftCell.setRightCell(newThisCell);
			newThisCell.moveRight().setLeftCell(newThisCell);
			return newLeftCell;
		}
	}

	private class RightCell<E> extends Cell<E> {
		private RightCell(Cell<E> leftCell) {
			super(leftCell, null);
		}

		@Override
		public Cell<E> moveRight() {
			Cell<E> newRightCell = new RightCell<E>(new Cell(Symbol.BLANK));
			Cell<E> newThisCell = new Cell<E>(super.symbol);
			newThisCell.setLeftCell(this.moveLeft());
			newThisCell.setRightCell(newRightCell);
			newRightCell.setLeftCell(newThisCell);
			newThisCell.moveLeft().setRightCell(newThisCell);
			// System.out.println("<\t" + leftCell.symbol + "\t" +
			// newThisCell.symbol + "\t" + newRightCell.symbol);
			return newRightCell;
		}
	}

	private Symbol symbol = Symbol.BLANK;
	private Cell<E> leftCell, rightCell;

	public Cell(Cell<E> leftCell, Cell<E> rightCell) {
		this.leftCell = leftCell;
		this.rightCell = rightCell;
	}

	public Cell(Symbol<E> symbol) {
		this.leftCell = new LeftCell<E>(this);
		this.rightCell = new RightCell<E>(this);
		this.symbol = symbol;
	}

	public Cell(Symbol<E> symbol, Cell<E> leftCell, Cell<E> rightCell) {
		this(symbol);
		this.leftCell = leftCell;
		this.rightCell = rightCell;
	}

	private void setLeftCell(Cell<E> leftCell) {
		this.leftCell = leftCell;
	}

	private void setRightCell(Cell<E> rightCell) {
		this.rightCell = rightCell;
	}

	public Cell<E> moveLeft() {

		// System.out.println(rightCell != null);
		// System.out.println(">\t" + leftCell.symbol + "\t" + this.symbol +
		// "\t" + rightCell.symbol);
		return leftCell;
	}

	public Cell<E> moveRight() {

		// System.out.println(leftCell != null);
		// System.out.println("<\t" + leftCell.symbol + "\t" + this.symbol +
		// "\t" + rightCell.symbol);
		return rightCell;
	}

	public Symbol<E> symbol() {
		return symbol;
	}

	public void writeSymbol(Symbol<E> symbol) {
		this.symbol = symbol;
	}
}
