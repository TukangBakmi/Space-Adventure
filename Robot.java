import greenfoot.*;

public class Robot extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[13];
    private GreenfootImage[] mirroredImages = new GreenfootImage[13];
    private int pause = 10;
    private boolean faceRight = false;
    private boolean faceLeft = true;
    private int num = 1;
    //untuk pergerakan
    int dx = -1;
    int xSpeed = 2; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    private int robotHp = 80;
    public static int robotAttack = 70;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("robot"+i+".png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("robot"+j+".png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveHorizontal();
        moveVertically();
        moveBecauseScrollingBg();
        animation();
        getHit();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=10;
        }
        if(pause==1){
            if(faceLeft == true)
            {
                setImage(images[num]);
            }
            else if(faceRight == true)
            {
                setImage(mirroredImages[num]);
            }
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
        if(HeroMechanics.xPosition > getX())
        {
            dx+=1;
            faceRight = true;
            faceLeft = false;
        }
        if(HeroMechanics.xPosition < getX()-1)
        {
            dx-=1;
            faceRight = false;
            faceLeft = true;
        }
        setLocation(getX()+dx*xSpeed, getY());
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX()-dx*xSpeed, getY());
        }
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null)
        {
            //mengurangi hp
            robotHp -= HeroMechanics.laserDamage;
            //text damage
            ProjectileTextDamage textDamage = new ProjectileTextDamage("" + HeroMechanics.laserDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //menghapus projectile
            getWorld().removeObject(projectile);
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(getOneIntersectingObject(SaberSlash.class) != null && SaberSlash.hitEnemy == false)
        {
            SaberSlash.hitEnemy = true;
            //mengurangi hp
            robotHp -= HeroMechanics.saberDamage;
            //text damage
            SaberTextDamage textDamage = new SaberTextDamage("" + HeroMechanics.saberDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(robotHp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+15,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+5,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-5,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-15,this.getY()-10);
            //score
            ScoreIcon.myScore += 20;
            //remove
            getWorld().removeObject(this);
        }
    }
}