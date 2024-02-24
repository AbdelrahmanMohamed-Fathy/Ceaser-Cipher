package Encryption;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptionController 
{
    private int ThreadCount;
    private StringBuilder[] Text;
    private Encrypter_Thread[] Threads;
    private File ResultsFile;

    public EncryptionController(StringBuilder[] T,int TC,File R)
    {
        Text=T;
        ThreadCount=TC;
        ResultsFile=R;
        Threads= new Encrypter_Thread[ThreadCount];
        for(int i=0;i<ThreadCount;i++)
        {
            Threads[i]= new Encrypter_Thread(Text[i]);
            Threads[i].start();
        } 
    }

    public void start()
    {
        try
        {
            StringBuilder Ciphertext= new StringBuilder();
            for(int i=0;i<ThreadCount;i++)
            {
                //waits for threads to finish
                try
                {
                    Threads[i].join();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                //adds the Encrypted text to a combined string
                Ciphertext.append(Text[i]);
            }
            FileWriter Writer= new FileWriter(ResultsFile);
            Writer.write(Ciphertext.toString());
            Writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
