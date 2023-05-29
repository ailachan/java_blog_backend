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
        if (!new File(userDir+"/wblo gimg/").exists()) {
            File file = new File("${user.dir}/blogimg/");
            file.mkdir();
        }
        if (!new File("${user.dir}/blogimg/albumImg/").exists())
            new File("${user.dir}/blogimg/albumImg/").mkdir();
        if (!new File("${user.dir}/blogimg/contentImg/").exists())
            new File("${user.dir}/blogimg/contentImg/").mkdir();
        if (!new File("${user.dir}/blogimg/firstImg/").exists())
            new File("${user.dir}/blogimg/firstImg/").mkdir();
        if (!new File("${user.dir}/blogimg/photoImg/").exists())
            new File("${user.dir}/blogimg/photoImg/").mkdir();
    }

}
