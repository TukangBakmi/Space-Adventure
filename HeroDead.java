import greenfoot.*;

public class HeroDead extends Hero
{
    private GreenfootImage[] images = new GreenfootImage[3];
    private int pause=10, num=1;
    private int time = 0;
    private boolean addScene = false;
    public static boolean onGameOver = false;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("deadHero"+i+".png");
        }
        setImage(images[1]);
    }
    
    public void act()
    {
        animation();
        remove();
        time++;
    }
    //set animation
    public void animation()
    {
        if(pause==0){
            pause=10;
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
    
    private void remove()
    {
        if(time > 50)
        {
            if(addScene == false)
            {
                //scene gameover
                onGameOver = true;
                GameOverScene gameOver = new GameOverScene();
                getWorld().addObject(gameOver, 512, 288);
                getWorld().addObject(new Restart(),512,376);
                getWorld().addObject(new Quit(),512,486);
                getWorld().addObject(new GameOver(),512,156);
                ScoreLabel scoreLabel = new ScoreLabel("Your Score: " + ScoreIcon.myScore);
                getWorld().addObject(scoreLabel, 200, 400);
                getWorld().addObject(new ScoreIcon(scoreLabel), 200,400);
                //play sound effect
                BackGroundMusic.gameOver.setVolume(50);
                BackGroundMusic.gameOver.play();
                addScene = true;
            }
        }
        else
        {
            setLocation(getX(), getY()-2);
        }
    }
}