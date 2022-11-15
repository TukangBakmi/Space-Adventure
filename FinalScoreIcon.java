import greenfoot.*;

public class FinalScoreIcon extends MyScore
{
    private FinalScoreLabel myScoreLabel;
    int score = 0;
    
    public FinalScoreIcon(FinalScoreLabel scoreLabel)
    {
        myScoreLabel = scoreLabel;
    }
    
    public void act()
    {
        if(score <= ScoreIcon.myScore-10)
        {
            myScoreLabel.setText("" + score);
            score += 10;
        }
        else
        {
            myScoreLabel.setText("" + ScoreIcon.myScore);
        }
    }
}