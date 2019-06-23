package com.SubTool.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.SubTool.API.DataAPI;
import com.SubTool.API.ViewAPI;
import com.SubTool.API.ViewAPI.UserTextField;

public class Side extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8350819795786602932L;

	// 全局变量

	//ViewAPI api = new ViewAPI();
	//DataAPI data = new DataAPI();

	public UserTextField jt_Search;
	public JLabel jl_Title, jl_Version, jl_Free_Title, jl_Timeline_Title, jl_Replace_Title, jl_Statistics_Title, jl_More_Title, jl_Dock_Title;
	public JButton jb_Menu, jb_Free,jb_Timeline,jb_Replace,jb_Statistics,jb_Search_Button,jb_More,jb_Setting, jb_Setting_Dock, jb_Save, jb_Delete, jb_Open,jb_Return;

	
	public boolean side_state = false;

	public Side(JFrame f,DataAPI data,ViewAPI api) {
		// TODO 自动生成的构造函数存根

		this.setBounds(0, 0, 60, 680);
		this.setBackground(data.theme.sidecolor);
		this.setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		/*侧栏菜单按钮*/
		jb_Menu = new JButton();
		jb_Menu.setBounds(10, 65, 42, 42);
		api.setIcon("/res/menu.png", jb_Menu, 42, 42);
		jb_Menu.setOpaque(false); // 透明
		jb_Menu.setBorder(null); // 颜色为空
		jb_Menu.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Menu.setFocusPainted(false);// 去除按钮点击焦点
		// f.getLayeredPane().add(jb0);
		add(jb_Menu);

		// 侧栏标题
		jl_Title = new JLabel();
		add(jl_Title);
		jl_Title.setText("Subtitles Tool");
		jl_Title.setFont(new Font("华文细黑", 1, 27));
		jl_Title.setForeground(Color.white);
		jl_Title.setBounds(16, 7, 380, 40);
		jl_Title.setVisible(false);

		// 版本号
		jl_Version = new JLabel("◎测试版" + data.Version(1));
		jl_Version.setFont(new Font("华文细黑", 0, 14));
		jl_Version.setForeground(Color.white);
		jl_Version.setBounds(16, 42, 380, 20);
		add(jl_Version);
		jl_Version.setVisible(false);

		// 搜索框
		ImageIcon icon = new ImageIcon(ViewAPI.class.getResource("/res/sou.png")); // 图标
		jt_Search = api.new UserTextField(20, icon);
		jt_Search.setBounds(16, 560, 260, 40);
		jt_Search.setFont(new Font("华文细黑", 0, 20));
		jt_Search.setForeground(Color.white);
		jt_Search.setCaretColor(Color.WHITE); //光标颜色
		jt_Search.setOpaque(false); // 透明
		add(jt_Search);
		// f.setFocusable(true); // 让面板获得焦点
		jt_Search.setText("Search");
		jt_Search.setVisible(false);

		//自由修改
		jb_Free = new JButton();
		jb_Free.setBounds(16, 140, 28, 28);
		api.setIcon("/res/view4.png", jb_Free, 28, 28);
		jb_Free.setOpaque(false); // 透明
		jb_Free.setBorder(null); // 颜色为空
		jb_Free.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Free.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Free);
		

		jl_Free_Title = new JLabel("自由修改");
		jl_Free_Title.setFont(new Font("华文细黑", 0, 21));
		jl_Free_Title.setForeground(Color.white);
		jl_Free_Title.setBounds(60, 138, 200, 30);
		jl_Free_Title.setVisible(false);
		add(jl_Free_Title);

		// 时间对齐
		jb_Timeline = new JButton();
		jb_Timeline.setBounds(14, 200, 32, 32);
		api.setIcon("/res/view5.png", jb_Timeline, 32, 32);
		jb_Timeline.setOpaque(false); // 透明
		jb_Timeline.setBorder(null); // 颜色为空
		jb_Timeline.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Timeline.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Timeline);
		

		jl_Timeline_Title = new JLabel("时间轴对齐");
		jl_Timeline_Title.setFont(new Font("华文细黑", 0, 20));
		jl_Timeline_Title.setForeground(Color.white);
		jl_Timeline_Title.setBounds(60, 198, 200, 30);
		jl_Timeline_Title.setVisible(false);
		add(jl_Timeline_Title);

		// =================================关键字替换====================================
		
		jb_Replace = new JButton();
		jb_Replace.setBounds(16, 260, 30, 30);
		api.setIcon("/res/view6.png", jb_Replace, 30, 30);
		jb_Replace.setOpaque(false); // 透明
		jb_Replace.setBorder(null); // 颜色为空
		jb_Replace.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Replace.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Replace);
		
		jl_Replace_Title = new JLabel("关键字替换");
		jl_Replace_Title.setFont(new Font("华文细黑", 0, 20));
		jl_Replace_Title.setForeground(Color.white);
		jl_Replace_Title.setBounds(60, 258, 200, 30);
		jl_Replace_Title.setVisible(false);
		add(jl_Replace_Title);

		// =================================信息统计====================================
		jb_Statistics = new JButton();
		jb_Statistics.setBounds(16, 320, 30, 30);
		api.setIcon("/res/view7.png", jb_Statistics, 30, 30);
		jb_Statistics.setOpaque(false); // 透明
		jb_Statistics.setBorder(null); // 颜色为空
		jb_Statistics.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Statistics.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Statistics);
		
		
		jl_Statistics_Title = new JLabel("信息统计");
		jl_Statistics_Title.setFont(new Font("华文细黑", 0, 20));
		jl_Statistics_Title.setForeground(Color.white);
		jl_Statistics_Title.setBounds(60, 318, 200, 30);
		jl_Statistics_Title.setVisible(false);
		add(jl_Statistics_Title);

		// =================================搜索按钮====================================
		// 搜索按钮
		jb_Search_Button = new JButton();
		jb_Search_Button.setBounds(16, 565, 30, 30);
		api.setIcon("/res/sou-1.png", jb_Search_Button, 30, 30);
		jb_Search_Button.setOpaque(false); // 透明
		jb_Search_Button.setBorder(null); // 颜色为空
		jb_Search_Button.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Search_Button.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Search_Button);
		
		
		

		// =================================添加模式====================================
		jb_More = new JButton();
		jb_More.setBounds(16, 380, 30, 30);
		api.setIcon("/res/add.png", jb_More, 30, 30);
		jb_More.setOpaque(false); // 透明
		jb_More.setBorder(null); // 颜色为空
		jb_More.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_More.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_More);
		
		jl_More_Title = new JLabel("添加模式");
		jl_More_Title.setFont(new Font("华文细黑", 0, 20));
		jl_More_Title.setForeground(Color.white);
		jl_More_Title.setBounds(60, 378, 200, 30);
		jl_More_Title.setVisible(false);
		add(jl_More_Title);

		// 设置
		jb_Setting = new JButton();
		jb_Setting.setBounds(16, 625, 30, 30);
		api.setIcon("/res/setting.png", jb_Setting, 30, 30);
		jb_Setting.setOpaque(false); // 透明
		jb_Setting.setBorder(null); // 颜色为空
		jb_Setting.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Setting.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Setting);


		// ========================================侧栏底部按钮========================================
		// 底栏设置
		jb_Setting_Dock = new JButton();
		jb_Setting_Dock.setBounds(25, 620, 30, 30);
		api.setIcon("/res/setting.png", jb_Setting_Dock, 30, 30);
		jb_Setting_Dock.setOpaque(false); // 透明
		jb_Setting_Dock.setBorder(null); // 颜色为空
		jb_Setting_Dock.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Setting_Dock.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Setting_Dock);
		jb_Setting_Dock.setVisible(false);
		jb_Setting_Dock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				jb_Setting.doClick();
				sidecut(true);
			}
		});

		// 保存、另存
		jb_Save = new JButton();
		jb_Save.setBounds(95, 620, 30, 30);
		api.setIcon("/res/jb_Save.png", jb_Save, 30, 30);
		jb_Save.setOpaque(false); // 透明
		jb_Save.setBorder(null); // 颜色为空
		jb_Save.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Save.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Save);
		jb_Save.setVisible(false);


		// 删除
		jb_Delete = new JButton();
		jb_Delete.setBounds(235, 620, 30, 30);
		api.setIcon("/res/jb_Delete.png", jb_Delete, 30, 30);
		jb_Delete.setOpaque(false); // 透明
		jb_Delete.setBorder(null); // 颜色为空
		jb_Delete.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Delete.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Delete);
		jb_Delete.setVisible(false);

		// 打开其他文件
		jb_Open = new JButton();
		jb_Open.setBounds(165, 620, 30, 30);
		api.setIcon("/res/jb_Open.png", jb_Open, 30, 30);
		jb_Open.setOpaque(false); // 透明
		jb_Open.setBorder(null); // 颜色为空
		jb_Open.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Open.setFocusPainted(false);// 去除按钮点击焦点
		add(jb_Open);

		jb_Open.setVisible(false);

		// 最底部提示语
		jl_Dock_Title = new JLabel("Setting     save      open    delete");
		jl_Dock_Title.setFont(new Font("华文细黑", 1, 14));
		jl_Dock_Title.setForeground(Color.white);
		jl_Dock_Title.setBounds(16, 653, 380, 20);
		add(jl_Dock_Title);
		jl_Dock_Title.setVisible(false);

		

		// 返回按钮
				jb_Return = new JButton();
				jb_Return.setBounds(17, 19, 27,27);
				jb_Return.setVisible(false);
				api.setIcon("/res/re.png", jb_Return,  27,27);
				jb_Return.setOpaque(false); // 透明
				jb_Return.setBorder(null); // 颜色为空
				jb_Return.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
				jb_Return.setFocusPainted(false);// 去除按钮点击焦点
				// f.getLayeredPane().add(jb0);
				add(jb_Return);		
		
		
	}
	
	
	public void sidecut(boolean state)  //侧栏收起
	{
		if(state) {
			side_state =false;
			this.setBounds(0, 0, 60, 750);		
			side_state = false;
			jt_Search.setVisible(false);
			jl_Title.setVisible(false);
			jl_Version.setVisible(false);
			jb_Search_Button.setVisible(true);
			jb_Setting.setVisible(true);
			jb_Setting_Dock.setVisible(true);
			jl_Free_Title.setVisible(false);
			jl_Timeline_Title.setVisible(false);
			jl_Replace_Title.setVisible(false);
			jl_Statistics_Title.setVisible(false);
			jl_More_Title.setVisible(false);
			jb_Setting_Dock.setVisible(false);
			jb_Save.setVisible(false);
			jb_Delete.setVisible(false);
			jb_Open.setVisible(false);
			jl_Dock_Title.setVisible(false);
		}else {
			side_state = true;
			this.setBounds(0, 0, 290, 750);		
			jb_Return.setVisible(false);
			// 显示组件
			jt_Search.setVisible(true);
			jl_Title.setVisible(true);
			jl_Version.setVisible(true);
			jb_Search_Button.setVisible(false);
			jb_Setting.setVisible(false);
			jb_Setting_Dock.setVisible(false);
			jl_More_Title.setVisible(true);// 中间标签
			jl_Statistics_Title.setVisible(true);
			jl_Replace_Title.setVisible(true);
			jl_Timeline_Title.setVisible(true);
			jl_Free_Title.setVisible(true);
			jb_Setting_Dock.setVisible(true);// 底部功能按钮
			jb_Save.setVisible(true);
			jb_Delete.setVisible(true);
			jb_Open.setVisible(true);
			jl_Dock_Title.setVisible(true);
		}

	}

}
