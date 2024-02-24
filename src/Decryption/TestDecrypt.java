package Decryption;
import Utils.*;
import java.io.File;

public class TestDecrypt 
{
    public TestDecrypt(int TC,String TestFile,String ResultFile)
    {
        StringBuilder Plaintext= Functions.ReadFileContents(TestFile);
        int ThreadCount = TC;

        Butcher b1=new Butcher(ThreadCount, Plaintext);
        StringBuilder[] WorkLoad = b1.Slash();

        File Result = new File(ResultFile);

        DecryptionController EC= new DecryptionController(WorkLoad, ThreadCount, Result);
        EC.start();
    }
}
