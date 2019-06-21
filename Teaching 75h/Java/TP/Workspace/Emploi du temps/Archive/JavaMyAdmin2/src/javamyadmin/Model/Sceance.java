package javamyadmin.Model;

import java.util.Date;

public class Sceance extends BaseEntity {

	private Date date;
	private Date time;
	private Module module;
	private String idEmploi;
	boolean isTest;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isTest() {
		return isTest;
	}

	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getIdEmploi() {
		return idEmploi;
	}

	public void setIdEmploi(String idEmploi) {
		this.idEmploi = idEmploi;
	}

}
