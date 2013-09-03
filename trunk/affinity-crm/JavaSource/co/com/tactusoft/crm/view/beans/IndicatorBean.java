package co.com.tactusoft.crm.view.beans;

public class IndicatorBean {

	private String type;
	private long value;
	private double percent;

	public IndicatorBean() {

	}

	/**
	 * @param type
	 * @param value
	 * @param percent
	 */
	public IndicatorBean(String type, long value, double percent) {
		super();
		this.type = type;
		this.value = value;
		this.percent = percent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

}
