package Encryption;
public class Encrypter_Thread extends Thread
{
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private StringBuilder Plaintext;
    Encrypter_Thread(StringBuilder text)
    {
        Plaintext = text;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run()
    {
        char[] Ciphertext = Plaintext.toString().toCharArray();
        int temp= Plaintext.length();
        Plaintext.setLength(0);
        for(int i=0;i<temp;i++)
        {
            if(Ciphertext[i]>47)
            {
                Ciphertext[i] -= 17;
            }
            Plaintext.append(Ciphertext[i]);
        }
    }
}