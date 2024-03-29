package co.com.tactusoft.crm.util;

public class Parameter {
	
	private String name;
	private Object value;
	
	public Parameter(){
		
	}
	
	/**
	 * @param name
	 * @param value
	 */
	public Parameter(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}