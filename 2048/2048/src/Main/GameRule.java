package Main;

import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class GameRule {
    private int[][] gameData;
    private static GameRule gr;

    public static GameRule getInstance() {
        if (GameRule.gr == null)
            GameRule.gr = new GameRule();
        return GameRule.gr;
    }

    private GameRule() {
        gameData = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameData[i][j] = 0;
            }
        }
    }

    public int[][] getGameData() {
        return this.gameData;
    }

    //创建一个方块，如果创建成功返回true，否则返回false表示已经无法创建方块，此时游戏应该结束
    public boolean CreateSquare() {
        Stack<Point> point = new Stack<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameData[i][j] == 0)
                    point.add(new Point(i, j));
            }
        }
        if (point.size() == 0)
            return false;
        Point p = (Point) point.toArray()[new Random(System.currentTimeMillis()).nextInt(point.size())];
        gameData[p.x][p.y] = 2;
        return true;
    }

    //所有方块向上移动,遇到数值相同的方块则合并
    public void up() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if ((gameData[i][j] != 0) && (gameData[i][j] == gameData[i][j + 1])) {
                    gameData[i][j + 1] *= 2;
                    gameData[i][j] = 0;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (gameData[i][j] == 0) {
                    for (int k = j + 1; k < 4; k++) {
                        if (gameData[i][k] != 0) {
                            gameData[i][j] = gameData[i][k];
                            gameData[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void right() {
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i > 0; i--) {
                if ((gameData[i][j] != 0) && (gameData[i][j] == gameData[i - 1][j])) {
                    gameData[i - 1][j] *= 2;
                    gameData[i][j] = 0;
                }
            }
            for (int i = 3; i > 0; i--) {
                if (gameData[i][j] == 0) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (gameData[k][j] != 0) {
                            gameData[i][j] = gameData[k][j];
                            gameData[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void left() {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if ((gameData[i][j] != 0) && (gameData[i][j] == gameData[i + 1][j])) {
                    gameData[i + 1][j] *= 2;
                    gameData[i][j] = 0;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (gameData[i][j] == 0) {
                    for (int k = i + 1; k < 4; k++) {
                        if (gameData[k][j] != 0) {
                            gameData[i][j] = gameData[k][j];
                            gameData[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void down() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if ((gameData[i][j] != 0) && (gameData[i][j] == gameData[i][j - 1])) {
                    gameData[i][j - 1] *= 2;
                    gameData[i][j] = 0;
                }
            }
            for (int j = 3; j > 0; j--) {
                if (gameData[i][j] == 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (gameData[i][k] != 0) {
                            gameData[i][j] = gameData[i][k];
                            gameData[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}
