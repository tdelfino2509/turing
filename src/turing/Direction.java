package turing;

public enum Direction {
	LEFT {
		@Override
		public Cell move(Cell cell) {
			return cell.moveLeft();
		}
	},
	RIGHT {
		@Override
		public Cell move(Cell cell) {
			return cell.moveRight();
		}
	},
	STAY;

	public Cell move(Cell cell) {
		return cell;
	}
}
