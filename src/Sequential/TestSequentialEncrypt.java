package Sequential;
import java.io.FileWriter;
import java.io.IOException;

import Utils.*;

public class TestSequentialEncrypt 
{
    public TestSequentialEncrypt(String TestFile,String ResultFile)
    {
        StringBuilder Plaintext= Functions.ReadFileContents(TestFile);
        char[] temp = Plaintext.toString().toCharArray();

        for(int i=0;i<Plaintext.length();i++)
        {
            if(temp[i]>47)
            {
                temp[i] -= 17;
            }
        }
        try
        {
            FileWriter Writer= new FileWriter(ResultFile);
            Writer.write(temp);
            Writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
