import greenfoot.*;

public class BotLeft extends Buy
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
                Item.antidote++;
                CoinIcon.myCoins -= 15;
            }
            else if(ShopPage1.shopPage == 2 && CoinIcon.myCoins >= 70 && Item.crystal == 0)
            {
                enoughCoin();
                Item.crystal++;
                CoinIcon.myCoins -= 70;
            }
            else if(ShopPage1.shopPage == 3 && CoinIcon.myCoins >= 30)
            {
                enoughCoin();
                Item.levelSaber++;
                CoinIcon.myCoins -= 30;
            }
            else
            {
                notEnoughCoin();
            }
        }
    }
}