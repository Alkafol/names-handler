import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent {
  showFreq = false;
  showMaxAge = false;
  frequencyData: Map<string, number> = new Map();
  maxAgeData: Map<string, number> = new Map();

  constructor(private http: HttpClient) {}

  getFrequencyData() {
    this.http
      .get<Map<string, number>>('http://localhost:8080/get_frequency')
      .pipe(map((data: Map<string, number>) => (this.frequencyData = data)))
      .subscribe(() => (this.showFreq = true));
  }

  getMaxAgeData() {
    this.http
      .get<Map<string, number>>('http://localhost:8080/get_max_age')
      .pipe(map((data: Map<string, number>) => (this.maxAgeData = data)))
      .subscribe(() => (this.showMaxAge = true));
  }
}
