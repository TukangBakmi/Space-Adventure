import greenfoot.*;

public class Inventory extends Button
{
    public static boolean isOpened = false;
    public static boolean cursorOnInventory = false;
    public static boolean cursorOnInventoryButton = false;
    public static boolean cursorOnInventoryBox = false;
    public static boolean cursorOnInventoryItems = false;
    private int time = 5;
    
    public void act()
    {
        getPressed();
        hover();
        time--;
        if(Antidote.hoverAntidote || BatteryItem.hoverBattery || Crystal.hoverCrystal || HiPotion.hoverHiPotion || Interferon.hoverInterferon || Potion.hoverPotion || Rage.hoverRage || ShieldItem.hoverShield)
            cursorOnInventoryItems = true;
        else
            cursorOnInventoryItems = false;
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this) || (Greenfoot.isKeyDown("v") && time <=0))
        {
            //Mengganti tombol inventory ketika ditekan
            setImage("inventory.png");
            buttonClick();  //soundeffect
            //Memberi jeda agar animasi terlihat
            Greenfoot.delay(5);
            //membuka inventory
            if(isOpened == false)
            {
                setLocation(getX(), getY()-118);
                isOpened = true;
            }
            else if(isOpened = true)
            {
                setLocation(getX(), getY()+118);
                isOpened = false;
            }
            time = 5;
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("inventoryHover.png");
            cursorOnInventoryButton = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("inventory.png");
            cursorOnInventoryButton = false;
        }
    }
}