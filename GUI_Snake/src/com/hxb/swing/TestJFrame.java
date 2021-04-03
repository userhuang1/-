package com.hxb.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 19:12
 */
public class TestJFrame {

    public void init(){
        JFrame frame = new JFrame();
        frame.setBounds(100,100,320,300);
        frame.setVisible(true);
        Container contentPane = frame.getContentPane(); // 这里需要使用容器来获取颜色，需要显示的初始化
        contentPane.setBackground(new Color(25, 198, 175));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestJFrame().init();
    }
}
