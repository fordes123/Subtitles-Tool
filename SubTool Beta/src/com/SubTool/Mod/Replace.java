package com.SubTool.Mod;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.SubTool.API.DataAPI;
import com.SubTool.API.ViewAPI;
import com.SubTool.UI.MainPanel;
import com.SubTool.UI.Message;

public class Replace extends JPanel {

	/**
	 * 查找替换模块
	 * 
	 * 问题较多，待排查
	 */
	private static final long serialVersionUID = 1L;
	// 全局变量
	public final JTextField jt1, jt2;
	public JCheckBox jc1, jc2, jc3, jc4;
	public JButton jb0, jb1, jb2;
	public String Text1 = null, Text2 = null;
	public String[] poslist;
	public int num;

	public Replace(DataAPI data, ViewAPI api, MainPanel MPanel, JFrame f) {
		// TODO 自动生成的构造函数存根

		this.setBorder(null);
		this.setSize(330, 630);
		this.setBounds(0, 0, 330, 630);
		this.setBackground(data.theme.sidecolor);
		this.setLayout(null);
		this.setVisible(false);// 默认隐藏
		JPanel p = this;

		// 功能面板贴靠按钮
		jb0 = new JButton();
		jb0.setBounds(this.getWidth() - 40, 10, 28, 28);
		api.setIcon("/res/t.png", jb0, 28, 28);
		jb0.setOpaque(false); // 透明
		jb0.setBorder(null); // 颜色为空
		jb0.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb0.setFocusPainted(false);// 去除按钮点击焦点
		this.add(jb0);

		JLabel l1 = new JLabel("查找");
		JLabel l2 = new JLabel("替换");
		l1.setFont(new Font("微软雅黑", 0, 18));
		l2.setFont(new Font("微软雅黑", 0, 18));
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l1.setBounds(30, 50, 50, 30);
		l2.setBounds(30, 120, 50, 30);
		this.add(l1);
		this.add(l2);

		// 输入框
		jt1 = new JTextField();
		jt1.setBounds(100, 50, 180, 30);
		jt1.setFont(new Font("微软雅黑", 0, 20));
		jt1.setForeground(Color.black);
		// jt1.setOpaque(false);
		// t1.setEditable(false);//不可修改
		jt1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		jt1.setBorder(null);
		this.add(jt1);
		jt1.setText("");
		jt1.requestFocus();
		jt1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				jt1.setText("");
			}
		});

		// 输入框
		jt2 = new JTextField();
		jt2.setBounds(100, 120, 180, 30);
		jt2.setFont(new Font("微软雅黑", 0, 20));
		jt2.setForeground(Color.black);
		// t1.setOpaque(false);
		// t1.setEditable(false);//不可修改
		jt2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		jt2.setBorder(null);
		this.add(jt2);
		jt2.setText("");
		jt2.requestFocus();
		jt2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				jt2.setText("");
			}
		});

		// 执行按钮

		jc1 = new JCheckBox(" 区分大小写", true);
		jc1.setBounds(40, 240, 130, 30);
		jc1.setForeground(Color.WHITE);
		jc1.setFont(new Font("华文细黑", 0, 19));
		jc1.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jc1.setOpaque(false);
		jc1.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		this.add(jc1);

		jc2 = new JCheckBox(" 正则表达式", false);
		jc2.setBounds(180, 240, 130, 30);
		jc2.setForeground(Color.WHITE);
		jc2.setFont(new Font("华文细黑", 0, 19));
		jc2.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jc2.setOpaque(false);
		jc2.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		this.add(jc2);

		jc3 = new JCheckBox(" 单步操作", false);
		jc3.setBounds(40, 290, 120, 30);
		jc3.setForeground(Color.WHITE);
		jc3.setFont(new Font("华文细黑", 0, 19));
		jc3.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jc3.setOpaque(false);
		jc3.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		this.add(jc3);
		jc3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
			//	jt1.setText("");
			//	jt2.setText("");
			}
		});

		jc4 = new JCheckBox(" 智能过滤", true);
		jc4.setBounds(180, 290, 150, 30);
		jc4.setForeground(Color.WHITE);
		jc4.setFont(new Font("华文细黑", 0, 19));
		jc4.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jc4.setOpaque(false);
		jc4.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		this.add(jc4);

		jb1 = new JButton("查找");
		jb1.setFont(new Font("华文细黑", 0, 18));
		jb1.setForeground(new Color(80, 203, 172));
		jb1.setBounds(50, 410, 100, 35);
		jb1.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		jb1.setOpaque(false); // 透明
		// jb1.setBorder(null); // 颜色为空
		jb1.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		this.add(jb1);

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				if (!jt1.getText().trim().equals("")) {
					
					int renum = data.search(MPanel, jt1.getText(), jc3.isSelected(), jc4.isSelected());

					if (!jc3.isSelected()) {
						// 全体查找,即一次查找出所有关键字
						if (renum < 0)
							new Message(f, "搜索完毕，没有发现关键字~", 2000).start();
						else
							new Message(f, "搜索完成，共找到 " + renum + " 个关键字，已做出标记", 4000).start();

					} else {
						// 单步查找，一次查找一个关键字，循环搜索
						switch (renum) {
						case -2:
							new Message(f, "搜索完毕，没有发现关键字~", 2000).start();
							break;

						case -1:
								//MPanel.jta.setCaretPosition(renum);
								new Message(f, "已到达文档尾，再次点击将回到文档开始", 2000).start();
								break;
						default:
							MPanel.jta.setCaretPosition(renum);
							break;
						}
					}

				} else {
					new Message(f, "输入错误，关键字不允许为空或空格~", 3000).start();
					jt1.setText("");
				}
				//
			}
		});

		// 替换按钮
		jb2 = new JButton("替换");
		jb2.setFont(new Font("华文细黑", 0, 18));
		jb2.setForeground(new Color(80, 203, 172));
		jb2.setBounds(180, 410, 100, 35);
		jb2.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		jb2.setOpaque(false); // 透明
		// jb1.setBorder(null); // 颜色为空
		jb2.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		this.add(jb2);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (!jt1.getText().trim().equals("") && !jt2.getText().equals("")) {

					int renum = data.replace(f, MPanel, jt1.getText().trim(), jt2.getText(), jc1.isSelected(),jc2.isSelected(), jc3.isSelected(),jc4.isSelected());

					if (!jc3.isSelected()) {
						// 全体查找,即一次替换所有关键字
						if (renum < 0)
							new Message(f, "替换完毕，没有发现关键字~", 2000).start();
						else
							new Message(f, "替换完成，共找到 " + renum + " 个关键字，已做出标记", 4000).start();

					} else {
						// 单步查找，一次查找一个关键字，循环搜索
						switch (renum) {
						case -2:
							new Message(f, "替换完毕，没有发现关键字~", 2000).start();
							break;

						case -1:
								new Message(f, "替换完成，已到达文档尾", 2000).start();
								MPanel.jta.setCaretPosition(0);
								break;
						default:
							MPanel.jta.setCaretPosition(renum);
							break;
						}
					}
					data.subtitles=MPanel.jta.getText();
				}else {
					new Message(f, "输入有误，查找和替换内容不允许为空~", 3000).start();
					jt1.setText("");
				}
			}
		});

		JLabel l3 = new JLabel("选项");
		JLabel l4 = new JLabel("操作");
		l3.setFont(new Font("微软雅黑", 0, 15));
		l4.setFont(new Font("微软雅黑", 0, 15));
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l3.setBounds(30, 190, 300, 30);
		l4.setBounds(30, 350, 300, 30);
		this.add(l3);
		this.add(l4);

		JTextArea jta = new JTextArea();
		jta.setBounds(30, 470, 255, 300);
		jta.setOpaque(false);
		jta.setFont(new Font("微软雅黑", 0, 15));
		jta.setForeground(Color.WHITE);
		jta.append("注意" + "\n\n");
		jta.append("*  智能过滤将在操作时过滤掉时间轴" + "\n" + "    描述行，以防止损坏，建议开启" + "\n\n");
		jta.append("*  替换操作默认为单步操作，当勾选 " + "\n" + "    了全部替换后将一次替换所有关键字\n\n");
		// jta.append("* 点击本面板任意空白处，即可退出本模式" + "\n");
		this.add(jta);

		jb0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				// st_MOd.setVisible(true);
				if (data.Mod_state) {
					// System.out.println("恢复贴靠");
					data.Mod_state = false;
					MPanel.jf_Mod.setVisible(false);// 隐藏模块窗口
					MPanel.jp_Mod.add(p);// 内容面板添加至承载面板
					MPanel.jp_Mod.setVisible(true);// 显示贴靠面板
					// new Message(f, "窗口已恢复贴靠~", 2000).start();
					MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				} else {
					// System.out.println("窗口独立");
					MPanel.jp_Mod.setVisible(false);// 隐藏模块面板
					MPanel.jf_Mod.add(p);
					MPanel.jf_Mod.setVisible(true);// 窗口可见
					MPanel.jf_Mod.setBounds(f.getX() + MPanel.jp_Mod.getX(), f.getY() + MPanel.jp_Mod.getY(),
							MPanel.jp_Mod.getWidth(), MPanel.jp_Mod.getHeight());
					data.Mod_state = true;
					// new Message(f, "窗口已独立，可自由拖动，点击右上角再次贴靠~", 1000).start();
					MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				}
			}
		});
	}
}
