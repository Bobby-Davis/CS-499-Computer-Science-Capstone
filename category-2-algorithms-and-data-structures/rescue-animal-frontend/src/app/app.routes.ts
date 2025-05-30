import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ServicesComponent } from './services/services.component';
import { AboutComponent } from './about/about.component';
import { RescueAnimalsComponent } from './rescue-animals/rescue-animals.component';
import { LoginComponent} from './login/login.component';
import { EditAnimalComponent } from './edit-animal/edit-animal.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'services', component: ServicesComponent },
  { path: 'about', component: AboutComponent },
  { path: 'rescue-animals', component: RescueAnimalsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'edit-animal/:id', component: EditAnimalComponent },
  { path: 'add-animal', component: EditAnimalComponent}
  // Add other routes as needed
];
