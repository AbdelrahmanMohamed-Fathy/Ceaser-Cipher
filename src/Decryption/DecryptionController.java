package Decryption;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DecryptionController 
{
    private int ThreadCount;
    private StringBuilder[] Text;
    private Decrypter_Thread[] Threads;
    private File ResultsFile;

    public DecryptionController(StringBuilder[] T,int TC,File R)
    {
        Text=T;
        ThreadCount=TC;
        ResultsFile=R;
        Threads= new Decrypter_Thread[ThreadCount];
        for(int i=0;i<ThreadCount;i++)
        {
            Threads[i]= new Decrypter_Thread(Text[i]);
            Threads[i].start();
        }
        try
        {
            StringBuilder Decipheredtext= new StringBuilder();
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
                //adds the Decrypted text to a combined string
                Decipheredtext.append(Text[i]);
            }
            FileWriter Writer= new FileWriter(ResultsFile);
            Writer.write(Decipheredtext.toString());
            Writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
