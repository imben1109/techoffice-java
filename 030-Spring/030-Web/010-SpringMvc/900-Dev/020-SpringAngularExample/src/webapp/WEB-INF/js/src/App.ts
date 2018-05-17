import 'core-js/es6';
import 'core-js/es7/reflect';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import AppModule from './AppModule';
require('zone.js/dist/zone');

if (process.env.ENV === 'production') {

} else {
    Error['stackTraceLimit'] = Infinity;
    require('zone.js/dist/long-stack-trace-zone');
}
  
platformBrowserDynamic().bootstrapModule(AppModule);