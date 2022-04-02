import greenfoot.*;

public class BatteryIcon extends Battery
{
    private GreenfootImage[] images = new GreenfootImage[5];
    private BatteryLabel myBatteryLabel;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=0; i<images.length; i++){
            images[i] = new GreenfootImage("battery"+i+".png");
        }
    }
    
    public BatteryIcon(BatteryLabel batteryLabel)
    {
        myBatteryLabel = batteryLabel;
    }
    
    public void act()
    {
        drawBattery();
        myBatteryLabel.setText(HeroMechanics.batteryInt * 100 / HeroMechanics.maxBattery + "%");
    }
    
    public void drawBattery()
    {
        int batteryPercent = HeroMechanics.batteryInt * 100 / HeroMechanics.maxBattery;
        if(batteryPercent <= 0)
        {
            setImage(images[0]);
        }
        else if(batteryPercent > 0 && batteryPercent <= 25)
        {
            setImage(images[1]);
        }
        else if(batteryPercent > 25 && batteryPercent <= 50)
        {
            setImage(images[2]);
        }
        else if(batteryPercent > 50 && batteryPercent <= 75)
        {
            setImage(images[3]);
        }
        else if(batteryPercent > 75 && batteryPercent <= 100)
        {
            setImage(images[4]);
        }
    }
}
