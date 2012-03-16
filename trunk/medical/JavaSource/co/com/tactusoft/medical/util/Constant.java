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
	
	public static final String QUESTION_TYPE_MESSAGE = "MESSAGE";
	public static final String QUESTION_TYPE_ASSERTIVE = "ASSERTIVE";
	public static final String QUESTION_TYPE_UNIQUE = "UNIQUE";
	public static final String QUESTION_TYPE_MULTIPLE = "MULTIPLE";
	public static final String QUESTION_TYPE_MEDIA = "FINAL";
	
	public static final String RESOURCE_TYPE_IMAGE = "IMAGE";
	public static final String RESOURCE_TYPE_VIDEO = "VIDEO";
	public static final String RESOURCE_TYPE_LINK = "LINK";
	
	public static final String VIDEO_TYPE_WINDOWS = "windows";
	public static final String VIDEO_TYPE_QUICKTIME = "quicktime";
	public static final String VIDEO_TYPE_FLASH = "flash";
	public static final String VIDEO_TYPE_REAL = "real";
	
	public static final String LOAD_MODE_ON_LINE = "ON_LINE";
	public static final String LOAD_MODE_OFF_LINE = "OFF_LINE";

	public static final String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

}
