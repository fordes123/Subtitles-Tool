package com.SubTool.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.SubTool.API.DataAPI;

public class About extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel jl_Dev, jl_Tilte, jl_Version, jl_Dev_Home, jl_Tilte0, jl_Build, jl_Date, jl_Copyright, jl_Online,
			jl_DevSay, jl_Terms, jl_Privacy;
	public JTextArea AboutTest;
	public int egg = 0;
	public String[] eggs;

	public About(JFrame f,DataAPI data) {
		// TODO 自动生成的构造函数存根

		this.setVisible(false);// 默认隐藏
		this.setBounds(90, 50, 1070, 620);
		this.setLayout(null);
		this.setOpaque(false);

		jl_Tilte = new JLabel("Subtitles Tool");
		jl_Tilte.setFont(new Font("华文细黑", 1, 34));
		jl_Tilte.setForeground(Color.black);
		jl_Tilte.setBounds(0, 10, 250, 40);
		add(jl_Tilte);

		jl_Version = new JLabel("内测版" + data.Version(1));
		jl_Version.setFont(new Font("微软雅黑", 0, 16));
		jl_Version.setForeground(Color.black);
		jl_Version.setBounds(0, 45, 200, 30);
		add(jl_Version);

		jl_Tilte0 = new JLabel("  『 本软件是一款免费软件，致力于简洁、高效、优雅的处理和查看字幕文本文件 』");
		jl_Tilte0.setFont(new Font("华文细黑", 1, 23));
		jl_Tilte0.setForeground(Color.black);
		jl_Tilte0.setBounds(0, 90, 900, 30);
		add(jl_Tilte0);

		jl_Dev = new JLabel("独立开发：Fordes");
		jl_Dev.setFont(new Font("华文细黑", 0, 18));
		jl_Dev.setForeground(Color.black);
		jl_Dev.setBounds(0, 150, 200, 30);
		add(jl_Dev);

		jl_Dev_Home = new JLabel("项目主页：https://github.com/fordes123/Subtitles-Tool");
		jl_Dev_Home.setFont(new Font("华文细黑", 0, 18));
		jl_Dev_Home.setForeground(Color.black);
		jl_Dev_Home.setBounds(0, 180, 700, 30);
		add(jl_Dev_Home);

		jl_Build = new JLabel("内部版本号 ：" + data.Version(2));
		jl_Build.setFont(new Font("微软雅黑", 0, 18));
		jl_Build.setForeground(Color.black);
		jl_Build.setBounds(0, 530, 200, 30);
		add(jl_Build);
		jl_Build.addMouseListener(new MouseListener() {
			
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
				new Message(f,"这意味着，在20"+data.Version(2).substring(0, 2)+"年，已经更新了"+data.Version(2).substring(3, 5)+"个内部版本" , 2000).start();
			}
		});

		jl_Date = new JLabel("编译日期 ：2019.6.23");
		jl_Date.setFont(new Font("微软雅黑", 0, 18));
		jl_Date.setForeground(Color.black);
		jl_Date.setBounds(0, 555, 200, 30);
		add(jl_Date);

		jl_Copyright = new JLabel("© 2019 Fordes  All rights reserved.");
		jl_Copyright.setFont(new Font("微软雅黑", 0, 18));
		jl_Copyright.setForeground(Color.black);
		jl_Copyright.setBounds(0, 590, 400, 30);
		add(jl_Copyright);

		AboutTest = new JTextArea();
		JScrollPane jsp = new JScrollPane(AboutTest);
		jsp.setBounds(0, 225, 800, 100);

		add(jsp);// 将含文本区的滚动面板加入到当前窗口中

		String str = "此计算机程序受版权法和国际公约保护。\n" + "未经授权擅自复制或传播本程序的部分或全部，可能遭受严厉的民\n" + "事及刑事制裁，并将在法律许可的范围内受到最大可能的起诉。";

		AboutTest.setText(str); // 文本区内容
		AboutTest.setSize(this.getWidth(), this.getHeight()); // 文本区大小
		AboutTest.setEditable(false); // 设置为不可修改
		AboutTest.setVisible(true); // 文本区是否显示
		AboutTest.setFont(new Font("华文细黑", 0, 17)); // 字体名称、样式(加粗)、磅值
		// Updatelog.insert("", 0);指定位置插入
		AboutTest.setCaretPosition(0);// 获取焦点，定位至第一行

		// 把JScrollPane加入到JFrame
		this.add(jsp, BorderLayout.NORTH);

		AboutTest.setOpaque(false); // 设置透明
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);

		jsp.setBorder(null); // 消除文本区边框
		setLayout(null); //

		jl_Online = new JLabel("联机内容");
		jl_Online.setFont(new Font("微软雅黑", 1, 20));
		jl_Online.setForeground(Color.black);
		jl_Online.setBounds(0, 335, 300, 30);
		add(jl_Online);

		jl_DevSay = new JLabel("开发者说");
		jl_DevSay.setFont(new Font("微软雅黑", 0, 18));
		jl_DevSay.setBackground(new Color(0, 128, 64));
		jl_DevSay.setBounds(0, 380, 300, 30);
		add(jl_DevSay);
		jl_DevSay.addMouseListener(new MouseListener() {
			
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
				new Message(f, "开发者没什么好说的~", 1000).start();
			}
		});
		

		jl_Terms = new JLabel("服务条款");
		jl_Terms.setFont(new Font("微软雅黑", 0, 18));
		jl_Terms.setBackground(new Color(0, 128, 64));
		jl_Terms.setBounds(0, 425, 300, 30);
		add(jl_Terms);
		jl_Terms.addMouseListener(new MouseListener() {
			
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
				new Message(f, "呃，服务条款还没有写好~", 1000).start();
			}
		});
		

		jl_Privacy = new JLabel("隐私声明");
		jl_Privacy.setFont(new Font("微软雅黑", 0, 18));
		jl_Privacy.setBackground(new Color(0, 128, 64));
		jl_Privacy.setBounds(0, 470, 300, 30);
		add(jl_Privacy);
		jl_Privacy.addMouseListener(new MouseListener() {
			
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
				new Message(f, "开源软件，没什么隐私~", 1000).start();
			}
		});
		
		String temp = "一醉江湖三十春，焉得书剑解红尘\r\n" + "枕上诗书闲处好，门前风景雨来佳。\r\n" + "半世浮萍随逝水，一宵冷雨葬名花\r\n" + "愿为西南风  长逝入君怀\r\n"
				+ "城关北上马蹄铮，从此江南唯梦生\r\n" + "我有故人抱剑去  斩尽春风未曾归\r\n" + "朱颜君未老  白发我先秋\r\n" + "此后锦书休寄  画楼云雨无凭\r\n"
				+ "四时可爱唯春日  一事能狂便少年\r\n" + "休对故人思故国 且将新火试新茶  诗酒趁年华\r\n" + "大抵浮生若梦  姑且此处销魂\r\n" + "除却君身三重雪，天下谁人配白衣\r\n"
				+ "唯有南山与君眼，相逢不改旧时青\r\n" + "饮罢千樽雪已老 孤山不见白头人\r\n" + "伤心桥下春波绿  曾是惊鸿照影来\r\n" + "梧桐半死清霜后  头白鸳鸯失伴飞\r\n"
				+ "夜寒不耐西风劲  多情却是无情病\r\n" + "寒云添暝色   老屋聚秋声\r\n" + "星光全在水  渔火欲浮天\r\n" + "江心浪险鸥偏稳  船里人多客自孤\r\n"
				+ "熏风一万里  来处是长安\r\n" + "宫娥不识中书令  借问谁家美少年\r\n" + "蝶来风有致  人去月无聊\r\n" + "怪他去后花如许  记得来时路也无\r\n"
				+ "未必美人多富贵  断无仙子不楼台\r\n" + "细认双瞳点秋水   依然竹马识君初\r\n" + "梦魂惯得无拘检 又踏杨花过谢桥\r\n" + "也曾醉酒鞭名马 生怕多情累美人\r\n"
				+ "浮云一别后  流水十年间\r\n" + "欲持一瓢酒 远慰风雨夕\r\n" + "一寸江湖刀剑错 万里山河杯间酌 \r\n" + "半生零落半生过 一任劲风拂大河\r\n"
				+ "别后不知君远近，渐行渐远渐无书\r\n" + "此时无一盏  何以叙平生\r\n" + "三杯浑白酒 几句话衷肠\r\n" + "人间便觉无清气  海内安能见古风\r\n"
				+ "我未成名君未嫁  可能俱是不如人？\r\n" + "君埋泉下泥销骨  我寄人间雪满头\r\n" + "垂死病中惊坐起  暗风吹雨入寒窗\r\n" + "世间无限丹青手  一片伤心画不成\r\n"
				+ "松门松菊何年梦  且认他乡作故乡\r\n" + "心中但有豪气在  不许岁月空凝眸\r\n" + "未必杨花不是花，如何天涯更无涯\r\n" + "长恨人心不如水  等闲平地起波澜\r\n"
				+ "满堂花醉三千客  一剑霜寒十四洲\r\n" + "故人笑比中庭树，一日秋风一日疏。\r\n" + "新妆宜面下朱楼  深锁春光一院愁\r\n" + "归来却怪丹青手 入眼平生几时有\r\n"
				+ "低眉君归处 长发绾君心\r\n" + "一身转战三千里  一剑曾挡百万师\r\n" + "人似秋鸿来有信，事如秋梦了无痕\r\n" + "一枕清风梦绿萝 人生随处是南柯.\r\n"
				+ "风云三尺剑 花鸟一书床\r\n" + "得成比目何辞死，只羡温言不羡仙。\r\n" + "十里水光心地朗 一抹花色性天空\r\n" + "似此星辰非昨夜 为谁风露立中宵\r\n"
				+ "相看两不厌  唯有敬亭山\r\n" + "唯将终夜长开眼，报答平生未展眉。\r\n" + "桃花春风一杯酒 望眼生花已十年.\r\n" + "数声风笛离亭晚，君向潇湘我向秦。\r\n"
				+ "你是云中客  我乘天外舟\r\n" + "枕山卧听叮咚泉 扶风醉写潇湘卷\r\n" + "我居北海思南海 寄雁传书谢不能\r\n" + "青瓦长忆旧时雨  朱伞深巷无故人\r\n"
				+ "人非木石皆有情 不如不遇倾城色\r\n" + "难得白发上眉梢 却叫相思到词穷\r\n" + "世间安得双全法，不负如来不负卿。\r\n" + "夜深忽梦少年事 不梦闲人不梦君\r\n"
				+ "一掊黄土收艳骨，数丈白绫掩风流。\r\n" + "捻纸作杯字为酒 君若无心我亦休.\r\n" + "久不相逢仍如故 无歌无酒是清欢.\r\n" + "玲珑骰子安红豆 入骨相思君知否\r\n"
				+ "亲朋无一字  老病有孤舟\r\n" + "细雨湿衣看不见，闲花落地听无声。\r\n" + "十里寒塘路，烟花一半醒\r\n" + "浮天水送无穷树，带雨云埋一半山。\r\n"
				+ "春水碧于天，画船听雨眠。\r\n" + "背灯和月就花阴，已是十年踪迹十年心。\r\n" + "十分冷淡存知己，一曲微茫度此生。\r\n" + "华灯一城梦 明月百年心\r\n"
				+ "爱他明月好 憔悴也相关\r\n" + "砌下乱梅如雪  拂了一身还满\r\n" + "我是清都山水郎。天教分付与疏狂\r\n" + "三杯吐然诺，五岳倒为轻\r\n"
				+ "白骨如山忘姓氏 无非公子与红妆\r\n" + "何时仗尔看南雪 我与梅花两白头\r\n" + "且就洞庭赊月色，将船买酒白云边\r\n" + "东门酤酒饮我曹，心轻万事皆鸿毛\r\n"
				+ "燕山雪花大如席，片片吹落轩辕台\r\n" + "含泪饮喜酒  吞声祝白头\r\n" + "声妓晚景从良，一世烟花无碍。\r\n" + "贞妇白头失守，半生清苦俱非。\r\n"
				+ "寂寞空庭春欲晚，梨花满地不开门。\r\n" + "起身呵手封题处  却道鸳鸯两字冰";
		eggs = temp.split("\n");// 将内容逐行放入数组

	}

}
