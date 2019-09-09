<?xml version="1.0" encoding="UTF-8" ?>
<feed xmlns="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/">
<title type="html">Les fiches de Bébert - LaTeX insérer des illustrations et triturer du texte - Commentaires</title>
<subtitle type="html">pour une véritable Publication Assistée par Ordinateur</subtitle>
<link href="http://bertrandmasson.free.fr/feed.php?atom/commentaires/article25" rel="self" type="application/atom+xml"/>
<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte" rel="alternate" type="text/html"/>
<updated>2011-06-27T17:13:02+01:00</updated>
<id>urn:md5:82c3ea1d9bce7a75759f2e9788476752</id>
<generator uri="http://pluxml.org/">PluXml 5.0.2</generator>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Bertrand Masson le lundi 27 juin 2011, 17:13</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309187582-1"/>
	<id>urn:md5:005dd2310efe1e1066c85ba2cf81a855</id>
	<updated>2011-06-27T17:13:02+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Manuel :
You can use my slides. I put the source file at the end of the article.

Bertrand</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Manuel le lundi 27 juin 2011, 16:41</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309185673-1"/>
	<id>urn:md5:428ee1d2457eb08527063f8d5f58e161</id>
	<updated>2011-06-27T16:41:13+01:00</updated>
	<author><name>Manuel</name></author>
	<content type="html">I see - that is a lot of work. I was hoping that there is a &amp;#039;automatic&amp;#039; way to do that. Can I use your slides (the box part) in a presentation?

Manuel</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Bertrand Masson le lundi 27 juin 2011, 11:04</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309165450-1"/>
	<id>urn:md5:6cf216b5b20908f389a806ecfc176632</id>
	<updated>2011-06-27T11:04:10+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Manuel :
Hello Manuel,

My method is empirical.
There is certainly a way to retrieve the coordinates of an object on the page but I can not do that.

Here&#039;s how I did:
  First I create a grid (grille in french) that allows me to place my items

\newcommand{\grille}{
 \begin{tikzpicture}[overlay,remember picture]
  \begin{scope}[shift={(current page.south west)}]
    \draw[gray!50] (0,0) grid[step=2mm] (current page.north east);
    \draw[red!50] (0,0) grid[step=1cm] (current page.north east);
  \end{scope}
\end{tikzpicture}
}

Here is the code of my first compilation :

\documentclass[]{beamer}
\usepackage{tikz}

\newcommand{\grille}{
 \begin{tikzpicture}[overlay,remember picture]
  \begin{scope}[shift={(current page.south west)}]
    \draw[gray!50] (0,0) grid[step=2mm] (current page.north east);
    \draw[red!50] (0,0) grid[step=1cm] (current page.north east);
  \end{scope}
\end{tikzpicture}
}

\begin{document}
\begin{frame}
\begin{center}
{\fontsize{45}{45}\selectfont Un petit} \includegraphics[scale=0.25]{gnuOrange}\, {\fontsize{45}{45}\selectfont gnu}
\end{center}

\grille
\end{frame}
\end{document}

Be careful when you are using tikz and overlay it takes two compilations for proper positioning
I count manually the coordinates of the frame on the screen.
The red squares are 1cm and the gray are 2mm
In this example (6.3,5.2) and (9.2,6.4)

I draw the framework

\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)}]
\draw (6.3,5.2) rectangle (9.2,6.4);
\end{scope}
\end{tikzpicture}

After two compilations, I adjust if necessary, and if it&#039;s good I remove the grid

The final code :

\documentclass[]{beamer}
\usepackage{tikz}

\newcommand{\grille}{
 \begin{tikzpicture}[overlay,remember picture]
  \begin{scope}[shift={(current page.south west)}]
    \draw[gray!50] (0,0) grid[step=2mm] (current page.north east);
    \draw[red!50] (0,0) grid[step=1cm] (current page.north east);
  \end{scope}
\end{tikzpicture}
}

\begin{document}
\begin{frame}

\begin{center}
{\fontsize{45}{45}\selectfont Un petit} \includegraphics[scale=0.25]{gnuOrange}\, {\fontsize{45}{45}\selectfont gnu}
\end{center}

\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)}]
\draw (6.3,5.2) rectangle (9.2,6.4);
\end{scope}
\end{tikzpicture}

%\grille

\end{frame}
\end{document}

Bertrand</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Manuel le lundi 27 juin 2011, 09:33</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309160012-1"/>
	<id>urn:md5:0dadc55e0f07809577e2e2e686542e1c</id>
	<updated>2011-06-27T09:33:32+01:00</updated>
	<author><name>Manuel</name></author>
	<content type="html">Hello Bertrand, I tried to make the code working. I changed \latex to \LaTeX{} and removed some other costom code.

I also extracted the gno picture from your pdf.

But something is still wrong: the boxes are at the wrong place. What am I missing?

\documentclass[]{beamer}
\usepackage[french]{babel}
\usepackage{tikz}

\begin{document}
\begin{frame}[fragile]
\frametitle{\LaTeX{} et les boites}
\onslide
\begin{center}
{\fontsize{45}{45}\selectfont Un petit} \includegraphics[scale=0.25]{gnuOrange}\, {\fontsize{45}{45}\selectfont gnu}
\end{center}


\onslide \LaTeX{} tout est boite. \LaTeX{} ne compose pas des mots avec des lettres mais manipule des boites qui contiennent des objets. Un peu comme les ouvriers typographes et leurs caractères en plomb.\par
\onslide
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)}]
\draw (1.15,6.8) rectangle (2.15,7.9);
\draw (2.15,6.8) rectangle (2.9,7.5);
\draw (2.9,6.8) rectangle (3.47,7.5);
\draw (3.47,6.5) rectangle (4.2,7.5);
\draw (4.2,6.8) rectangle (4.9,7.5);
\draw (4.9,6.8) rectangle (5.45,7.7);
\draw (5.45,6.8) rectangle (5.75,7.85);
\draw (5.75,6.8) rectangle (6.3,7.7);
\draw (6.3,6.8) rectangle (9.3,7.9);
\draw (9.3,6.5) rectangle (10.1,7.5);
\draw (10.1,6.8) rectangle (10.9,7.5);
\draw (10.9,6.8) rectangle (11.6,7.5);
\end{scope}
\end{tikzpicture}
\onslide&amp;lt;1&amp;gt;
On a donc des boites qui contiennent des lettres.
\onslide&amp;lt;2&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)},draw=red]
\draw (1.15,6.8) rectangle (2.9,7.9);
\draw (3.47,6.25) rectangle (6.3,7.85);
\draw (9.3,6.25) rectangle (11.6,7.5);
\end{scope}
\end{tikzpicture}
\onslide des boites de mots contenant des boites de lettres
\onslide&amp;lt;3&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)},draw=blue]
\draw (1.15,6.25) rectangle (11.6,7.9);
\end{scope}
\end{tikzpicture}
\onslide enfin des boites de phrases contenant des boites de mots. Le logo gnu est aussi mis en boite.\par
\onslide&amp;lt;4&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)}]
\draw (1.15,6.8) circle (2pt);
\draw (2.15,6.8) circle (2pt);
\draw (2.9,6.8) circle (2pt);
\draw (3.47,6.8) circle (2pt);
\draw (4.2,6.8) circle (2pt);
\draw (4.9,6.8) circle (2pt);
\draw (5.45,6.8) circle (2pt);
\draw (5.75,6.8) circle (2pt);
\draw (6.3,6.8) circle (2pt);
\draw (9.3,6.8) circle (2pt);
\draw (10.1,6.8) circle (2pt);
\draw (10.9,6.8) circle (2pt);
\end{scope}
\end{tikzpicture}
\onslide boite à une origine.\par
\onslide&amp;lt;5&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)},draw=red]
\draw (1.15,6.8) circle (2pt);
\draw (2.9,6.8) circle (2pt);
\draw (3.47,6.8) circle (2pt);
\draw (6.3,6.8) circle (2pt);
\end{scope}
\end{tikzpicture}
\onslide&amp;lt;6&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)},draw=blue]
\draw (1.15,6.8) circle (2pt);
\end{scope}
\end{tikzpicture}
\onslide&amp;lt;7&amp;gt;
\begin{tikzpicture}[overlay,remember picture]
\begin{scope}[shift={(current page.south west)},draw=green,thick]
\draw (0,6.8) -- (12.8,6.8);
\end{scope}
\end{tikzpicture}
\onslide&amp;lt;8&amp;gt;
\noindent
\LaTeX{} place cet origine sur une ligne appelée ligne de base. Tu peux remarquer que cette origine n&amp;#039;est pas toujours au coin en bas à gauche (lettres p et g).\par
\onslide boites \LaTeX{} ont trois dimensions : une largeur, une hauteur et une profondeur qui correspond à ce qui se trouve sous la ligne de base. Dans notre exemple, toutes les boites lettres ont une profondeur nulle à l&amp;#039;exception du p et du g.
\end{frame}

\end{document}</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Manuel le lundi 27 juin 2011, 09:15</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309158930-1"/>
	<id>urn:md5:68337199ec98c70d4ddce5eebcb7dae4</id>
	<updated>2011-06-27T09:15:30+01:00</updated>
	<author><name>Manuel</name></author>
	<content type="html">Thank you very much!</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Bertrand Masson le dimanche 26 juin 2011, 19:15</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309108542-1"/>
	<id>urn:md5:29337cc7c125dfac0764968990095f21</id>
	<updated>2011-06-26T19:15:42+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Manuel :
Hello Manuel,

To make the boxes I use Tikz, with the options overlay and remember

Here is the code on slide 10


 \begin{frame}[fragile]
   \frametitle{\latex et les boites}
\onslide 
\begin{center}
{\fontsize{45}{45}\selectfont Un petit} \includegraphics[scale=0.25]{gnuOrange}\, {\fontsize{45}{45}\selectfont gnu}
\end{center}


\onslidePour \latex tout est boite. \latex ne compose pas des mots avec des lettres mais manipule des boites qui contiennent des objets. Un peu comme les ouvriers typographes et leurs caractères en plomb.\par
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)}] 
    		\draw (1.15,6.8) rectangle (2.15,7.9);
    		\draw (2.15,6.8) rectangle (2.9,7.5);
    		\draw (2.9,6.8) rectangle (3.47,7.5);
    		\draw (3.47,6.5) rectangle (4.2,7.5);
    		\draw (4.2,6.8) rectangle (4.9,7.5);
    		\draw (4.9,6.8) rectangle (5.45,7.7);
    		\draw (5.45,6.8) rectangle (5.75,7.85);
    		\draw (5.75,6.8) rectangle (6.3,7.7);
    		\draw (6.3,6.8) rectangle (9.3,7.9);
    		\draw (9.3,6.5) rectangle (10.1,7.5);
    		\draw (10.1,6.8) rectangle (10.9,7.5);
    		\draw (10.9,6.8) rectangle (11.6,7.5);
    	 \end{scope}   
\end{tikzpicture}
\onslide
On a donc des boites qui contiennent des lettres. 
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)},draw=red] 
    		\draw (1.15,6.8) rectangle (2.9,7.9);
    		\draw (3.47,6.25) rectangle (6.3,7.85);
    		\draw (9.3,6.25) rectangle (11.6,7.5);    	
    	 \end{scope}   
\end{tikzpicture}
\onslidePuis des boites de mots contenant des boites de lettres
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)},draw=blue] 
    		\draw (1.15,6.25) rectangle (11.6,7.9);  	
    	 \end{scope}   
\end{tikzpicture}
\onslideet enfin des boites de phrases contenant des boites de mots. Le logo gnu est aussi mis en boite.\par
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)}] 
    		\draw (1.15,6.8) circle (2pt);
    		\draw (2.15,6.8) circle (2pt);
    		\draw (2.9,6.8) circle (2pt);
    		\draw (3.47,6.8) circle (2pt);
    		\draw (4.2,6.8) circle (2pt);
    		\draw (4.9,6.8) circle (2pt);
    		\draw (5.45,6.8) circle (2pt);
    		\draw (5.75,6.8) circle (2pt);
    		\draw (6.3,6.8) circle (2pt);
    		\draw (9.3,6.8) circle (2pt);
    		\draw (10.1,6.8) circle (2pt);
    		\draw (10.9,6.8) circle (2pt);
    	 \end{scope}   
\end{tikzpicture}
\onslideChaque boite à une origine.\par
\onslide\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)},draw=red] 
    		\draw (1.15,6.8) circle (2pt);
       		\draw (2.9,6.8) circle (2pt);
    		\draw (3.47,6.8) circle (2pt);
    		\draw (6.3,6.8) circle (2pt);  	
    	 \end{scope}   
\end{tikzpicture}
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)},draw=blue] 
    		\draw (1.15,6.8) circle (2pt); 
    	 \end{scope}   
\end{tikzpicture}
\onslide
\begin{tikzpicture}[overlay,remember picture]
	\begin{scope}[shift={(current page.south west)},draw=green,thick] 
    		\draw (0,6.8) -- (12.8,6.8); 
    	 \end{scope}   
\end{tikzpicture}
\onslide\noindent
\latex place cet origine sur une ligne appelée ligne de base. Tu peux remarquer que cette origine n&#039;est pas toujours au coin en bas à gauche (lettres p et g).\par
\onslideLes boites \latex ont trois dimensions : une largeur, une hauteur et une profondeur qui correspond à ce qui se trouve sous la ligne de base. Dans notre exemple, toutes les boites lettres ont une profondeur nulle à l&#039;exception du p et du g.
\end{frame}

Bertrand</content>
</entry>
<entry>
	<title type="html">LaTeX insérer des illustrations et triturer du texte - par Manuel le dimanche 26 juin 2011, 14:50</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte/atom#c1309092606-1"/>
	<id>urn:md5:f9c78403a6d5fc85781a60c59312a731</id>
	<updated>2011-06-26T14:50:06+01:00</updated>
	<author><name>Manuel</name></author>
	<content type="html">Hello, I really like your LaTeX stuff. I don&amp;#039;t speak French but I like the examples. Can you tell me how you did the boxes at page 10 (LATEX et les boites)?

I also do LaTeX presentations, here&amp;#039;s a tutorial in German:

http://bipede.de/Downloads/LaTeX-Kurs/Kurs-Folien_2011-05-24.pdf

Thank you very much
Manuel</content>
</entry>
</feed>