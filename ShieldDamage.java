import greenfoot.*;

public class ShieldDamage extends Hero
{
    private int time = 0;
    
    public ShieldDamage(String text)
    {
        GreenfootImage textDamage = new GreenfootImage (text.length()*35, 44);
        textDamage.setColor(Color.GRAY);
        textDamage.setFont(new Font("OptimusPrinceps", false, false , 30));
        textDamage.drawString(text, 0, 34);
        setImage(textDamage);
    }
    
    public void act()
    {
        setLocation(getX(), getY()-2);
        remove();
        time++;
    }
    
    private void remove()
    {
        if(time >= 40)
        {
            getWorld().removeObject(this);
            time = 0;
        }
    }
}