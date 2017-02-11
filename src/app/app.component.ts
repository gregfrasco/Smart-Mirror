import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { StatusBar, Splashscreen } from 'ionic-native';
import { Http } from '@angular/http';
import { HomePage } from '../pages/home/home';
import { Env } from '../providers/env';
import { Weather } from '../providers/weather';
import { MBTA } from '../providers/mbta';


@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage = HomePage;

  constructor(platform: Platform,
    http:Http,
    env:Env,
    weather:Weather,
    mbta:MBTA) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      StatusBar.styleDefault();
      Splashscreen.hide();
      http.get('assets/environment.json').map(res => res.json()).subscribe(
        response => {
        env.env = response;
        weather.init();
        mbta.init();
      });

    });
  }
}
