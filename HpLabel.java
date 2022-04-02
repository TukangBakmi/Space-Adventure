import greenfoot.*;

public class HpLabel extends MyHealthPoint
{
    public HpLabel(String text)
    {
        GreenfootImage labelHp = new GreenfootImage (text.length()*35, 44);
        labelHp.setColor(Color.WHITE);
        labelHp.setFont(new Font("OptimusPrinceps", false, false , 30));
        labelHp.drawString(text, 0, 34);
        setImage(labelHp);
    }
    
    public void setText(String text)
    {
        GreenfootImage labelHp = getImage();
        labelHp.clear();
        GreenfootImage newlabelHp = new GreenfootImage (text.length()*35, 44);
        newlabelHp.setColor(Color.WHITE);
        newlabelHp.setFont(new Font("OptimusPrinceps", false, false , 30));
        newlabelHp.drawString(text, 0, 34);
        setImage(newlabelHp);
    }
    
    public void act()
    {
        setLocation(96+getImage().getWidth()/2, 5+getImage().getHeight()/2);
    }
}