package cn.yuan.modelutil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {  
    private GameUtil(){}//将构造方法私有  
    /** 
     * 加载图片，所有图片需在项目里建一个文件夹或者包存起来，图片类Image 
     */  
    public static Image getImage(String path){  
        URL u=GameUtil.class.getClassLoader().getResource(path);  
        BufferedImage img=null;  
        try {  
            img=ImageIO.read(u);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return img;  
    }  
}  