import { Component } from '@angular/core';
import { Time } from '../../providers/time';
import { Weather } from '../../providers/weather';
import { MBTA } from '../../providers/mbta';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(
    public time:Time,
    public weather:Weather,
    public mbta:MBTA
    ) {

  }

}
