package service.rc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import enums.rc.IconFunctions;
import model.bean.rc.GridBean;
import model.bean.rc.IconInfo;
import util.json.JacksonUtils;

public class GridResultCalcService {
	
	/**
	 * Process and calculate the result from RC Grid.
	 */
	public void processGridIcons(GridBean gb) {
		
		int count=0;
		
		List<Integer> iconPositions=null;
		Integer initPos=null;
		Integer initFrom=null;
		Integer vsPosition=null;
		Integer from=null;
		Integer to=null;
		Map<String,Integer> dirs=new HashMap<>();
		
		int width=gb.getWidth();
		int height=gb.getHeight();
		if(width<=0 || height<=0) {
			throw new RuntimeException("Zero grid?");
			// TODO
		}
		
//		System.out.println(gb);
		
		IconInfo info=new IconInfo();
//		System.out.println(gb.getIconJsonStr());
		List<List<Object>> iconList=(List<List<Object>>) JacksonUtils.jsonToList(gb.getIconJsonStr());
		System.out.println("Grid Icons="+iconList);
		
		/*Look for a voltage source, the start point.*/
		iconPositions=findIconPosition(iconList,IconFunctions.VOLTAGE_SOURCE);
		if(null==iconPositions || iconPositions.size()==0) {
//			System.out.println("No voltage source to begin.");
			throw new RuntimeException("No voltage source to begin.");
			// TODO User must place one voltage source.
		}else if(iconPositions.size()>1) {
//			System.out.println("There can be only one voltage source.");
			throw new RuntimeException("There can be only one voltage source.");
			// TODO User can only place ONE voltage source.
		}else if(iconPositions.size()==1) {
			
			/*Now there's a voltage source, let's continue.*/
			
			/*This is the start point, we'll travel through all the grid and eventually back to this point.*/
			initPos=iconPositions.get(0);
			
			vsPosition=initPos;
			System.out.println("vs="+vsPosition);
//			System.out.println(getFourWayNums(vsPosition,gb.getWidth(),gb.getHeight()));
			
			info.setPositions(iconPositions);
			info.setCurrentPos(vsPosition);
			info.setIcon(getIconByPos(iconList, vsPosition));
			info=setIconDirections(info);
			
			System.out.println(info);
			
			/*This section loops the circuit.*/
			if(info.getFrom()!=null && info.getTo()!=null) {
				
				/*There's a source and directions, now process to the next block.*/
				do {
					System.out.println("Count="+(++count));
					
					/*Get the four way blocks.*/
					dirs=getFourWayNums(info.getCurrentPos(),width,height);
					
					System.out.println("dirs"+dirs);
					System.out.println(dirs.get(info.getTo()));
					System.out.println(getIconByPos(iconList, dirs.get(info.getTo())));
					
					/*Check if the circuit encounters a dead end.*/
					if(existsDeadEnd(info)) {
						throw new RuntimeException("The circuit encounters a dead end, the result cannot be processed.");
						// TODO User must check if it's a complete circuit.
					}
					
					/*Move to the next block by setting info into IconInfo.*/
					info.setCurrentPos(dirs.get(info.getTo()));
					info.setIcon(getIconByPos(iconList, dirs.get(info.getTo())));
					info.setPositions(findIconPosition(iconList, info.getIcon()));
					info.setFrom(IconDirectionsUtils.getFromByTo(info.getTo()));
					info=IconDirectionsUtils.setIconDirections(info);
					//// TODO TODO
					
					System.out.println("AFTER "+info);
					
					/*Check if the next block is the source.*/
					if(info.getIcon()==IconFunctions.VOLTAGE_SOURCE) {
						System.out.println("END!!!!!!!!!!!!!!!!!");
					}
					
					System.out.println("-----------");
					/*Loop to the next block.*/
				}while(info.getIcon()!=IconFunctions.VOLTAGE_SOURCE);
				
//				for(int i=0;i<9;i++) {
//					
//					System.out.println("Count="+(++count));
//					
//					/*Get the four way blocks.*/
//					dirs=getFourWayNums(info.getCurrentPos(),width,height);
//					
//					System.out.println("dirs"+dirs);
//					System.out.println(dirs.get(info.getTo()));
//					System.out.println(getIconByPos(iconList, dirs.get(info.getTo())));
//					
//					/*Check if the circuit encounters a dead end.*/
//					if(existsDeadEnd(info)) {
//						throw new RuntimeException("The circuit encounters a dead end, the result cannot be processed.");
//						// TODO User must check if it's a complete circuit.
//					}
//					
//					/*Move to the next block by setting info into IconInfo.*/
//					info.setCurrentPos(dirs.get(info.getTo()));
//					info.setIcon(getIconByPos(iconList, dirs.get(info.getTo())));
//					info.setPositions(findIconPosition(iconList, info.getIcon()));
//					info.setFrom(IconDirectionsUtils.getFromByTo(info.getTo()));
//					info=IconDirectionsUtils.setIconDirections(info);
//					//// TODO TODO
//					
//					System.out.println("AFTER "+info);
//					
//					/*Check if the next block is the source.*/
//					if(info.getIcon()==IconFunctions.VOLTAGE_SOURCE) {
//						System.out.println("END!!!!!!!!!!!!!!!!!");
//					}
//					
//					System.out.println("-----------");
//					/*Loop to the next block.*/
//					
//				}
				
//				//////////////////
//				/*There's a source and directions, now process to the next block.*/
//				dirs=getFourWayNums(vsPosition,width,height);
//				System.out.println("dirs"+dirs);
//				
//				/*? TEST SECTION, REPLACE IT WITH LOOP ?*/
//				System.out.println(dirs.get(info.getTo()));
//				System.out.println(getIconByPos(iconList, dirs.get(info.getTo())));
//				info.setCurrentPos(dirs.get(info.getTo()));
//				info.setIcon(getIconByPos(iconList, dirs.get(info.getTo())));
//				info.setPositions(findIconPosition(iconList, info.getIcon()));
//				info.setFrom(IconDirectionsUtils.getFromByTo(info.getTo()));
//				
//				System.out.println("AFTER "+info);
//				////////////////
			}else {
				throw new RuntimeException("The source's Directions are unknown. Check if it has the right source.");
				// TODO 
			}
			
		}
		
	}
	
//	private void buildGrid(GridBean gb) {
//		
//		int height=gb.getHeight();
//		int width=gb.getWidth();
//		
//		if(0==height || 0==width) {
//			throw new RuntimeException("Zero grid.");
//		}
//		
//	}
	
	/**
	 * 
	 * @param n the current position 
	 * @param x width
	 * @param y height
	 * @return the relative position number of current position 
	 */
	private Map<String,Integer> getFourWayNums(int n,int x,int y){
		Map<String,Integer> map=new HashMap<>();
		
		//up
		Integer up=n-x;
		if(up<1) {
			up=null;
		}
		
		//down
		Integer down=n+x;
		if(down>x*y) {
			down=null;
		}
		
		//left
		Integer left=n-1;
		if(left%x==0) {
			left=null;
		}
		
		//right
		Integer right;
		if(n%x==0) {
			right=null;
		}else {
			right=n+1;
		}		
		
		map.put("UP",up);
		map.put("DOWN",down);
		map.put("LEFT",left);
		map.put("RIGHT",right);
		return map;
	}
	
	/**
	 * Find the positions of a icon.
	 * @param iconList
	 * @param icon
	 */
	private List<Integer> findIconPosition(List<List<Object>> iconList,IconFunctions icon) {
		
		List<Integer> positions=new ArrayList<>();
		
		for(List<Object> list:iconList) {
			if(icon.getIcon().equals(list.get(1))) {
				positions.add((Integer)list.get(0));
			}
		}
		
		if(positions.size()>=0) {
			return positions;
		}else {
			return null;
		}
		
	}
	
	/**
	 * Set current icon directions into info.
	 * @param info
	 */
	private IconInfo setIconDirections(IconInfo info) {
		return IconDirectionsUtils.setIconDirections(info);
	}
	
	/**
	 * Get Icon enum by Position.
	 * @param iconList
	 * @param pos
	 * @return
	 */
	private IconFunctions getIconByPos(List<List<Object>> iconList,Integer pos) {
		int n=0;
		
		for(List<Object> list:iconList) {
			for(Object obj:list) {
				if(obj.equals(pos)) {
					for(IconFunctions i:IconFunctions.values()) {
						if(i.getIcon().equals(iconList.get(n).get(1))) {
							return i;
						}
					}
				}
			}
			n++;
		}
		return null;
	}
	
	/**
	 * Process to the next icon.
	 */
	private void processNextIcon() {
		
	}
	
	/**
	 * Check if the circuit has a dead end.
	 * @param info
	 * @return
	 */
	private boolean existsDeadEnd(IconInfo info) {
		// TODO Needs adjustments.
		if(null==info.getFrom() || null==info.getTo()) {
			return true;
		}else {
			return false;
		}
	}

}
