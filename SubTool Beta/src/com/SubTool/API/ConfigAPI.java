package com.SubTool.API;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class ConfigAPI {

	public boolean t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12,t13;
	public int v1, v2, v3, v4, v5, v6, v7, v8;
	public Color sidecolor;
	public Color maincolor;
	public Color fontolor;
	public String workmod;
	
	
	
	public ConfigAPI() {
		// TODO 自动生成的构造函数存根
		
	}

	/**
	 * 读取配置文件
	 */
	public ConfigAPI reconfig() {
		//CONFIG config=new CONFIG();
		File cfile = new File(System.getProperty("user.dir") + "\\config.in");
		try {
			if (!cfile.exists()) {// 配置文件不存在
				System.out.println("配置文件不存在，已重新生成");
				cfile.createNewFile();
				return null;
			} else {

				System.out.println("配置文件存在，已读取");
				BufferedReader re = new BufferedReader(new InputStreamReader(new FileInputStream(cfile), "UTF-8"));
				BufferedReader r = new BufferedReader(re);
				r.readLine();// 跳过第一行

				// 主题设置
				String[] list1 = r.readLine().split(",,");
				if (Integer.parseInt(list1[0]) == 0)
					t1 = false;// 主题混搭开关
				else
					t1 = true;
				v1 = Integer.parseInt(list1[1]);// 主题序号
				if (Integer.parseInt(list1[2]) == 1)
					t2 = true;
				else
					t2 = false;
				v2 = Integer.parseInt(list1[3]);
				sidecolor = new Color(Integer.parseInt(list1[4].split(",")[0]),
						Integer.parseInt(list1[4].split(",")[1]), Integer.parseInt(list1[4].split(",")[2]),
						Integer.parseInt(list1[4].split(",")[3]));

				if (Integer.parseInt(list1[5]) == 0)
					t3 = false;
				else
					t3 = true;
				v3 = Integer.parseInt(list1[6]);
				maincolor = new Color(Integer.parseInt(list1[7].split(",")[0]),
						Integer.parseInt(list1[7].split(",")[1]), Integer.parseInt(list1[7].split(",")[2]),
						Integer.parseInt(list1[7].split(",")[3]));

				// 浏览设置
				String[] list2 = r.readLine().split(",,");
				v4 = Integer.parseInt(list2[0]);// 字体
				v5 = Integer.parseInt(list2[1]);// 大小
				if (Integer.parseInt(list2[2]) == 1) {// 自定色
					t4 = true;
					fontolor = new Color(Integer.parseInt(list2[4].split(",")[0]),
							Integer.parseInt(list2[4].split(",")[1]), Integer.parseInt(list2[4].split(",")[2]),
							Integer.parseInt(list2[4].split(",")[3]));
				} else {
					t4 = false;
					fontolor = new Color(0, 0, 0, 255);
				}
				v6 = Integer.parseInt(list2[3]);// 字体颜色
				if (Integer.parseInt(list2[5]) == 1) {// 组合风
					t5 = true;
					if (Integer.parseInt(list2[7]) == 1)
						t6 = true;
					else
						t6 = false;
					if (Integer.parseInt(list2[8]) == 1)
						t7 = true;
					else
						t7 = false;
					if (Integer.parseInt(list2[9]) == 1)
						t8 = true;
					else
						t8 = false;
				}
				v7 = Integer.parseInt(list2[6]);

				// 功能设置
				String[] list3 = r.readLine().split(",,");
				//for(int i=0;i<list3.length;i++)
				//	System.out.println(list3[i]);
				//System.out.println(list3[6]);
				if (Integer.parseInt(list3[0]) == 1)
					t9 = true;
				else
					t9 = false;
				if (Integer.parseInt(list3[1]) == 1)
					t10 = true;
				else
					t10 = false;
				v8 = Integer.parseInt(list3[2]);
				if (Integer.parseInt(list3[3]) == 1)
					t11 = true;
				else
					t11 = false;
				if (Integer.parseInt(list3[4]) == 1)
					t12 = true;
				else
					t12 = false;
				if (Integer.parseInt(list3[5]) == 1)
					t13 = true;
				else
					t13 = false;
				//System.out.println("工作空间："+list3[6]);
				workmod=list3[6];
				re.close();// 关闭文件流
				return this;

			}
		} catch (IOException e) {
			// TODO 文件读取异常
			System.out.println("文件读取异常");
			return null;
			// e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			// 文件格式错误
			System.out.println("配置文件格式错误。。");
			return null;
		}

	}
	
	
	
}
