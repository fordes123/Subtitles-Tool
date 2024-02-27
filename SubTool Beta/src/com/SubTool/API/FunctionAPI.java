package com.SubTool.API;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.SubTool.Log.UpdateLog;
import com.SubTool.Mod.Informations;
import com.SubTool.Mod.Replace;
import com.SubTool.Mod.Timeline;
import com.SubTool.UI.About;
import com.SubTool.UI.Help;
import com.SubTool.UI.MainPanel;
import com.SubTool.UI.Message;
import com.SubTool.UI.Setting;
import com.SubTool.UI.Side;

public class FunctionAPI {

	// 全局变量
	private JFrame f;
	private DataAPI data;
	private ViewAPI api;
	private ColorAPI color;
	private Side SidePanel;
	private MainPanel MPanel;
	private Setting setting;
	private About about;
	private Help help;
	private UpdateLog log;
	private Informations st_MOd;
	private Timeline Tl_Mod;
	private Replace Re_Mod;

	public FunctionAPI(JFrame f, DataAPI data, ViewAPI api, ColorAPI color, Side SidePanel, MainPanel MPanel,
			Setting setting, About about, Help help, UpdateLog log, Informations st_MOd, Timeline Tl_Mod,
			Replace Re_Mod) {
		// TODO 自动生成的构造函数存根
		this.data = data;
		this.api = api;
		this.color = color;
		this.SidePanel = SidePanel;
		this.MPanel = MPanel;
		this.setting = setting;
		this.about = about;
		this.help = help;
		this.log = log;
		this.f = f;
		this.st_MOd = st_MOd;
		this.Tl_Mod = Tl_Mod;
		this.Re_Mod = Re_Mod;

		// 侧栏控制按钮事件
		SidePanel.jb_Menu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// t.setVisible(false);
				if (!SidePanel.side_state) { // 侧边展开
					SidePanel.sidecut(false);
					SidePanel.jb_Return.setVisible(false); // 侧边展开时隐藏返回按钮
				} else { // 侧边收回
					SidePanel.sidecut(true);
					if (!MPanel.jsp.isShowing())
						SidePanel.jb_Return.setVisible(true); // 侧边回收时，如主界面处于隐藏状态，则显示返回按钮
				}
			}
		});
		// 侧栏设置按钮
		SidePanel.jb_Setting.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(0);
				setting.setVisible(true);
				data.SettingState = true;// 表示设置界面被打开

			}
		});

		// 侧栏搜索按钮事件
		SidePanel.jb_Search_Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(1);// 显示主界面
				SidePanel.sidecut(false);
				// 清空提示语并使输入框获得焦点
				SidePanel.jt_Search.setText("");
				SidePanel.jt_Search.requestFocus();
			}
		});

		// 关于菜单项事件
		MPanel.jmi_AboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				hide(0);// 隐藏主界面
				about.setVisible(true);

			}
		});

		// 帮助菜单项事件
		MPanel.jmi_HelpItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				hide(0);// 隐藏主界面
				help.setVisible(true);
			}
		});

		// 更新日志菜单项事件
		MPanel.jmi_UpdateItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				hide(0);// 隐藏主界面
				log.setVisible(true);
			}
		});

		// 返回主界面
		SidePanel.jb_Return.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hide(1);
			}
		});

		// 退出程序按钮
		MPanel.jb_Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (setting.L3_j7.isSelected()) {// 需要记住文件路径
					data.workmode = data.file.getAbsolutePath();
					// System.out.println("文件路径："+data.workmode);
				}
				data.saveconfig(setting);//退出前保存一下配置文件
				if (!setting.L3_j6.isSelected()) {// 检测是否开启了保存设置，如未开启，将删除配置文件
					// System.out.println("已删除配置文件...");
					data.rmconfig();
				}	
				data.newfile.delete();
				new File(System.getProperty("user.dir") + "\\guide.lrc").delete();
				System.exit(0);
			}
		});

		// 彩蛋事件
		about.jl_Dev.addMouseListener(new MouseListener() {

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
				// 彩蛋
				Random random = new Random();
				if (e.getClickCount() == 2)
					new Message(f, "\"" + about.eggs[random.nextInt(about.eggs.length)] + "\"", 1000).start();

			}
		});

		SidePanel.jb_Open.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(1);
				data.file = data.openfile(f);
				if (data.file == null)
					new Message(f, "" + "操作被取消~", 3000).start();
				else {
					data.newfile.delete();// 删除原副本文件
					// ;//读取配置文件
					data.Analysis(data.file);// 读取文件类型和编码
					// 在原目录下生成副本文件
					String suffix = data.file.getName().substring(data.file.getName().lastIndexOf(".") + 1);// 后缀名
					String filename1 = "."
							+ data.file.getName().substring(0, data.file.getName().length() - suffix.length() - 1); // 获取纯文件名

					data.newfile = new File(data.file.getParent(), filename1 + "-副本." + suffix);// 生成副本
					try {
						data.newfile.createNewFile();
					} catch (IOException e2) {
						// TODO 自动生成的 catch 块
						// e2.printStackTrace();
						new Message(f, "权限不足！生成副本文件失败，请检查权限！", 5000);
						System.exit(0);
					}
					data.subtitles = data.Read(data.file, setting.L3_j2.isSelected(),
							(String) setting.L3_j3.getSelectedItem());// 读取文件内容到主界面
					api.Refresh(data, SidePanel, MPanel, st_MOd, Tl_Mod, Re_Mod);
					new File(System.getProperty("user.dir") + "\\guide.lrc").delete();
				}
				SidePanel.sidecut(true);
			}

		});

		/*
		 * ===============================================
		 * 
		 * 保存与另存
		 * 
		 * ================================================
		 */
		SidePanel.jb_Save.addMouseListener(new MouseListener() {

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
				if (e.isMetaDown()) {// 检测鼠标右键单击
					FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
					JFileChooser fc = new JFileChooser();
					fc.setFileFilter(filter);
					fc.setMultiSelectionEnabled(false);
					int result = fc.showSaveDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file1 = fc.getSelectedFile();
						if (!file1.getPath().endsWith(".txt")) {
							file1 = new File(file1.getPath() + ".txt");
						}
						// System.out.println("file path="+file.getPath());
						FileOutputStream fos = null;
						try {
							if (!file1.exists()) {// 文件不存在 则创建一个
								file1.createNewFile();
							}
							fos = new FileOutputStream(file1);
							fos.write(MPanel.jta.getText().getBytes());
							fos.flush();
						} catch (IOException e1) {
							new Message(f, "文件另存失败~", 2000).start();
							// System.err.println("文件创建失败：");
							e1.printStackTrace();
						} finally {
							if (fos != null) {
								try {
									fos.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
						new Message(f, "文本已另存为" + file1.getName(), 2000).start();
					}

				} else {
					data.save(data.file, data.Read(data.newfile, true, data.way));// 将修改保存至原文件

					new Message(f, "所有修改已保存至文件~", 2000).start();
					SidePanel.sidecut(true);
				}
			}
		});

		// 删除
		SidePanel.jb_Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Object[] options = { "确定", "取消" };
				int Re = JOptionPane.showOptionDialog(f, "删除源文件的同时将退出程序，是否继续？", "此操作不可逆", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				System.out.println(Re);
				if (Re == 0) {// 删除文件
					if (!setting.L3_j6.isSelected()) {
						System.out.println("已删除配置文件...");
						data.rmconfig();
					}
					// 检测是否开启了保存设置，如未开启，将删除配置文件
					if (data.file.delete() && data.newfile.delete())
						new Message(f, "删除完成~程序即将退出", 3000).start();
					else
						new Message(f, "删除异常，请以实际结果为准~", 3000).start();
					System.exit(0);
				} else {// 取消操作
					SidePanel.sidecut(true);
				}
			}
		});

		// 模块面板事件
		MPanel.jta.addMouseListener(new MouseListener() {

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
				if (data.Mod) {
					// System.out.println("点了一下文本区");

					// MPanel.jf_Mod.setVisible(false);
					MPanel.jp_Mod.setVisible(false);
					MPanel.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);// 水平滚动条隐藏
					MPanel.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					data.Mod = false;
				} // 当模块面板显示时，点一下文本区关闭模块面板
			}
		});

		/*
		 * ==================================================
		 * 
		 * @自由修改按钮事件
		 * 
		 * =================================================
		 */

		SidePanel.jb_Free.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// free();
				// filestate=false;
			}
		});

		SidePanel.jl_Free_Title.addMouseListener(new MouseListener() {

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
				// free();
				// filestate=false;
				SidePanel.jb_Free.doClick();
			}
		});

		/*
		 * =============================================== 时间轴对齐按钮事件
		 * ================================================
		 */
		SidePanel.jb_Timeline.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(1);
				st_MOd.setVisible(false);
				Tl_Mod.setVisible(true);
				Re_Mod.setVisible(false);
				data.Mod = true;
				if (setting.L3_j4.isSelected()) {
					// System.out.println("设置为窗口默认独立");
					data.Mod_state = false;
					Tl_Mod.jb0.doClick();
				} else {
					// System.out.println("设置为窗口默认贴靠");
					data.Mod_state = true;
					Tl_Mod.jb0.doClick();
				}
				// Timeline();
				// filestate=false;
			}
		});

		SidePanel.jl_Timeline_Title.addMouseListener(new MouseListener() {

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
				SidePanel.sidecut(true);
				SidePanel.jb_Timeline.doClick();
			}
		});

		/*
		 * =============================================== 关键字替换
		 * ================================================
		 */
		SidePanel.jb_Replace.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(1);
				st_MOd.setVisible(false);
				Tl_Mod.setVisible(false);
				Re_Mod.setVisible(true);
				data.Mod = true;
				if (setting.L3_j4.isSelected()) {
					// System.out.println("设置为窗口默认独立");
					data.Mod_state = false;
					Re_Mod.jb0.doClick();
				} else {
					// System.out.println("设置为窗口默认贴靠");
					data.Mod_state = true;
					Re_Mod.jb0.doClick();
				}
			}
		});

		SidePanel.jl_Replace_Title.addMouseListener(new MouseListener() {

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
				SidePanel.sidecut(true);
				// hide(1);
				// filestate=false;
				// replace();
				SidePanel.jb_Replace.doClick();
			}
		});

		/*
		 * =============================================== 信息统计
		 * ================================================
		 */
		SidePanel.jb_Statistics.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// System.out.println("按键正常");
				hide(1);
				st_MOd.setVisible(true);
				Tl_Mod.setVisible(false);
				Re_Mod.setVisible(false);
				data.Mod = true;
				if (setting.L3_j4.isSelected()) {
					// System.out.println("设置为窗口默认独立");
					data.Mod_state = false;
					st_MOd.jb0.doClick();
				} else {
					// System.out.println("设置为窗口默认贴靠");
					data.Mod_state = true;
					st_MOd.jb0.doClick();
				}
				// st_MOd.setVisible(true);

			}
		});

		SidePanel.jl_Statistics_Title.addMouseListener(new MouseListener() {

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
				SidePanel.sidecut(true);
				SidePanel.jb_Statistics.doClick();
				// new Message(jp, message, "该功能尚未适配完成~", 2000).start();
			}
		});

		/*
		 * =============================================== 待定功能
		 * ================================================
		 */
		SidePanel.jb_More.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				hide(1);
				new Message(f, "该功能开发者还没有想好啦~", 2000).start();
			}
		});

		SidePanel.jl_More_Title.addMouseListener(new MouseListener() {

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
				SidePanel.sidecut(true);
				SidePanel.jb_More.doClick();
			}
		});

		MPanel.jp_Mod.addMouseListener(new MouseListener() {

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
				// MPanel.jp_Mod_Bottom.setVisible(false);
			}
		});

		/*
		 * =============================================== 搜索框
		 * ================================================
		 */
		SidePanel.jt_Search.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				SidePanel.jt_Search.setText("");
			}
		});

		SidePanel.jt_Search.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				// String keyText = KeyEvent.getKeyText(e.getKeyCode());
				// System.out.println(keyText); //输出按下的按键
				// SidePanel.jt1.setText("");
				int number = 0;
				int keyCode = e.getKeyCode();// 获得与此事件中的键相关联的字符
				switch (keyCode) {
				case KeyEvent.VK_ENTER: // 判断按下的是否为回车键
					// System.out.print("回车键被按下");
					// new Message(jp, message, "搜索 功能还没有完善呢~", 2000).start();
					if (!SidePanel.jt_Search.getText().trim().equals("")) {
						// System.out.println("开始搜索 " + "\"" + SidePanel.jt1.getText() + "\"");
						hide(1);
						SidePanel.sidecut(false);
						number = data.search(MPanel, SidePanel.jt_Search.getText(), false, false);
						SidePanel.sidecut(true);
						System.out.println(number);
						if (number < 0)
							new Message(f, "搜索完毕，未发现关键字~", 2000).start();
						else
							new Message(f, "搜索完成，共找到 " + number + " 个关键字，已做出标记", 4000).start();
					}
					SidePanel.jt_Search.setText("");// 无效输入，清空
					break;
				}
			}
		});
	}

	/*
	 * ======================= hide函数隐藏和显示主文本区 =======================
	 */

	public void hide(int s) {

		setting.setVisible(false);
		log.setVisible(false);
		about.setVisible(false);
		help.setVisible(false);
		MPanel.jf_Mod.setVisible(false);
		MPanel.jp_Mod.setVisible(false);
		data.Mod = false;
		// data.Mod_state=false;
		// t.setVisible(false);
		// if (state)
		// tf.setVisible(false);

		if (s == 0) { // 参数0表示隐藏主文本区，并显示返回文本区按钮

			MPanel.jsp.setVisible(false);
			SidePanel.jb_Return.setVisible(true);// 返回按钮
			// if(FunctionState) {//检测自由修改状态，并保存之
			// FunctionState=false;
			// data.save(newfile, jta.getText());//文件保存至副本
			// new Message(jp, message, "自由修改模式已关闭~", 2000).start();
			// filestate=false;
			// }

		}
		if (s == 1) { // 参数1表示显示主文本区，并隐藏返回文本区按钮
			// p.setVisible(false);
			// log.setVisible(false);
			if (data.SettingState) {
				api.SetTheme(setting, data, color, MPanel, f);
				api.Refresh(data, SidePanel, MPanel, st_MOd, Tl_Mod, Re_Mod);
				data.saveconfig(setting);// 读取设置保存至配置文件
				data.SettingState = false;
				new Message(f, "设置已更新 : )", 2000).start();
			}

			MPanel.jsp.setVisible(true);
			SidePanel.jb_Return.setVisible(false);

			// SidePanel.jb0.setEnabled(true);
			// 分别设置水平和垂直滚动条自动出现
			// jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			// jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

			// Refresh();
		}

	}

}
