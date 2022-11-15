import greenfoot.*;

public class UpLeft extends Buy
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
            if(ShopPage1.shopPage == 1 && CoinIcon.myCoins >= 12)
            {
                enoughCoin();
                Item.potion++;
                CoinIcon.myCoins -= 12;
            }
            else if(ShopPage1.shopPage == 2 && CoinIcon.myCoins >= 70)
            {
                enoughCoin();
                Item.interferon++;
                CoinIcon.myCoins -= 70;
            }
            else if(ShopPage1.shopPage == 3 && CoinIcon.myCoins >= 30)
            {
                enoughCoin();
                Item.levelHp++;
                CoinIcon.myCoins -= 30;
            }
            else
            {
                notEnoughCoin();
            }
        }
    }
}