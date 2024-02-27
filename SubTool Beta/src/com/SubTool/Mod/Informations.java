package com.SubTool.Mod;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import com.SubTool.API.DataAPI;
import com.SubTool.API.ViewAPI;
import com.SubTool.UI.MainPanel;

public class Informations extends JPanel{

	/**
	 * 字幕信息统计模块
	 * 
	 * 已知问题：汉字和单词数量统计暂不可用
	 */
	private static final long serialVersionUID = 1L;

	public JTextPane jp;
	public JLabel jl;
	public JButton jb0;
	
	public Informations(JFrame f,MainPanel MPanel,DataAPI data, ViewAPI api) {
		// TODO 自动生成的构造函数存根
		this.setBorder(null);
		this.setSize(330, 630);
		this.setBounds(0, 0, 330, 630);
		this.setBackground(data.theme.sidecolor);
		this.setLayout(null);
		this.setVisible(false);//默认隐藏
		JPanel p=this;
		
		jp = new JTextPane();
		jp.setBounds(15, 80, this.getWidth() - 15, this.getHeight() - 80);
		jp.setBorder(null);// 无边框
		jp.setCaretColor(Color.WHITE); // 光标颜色
		jp.setOpaque(false); // 文本区边框
		this.add(jp);

		jl = new JLabel("信息统计");
		jl.setFont(new Font("微软雅黑", 0, 23));
		jl.setForeground(Color.white);
		jl.setBounds(10, 10, 200, 30);
		this.add(jl);

		// 功能面板贴靠按钮
		jb0 = new JButton();
		jb0.setBounds(this.getWidth() - 40, 10, 28, 28);
		api.setIcon("/res/t.png", jb0, 28, 28);
		jb0.setOpaque(false); // 透明
		jb0.setBorder(null); // 颜色为空
		jb0.setBackground(new Color(255, 255, 255)); // 必须设置颜色后才可以设置透明
		jb0.setFocusPainted(false);// 去除按钮点击焦点
		this.add(jb0);
		
		// 设置行距
		SimpleAttributeSet a = new SimpleAttributeSet();
		StyleConstants.setLineSpacing(a, 0.3f); // 此处设定行间距
		jp.setParagraphAttributes(a, false);
		
		Style def1 = jp.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def1, "微软雅黑");
		Style t1 = jp.addStyle("title", def1);
		StyleConstants.setFontSize(def1, 20);
		Style title = jp.addStyle("title", t1);
		StyleConstants.setForeground(title, Color.white);
		StyleConstants.setBold(title, true); // 字体加粗

		Style def2 = jp.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def2, "华文细黑");
		Style t2 = jp.addStyle("doc", def2);
		StyleConstants.setFontSize(def2, 18);
		Style doc = jp.addStyle("doc", t2);
		StyleConstants.setForeground(doc, Color.white);
		StyleConstants.setBold(doc, false); // 字体加粗

		try {
			jp.getDocument().insertString(jp.getDocument().getLength(), "• 基础信息", title);
			if (data.file.getName().length() > 12)
				jp.getDocument().insertString(jp.getDocument().getLength(),
						"\n     文件名：" + data.file.getName().substring(0, 12) + "...", doc);
			else
				jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件名：" + data.file.getName(), doc);
			// 根据类型载入预设字体
			switch (data.type) {
			case 1:
				jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件类型：SRT字幕文件", doc);
				break;
			case 2:
				jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件类型：ASS特效字幕", doc);
				break;
			case 3:
				jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件类型：LRC歌词文件", doc);
				break;

			default:// 默认类型
				jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件类型：不受支持", doc);
				break;
			}
			long leng = data.file.length();
			String l;
			int i = 0;
			while (leng > 1024) {
				leng = leng / 1024;
				i++;
			}

			switch (i) {
			case 0:
				l = leng + "B";
				break;
			case 1:
				l = leng + "KB";
				break;
			case 2:
				l = leng + "MB";
				break;
			case 3:
				l = leng + "GB";
				break;
			case 4:
				l = leng + "TB";
				break;
			case 5:
				l = leng + "PB";
				break;
			default:
				l = leng + "(无法识别的大小)";
				break;
			}
			jp.getDocument().insertString(jp.getDocument().getLength(), "\n     编码方式：" + data.way, doc);
			jp.getDocument().insertString(jp.getDocument().getLength(), "\n     文件大小：" + l, doc);

			jp.getDocument().insertString(jp.getDocument().getLength(), "\n\n• 字数统计", title);
			jp.getDocument().insertString(jp.getDocument().getLength(), "\n     汉字和单词：" + "暂无信息", doc);
			jp.getDocument().insertString(jp.getDocument().getLength(), "\n     字符数（含空格）：" + data.file.length(), doc);
			jp.getDocument().insertString(jp.getDocument().getLength(),
					"\n     字符数（不含空格）：" + data.subtitles.replaceAll(" ", "").length(), doc);

			jp.getDocument().insertString(jp.getDocument().getLength(), "\n\n• 时间轴信息", title);
			jp.getDocument().insertString(jp.getDocument().getLength(),
					"\n     时间起点：" + data.extime(data.subtitles, data.type)[0], doc);
			jp.getDocument().insertString(jp.getDocument().getLength(),
					"\n     时间终点：" + data.extime(data.subtitles, data.type)[1], doc);
			jp.getDocument().insertString(jp.getDocument().getLength(), "\n     对话数：" + data.extime(data.subtitles, data.type)[2],
					doc);

		} catch (BadLocationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		jp.setEditable(false);// 禁止修改
		jb0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//st_MOd.setVisible(true);
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
