package com.hxb.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 11:13
 */
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置面板
        Panel panel = new Panel(new BorderLayout());

        // 设置布局
        frame.setLayout(null);

        // 设置坐标和大小
        frame.setBounds(200,200,300,300);

        frame.setBackground(new Color(206, 44, 32));

        // 相对于frame的
//        panel.setBounds(50,50,100,30);
        panel.setSize(100,100);
        panel.setBackground(new Color(95, 155, 168));

        // 加一个button
        JButton button = new JButton("来了");
        panel.add(button,BorderLayout.SOUTH);
        // 将面板放进去
        frame.add(panel);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
