package com.hxb.awt;

import java.awt.*;

/**
 *
 * 测试frame的使用
 * @Author: hxb
 * @CreateTime: 2021-04-02 10:38
 */
public class TestFrame {
    public static void main(String[] args) {
        Frame frame = new Frame("我的第一个Javagui窗口");
        // 设置可见性
        frame.setVisible(true);

        // 设置大小
        frame.setSize(300,300);

        //设置颜色
        frame.setBackground(new Color(95, 155, 168));

        // 设置弹出的位置
        frame.setLocation(300,300);

        // 设置大小固定
        frame.setResizable(false);
    }
}
