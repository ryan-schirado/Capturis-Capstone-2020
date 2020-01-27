import {environment} from '../../../environments/environment';
import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const path = environment.api + 'example';

@Injectable()
export class ExampleService {
    constructor(private http: HttpClient) {
    }

    getById(id) {
        const headers = {
            headers: new HttpHeaders({'Content-Type': 'application/json; charset=utf-8'})
        };
        return this.http.get<any>(path + '/' + id, headers);
    }
}
