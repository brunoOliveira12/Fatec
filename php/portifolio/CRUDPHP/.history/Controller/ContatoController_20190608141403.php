<?php
// Inclui o arquivo class.phpmailer.php localizado na mesma pasta do arquivo php
include "View/PHPMailerAutoload.php";

if (isset($_POST['contato'])) {

    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $mensagem = $_POST['mensagem'];
}
// Inicia a classe PHPMailer
$mail = new PHPMailer();
 
// Método de envio
$mail->IsSMTP(); // Enviar por SMTP 
$mail->Host = "mail.meusitemodelo.com"; // Você pode alterar este parametro para o endereço de SMTP do seu provedor
$mail->Port = 25; 
 
$mail->SMTPAuth = true; // Usar autenticação SMTP (obrigatório)
$mail->Username = 'francisco@meusitemodelo.com'; // Usuário do servidor SMTP (endereço de email)
$mail->Password = 'senha-do-email'; // Mesma senha da sua conta de email
 
// Configurações de compatibilidade para autenticação em TLS
$mail->SMTPOptions = array(
 'ssl' => array(
 'verify_peer' => false,
 'verify_peer_name' => false,
 'allow_self_signed' => true
 )
);
// $mail->SMTPDebug = 2; // Você pode habilitar esta opção caso tenha problemas. Assim pode identificar mensagens de erro.
 
// Define o remetente
$mail->From = "francisco@meusitemodelo.com"; // Seu e-mail
$mail->FromName = "Francisco"; // Seu nome
 
// Define o(s) destinatário(s)
$mail->AddAddress('maria@gmail.com', 'Maria');
//$mail->AddAddress('fernando@email.com');
 
// Definir se o e-mail é em formato HTML ou texto plano
$mail->IsHTML(true); // Formato HTML . Use "false" para enviar em formato texto simples.
 
$mail->CharSet = 'UTF-8'; // Charset (opcional)
 
// Assunto da mensagem
$mail->Subject = "Assunto da mensagem"; 
 
// Corpo do email
$mail->Body = 'Corpo do email em html.<br><br><font color=blue>Teste de cores</font><br><br><img src="http://meusitemodelo.com/imagem.jpg">';
 
// Envia o e-mail
$enviado = $mail->Send();
 
// Exibe uma mensagem de resultado
if ($enviado) {
     echo "Seu email foi enviado com sucesso!";
} else {
     echo "Houve um erro enviando o email: ".$mail->ErrorInfo;
}
 
?>