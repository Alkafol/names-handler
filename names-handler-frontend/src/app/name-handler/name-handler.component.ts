import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-name-handler',
  templateUrl: './name-handler.component.html',
  styleUrls: ['./name-handler.component.css']
})
export class NameHandlerComponent {
  name = '';
  lastInputName = '';
  age = '';
  hasClickedButton = false;

  constructor(private http: HttpClient) { }

  getAge() {
    this.http.get<any>('http://localhost:8080/get_age/' + this.name)
      .subscribe(data => {
        this.age = data.age;
        this.lastInputName = this.name;
        this.hasClickedButton = true;
      });
  }
}
