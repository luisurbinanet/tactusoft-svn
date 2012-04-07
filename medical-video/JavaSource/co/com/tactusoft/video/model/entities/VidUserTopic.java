package co.com.tactusoft.video.model.entities;

// Generated 5/04/2012 11:08:28 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VidUserTopic generated by hbm2java
 */
@Entity
@Table(name = "vid_user_topic", catalog = "medical_video_db")
public class VidUserTopic implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private User user;
	private VidTopic vidTopic;
	private Date initDate;
	private Date endDate;
	private Integer transactionsNumber;

	public VidUserTopic() {
	}

	public VidUserTopic(BigDecimal id, User user, VidTopic vidTopic) {
		this.id = id;
		this.user = user;
		this.vidTopic = vidTopic;
	}

	public VidUserTopic(BigDecimal id, User user, VidTopic vidTopic,
			Date initDate, Date endDate, Integer transactionsNumber) {
		this.id = id;
		this.user = user;
		this.vidTopic = vidTopic;
		this.initDate = initDate;
		this.endDate = endDate;
		this.transactionsNumber = transactionsNumber;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_topic", nullable = false)
	public VidTopic getVidTopic() {
		return this.vidTopic;
	}

	public void setVidTopic(VidTopic vidTopic) {
		this.vidTopic = vidTopic;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "init_date", length = 19)
	public Date getInitDate() {
		return this.initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "transactions_number")
	public Integer getTransactionsNumber() {
		return this.transactionsNumber;
	}

	public void setTransactionsNumber(Integer transactionsNumber) {
		this.transactionsNumber = transactionsNumber;
	}

}
