package com.hxb.awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 15:29
 */
public class TestFiled {
    public static void main(String[] args) {
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);  //  这里可以不用写frame。
        setVisible(true);

        myActionListener2 my = new myActionListener2();
        textField.addActionListener(my);

        pack();
    }
}

class myActionListener2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println(e.getActionCommand());
        TextField text = (TextField) e.getSource();
        System.out.println(text.getText()); // 获得输入框的文本
        text.setText(""); //  设置为空字符串
    }
}