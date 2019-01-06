package model.bean.rc;

import java.util.List;

import enums.rc.IconFunctions;

/**
 * This bean stores icon info.
 * @author Adam S
 *
 */
public class IconInfo {
	
	private IconFunctions icon;
	private List<Integer> positions;
	private String from;
	private String to;
	private Integer currentPos;
	
	public IconFunctions getIcon() {
		return icon;
	}
	public void setIcon(IconFunctions icon) {
		this.icon = icon;
	}
	public List<Integer> getPositions() {
		return positions;
	}
	public void setPositions(List<Integer> positions) {
		this.positions = positions;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getCurrentPos() {
		return currentPos;
	}
	public void setCurrentPos(Integer currentPos) {
		this.currentPos = currentPos;
	}
	
	@Override
	public String toString() {
		return "IconInfo [icon=" + icon + ", positions=" + positions + ", from=" + from + ", to=" + to + ", currentPos="
				+ currentPos + "]";
	}

}
