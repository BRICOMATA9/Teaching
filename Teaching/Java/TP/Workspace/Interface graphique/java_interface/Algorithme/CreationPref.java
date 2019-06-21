package Algorithme;

import Interface.Dialogue;
import java.io.*;

class CreationPref
{

    CreationPref()
    {
        creation();
    }

    void creation()
    {
        try
        {
            FileWriter filewriter = new FileWriter("./.pref.conf");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);
            printwriter.println("true");
            for(int i = 1; i < 8; i++)
                printwriter.println("false");

            printwriter.println("");
            printwriter.println("5");
            printwriter.println("3");
            printwriter.println("false");
            printwriter.println("true");
            printwriter.println("5");
            printwriter.println("");
            printwriter.flush();
            printwriter.close();
            bufferedwriter.close();
            filewriter.close();
        }
        catch(IOException ioexception)
        {
            new Dialogue("Creation Impossible du fichier" + ioexception);
        }
    }
}
