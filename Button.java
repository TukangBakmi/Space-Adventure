import greenfoot.*;

public class Button extends Actor
{
    public void buttonClick()
    {
        GreenfootSound buttonClick = new GreenfootSound("buttonClick.mp3");
        buttonClick.setVolume(60);
        buttonClick.play();
    }
}