<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Conexao
 *
 * @author Lab
 */
require_once 'Config.php';

class Conexao {

    private static $con;

    public static function conectar() {

        if (!isset(self::$con)) {

            try {
                self::$con = new PDO(DB_DRIVER . ':host=' . DB_HOST . ';port=' . DB_PORT . ';dbname=' . DB_NAME, DB_USER, DB_PASS);
                self::$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                self::$con->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
            } catch (Exception $e) {
                echo $e->getMessage();
            }
        }
        return self::$con;
    }

    public static function prepare($sql) {
        return self::conectar()->prepare($sql);
    }

}
