<?php
$database = "projet_web";
$db_handle = mysqli_connect('localhost', 'root', '');
$db_found = mysqli_select_db($db_handle, $database);
if(mysqli_connect_error()){
	echo 'Database connection failed with the following errors : '
.mysqli_connect_error();
die();
}
?>