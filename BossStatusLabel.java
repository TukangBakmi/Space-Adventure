import greenfoot.*;

public class BossStatusLabel extends BossStatus
{
    public BossStatusLabel(String text)
    {
        GreenfootImage labelStat = new GreenfootImage (text.length()*14, 44);
        labelStat.setColor(Color.WHITE);
        labelStat.setFont(new Font("OptimusPrinceps", false, false , 30));
        labelStat.drawString(text, 0, 34);
        setImage(labelStat);
    }
    
    public void setText(String text)
    {
        GreenfootImage newlabelStat = new GreenfootImage (text.length()*14, 44);
        newlabelStat.setColor(Color.WHITE);
        newlabelStat.setFont(new Font("OptimusPrinceps", false, false , 30));
        newlabelStat.drawString(text, 0, 34);
        setImage(newlabelStat);
    }
    
    public void act()
    {
        setLocation(1024-getImage().getWidth()/2, 110+getImage().getHeight()/2);
    }
}