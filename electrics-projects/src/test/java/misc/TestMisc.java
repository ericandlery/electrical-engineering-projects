package misc;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestMisc {
	
	@Test
	public void test() {
		
		int x=6;
		int y=5;
		String block="O";
		int c=1;
		int total=x*y;
		
		NumberFormat nf=new DecimalFormat("000");
		
		for(int i=0;i<y;i++) {
			for(int j=0;j<x;j++) {
				System.out.print(nf.format(c++)+" ");
			}
			System.out.println();
		}
		Map<String,Integer> map=this.getFourWayNums(15,x, y);
		System.out.println(map);
		
		this.findWrongNums(map, x, y);
	}
	
	public Map<String,Integer> getFourWayNums(int n,int x,int y){
		Map<String,Integer> map=new HashMap<>();
		
		//get 15
		
		//up
		int up=n-x;
//		System.out.println(up);
		
		//down
		int down=n+x;
//		System.out.println(down);
		
		//left
		int left=n-1;
//		System.out.println(left);
		
		//right
		int right=n+1;
//		System.out.println(right);
		
		
		map.put("UP",up);
		map.put("DOWN",down);
		map.put("LEFT",left);
		map.put("RIGHT",right);
		return map;
	}
	
	public List<Integer> findWrongNums(Map<String,Integer> map,int x,int y){
		int total=x*y;
		Set<String> s=map.keySet();
//		String[] ss=(String[])s.toArray();
		System.out.println("kk");
		
		return null;
	}

}
