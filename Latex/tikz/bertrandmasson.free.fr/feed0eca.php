<?xml version="1.0" encoding="UTF-8" ?>
<feed xmlns="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/">
<title type="html">Les fiches de Bébert - PGF-Tikz</title>
<subtitle type="html">pour une véritable Publication Assistée par Ordinateur</subtitle>
<link href="http://bertrandmasson.free.fr/feed.php?atom/categorie6" rel="self" type="application/atom+xml"/>
<link href="http://bertrandmasson.free.fr/index.php?categorie6/latex-pgf-tikz" rel="alternate" type="text/html"/>
<updated>2010-10-01T16:51:00+01:00</updated>
<id>urn:md5:7867b45976eeb02b0eef945ad4045fbd</id>
<generator uri="http://pluxml.org/">PluXml 5.0.2</generator>
<entry>
	<title>Comment faire de beaux graphiques avec Tikz et PGFPLOTS</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article28/comment-faire-de-beaux-graphiques-avec-tikz-et-pgfplots"/>
	<id>urn:md5:f0333c74da50f2a85a1cdce96774335d</id>
	<updated>2010-10-01T16:51:00+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<dc:subject>LaTeX, PGF-Tikz</dc:subject>
	<content type="html">Le but de ce tutoriel est d&#039;apprendre à réaliser des graphiques à l&#039;aide de Tikz et PGFPLOTS. Pourquoi ne pas utiliser un logiciel spécialisé comme un tableur ? Il y a plusieurs raisons.
&lt;bd/&gt;
l&#039;exportation d&#039;un graphique fait à l&#039;aide d&#039;un tableur en un document compris par LaTeX n&#039;est pas toujours aisé et tu te retrouves souvent à exporter ton graphique sous un format image, qui perd beaucoup en qualité ;
l&#039;insertion dans LaTeX notamment au niveau de l&#039;échelle, n&#039;est pas toujours heureuse. Tu es amené à souvent réduire sa taille, rendant souvent des parties du graphique illisibles (taille de caractère trop petite, pixelisation,...) ;
tu perds la continuité typographique de ton document (polices différentes).&lt;bd/&gt;
Donc pour des graphiques parfaitement intégrés à ton document, utilise le couple Tikz et PGFPLOTS, en plus ce n&#039;est guère plus compliqué à utiliser qu&#039;un tableur.
&lt;bd/&gt;
Voici le fichier : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvZ3JhcGhpcXVlcy5wZGYqNGViOWIw&quot;&gt;graphiques.pdf&lt;/a&gt;

&lt;!-- phpmyvisites --&gt;
 &lt;a href=&quot;http://st.free.fr/&quot; title=&quot;phpMyVisites | Open source web analytics&quot; 
 onclick=&quot;window.open(this.href);return(false);&quot;&gt;&lt;script type=&quot;text/javascript&quot;&gt;
 &lt;!--
 var a_vars = Array();
var pagename = document.title;

 var phpmyvisitesSite = 241711;
 var phpmyvisitesURL = &quot;http://st.free.fr/phpmyvisites.php&quot;;
 //--&gt;
 &lt;/script&gt;
 &lt;script language=&quot;javascript&quot; src=&quot;http://st.free.fr/phpmyvisites.js&quot; type=&quot;text/javascript&quot;&gt;&lt;/script&gt;
 &lt;object&gt;&lt;noscript&gt;&lt;p&gt;phpMyVisites | Open source web analytics
 &lt;img src=&quot;http://st.free.fr/phpmyvisites.php&quot; alt=&quot;Statistics&quot; style=&quot;border:0&quot; /&gt;
 &lt;/p&gt;&lt;/noscript&gt;&lt;/object&gt;&lt;/a&gt;
 &lt;!-- /phpmyvisites --&gt;</content>
</entry>
<entry>
	<title>LaTeX insérer des illustrations et triturer du texte</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article25/latex-inserer-des-illustrations-et-triturer-du-texte"/>
	<id>urn:md5:82c3ea1d9bce7a75759f2e9788476752</id>
	<updated>2010-03-07T16:45:00+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<dc:subject>LaTeX, PGF-Tikz</dc:subject>
	<content type="html">Voici une fiche qui te montre comment insérer des illustrations dans LaTeX. Attention cette fiche ne parle pas des flottants mais de \includegraphics du packages graphicx. Donc c&#039;est juste une fiche qui te montre comment mettre des petits dessins leur faire subir des rotations, des agrandissements ou les rétrécir, mais pas de leur attribuer une légende, ni faire une table des illustrations. Ce sera pour une autre fiche. Comme on parle du package graphicx j&#039;en profite pour évoquer les commandes \reflectbox, \scalebox, \resizebox et \rotatebox, qui permettent de triturer du texte.

&lt;p&gt;Voici le fichier : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvaWxsdXN0cmF0aW9uLnBkZipiNDYwZjA,&quot;&gt;illustration.pdf&lt;/a&gt;&lt;/p&gt;

&lt;p&gt;Le source : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvaWxsdXN0cmF0aW9uLnRleCpkM2IyNDg,&quot;&gt;illustration.tex&lt;/a&gt;&lt;/p&gt;

&lt;!-- phpmyvisites --&gt;
 &lt;a href=&quot;http://st.free.fr/&quot; title=&quot;phpMyVisites | Open source web analytics&quot; 
 onclick=&quot;window.open(this.href);return(false);&quot;&gt;&lt;script type=&quot;text/javascript&quot;&gt;
 &lt;!--
 var a_vars = Array();
var pagename = document.title;

 var phpmyvisitesSite = 241711;
 var phpmyvisitesURL = &quot;http://st.free.fr/phpmyvisites.php&quot;;
 //--&gt;
 &lt;/script&gt;
 &lt;script language=&quot;javascript&quot; src=&quot;http://st.free.fr/phpmyvisites.js&quot; type=&quot;text/javascript&quot;&gt;&lt;/script&gt;
 &lt;object&gt;&lt;noscript&gt;&lt;p&gt;phpMyVisites | Open source web analytics
 &lt;img src=&quot;http://st.free.fr/phpmyvisites.php&quot; alt=&quot;Statistics&quot; style=&quot;border:0&quot; /&gt;
 &lt;/p&gt;&lt;/noscript&gt;&lt;/object&gt;&lt;/a&gt;
 &lt;!-- /phpmyvisites --&gt;</content>
</entry>
<entry>
	<title>TikZ le positionnement des &quot;node&quot;</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article24/tikz-le-positionnement-des-node"/>
	<id>urn:md5:05ed7dac300222002cf102f340f9d1c5</id>
	<updated>2010-02-11T16:44:00+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<dc:subject>LaTeX, PGF-Tikz</dc:subject>
	<content type="html">Les &quot;node&quot; sous TikZ permettent de placer du texte ou tout autre objet LaTeX (tableau, boite, image,...) Dans cette fiche nous aborderons le placement des &quot;node&quot; dans ton dessin. Placer du texte à coté d&#039;un point, au-dessus et au milieu d&#039;une ligne... Les possibilités sont grandes, et permettent de faire des illustrations de grandes qualités et même des effets assez spectaculaire, comme tu le verras à la fin de la fiche.

Voici le fichier : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvbm9kZS5wZGYqYjkxYzVh&quot;&gt;node.pdf&lt;/a&gt;

&lt;!-- phpmyvisites --&gt;
 &lt;a href=&quot;http://st.free.fr/&quot; title=&quot;phpMyVisites | Open source web analytics&quot; 
 onclick=&quot;window.open(this.href);return(false);&quot;&gt;&lt;script type=&quot;text/javascript&quot;&gt;
 &lt;!--
 var a_vars = Array();
var pagename = document.title;

 var phpmyvisitesSite = 241711;
 var phpmyvisitesURL = &quot;http://st.free.fr/phpmyvisites.php&quot;;
 //--&gt;
 &lt;/script&gt;
 &lt;script language=&quot;javascript&quot; src=&quot;http://st.free.fr/phpmyvisites.js&quot; type=&quot;text/javascript&quot;&gt;&lt;/script&gt;
 &lt;object&gt;&lt;noscript&gt;&lt;p&gt;phpMyVisites | Open source web analytics
 &lt;img src=&quot;http://st.free.fr/phpmyvisites.php&quot; alt=&quot;Statistics&quot; style=&quot;border:0&quot; /&gt;
 &lt;/p&gt;&lt;/noscript&gt;&lt;/object&gt;&lt;/a&gt;
 &lt;!-- /phpmyvisites --&gt;</content>
</entry>
<entry>
	<title>PGF Tikz modifier la forme des lignes</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article19/pgf-tikz-modifier-la-forme-des-lignes"/>
	<id>urn:md5:8d4ed2d8a578fc72f0b4bb74eada47ce</id>
	<updated>2009-10-20T14:59:00+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<dc:subject>LaTeX, PGF-Tikz</dc:subject>
	<content type="html">Dans cette fiche on verra comment changer l&#039;aspect des lignes :

lignes en pointillé
lignes à bout rond
lignes doubles
lignes avec des flèches
lignes avec angles arrondis
....
Voici le fichier pdf : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvdGlremxpZ25lcy5wZGYqZDI5YTM5&quot;&gt;tikzlignes.pdf&lt;/a&gt;

&lt;!-- phpmyvisites --&gt;
 &lt;a href=&quot;http://st.free.fr/&quot; title=&quot;phpMyVisites | Open source web analytics&quot; 
 onclick=&quot;window.open(this.href);return(false);&quot;&gt;&lt;script type=&quot;text/javascript&quot;&gt;
 &lt;!--
 var a_vars = Array();
 var pagename = document.title;

 var phpmyvisitesSite = 241711;
 var phpmyvisitesURL = &quot;http://st.free.fr/phpmyvisites.php&quot;;
 //--&gt;
 &lt;/script&gt;
 &lt;script language=&quot;javascript&quot; src=&quot;http://st.free.fr/phpmyvisites.js&quot; type=&quot;text/javascript&quot;&gt;&lt;/script&gt;
 &lt;object&gt;&lt;noscript&gt;&lt;p&gt;phpMyVisites | Open source web analytics
 &lt;img src=&quot;http://st.free.fr/phpmyvisites.php&quot; alt=&quot;Statistics&quot; style=&quot;border:0&quot; /&gt;
 &lt;/p&gt;&lt;/noscript&gt;&lt;/object&gt;&lt;/a&gt;
 &lt;!-- /phpmyvisites --&gt;</content>
</entry>
<entry>
	<title>PGF &amp; Tikz</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz"/>
	<id>urn:md5:94be2eda20d6d15ec544087dd3bf3726</id>
	<updated>2009-10-15T14:51:00+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<dc:subject>LaTeX, PGF-Tikz</dc:subject>
	<content type="html">PGF &amp; Tikz est un ensemble de commandes pour LaTeX permettant de faire des dessins vectoriels. Son avantage est d&#039;être directement compilable par pdflatex. Je l&#039;utilise pour faire des schémas explicatifs, des animations pour mes présentations avec beamer et surtout pour ajouter un côté &quot;PAO&quot; à LaTeX.

Voici la première fiche consacré à PGF Tikz. Attention sous certain viewer des pages ne &quot;sortent&quot; pas bien notamment celles consacrées aux dégradés et une des premières pages avec une petite animation. Pour les apprécier il faut malheureusement utiliser acroread d&#039;Adobe (ne frappez pas, je sais c&#039;est le mal absolu, mais je ne vous oblige pas à l&#039;utiliser, ces pages seront lisibles quand même, mais moche) : &lt;a href=&quot;http://bertrandmasson.free.fr/./?telechargement/Li4vLi4vZGF0YS9kb2N1bWVudHMvbGF0ZXgvaW50cm90aWt6LnBkZiphZjU2YjE,&quot;&gt;introtikz.pdf&lt;/a&gt;

&lt;!-- phpmyvisites --&gt;
 &lt;a href=&quot;http://st.free.fr/&quot; title=&quot;phpMyVisites | Open source web analytics&quot; 
 onclick=&quot;window.open(this.href);return(false);&quot;&gt;&lt;script type=&quot;text/javascript&quot;&gt;
 &lt;!--
 var a_vars = Array();
 var pagename = document.title;
 var phpmyvisitesSite = 241711;
 var phpmyvisitesURL = &quot;http://st.free.fr/phpmyvisites.php&quot;;
 //--&gt;
 &lt;/script&gt;
 &lt;script language=&quot;javascript&quot; src=&quot;http://st.free.fr/phpmyvisites.js&quot; type=&quot;text/javascript&quot;&gt;&lt;/script&gt;
 &lt;object&gt;&lt;noscript&gt;&lt;p&gt;phpMyVisites | Open source web analytics
 &lt;img src=&quot;http://st.free.fr/phpmyvisites.php&quot; alt=&quot;Statistics&quot; style=&quot;border:0&quot; /&gt;
 &lt;/p&gt;&lt;/noscript&gt;&lt;/object&gt;&lt;/a&gt;
 &lt;!-- /phpmyvisites --&gt;</content>
</entry>
</feed>