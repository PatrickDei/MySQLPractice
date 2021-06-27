import { Component, OnInit } from '@angular/core';
import {LoginService} from './service/login.service';
import {Credentials} from './credentials.model';
import {UserService} from '../user/user.service';
import {JwtToken} from './jwt-token.model';
import {User} from '../user/user.model';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userCredentials: Credentials;

  authenticating: boolean;
  failedLogin: boolean;

  form: FormGroup;

  constructor(
    private loginService: LoginService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.userCredentials = new Credentials();
    this.form = new FormGroup({
      username: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    });
  }

  login(){
    if(this.form.valid) {
      this.authenticating = true;
      this.failedLogin = false;

      this.userCredentials.username = this.form.get('username').value;
      this.userCredentials.password = this.form.get('password').value;

      console.log(this.userCredentials);

      this.loginService.authenticate(this.userCredentials).subscribe(
        (token: JwtToken) => this.onLoginSuccess(token),
        () => this.failedLogin = true
      );
    }
  }

  onLoginSuccess(jwtToken: JwtToken): void{
    localStorage.setItem('token', jwtToken.token);
    this.authenticating = false;
    this.userService.getCurrentUser().subscribe((currentUser: User) => this.userService.currentUser = currentUser);
    this.router.navigate(['/']);
  }
}
