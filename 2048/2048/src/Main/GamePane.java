package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePane extends JFrame {
    private static GamePane gp;//用于保存单例模式的唯一对象
    private Graphics g;//graphics对象用户对界面进行绘图

    //私有构造函数，获取对象的方式是调用getInstance方法
    private GamePane() {
        super();
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        this.g = this.getGraphics();
    }

    //获取GamePane的唯一对象
    public static GamePane getInstance() {
        if (GamePane.gp == null)
            GamePane.gp = new GamePane();
        return GamePane.gp;
    }

    //绘制游戏界面
    public void drawing(int[][] data) {
        //获取界面宽度和界面高度
        int width = this.getWidth();
        int height = this.getHeight();
        g.setColor(new Color(85, 85, 85));
        g.fillRect(0, 0, width, height);
        //计算每个方块的宽度和高度
        double squareWidth = width * 0.225;
        double squareHeight = height * 0.2175;
        //计算方块间空隙的宽度和高度
        double spaceWidth = width * 0.02;
        double spaceHeight = height * 0.02;
        double spaceHeightS = height * 0.03;
        //两层for循环绘制4X4的方块，并根据data数组在每个方块中央写上数字
        for (int i = 0; i < 4; i++) {
            int tmpX = (int) ((squareWidth + spaceWidth) * i + spaceWidth);
            int tmpStrX = (int) (tmpX + squareWidth / 2);
            for (int j = 0; j < 4; j++) {
                int tmpY = (int) ((squareHeight + spaceHeight) * j + spaceHeight + spaceHeightS);
                int tmpStrY = (int) (tmpY + squareHeight / 2);
                g.setColor(getColor(data[i][j]));
                g.fillRect(tmpX, tmpY, (int) squareWidth, (int) squareHeight);
                if (data[i][j] != 0) {
                    g.setColor(Color.white);
                    g.drawString("" + data[i][j], tmpStrX, tmpStrY);
                }
            }
        }
    }

    public Color getColor(int num) {
        switch (num) {
            case 0:
                return new Color(248, 255, 229);
            case 2:
                return new Color(255, 196, 61);
            case 4:
                return new Color(239, 71, 111);
            case 8:
                return new Color(27, 154, 170);
            case 16:
                return new Color(6, 214, 160);
            case 32:
                return new Color(243, 118, 148);
            case 64:
                return new Color(34, 194, 214);
            case 128:
                return new Color(23, 248, 190);
            case 256:
                return new Color(255, 212, 112);
            case 512:
                return new Color(235, 24, 74);
            case 1024:
                return new Color(20, 114, 126);
            case 2048:
                return new Color(5, 164, 123);
            default:
                return null;
        }
    }
}
