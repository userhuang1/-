package com.hxb.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 21:10
 */
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇");

        frame.setBounds(10,10,900,720);
        frame.setResizable(false);//  控制面板大小不可变
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new GamePanel());

        frame.setVisible(true); // 显示的操作要放在最后面蔡对，后面在修改都没用了。

    }
}
