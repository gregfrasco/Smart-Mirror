import { Injectable } from '@angular/core';
import { HomePage } from '../pages/home/home';
import 'rxjs/add/operator/map';

/*
  Generated class for the Time provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular 2 DI.
*/
@Injectable()
export class Time {

  private date:Date = new Date();

  constructor() {
    setInterval(() => {
      this.updateTime();
    },1000);
  }

  getTime() {
    let ampm;
    if (this.date.getHours() > 12) {
      ampm = "PM";
    } else {
      ampm = "AM";
    }
    return this.date.getHours() + ":" + ("0" + this.date.getMinutes()).slice(-2) + " " + ampm;
  }

  getDate() {
    let day = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    let month = ["January", "February", "March","April", "May", "June", "July","August", "September", "October","November", "December"];
    return day[this.date.getDay()] + " " + month[this.date.getMonth()] + " " + this.date.getDate() + this.datePostfeix() + " " + this.date.getFullYear();
  }

  private updateTime() {
    this.date = new Date();
  }

  private datePostfeix() {
    switch(this.date.getDate()) {
      case 1:
        return "st";
      case 2:
        return "nd";
      case 3:
        return "rd";
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
        return "th";
      case 21:
        return "st";
      case 22:
        return "nd";
      case 23:
        return "rd";
      case 31:
        return "st";
    }
  }

}
