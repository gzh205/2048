package Main;

import java.awt.event.*;
import java.util.Timer;

public class Game {
    public static void main(String[] args) {
        GameRule rule = GameRule.getInstance();
        GameTimer gt = new GameTimer();
        GamePane.getInstance().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: {
                        rule.up();
                        init();
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        rule.down();
                        init();
                        break;
                    }
                    case KeyEvent.VK_LEFT: {
                        rule.left();
                        init();
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        rule.right();
                        init();
                        break;
                    }
                }
            }
        });
        GamePane.getInstance().addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        init();
        Timer timer = new Timer();
        timer.schedule(new GameTimer(), 200, 1);
    }

    public static void init() {
        GameRule rule = GameRule.getInstance();
        GamePane gp = GamePane.getInstance();
        if (rule.CreateSquare()) {
            gp.drawing(rule.getGameData());
        } else {
            System.out.println("游戏结束!!!");
            gp.addKeyListener(null);
        }
    }
}
