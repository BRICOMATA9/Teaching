<?xml version="1.0" encoding="UTF-8" ?>
<feed xmlns="http://www.w3.org/2005/Atom" xmlns:dc="http://purl.org/dc/elements/1.1/">
<title type="html">Les fiches de Bébert - PGF &amp; Tikz - Commentaires</title>
<subtitle type="html">pour une véritable Publication Assistée par Ordinateur</subtitle>
<link href="http://bertrandmasson.free.fr/feed.php?atom/commentaires/article17" rel="self" type="application/atom+xml"/>
<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz" rel="alternate" type="text/html"/>
<updated>2012-06-13T23:08:22+01:00</updated>
<id>urn:md5:94be2eda20d6d15ec544087dd3bf3726</id>
<generator uri="http://pluxml.org/">PluXml 5.0.2</generator>
<entry>
	<title type="html">PGF &amp; Tikz - par Bertrand Masson le mercredi 13 juin 2012, 23:08</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1339621702-1"/>
	<id>urn:md5:26a0c9b992f340950133980ab4736c67</id>
	<updated>2012-06-13T23:08:22+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Guy :
Bonsoir Guy,
Étant archéologue j&#039;ai peu l&#039;occasion de faire des  schémas blocs. Outre lire la doc PGF TIKZ page 60, une possibilité est d&#039;utiliser le logiciel DIA (https://live.gnome.org/Dia) qui fonctionne sous linux et windows qui permet de faire de jolis schémas et de les exporter en LaTeX sous 3 formes différentes : en metapost en pstrick et en pgf-tikz. Les rares fois ou j&#039;ai du réaliser des schémas c&#039;est avec dia et export et tikz que je les ai fait.

Sinon pour les faire tikz tu trouveras des exemples ici : http://sciences-indus-cpge.papanicola.info/Schema-blocs-avec-PGF-TIKZ-sous

ou ici : http://www.texample.net/tikz/examples/schemabloc/

Bertrand</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Guy le mercredi 13 juin 2012, 13:40</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1339587647-1"/>
	<id>urn:md5:901ab196bcbdf9be119782717647b73c</id>
	<updated>2012-06-13T13:40:47+01:00</updated>
	<author><name>Guy</name></author>
	<content type="html">Bonjour et bravo pour ce remarquable travail de titan.
Pourriez m&amp;#039;aider parceque je cherche depuis longtemps comment réaliser de jolis schémas blocs ( automatique )?
En vous remerciant d&amp;#039;avance.
Guy.</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par le brésilien le jeudi 03 mai 2012, 13:05</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1336043112-1"/>
	<id>urn:md5:ffd09b5daa542a9cd414879de874f597</id>
	<updated>2012-05-03T13:05:12+01:00</updated>
	<author><name>le brésilien</name></author>
	<content type="html">Merci pour ces infos sur PGF je n&amp;#039;ai rien trouvé de comparable en Français ça m&amp;#039;a bien aidé pour mon mémoire.</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Capello le jeudi 22 mars 2012, 10:58</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1332410292-1"/>
	<id>urn:md5:b3631d3507357ac7cbcd16aa6c753f43</id>
	<updated>2012-03-22T10:58:12+01:00</updated>
	<author><name>Capello</name></author>
	<content type="html">Pour le wiki, c’est une bonne idée. Par contre, sans licence, c’est le droit d’auteur le plus strict qui s’applique par défaut. Mentionne domaine public ou une licence creative.
Pour la problématique de faire un dessin au dessus du texte, il y a un exemple sur :
http://www.texample.net/tikz/examples
http://www.texample.net/tikz/examples/beamer-arrows/
Le principe est de créer un « node » vide nommé dans le texte, puis de le relier à un autre en « overlay ». Je regarderai tes sources ce soir. Merci pour te disponibilité et ta réactivité.</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Bertrand Masson le mercredi 21 mars 2012, 22:05</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1332363906-1"/>
	<id>urn:md5:f3ea326ced5c338029be321b6a7c578b</id>
	<updated>2012-03-21T22:05:06+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Capello :
Bonsoir,

Ça dépend de ce que tu veux faire. Si tu veux relier par une flèche 2 mots d&#039;un texte comme exposé dans l&#039;avant dernière dia de la fiche &quot;TIKZ et PGF et les nodes&quot;, il faut utiliser les fonctions remember picture et overlay voici le code de cette frame :

%%%%%%%%%%%%
 %%%   diapo 26    %%%
 %%%%%%%%%%%%
\begin{frame}[fragile]
Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Ut purus elit, vestibulum ut, placerat ac, \tikz[baseline=(A.base),remember picture] \node[circle,red,draw] (A) {hello}; vitae, felis. Curabitur dictum gravida mauris. Nam arcu libero, nonummy eget, consectetuer id, vulputate a, magna. Donec vehicula augue eu neque.
Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris ut leo. Cras viverra metus rhoncus sem. Nulla et lectus vestibulum urna fringilla ultrices. Phasellus eu tellus sit amet tortor gravida placerat. Integer sapien est, iaculis in, pretium quis, \tikz[baseline=(B.base),remember picture] \node (B) {word}; ac, nunc. Praesent eget sem vel leo ultrices bibendum. Aenean faucibus. Morbi dolor nulla, malesuada eu, pulvinar at, mollis ac, nulla. Curabitur auctor semper nulla. Donec varius orci \tikz[baseline=(C.base),remember picture] \node[draw] (C) {hello}; risus. Duis nibh mi, congue eu, accumsan eleifend, sagittis quis, diam. Duis eget orci sit amet orci
dignissim rutrum.
Nam dui ligula, fringilla a, euismod sodales, sollicitudin vel, wisi. Morbi auctor lorem non justo. Nam lacus libero, pretium at, lobortis vitae, ultricies et, tellus. Donec aliquet, tortor sed accumsan bibendum, erat ligula aliquet magna, vitae ornare odio metus a mi. Morbi ac orci et nisl hendrerit mollis. Suspendisse ut massa. Cras nec \tikz[baseline=(D.base),remember picture] \node[draw] (D) {word}; ante. Pellentesque a nulla. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam  urna. Nulla ullamcorper vestibulum
turpis. Pellentesque cursus luctus mauris.
Nulla malesuada porttitor diam. Donec felis erat, congue non, volutpat at, tincidunt tristique, libero. Vivamus viverra fermentum felis. Donec nonummy pellentesque ante.
Phasellus adipiscing semper elit. Proin fermentum massa ac quam. Sed diam turpis, molestie vitae, placerat a, molestie nec, leo. Maecenas lacinia. Nam ipsum ligula, eleifend at, accumsan nec, suscipit a, ipsum. Morbi blandit ligula feugiat magna.
\begin{tikzpicture}[remember picture,overlay]
\draw[-&gt;,ultra thick,green,opacity=.5] (A) to[bend left] (B);
\draw[,ultra thick,blue,opacity=.3] (C) -| (D);
\end{tikzpicture}
\end{frame}

Les (A), (B),... sont des ancres qui permettent de relier des objets entre-eux. J&#039;ai mis en gras le code tikz.

Par contre dans l&#039;exemple que tu cites la méthode est plus empirique car je relie un mot d&#039;un texte à une image, j&#039;utilise dans ce cas que le mode overlay qui permet de ré-écrire sur une page. Voici un emc qui te montre comment je fais :

\documentclass[8pt]{beamer}
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
\grille
Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris ut leo. Cras viverra metus rhoncus sem. Nulla et lectus vestibulum urna fringilla ultrices. Phasellus eu tellus sit amet tortor gravida placerat. {\color{red}Integer} sapien est, iaculis in, pretium quis,  ac, nunc. Praesent eget sem vel leo ultrices bibendum. Aenean faucibus. Morbi dolor nulla, malesuada eu, pulvinar at, mollis ac, nulla. Curabitur auctor semper nulla. Donec varius orci risus. Duis nibh mi, congue eu, accumsan eleifend, sagittis quis, diam. Duis eget orci sit amet orci dignissim rutrum.

\vspace{2cm}
\includegraphics[scale=0.5]{image}

\begin{tikzpicture}
\draw[overlay,-&gt;,draw=red,line width=1pt] (9.5,7) -- (3,2);
\filldraw[green] (0,0)circle(2pt);
\end{tikzpicture}
\end{frame}
\end{document}

Je crée une grille qui me permet de calculer les coordonnées sur la page (l&#039;origine n&#039;est pas exactement en bas à gauche à cause des marges de la diapo). Cette grille dessine un quadrillage tous les 1 cm avec une subdivision tous les 2mm. J&#039;enlève cette grille pour la version finale quand j&#039;ai placé tous mes objets.

N&#039;oublie pas de remplacer image par une image à toi (pas trop grosse, celle que j&#039;utilise fait 380x250 pixels) située dans le même répertoire que l&#039;emc.

Attention les commandes overlay et remember nécessitent 2 compilations pour bien afficher les éléments. Tu peux placer \grille à la fin de ta diapo si tu veux qu&#039;elle recouvre l&#039;image.

J&#039;espère que je suis assez clair, n&#039;hésite pas à demander des précisions. La fiche qui explique en détail comment faire est toujours en cours de réalisation mais depuis quelques mois je suis assez débordé et je n&#039;ai que très peu de temps à consacrer aux fiches.

Concernant ton précédent mail évoquant github, je ne vais pas répondre directement. En effet, j&#039;ai décidé de transformer les fiches en un wiki donc les fiches ne seront plus &quot;fermées&quot; ce qui permettra à plus d&#039;y contribuer (notamment pour la correction des fautes). Les sources seront directement accessible et comme il n&#039;y aura pas de licence tout le monde pourra les re-pomper intégralement et librement. Il devrait voir le jour d&#039;ici à ... quand il sera prêt, j&#039;espère bientôt si mes activités me laisse un peu de temps pour les fiches.

Bertrand</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Capello le mercredi 21 mars 2012, 13:35</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1332333338-1"/>
	<id>urn:md5:2657ce68541025a0d8a8f41bcfffae7b</id>
	<updated>2012-03-21T13:35:38+01:00</updated>
	<author><name>Capello</name></author>
	<content type="html">Bonjour,
J’ai lu avec intérêt le pdf. Une chose m’interpelle. À la page 18 il y a une flèche entre le mot « origine » et le point (0,0). Je me demande comment tu as fais.</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Bertrand Masson le samedi 27 ao&amp;ucirc;t 2011, 17:27</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1314458870-1"/>
	<id>urn:md5:df71659334aed407868ab50327c6d894</id>
	<updated>2011-08-27T17:27:50+01:00</updated>
	<author><name>Bertrand Masson</name></author>
	<content type="html">@Jen :
Désolé de vous répondre si tardivement, j&#039;étais en vacances sans internet.
Pour vous aider il me faut un emc (exemple minimum complet) qui reproduise l&#039;erreur, un truc du genre :

\documentclass[a4paper,11pt]{article}
\usepackage{tikz}

\begin{document}
\begin{tikzpicture}
%la figure qui ne marche pas
\end{tikzpicture}
\end{document}

Bertrand</content>
</entry>
<entry>
	<title type="html">PGF &amp; Tikz - par Jen le jeudi 11 ao&amp;ucirc;t 2011, 17:09</title> 
	<link href="http://bertrandmasson.free.fr/index.php?article17/pgf-tikz/atom#c1313075347-1"/>
	<id>urn:md5:526094fb12d0d41ef84fa00b3e4100c5</id>
	<updated>2011-08-11T17:09:07+01:00</updated>
	<author><name>Jen</name></author>
	<content type="html">Bonjour, 

J&amp;#039;ai une petite question par rapport aux figures tikz...
J&amp;#039;ai fait un schema blocs en tikz pour une présentation sur beamer... maintenant, je veux bien l&amp;#039;utiliser dans un document (article), si j&amp;#039;utilise la même source code, je me retrouve avec un schéma qui deviens n&amp;#039;importe quoi... les coordonnées sont différentes sur beamer que sur les autres types de document latex? je peux changer les coordonnées manuellement, mais est-ce qu&amp;#039;il existe une façon de le faire automatiquement? (parce que sinon il faut que j’aille une version du schéma pour chaque type de document !???? double colonne, etc. :s …)

Je vous remercie en avance pour votre aide,

Bien cordialement,
Jen 

Ps: désolée pour mon français, n&amp;#039;est pas ma langue maternelle.</content>
</entry>
</feed>