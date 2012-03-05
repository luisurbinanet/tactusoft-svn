package co.com.tactusoft.medical.util;

import java.math.BigDecimal;

public class Constant {

	public static final int STATE_ACTIVE = 1;
	public static final int STATE_INACTIVE = 0;

	public static BigDecimal DEFAULT_VALUE = new BigDecimal(-1);
	public static String DEFAULT_LABEL = "-- SELECCIONE --";

	public static final int CALCULATION_TYPE_1 = 1;
	public static final int CALCULATION_TYPE_2 = 2;
	public static final int CALCULATION_TYPE_3 = 3;
	
	public static final String TYPE_QUESTION_ASSERTIVE = "ASSERTIVE";
	public static final String TYPE_QUESTION_UNIQUE = "UNIQUE";
	public static final String TYPE_QUESTION_MULTIPLE = "MULTIPLE";
	public static final String TYPE_QUESTION_FINAL = "FINAL";

	public static final String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

}
