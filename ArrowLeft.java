import greenfoot.*;

public class ArrowLeft extends Button
{
    public void act()
    {
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol start ketika ditekan
            setImage("arrowLeft.png");
            setLocation(74, 338);
            buttonClick();  //soundeffect
            if(ShopPage1.shopPage == 2)
            {
                Greenfoot.setWorld(new ShopPage1());
            }
            else if(ShopPage1.shopPage == 3)
            {
                Greenfoot.setWorld(new ShopPage2());
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("arrowLeftHover.png");
            setLocation(69, 333);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("arrowLeft.png");
            setLocation(74, 338);
        }
    }
}
