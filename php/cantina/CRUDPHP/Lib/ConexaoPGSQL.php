<?php

$con = pg_connect("host=localhost dbname=crudphp user=postgres password=bancosql");

$select = pg_query($con, 'select * from pessoa');


//fazendo select para buscar todos os dados e mostrar forma de matriz
while ($dados = pg_fetch_assoc($select)) {   
echo "<p>{$dados['id']} | {$dados['nome']} | {$dados['email']}</p>";    
}
