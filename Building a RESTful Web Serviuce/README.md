# https://spring.io/guides/gs/rest-service

go there once the app is started:
http://localhost:8080/greetings

## You can change the default name value by adding a query:
http://localhost:8080/greetings?name=Tom

Sum up of learned stuff (still need practice but I get it):
- **@RestController** receives an http request from the browser and responds through a method or through an external method call
- **@GetMapping** executes / maps the received **GET** request received at the specified URL: _URL + parameter_, then executes code
- **@RequestParam** listens for a query parameter to have dynamic data, can have a default value if no query string
