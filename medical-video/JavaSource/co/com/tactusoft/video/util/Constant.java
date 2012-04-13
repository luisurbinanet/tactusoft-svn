package co.com.tactusoft.video.util;

import java.math.BigDecimal;

public class Constant {

	public static final int STATE_ACTIVE = 1;
	public static final int STATE_INACTIVE = 0;

	public static BigDecimal DEFAULT_VALUE = new BigDecimal(-1);
	public static String DEFAULT_LABEL = "-- SELECCIONE --";
	
	public static final String QUESTION_TYPE_MESSAGE = "MESSAGE";
	public static final String QUESTION_TYPE_ASSERTIVE = "ASSERTIVE";
	public static final String QUESTION_TYPE_UNIQUE = "UNIQUE";
	public static final String QUESTION_TYPE_TIME = "TIME";

	public static final String VIDEO_TYPE_WINDOWS = "windows";
	public static final String VIDEO_TYPE_QUICKTIME = "quicktime";
	public static final String VIDEO_TYPE_FLASH = "flash";
	public static final String VIDEO_TYPE_REAL = "real";

	public static final String ROLE_ADMIN = "ADMINISTRADOR";
	public static final String ROLE_USER = "USUARIO";

}
