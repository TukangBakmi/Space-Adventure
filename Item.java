import greenfoot.*;

public class Item extends Button
{
    public static int potion;
    public static int hiPotion;
    public static int antidote;
    public static int rage;
    public static int battery;
    public static int shield;
    public static int interferon;
    public static int crystal;
    public static int levelHp = 1;
    public static int levelLaser = 1;
    public static int levelSaber = 1;
    public static int levelBattery = 1;
    
    public void show()
    {
        if(Inventory.isOpened == true)
        {
            setLocation(getX(), 501);
        }
        else if(Inventory.isOpened == false)
        {
            setLocation(getX(), 635);
        }
    }
    
    public void showAmt()
    {
        if(Inventory.isOpened == true)
        {
            setLocation(getX(), 553);
        }
        else if(Inventory.isOpened == false)
        {
            setLocation(getX(), 635);
        }
    }
    
    public void emptyItemSound()
    {
        GreenfootSound emptyItem = new GreenfootSound("useItem.wav");
        emptyItem.setVolume(60);
        emptyItem.play();
    }
}