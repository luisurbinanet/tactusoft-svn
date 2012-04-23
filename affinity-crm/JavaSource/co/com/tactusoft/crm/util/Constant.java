package co.com.tactusoft.crm.util;

import java.math.BigDecimal;

public class Constant {

	public static final int STATE_ACTIVE = 1;
	public static final int STATE_INACTIVE = 0;

	public static BigDecimal DEFAULT_VALUE = new BigDecimal(-1);
	public static String DEFAULT_LABEL = "-- SELECCIONE --";

	public static final Integer SEND_PHONE = 1;
	public static final Integer SEND_EMAIL = 2;
	public static final Integer SEND_POSTAL = 3;
	public static final Integer SEND_SMS = 4;

	public static final String VIDEO_TYPE_WINDOWS = "windows";
	public static final String VIDEO_TYPE_QUICKTIME = "quicktime";
	public static final String VIDEO_TYPE_FLASH = "flash";
	public static final String VIDEO_TYPE_REAL = "real";

	public static final String ROLE_ADMIN = "ADMINISTRADOR";
	public static final String ROLE_USER = "USUARIO";

}
