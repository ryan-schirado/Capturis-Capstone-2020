import {Component, OnInit} from '@angular/core';
import {ExampleService} from '../services/example.service';

@Component({
  selector: 'example-component',
  templateUrl: './example-child.component.html',
  providers: [ExampleService]
})
export class ExampleChildComponent implements OnInit {
  constructor(private exampleService: ExampleService) {

  }

  ngOnInit() {
    console.log('this component should be deleted after you create your own');

    this.exampleService.getById(1).subscribe(response => {
      console.log(response);
    });
  }
}
