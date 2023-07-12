import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PipeComponent } from './components/pipe/pipe.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CustomPipesPipe } from './components/custom-pipes.pipe';

@NgModule({
  declarations: [AppComponent, PipeComponent, CustomPipesPipe],
  imports: [BrowserModule, NgbModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
