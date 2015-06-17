/**
* A timing utility class useful for timing code segments
*/
public class TimeInterval {
	private long startTime, endTime;
	private long elapsedTime; // Time interval in milliseconds
// Commands
	public void startTiming() {
		elapsedTime = 0;
		startTime = System.currentTimeMillis();
	}
	public void endTiming() {
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
	}
// Queries
	public double getElapsedTime() {
		return (double) elapsedTime / 1000.0;
	}
}
