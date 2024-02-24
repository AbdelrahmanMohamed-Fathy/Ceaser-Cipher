package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Functions 
{
    public static StringBuilder ReadFileContents(String Filename)
    {
        StringBuilder Plaintext= new StringBuilder("");
        try
        {
            String temp;
            File Test = new File("C:\\Code\\Java\\Assignment 1\\"+Filename);
            Scanner FileReader = new Scanner(Test);
            temp = FileReader.nextLine();
            Plaintext.append(temp);
            while (FileReader.hasNextLine())
            {
                temp = FileReader.nextLine();
                Plaintext.append(temp);
            }
            FileReader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return Plaintext;
    }
    public static boolean CompareFiles(String FileName1,String FileName2)
    {
        StringBuilder FileContent1 = ReadFileContents(FileName1);
        StringBuilder FileContent2 = ReadFileContents(FileName2);
        if(FileContent1.equals(FileContent2))
        {
            return true;
        }
        return false;
    }
}
