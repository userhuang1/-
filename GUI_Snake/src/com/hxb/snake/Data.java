package com.hxb.snake;

import javax.swing.*;
import java.net.URL;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 21:35
 */
public class Data {
    // 上框
    public static URL headerURL = Data.class.getResource("statics/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    // 四个方向的头
    public static URL downURL = Data.class.getResource("statics/down.png");
    public static ImageIcon down = new ImageIcon(downURL);

    public static URL upURL = Data.class.getResource("statics/up.png");
    public static ImageIcon up = new ImageIcon(upURL);

    public static URL leftURL = Data.class.getResource("statics/left.png");
    public static ImageIcon left = new ImageIcon(leftURL);

    public static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon right = new ImageIcon(rightURL);

    // body身体
    public static URL bodyURL = Data.class.getResource("statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    //food
    public static URL foodURL = Data.class.getResource("statics/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

}
