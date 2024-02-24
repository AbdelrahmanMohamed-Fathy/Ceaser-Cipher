package Encryption;
import Utils.*;
import java.io.File;

public class TestEncrypt 
{
    public TestEncrypt(int TC,String TestFile,String ResultFile)
    {
        StringBuilder Plaintext= Functions.ReadFileContents(TestFile);
        int ThreadCount = TC;

        Butcher b1=new Butcher(ThreadCount, Plaintext);
        StringBuilder[] WorkLoad = b1.Slash();

        File Result = new File(ResultFile);

        EncryptionController EC= new EncryptionController(WorkLoad, ThreadCount, Result);
        EC.start();
    }
}
