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
	private int count;
	private String style;
	private String style1;

	public ClimateService() {
	}
	
	public ClimateService(long rootServiceId, User user, String name,
			String purpose, String url, String scenario, String createTime,
			String versionNo, int randomNum, int count, String style, String style1) {
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
		this.count = count;
		this.style = style;
		this.style1 = style1;
	}
	public void setStyle() {
		int rand = this.randomNum;
		switch(rand) {
			case 0 : style = "price-one"; style1 = "heading-one"; break;
			case 1 : style = "price-two"; style1 = "heading-two"; break;
			case 2 : style = "price-three"; style1 = "heading-three"; break;
			case 3 : style = "price-four"; style1 = "heading-four"; break;
			case 4 : style = "price-five"; style1 = "heading-five"; break;
			default : style = "price-six"; style1 = "heading-six"; break;
		}
	}

	public String getStyle() {return style;}

	public String getStyle1() {return style1;}

	public void setCount(int count) {this.count = count; }

	public int getCount() {return count;}

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
