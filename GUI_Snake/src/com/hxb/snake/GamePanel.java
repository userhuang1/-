package com.hxb.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @Author: hxb
 * @CreateTime: 2021-04-02 21:21
            */

    // KeyListener是键盘监听事件，ActionListener是定时器
    public class GamePanel extends JPanel implements KeyListener, ActionListener {

        // 定义蛇的数据结构
        int length ; // 蛇的长度
        int[] snakex = new int[600]; // 脑袋在【0,0】，后面的开始【1,1】，【2,2】。。。。
        int[] snakey = new int[600];
        String dict; // 蛇头的方向

        // 游戏当前的状态
        boolean isstart = false;

        // 判定失败
        boolean isFail = false;

        // 再来个积分
        int score ;

    //在来个食物
    int foodx;
    int foody;
    Random ramdom = new Random();



    //定时器
    Timer timer = new Timer(100,this);// 100毫秒执行一次

    // 空参构造器
    public GamePanel() {
        init();
        // 获得焦点和键盘事件
        this.setFocusable(true); //  获得焦点事件
        this.addKeyListener(this);// 获得键盘的监听事件

        timer.start();
    }

    // 初始化对象 开始小蛇长度为三
    public void init(){
        length = 3;                       //  代表脑袋
        snakex[0] = 100; snakey[0] = 100; //  这里的y都不需要变化， 每一小格是25个px（像素）
        snakex[1] = 75;  snakey[1] = 100;
        snakex[2] = 50;  snakey[2] = 100;
        dict = "R"; // 初始方向向右

        //把食物随机分布在界面上
        foodx = 25 + 25*ramdom.nextInt(34);
        foody = 75 + 25*ramdom.nextInt(24);

        score = 0;
    }





    // 这个方法会自动执行
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 清屏，不清的话会闪烁

        // 绘制静态的面板
        this.setBackground(Color.white);
        Data.header.paintIcon(this,g,25,11);
        // 画一个矩形（黑框）
        g.fillRect(25,75,850,600); //  默认的游戏界面

        // 画积分
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度为" + length,750,35);
        g.drawString("分数为" + score,750,55);



        // 把小蛇画上去
        //Data.right 是一个ImageIcon (图像坐标）
        if(dict.equals("R")){
            Data.right.paintIcon(this,g,snakex[0],snakey[0]);
        } else if(dict.equals("L")){
            Data.left.paintIcon(this,g,snakex[0],snakey[0]);
        }else if(dict.equals("U")){
            Data.up.paintIcon(this,g,snakex[0],snakey[0]);
        }else if(dict.equals("D")){
            Data.down.paintIcon(this,g,snakex[0],snakey[0]);
        }
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakex[i],snakey[i]); // 这里是身体了，不是蛇头,
            // 最后的两个参数代表的是x，y的坐标位置
        }

        // 把食物放上去
        Data.food.paintIcon(this,g,foodx,foody);


        //游戏状态
        if(isstart == false){
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }

        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("失败，按下空格重新开始",300,300);
        }
    }


    // 键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // 获得键盘按键是哪一个
        if(key == KeyEvent.VK_SPACE){
            if(isFail){
                isFail = false;
                init();
            }else{
                isstart = !isstart;
            }
            repaint();
//            isstart = !isstart;
//            repaint();
        }
        if(key == KeyEvent.VK_UP){
            dict = "U";
        } else if(key == KeyEvent.VK_DOWN){
            dict = "D";
        } else if(key == KeyEvent.VK_LEFT){
            dict = "L";
        } else if(key == KeyEvent.VK_RIGHT){
            dict = "R";
        }
    }

    // 事件监听（定时方法）  --- 通过固定事件来刷新，比如一秒十次（上面搞一个定时器）
    @Override
    public void actionPerformed(ActionEvent e) {

        //吃食物
        if(foodx == snakex[0] && foody == snakey[0]){
            length++;

            // 加分数
            score += 10;

            //把食物随机分布在界面上
            foodx = 25 + 25*ramdom.nextInt(34);
            foody = 75 + 25*ramdom.nextInt(24);
        }

        if(isstart && isFail == false){

            // 身体走向，不用改变
            for(int i = length - 1;i > 0 ; i--){ // 后一节移到前一节的身体
                snakex[i] = snakex[i-1];
                snakey[i] = snakey[i-1];
            }

            // 头部走向
            if(dict.equals("R")){
                snakex[0] = snakex[0] + 25;
                if(snakex[0] > 850){snakex[0] = 25;}
            } else if(dict.equals("L")){
                snakex[0] = snakex[0] - 25;
                if(snakex[0] < 25){snakex[0] = 850;}
            } else if(dict.equals("U")){
                snakey[0] = snakey[0] - 25;
                if(snakey[0] < 75){snakey[0] = 650;}
            } else if(dict.equals("D")){
                snakey[0] = snakey[0] + 25;
                if(snakey[0] > 650){snakey[0] = 75;}
            }

            // 失败判定
            for (int i = 1; i < length; i++) {
                if(snakey[0] == snakey[i] && snakex[0] == snakex[i]){
                    isFail = true;
                }
            }

            repaint(); // 重画画面
        }
        timer.start(); // 定时器开始
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
