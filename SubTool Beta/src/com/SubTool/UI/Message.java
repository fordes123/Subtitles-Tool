package com.SubTool.UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Message extends Thread {

	/**
	 * 消息提示框，参数为主窗口，消息内容、显示时长
	 */

	JPanel jp;
	JLabel message;
	long number;
	String text;

	public Message(JFrame f, String temp, long num) {
		// TODO 自动生成的构造函数存根

		// 消息提示框
		jp = new JPanel();
		jp.setBounds(0, 625, f.getWidth(), 55);
		jp.setBackground(new Color(59, 59, 59, 200));
		jp.setLayout(null);
		jp.setVisible(false);// 默认隐藏
		f.getLayeredPane().add(jp, new Integer(1));
		message = new JLabel("", JLabel.CENTER);
		message.setBounds(0, 10, jp.getWidth(), 30);
		message.setFont(new Font("微软雅黑", 0, 22));
		message.setForeground(Color.white);
		jp.add(message);

		number = num;
		message.setText(temp);

	}

	public void run() {
		super.run();// 启动线程
		jp.setVisible(true);// 显示面板
		try {
			sleep(number);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		jp.setVisible(false);// 默认隐藏
	}
}
