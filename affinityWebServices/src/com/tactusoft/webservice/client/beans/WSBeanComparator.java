package com.tactusoft.webservice.client.beans;

import java.util.Comparator;

public class WSBeanComparator implements Comparator<WSBean> {
	
	@Override
	public int compare(WSBean o1, WSBean o2) {
		return o1.getNames().compareTo(o2.getNames());
	}

}
