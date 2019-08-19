package com.SubTool.Start;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.SubTool.API.ConfigAPI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConfigAPI config = new ConfigAPI();
		config = config.reconfig();// 检测并解析配置文件

		File file = new File(System.getProperty("user.dir") + "\\guide.lrc");
		if (file.exists()) {// 初次使用
			new Lanuch(file, config);
		} else {

			if (config == null) {// 如配置文件出错
				file=Open(file);
				if ( file!= null) {
					new Lanuch(file, config);
				} else {
					System.exit(0);
				}
			} else {// 配置文件未出错
				if (config.t13) {// 直接记住历史文件
					//System.out.println("存在历史文件" + config.workmod);
					file = new File(config.workmod);
					//System.out.println(file.exists());
					if (file.exists()) {
						new Lanuch(file, config);
					}else {
						file=Open(file);
						if ( file!= null) {
							new Lanuch(file, config);
						} else {
							System.exit(0);
						}
					}
				} else {
					System.out.println("打开预设工作空间");
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("目前已支持ASS、SRT、LRC格式", "srt", "ass",
							"lrc", "txt");
					chooser.setCurrentDirectory(new File(config.workmod));
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(null);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						file = chooser.getSelectedFile();
						new Lanuch(file, config);
					} else {
						System.exit(0);
					}
				}

			}

		}
	}

	private static File Open(File file) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("目前已支持ASS、SRT、LRC格式", "srt", "ass", "lrc", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		FileSystemView fsv = FileSystemView.getFileSystemView(); // 默认以桌面目录为准
		// System.out.println(fsv.getHomeDirectory()); //得到桌面路径
		chooser.setCurrentDirectory(fsv.getHomeDirectory());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			return file;
		} else {
			System.exit(0);
		}
		return null;
	}

}
