import greenfoot.*;

public class HealEffect extends ItemEffects
{
    private int time = 0;
    
    public HealEffect(String text)
    {
        GreenfootImage heal = new GreenfootImage (text.length()*35, 44);
        heal.setColor(Color.GREEN);
        heal.setFont(new Font("OptimusPrinceps", false, false , 30));
        heal.drawString(text, 0, 34);
        setImage(heal);
    }
    
    public void act()
    {
        setLocation(getX(), getY()-3);
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