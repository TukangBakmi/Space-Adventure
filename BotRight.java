import greenfoot.*;

public class BotRight extends Buy
{
    public void act()
    {
        getPressed();
        hover();
        addItem();
    }
    
    private void addItem()
    {
        if(Greenfoot.mousePressed(this))
        {
            if(ShopPage1.shopPage == 1 && CoinIcon.myCoins >= 15)
            {
                enoughCoin();
                Item.rage++;
                CoinIcon.myCoins -= 15;
            }
            else if(ShopPage1.shopPage == 2 && CoinIcon.myCoins >= 15)
            {
                enoughCoin();
                Item.battery++;
                CoinIcon.myCoins -= 15;
            }
            else if(ShopPage1.shopPage == 3 && CoinIcon.myCoins >= 25)
            {
                enoughCoin();
                Item.levelLaser++;
                CoinIcon.myCoins -= 25;
            }
            else
            {
                notEnoughCoin();
            }
        }
    }
}