package com.SubTool.Start;

import java.awt.Color;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;
import com.SubTool.API.ColorAPI;
import com.SubTool.API.ConfigAPI;
import com.SubTool.API.DataAPI;
import com.SubTool.API.FunctionAPI;
import com.SubTool.API.ViewAPI;
import com.SubTool.Log.UpdateLog;
import com.SubTool.Mod.Informations;
import com.SubTool.Mod.Replace;
import com.SubTool.Mod.Timeline;
import com.SubTool.UI.About;
import com.SubTool.UI.Help;
import com.SubTool.UI.MainPanel;
import com.SubTool.UI.Setting;
import com.SubTool.UI.Side;




public class Lanuch {

	private JFrame f;
	private ViewAPI api;
	private DataAPI data;
	private ColorAPI color;
	private Side SidePanel;
	private Setting setting;
	private About about;
	private Help help;
	private UpdateLog log;
	private MainPanel MPanel;
	private Informations St_Mod;
	private Timeline Tl_Mod;
	private Replace Re_Mod;

	
	public Lanuch(File file,ConfigAPI config) {

		if (file == null)
			new lanuch().UI(new DataAPI(f, null).openfile(f),config);
		else {

			if (file.exists()) {
				new lanuch().UI(file,config);
			} else 
				System.exit(0);
		}

	}

	
	
	
	class lanuch {
		public void UI(File file,ConfigAPI config) {
			
			//初始化界面
			f=new JFrame();
			//THEME Theme=new THEME();
			
			api=new ViewAPI(f);
			data=new DataAPI(f,file);
			color=new ColorAPI();
			
			about=new About(f, data);
			help=new Help(api);
			log=new UpdateLog(data, api);
			

			f.setBounds(0, 0, 1200, 680); 
			f.setResizable(false); //禁用最大化
			f.setLocationRelativeTo(null);//窗体设置屏幕中央
			f.setUndecorated(true);//取消系统标题栏（边框）
			f.setLayout(null); 
			f.setVisible(true);
			api.titlebar(f, f.getWidth(), 40, 0);
			UIManager.put("Button.select", new Color(255, 255, 255, 0));// 全局按钮按下时颜色
			
			
			if(config==null) {//检测配置文件
				//System.out.println("未检测到配置文件，载入程序预设");
				setting=new Setting(f, null, api, data, color);
				switch (data.type) {
				case 1:
					data.theme.fontsize = 18;
					setting.L1_j2.setSelectedIndex(data.theme.fontsize - 10);// 载入预设字体大小
					break;
				case 2:
					data.theme.fontsize = 16;
					setting.L1_j2.setSelectedIndex(data.theme.fontsize - 10);// 载入预设字体大小
					break;
				case 3:
					data.theme.fontsize = 20;
					setting.L1_j2.setSelectedIndex(data.theme.fontsize - 10);// 载入预设字体大小
					break;

				default:// 默认类型
					data.theme.fontsize = 20;
					setting.L1_j2.setSelectedIndex(data.theme.fontsize - 10);// 载入预设字体大小
					break;
				}
				
			}else {
				//System.out.println("配置文件存在");
				setting=new Setting(f, config, api, data, color);
				
			}
			api.SetTheme(setting, data, color, MPanel, f);
			//创建主面板及侧栏
			MPanel=new MainPanel(f, api, data);
			SidePanel=new Side(f, data, api);
			f.getLayeredPane().add(MPanel, new Integer(0)); 
			f.getLayeredPane().add(SidePanel, new Integer(1)); 
			//jp.add(MPanel);
			//jp.add(SidePanel);
			//读取文件至主界面文本区
			data.subtitles=data.Read(file, setting.L3_j2.isSelected(), (String) setting.L3_j3.getSelectedItem());
			data.Display(MPanel);
			
			//api.Refresh(data, SidePanel, MPanel);
			MPanel.add(setting);			
			//new Message(f, "侧边", 2000).start();
			
			MPanel.add(about); 
			MPanel.add(help);
			MPanel.add(log);
			
			St_Mod=new Informations(f, MPanel, data,api);
			MPanel.jp_Mod.add(St_Mod);
			Tl_Mod=new Timeline(f, MPanel, data, api);
			MPanel.jp_Mod.add(Tl_Mod);
			Re_Mod=new Replace(data, api, MPanel, f);
			MPanel.jp_Mod.add(Re_Mod);
			
			new FunctionAPI(f, data, api, color, SidePanel, MPanel, setting, about, help, log, St_Mod, Tl_Mod, Re_Mod);
		}

	}
	

	
	
	
	
	
}
