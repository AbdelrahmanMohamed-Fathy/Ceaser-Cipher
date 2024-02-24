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
            if((temp[i]>=97+17 && temp[i]<=122)|| (temp[i]>=65+17 && temp[i]<=90))
            {
                temp[i] -= 17;
            }
            else if((temp[i]>=97 && temp[i]<=97+16)|| (temp[i]>=65 && temp[i]<=65+16))
            {
                temp[i] += 9;
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
