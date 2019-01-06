package model.bean.rc;

import java.util.List;

public class GridBean {
	
	private Integer height;
	private Integer width;
	private String iconJsonStr;
	private List<String> iconNames;
	
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public String getIconJsonStr() {
		return iconJsonStr;
	}
	public void setIconJsonStr(String iconJsonStr) {
		this.iconJsonStr = iconJsonStr;
	}
	public List<String> getIconNames() {
		return iconNames;
	}
	public void setIconNames(List<String> iconNames) {
		this.iconNames = iconNames;
	}
	
	@Override
	public String toString() {
		return "GridBean [height=" + height + ", width=" + width + ", iconJsonStr=" + iconJsonStr + ", iconNames="
				+ iconNames + "]";
	}
	
}
