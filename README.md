Tweeter-like REST Project

This is a school project which intends to show the use of Jersey and JavaEE servlets.
It contains two different java web project :

- rest which is a REST service made with spring and jersey

- wapp which is a web application meant to communicate with rest, retrieve tweets from tweeter and display the results in web client.


Both project use Gradle 2.1 to handle dependencies.

rest is a spring-jersey project with hibernate as ORM.
To start it correctly you have to copy the file rest.properties (rest/src/main/config) at whatever location you want,
and give this location to the JVM when started it in user.dir variable : -Duser.dir=/location_of_the_file/rest.properties.
You will have of course to fill this file with your database informations.


wapp is a spring-mvc project with a web.xml servlet configuration.
Sitemesh is used to share the web-theme between pages (bootstrap responsive theme).
To start it correctly you have to copy the file wapp.properties (rest/src/main/config) at whatever location you want,
and give this location to the JVM when started it in user.dir variable : -Duser.dir=/location_of_the_file/rest.properties.
You will have of course to fill this file with your tweeter developper account informations.
You will have to fill rest project deployment informations too.

For exemple when I deploy the rest application on the root application context "/" I have to fill it like this :

- rest.authors=/rest/authors

- rest.tweets=/rest/tweets

- rest.tweets.authors=/rest/tweets/author/

- rest.tweets.update=/rest/tweets/update

- rest.protocol=http

- rest.hostname=localhost

- rest.port=8080
