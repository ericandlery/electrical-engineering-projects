package model.bean.rc;

public class GridBean {
	
	private Integer height;
	private Integer width;
	private String iconJsonStr;
	
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
	
	@Override
	public String toString() {
		return "GridBean [height=" + height + ", width=" + width + ", iconJsonStr=" + iconJsonStr + "]";
	}
	
}
