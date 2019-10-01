package Algorithme;

import Interface.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

// Referenced classes of package Algorithme:
//            CreationPref, Verrou

public class Telechargement extends Thread
{
    class Graphique extends JFrame
    {

        void progression()
        {
            JLabel jlabel = new JLabel("Progression en %");
            JLabel jlabel1 = new JLabel("Telechargement en cours.");
            setTitle(adr + "/" + nom);
            getContentPane().setLayout(null);
            setSize(new Dimension(277, 108));
            progressBar.setMaximum(100);
            progressBar.setForeground(new Color(0, 0, 113));
            progressBar.setBounds(new Rectangle(27, 35, 207, 27));
            progressBar.setStringPainted(true);
            jlabel.setBounds(new Rectangle(28, 14, 150, 15));
            jlabel1.setBounds(new Rectangle(28, 14, 250, 115));
            getContentPane().add(progressBar);
            getContentPane().add(jlabel);
            setResizable(false);
            getContentPane().add(jlabel1);
            setVisible(true);
        }

        public void progress(int i, int j)
        {
            progressBar.setValue(i);
            if(i >= 95 && j != 1)
            {
                try
                {
                    Thread.sleep(2000L);
                }
                catch(InterruptedException _ex) { }
                dispose();
            }
        }

        void close()
        {
            dispose();
        }

        Windows win;
        String adr;
        String nom;
        int profondeur;
        Telechargement t;
        Verrou verrou;
        int numero;
        MyPanelTree tree;
        private JProgressBar progressBar;

        Graphique(Windows windows, String s, String s1, int i, Verrou verrou1, Telechargement telechargement1, 
                int j, MyPanelTree mypaneltree)
        {
            progressBar = new JProgressBar(0);
            win = windows;
            adr = s;
            nom = s1;
            profondeur = i;
            verrou = verrou1;
            t = telechargement1;
            numero = j;
            tree = mypaneltree;
            progression();
        }
    }


    public Telechargement(Windows windows, String s, String s1, int i, MyPanelTree mypaneltree, Verrou verrou1)
    {
        nbThreadMax = 5;
        NOM_FICHIER = 0;
        continu = true;
        FTP = false;
        win = windows;
        adr = transforme(s);
        nom = s1;
        profondeur = i;
        tree = mypaneltree;
        verrou = verrou1;
        numero = ++num;
        if(!FTP)
            progressBar = new Graphique(windows, s, s1, i, verrou1, this, numero, mypaneltree);
        if(CHANGEMENT)
            init(pref);
    }

    void init(boolean aflag[])
    {
        for(int i = 1; i < 8; i++)
            aflag[i] = false;

        File file = new File("./.pref.conf");
        if(!file.exists())
            new CreationPref();
        try
        {
            FileReader filereader = new FileReader("./.pref.conf");
            BufferedReader bufferedreader = new BufferedReader(filereader);
            aflag[0] = "true".equals(bufferedreader.readLine());
            if(!aflag[0])
            {
                for(int j = 1; j < 8; j++)
                    aflag[j] = "true".equals(bufferedreader.readLine());

                bufferedreader.readLine();
                bufferedreader.readLine();
                profPref = Integer.parseInt(bufferedreader.readLine());
                changementSite = "true".equals(bufferedreader.readLine());
                bufferedreader.readLine();
                bufferedreader.readLine();
                nbThreadMax = Integer.parseInt(bufferedreader.readLine());
            } else
            {
                for(int k = 1; k < 10; k++)
                    bufferedreader.readLine();

                profPref = Integer.parseInt(bufferedreader.readLine());
                changementSite = "true".equals(bufferedreader.readLine());
                bufferedreader.readLine();
                nbThreadMax = Integer.parseInt(bufferedreader.readLine());
            }
            filereader.close();
            bufferedreader.close();
        }
        catch(IOException _ex)
        {
            new Dialogue("Impossible de lire le fichier ici ");
            progressBar.close();
            verrou.fin(this, tree, numero, true);
        }
        CHANGEMENT = false;
    }

    String transforme(String s)
    {
        if(s.startsWith("http://"))
            return s;
        if(s.startsWith("ftp://"))
        {
            new Dialogue("Erreur de protocole. \n Protocole non implemente.");
            win.affecteAdr("");
            continu = false;
            FTP = true;
            return "";
        } else
        {
            return "http://".concat(s);
        }
    }

    public void run()
    {
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        boolean flag = false;
        if(continu)
        {
            URL url;
            URLConnection urlconnection;
            try
            {
                url = new URL(adr + "/" + nom);
                try
                {
                    urlconnection = url.openConnection();
                }
                catch(IOException _ex)
                {
                    new Dialogue("Impossible d'ouvrir la connection de " + adr);
                    progressBar.close();
                    verrou.fin(this, tree, numero, true);
                    return;
                }
            }
            catch(MalformedURLException _ex)
            {
                new Dialogue("Adresse mal formee. Veuillez la verifier.");
                progressBar.close();
                verrou.fin(this, tree, numero, true);
                return;
            }
            String s = urlconnection.getContentType();
            //System.out.println(s);
            int i = urlconnection.getContentLength();
            long l = urlconnection.getHeaderFieldDate("last-modification", -1L);
            if(s != null)
            {
                if(s.startsWith("text/"))
                {
                    InputStream inputstream;
                    try
                    {
                        inputstream = url.openStream();
                    }
                    catch(IOException _ex)
                    {
                        new Dialogue("Impossible d'ouvrir le flux depuis le serveur");
                        progressBar.close();
                        verrou.fin(this, tree, numero, true);
                        return;
                    }
                    if("".equals(nom))
                    {
                        NOM_FICHIER = 1;
                        nom = "index.html";
                    } else
                    if("text/html".equals(s))
                        NOM_FICHIER = 1;
                    else
                        NOM_FICHIER = 2;
                    String s1 = adr.substring(7, adr.length());
                    path(s1);
                    s1 = "./download/" + s1 + "/";
                    if(NOM_FICHIER == 1 || NOM_FICHIER == 2 && (pref[5] || pref[0]))
                    {
                        if(existeFichier(s1, nom, l))
                        {
                            lireTexte(s1, nom, inputstream, i, adr, NOM_FICHIER);
                        } else
                        {
                            progressBar.close();
                            verrou.fin(this, tree, numero, true);
                        }
                    } else
                    {
                        new Dialogue("Vous ne pouvez telecharger ce fichier \n d'apres vos preferences.");
                        progressBar.close();
                        verrou.fin(this, tree, numero, true);
                    }
                } else
                {
                    NOM_FICHIER = 3;
                    InputStream inputstream1 = null;
                    Object obj3 = null;
                    try
                    {
                        inputstream1 = urlconnection.getInputStream();
                    }
                    catch(IOException _ex)
                    {
                        new Dialogue("Impossible de telecharger le fichier : " + nom);
                        progressBar.close();
                        verrou.fin(this, tree, numero, true);
                    }
                    char c = '\u0400';
                    byte abyte0[] = new byte[c];
                    int j = 0;
                    boolean flag1 = false;
                    String s2 = adr.substring(7, adr.length());
                    path(s2);
                    s2 = "./download/" + s2 + "/";
                    if(existeFichier(s2, nom, l))
                    {
                        FileOutputStream fileoutputstream;
                        try
                        {
                            fileoutputstream = new FileOutputStream(s2 + nom);
                        }
                        catch(FileNotFoundException filenotfoundexception)
                        {
                            new Dialogue("Fichier introuvable : " + filenotfoundexception);
                            progressBar.close();
                            verrou.fin(this, tree, numero, true);
                            return;
                        }
                        int k = 0;
                        int i1 = 0;
                        try
                        {
                            while(j >= 0) 
                            {
                                j = inputstream1.read(abyte0, 0, c);
                                fileoutputstream.write(abyte0);
                                if(j == -1)
                                    break;
                                i1 = k += 1024;
                                i1 = (k * 100) / i;
                            }
                            progressBar.progress(i1, i);
                            fileoutputstream.close();
                        }
                        catch(IOException ioexception)
                        {
                            new Dialogue("Impossible de lire le fichier : " + ioexception);
                            progressBar.close();
                            verrou.fin(this, tree, numero, true);
                            return;
                        }
                    }
                    verrou.fin(this, tree, numero, false);
                }
            } else
            {
                new Dialogue("Le site specifie n'existe pas. Veuillez corriger." + adr + "/" + nom);
                verrou.fin(this, tree, numero, true);
                progressBar.close();
            }
        } else
        {
            verrou.fin(this, tree, numero, true);
        }
    }

    boolean existeFichier(String s, String s1, long l)
    {
        File file = new File(s + s1);
        if(file.exists())
            return l > file.lastModified() || l == -1L;
        else
            return true;
    }

    void path(String s)
    {
        boolean flag = false;
        int i = 0;
        int j = 0;
        String s1 = "";
        File file = new File("./download");
        if(!file.exists())
            file.mkdir();
        for(; i < s.length(); i = j)
        {
            int k = j;
            for(; s.charAt(j) != '/' && j < s.length() - 1; j++);
            j++;
            s1 = s1 + s.substring(k, j);
            File file2 = new File("./download/" + s1);
            file2.mkdir();
        }

        File file1 = new File("./download/" + s);
        if(!file1.exists())
            file1.mkdir();
    }

    void lireTexte(String s, String s1, InputStream inputstream, int i, String s2, int j)
    {
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        boolean flag = false;
        int k = 0;
        boolean flag1 = false;
        try
        {
            FileWriter filewriter = new FileWriter(s + s1);
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            String s3;
            while((s3 = bufferedreader.readLine()) != null) 
            {
                printwriter.println(s3);
                k = ++k + s3.length();
                int l = k;
                l = (l * 100) / i;
                progressBar.progress(l, i);
                printwriter.flush();
            }
            printwriter.flush();
            printwriter.close();
            bufferedwriter.close();
            filewriter.close();
            bufferedreader.close();
        }
        catch(IOException ioexception)
        {
            new Dialogue("Impossible de creer le fichier sur le disque : " + ioexception);
            progressBar.close();
            verrou.fin(this, tree, numero, true);
            return;
        }
        if(i == -1)
            progressBar.close();
        verrou.fin(this, tree, numero, false);
        if(j == 1)
            analyse(s, s1, s2);
    }

    void analyse(String s, String s1, String s2)
    {
        RandomAccessFile randomaccessfile = null;
        String s3 = "";
        String s5 = "";
        String s7 = "";
        boolean flag = false;
        try
        {
            randomaccessfile = new RandomAccessFile(s + s1, "r");
        }
        catch(FileNotFoundException filenotfoundexception)
        {
            new Dialogue("Impossible de trouver le fichier specifie : " + filenotfoundexception);
            progressBar.close();
            verrou.fin(this, tree, numero, true);
            return;
        }
        profondeur++;
        try
        {
            String s4;
            while((s4 = randomaccessfile.readLine()) != null) 
            {
                for(int i = 0; i < s4.length(); i++)
                {
                    String s9 = "";
                    String s10 = "";
                    String s11 = "";
                    String s12 = "";
                    if(i + 10 < s4.length())
                        s11 = s4.substring(i, i + 10).toLowerCase();
                    if(i + 7 < s4.length())
                        s12 = s4.substring(i, i + 7).toLowerCase();
                    if(i + 4 < s4.length())
                        s9 = s4.substring(i, i + 4).toLowerCase();
                    if(i + 3 < s4.length())
                        s10 = s4.substring(i, i + 3).toLowerCase();
                    if(s4.length() <= 3)
                        break;
                    int j = i;
                    if("<script".equals(s12))
                    {
                        if(!Character.isLetter(s4.charAt(i + 7)))
                        {
                            i++;
                            while(s4 != null && !"</script>".equals(s4.substring(i, i + 9).toLowerCase())) 
                            {
                                if(++i + 9 <= s4.length())
                                    continue;
                                s4 = randomaccessfile.readLine();
                                i = 0;
                                for(; s4 == null || s4.length() < 9; s4 = randomaccessfile.readLine());
                                if(s4 == null)
                                    break;
                            }
                            s4 = randomaccessfile.readLine();
                            i = 0;
                        }
                    } else
                    if("href".equals(s9) || "src".equals(s10) || "background".equals(s11))
                    {
                        boolean flag1 = false;
                        while(s4.charAt(j) != '>') 
                            if(++j + 1 == s4.length())
                                s4 = s4 + randomaccessfile.readLine();
                        for(; i != s4.length() && s4.charAt(i) != '=' && s4.charAt(i) != '"'; i++);
                        for(i++; i != s4.length() && s4.charAt(i) == ' ' && s4.charAt(i) != '"'; i++);
                        if(s4.charAt(i) == '"')
                            i++;
                        if(s4.charAt(i) == '.' && s4.charAt(i + 1) == '/')
                            i += 2;
                        int k;
                        for(k = i; s4.charAt(k) != '"' && s4.charAt(k) != '>' && s4.charAt(k) != ' '; k++);
                        String s6 = s4.substring(i, k);
                        for(; s4.charAt(i) != '>'; i++);
                        if(s6.startsWith("mailto:"))
                            flag1 = true;
                        if(s6.startsWith("http://"))
                        {
                            int l;
                            for(l = 7; l != s6.length() && s6.charAt(l) != '/'; l++);
                            int j1;
                            for(j1 = 7; j1 != s2.length() && s2.charAt(j1) != '/'; j1++);
                            String s13 = s6.substring(7, l);
                            String s14 = s2.substring(7, j1);
                            if(profondeur <= profPref)
                            {
                                int l1 = s6.length() - 1;
                                boolean flag3 = false;
                                for(; l1 != 0 && s6.charAt(l1) != '/'; l1--);
                                if(l1 != 0)
                                    s1 = s6.substring(l1 + 1, s6.length());
                                for(int i2 = 0; i2 < s1.length(); i2++)
                                {
                                    if(s1.charAt(i2) != '.')
                                        continue;
                                    flag3 = true;
                                    break;
                                }

                                if("http://".equals(s6.substring(l1 - 6, l1 + 1)))
                                    flag3 = false;
                                if(!flag3)
                                    s1 = "index.html";
                                if(flag3)
                                    s6 = s6.substring(0, l1);
                                if(!s14.equals(s13) && changementSite)
                                {
                                    verrou.lien(s6, s1, profondeur, numero, tree, this);
                                    s6 = "";
                                } else
                                if(s14.equals(s13))
                                {
                                    verrou.lien(s6, s1, profondeur, numero, tree, this);
                                    s6 = "";
                                }
                            }
                        } else
                        if(!flag1)
                        {
                            int i1 = s6.length() - 1;
                            boolean flag2 = false;
                            for(; i1 != 0 && s6.charAt(i1) != '/'; i1--);
                            if(i1 != 0)
                                s1 = s6.substring(i1 + 1, s6.length());
                            else
                                s1 = s6.substring(i1, s6.length());
                            for(int k1 = 0; k1 < s1.length(); k1++)
                            {
                                if(s1.charAt(k1) != '.')
                                    continue;
                                flag2 = true;
                                break;
                            }

                            if(!flag2)
                                s1 = "index.html";
                            String s8;
                            if(i1 != 0)
                            {
                                if(flag2)
                                    s8 = s2 + "/" + s6.substring(0, i1);
                                else
                                    s8 = s2 + "/" + s6;
                            } else
                            if(!flag2)
                                s8 = s2 + "/" + s6;
                            else
                                s8 = s2;
                            if(profondeur <= profPref)
                                verrou.lien(s8, s1, profondeur, numero, tree, this);
                            s6 = "";
                        }
                    }
                }

            }
            try
            {
                randomaccessfile.close();
            }
            catch(IOException ioexception)
            {
                new Dialogue("Impossible de fermer le fichier : " + ioexception);
                progressBar.close();
                verrou.fin(this, tree, numero, true);
                return;
            }
        }
        catch(IOException ioexception1)
        {
            new Dialogue("Impossible de lire le fichier specifie : " + ioexception1);
            progressBar.close();
            verrou.fin(this, tree, numero, true);
            return;
        }
    }

    Windows win;
    String adr;
    String nom;
    MyPanelTree tree;
    Graphique progressBar;
    static int nbThread = 0;
    static int num = 0;
    static boolean CHANGEMENT = true;
    int nbThreadMax;
    int NOM_FICHIER;
    int numero;
    static boolean changementSite = false;
    static boolean pref[] = new boolean[8];
    int profondeur;
    static int profPref;
    boolean continu;
    boolean FTP;
    Verrou verrou;

}
