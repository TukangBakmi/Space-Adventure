import greenfoot.*;

public class ScoreLabel extends MyScore
{
    public ScoreLabel(String text)
    {
        GreenfootImage labelScore = new GreenfootImage (text.length()*35, 44);
        labelScore.setColor(Color.WHITE);
        labelScore.setFont(new Font("OptimusPrinceps", false, false , 30));
        labelScore.drawString(text, 0, 34);
        setImage(labelScore);
    }
    
    public void setText(String text)
    {
        GreenfootImage labelScore = getImage();
        labelScore.clear();
        GreenfootImage newlabelScore = new GreenfootImage (text.length()*35, 44);
        newlabelScore.setColor(Color.WHITE);
        newlabelScore.setFont(new Font("OptimusPrinceps", false, false , 30));
        newlabelScore.drawString(text, 0, 34);
        setImage(newlabelScore);
    }
    
    public void act()
    {
        if(HeroDead.onGameOver == false)
            setLocation(500+getImage().getWidth()/2, 5+getImage().getHeight()/2);
        else
            setLocation(980, 420);
    }
}