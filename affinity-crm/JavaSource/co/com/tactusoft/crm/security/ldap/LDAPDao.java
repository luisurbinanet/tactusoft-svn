package co.com.tactusoft.crm.security.ldap;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.context.annotation.Scope;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.util.FacesUtil;

@Named("LDAPDao")
@Scope("session")
public class LDAPDao {

	@Inject
	private ParameterBo service;

	public static final String ATTRIB_OBJECTCLASS = "objectclass";
	public static final String ATTRIB_CN = "cn";

	public static final String ATTRIB_VALUE_PERSON = "person";
	public static final String ATTRIB_VALUE_GROUPOFNAMES = "groupOfNames";

	private LdapTemplate ldapTemplate;

	public LDAPDao() {
		LdapContextSource contextSource = FacesUtil.findBean("contextSource");
		ldapTemplate = new LdapTemplate(contextSource);
	}

	/**
	 * @param base
	 *            : Por ejemplo 'cn=users'
	 * @param atributo
	 *            : Por ejemplo 'objectclass'
	 * @param valor
	 *            : Por ejemplo 'person', 'groupOfNames'
	 * @param atributoResult
	 *            : el atributo usado para generar la respuesta, por ejemplo
	 *            'cn'
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<String> getList(String base, String atributo, String valor,
			String atributoResult) {
		if (atributo == null) {
			atributo = LDAPDao.ATTRIB_OBJECTCLASS;
		}

		if (atributoResult == null) {
			atributoResult = LDAPDao.ATTRIB_CN;
		}

		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter(atributo, valor));

		final String sAttr = atributoResult;

		List<String> list = new LinkedList<String>();
		try {
			list = ldapTemplate.search(base, filter.encode(),
					new AttributesMapper() {
						public Object mapFromAttributes(Attributes attrs)
								throws NamingException {
							return attrs.get(sAttr).get();
						}
					});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public List<String> getListUsers() {
		List<String> listado = new LinkedList<String>();
		try {
			List<CrmParameter> listParameter = service
					.getListParameterByGroup("LDAP_GROUPS");
			for (CrmParameter row : listParameter) {
				List<String> listado1 = this.getList(row.getTextValue(),
						"objectClass", "user", "sAMAccountName");
				listado.addAll(listado1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listado;
	}

}
