import greenfoot.*;

public class BatteryLabel extends Battery
{
    public BatteryLabel(String text)
    {
        GreenfootImage labelBattery = new GreenfootImage (text.length()*35, 44);
        labelBattery.setColor(Color.WHITE);
        labelBattery.setFont(new Font("OptimusPrinceps", false, false , 30));
        labelBattery.drawString(text, 0, 34);
        setImage(labelBattery);
    }
    
    public void setText(String text)
    {
        GreenfootImage labelBattery = getImage();
        labelBattery.clear();
        GreenfootImage newlabelBattery = new GreenfootImage (text.length()*35, 44);
        newlabelBattery.setColor(Color.WHITE);
        newlabelBattery.setFont(new Font("OptimusPrinceps", false, false , 30));
        newlabelBattery.drawString(text, 0, 34);
        setImage(newlabelBattery);
    }
}