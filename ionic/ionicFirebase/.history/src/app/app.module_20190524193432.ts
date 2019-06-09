import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { AngularFireModule } from '@angular/fire';
import { AngularFireAuthModule } from '@angular/fire/auth';
import { ReactiveFormsModule } from '@angular/forms';


export const firebaseConfig = {
  apiKey: "AIzaSyBeetF0E4lDon-Op9aeOWaeqMQFduAsD9U",
    authDomain: "appexemplo-c963a.firebaseapp.com",
    databaseURL: "https://appexemplo-c963a.firebaseio.com",
    projectId: "appexemplo-c963a",
    storageBucket: "appexemplo-c963a.appspot.com",
    messagingSenderId: "549662839209",
    appId: "1:549662839209:web:89031a8fe070d07c"
};

@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, ReactiveFormsModule,
    AngularFireModule.initializeApp(firebaseConfig),
    AngularFireAuthModule],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
