import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ToDoListComponent } from './to-do-list/to-do-list.component';
import { HttpInterceptorService } from './shared/http-interceptor.service';
import { NavComponent } from './nav/nav.component';
import { AppRoutingModule } from './app-route.module';
import { LogErrorComponent } from './auth/login/log-error/log-error.component';
import { AdminComponent } from './admin/admin.component';
import { GraphComponent } from './admin/graph/graph.component';
import { GoogleChartsModule } from 'angular-google-charts';
// import { AdminLoginComponent } from './shared/admin-login/admin-login.component';
// import { AdminUsersListComponent } from './admin/admin-users-list/admin-users-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    LoginComponent,
    SignupComponent,
    ToDoListComponent,
    NavComponent,
    LogErrorComponent,
    AdminComponent,
    GraphComponent,
    // AdminLoginComponent,
    // AdminUsersListComponent
  ],
  imports: [
    BrowserModule, FormsModule,
    ReactiveFormsModule,HttpClientModule,
    AppRoutingModule,
    GoogleChartsModule.forRoot(),
  ],
  providers: [
    { provide:HTTP_INTERCEPTORS, useClass:HttpInterceptorService, multi:true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
