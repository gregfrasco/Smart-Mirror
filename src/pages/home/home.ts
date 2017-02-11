import { Component } from '@angular/core';
import { Time } from '../../providers/time';
import { Weather } from '../../providers/weather';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(
    public time:Time,
    public weather:Weather
    ) {

  }

}
