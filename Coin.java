import greenfoot.*;

public class Coin extends Objects
{
    private GreenfootImage[] images = new GreenfootImage[35];
    private int pause=3, num=1;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("coin"+i+".png");
        }
        setImage(images[1]);
    }
    
    public void act()
    {
        moveObjects();
        animation();
        coinCollision();
    }
    //set animation
    public void animation()
    {
        if(pause==0){
            pause=3;
        }
        if(pause==1){
            setImage(images[num]);
            num++;
            if(num >= images.length){
                num=1;
            }
        }
        if(pause>0){
            pause--;
        }
    }
    //hero get coin
    public void coinCollision()
    {
        Actor b = getOneIntersectingObject(HeroMechanics.class);  
        if(b != null)  
        {
            //menambahkan score
            ScoreIcon.myScore++;
            //menambahkan koin
            CoinIcon.myCoins++;
            //menggerakan dan me-remove coin
            CoinMove move = new CoinMove();
            getWorld().addObject(move, this.getX(), this.getY());
            getWorld().removeObject(this);

            //play sound effect
            GreenfootSound getCoinSound = new GreenfootSound("getCoinSound.wav");
            getCoinSound.setVolume(40);
            getCoinSound.play();
        }
    }
}