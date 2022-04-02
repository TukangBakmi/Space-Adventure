import greenfoot.*;

public class FlyingRobot extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[61];
    private GreenfootImage[] mirroredImages = new GreenfootImage[61];
    private int pause = 1;
    private boolean faceRight = false;
    private boolean faceLeft = true;
    private int num = 1;
    //untuk pergerakan
    int dy;
    int dx;
    int xSpeed = 2; //kecepatan bergerak horizontal
    int ySpeed = 2;
    //untuk atribut
    private int hp = 400;
    public static int attack = 250;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("flyingRobot ("+i+").png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("flyingRobot ("+j+").png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveHorizontal();
        moveVertical();
        moveBecauseScrollingBg();
        animation();
        getHit();
    }
    
    public void animation()
    {
        if(pause==0){
            pause=1;
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
    
    public void moveVertical()
    {
        dy = 0;
        if(HeroMechanics.yPosition > getY()+30)
            dy+=1;
        if(HeroMechanics.yPosition < getY()+29)
            dy-=1;
        setLocation(getX(), getY()+dy*ySpeed);
        while(getOneIntersectingObject(Tiles.class) != null)
        {
            setLocation(getX(), getY()-dy);
        }
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null)
        {
            //mengurangi hp
            hp -= HeroMechanics.laserDamage;
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
            hp -= HeroMechanics.saberDamage;
            //text damage
            SaberTextDamage textDamage = new SaberTextDamage("" + HeroMechanics.saberDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(hp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+20,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()+10,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+10,this.getY()-30);
            getWorld().addObject(new Coin(), this.getX(),this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-10,this.getY()-30);
            getWorld().addObject(new Coin(), this.getX()-10,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-20,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()-30,this.getY()-10);
            //score
            ScoreIcon.myScore += 60;
            //explode
            getWorld().addObject(new FlyingRobotExplode(), getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy1.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
            //remove
            getWorld().removeObject(this);
        }
    }
}