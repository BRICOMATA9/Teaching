<?php
  session_start();
  session_unset();
  session_destroy();
  header('Location: http://127.0.0.1/ProjetPiscineWeb/menu_principal.php');
  exit();
?>