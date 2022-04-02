import greenfoot.*;

public class UpRight extends Buy
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
            if(ShopPage1.shopPage == 1 && CoinIcon.myCoins >= 20)
            {
                enoughCoin();
                Item.hiPotion++;
                CoinIcon.myCoins -= 20;
            }
            else if(ShopPage1.shopPage == 2 && CoinIcon.myCoins >= 15)
            {
                enoughCoin();
                Item.shield++;
                CoinIcon.myCoins -= 15;
            }
            else if(ShopPage1.shopPage == 3 && CoinIcon.myCoins >= 18)
            {
                enoughCoin();
                Item.levelBattery++;
                CoinIcon.myCoins -= 18;
            }
            else
            {
                notEnoughCoin();
            }
        }
    }
}