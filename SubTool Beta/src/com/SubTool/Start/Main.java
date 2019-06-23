package com.SubTool.Start;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		File file=new File(System.getProperty("user.dir") + "\\guide.lrc");
		if (file.exists()) {
			new Lanuch(file);
		}else {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("目前已支持ASS、SRT、LRC格式", "srt", "ass", "lrc", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				new Lanuch(file);
			} else {
				System.exit(0);
			}
		}
		
	}
	
}
