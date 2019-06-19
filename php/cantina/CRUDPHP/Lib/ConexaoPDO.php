<?php

//PHP -> php.ini -> habilitar php_pdo_mysql ou banco desejado


try {
    
    //$con = new PDO('pgsql:host=localhost;dbname=crud', 'postgress', '123456');
    //$con = new PDO('mysql:host=localhost;dbname=crud', 'root', '');
    $con = new PDO(DB_DRIVER .':host=' . DB_HOST . ';dbname=' . DB_NAME,DB_USER,DB_PASSWORD);
    
    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    
    $select = $con->query("select * from pessoa");        
    
    
    while ($dados = $select->fetch(PDO::FETCH_ASSOC)) {
        
        echo "<p>{$dados['id']} | {$dados['nome']} | {$dados['email']}</p>";
        
    }
    
    
} catch (Exception $exc) {
    echo $exc->getTraceAsString();
}
