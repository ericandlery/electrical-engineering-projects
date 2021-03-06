package service.rc;

import enums.rc.IconFunctions;
import model.bean.rc.IconInfo;

/**
 * Use this API to determine the direction of a icon.<br>
 * A temporary solution without using database.
 * @author Adam S
 */
public class IconDirectionsUtils {
	
	private static final String DOWN="DOWN";
	private static final String LEFT="LEFT";
	private static final String RIGHT="RIGHT";
	private static final String UP="UP";
	
	/**
	 * Configure and use this method to determine the directions of an icon.
	 * @param info
	 * @return
	 */
	public static IconInfo setIconDirections(IconInfo info) {
		
		IconFunctions icon=null;
		String from=null;
		String to=null;
		boolean error=false;
		
		if(null==info) {
			throw new RuntimeException("Must have a IconInfo object.");
			// TODO
		}
		
		icon=info.getIcon();
		from=info.getFrom();
		to=info.getTo();
		
		switch(icon) {
		case DOWN_RIGHT:
			if(DOWN.equals(from)) {
				info.setTo(RIGHT);
			}else if(RIGHT.equals(from)) {
				info.setTo(DOWN);
			}else {
				error=true;
			}
			break;
		case EMPTY:
			// TODO Empty blocks not allowed.
			throw new RuntimeException("You encounter a empty block!");
//			break;
		case LEFT_DOWN:
			if(LEFT.equals(from)) {
				info.setTo(DOWN);
			}else if(DOWN.equals(from)) {
				info.setTo(LEFT);
			}else {
				error=true;
			}
			break;
		case LEFT_UP:
			if(LEFT.equals(from)) {
				info.setTo(UP);
			}else if (UP.equals(from)) {
				info.setTo(LEFT);
			}else {
				error=true;
			}
			break;
		case STR_LINE_H:
			if(LEFT.equals(from)) {
				info.setTo(RIGHT);
			}else if (RIGHT.equals(from)) {
				info.setTo(LEFT);
			}else {
				error=true;
			}
			break;
		case STR_LINE_V:
			if(UP.equals(from)) {
				info.setTo(DOWN);
			}else if (DOWN.equals(from)) {
				info.setTo(UP);
			}else {
				error=true;
			}
			break;
		case UP_RIGHT:
			if(UP.equals(from)) {
				info.setTo(RIGHT);
			}else if(RIGHT.equals(from)) {
				info.setTo(UP);
			}else {
				error=true;
			}
			break;
		case VOLTAGE_SOURCE:
			info.setFrom(DOWN);
			info.setTo(UP);
			break;
		case RESISTOR_H:
			if(LEFT.equals(from)) {
				info.setTo(RIGHT);
			}else if(RIGHT.equals(from)) {
				info.setTo(LEFT);
			}else {
				error=true;
			}
			break;
		case RESISTOR_V:
			if(UP.equals(from)) {
				info.setTo(DOWN);
			}else if(DOWN.equals(from)) {
				info.setTo(UP);
			}else {
				error=true;
			}
			break;
		default:
			error=true;
			break;
		}
		
		if(error==true) {
			throw new RuntimeException("Not a valid circuit.");
			// TODO
		}else {
			return info;
		}
		
	}
	
	/**
	 * Determine where the direction  by . 
	 * @return
	 */
	public static String getFromByTo(String dir) {
		switch(dir.toUpperCase()) {
		case "UP":
			return "DOWN";
		case "DOWN":
			return "UP";
		case "LEFT":
			return "RIGHT";
		case "RIGHT":
			return "LEFT";
		default:throw new RuntimeException("Not a correct direction String.");
		}
	}

}
