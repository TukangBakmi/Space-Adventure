import greenfoot.*;

public class ProjectileTextDamage extends Objects
{
    private int time = 0;
    
    public ProjectileTextDamage(String text)
    {
        GreenfootImage textDamage = new GreenfootImage (text.length()*35, 44);
        textDamage.setColor(Color.RED);
        textDamage.setFont(new Font("OptimusPrinceps", false, false , 30));
        textDamage.drawString(text, 0, 34);
        setImage(textDamage);
    }
    
    public void act()
    {
        setLocation(getX(), getY()-3);
        remove();
        time++;
    }
    
    private void remove()
    {
        if(time >= 30)
        {
            getWorld().removeObject(this);
            time = 0;
        }
    }
}