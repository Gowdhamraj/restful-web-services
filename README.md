# restful-web-services
Microservices workshop practice project

A simple webservice client to store and retrieve users and their posts, social media style.
Very basic APIs developed as part of introduction to Spring boot and REST services.
### API Endpoints
User resource:
* GET: http://localhost:8080/api/v2/users/
* GET: http://localhost:8080/api/v2/users/{name}
* POST: http://localhost:8080/api/v2/users/ - json user
* DELETE: http://localhost:8080/api/v2/users/{name}

Post resource:
* GET: http://localhost:8080/api/v2/users/{name}/posts

Swagger Doc:
* http://localhost:8080/swagger-ui/index.html

H2 DB Console:
* http://localhost:8080/h2-console
#
Will develop further if time permits.

Code TODO:
* Refactoring to individual packages
* Better design
* Unit tests

Features TODO:
* support user editing
* support post posting
* support post deleting without deleting user
* support post retrieval using post id