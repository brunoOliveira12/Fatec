import { Component, ViewChild } from '@angular/core';
import { NavController, ToastController } from '@ionic/angular';
import { AngularFireAuth } from '@angular/fire/auth';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  public user: any;
  @ViewChild('usuario') email;
  @ViewChild('senha') password;
constructor(public navCtrl: NavController,
              public toastCtrl: ToastController,
              public firebaseauth: AngularFireAuth,
              public alertCtrl: AlertController) {
      firebaseauth.user.subscribe((data => {
        this.user = data;
      }));     
  }

public LoginComEmail(): void {
    this.firebaseauth.auth.signInWithEmailAndPassword(this.email.value , this.password.value)
      .then(() => {
        this.exibirMensagem("Logado com sucesso");
       })
        .catch((erro: any) => {
          this.exibirMensagem("Não há registro de usuário correspondente a esse identificador");
      });
  }

  async exibirMensagem(mensagem) {
    const toast = await this.toastCtrl.create({
      message: mensagem, duration: 2000
    });
    toast.present();
  }
  
public cadastrarUsuario(): void {
    this.firebaseauth.auth.createUserWithEmailAndPassword(this.email.value , this.password.value)
    .then(() => {
      this.exibirMensagem("Usuário criado com sucesso");
    })
    .catch((erro: any) => {
      this.exibirMensagem(erro)
    });
  }

public alterarEmail(): void {
    var user = this.firebaseauth.auth.currentUser;
    user.updateEmail(this.email.value).then(function() {
      this.exibirMensagem("Usuário alterado com sucesso")
    }).catch(function(error) {
      this.exibirMensagem(error)
    });
}

public excluirUsuario(): void {
  var user = this.firebaseauth.auth.currentUser;
    user.delete().then(function() {
      this.exibirMensagem("Usuário excluido com sucesso")      
    }).catch(function(error) {
      this.exibirMensagem(error)
    });
}

public Sair(): void {
    this.firebaseauth.auth.signOut()
    .then(() => {
      this.exibirMensagem("Saiu com sucesso");  
    })
    .catch((erro: any) => {
      this.exibirMensagem(erro)
    });
  }
}