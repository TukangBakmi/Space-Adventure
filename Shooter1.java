import greenfoot.*;

public class Shooter1 extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[71];
    private GreenfootImage[] mirroredImages = new GreenfootImage[71];
    private int pause = 3;
    public static boolean faceRight = false;
    public static boolean faceLeft = true;
    private int num = 1;
    //untuk atribut
    public static boolean hitting = false;
    private int shooter1Hp = 160;
    public static int shooter1Attack = 60;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("shooter1 ("+i+").png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("shooter1 ("+j+").png");
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
            pause=3;
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
                Shooter1Projectile shot = new Shooter1Projectile();
                getWorld().addObject(shot, getX(), getY());
                shot.turnTowards(HeroMechanics.xPosition, HeroMechanics.yPosition);
                //play sound effect
                GreenfootSound shotLaser = new GreenfootSound("shotLaser.mp3");
                shotLaser.setVolume(65);
                shotLaser.play();
            }
        }
        if(pause>0){
            pause--;
        }
    }
    
    public void moveHorizontal()
    {
        if(HeroMechanics.xPosition > getX())
        {
            faceRight = true;
            faceLeft = false;
        }
        if(HeroMechanics.xPosition < getX()-1)
        {
            faceRight = false;
            faceLeft = true;
        }
    }
    
    private void getHit()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null)
        {
            //mengurangi hp slime
            shooter1Hp -= HeroMechanics.laserDamage;
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
            //mengurangi hp slime
            shooter1Hp -= HeroMechanics.saberDamage;
            //text damage
            SaberTextDamage textDamage = new SaberTextDamage("" + HeroMechanics.saberDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(shooter1Hp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+30,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+18,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()+6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-6,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-18,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-30,this.getY()-10);
            //score
            ScoreIcon.myScore += 30;
            //remove slime
            getWorld().removeObject(this);
        }
    }
}