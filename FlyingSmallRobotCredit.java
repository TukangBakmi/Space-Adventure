import greenfoot.*;

public class FlyingSmallRobotCredit extends CreditSceneBackground
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[111];
    private int pause = 1;
    private int num = 1;
    //untuk pergerakan
    public static int xPosition;
    public static int yPosition;
    int dy;
    int dx;
    int xSpeed = 3; //kecepatan bergerak horizontal
    int ySpeed = 3;
    int randomX;
    int randomY;
    int timeX = 300;
    int timeY = 200;
    int time = 0;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("flyingSmallRobot ("+i+").png");
        }
    }
    
    public void act()
    {
        xPosition = getX();
        yPosition = getY();
        moveHorizontal();
        moveVertical();
        animation();
        time++;
        timeX++;
        timeY++;
        if(timeX>300 || getX() == randomX+2 || getX() == randomX+1 || getX() == randomX || getX() == randomX-1 || getX() == randomX-2)
        {
            randomX = Greenfoot.getRandomNumber(1024);
            timeX = 0;
        }
        if(timeY>200 || getY() == randomY+2 || getY() == randomY+1 || getY() == randomY || getY() == randomY-1 || getY() == randomY-2)
        {
            randomY = Greenfoot.getRandomNumber(576);
            timeY = 0;
        }
        getHit();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=1;
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
    
    public void moveHorizontal()
    {
        dx = 0;
        if(randomX > getX())
            dx+=1;
        if(randomX < getX()-1)
            dx-=1;
        setLocation(getX()+dx*xSpeed, getY());
    }
    
    public void moveVertical()
    {
        dy = 0;
        if(randomY > getY()+7)
            dy+=1;
        if(randomY < getY())
            dy-=1;
        setLocation(getX(), getY()+dy*ySpeed);
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(UfoShooterProjectileCredit.class); 
        if(projectile != null || time > 2000)
        {
            if(projectile != null)
                getWorld().removeObject(projectile);
            //explode
            getWorld().addObject(new FlyingSmallRobotExplode(), getX(), getY());
            //remove
            getWorld().removeObject(this);
        }
    }
}