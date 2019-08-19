package com.SubTool.Log;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import com.SubTool.API.DataAPI;
import com.SubTool.API.ViewAPI;




public class UpdateLog extends JPanel{
	
	/**
	 * 更新日志
	 */
	private static final long serialVersionUID = 1L;
	//全局变量
	String version;
	
	

	
	public UpdateLog(DataAPI data,ViewAPI api) {
		
		//ViewAPI api = new ViewAPI();
		version=data.Version(1);
		this.setVisible(false);//默认隐藏
		this.setBounds(90, 50, 1070, 600);
		this.setLayout(null);
		this.setOpaque(false);
		

		JLabel l1 = new JLabel("更新日志");
		l1.setFont(new Font("微软雅黑", 1, 30));
		l1.setForeground(Color.black);
		l1.setBounds(0, 0, 200, 30);
		 add(l1);

		// 文本区
		JTextPane jta = new JTextPane();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(0, 65, this.getWidth(), this.getHeight()-75);
		jsp.setBorder(null); // 消除边框
		jsp.setBackground(null);
		jsp.setOpaque(false);

		// 分别设置水平和垂直滚动条自动出现
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.getVerticalScrollBar().setUI(api.new DemoScrollBarUI());
		// jsp.getHorizontalScrollBar().setUI(api.new DemoScrollBarUI());

		// 把JScrollPane加入到JFrame
		add(jsp, BorderLayout.NORTH);
		jta.setOpaque(false); // 设置文本区透明
		jta.setBorder(null);// 无边框
		// jta.setCaretColor(Color.WHITE); //光标颜色
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false); // 文本区边框

		// 字体风格
		Style def1 = jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def1, "微软雅黑");
		Style t1 = jta.addStyle("title", def1);
		StyleConstants.setFontSize(def1, 21);
		Style title = jta.addStyle("title", t1);
		StyleConstants.setForeground(title, Color.black);
		StyleConstants.setBold(title, true); // 字体加粗
		
		
		Style def2 = jta.getStyledDocument().addStyle(null, null);
		StyleConstants.setFontFamily(def2, "华文细黑");
		Style t2 = jta.addStyle("doc", def2);
		StyleConstants.setFontSize(def2, 18);
		Style doc = jta.addStyle("doc", t2);
		StyleConstants.setForeground(doc, Color.black);
		StyleConstants.setBold(doc, false); // 字体加粗

		try {
			jta.getDocument().insertString(jta.getDocument().getLength(), "版本号：V2.0.Alpha1"+"\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "Build Version：19018"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •内测第一版，优化了交互显示逻辑，细化部分设计，主要功能有待添加"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •完善  侧栏、设置、日志、关于、帮助等多个界面"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •适配  SRT、LRC、ASS文件的时间轴对齐功能，精度支持至毫秒（分秒）"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  修改数据处理方式，减少文件读写操作，节省资源、避免异常"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  主题混搭、六种国风字体配色，支持个性混搭"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  全局消息提示，进一步提升程序使用体验"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  小彩蛋，点击开发者三次即可见  : )"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  界面刷新导致的显示异常以及文本位置错误"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  部分因交互问题产生的异常"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •优化  调整了部分主题取色，色调减淡，便于阅读"+"\n\n", doc);

			
			jta.getDocument().insertString(jta.getDocument().getLength(), "版本号：V2.0.Alpha2"+"\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "Build Version：19033"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •完善  帮助文档相关界面"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  信息统计功能，可便捷查看文件的基础状况、以及字数、时间轴等信息 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  搜索功能和查找替换功能，初版存在一些问题，等待修复"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  功能模块面板拖动后变为独立窗口，避免遮挡"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  设置界面改版，新增若干设置项、细化设计"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  日志、帮助界面重构，侧栏按钮调整"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  开放自定义编码功能，同时移除部分暂不支持的编码选择项 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  封装主题相关参数，提高效率"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  算法和交互上存在的部分错误 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  功能窗口偏好设置不生效问题、以及窗口独立时，切换功能导致的窗口显示异常 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •其他  删除冗余代码、合并日志"+"\n\n", doc);
				
			
			jta.getDocument().insertString(jta.getDocument().getLength(), "版本号：V2.0.Alpha3"+"\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "Build Version：19044"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  设置数据保存至配置文件，设置不丢失（默认关闭） "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  自定义界面背景图，实验性功能，暂时存在一些问题 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  侧栏保存文件按钮右键支持文本另存 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  退出程序前将提示保存修改，同时开放侧栏保存按钮"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  主题相关数据结构优化，开放自定义主题色、自定义字体颜色和风格"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  添加窗口效果，界面更加自然"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  设置保存调整为默认关闭；彩蛋触发调整为三击"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  修改模块面板拖动独立为点击独立，改关闭方式为点击主界面空白处"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  取消打开其他文件窗口导致的非正常退出"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  消息提示框偶发的显示异常"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •其他  部分细节调整、bug修复 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •其他  自动保存功能存在严重错误，现已回退"+"\n\n", doc);

			
			jta.getDocument().insertString(jta.getDocument().getLength(), "版本号：V2.0.Beta"+"\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "Build Version：19047"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •新增  启动模式设置，可以选择启动时打开最后浏览的文件或是指定文件夹 "+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  字体风格设置无法从配置文件正常读取显示"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •修复  某些设置项逻辑错误导致的无效设置"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  首个公测版，代码重构，修正大量错误，提高运行速度"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  设置保存至配置文件策略由默认关闭调整为默认开启(建议开启)"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  完善具有多项选择的设置项之间的逻辑关系，并添加了一些提示"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •调整  算法优化，效率提高（并不是很明显...）"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •其他  删除冗余代码、合并日志，上传至GitHub"+"\n", doc);			

		} catch (BadLocationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		jta.setEditable(false);// 禁止修改
	}
}