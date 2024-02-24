package Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Functions 
{
    public static StringBuilder ReadFileContents(String Filename)
    {
        StringBuilder Plaintext= new StringBuilder("");
        try
        {
            Path Test = Paths.get("C:\\Code\\Java\\Assignment 1\\"+Filename);
            String Temp = Files.readAllLines(Test).toString();
            Plaintext.append(Temp.substring(1,Temp.length()-1));
        }
        catch(IOException e)
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
