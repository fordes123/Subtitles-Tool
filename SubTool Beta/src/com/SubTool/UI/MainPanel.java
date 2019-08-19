package com.SubTool.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import com.SubTool.API.DataAPI;
import com.SubTool.API.ViewAPI;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 全局变量
	public JScrollPane jsp;
	public JTextPane jta;
	public JButton jb_Exit, jb_Min;
	public JMenuBar jmb_Menubar;
	public JMenu jm_MenuButton;
	public JMenuItem jmi_HelpItem, jmi_UpdateItem, jmi_AboutItem;
	public JPanel jp_Mod;
	public JFrame jf_Mod;
	public int Mod_first_x, Mod_first_y;
	
	

	public MainPanel(JFrame f, ViewAPI api, DataAPI data) {
		// TODO 自动生成的构造函数存根
		this.setBounds(0, 0, f.getWidth(), f.getHeight());
		this.setBackground(data.theme.maincolor);
		this.setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		
		
		// 文本区
		jta = new JTextPane();
		jsp = new JScrollPane(jta);
		jsp.setBounds(90, 50, 1080, 615);
		jsp.setBorder(null); // 消除边框
		jsp.setBackground(null);
		jsp.setOpaque(false);

		// 分别设置水平和垂直滚动条自动出现
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.getVerticalScrollBar().setUI(api.new DemoScrollBarUI());
		// jsp.getHorizontalScrollBar().setUI(api.new DemoScrollBarUI());

		// jta.setParagraphAttributes(normal, true);
		// 把JScrollPane加入到JFrame
		this.add(jsp, BorderLayout.NORTH);
		jta.setOpaque(false); // 设置文本区透明
		jta.setBorder(null);// 无边框
		// jta.setCaretColor(Color.WHITE); //光标颜色
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false); // 文本区边框
		jta.setEditable(false);// 默认禁止修改

		// 退出程序按钮
		jb_Exit = new JButton();
		jb_Exit.setBounds(1160, 12, 26, 26);
		api.setIcon("/res/view1.png", jb_Exit, 26, 26);
		jb_Exit.setOpaque(false); // 透明
		jb_Exit.setBorder(null); // 颜色为空
		jb_Exit.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Exit.setFocusPainted(false);// 去除按钮点击焦点
		this.add(jb_Exit);

		// 程序菜单按钮
		// 菜单栏板
		jmb_Menubar = new JMenuBar();
		jmb_Menubar.setBounds(1118, 10, 30, 30);
		this.add(jmb_Menubar);
		jmb_Menubar.setOpaque(false); // 透明
		jmb_Menubar.setBorder(null); // 边框

		// 菜单按钮
		jm_MenuButton = new JMenu();
		jm_MenuButton.setBounds(1168, 10, 26, 26);
		jm_MenuButton.setOpaque(false);
		ImageIcon jmicon = new ImageIcon(this.getClass().getResource("/res/view2.png")); // 背景图片
		jmicon.setImage(jmicon.getImage().getScaledInstance(26, 26, Image.SCALE_DEFAULT));
		jm_MenuButton.setIcon(jmicon);
		this.add(jm_MenuButton);
		// 菜单项
		jmi_HelpItem = new JMenuItem("获取帮助");
		jmi_UpdateItem = new JMenuItem("更新日志");
		jmi_AboutItem = new JMenuItem("关于软件");

		jmi_HelpItem.setFont(new Font("华文细黑", 1, 16));
		jmi_UpdateItem.setFont(new Font("华文细黑", 1, 16));
		jmi_AboutItem.setFont(new Font("华文细黑", 1, 16));

		jmb_Menubar.add(jm_MenuButton); // 将菜单添加到菜单条上
		jm_MenuButton.add(jmi_HelpItem);
		jm_MenuButton.add(jmi_UpdateItem);
		jm_MenuButton.add(jmi_AboutItem);

		// 最小化按钮
		jb_Min = new JButton();
		jb_Min.setBounds(1080, 12, 26, 26);
		api.setIcon("/res/view3.png", jb_Min, 26, 26);
		jb_Min.setOpaque(false); // 透明
		jb_Min.setBorder(null); // 颜色为空
		jb_Min.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb_Min.setFocusPainted(false);// 去除按钮点击焦点
		this.add(jb_Min);
		jb_Min.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setExtendedState(JFrame.ICONIFIED); // 最小化
			}
		});

		// 面板jp_Mod为功能模块底层面板
		jp_Mod = new JPanel();
		jp_Mod.setBorder(null);
		jp_Mod.setBounds(870, 50, 330, 630);
		jp_Mod.setBackground(data.theme.sidecolor);
		jp_Mod.setLayout(null);
		jp_Mod.setVisible(false);
		this.add(jp_Mod,0);

	

		// 功能面板贴靠按钮
		//jb0 = new JButton();
		//jb0.setBounds(jp_Mod.getWidth() - 40, 10, 28, 28);
		//api.setIcon("/res/t.png", jb0, 28, 28);
		//jb0.setOpaque(false); // 透明
		//jb0.setBorder(null); // 颜色为空
		//jb0.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		//jb0.setFocusPainted(false);// 去除按钮点击焦点
		// f.getLayeredPane().add(jb0);
		//jp_Mod.add(jb0);
		
		jf_Mod = new JFrame();
		jf_Mod.setResizable(false); // 禁用窗口最大化
		jf_Mod.setUndecorated(true);// 删除窗口边框
		jf_Mod.setVisible(false);// 窗口不可见
		api.titlebar(jf_Mod, jp_Mod.getWidth()-40, 40, 0);
		jf_Mod.setBounds(500,500,330,630);
		//System.out.println("主界面载入完成");
		

		
	}
}
