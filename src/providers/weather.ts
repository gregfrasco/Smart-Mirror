import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Env } from './env';

@Injectable()
export class Weather {

  private weather;

  constructor(public http: Http,
    private env:Env) {
    setInterval(() => {
      this.updateWeather();
    },90000)
  }

  init(){
    this.updateWeather();
  }

  private updateWeather() {
    this.http.get('https://api.darksky.net/forecast/'+this.env.env.FORCAST_API_KEY+"/"+this.env.env.FORCAST_LATLNG).map(res => res.json()).subscribe(
      (weather) => {
      this.weather = weather;
      console.log(this.weather);
    });
  }

  getTemp(){
    if(this.weather){
      return Math.floor(this.weather.currently.temperature) + "°F";
    }
  }

  getCurrently() {
    if(this.weather){
      return this.weather.currently.summary;
    }
  }

  today() {
    if(this.weather){
      return this.weather.hourly.summary;
    }
  }

  todayIcon() {
    if(this.weather){
      return this.weatherIcon(this.weather.hourly.icon);
    }
  }

  chanceOfRain() {
    let max = 0;
    if(this.weather){
      for(let i = 0; i < 12; i++) {
        if(this.weather.hourly.data[i].precipProbability > max) {
          max = this.weather.hourly.data[i].precipProbability;
        }
      }
      return max * 100 + "%";
    }
  }
  getIcon(){
    if(this.weather){
      return this.weatherIcon(this.weather.currently.icon);
    }
  }

  private weatherIcon(icon){
    switch(icon) {
      case "clear-day":
        return "assets/images/weather/weatherclear.png";
      case "clear-night":
        return "assets/images/weather/weatherclearnight.png";
      case "rain":
        return "assets/images/weather/weatherdrizzleday.png";
      case "snow":
        return "assets/images/weather/weatherbigsnow.png";
      case "sleet":
        return "assets/images/weather/weathersnowrain.png";
      case "wind":
        return "assets/images/weather/weatherwind.png";
      case "fog":
        return "assets/images/weather/weatherhaze.png";
      case "cloudy":
        return "assets/images/weather/weathercloudsnight.png";
      case "partly-cloudy-day":
        return "assets/images/weather/weatherclouds.png";
      case "partly-cloudy-night":
        return "assets/images/weather/weatherfewcloudsnight.png";
    }
  }

}
