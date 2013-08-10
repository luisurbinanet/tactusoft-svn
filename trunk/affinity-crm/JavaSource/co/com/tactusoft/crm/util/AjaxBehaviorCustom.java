package co.com.tactusoft.crm.util;

import java.util.HashMap;
import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.BehaviorEvent;
import org.primefaces.component.behavior.ajax.AjaxBehavior;

/**
 * 
 * @author administrador
 */
public class AjaxBehaviorCustom extends AjaxBehavior {

	@Override
	public Object saveState(FacesContext context) {
		HashMap<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("update", getUpdate());
		map.put("process", getProcess());
		map.put("oncomplete", getOncomplete());
		map.put("onerror", getOnerror());
		map.put("onsuccess", getOnsuccess());
		map.put("onstart", getOnstart());
		map.put("listener", getListener());

		if (initialStateMarked()) {
			return null;
		}
		return UIComponentBase.saveAttachedState(context, map);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void restoreState(FacesContext context, Object state) {
		if (state != null) {
			HashMap<String, Object> map;
			map = (HashMap<String, Object>) UIComponentBase
					.restoreAttachedState(context, state);

			setUpdate((String) map.get("update"));
			setProcess((String) map.get("process"));
			setOncomplete((String) map.get("oncomplete"));
			setOnerror((String) map.get("onerror"));
			setOnsuccess((String) map.get("onsuccess"));
			setOnstart((String) map.get("onstart"));
			setListener((MethodExpression) map.get("listener"));
		}

	}

	@Override
	public void broadcast(BehaviorEvent event) throws AbortProcessingException {
		ELContext eLContext = FacesContext.getCurrentInstance().getELContext();

		// Backward compatible implementation of listener invocation
		if (getListener() != null) {
			try {
				getListener().invoke(eLContext, new Object[] { event });
			} catch (IllegalArgumentException exception) {
				getListener().invoke(eLContext, new Object[0]);
			}
		}
	}
}
