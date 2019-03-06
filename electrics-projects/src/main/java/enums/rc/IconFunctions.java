package enums.rc;

/**
 * Use this enum to determine the functionality of icons. Will try using db as a solution the other day......
 * */
public enum IconFunctions {
	
	EMPTY("0_empty.png"),
	STR_LINE_H("01_str_line_h.png"),
	STR_LINE_V("02_str_line_v.png"),
	DOWN_RIGHT("03_down_right.png"),
	LEFT_DOWN("04_left_down.png"),
	LEFT_UP("05_left_up.png"),
	UP_RIGHT("06_up_right.png"),
	VOLTAGE_SOURCE("10_Voltage_Source.png"),
	RESISTOR_H("11_Resistor_h.png"),
	RESISTOR_V("12_Resistor_v.png")
	;
	
	private String icon;
	
	IconFunctions(String icon){
		this.icon=icon;
	}
	
	public String getIcon() {
		return icon;
	}

}
