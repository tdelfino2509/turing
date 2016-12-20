package turing;

public class Triple {
	private State nextState;
	private Direction nextDirection;
	private Symbol nextSymbol;

	public Triple(Symbol nextSymbol, Direction nextDirection, State nextState) {
		this.nextState = nextState;
		this.nextDirection = nextDirection;
		this.nextSymbol = nextSymbol;
	}

	public void execute(Cell cell) {
		System.out.println(nextSymbol + "\t" + nextDirection + "\t" + nextState);
		cell.writeSymbol(this.nextSymbol);
		cell = this.nextDirection.move(cell);
		this.nextState.enter(cell);
	}
}
