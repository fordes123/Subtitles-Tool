package com.SubTool.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SubTool.API.ColorAPI;
import com.SubTool.API.DataAPI;
import com.SubTool.API.DataAPI.CONFIG;
import com.SubTool.API.ViewAPI;

public class Setting extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 全局变量
	public JPanel p = this;
	public JLabel L1, L2, L3, L4 = null;
	public JLabel L11, L12, L13, L14, L21, L22, L24, L25, L23, L31, L32, L33, L34, L41 ,L42= null;
	@SuppressWarnings("rawtypes")
	public JComboBox L2_j1, L1_j1, L1_j2, L1_j5, L1_j3, L2_j3, L2_j4, L3_j3 = null; // 下拉框
	public JCheckBox L1_j4, L1_j6, L1_j7, L1_j8, L1_j9, L2_j2, L2_j5, L2_j6, L2_j7, L3_j1, L3_j2, L3_j4, L3_j5, L3_j6,
			L4_j1 = null; // 复选框

	public Color fontcolor = null;
	public Color sidecolor = null;
	public Color pancolor = null;
	public File bgfile = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Setting(JFrame f,CONFIG config,ViewAPI api,DataAPI data,ColorAPI color) {
		// TODO 自动生成的构造函数存根
		//ViewAPI api = new ViewAPI();
		//DataAPI data=new DataAPI();
		//ColorAPI color = new ColorAPI();
		//CONFIG config=data.reconfig();
		// 设置面板属性
		p.setBounds(90, 50, 1070, 600);
		p.setLayout(null);
		p.setOpaque(false);
		p.setVisible(false);

		// 设置容器面板，这里不可以使用setSize
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setOpaque(false);// 透明
		pane.setPreferredSize(new Dimension(p.getWidth(), 1200));

		// 设置滚动面板
		JScrollPane jsp = new JScrollPane(pane);
		jsp.setViewportView(pane);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);// 垂直滚动条自动出现
		jsp.getVerticalScrollBar().setUI(api.new DemoScrollBarUI());// 垂直滚动条使用自定义样式
		jsp.getVerticalScrollBar().setUnitIncrement(20);// 鼠标滚动行数
		jsp.setBounds(0, 0, p.getWidth(), p.getHeight());
		jsp.setSize(p.getWidth(), p.getHeight()); // 这里要用setSize设定固定大小
		jsp.setBorder(null); // 消除边框
		jsp.setOpaque(false);// 透明
		jsp.getViewport().setOpaque(false); // 设置内容窗格透明
		jsp.setBackground(null);// 颜色为空，设置颜色后才可设置透明
		p.add(jsp,new Integer(0));

		/*
		 * ======================================================================== 界面设置
		 * ==========================================================================
		 */
		L1 = new JLabel("浏览设置");
		L1.setFont(new Font("微软雅黑", 1, 26));
		L1.setForeground(Color.black);
		L1.setBounds(0, 280, 200, 30);
		// pl1.setVisible(false);
		pane.add(L1);

		L11 = new JLabel("字体");
		L11.setFont(new Font("华文细黑", 1, 23));
		L11.setForeground(null);
		L11.setBounds(50, 350, 200, 30);
		pane.add(L11);

		L12 = new JLabel("颜色");
		L12.setFont(new Font("华文细黑", 1, 23));
		L12.setForeground(null);
		L12.setBounds(50, 470, 200, 30);
		pane.add(L12);

		L13 = new JLabel("风格");
		L13.setFont(new Font("华文细黑", 1, 23));
		L13.setForeground(null);
		L13.setBounds(50, 530, 260, 30);
		pane.add(L13);

		L14 = new JLabel("大小");
		L14.setFont(new Font("华文细黑", 1, 23));
		L14.setForeground(null);
		L14.setBounds(50, 410, 200, 30);
		pane.add(L14);

		// 获取系统字体列表
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = e.getAvailableFontFamilyNames();

		// 字体
		L1_j1 = new JComboBox(fontNames);
		L1_j1.setBounds(140, 352, 200, 32);
		L1_j1.setFont(new Font("华文细黑", 0, 21));
		pane.add(L1_j1);
		L1_j1.setSelectedItem("微软雅黑");
		if(!(config==null))
			L1_j1.setSelectedIndex(config.v4);

		// 大小
		String str2[] = { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30" };
		L1_j2 = new JComboBox(str2);
		L1_j2.setBounds(140, 410, 80, 32);
		L1_j2.setFont(new Font("华文细黑", 0, 21));
		pane.add(L1_j2);
		L1_j2.setOpaque(false);
		if(!(config==null))
			L1_j2.setSelectedIndex(config.v5);
		
		
		// 字体颜色
		L1_j3 = new JComboBox(color.RFL());
		L1_j3.setBounds(140, 470, 160, 32);
		L1_j3.setFont(new Font("华文细黑", 0, 21));
		pane.add(L1_j3);
		L1_j3.setOpaque(false);
		L1_j3.setSelectedIndex(0);
		if(!(config==null))
			L1_j3.setSelectedIndex(config.v6);

		L1_j4 = new JCheckBox("自定义字体颜色", false);
		L1_j4.setBounds(360, 470, 200, 32);
		L1_j4.setFont(new Font("华文细黑", 0, 24));
		L1_j4.setOpaque(false);
		L1_j4.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L1_j4);
		if(!(config==null)) {
			L1_j4.setSelected(config.t4);
			fontcolor=config.fontolor;}
		L1_j4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L1_j4.isSelected()) {
					fontcolor = JColorChooser.showDialog(f, "选取颜色", null);
					if (fontcolor == null)
						L1_j4.setSelected(false);
				} else
					L1_j4.setSelected(false);
				// System.out.println("选到的颜色为："+fontcolor);
			}
		});

		// 风格
		String str3[] = { "正常", "加粗", "斜体", "下划线" };
		L1_j5 = new JComboBox(str3);
		L1_j5.setBounds(140, 530, 100, 32);
		L1_j5.setFont(new Font("华文细黑", 0, 21));
		pane.add(L1_j5);
		L1_j5.setOpaque(false);
		L1_j5.setSelectedIndex(0);
		if(!(config==null))
			L1_j5.setSelectedIndex(config.v7);

		L1_j6 = new JCheckBox("使用组合风格", false);
		L1_j6.setBounds(360, 530, 200, 32);
		L1_j6.setFont(new Font("华文细黑", 0, 24));
		L1_j6.setOpaque(false);
		L1_j6.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L1_j6);
		if(!(config==null))
			L1_j6.setSelected(config.t5);
		L1_j6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L1_j6.isSelected()) {
					L1_j7.setSelected(false);
					L1_j8.setSelected(false);
					L1_j9.setSelected(false);
					L1_j7.setVisible(true);
					L1_j8.setVisible(true);
					L1_j9.setVisible(true);
				} else {
					L1_j7.setVisible(false);
					L1_j8.setVisible(false);
					L1_j9.setVisible(false);
				}
			}
		});

		L1_j7 = new JCheckBox("加粗", false);
		L1_j7.setBounds(600, 530, 80, 32);
		L1_j7.setFont(new Font("华文细黑", 0, 24));
		L1_j7.setOpaque(false);
		L1_j7.setFocusPainted(false);// 去除按钮点击焦点
		L1_j7.setVisible(false);
		pane.add(L1_j7);
		if(!(config==null))
			L1_j7.setSelected(config.t6);

		L1_j8 = new JCheckBox("斜体", false);
		L1_j8.setBounds(690, 530, 80, 32);
		L1_j8.setFont(new Font("华文细黑", 0, 24));
		L1_j8.setOpaque(false);
		L1_j8.setFocusPainted(false);// 去除按钮点击焦点
		L1_j8.setVisible(false);
		pane.add(L1_j8);
		if(!(config==null))
			L1_j8.setSelected(config.t7);

		L1_j9 = new JCheckBox("下划线", false);
		L1_j9.setBounds(780, 530, 100, 32);
		L1_j9.setFont(new Font("华文细黑", 0, 24));
		L1_j9.setOpaque(false);
		L1_j9.setFocusPainted(false);// 去除按钮点击焦点
		L1_j9.setVisible(false);
		pane.add(L1_j9);
		if(!(config==null))
			L1_j9.setSelected(config.t8);

		/*
		 * ======================================================================== 
		 *  主题设置
		 * ==========================================================================
		 */
		L2 = new JLabel("主题设置");
		L2.setFont(new Font("微软雅黑", 1, 26));
		L2.setForeground(null);
		L2.setBounds(0, 10, 200, 30);
		pane.add(L2);

		L21 = new JLabel("全局主题");
		L21.setFont(new Font("华文细黑", 1, 23));
		L21.setForeground(null);
		L21.setBounds(50, 80, 200, 30);
		pane.add(L21);

		L22 = new JLabel("侧栏颜色");
		L22.setFont(new Font("华文细黑", 1, 23));
		L22.setForeground(null);
		L22.setBounds(50, 140, 200, 30);
		pane.add(L22);

		L23 = new JLabel("界面背景");
		L23.setFont(new Font("华文细黑", 1, 23));
		L23.setForeground(null);
		L23.setBounds(50, 200, 200, 30);
		pane.add(L23);

		L2_j7 = new JCheckBox("自定义背景图", false);
		L2_j7.setBounds(50, 1090, 180, 32);
		L2_j7.setFont(new Font("华文细黑", 1, 24));
		L2_j7.setOpaque(false);
		L2_j7.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L2_j7);
		L2_j7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L2_j7.isSelected()) {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("选择图片文件", "png");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showOpenDialog(f.getParent());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						bgfile = chooser.getSelectedFile();
					} else
						L2_j7.setSelected(false);
				} else
					L2_j7.setSelected(false);

			}
		});

		// 主题选项
		// String str21[] = { "默认黑", "火山棕", "深海绿", "卷轴黄", "水鸭青", "栗紫", "海报灰" };
		L2_j1 = new JComboBox(color.RSL());
		L2_j1.setBounds(180, 80, 120, 32);
		L2_j1.setFont(new Font("华文细黑", 0, 21));
		L2_j1.setBorder(null);// 边框
		L2_j1.setOpaque(false);
		L2_j1.setBackground(null);
		if(!(config==null))
			L2_j1.setSelectedIndex(config.v1);
		pane.add(L2_j1);

		L2_j2 = new JCheckBox("开启主题混搭", false);
		L2_j2.setBounds(360, 80, 180, 32);
		L2_j2.setFont(new Font("华文细黑", 0, 24));
		L2_j2.setOpaque(false);
		L2_j2.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L2_j2);
		if(!(config==null))
			L2_j2.setSelected(config.t1);


		// 侧栏主题选项
		L2_j3 = new JComboBox(color.RSL());
		L2_j3.setBounds(180, 140, 120, 32);
		L2_j3.setFont(new Font("华文细黑", 0, 21));
		L2_j3.setBorder(null);// 边框
		L2_j3.setBackground(null);
		L2_j3.setOpaque(false);
		pane.add(L2_j3);
		if(!(config==null))
			L2_j3.setSelectedIndex(config.v2);

		// 主界面主题选项
		L2_j4 = new JComboBox(color.RML());
		L2_j4.setBounds(180, 200, 120, 32);
		L2_j4.setFont(new Font("华文细黑", 0, 21));
		L2_j4.setBorder(null);// 边框
		L2_j4.setBackground(null);
		L2_j4.setOpaque(false);
		pane.add(L2_j4);
		if(!(config==null))
			L2_j4.setSelectedIndex(config.v3);

		L2_j5 = new JCheckBox("自定义颜色", false);
		L2_j5.setBounds(360, 140, 180, 32);
		L2_j5.setFont(new Font("华文细黑", 0, 24));
		L2_j5.setOpaque(false);
		L2_j5.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L2_j5);
		if(!(config==null)) {
			L2_j5.setSelected(config.t2);
			sidecolor=config.sidecolor;
		}
		L2_j5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L2_j5.isSelected()) {
					sidecolor = JColorChooser.showDialog(f, "选取颜色", null);
					if (sidecolor == null)
						L2_j5.setSelected(false);
				} else
					L2_j5.setSelected(false);
				//System.out.println("选到的颜色为：" + sidecolor);
			}
		});

		L2_j6 = new JCheckBox("自定义颜色", false);
		L2_j6.setBounds(360, 200, 180, 32);
		L2_j6.setFont(new Font("华文细黑", 0, 24));
		L2_j6.setOpaque(false);
		L2_j6.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L2_j6);
		if(!(config==null)) {
			L2_j6.setSelected(config.t3);
			pancolor=config.maincolor;
		//	System.out.println(config.maincolor);
			//System.out.println(pancolor);
		}
		L2_j6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L2_j6.isSelected()) {
					pancolor = JColorChooser.showDialog(f, "选取颜色", null);
					if (pancolor == null)
						L2_j6.setSelected(false);
				} else
					L2_j6.setSelected(false);
				//System.out.println("选到的颜色为：" + pancolor);
			}
		});

		/*
		 * ======================================================================== 功能设置
		 * ==========================================================================
		 */
		L3 = new JLabel("功能设置");
		L3.setFont(new Font("微软雅黑", 1, 26));
		L3.setForeground(null);
		L3.setBounds(0, 610, 200, 30);
		pane.add(L3);

		L31 = new JLabel("自动保存");
		L31.setFont(new Font("华文细黑", 1, 23));
		L31.setForeground(null);
		L31.setBounds(50, 680, 200, 30);
		pane.add(L31);

		L32 = new JLabel("文件编码");
		L32.setFont(new Font("华文细黑", 1, 23));
		L32.setForeground(null);
		L32.setBounds(50, 740, 200, 30);
		pane.add(L32);

		L33 = new JLabel("功能窗口独立");
		L33.setFont(new Font("华文细黑", 1, 23));
		L33.setForeground(null);
		L33.setBounds(50, 800, 200, 30);
		pane.add(L33);

		L34 = new JLabel("设置存储");
		L34.setFont(new Font("华文细黑", 1, 23));
		L34.setForeground(null);
		L34.setBounds(50, 860, 200, 30);
		pane.add(L34);

		L3_j1 = new JCheckBox("检测修改并自动保存", true);
		L3_j1.setBounds(180, 680, 250, 30);
		L3_j1.setFont(new Font("华文细黑", 0, 24));
		L3_j1.setFocusPainted(false);// 去除按钮点击焦点
		L3_j1.setOpaque(false);
		pane.add(L3_j1);
		if(config!=null)
			L3_j1.setSelected(config.t9);

		L3_j2 = new JCheckBox("自定义编码", false);
		L3_j2.setBounds(180, 740, 200, 30);
		L3_j2.setFont(new Font("华文细黑", 0, 24));
		L3_j2.setFocusPainted(false);// 去除按钮点击焦点
		L3_j2.setOpaque(false);
		pane.add(L3_j2);
		if(config!=null) 
			L3_j2.setSelected(config.t10);

		String str5[] = { "UTF-8", "GBK", "GB2312" };
		L3_j3 = new JComboBox(str5);
		L3_j3.setBounds(350, 740, 180, 32);
		L3_j3.setFont(new Font("华文细黑", 0, 21));
		pane.add(L3_j3);
		L3_j3.setBackground(null);
		L3_j3.setOpaque(false);
		L3_j3.setSelectedIndex(0);
		L3_j3.setVisible(false);// 默认不显示
		if(config!=null) {
			L3_j3.setSelectedIndex(config.v8);
			if(L3_j2.isSelected())
				L3_j3.setOpaque(true);
		}
		L3_j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L3_j2.isSelected()) {
					L3_j3.setVisible(true);
					L3_j3.setSelectedItem("UTF-8");
				} else {
					L3_j3.setVisible(false);
					L3_j3.setSelectedItem("UTF-8");
				}
			}
		});

		L3_j4 = new JCheckBox("默认独立", false);
		L3_j4.setBounds(230, 800, 200, 30);
		L3_j4.setFont(new Font("华文细黑", 0, 24));
		L3_j4.setOpaque(false);
		L3_j4.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L3_j4);
		L3_j4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L3_j4.isSelected())
					L3_j5.setSelected(false);
				else
					L3_j5.setSelected(true);
			}
		});

		L3_j5 = new JCheckBox("默认贴靠", true);
		L3_j5.setBounds(380, 800, 200, 30);
		L3_j5.setFont(new Font("华文细黑", 0, 24));
		L3_j5.setOpaque(false);
		L3_j5.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L3_j5);
		if(config!=null) {
			L3_j4.setSelected(config.t11);
			L3_j5.setSelected(!config.t11);}
		L3_j5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (L3_j5.isSelected())
					L3_j4.setSelected(false);
				else
					L3_j4.setSelected(true);
			}
		});

		L3_j6 = new JCheckBox("保存设置到配置文件", false);
		L3_j6.setBounds(180, 860, 250, 30);
		L3_j6.setFont(new Font("华文细黑", 0, 24));
		L3_j6.setOpaque(false);
		L3_j6.setFocusPainted(false);// 去除按钮点击焦点
		pane.add(L3_j6);
		if(config!=null)
			L3_j6.setSelected(config.t12);
		/*
		 * ======================================================================== 实验性
		 * 功能 ==========================================================================
		 */
		L4 = new JLabel("实验功能");
		L4.setFont(new Font("微软雅黑", 1, 26));
		L4.setForeground(null);
		L4.setBounds(0, 940, 200, 30);
		pane.add(L4);

		L4_j1 = new JCheckBox("超级过滤");
		L4_j1.setBounds(50, 1010, 250, 30);
		L4_j1.setFont(new Font("华文细黑", 1, 23));
		L4_j1.setFocusPainted(false);// 去除按钮点击焦点
		L4_j1.setOpaque(false);
		pane.add(L4_j1);

		L41 = new JLabel("（主界面过滤掉时间轴相关信息，只显示字幕对话内容）");
		L41.setFont(new Font("华文细黑", 0, 18));
		L41.setForeground(null);
		L41.setBounds(50, 1040, 500, 20);
		pane.add(L41);

		L42 = new JLabel("（选择一张图片作为主界面背景，兼容性较差）");
		L42.setFont(new Font("华文细黑", 0, 18));
		L42.setForeground(null);
		L42.setBounds(50, 1120, 500, 20);
		pane.add(L42);
		
	}

}
