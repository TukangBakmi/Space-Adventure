import greenfoot.*;

public class BatteryItem extends Item
{
    public static boolean hoverBattery = false;
    private int recharge;
    private BatteryItemAmt myBattery;
    
    public BatteryItem(BatteryItemAmt batteryAmmount)
    {
        myBattery = batteryAmmount;
    }
    
    public void act()
    {
        myBattery.setText("Amt:\n  " + Item.battery);
        show();
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol ketika ditekan
            setImage("itemBattery.png");
            Greenfoot.delay(4);
            setImage("itemHoverBattery.png");
            //soundeffect
            if(Item.battery <= 0)
                emptyItemSound();
            else
                buttonClick();
            //mengurangi item & memberi efek
            if(Item.battery > 0)
            {
                Item.battery--;
                recharge = HeroMechanics.maxBattery/2;
                if(HeroMechanics.batteryInt + recharge > HeroMechanics.maxBattery)
                {
                    recharge = HeroMechanics.maxBattery-HeroMechanics.batteryInt;
                }
                HeroMechanics.batteryInt += recharge;
                getWorld().addObject(new BatteryEffect(), HeroMechanics.xPosition, HeroMechanics.yPosition-20);
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("itemHoverBattery.png");
            hoverBattery = true;
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("itemBattery.png");
            hoverBattery = false;
        }
    }
}