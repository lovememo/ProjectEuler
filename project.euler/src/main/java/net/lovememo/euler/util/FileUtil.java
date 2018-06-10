package net.lovememo.euler.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /**
     *
     * @param fileName e.g /src/Problem1_25/names.txt
     * @return
     * @throws IOException
     */
    public static List<String> getData(String fileName) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File file = new File(System.getProperty("user.dir") + fileName);
        List<String> retList  = new ArrayList();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line=null;
        StringBuffer sb=new StringBuffer();
        line=br.readLine();
        while(line!=null){
            retList.add(line);
            line=br.readLine();
        }
        br.close();
        return retList;
    }
}
