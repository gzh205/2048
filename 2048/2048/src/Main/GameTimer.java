package Main;

import java.util.TimerTask;

public class GameTimer extends TimerTask {
    @Override
    public void run()
    {
        GamePane.getInstance().drawing(GameRule.getInstance().getGameData());
    }
}
