package Decryption;
import Utils.Functions;

public class Decrypter_Thread extends Thread
{
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private StringBuilder Plaintext;
    public Decrypter_Thread(StringBuilder text)
    {
        Plaintext = text;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run()
    {
        char[] Ciphertext = Plaintext.toString().toCharArray();
        int TextLength= Plaintext.length();
        Plaintext.setLength(0);
        for(int i=0;i<TextLength;i++)
        {
            Plaintext.append(Functions.Decrypt(Ciphertext[i]));
        }
    }
}