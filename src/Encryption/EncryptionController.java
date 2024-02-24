package Encryption;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptionController 
{
    private int ThreadCount;
    private StringBuilder[] Text;
    private Encrypter_Thread[] Threads;
    private File Results;
    EncryptionController(StringBuilder[] T,int TC,File R)
    {
        Text=T;
        ThreadCount=TC;
        Results=R;
        Threads= new Encrypter_Thread[ThreadCount];
        for(int i=0;i<ThreadCount;i++)
        {
            Threads[i]= new Encrypter_Thread(Text[i]);
        } 
    }
    public void start()
    {
        for(int i=0;i<ThreadCount;i++)
        {
            Threads[i].start();
        }
        try
        {
            StringBuilder Ciphertext= new StringBuilder();
            for(int i=0;i<ThreadCount;i++)
            {
                try
                {
                    Threads[i].join();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                Ciphertext.append(Text[i]);
            }
            FileWriter Writer= new FileWriter(Results);
            Writer.write(Ciphertext.toString());
            Writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
