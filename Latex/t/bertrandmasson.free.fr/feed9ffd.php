<?xml version="1.0" encoding="UTF-8" ?>
<feed xmlns="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/">
<title type="html">Les fiches de Bébert - KOMA-Script &amp; le sectionnement du texte - Commentaires</title>
<subtitle type="html">pour une véritable Publication Assistée par Ordinateur</subtitle>
<link href="http://bertrandmasson.free.fr/feed.php?atom/commentaires/article23" rel="self" type="application/atom+xml"/>
<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte" rel="alternate" type="text/html"/>
<updated>2013-01-28T13:29:13+01:00</updated>
<id>urn:md5:dca43b5f21be6fa356dd072bad7f44bd</id>
<generator uri="http://pluxml.org/">PluXml 5.0.2</generator>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par Bertrand Masson le lundi 28 janvier 2013, 13:29</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1359376153-1"/>
	<id>urn:md5:5955fdf1c77178da89fd41530b41bb83</id>
	<updated>2013-01-28T13:29:13+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Julie D. :
Bonjour,
Pour éviter de taper à chaque fois \addcontentsline{toc}{subsubsection}{Le titre de la sous sous section}
tu peux te créer une commande du type :

\newcommand{\masubsection}[1]{\subsection*{#1}
\addcontentsline{toc}{subsection}{#1}}

que tu emplois comme ceci :

\section{Le titre de ma section}
\masubsection{Le titre de ma subsection}

Bertrand</content>
</entry>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par Julie D. le lundi 28 janvier 2013, 12:26</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1359372389-1"/>
	<id>urn:md5:53c97bf5f2425d188acf3d70552cbc33</id>
	<updated>2013-01-28T12:26:29+01:00</updated>
	<author><name>Julie D.</name></author>
	<content type="html">Merci beaucoup pour ta réponse et pour le code. 
Je suis dans le deuxième cas : j&amp;#039;édite des fragments, qui se trouvent au niveau subsubsection, donc je veux leur donner moi-même un numéro sans que LaTeX leur en attribue un, mais qu&amp;#039;ils apparaissent dans la table. Comme il y en a beaucoup je cherchais une version alternative de \addsec qui m&amp;#039;aurait évité de remettre à chaque fois \addcontentsline{toc}{subsubsection}{Le titre de la sous sous section} - et pour laquelle il n&amp;#039;y aurait pas eu besoin de créer une macro, car je maîtrise très mal cette syntaxe et qu&amp;#039;en plus je ne sais pas où trouver la macro de base de \addsec pour la modifier.
Je vais donc en rester aux solutions traditionnelles comme tu le conseilles. 

Julie</content>
</entry>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par Bertrand Masson le vendredi 25 janvier 2013, 18:21</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1359134519-1"/>
	<id>urn:md5:35c8baa3513a7c678e8c0c86402a815e</id>
	<updated>2013-01-25T18:21:59+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Julie D. :
Bonjour,

Je n&#039;ai pas bien compris si tous tes niveaux étaient non numérotés ou seulement les sous sections.
Mais dans tous les cas il faut ajouter dans le préambule

\setcounter{tocdepth}{3}

si non, tes sous sous sections n&#039;apparaissent pas dans la table des matières
Voici les 2 solutions
Premier cas aucune section n&#039;est numérotée, tu ajoutes dans le préambule
\setcounter{secnumdepth}{-2}
 et tu utilises normalement
\chapter{titre chapitre}
\section{titre section}
\subsection{titre sous section}
\subsubsection{titre sous sous section}

Les différentes sections apparaitront dans la table des matières non numérotées
Le code :
\documentclass{scrbook}

\usepackage[utf8]{inputenc}

\usepackage[T1]{fontenc}

\usepackage{lmodern}

\usepackage[french]{babel}


\setcounter{secnumdepth}{-2}

\setcounter{tocdepth}{3}

\begin{document}


\tableofcontents


\chapter{Un titre de chapitre}

\section{Première section}

\subsection{Sous section}

\subsubsection{Sous Sous section}

\section{Deuxième section}


\end{document}




Deuxième solution si seules les sous sections son non numérotés tu utilises la méthode classique de LaTeX pour ajouter dans la table des matière des sections non numérotées :
\subsection*{Sous section}

\addcontentsline{toc}{subsection}{Le titre de la sous section}
Le texte de ta sous section....

et
\subsubsection*{Sous Sous section}

\addcontentsline{toc}{subsubsection}{Le titre de la sous sous section}

Le texte de ta sous section....


Après 2 compilations tu devrais obtenir le bon résultat

Le code :
\documentclass{scrbook}

\usepackage[utf8]{inputenc}

\usepackage[T1]{fontenc}

\usepackage{lmodern}

\usepackage[french]{babel}


\setcounter{tocdepth}{3}

\begin{document}


\tableofcontents


\chapter{Un titre de chapitre}

\section{Première section}

\subsection*{Sous section}

\addcontentsline{toc}{subsection}{Le titre de la sous section}

\subsubsection*{Sous Sous section}

\addcontentsline{toc}{subsubsection}{Le titre de la sous sous section}

\addsec{Deuxième section non numéroté}


\end{document}




Bertrand</content>
</entry>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par Julie D. le jeudi 24 janvier 2013, 18:25</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1359048354-1"/>
	<id>urn:md5:27c364f74b5c64473514cc6226fa2cc5</id>
	<updated>2013-01-24T18:25:54+01:00</updated>
	<author><name>Julie D.</name></author>
	<content type="html">Bonjour, et merci pour toutes vos fiches ! J&amp;#039;ai cherché un peu partout, y compris dans la doc de koma-script, mais je n&amp;#039;ai pas trouvé comment on pouvait fabriquer des commandes du type \addsubsec \addsubsubsec... j&amp;#039;aimerais que ces titres apparaissent en titres courants et dans la table des matières, mais je ne veux pas les numéroter de manière automatique... serait-ce possible, et comment ? Je sais que cela fait beaucoup de niveaux, mais c&amp;#039;est pour une thèse.</content>
</entry>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par Bertrand Masson le mercredi 05 septembre 2012, 22:14</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1346876052-1"/>
	<id>urn:md5:492f81230e252c48c7fbdcd11cd2d620</id>
	<updated>2012-09-05T22:14:12+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@lerat :
Merci, pour cette remarque je vais corriger la faute
Bertrand</content>
</entry>
<entry>
	<title type="html">KOMA-Script &amp; le sectionnement du texte - par lerat le mardi 04 septembre 2012, 22:51</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article23/koma-script-le-sectionnement-du-texte/atom#c1346791886-1"/>
	<id>urn:md5:43af3234a395914f8b5a1b9ad16f7f32</id>
	<updated>2012-09-04T22:51:26+01:00</updated>
	<author><name>lerat</name></author>
	<content type="html">Tout d&amp;#039;abord, merci pour cette présentation, très instructive.
Pour ceux qui arriveraient sur ce site, et qui comme moi se casseront la tête pour cette bêtise, il y a une petite coquille dans une fonction.
Ce n&amp;#039;est pas &amp;quot;numbers=notenddot&amp;quot; mais bien &amp;quot;numbers=noenddot&amp;quot; sans t !
Voilà. ;)</content>
</entry>
</feed>