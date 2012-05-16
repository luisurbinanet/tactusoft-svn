package co.com.tactusoft.crm.util;

import java.math.BigDecimal;

public class Constant {

	public static final int STATE_ACTIVE = 1;
	public static final int STATE_INACTIVE = 0;

	public static BigDecimal DEFAULT_VALUE = new BigDecimal(-1);
	public static String DEFAULT_LABEL = "glb_default_value";

	public static final Integer SEND_PHONE = 1;
	public static final Integer SEND_EMAIL = 2;
	public static final Integer SEND_POSTAL = 3;
	public static final Integer SEND_SMS = 4;

	public static final String ROLE_ADMIN = "ADMINISTRADOR";
	public static final String ROLE_USER = "USUARIO";

	public static BigDecimal APP_TYPE_FOR_DATE_VALUE = new BigDecimal(1);
	public static BigDecimal APP_TYPE_FOR_DOCTOR_VALUE = new BigDecimal(2);

	public static String APP_TYPE_FOR_DATE_DESC = "app_for_date";
	public static String APP_TYPE_FOR_DOCTOR_DESC = "app_for_doctor";
	
	public static final Integer INTERVAL_TIME_APPOINTMENT = 5;

}
