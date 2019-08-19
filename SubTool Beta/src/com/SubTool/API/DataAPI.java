package com.SubTool.API;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import com.SubTool.UI.MainPanel;
import com.SubTool.UI.Message;
import com.SubTool.UI.Setting;

public class DataAPI {

	// 全局变量
	public File file;
	public String version = "V2.0.Beta";
	public String Build = "19047";
	public String way = "UTF-8";// 默认编码方式
	public int type = 0;// 文件类型1str，2ass，3lrc

	@SuppressWarnings("unused")
	private int oldsecond, oldminute, oldhour;
	private long StartTime = 0;

	public int num = 0;
	public String Key = "";// 查找时的关键字
	public boolean SettingState = false;// 设置界面状态
	public boolean Mod_state = false;
	public boolean Mod = false;
	public String workmode;//工作空间路径


	public File newfile;
	public String subtitles;
	public THEME theme = new THEME();
	public File cfile = new File(System.getProperty("user.dir") + "\\config.in");

	/**
	 * 将主题相关封装在一个类中
	 */
	public class THEME {
		public Color maincolor = null;
		public Color sidecolor = null;
		public Color fontcolor = Color.BLACK;
		public int fontsize = 20;
		public String fontface = "微软雅黑";
		public boolean Bold = false;// 字体加粗
		public boolean Italic = false;// 字体倾斜
		public boolean Underline = false;// 下划线

	}

	public DataAPI(JFrame f,File file) {
		// TODO 自动生成的构造函数存根
		this.file = file;
		// ;//读取配置文件
		Analysis(file);// 读取文件类型和编码
		// 在原目录下生成副本文件
		String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);// 后缀名
		String filename1 = "." + file.getName().substring(0, file.getName().length() - suffix.length() - 1); // 获取纯文件名

		newfile = new File(file.getParent(), filename1 + "-副本." + suffix);// 生成副本
		try {
			newfile.createNewFile();
		} catch (IOException e2) {
			// TODO 自动生成的 catch 块
			// e2.printStackTrace();
			new Message(f, "权限不足！生成副本文件失败，请检查权限！", 5000);
			System.exit(0);
		}
	}

	/**
	 * 返回软件版本号，2为内部版本号
	 */
	public String Version(int type) {

		if (type == 2)
			return Build;
		else
			return version;
	}

	

	/**
	 * 读取设置偏好并保存至配置文件
	 */
	public int saveconfig(Setting p) {

		try {
			System.out.println("已保存配置文件...");
			OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(cfile), "utf-8");
			BufferedWriter wr = new BufferedWriter(outStream);
			wr.write("@SubTool Config File\n");// 第一行，无用行

			String list1 = "";
			if (p.L2_j2.isSelected())
				list1 += "1,,";
			else
				list1 += "0,,";
			list1 += p.L2_j1.getSelectedIndex() + ",,";// 主题序号

			if (p.L2_j5.isSelected()) {// 侧栏混搭开关
				list1 += "1,,";
				list1 += (p.L2_j3.getSelectedIndex() + ",,");
				list1 += (p.sidecolor.getRed() + "," + p.sidecolor.getGreen() + "," + p.sidecolor.getBlue() + ","
						+ p.sidecolor.getAlpha() + ",,");
				// System.out.println((p.sidecolor.getRed()+","+p.sidecolor.getGreen()+","+p.sidecolor.getBlue()+","+p.sidecolor.getAlpha()+",,"));
			} else {
				list1 += "0,,";
				list1 += (p.L2_j3.getSelectedIndex() + ",,");
				list1 += "000,000,000,000,,";
			}
			if (p.L2_j6.isSelected()) {
				list1 += "1,,";
				list1 += p.L2_j4.getSelectedIndex() + ",,";
				list1 += (p.pancolor.getRed() + "," + p.pancolor.getGreen() + "," + p.pancolor.getBlue() + ","
						+ p.pancolor.getAlpha()) + ",,";
			} else {
				list1 += "0,,";
				list1 += p.L2_j4.getSelectedIndex() + ",,";
				list1 += "000,000,000,000";
			}
			wr.write(list1);// 写入主题配置
			// System.out.println(list1);

			String list2 = "";
			list2 += (p.L1_j1.getSelectedIndex() + ",,");
			list2 += (p.L1_j2.getSelectedIndex() + ",,");
			if (p.L1_j4.isSelected()) {
				list2 += "1,,";
				list2 += p.L1_j3.getSelectedIndex() + ",,";

				list2 += p.fontcolor.getRed() + "," + p.fontcolor.getGreen() + "," + p.fontcolor.getBlue() + ","
						+ p.fontcolor.getAlpha() + ",,";
				//System.out.println(list2);
			} else {
				list2 += "0,,";
				list2 += p.L1_j3.getSelectedIndex() + ",,";
				list2 += "000,000,000,000,,";
			}
			if (p.L1_j6.isSelected()) {
				list2 += "1,,";
				list2 += p.L1_j5.getSelectedIndex() + ",,";
				if (p.L1_j7.isSelected())
					list2 += "1,,";
				else
					list2 += "0,,";
				if (p.L1_j8.isSelected())
					list2 += "1,,";
				else
					list2 += "0,,";
				if (p.L1_j9.isSelected())
					list2 += "1,,";
				else
					list2 += "0";

			} else {
				list2 += "0,,";
				list2 += p.L1_j5.getSelectedIndex() + ",,";
				list2 += "0,,0,,0";
			}
			wr.write("\n" + list2);// 写入主题配置

			String list3 = "";
			if (p.L3_j1.isSelected())
				list3 += "1,,";
			else
				list3 += "0,,";

			if (p.L3_j2.isSelected())
				list3 += "1,,";
			else
				list3 += "0,,";
			list3 += p.L3_j3.getSelectedIndex() + ",,";

			if (p.L3_j4.isSelected())
				list3 += "1,,";
			else
				list3 += "0,,";

			if (p.L3_j6.isSelected())
				list3 += "1,,";
			else
				list3 += "0,,";
			if(p.L3_j7.isSelected()) 
				list3 += "1,,"+workmode;
			else 
				list3 += "0,,"+workmode;
			
				

			wr.write("\n" + list3);// 写入主题配置
			wr.flush();// 清除缓冲
			wr.close();// 关闭文件流

		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	public boolean rmconfig() {

		return cfile.delete();

	}

	/******************************************************************************
	 * 将文本写入至指定文件
	 ******************************************************************************/
	//
	public void save(File file, String temp) {
		try {
			// Analysis(file);//读取文件编码
			OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(file), way);
			// BufferedWriter wr = new BufferedWriter(new FileWriter(file));
			BufferedWriter wr = new BufferedWriter(outStream);
			wr.write(temp);
			wr.flush();
			wr.close();// 关闭文件流
			// System.out.println("文件流已关闭...");
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块

			e1.printStackTrace();
		}
	}

	/******************************************************************************
	 * 读取文件编码
	 ******************************************************************************/
	public int Analysis(File file) {
		@SuppressWarnings("unused")
		String temp;
		if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("srt")
				|| file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("SRT")) {
			type = 1;
			temp = type + "-srt";
		} else if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("ass")
				|| file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("ASS")) {
			type = 2;
			temp = type + "-ass";
		} else if (file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("lrc")
				|| file.getName().substring(file.getName().lastIndexOf(".") + 1).equals("LRC")) {
			type = 3;
			temp = type + "-lrc";

		} else {
			type = 0;
			temp = type + "-不受支持";

		}

		InputStream inputStream;
		byte[] head = new byte[3];
		try {
			inputStream = new FileInputStream(file);
			inputStream.read(head);
			inputStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String code = "UTF-8";

		if (head[0] == -1 && head[1] == -2) {
			code = "UTF-16";
			// System.out.println("1");
		}

		if (head[0] == -2 && head[1] == -1) {
			code = "Unicode";
			// System.out.println("2");
		}

		if (head[0] == -17 && head[1] == -69 && head[2] == -65) {
			code = "UTF-8";
			// System.out.println("3");
		}

		way = code;
		// System.out.println("文件" + temp + "编码方式为：" + way);

		return type;

	}

	/******************************************************************************
	 * 显示内容至文本区
	 ******************************************************************************/
	public void Display(MainPanel MPanel) {

		// 字体风格
		Style def = MPanel.jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def, theme.fontface);// 获取字体
		StyleConstants.setFontSize(def, theme.fontsize);// 字体大小
		Style normal = MPanel.jta.addStyle("normal", def);
		Style face = MPanel.jta.addStyle("face", normal);

		StyleConstants.setForeground(face, theme.fontcolor);// 字体颜色

		StyleConstants.setBold(def, theme.Bold); // 字体加粗
		StyleConstants.setItalic(def, theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(def, theme.Underline);// 下划线

		try {
			MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), subtitles, face);
		} catch (BadLocationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		MPanel.jta.setCaretPosition(0); // 默认显示顶端

	}

	/******************************************************************************
	 * 读取文件内容
	 ******************************************************************************/
	public String Read(File file, Boolean state, String code) {
		// Analysis(file);
		if (state)
			way = code;
		String srt = "";
		try {
			BufferedReader re = new BufferedReader(new InputStreamReader(new FileInputStream(file), way));
			BufferedReader r = new BufferedReader(re);
			String temp;
			while ((temp = r.readLine()) != null) {
				srt += (temp + "\n");
			}

			re.close();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		return srt;
	}

	/******************************************************************************
	 * 解析时间轴相关信息
	 ******************************************************************************/
	public String[] extime(String subtitles, int type) {

		String[] temp = new String[3];
		String[] list;
		int number = 0;
		boolean st = false;
		switch (type) {
		case 1:// srt

			list = subtitles.split("\n");
			String regex1 = "\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d --> \\d\\d:\\d\\d:\\d\\d,\\d\\d\\d";
			for (int i = 0; i < list.length; i++) {
				if (!Pattern.matches(regex1, list[i]))
					continue;
				else {
					number++;
					if (!st) {
						temp[0] = list[i].substring(0, 2) + ":" + list[i].substring(3, 5) + ":"
								+ list[i].substring(6, 8) + "," + list[i].substring(9, 12);
						st = true;
					} else

						temp[1] = list[i].substring(17, 19) + ":" + list[i].substring(20, 22) + ":"
								+ list[i].substring(23, 25) + "," + list[i].substring(26, 29);

				}
			}
			st = false;
			temp[2] = number + "";
			number = 0;
			break;
		case 2:// ass 0,0:07:38.34,0:07:40.13

			list = subtitles.split("\n");
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() < 33 || !(list[i].substring(0, 8).equals("Dialogue")))
					continue;// ֱ�ӽ�����һ��ѭ��

				else {
					number++;
					if (!st) {

						temp[0] = list[i].substring(12, 13) + ":" + list[i].substring(14, 16) + ":"
								+ list[i].substring(17, 19) + "." + list[i].substring(20, 22);
						st = true;
					} else

						temp[1] = list[i].substring(23, 24) + ":" + list[i].substring(25, 27) + ":"
								+ list[i].substring(28, 30) + "." + list[i].substring(31, 33);

				}
			}
			st = false;
			temp[2] = number + "";
			number = 0;
			break;
		case 3: // lrc

			String regex3 = "\\d\\d:\\d\\d.\\d\\d";
			list = subtitles.split("\n");
			for (int i = 0; i < list.length; i++) {
				//System.out.println(list[i].substring(1, 9));
				if (!Pattern.matches(regex3, list[i].substring(1, 9)))
					continue;
				else {
					number++;
					if (!st) {

						temp[0] = list[i].substring(1, 3) + ":" + list[i].substring(4, 6) + "."
								+ list[i].substring(7, 9);
						st = true;
					} else
						temp[1] = list[i].substring(1, 3) + ":" + list[i].substring(4, 6) + "."
								+ list[i].substring(7, 9);

				}
			}
			st = false;
			temp[2] = number + "";
			number = 0;
			break;

		default:
			temp[0] = "暂无信息";
			temp[1] = "暂无信息";
			temp[2] = "暂无信息";
			st = false;
			number = 0;
			break;
		}

		return temp;

	}

	/******************************************************************************
	 * 时间轴对齐
	 ******************************************************************************/
	public String Revise(String temp, String time) {
		// 参数1为文件类型，参数2为字幕文本内容，参数3为新时间

		String[] list;
		String newsub = "";
		long timeError;
		switch (type) {
		case 1:// srt
			newsub = "";
			list = temp.split("\n");
			String regex1 = "\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d --> \\d\\d:\\d\\d:\\d\\d,\\d\\d\\d";
			for (int i = 0; i < list.length; i++) {
				if (!Pattern.matches(regex1, list[i]))
					continue;
				else {
					// System.out.println(list[i]);
					int millisecond = Integer.parseInt(list[i].substring(9, 12));
					int second = Integer.parseInt(list[i].substring(6, 8));
					int minute = Integer.parseInt(list[i].substring(3, 5));
					int hour = Integer.parseInt(list[i].substring(0, 2));
					StartTime = (hour * 3600 + minute * 60 + second) * 1000 + millisecond;
					// System.out.println("时间轴起点"+hour+":"+minute+":"+second+","+millisecond+"
					// 合计"+StartTime );
					break;
				}
			} // 正则表达式匹配，找到时间轴起点

			// 计算时间差值
			timeError = (Integer.parseInt(time.substring(0, 2))) * 3600000
					+ (Integer.parseInt(time.substring(3, 5))) * 60000 + (Integer.parseInt(time.substring(6, 8))) * 1000
					+ (Integer.parseInt(time.substring(9, 12))) - StartTime;

			// System.out.println("时间差值"+timeError+"毫秒");

			for (int j = 0; j < list.length; j++) {
				if (!Pattern.matches(regex1, list[j])) {
					newsub += list[j] + "\n";
					continue;
				} else {

					int ms = Integer.parseInt(list[j].substring(9, 12));
					int s = Integer.parseInt(list[j].substring(6, 8));
					int m = Integer.parseInt(list[j].substring(3, 5));
					int h = Integer.parseInt(list[j].substring(0, 2));

					String h1 = "" + ((timeError + ms + s * 1000 + m * 60000 + h * 3600000) / 3600000);
					String m1 = "" + (((timeError + ms + s * 1000 + m * 60000 + h * 3600000) % 3600000) / 60000);
					String s1 = "" + ((timeError + ms + s * 1000 + m * 60000 + h * 3600000) % 60000 / 1000);
					String ms1 = "" + ((timeError + ms + s * 1000 + m * 60000 + h * 3600000) % 1000);

					int ms2 = Integer.parseInt(list[j].substring(26, 29));
					int s2 = Integer.parseInt(list[j].substring(23, 25));
					int m2 = Integer.parseInt(list[j].substring(20, 22));
					int h2 = Integer.parseInt(list[j].substring(17, 19));

					String h3 = "" + ((timeError + ms2 + s2 * 1000 + m2 * 60000 + h2 * 3600000) / 3600000);
					String m3 = "" + (((timeError + ms2 + s2 * 1000 + m2 * 60000 + h2 * 3600000) % 3600000) / 60000);
					String s3 = "" + ((timeError + ms2 + s2 * 1000 + m2 * 60000 + h2 * 3600000) % 60000 / 1000);
					String ms3 = "" + ((timeError + ms2 + s2 * 1000 + m2 * 60000 + h2 * 3600000) % 1000);

					if (h1.length() == 1)
						h1 = "0" + h1;
					newsub += h1 + ":";
					if (m1.length() == 1)
						m1 = "0" + m1;
					newsub += m1 + ":";
					if (s1.length() == 1)
						s1 = "0" + s1;
					newsub += s1 + ",";

					if (ms1.length() == 1)
						ms1 = "00" + s1;
					if (ms1.length() == 2)
						ms1 = "0" + ms1;
					newsub += ms1 + list[j].substring(12, 17);

					if (h3.length() == 1)
						h3 = "0" + h3;
					newsub += h3 + ":";
					if (m3.length() == 1)
						m3 = "0" + m3;
					newsub += m3 + ":";
					if (s3.length() == 1)
						s3 = "0" + s3;
					newsub += s3 + ",";

					if (ms3.length() == 1)
						ms3 = "00" + ms3;
					if (ms3.length() == 2)
						ms3 = "0" + ms3;
					newsub += ms3 + "\n";

				}
			}
			return newsub;

		case 2:// ass 0,0:07:38.34,0:07:40.13

			newsub = "";
			list = temp.split("\n");
			for (int i = 0; i < list.length; i++) {
				if (list[i].length() < 33 || !(list[i].substring(0, 8).equals("Dialogue")))
					continue;
				else {
					int millisecond = Integer.parseInt(list[i].substring(20, 22));
					int second = Integer.parseInt(list[i].substring(17, 19));
					int minute = Integer.parseInt(list[i].substring(14, 16));
					int hour = Integer.parseInt(list[i].substring(12, 13));
					StartTime = millisecond + second * 100 + minute * 6000 + hour * 360000; // ��Ļ��ʼʱ��

					break;
				}
			}

			timeError = (Integer.parseInt(time.substring(0, 1))) * 360000 // ����ʱ���ֵ
					+ (Integer.parseInt(time.substring(2, 4))) * 6000 + (Integer.parseInt(time.substring(5, 7))) * 100
					+ (Integer.parseInt(time.substring(8, 10))) - StartTime;

			for (int j = 0; j < list.length; j++) {
				if (list[j].length() < 33 || !(list[j].substring(0, 8).equals("Dialogue"))) {
					newsub += list[j] + "\n";
					continue;
				} else {

					int ms = Integer.parseInt(list[j].substring(20, 22));
					int s = Integer.parseInt(list[j].substring(17, 19));
					int m = Integer.parseInt(list[j].substring(14, 16));
					int h = Integer.parseInt(list[j].substring(12, 13));

					String h1 = "" + ((timeError + ms + s * 100 + m * 6000 + h * 360000) / 360000);
					String m1 = "" + (((timeError + ms + s * 100 + m * 6000 + h * 360000) % 360000) / 6000);
					String s1 = "" + ((timeError + ms + s * 100 + m * 6000 + h * 360000) % 6000 / 100);
					String ms1 = "" + ((timeError + ms + s * 100 + m * 6000 + h * 360000) % 100);

					int ms2 = Integer.parseInt(list[j].substring(31, 33));
					int s2 = Integer.parseInt(list[j].substring(28, 30));
					int m2 = Integer.parseInt(list[j].substring(25, 27));
					int h2 = Integer.parseInt(list[j].substring(23, 24));

					String h3 = "" + ((timeError + ms2 + s2 * 100 + m2 * 6000 + h2 * 360000) / 360000);
					String m3 = "" + (((timeError + ms2 + s2 * 100 + m2 * 6000 + h2 * 360000) % 360000) / 6000);
					String s3 = "" + ((timeError + ms2 + s2 * 100 + m2 * 6000 + h2 * 360000) % 6000 / 100);
					String ms3 = "" + ((timeError + ms2 + s2 * 100 + m2 * 6000 + h2 * 360000) % 100);

					newsub += list[j].substring(0, 12) + h1 + ":";
					if (m1.length() == 1)
						m1 = "0" + m1;
					newsub += m1 + ":";
					if (s1.length() == 1)
						s1 = "0" + s1;
					newsub += s1 + ".";
					if (ms1.length() == 1)
						ms1 = "0" + s1;
					newsub += ms1 + ",";

					newsub += h3 + ":";
					if (m3.length() == 1)
						m3 = "0" + m3;
					newsub += m3 + ":";
					if (s3.length() == 1)
						s3 = "0" + s3;
					newsub += s3 + ".";

					if (ms3.length() == 1)
						ms3 = "0" + s3;

					newsub += ms3 + list[j].substring(33, list[j].length()) + "\n";
				}
			}
			return newsub;
			
			
		case 3: // lrc
			String regex3 = "\\d\\d:\\d\\d.\\d\\d";
			newsub = "";
			list = temp.split("\n");
			for (int i = 0; i < list.length; i++) {
				//System.out.println(list[i].substring(1, 9));
				if (!Pattern.matches(regex3, list[i].substring(0, 9)))
					continue;
				else {
					int ms = Integer.parseInt(list[i].substring(7, 9));
					int s = Integer.parseInt(list[i].substring(4, 6));
					int m = Integer.parseInt(list[i].substring(1, 3));
					StartTime = ms + s * 100 + m * 6000; // ��Ļ��ʼʱ��

					break;
				}
			}

			timeError = (Integer.parseInt(time.substring(0, 2))) * 6000 + (Integer.parseInt(time.substring(3, 5))) * 100
					+ (Integer.parseInt(time.substring(6, 8))) - StartTime;

			for (int j = 0; j < list.length; j++) {
				if (list[j].length() < 9) {
					newsub += list[j] + "\n";
					continue;
				} else if (!Pattern.matches(regex3, list[j].substring(1, 9))) {
					newsub += list[j] + "\n";
					continue;

				} else {

					int ms = Integer.parseInt(list[j].substring(7, 9));
					int s = Integer.parseInt(list[j].substring(4, 6));
					int m = Integer.parseInt(list[j].substring(1, 3));

					String m1 = "" + ((timeError + ms + s * 100 + m * 6000) / 6000);
					String s1 = "" + (((timeError + ms + s * 100 + m * 6000) % 6000) / 100);
					String ms1 = "" + ((timeError + ms + s * 100 + m * 6000) % 100);

					if (m1.length() == 1)
						m1 = "[" + "0" + m1;
					newsub += m1 + ":";
					if (s1.length() == 1)
						s1 = "0" + s1;
					newsub += s1 + ".";
					if (ms1.length() == 1)
						ms1 = "0" + ms1;
					newsub += ms1 + "]";

					newsub += list[j].substring(10, list[j].length()) + "\n";
				}
			}

			return newsub;
		default:
			return null;
		}

	}

	// 打开文件
	public File openfile(JFrame f) {

		File file = null;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("目前已支持ASS、SRT、LRC格式", "srt", "ass", "lrc", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(f.getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		} else {
			if (type == 0)
				System.exit(0);
			else
				return null;
		}
		return file;
	}

	//打开一个文件夹选择对话框，并返回选中的文件夹路径
	public String select(JFrame f) {
		try {
			JFileChooser jfc=new JFileChooser();  
	        //设置当前路径为桌面路径,否则将我的文档作为默认路径
	        FileSystemView fsv = FileSystemView .getFileSystemView();
	        jfc.setCurrentDirectory(fsv.getHomeDirectory());
	        //JFileChooser.FILES_AND_DIRECTORIES 选择路径和文件
	        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY );  
	        //弹出的提示框的标题
	        jfc.showDialog(new JLabel(), "确定");  
	        //用户选择的路径或文件
	        File file=jfc.getSelectedFile();  
	        String path=file.getPath();
		    //System.out.println("path: "+path);
	        return  path ;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
 
	}

	
	
	
	
	/******************************************************************************
	 * 替换
	 * 
	 * @throws BadLocationException
	 ******************************************************************************/
	public int replace(JFrame f,MainPanel MPanel, String temp, String temp2, boolean b1, boolean b2, boolean b3, boolean b4) {

		/*
		 * *b1--区分大小写 *b2--正则表达式 *b3--单步操作 *b4--智能过滤
		 */
		Style def = MPanel.jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def, theme.fontface);
		StyleConstants.setFontSize(def, theme.fontsize);
		Style normal = MPanel.jta.addStyle("normal", def);
		Style face = MPanel.jta.addStyle("face", normal);

		Style red = MPanel.jta.addStyle("red", normal);
		StyleConstants.setForeground(red, Color.red);
		StyleConstants.setBold(normal, theme.Bold); // 字体加粗
		StyleConstants.setItalic(normal, theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(normal, theme.Underline);// 下划线

		StyleConstants.setForeground(face, theme.fontcolor);
		StyleConstants.setBold(def, theme.Bold); // 字体加粗
		StyleConstants.setItalic(def, theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(def, theme.Underline);// 下划线

		String Result=seek(MPanel, temp, true);
		if(Result==null) {
			
			return -2;
		}
		String[] poslist = Result.split("\n");
		String[] list = subtitles.split("\n");// 逐行存入
		int pos=0;
		int renum=0;
		// 解析返回结果
		int line[] = new int[poslist.length];
		int seat[] = new int[poslist.length];
		for (int i = 0; i < poslist.length; i++) {
			line[i] = Integer.parseInt(poslist[i].split(":")[0]);// 获得行
			seat[i] = Integer.parseInt(poslist[i].split(":")[1]);// 获得位置
		}

		MPanel.jta.setText("");// 清空
		if (b3) {// 单步操作
			if (Key.equals(temp)) {
				// 如关键字没有改变
				for (int i = 0; i < list.length; i++) {
					boolean s = false;
					try {

						if (i == line[num]) {
							if(s!=true) {
							s = true;
							renum=pos+seat[num];
							//System.out.println("已找到第"+num+"个关键字"+s);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(0, seat[num]), face);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), temp2, red);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(seat[num] + temp.length(), list[i].length()) + "\n", face);
							}
							}else {
							//if(st)
							pos+=list[i].length();
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), list[i] + "\n",
									face);
						}

					} catch (BadLocationException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();

					}

				}
				if(num==poslist.length-1) {
					System.out.println("已到达文档尾");
					num=0;
					//subtitles=MPanel.jta.getText();
					return -1;
				}else {
					//num++;
					//subtitles=MPanel.jta.getText();
					return renum;
				}
				
				
			} else {
				// 如关键字被改变
				System.out.println("关键字被改变");
				Key = temp;
				num=0;
				replace(f, MPanel, temp, temp2, b1, b2, b3, b4);

			}

		} else {// 全局查找
			// 获取关键字位置列表
			// String[] poslist = seek(MPanel, temp, true).split("\n");
			boolean st = false;
			// 遍历
			for (int i = 0; i < list.length; i++) {

				try {

					// 遍历匹配
					for (int j = 0; j < line.length; j++) {
						if (i == line[j]) {
							st = true;
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(0, seat[j]), face);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), temp2, red);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(seat[j] + temp.length(), list[i].length()) + "\n", face);
							break;
						}
					}
					if (st)
						st = false;
					else
						MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), list[i] + "\n",
								face);

				} catch (BadLocationException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			MPanel.jta.setCaretPosition(0);
			//subtitles=MPanel.jta.getText();
			return poslist.length;
		}
		return 0;
		// 字体风格
	
	}

	/******************************************************************************
	 * 搜索
	 * 
	 * @param theme
	 * @return
	 * @throws BadLocationException
	 ******************************************************************************/
	public int search(MainPanel MPanel, String temp, boolean stype,boolean b4) {

		//String subtitle = MPanel.jta.getText();
		//MPanel.jta.setText("");

		Style def = MPanel.jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def, theme.fontface);
		StyleConstants.setFontSize(def, theme.fontsize);
		Style normal = MPanel.jta.addStyle("normal", def);
		Style face = MPanel.jta.addStyle("face", normal);

		Style red = MPanel.jta.addStyle("red", normal);
		StyleConstants.setForeground(red, Color.red);
		StyleConstants.setBold(normal, theme.Bold); // 字体加粗
		StyleConstants.setItalic(normal, theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(normal, theme.Underline);// 下划线

		StyleConstants.setForeground(face, theme.fontcolor);
		StyleConstants.setBold(def, theme.Bold); // 字体加粗
		StyleConstants.setItalic(def, theme.Italic);// 字体倾斜
		StyleConstants.setUnderline(def, theme.Underline);// 下划线

		String Result=seek(MPanel, temp, b4);
		if(Result==null) {
			
			return -2;
		}
		String[] poslist = Result.split("\n");
		String[] list = subtitles.split("\n");// 逐行存入
		int pos=0;
		int renum=0;
		// 解析返回结果
		int line[] = new int[poslist.length];
		int seat[] = new int[poslist.length];
		for (int i = 0; i < poslist.length; i++) {
			line[i] = Integer.parseInt(poslist[i].split(":")[0]);// 获得行
			seat[i] = Integer.parseInt(poslist[i].split(":")[1]);// 获得位置
		}

		MPanel.jta.setText("");// 清空
		if (stype) {// 单步查找
			if (Key.equals(temp)) {
				// 如关键字没有改变
				for (int i = 0; i < list.length; i++) {
					boolean s = false;
					try {

						if (i == line[num]) {
							if(s!=true) {
							s = true;
							renum=pos+seat[num];
							System.out.println("已找到第"+num+"个关键字"+s);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(0, seat[num]), face);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), temp, red);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(seat[num] + temp.length(), list[i].length()) + "\n", face);
							}
							}else {
							//if(st)
							pos+=list[i].length();
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), list[i] + "\n",
									face);
						}

					} catch (BadLocationException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();

					}

				}
				if(num==poslist.length-1) {
					System.out.println("已到达文档尾");
					num=0;
					return -1;
				}else {
					num++;
					return renum;
				}
				
				
			} else {
				// 如关键字被改变
				System.out.println("关键字被改变");
				Key = temp;
				num=0;
				search(MPanel, temp, stype,b4);

			}

		} else {// 全局查找
			// 获取关键字位置列表
			// String[] poslist = seek(MPanel, temp, true).split("\n");
			boolean st = false;
			// 遍历
			for (int i = 0; i < list.length; i++) {

				try {

					// 遍历匹配
					for (int j = 0; j < line.length; j++) {
						if (i == line[j]) {
							st = true;
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(0, seat[j]), face);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), temp, red);
							MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(),
									list[i].substring(seat[j] + temp.length(), list[i].length()) + "\n", face);
							break;
						}
					}
					if (st)
						st = false;
					else
						MPanel.jta.getDocument().insertString(MPanel.jta.getDocument().getLength(), list[i] + "\n",
								face);

				} catch (BadLocationException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			MPanel.jta.setCaretPosition(0);
			return poslist.length;
		}
		return 0;
	}

	/*
	 * =============================================================================
	 * 根据关键字在文本中查找，返回关键字位置
	 * =============================================================================
	 */

	public String seek(MainPanel MPanel, String temp, boolean b4) {

		// 正则表达式
		String regex1 = "\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d --> \\d\\d:\\d\\d:\\d\\d,\\d\\d\\d";
		String[] list = subtitles.split("\n");// 逐行存入
		String pos = "";// 记录关键字位置
		boolean s=false;
		// int position = 0;
		// 遍历
		for (int i = 0; i < list.length; i++) {

			// ==智能过滤规则==
			if (b4) {
				switch (type) {
				case 1:// srt
						// 过滤时间轴相关行
					if (Pattern.matches(regex1, list[i])) {
						// newSubtitles+=list[i];
						// position+=list[i].length();//位置累加
						continue;
					}
					break;

				case 2:// ass
						// 过滤时间轴相关行
					if (list[i].length() < 33 || !(list[i].substring(0, 8).equals("Dialogue"))) {
						// newSubtitles+=list[i];
						// position+=list[i].length();//位置累加
						continue;
					}
					break;

				case 3:// lrc
					break;
				default:
					break;
				}

			} else {// ==全局过滤规则==
				if (list[i].length() < temp.length()) {
					// newSubtitles+=list[i];
					// position+=list[i].length();//位置累加
					continue;
				}
			}

			// 计算比较次数
			int n = list[i].length() - temp.length() + 1;
			// 暴力遍历
			for (int j = 0; j < n; j++) {

				if ((list[i].substring(j, j + temp.length())).equals(temp)) {
					// 命中
					// pos+=position+j+"\n";//记录关键字位置
					pos += i + ":" + j + "\n";// 记录关键字位置信息，包括行号和所在位置
					j = j + temp.length();// 计算下次比较位置
					s=true;//表示至少命中一次，即存在关键字
				}
			}
			// position+=list[i].length();

		}
		if(s)
			return pos;
		else
			return null;

	}

}
