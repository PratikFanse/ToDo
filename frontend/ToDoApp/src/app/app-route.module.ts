import { Routes, RouterModule } from '@angular/router';

import { NgModule } from '@angular/core';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { ToDoListComponent } from './to-do-list/to-do-list.component';
import { AuthComponent } from './auth/auth.component';
import { LogErrorComponent } from './auth/login/log-error/log-error.component';
import { NavComponent } from './nav/nav.component';
import { AdminComponent } from './admin/admin.component';
import { GraphComponent } from './admin/graph/graph.component';

const appRoutes: Routes =[
    {path:"", redirectTo:'/app', pathMatch:'full'},
    {path:"app", component:NavComponent,children:[
        {path:"",component: ToDoListComponent},
        // {path:"/ToDo",component: ToDoListComponent},
        {path:"admin",component: AdminComponent},
        {path:"usersList",component: AdminComponent},
        {path:"usersActivity",component: GraphComponent}]},
    {path:"logError",component: LogErrorComponent, },
    {path:"authentication",component: AuthComponent, children:[
        {path:"signup",component: SignupComponent},
        {path:"",component: LoginComponent}]}
    
    // {path:"ToDo",component: ToDoListComponent},
]

@NgModule({
    imports:[RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}