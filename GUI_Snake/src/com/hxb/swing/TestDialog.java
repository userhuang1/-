package com.hxb.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 19:28
 */

// 弹窗的实现
public class TestDialog extends JFrame {
    public TestDialog(){
        this.setVisible(true);
        this.setBounds(100,100,600,500);
        // 关闭操作
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 放东西，容器
        Container contentPane = this.getContentPane();
        contentPane.setBackground(new Color(23,234,233));

        // 没有这一行会无法定位到某个特定位置上，需要开启绝对定位，
        contentPane.setLayout(null);

        JButton jButton = new JButton("点击生成弹窗！！！");
        jButton.setBounds(100,100,200,50);
        jButton.setBackground(Color.GREEN);

        // 需要添加进去
        contentPane.add(jButton);

        // 监听事件
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  //  监听器
                // 需要写一个弹窗
                new MyDialog();
            }
        });

    }

    public static void main(String[] args) {
        new TestDialog();
    }
}


// 弹窗的窗口
class MyDialog extends JDialog{
    public MyDialog() {
        this.setVisible(true);
        this.setBounds(100,100,200,200);
        Container contentPane = this.getContentPane();

        // 设置绝对定位
        contentPane.setLayout(null);

        contentPane.add(new Label("蔡某叫你学Java"));

    }


}