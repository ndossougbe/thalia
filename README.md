thalia
======

Media manager, allows you to manage your library and easily display it on your network.

In development, using:

* [Dropwizard](https://www.dropwizard.io) - Java REST stack
* JavaFX - Desktop UI APIs
* [AngularJS](https://www.angularjs.org) - JS application framework
* [ng-boilerplate](https://github.com/ngbp/ngbp) - starter and build configuration for angular projects


## Contributing

- Commit guidelines (from [AngularJS](https://docs.google.com/document/d/1QrDFcIiPjSLDn3EL15IJygNPiHORgU1_OOAqWjiDU5Y/edit#))
- Prerequisites:
  -  [Gradle](https://www.gradle.org) (or an IDE like IntelliJ IDEA that will download gradle and use it to build)
  -  [npm](http://nodejs.org/), [bower](http://bower.io/)
  -  [Oracle JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Open JDK isn't bundled with the Java FX jars yet. Using Oracle's is probably the easiest workaround)
- To build:
  - run `gradlew shadowJar` to build the Java projects
  - run `npm install && bower install && grunt build` to download the JS dependencies and build the app
  - start the project by going to `thalia/server` and running `./thalia.sh`
