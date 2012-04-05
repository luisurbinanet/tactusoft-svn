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
 * VidUserPackage generated by hbm2java
 */
@Entity
@Table(name = "vid_user_package", catalog = "medical_video_db")
public class VidUserPackage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private User user;
	private VidPackage vidPackage;
	private Date initDate;
	private Date endDate;

	public VidUserPackage() {
	}

	public VidUserPackage(BigDecimal id, User user, VidPackage vidPackage) {
		this.id = id;
		this.user = user;
		this.vidPackage = vidPackage;
	}

	public VidUserPackage(BigDecimal id, User user, VidPackage vidPackage,
			Date initDate, Date endDate) {
		this.id = id;
		this.user = user;
		this.vidPackage = vidPackage;
		this.initDate = initDate;
		this.endDate = endDate;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_package", nullable = false)
	public VidPackage getVidPackage() {
		return this.vidPackage;
	}

	public void setVidPackage(VidPackage vidPackage) {
		this.vidPackage = vidPackage;
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

}
