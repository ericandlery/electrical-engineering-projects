package service.rc;

import enums.rc.IconFunctions;
import model.bean.rc.IconInfo;

/**
 * Use this Class to determine the direction of a icon.<br>
 * A temporary solution without using database.
 * @author Adam S
 */
public class IconDirections {
	
	private static final String DOWN="DOWN";
	private static final String LEFT="LEFT";
	private static final String RIGHT="RIGHT";
	private static final String UP="UP";
	
	public static void setIconDirections(IconInfo info) {
		
		IconFunctions icon=info.getIcon();
		
		switch(icon) {
		case DOWN_RIGHT:
			break;
		case EMPTY:
			break;
		case LEFT_DOWN:
			break;
		case LEFT_UP:
			break;
		case STR_LINE_H:
			break;
		case STR_LINE_V:
			break;
		case UP_RIGHT:
			break;
		case VOLTAGE_SOURCE:
			info.setFrom(DOWN);
			info.setTo(UP);
			break;
		default:
			break;
		}
		
	}

}
