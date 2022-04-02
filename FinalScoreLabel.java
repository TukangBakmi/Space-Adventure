import greenfoot.*;

public class FinalScoreLabel extends MyScore
{
    public FinalScoreLabel(String text)
    {
        GreenfootImage labelScore = new GreenfootImage (text.length()*60, 75);
        labelScore.setColor(Color.WHITE);
        labelScore.setFont(new Font("OptimusPrinceps", false, false , 100));
        labelScore.drawString(text, 0, 75);
        setImage(labelScore);
    }
    
    public void setText(String text)
    {
        GreenfootImage labelScore = getImage();
        labelScore.clear();
        GreenfootImage newlabelScore = new GreenfootImage (text.length()*60, 75);
        newlabelScore.setColor(Color.WHITE);
        newlabelScore.setFont(new Font("OptimusPrinceps", false, false , 100));
        newlabelScore.drawString(text, 0, 75);
        setImage(newlabelScore);
    }
    
    public void act()
    {
        setLocation(512, 400);
    }
}