package co.com.tactusoft.crm.util;

import java.math.BigDecimal;

public class Constant {

	public static final int STATE_ACTIVE = 1;
	public static final int STATE_INACTIVE = 0;

	public static String DEFAULT_VALUE_STRING = "-1";
	public static BigDecimal DEFAULT_VALUE = new BigDecimal(-1);
	public static String DEFAULT_LABEL = "glb_default_value";
	public static String DEFAULT_LABEL_ALL = "glb_all_value";
	public static String ALL_LABEL = "glb_all_value";

	public static final Integer SEND_PHONE = 1;
	public static final Integer SEND_EMAIL = 2;
	public static final Integer SEND_POSTAL = 3;
	public static final Integer SEND_SMS = 4;

	public static final String ROLE_ADMIN = "ADMINISTRADOR";
	public static final String ROLE_USER = "USER";
	public static final String ROLE_DOCTOR = "DOCTOR";
	public static final String ROLE_NURSE = "NURSE";
	public static final String ROLE_NURSE_AUX = "NURSE_AUX";

	public static BigDecimal APP_TYPE_FOR_DATE_VALUE = new BigDecimal(1);
	public static BigDecimal APP_TYPE_FOR_DOCTOR_VALUE = new BigDecimal(2);

	public static String APP_TYPE_FOR_DATE_DESC = "app_for_date";
	public static String APP_TYPE_FOR_DOCTOR_DESC = "app_for_doctor";

	public static final int INTERVAL_TIME_APPOINTMENT = 5;
	public static final int INCREASE_MIN = 10;

	public static final int STATE_APP_ACTIVE = 1;
	public static final int STATE_APP_CANCEl = 3;

	public static final int APP_STATE_CONFIRMED = 1;
	public static final int APP_STATE_CANCELED = 2;
	public static final int APP_STATE_CHECKED = 3;
	public static final int APP_STATE_ATTENDED = 4;
	public static final int APP_STATE_NOATTENDED = 5;

	public static final String APP_STATE_CONFIRMED_LABEL = "glb_app_confirmed";
	public static final String APP_STATE_CANCELED_LABEL = "glb_app_canceled";
	public static final String APP_STATE_CHECKED_LABEL = "glb_app_checked";
	public static final String APP_STATE_ATTENDED_LABEL = "glb_app_attended";
	public static final String APP_STATE_NOATTENDED_LABEL = "glb_app_no_attended";

	public static final String HISTORY_NOT_REFER = "NO REFERIDO";
	public static final String HISTORY_NORMAL = "NORMAL";

	public static final String MATERIAL_TYPE_MEDICINE = "MEDICAMENTO";
	public static final String MATERIAL_TYPE_OTHER_MEDICINE = "OTRO_MEDICAMENTO";
	public static final String MATERIAL_TYPE_THERAPY = "TERAPIA";
	public static final String MATERIAL_TYPE_EXAMS = "EXAMENES_COMPLEMENTARIOS";

	public static final String NOTE_TYPE_DOCTOR = "MEDICO";
	public static final String NOTE_TYPE_NURSE = "ENFERMERA";
	public static final String NOTE_TYPE_SUPPORT = "SOPORTE";
	public static final String NOTE_TYPE_REMISSION = "REMISION";
	public static final String NOTE_TYPE_THERAPY = "TERAPIA";

	public static final String TIME_TYPE_DOCTOR = "MEDICO";
	public static final String TIME_TYPE_NURSE = "ENFERMERA";
	public static final String TIME_TYPE_STRETCHERS = "CAMILLAS";

	public static final String PRINT_ORIENTATION_PORTRAIT = "PORTRAIT";
	public static final String PRINT_ORIENTATION_LANDSCAPE = "LANDSCAPE";

	public static final String SCHEDULE_REMOVE = "REMOVE";
	public static final String SCHEDULE_MAINTAIN = "MAINTAIN";

	public static String CALLED_TYPE_IN = "INCOMING";
	public static String CALLED_TYPE_OUT = "OUTGOING";

	public static String HISTORY_HISTORY = "HISTORY";
	public static String HISTORY_RECORD = "RECORD";
	public static String HISTORY_HOMEOPATHIC = "HOMEOPATHIC";
	public static String HISTORY_PHYSIQUE = "PHYSIQUE";
	public static String HISTORY_ORGANOMETRY = "ORGANOMETRY";
	
	public static final int RECALL_NO_ATTENDET = 1;
	public static final int RECALL_CONFIRMED = 2;
	public static final int RECALL_CONTROL = 3;
	public static final int RECALL_MEDICATION = 4;
	public static final int RECALL_REMINDER = 5;
	
	public static String ODONTOLOGY_HISTORY_TYPE = "ODONTOLOGY";
	public static String MEDICAL_HISTORY_TYPE = "MEDICAL";
}
