package xyz.angelbeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogApplication.class, args);
        System.out.println("sdddsd");
        String userDir = System.getProperty("user.dir");
        if (!new File(userDir+"/blogimg/").exists()) {
            File file = new File(userDir+"/blogimg/");
            file.mkdir();
        }
        if (!new File(userDir+"/blogimg/albumImg/").exists())
            new File(userDir+"/blogimg/albumImg/").mkdir();
        if (!new File(userDir+"/blogimg/contentImg/").exists())
            new File(userDir+"/blogimg/contentImg/").mkdir();
        if (!new File(userDir+"/blogimg/firstImg/").exists())
            new File(userDir+"/blogimg/firstImg/").mkdir();
        if (!new File(userDir+"/blogimg/photoImg/").exists())
            new File(userDir+"/blogimg/photoImg/").mkdir();
    }

}
