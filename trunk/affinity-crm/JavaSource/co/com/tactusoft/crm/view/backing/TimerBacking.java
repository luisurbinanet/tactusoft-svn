package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.util.Asterisk;

@Named
@Scope("application")
public class TimerBacking {
	@Inject
	private ParameterBo parameterService;

	private Timer timer = new Timer();
	private boolean started = false;

	private String asteriskHost;
	private int asteriskPort;
	private String asteriskUser;
	private String asteriskPassword;

	public TimerBacking() {

	}

	@PostConstruct
	public void init() {

	}

	public void execute() {
		if (!started) {
			List<CrmParameter> listParameter = parameterService
					.getListParameterByGroup("ASTERISK");
			for (CrmParameter crmParameter : listParameter) {
				if (crmParameter.getCode().equals("ASTERISK_HOST")) {
					asteriskHost = crmParameter.getTextValue();
				} else if (crmParameter.getCode().equals("ASTERISK_PORT")) {
					asteriskPort = Integer
							.parseInt(crmParameter.getTextValue());
				} else if (crmParameter.getCode().equals("ASTERISK_USER")) {
					asteriskUser = crmParameter.getTextValue();
				} else if (crmParameter.getCode().equals("ASTERISK_PASSWORD")) {
					asteriskPassword = crmParameter.getTextValue();
				}
			}

			started = true;
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					Asterisk asterisk = new Asterisk(asteriskHost,
							asteriskPort, asteriskUser, asteriskPassword);
					asterisk.run();
					CrmParameter crmParameter = parameterService
							.getParameter("NUM_CALLS");
					crmParameter.setTextValue(asterisk.getNumCalls());
					crmParameter.setDescription("Última Actualización: "
							+ new Date());
					parameterService.saveParameter(crmParameter);
					//System.out.println("LLamadas: " + asterisk.getNumCalls());
				}
			}, 0L, 60000L);
		}
	}

}
