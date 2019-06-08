<?php
// On démarre la session (ceci est indispensable dans toutes les pages de notre section membre)

include("Inscription.php");


    // On teste pour voir si nos variables ont bien été enregistrées
    echo '<html>';
    echo '<head>';
    echo '<title>Page de notre section membre</title>';
    echo '</head>';

    echo '<body>';
    echo 'Votre login est '.$_SESSION['Nom'].'.';
   
?>