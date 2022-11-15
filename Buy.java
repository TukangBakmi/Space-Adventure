import greenfoot.*;

public class Buy extends Button
{
    public void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol buy ketika ditekan
            setImage("buy.png");
            Greenfoot.delay(4);
            setImage("buyHover.png");
        }
    }
    
    public void enoughCoin()
    {
        //play sound effect
        GreenfootSound purchaseItem = new GreenfootSound("purchaseItem.wav");
        purchaseItem.setVolume(50);
        purchaseItem.play();
    }
    
    public void notEnoughCoin()
    {
        //play sound effect
        GreenfootSound purchaseItem = new GreenfootSound("useItem.wav");
        purchaseItem.play();
    }
    
    public void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("buyHover.png");
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("buy.png");
        }
    }
}