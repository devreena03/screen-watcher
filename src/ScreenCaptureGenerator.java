package com.kata.screen.capture;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Date;

public class ScreenCaptureGenerator {
    
    public static void main(String[] args) throws Exception {
        ScreenCaptureGenerator sc = new ScreenCaptureGenerator();
        for(int i=1; i<=10; i++){
          long time = new Date().getTime();
          sc.captureScreen("ScreenWatch/"+time+".png");
          Thread.sleep(10000);
        }
        System.out.println("It will get closed");
        System.exit(0);
    }
    
    public void captureScreen(String fileName) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));

     }

}
