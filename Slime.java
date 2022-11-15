import greenfoot.*;

public class Slime extends Enemy
{
    //untuk animasi
    private GreenfootImage[] images = new GreenfootImage[2];
    private GreenfootImage[] mirroredImages = new GreenfootImage[2];
    private int pause = 10;
    private boolean faceRight = true;
    private boolean faceLeft = false;
    private int num = 1;
    //untuk pergerakan
    int dx = 1;
    int xSpeed = 2; //kecepatan bergerak horizontal
    //untuk atribut
    public static boolean hitting = false;
    private int slimeHp = 50;
    public static int slimeAttack = 50;
    
    public void addedToWorld(World Stage1)
    {
        for(int i=1; i<images.length; i++){
            images[i] = new GreenfootImage("slime"+i+".png");
        }
        for(int j = 1; j<images.length; j++){
            GreenfootImage mirroredImage = new GreenfootImage("slime"+j+".png");
            mirroredImage.mirrorHorizontally();
            mirroredImages[j] = mirroredImage;
        }
    }
    
    public void act()
    {
        moveHorizontally();
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
            if(faceRight == true)
            {
                setImage(images[num]);
            }
            else if(faceLeft == true)
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
    
    public void moveHorizontally()
    {
        if(getOneIntersectingObject(EdgeGround.class) != null)
        {
            dx *= -1;
            if(faceRight == true)
            {
                setLocation(getX()-6, getY());
                faceRight = false;
                faceLeft = true;
            }
            else
            {
                setLocation(getX()+6, getY());
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
            //mengurangi hp slime
            slimeHp -= HeroMechanics.laserDamage;
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
            slimeHp -= HeroMechanics.saberDamage;
            //text damage
            SaberTextDamage textDamage = new SaberTextDamage("" + HeroMechanics.saberDamage);
            getWorld().addObject(textDamage, getX(), getY());
            //backsound
            GreenfootSound hitEnemy = new GreenfootSound("hitEnemy2.wav");
            hitEnemy.setVolume(90);
            hitEnemy.play();
        }
        if(slimeHp <= 0)
        {
            //koin
            getWorld().addObject(new Coin(), this.getX()+15,this.getY()-10);
            getWorld().addObject(new Coin(), this.getX(),this.getY()-10);
            getWorld().addObject(new Coin(), this.getX()-15,this.getY()-10);
            //score
            ScoreIcon.myScore += 10;
            //remove slime
            getWorld().removeObject(this);
        }
    }
}