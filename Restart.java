import greenfoot.*;

public class Restart extends Button
{
    public void act()
    {
        getPressed();
        hover();
    }
    
    private void getPressed()
    {
        if(Greenfoot.mousePressed(this))
        {
            //Mengganti tombol quit ketika ditekan
            setImage("restart.png");
            setLocation(512, 376);
            buttonClick();  //soundeffect
            //Memberi jeda agar animasi terlihat 
            Greenfoot.delay(5);
            HeroMechanics.healthPoints = HeroMechanics.maxHealthPoints;
            if(Stage1.stage == 1){
                Greenfoot.setWorld(new Stage1());
            } else if(Stage1.stage == 2){
                Greenfoot.setWorld(new Stage2());
            } else if(Stage1.stage == 3){
                Greenfoot.setWorld(new Stage3());
            } else if(Stage1.stage == 4){
                Greenfoot.setWorld(new Stage4());
            } else if(Stage1.stage == 5){
                Greenfoot.setWorld(new Stage5());
            } else if(Stage1.stage == 6){
                Greenfoot.setWorld(new Stage6());
            } else if(Stage1.stage == 7){
                Greenfoot.setWorld(new Stage7());
            } else if(Stage1.stage == 8){
                Greenfoot.setWorld(new Stage8());
            } else if(Stage1.stage == 9){
                Greenfoot.setWorld(new Stage9());
            }
        }
    }
    
    private void hover()
    {
        //memberikan efek hover
        if(Greenfoot.mouseMoved(this))
        {
            setImage("restartHover.png");
            setLocation(507, 371);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage("restart.png");
            setLocation(512, 376);
        }
    }
}