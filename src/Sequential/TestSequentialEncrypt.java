package Sequential;
import java.io.FileWriter;
import java.io.IOException;
import Utils.Functions;

public class TestSequentialEncrypt 
{
    public TestSequentialEncrypt(String TestFile,String ResultFile)
    {
        StringBuilder Plaintext= Functions.ReadFileContents(TestFile);
        char[] temp = Plaintext.toString().toCharArray();

        for(int i=0;i<Plaintext.length();i++)
        {
            temp[i] = Functions.Encrypt(temp[i]);
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
