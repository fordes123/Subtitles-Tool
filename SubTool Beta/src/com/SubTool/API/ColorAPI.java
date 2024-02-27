package com.SubTool.API;

import java.awt.Color;

public class ColorAPI {
	
	private String scname;//side颜色名列表
	private String sc;//side颜色代码列表
	private String fcname;//字体颜色名列表
	private String fc;//字体颜色代码列表
	private String mcname;//主界面颜色名列表
	private String mc;//主界面颜色代码列表
	

	public ColorAPI() {
		// TODO 自动生成的构造函数存根
		scname="默认黑\n"+"火岩棕\n"+ "深海绿\n"+ "卷轴黄\n"+"水鸭青\n"+"栗紫\n"+ "海报灰\n";
		sc="49,54,56,255\n"+"72,51,50,255\n"+"26,59,50,255\n"+"57,55,51,255\n"+"40,89,67,255\n"+"90,25,27,255\n"+"64,81,78,255\n";
		fcname="默认黑\n"+      "海涛蓝\n"+        "基佬紫\n"+          "高粱红\n"+         "深海绿\n"+        "海报灰\n"+        "芒果棕\n";
		fc="0,0,0,255\n"+"21,85,154,255\n"+"155,30,100,255\n"+"192,44,56,255\n"+"26,59,50,255\n"+"72,51,50,255\n"+"149,68,22,255\n";	
		mcname="默认白\n"+"卷轴黄\n"+"皎月白\n";
		mc="240,240,240,255\n"+"233,222,180,255\n"+"255,255,255,255\n";
	}

	//根据侧栏颜色名返回对应颜色代码
	public Color RSC(String temp) {
		
		String[] cnlist=scname.split("\n");
		String[] clist=sc.split("\n");
		
		for(int i=0;i<cnlist.length;i++) {
			if(temp.equals(cnlist[i]))
			{
				return new Color(Integer.parseInt(clist[i].split(",")[0]),Integer.parseInt(clist[i].split(",")[1]),Integer.parseInt(clist[i].split(",")[2]),Integer.parseInt(clist[i].split(",")[3]));
				}
		}
		//默认返回值
		return null;
	}
	
	//根据侧栏颜色名返回对应颜色代码
	public Color RFC(String temp) {
		
		String[] fnlist=fcname.split("\n");
		String[] flist=fc.split("\n");
		
		for(int i=0;i<fnlist.length;i++) {
			if(temp.equals(fnlist[i]))
			{
				return new Color(Integer.parseInt(flist[i].split(",")[0]),Integer.parseInt(flist[i].split(",")[1]),Integer.parseInt(flist[i].split(",")[2]),Integer.parseInt(flist[i].split(",")[3]));
				}
		}
		//默认返回值
		return null;
	}

	//根据主界面颜色名返回对应颜色代码
	public Color RMC(String temp) {
		
		String[] mnlist=mcname.split("\n");
		String[] mlist=mc.split("\n");
		
		
		for(int i=0;i<mnlist.length;i++) {
			if(temp.equals(mnlist[i]))
			{
				return new Color(Integer.parseInt(mlist[i].split(",")[0]),Integer.parseInt(mlist[i].split(",")[1]),Integer.parseInt(mlist[i].split(",")[2]),Integer.parseInt(mlist[i].split(",")[3]));
				}
		}
		//默认返回值
		return null;
	}	
	
	//返回侧栏颜色列表
	public String[] RSL() {//read side color list
		return scname.split("\n");
	}
	//返回字体颜色列表
	public String[] RFL() {//read font color list
		return fcname.split("\n");
	}
	//返回主界面颜色列表
	public String[] RML() {//read font color list
		return mcname.split("\n");
	}
}
