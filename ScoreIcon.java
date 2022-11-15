import greenfoot.*;

public class ScoreIcon extends MyScore
{
    public static boolean addScore = false;
    public static int myScore = 0;
    private ScoreLabel myScoreLabel;
    
    public ScoreIcon(ScoreLabel scoreLabel)
    {
        myScoreLabel = scoreLabel;
    }
    
    public void act()
    {
        if(HeroDead.onGameOver == false)
            myScoreLabel.setText("Score: " + myScore);
        else
            myScoreLabel.setText("Your Score: " + myScore);
    }
}