import stanford.karel.*;

public class VoteCountingKarel extends SuperKarel {
	public void run() {
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				removeChad();
			}
			move();
		}
	}
	
	private void removeChad() {
		turnRight();
		checkPunchCorner();
		checkPunchCorner();
		turnLeft();
	}
	
	private void checkPunchCorner() {
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}
}
