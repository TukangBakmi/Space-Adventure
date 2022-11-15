import greenfoot.*;

public class FlameAlien extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[61];
    private GreenfootImage[] mirroredImages = new GreenfootImage[61];
    private int pause = 1;
    private boolean faceRight = false;
    private boolean faceLeft = true;
    private int num = 1;
    //untuk pergerakan
    int dx = -1;
    int xSpeed = 7; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    private int hp = 350;
    public static int attack = 150;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("flameAlien ("+i+").png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("flameAlien ("+j+").png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveHorizontal();
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
        if(getOneIntersectingObject(EdgeGround.class) != null)
        {
            dx *= -1;
            if(faceRight == true)
            {
                setLocation(getX()-8, getY());
                faceRight = false;
                faceLeft = true;
            }
            else
            {
                setLocation(getX()+8, getY());
                faceRight = true;
                faceLeft = false;
            }
        }
        setLocation(getX()+dx*xSpeed, getY());
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
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
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
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(hp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+42,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()+30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+18,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()+6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-18,this.getY()-20);
            getWorld().addObject(new Coin(), this.getX()-30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-42,this.getY()-20);
            //score
            ScoreIcon.myScore += 40;
            //remove
            getWorld().removeObject(this);
        }
    }
}