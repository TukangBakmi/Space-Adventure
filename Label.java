import greenfoot.*;

public class Label extends MyCoins
{
    public Label(String text)
    {
        GreenfootImage labelCoin = new GreenfootImage (text.length()*35, 44);
        labelCoin.setColor(Color.YELLOW);
        labelCoin.setFont(new Font("OptimusPrinceps", false, false , 60));
        labelCoin.drawString(text, 0, 44);
        setImage(labelCoin);
    }
    
    public void setText(String text)
    {
        GreenfootImage labelCoin = getImage();
        labelCoin.clear();
        GreenfootImage newLabelCoin = new GreenfootImage (text.length()*35, 44);
        newLabelCoin.setColor(Color.YELLOW);
        newLabelCoin.setFont(new Font("OptimusPrinceps", false, false , 60));
        newLabelCoin.drawString(text, 0, 44);
        setImage(newLabelCoin);
    }
    
    public void act()
    {
        if(Stage1.onStage)
            setLocation(950-getImage().getWidth()/2, 15+getImage().getHeight()/2);
        else
            setLocation(540-getImage().getWidth()/2, 38+getImage().getHeight()/2);
    }
}