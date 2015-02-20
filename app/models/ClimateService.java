package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ClimateService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long rootServiceId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "creatorId", referencedColumnName = "id")
	private User user;
	private String name;
	private String purpose;
	private String url;
	private String scenario;
	private String createTime;
	private String versionNo;
	private int randomNum;

	public ClimateService() {
	}
	
	public ClimateService(long rootServiceId, User user, String name,
			String purpose, String url, String scenario, String createTime,
			String versionNo, int randomNum) {
		super();
		this.rootServiceId = rootServiceId;
		this.user = user;
		this.name = name;
		this.purpose = purpose;
		this.url = url;
		this.scenario = scenario;
		this.createTime = createTime;
		this.versionNo = versionNo;
		this.randomNum = randomNum;
	}
	public void setRandom(int random) {this.randomNum = random; }

	public int getRandom() {
		return randomNum;
	}

	public long getId() {
		return id;
	}

	public long getRootServiceId() {
		return rootServiceId;
	}

	public void setRootServiceId(long rootServiceId) {
		this.rootServiceId = rootServiceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	@Override
	public String toString() {
		return "ClimateService [id=" + id + ", rootServiceId=" + rootServiceId
				+ ", user=" + user + ", name=" + name + ", purpose=" + purpose
				+ ", url=" + url + ", scenario=" + scenario + ", createTime="
				+ createTime + ", versionNo=" + versionNo + "]";
	}

}
