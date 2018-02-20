package core.helpers;

import com.codeborne.selenide.Configuration;

import org.sikuli.basics.*;
import org.sikuli.script.*;
import org.sikuli.script.FindFailed;
/*import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;*/

import java.io.File;

public class SikuliX {
    public static void main (String [] args) throws FindFailed {
    Screen screen = new Screen();
    Pattern pattern = new Pattern("D:\\Automation\\Java\\testng2\\result\\etalonFile.png");
    screen.find(pattern.similar(8));
    }

    /*String File = "D:\\Automation\\Java\\testng2\\result\\my_file_name.png";
    String baseFile = "D:\\Automation\\Java\\testng2\\result\\etalonFile.png";*/

    // org.sikuli.script.Screen screen = (org.sikuli.script.Screen) new org.sikuli.script.Screen();


}
