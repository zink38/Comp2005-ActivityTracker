package model;

public class ActivityDataPoint {
	private double currentDuration;
	private double currentDistance;
	private double currentAltitude;
	private double altitudeChange;
	private Date date;
	 
	public ActivityDataPoint(double _cDur, double _cDis, double _cAlt,double _altCh, Date date) {
		this.currentAltitude = _cAlt;
		this.currentDistance = _cDis;
		this.currentDuration = _cDur;
		this.altitudeChange = _altCh;
		this.date = date;
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
	public Date getDate() {
		return date;
	}

	public double getAltitudeChange() {
		return altitudeChange;
	}

	public void setAltitudeChange(double altitudeChange) {
		this.altitudeChange = altitudeChange;
	}
	
}
