package misc;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import enums.rc.IconNames;
import model.bean.rc.GridBean;
import service.rc.GridResultCalcService;

public class TestMethod {

	@Test
	public void test() throws IOException {
		GridBean gb=new GridBean();
		gb.setHeight(4);
		gb.setWidth(7);
		gb.setIconJsonStr("[[1,\"0_empty.png\"],[2,\"0_empty.png\"],[3,\"0_empty.png\"],[4,\"0_empty.png\"],[5,\"0_empty.png\"],[6,\"0_empty.png\"],[7,\"0_empty.png\"],[8,\"0_empty.png\"],[9,\"03_down_right.png\"],[10,\"01_str_line_h.png\"],[11,\"04_left_down.png\"],[12,\"0_empty.png\"],[13,\"0_empty.png\"],[14,\"0_empty.png\"],[15,\"0_empty.png\"],[16,\"10_Voltage_Source.png\"],[17,\"0_empty.png\"],[18,\"02_str_line_v.png\"],[19,\"0_empty.png\"],[20,\"0_empty.png\"],[21,\"0_empty.png\"],[22,\"0_empty.png\"],[23,\"06_up_right.png\"],[24,\"01_str_line_h.png\"],[25,\"05_left_up.png\"],[26,\"0_empty.png\"],[27,\"0_empty.png\"],[28,\"0_empty.png\"]]");
		new GridResultCalcService().processGridIcons(gb);
				
	}

}
