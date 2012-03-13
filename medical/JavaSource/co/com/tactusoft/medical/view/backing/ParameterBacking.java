package co.com.tactusoft.medical.view.backing;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.ParameterBo;

@Named
@Scope("session")
public class ParameterBacking {

	@Inject
	private ParameterBo serviceParameter;

	private String urlImages;

	public ParameterBacking() {
		urlImages = null;
	}

	public String getUrlImages() {
		if (urlImages == null) {
			urlImages = serviceParameter.getValueText("URL_IMAGES");
		}
		return urlImages;
	}

}
