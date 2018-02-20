package core.helpers;

import org.testng.annotations.DataProvider;

import java.io.*;

public class TestDataD {

    @DataProvider(name="TestDataFromFile")
    public Object[][] testData (){
    try {
        BufferedReader br =  new BufferedReader(new FileReader("Data.txt"));
        String tmp = br.readLine();     //Enter использовать как разделитель
            String[] s = tmp.split(",");     //вывод полученных строк
            Object[][] data = new Object[s.length][1];
            int i = 0;
            for (String res : s) {
                //System.out.println(res);
                data[i][0] = res;
                i++;
            }
        br.close();
        return data;

    }
    catch (IOException e) {
        e.printStackTrace();
        return null;
    }
    }

}
