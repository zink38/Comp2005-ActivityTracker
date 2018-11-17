package model;

public class ActivityDataPoint {
	private double currentDuration;
	private double currentDistance;
	private double currentAltitude;
	
	public ActivityDataPoint(double _cDur, double _cDis, double _cAlt) {
		this.currentAltitude = _cAlt;
		this.currentDistance = _cDis;
		this.currentDuration = _cDur;
	}

	public double getCurrentDuration() {
		return currentDuration;
	}

	public void setCurrentDuration(double currentDuration) {
		this.currentDuration = currentDuration;
	}

	public double getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(double currentDistance) {
		this.currentDistance = currentDistance;
	}

	public double getCurrentAltitude() {
		return currentAltitude;
	}

	public void setCurrentAltitude(double currentAltitude) {
		this.currentAltitude = currentAltitude;
	}
}
