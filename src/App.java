
import Encryption.TestEncrypt;
import Sequential.TestSequentialDecrypt;
import Sequential.TestSequentialEncrypt;
import Decryption.TestDecrypt;
import Utils.Functions;
public class App 
{   
@SuppressWarnings("unused")
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws Exception 
    {
        StringBuilder TableLine = new StringBuilder();
        long StartTime; 
        long ElapsedTime=0;
        int ThreadCount=0; 
        String TestFile= new String();
        int ID;

        String[] ResultFile = new String[24];
        for(int i=0;i<24;i++)
        {
            ResultFile[i] = "Results\\Results_" + i + ".txt";
        }
        //testfiles:
        String TwentySix = "Tests\\TwentySixBytes.txt"; String FiveKilo = "Tests\\FiveKiloBytes.txt"; String OneMega = "Tests\\OneMegaByte.txt";

        for(int i=0;i<24;i++)
        {
            if((i>=0 && i<=3) || (i>=12 && i<=15))
            {
                TableLine.append("26 Bytes ");
                TestFile=TwentySix;
            }
            else if((i>=4 && i<=7) || (i>=16 && i<=19))
            {
                TableLine.append("5 KiloBytes ");
                TestFile=FiveKilo;
            }
            else if((i>=8 && i<=11) || (i>=20 && i<=23))
            {
                TableLine.append("1 Mega Byte ");
                TestFile=OneMega;
            }
            if(i==0|i==4|i==8|i==12|i==16|i==20)
            {
                TableLine.append("Sequential ");
                ID=1;
            }
            else
            {
                TableLine.append("MultiThreaded ");
                ID=2;
                if(i==1|i==5|i==9|i==13|i==17|i==21)
                {
                    TableLine.append("(5 Threads) ");
                    ThreadCount=5;
                }
                else if(i==2|i==6|i==10|i==14|i==18|i==22)
                {
                    TableLine.append("(10 Threads) ");
                    ThreadCount=10;
                }
                else if(i==3|i==7|i==11|i==15|i==19|i==23)
                {
                    TableLine.append("(25 Threads) ");
                    ThreadCount=25;
                }
            }
            if(i<=11)
            {
                TableLine.append("Encryption Test Time: ");
                if(ID==1)
                {
                    StartTime=System.nanoTime();
                    new TestSequentialEncrypt(TestFile, ResultFile[i]);
                    ElapsedTime= System.nanoTime() - StartTime;
                }
                else if(ID==2)
                {
                    StartTime=System.nanoTime();
                    new TestEncrypt(ThreadCount,TestFile, ResultFile[i]);
                    ElapsedTime= System.nanoTime() - StartTime;
                }
            }
            else
            {
                TableLine.append("Decryption Test Time: ");
                if(ID==1)
                {
                    StartTime=System.nanoTime();
                    new TestSequentialDecrypt(ResultFile[i-12], ResultFile[i]);
                    ElapsedTime= System.nanoTime() - StartTime;
                }
                else if(ID==2)
                {
                    StartTime=System.nanoTime();
                    new TestDecrypt(ThreadCount,ResultFile[i-12], ResultFile[i]);
                    ElapsedTime= System.nanoTime() - StartTime;
                }
            }
            TableLine.append(ElapsedTime/1000000 + " Milliseconds\n");
        }
        System.out.println(TableLine);
    }
}

