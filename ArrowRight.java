import greenfoot.*;

public class ArrowRight extends Button
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
            setImage("arrowRight.png");
            setLocation(950, 338);
            buttonClick();  //soundeffect
            if(ShopPage1.shopPage == 1)
            {
                Greenfoot.setWorld(new ShopPage2());
            }
            else if(ShopPage1.shopPage == 2)
            {
                Greenfoot.setWorld(new ShopPage3());
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("arrowRightHover.png");
            setLocation(945, 333);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("arrowRight.png");
            setLocation(950, 338);
        }
    }
}