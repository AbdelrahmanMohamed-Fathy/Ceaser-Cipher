package Utils;
import java.util.ArrayList;
import java.util.List;

public class Butcher 
{
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Butcher(int TC,StringBuilder PT)
    {
        threadcount=TC;
        plaintext=PT;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private StringBuilder plaintext;

    public StringBuilder getPlaintext() {
        return plaintext;
    }
    public void setPlaintext(StringBuilder plaintext) {
        this.plaintext = plaintext;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int threadcount;

    public int getThreadcount() {
        return threadcount;
    }
    public void setThreadcount(int threadcount) {
        this.threadcount = threadcount;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Converts a string into multiple sections of (almost) equal length.
    public StringBuilder[] Slash()
    {
        int StringSegmentLength = Math.floorDiv(plaintext.length(),threadcount);
        List<String> ciphertexts = new ArrayList<>();
        int StartIndex=0;
        for (int i = 0; i < threadcount; i++)
        {
            int endIndex = Math.min(StartIndex + StringSegmentLength, plaintext.length());

            ciphertexts.add(plaintext.substring(StartIndex, (i!=threadcount-1)?(endIndex):(plaintext.length())));
            StartIndex=endIndex;
        }
        String[] temp = ciphertexts.toArray(new String[0]);
        StringBuilder[] Final = new StringBuilder[threadcount];
        for(int i=0;i<threadcount;i++)
        {
            Final[i]=new StringBuilder(temp[i]);
        }
        return Final;
    }
}
