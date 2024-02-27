package com.SubTool.UI;

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

import com.SubTool.API.ViewAPI;


public class Help extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help(ViewAPI api) {
		// TODO 自动生成的构造函数存根

		//ViewAPI api = new ViewAPI();

		this.setVisible(false);// 默认隐藏
		this.setBounds(90, 50, 1070, 600);
		this.setLayout(null);
		this.setOpaque(false);
		// this.setBackground(Color.red);

		JLabel l1 = new JLabel("帮助文档");
		l1.setFont(new Font("微软雅黑", 1, 30));
		l1.setForeground(Color.black);
		l1.setBounds(0, 10, 200, 30);
		 add(l1);

		// 文本区
		JTextPane jta = new JTextPane();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(0, 75, this.getWidth(), this.getHeight()-75);
		jsp.setBorder(null); // 消除边框
		jsp.setBackground(null);
		jsp.getViewport().setOpaque(false); // 设置内容窗格透明
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
			jta.getDocument().insertString(jta.getDocument().getLength(), "目前主要有哪些功能？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •常见字幕文件（ASS、SRT、LRC）的查看、修改"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •字幕时间轴对齐"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •关键字查找、替换"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •文件信息统计、导出、另存等等"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "软件是免费的吗？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •SubTool目前所有功能都是免费的，而且也将一直免费下去"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •我们已经计划开源，当然，这将是在内测结束，功能完善之后"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "软件以后会新增更多功能吗？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •内测阶段以稳定为主，当然，新功能肯定会有的"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •计划添加更好主题功能，开放自定义背景图，以及更好看的皮肤"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •同时将面向字幕制作，添加相关的功能（划掉）"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •在对现有字幕文本的处理上会细化更多功能"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "我的文件打开后显示不全或是乱码的？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •这个问题主要是因为文件编码不同导致的，虽然我们已经内置了自动读取编码，但仍时有失误"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •解决方法是，设置>功能设置>自定义编码，尝试自行调整一下"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "经常弹窗提醒已自动保存修改？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •自动保存修改是默认开启的，旨在防止进度丢失"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •如不需要此功能，可在，设置>功能设置>自动保存修改，取消勾选即可"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •后期将会添加撤销修改按钮，以防止操作失误，这项功能会在内测版上率先测试"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "对于查找替换里面的选项不太理解？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •目前，查找替换功能中由四个操作选项，其中有三个选项是默认开启的"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •区分大小写适用于英文和单词，即字面上的意思，应该很好理解"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •单步搜索则使你在搜索关键字时，点击一次查找一个，如关闭之，它将一次搜索出所有关键字"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •全体替换，顾名思义，开启此项后，点击一下替换将替换掉所有关键字，否则如上，点击一次替换一个"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •智能过滤使得查找替换操作过滤掉时间轴，以免损坏关键信息，它是默认开启的，同时也建议不要关闭"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "查找替换时破坏了时间轴？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •查找替换默认会开启智能过滤，理论上不会处理到时间轴，建议检查一下相关设置"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •当然如你没有开启自动保存，也没有手动保存，那么这一修改不会生效(对于文件而言)"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •同样的，后期的撤销功能上线，或许会对这一失误挽回有所帮助"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "关于设置偏好保存配置文件？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •这项功能是为了避免重复设置软件所准备的，虽然它是默认关闭的，会在程序目录下生成一个配置文件"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •当在设置里面关闭这项功能后，配置文件仍然会生成，不过它会在退出程序后自动删除"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •注意，配置文件的优先级高于程序预设，所以当开启设置保存的时候，程序预设不会生效"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "什么是主题混搭？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •软件预置主题了一些全局主题，而开启了主题混搭，可以分别设置侧栏和主界面主题"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •同时，主题混搭提供自定义颜色选择，也就是说除了预置主题色，可自行取色设置颜色"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •注意，因主题混搭和自定义背景图存在兼容问题，此项功能为实验性功能，仅开放于测试版"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "打开不受支持的文件会怎么样？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •理论上是打不开不受支持的文件的"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •如果你打开了，基础功能也可以正常使用，当然，这样很可能导致一些未知问题"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "信息统计功能显示的信息有误？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •信息统计功能的部分信息（如字数统计）仅供参考，有一定误差属正常"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •如果显示的信息有明显错误（注意不是误差），那么可能是BUG，可以提交反馈，等待开发者修复"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •注意，由于算法上的一些问题，现移除统计信息中的字数统计，后期修正"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "软件各版本之间有什么差别，以及如何获取更新？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •目前软件分两种版本，公测版(Beta)和内测版(Alpha)，内部版本号则是更新迭代记录用，无实际意义"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •公测版是开放版本，同时也相较稳定，内测版本目前仅用于开发者调试使用"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •软件目前不支持内部热更新，同时也没有添加相关支持的计划，获取更新请移步项目主页"+"\n\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "我的问题没有在帮助文档中找到？"+"\n\n", title);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •帮助文档只列举了一些常见问题，更多问题可至项目主页：https://github.com/fordes123/Subtitles-Tool，提交反馈"+"\n", doc);
			jta.getDocument().insertString(jta.getDocument().getLength(), "  •或者发送邮件至 ec.cheng.16888@gmail.com，以联系作者"+"\n\n", doc);
			
		} catch (BadLocationException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		jta.setEditable(false);// 禁止修改

	}

}
