package util.file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

public class MyFileUtils {
	
	public static void getIconNamesForRC() {
//		FileUtils.listFiles(null,"png",false);
	}
	
	/**
	 * Use this method to get RC icons name list.
	 * */
	public static List<String> getFileNamesFromRequestForRC(String path,HttpServletRequest req) throws IOException {
		
		List<String> iconNames=new ArrayList<>();
		
		try {
			
			URL url=req.getServletContext().getResource(path);
			List<File> list=(List<File>) FileUtils.listFiles(new File(url.toURI()),new String[] {"png"},false);
			for(File file:list) {
				iconNames.add(file.getName());
			}
//			System.out.println(iconNames);
			
			return iconNames;
			
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException("MyFileUtils failed. Method=getFileNamesFromRequest");
		}
	}

}
