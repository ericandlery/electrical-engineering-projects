package test.bean;

import java.util.Date;

public class TestBean {
	
	private String s;
	private Integer i;
	private Date d;
	
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public Integer getI() {
		return i;
	}
	public void setI(Integer i) {
		this.i = i;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "TestBean [s=" + s + ", i=" + i + ", d=" + d + "]";
	}

}
