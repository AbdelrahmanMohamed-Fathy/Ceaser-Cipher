
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
        long[] elapsedTimes=new long[24];
        long StartTime;
        //testfiles:
        String TwentySix = "Tests\\TwentySixBytes.txt"; String FiveKilo = "Tests\\FiveKiloBytes.txt"; String OneMega = "Tests\\OneMegaByte.txt";

        //Sequential Encryption Result Files:
        String R01 = "Results\\Results_01.txt"; String R02 = "Results\\Results_02.txt"; String R03 = "Results\\Results_03.txt";
        //Sequential Decryption Result Files:
        String R04 = "Results\\Results_04.txt"; String R05 = "Results\\Results_05.txt"; String R06 = "Results\\Results_06.txt";

        //Encryption Result Files:
        String R11 = "Results\\Results_11.txt"; String R12 = "Results\\Results_12.txt"; String R13 = "Results\\Results_13.txt"; String R14 = "Results\\Results_14.txt";
        String R15 = "Results\\Results_15.txt"; String R16 = "Results\\Results_16.txt"; String R17 = "Results\\Results_17.txt"; String R18 = "Results\\Results_18.txt"; 
        String R19 = "Results\\Results_19.txt";

        //Decryption Result Files:
        String R21 = "Results\\Results_21.txt"; String R22 = "Results\\Results_22.txt"; String R23 = "Results\\Results_23.txt"; String R24 = "Results\\Results_24.txt";
        String R25 = "Results\\Results_25.txt"; String R26 = "Results\\Results_26.txt"; String R27 = "Results\\Results_27.txt"; String R28 = "Results\\Results_28.txt"; 
        String R29 = "Results\\Results_29.txt";
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Ecnryption Tests:
        StartTime = System.nanoTime();
        TestSequentialEncrypt T1 = new TestSequentialEncrypt(TwentySix, R01);
        elapsedTimes[0] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T11 = new TestEncrypt(5, TwentySix, R11);
        elapsedTimes[1] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T12 = new TestEncrypt(10, TwentySix, R12);
        elapsedTimes[2] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T13 = new TestEncrypt(25, TwentySix, R13);
        elapsedTimes[3] = System.nanoTime() - StartTime;
        
        StartTime = System.nanoTime();
        TestSequentialEncrypt T2 = new TestSequentialEncrypt(FiveKilo, R02);
        elapsedTimes[4] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T14 = new TestEncrypt(5, FiveKilo, R14);
        elapsedTimes[5] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T15 = new TestEncrypt(10, FiveKilo, R15);
        elapsedTimes[6] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T16 = new TestEncrypt(25, FiveKilo, R16);
        elapsedTimes[7] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestSequentialEncrypt T3 = new TestSequentialEncrypt(OneMega, R03);
        elapsedTimes[8] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T17 = new TestEncrypt(5, OneMega, R17);
        elapsedTimes[9] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T18 = new TestEncrypt(10, OneMega, R18);
        elapsedTimes[10] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestEncrypt T19 = new TestEncrypt(25, OneMega, R19);
        elapsedTimes[11] = System.nanoTime() - StartTime;


        //Decryption Tests:
        StartTime = System.nanoTime();
        TestSequentialDecrypt T4 = new TestSequentialDecrypt(R01, R04);
        elapsedTimes[12] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T21 = new TestDecrypt(5, R11, R21);
        elapsedTimes[13] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T22 = new TestDecrypt(10, R12, R22);
        elapsedTimes[14] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T23 = new TestDecrypt(25, R13, R23);
        elapsedTimes[15] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestSequentialDecrypt T5 = new TestSequentialDecrypt(R02, R05);
        elapsedTimes[16] = System.nanoTime() - StartTime;
        
        StartTime = System.nanoTime();
        TestDecrypt T24 = new TestDecrypt(5, R14, R24);
        elapsedTimes[17] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T25 = new TestDecrypt(10, R15, R25);
        elapsedTimes[18] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T26 = new TestDecrypt(25, R16, R26);
        elapsedTimes[19] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestSequentialDecrypt T6 = new TestSequentialDecrypt(R03, R06);
        elapsedTimes[20] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T27 = new TestDecrypt(5, R17, R27);
        elapsedTimes[21] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T28 = new TestDecrypt(10, R18, R28);
        elapsedTimes[22] = System.nanoTime() - StartTime;

        StartTime = System.nanoTime();
        TestDecrypt T29 = new TestDecrypt(25, R19, R29);
        elapsedTimes[23] = System.nanoTime() - StartTime;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringBuilder TableLine = new StringBuilder();
        for(int i=0;i<24;i++)
        {
            if((i>=0 && i<=3) || (i>=12 && i<=15))
            {
                TableLine.append("26 Bytes ");
            }
            else if((i>=4 && i<=7) || (i>=16 && i<=19))
            {
                TableLine.append("5 KiloBytes ");
            }
            else if((i>=8 && i<=11) || (i>=20 && i<=23))
            {
                TableLine.append("1 Mega Byte ");
            }
            if(i==0|i==4|i==8|i==12|i==16|i==20)
            {
                TableLine.append("Sequential ");
            }
            else
            {
                TableLine.append("MultiThreaded ");
                if(i==1|i==5|i==9|i==13|i==17|i==21)
                {
                    TableLine.append("(5 Threads) ");
                }
                else if(i==2|i==6|i==10|i==14|i==18|i==22)
                {
                    TableLine.append("(10 Threads) ");
                }
                else if(i==3|i==7|i==11|i==15|i==19|i==23)
                {
                    TableLine.append("(25 Threads) ");
                }
            }
            if(i<=11)
            {
                TableLine.append("Encryption Test Time: ");
            }
            else
            {
                TableLine.append("Decryption Test Time: ");
            }
            TableLine.append(elapsedTimes[i]/1000000 + " Milliseconds\n");
        }
        System.out.println(TableLine);
    }
}

