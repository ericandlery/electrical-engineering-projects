package misc.api;

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
		Map<String,Integer> map;
				
		for(int i=1;i<=x*y;i++) {
			map=this.getFourWayNums(i, x, y);
			System.out.println(map);
//			boolean b=this.isWrongNums(map, x, y);
//			if(b==false) {
//				System.out.println(i);
//			}
		}
	}
	
	public Map<String,Integer> getFourWayNums(int n,int x,int y){
		Map<String,Integer> map=new HashMap<>();
				
		//up
		Integer up=n-x;
		if(up<1) {
			up=null;
		}
//		System.out.println(up);
		
		//down
		Integer down=n+x;
		if(down>x*y) {
			down=null;
		}
//		System.out.println(down);
		
		//left
		Integer left=n-1;
		if(left%x==0) {
			left=null;
		}
//		System.out.println(left);
		
		//right
		Integer right;
		if(n%x==0) {
			right=null;
		}else {
			right=n+1;
		}
//		System.out.println(right);
		
		
		map.put("UP",up);
		map.put("DOWN",down);
		map.put("LEFT",left);
		map.put("RIGHT",right);
		return map;
	}
	
	public Boolean isWrongNums(Map<String,Integer> map,int x,int y){
		int total=x*y;
		Set<String> s=map.keySet();
		String[] st=new String[] {};
		String[] ss=s.toArray(st);
		for(String str:ss) {
			Integer num=map.get(str);
			if(num!=null && (num<1 || num>total)) {
				return false;
			}
		}
		return true;
	}

}
