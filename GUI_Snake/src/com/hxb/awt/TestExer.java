package com.hxb.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 11:56
 */
public class TestExer {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 先对总体进行设置
        frame.setBounds(300,300,400,400);
//        frame.setBackground(new Color(1,1,1));
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));


        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2,1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2,2));

        p1.add(new Button("1在"),BorderLayout.WEST);
        p1.add(new Button("2"),BorderLayout.EAST);
//        p2.add(new Button("中上"),BorderLayout.NORTH);
//        p2.add(new Button("中下"),BorderLayout.SOUTH);
        p2.add(new Button("3"));
        p2.add(new Button("4"));
        p1.add(p2, BorderLayout.CENTER);

        p3.add(new Button("5"),BorderLayout.WEST);
        p3.add(new Button("6"),BorderLayout.EAST);
        for (int i = 0; i < 4; i++) {
            p4.add(new Button("for +"+i));
        }
        p3.add(p4,BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);


        // 添加监听时间，实现关闭操作
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
