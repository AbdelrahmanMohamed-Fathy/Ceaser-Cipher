package Decryption;
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
            if((Ciphertext[i]>=97 && Ciphertext[i]<=122-17)|| (Ciphertext[i]>=65 && Ciphertext[i]<=90-17))
            {
                Ciphertext[i] += 17;
            }
            else if((Ciphertext[i]>=122-16 && Ciphertext[i]<=122)|| (Ciphertext[i]>=90-16 && Ciphertext[i]<=90))
            {
                Ciphertext[i] -= 9;
            }
            Plaintext.append(Ciphertext[i]);
        }
    }
}