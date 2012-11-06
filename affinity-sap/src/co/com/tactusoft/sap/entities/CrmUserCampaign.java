package co.com.tactusoft.sap.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

public class CrmUserCampaign implements Serializable {

	private static final long serialVersionUID = 1L;
	private CrmUserCampaignId id;
	private Long numRecords;

	@EmbeddedId
	public CrmUserCampaignId getId() {
		return id;
	}

	public void setId(CrmUserCampaignId id) {
		this.id = id;
	}

	public Long getNumRecords() {
		return numRecords;
	}

	public void setNumRecords(Long numRecords) {
		this.numRecords = numRecords;
	}

}
