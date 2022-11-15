import greenfoot.*;

public class EnemyTextDamage extends Hero
{
    private int time = 0;
    
    public EnemyTextDamage(String text)
    {
        GreenfootImage textDamage = new GreenfootImage (text.length()*35, 44);
        textDamage.setColor(Color.RED);
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