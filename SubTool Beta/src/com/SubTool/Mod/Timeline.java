package com.SubTool.Mod;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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

public class Timeline extends JPanel {

	/**
	 * 时间轴模块
	 */
	private static final long serialVersionUID = 1L;

	// 全局变量
	public final JTextField jt1;
	public JButton jb0, jb1;

	public Timeline(JFrame f,MainPanel MPanel,DataAPI data, ViewAPI api) {
		// TODO 自动生成的构造函数存根

		this.setBorder(null);
		this.setSize(330, 630);
		this.setBounds(0, 0, 330, 630);
		this.setBackground(data.theme.sidecolor);
		this.setLayout(null);
		this.setVisible(false);// 默认隐藏
		JPanel p=this;

		// 功能面板贴靠按钮
		jb0 = new JButton();
		jb0.setBounds(this.getWidth() - 40, 10, 28, 28);
		api.setIcon("/res/t.png", jb0, 28, 28);
		jb0.setOpaque(false); // 透明
		jb0.setBorder(null); // 颜色为空
		jb0.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb0.setFocusPainted(false);// 去除按钮点击焦点
		this.add(jb0);
		
		jt1 = new JTextField();
		jt1.setBounds(35, 60, 255, 40);
		jt1.setFont(new Font("微软雅黑", 0, 18));
		jt1.setForeground(new Color(195, 195, 195));
		// t1.setOpaque(false);
		// t1.setEditable(false);//不可修改
		jt1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		jt1.setBorder(null);
		this.add(jt1);
		// jt1.setText("");
		// jt1.requestFocus();

		jt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jt1.setForeground(Color.black);
				jt1.setText("");
				jt1.requestFocus();
				jt1.setText("");
			}
			// @Override
			// public void focusLost(FocusEvent e)
			// {
			// textField.setText("输入内容");
			// }
		});
		// 执行按钮
		jb1 = new JButton("START");
		jb1.setFont(new Font("华文细黑", 1, 24));
		jb1.setForeground(new Color(80, 203, 172));
		jb1.setBounds(80, 200, 180, 35);
		jb1.setFocusPainted(false); // 不设置焦点，以达到去除按钮文字边框得效果
		// jb1.setOpaque(false); // 透明
		// jb1.setBorder(null); // 颜色为空
		jb1.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		this.add(jb1);

		JTextArea jta = new JTextArea();
		jta.setBounds(35, 350, 255, 300);
		jta.setOpaque(false);
		jta.setFont(new Font("微软雅黑", 0, 15));
		jta.setForeground(Color.WHITE);
		jta.append("注意" + "\n\n");
		jta.append("*  请严格按照示例和提示语，规范输入时间轴" + "\n" + "    注意区分不同的单位和长度" + "\n" + "    输入格式不容有误" + "\n\n");
		jta.append("*  部分时间轴不规范，或不常见的类型" + "\n" + "    可能不受支持，或修正失误" + "\n" + "    请尝试自行调整或联系开发者适配" + "\n\n");
		jta.append("*  点击本面板空白处，即可退出本模式" + "\n");
		this.add(jta);

		// 搜索框下方提示语
		JLabel jl2 = new JLabel();
		jl2.setFont(new Font("华文细黑", 0, 16));
		jl2.setForeground(Color.white);
		jl2.setBounds(35, 105, 300, 60);
		this.add(jl2);

		switch (data.type) {
		case 1:// srt
			jt1.setText("示例: XX XX XX XXX");
			jl2.setText("<html>" + "Tips: 时、分、秒、毫秒以空格分开，" + "<br>" + "严格注意位数，不足需往前补零" + "<html>");
			break;
		case 2:// ass
			jt1.setText("示例: XX XX XX XX");
			jl2.setText("<html>" + "Tips: 时、分、秒、分秒以空格分开，" + "<br>" + "严格注意位数，不足需往前补零" + "<html>");
			break;
		case 3:// lrc
			jt1.setText("示例: XX XX XX");
			jl2.setText("<html>" + "Tips: 分、秒、分秒以空格分开，" + "<br>" + "务必注意位数，不足需往前补零" + "<html>");
			break;

		default:
			jt1.setText("文件格式不受支持");
			jl2.setText("<html>" + "Tips: 虽不受支持，但您仍可进行尝试" + "<br>" + "当然，理论上不可能成功" + "<html>");
			break;
		}
		
		
		jb1.addMouseListener(new MouseListener() {

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

				// 匹配正则表达式，校验输入时间的格式
				switch (data.type) {
				case 1:// srt
						// 使用正则表达式匹配检验输入正确性
					String time1 = "\\d\\d \\d\\d \\d\\d \\d\\d\\d";
					if (!Pattern.matches(time1, jt1.getText())) {
						new Message(f,  "时间信息有误，请检查输入格式~", 3000).start();
						jt1.setForeground(new Color(195, 195, 195));
						jt1.setText("示例: XX XX XX XXX");
					} else {
						String temp = data.Revise(data.subtitles, jt1.getText());
						if (temp == null)
							new Message(f,  "校正失败，文件格式不受支持！", 5000).start();
						else {
							data.subtitles = temp;
							new Message(f, "校正完成，是否请以文本为准~", 5000).start();
							data.save(data.newfile, data.subtitles);
							//System.out.println("保存至副本");
						}
						MPanel.jta.setText("");
						data.Display(MPanel);
						MPanel.jta.setCaretPosition(0);
					}
					break;
				case 2:// ass
						// 使用正则表达式匹配检验输入正确性
					String time2 = "\\d \\d\\d \\d\\d \\d\\d";
					if (!Pattern.matches(time2, jt1.getText())) {
						new Message(f,  "时间信息有误，请检查输入格式~", 3000).start();
						jt1.setForeground(new Color(195, 195, 195));
						jt1.setText("示例: X XX XX XX");
					} else {
						String temp = data.Revise(data.subtitles, jt1.getText());
						if (temp == null)
							new Message(f, "校正失败，文件格式不受支持！", 5000).start();
						else {
							data.subtitles = data.Revise(data.subtitles, jt1.getText());
							new Message(f,  "校正完成，是否请以文本为准~", 5000).start();
							data.save(data.newfile, data.subtitles);
							System.out.println("保存至副本");
						}
						MPanel.jta.setText("");
						data.Display(MPanel);
					//	api.Refresh(data, SidePanel, MPanel, st_MOd, Tl_Mod, Re_Mod);
						//t.setVisible(false);
						//jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
						//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					}

					break;
				case 3:// lrc
						// 使用正则表达式匹配检验输入正确性
					String time3 = "\\d\\d \\d\\d \\d\\d";
					if (!Pattern.matches(time3, jt1.getText())) {
						new Message(f, "时间信息有误，请检查输入格式~", 3000).start();
						jt1.setForeground(new Color(195, 195, 195));
						jt1.setText("示例: XX XX XX");
					} else {
						String temp = data.Revise(data.subtitles, jt1.getText());
						if (temp == null)
							new Message(f, "校正失败，文件格式不受支持！", 5000).start();
						else {
							data.subtitles = data.Revise(data.subtitles, jt1.getText());
							new Message(f,"校正完成，是否请以文本为准~", 5000).start();
							data.save(data.newfile, data.subtitles);
							System.out.println("保存至副本");
						}
						MPanel.jta.setText("");
						data.Display(MPanel);
						//api.Refresh(data, SidePanel, MPanel, st_MOd, Tl_Mod, Re_Mod);
						//t.setVisible(false);
						//jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					//	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					}
					break;

				default:
					break;
				}

			}
		});
		
		
		
		
		jb0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (data.Mod_state) {
					//System.out.println("恢复贴靠");
					data.Mod_state = false;
					MPanel.jf_Mod.setVisible(false);//隐藏模块窗口
					MPanel.jp_Mod.add(p);//内容面板添加至承载面板
					MPanel.jp_Mod.setVisible(true);//显示贴靠面板					
					//new Message(f,  "窗口已恢复贴靠~", 2000).start();
					MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				}else {
					//System.out.println("窗口独立");
					MPanel.jp_Mod.setVisible(false);//隐藏模块面板
					MPanel.jf_Mod.add(p);
					MPanel.jf_Mod.setVisible(true);// 窗口可见
					MPanel.jf_Mod.setBounds(f.getX() + MPanel.jp_Mod.getX(), f.getY() + MPanel.jp_Mod.getY(), MPanel.jp_Mod.getWidth(), MPanel.jp_Mod.getHeight());
					data.Mod_state = true;
					//new Message(f,  "窗口已独立，可自由拖动，点击右上角再次贴靠~", 1000).start();
					MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				}
			}
		});
	}
	
}
