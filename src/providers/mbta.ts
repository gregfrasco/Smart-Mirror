import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Env } from './env';

@Injectable()
export class MBTA {

  private mbtaData = [];

  constructor(public http: Http,
    private env:Env) {
      setInterval(() => {
        this.updateTime(false);
      },40000);
  }

  init(){
    this.updateTime(true);
  }

  tickDown(){
    for(let stop in this.mbtaData){
      if(this.mbtaData[stop]){
        if(this.mbtaData['time']){
          for(let i = 0; i < this.mbtaData[stop]['time'].length; i++){
            this.mbtaData[stop]['time'][i] -= 3;
          }
        }
      }
    }
  }

  updateTime(init){
    for(let stop of this.env.env.MBTA_STATIONS) {
      this.http.get('http://realtime.mbta.com/developer/api/v2/predictionsbystop?api_key=' + this.env.env.MBTA_KEY + '&stop=' + stop.stopid + '&format=json').map(res => res.json()).subscribe(
        (mbta) => {
          let data = {};
          data['alerts'] = [];
          data['time'] = [];
          for(let alert of mbta.alert_headers) {
            if(alert.effect_name == "Delay"){
              data['alerts'].push(alert);
            }
          }
          if(mbta.mode) {
            for(let route of mbta.mode[0].route) {
              if(route.direction[0]) {
                if(route.direction[0].trip) {
                  let length = 3;
                  if(route.direction[0].trip.length < 3) {
                    length = route.direction[0].trip.length;
                  }
                  for(let i = 0; i < length; i++) {
                    if(!(stop.direction == "Lechmere" && route.route_id =="Green-C")) {
                      data['time'].push(route.direction[0].trip[i].pre_away);
                    } else {
                      this.mbtaData['Cleveland Circle']['time'].push(parseInt(route.direction[0].trip[i].pre_away));
                      this.mbtaData['Cleveland Circle']['time'] = this.mbtaData['Cleveland Circle']['time'].sort(this.sortNumber);
                    }
                  }
                  data['time'] = data['time'].map(Number).sort(this.sortNumber);
                }
              }
            }
          }
          this.mbtaData[stop.direction] = data;
        }
      );
    }
    if(init){
      setInterval(() => {
        this.tickDown();
      },3000);
    }
  }

  sortNumber(a,b) {
    return a - b;
  }

  getMBTAData() {
    return this.mbtaData;
  }

  getTimes(stop){
    let message = "";
    if(this.mbtaData[stop]) {
      let times = this.mbtaData[stop]['time'];
      if(times) {
        for(let time of times) {
          if(time < 60) {
          } else{
            message += Math.ceil(time/60) + " min, ";
          }
        }
      }
    }
    return message.substring(0, message.length-2);
  }

}
