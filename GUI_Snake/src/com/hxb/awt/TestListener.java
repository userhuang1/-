package com.hxb.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 15:13
 */
public class TestListener {
    public static void main(String[] args) {
        Button button2 = new Button("start");
        Button button1 = new Button("stop");
        myActionListener my = new myActionListener();

        // 这里才是 添加监听事件
        button1.addActionListener(my);
        button2.addActionListener(my);

        Frame frame = new Frame();
        frame.setBounds(200,200,300,300);
        frame.add(button1,BorderLayout.WEST);
        frame.add(button2,BorderLayout.EAST);

        frame.pack(); // 自适应的
        frame.setVisible(true);
    }
}


class myActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮点击了：" + e.getActionCommand());
    }
}