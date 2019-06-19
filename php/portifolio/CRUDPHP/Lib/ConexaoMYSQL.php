<?php

$con = mysqli_connect('localhost', 'root', '', '$crud');

$select = mysqli_query($con, 'select * from pessoa');


//fazendo select para buscar todos os dados e mostrar forma de matriz
while ($dados = mysql_fetch_assoc($select)) {   
echo "<p>{$dados['id']} | {$dados['nome']} | {$dados['email']}</p>";    
}
