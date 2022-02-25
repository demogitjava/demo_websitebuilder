
Demo Websitebuilder with Spring Boot + Theamleaf + Grapesjs

<br/>
<br/>
<br/>

The used database is H2 from here
http://www.h2database.com/html/download.html
<br/>

the application port is
https://localhost/webbuilder
you can edit the port in the application.properties 
server.port=80

The first module is the project
landingpage for docker over port 80

<br/>
<br/>

used ide
https://netbeans.apache.org/
<br/>


To compile this application install maven.
maven https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip

make sure that java is correctly installed and the "JAVA_HOME" path is set.
<br/>

You can get the java jdk from here:
used jdk: **GraalVM Community ** https://www.graalvm.org/downloads/

<br/>


For Docker

To build the image type:

docker build -f Dockerfile -t demowebsitebuilder .

and you create a docker image with CentOS runs in a container over port 8442.

Run the application and open ports by create a new container

8443

9092

5005 (optional for debug)

docker for windows are available on https://www.docker.com/products/docker-desktop

for config on an docker image make a backup with

docker save -o demowebsitebuilder.tar jgsoftwares/jgsoftwares

to load your image to docker desktop type: docker load --input demowebsitebuilder.tar

<br/>



<p align="center"><img src="http://grapesjs.com/img/grapesjs-front-page-m.jpg" alt="GrapesJS" width="500" align="center"/></p>


GrapesJS is a free and open source Web Builder Framework which helps building HTML templates, faster and easily, to be delivered in sites, newsletters or mobile apps. Mainly, GrapesJS was designed to be used inside a [CMS] to speed up the creation of dynamic templates. To better understand this concept check the image below

<br/>
<p align="center"><img src="http://grapesjs.com/img/gjs-concept.png" alt="GrapesJS - Style Manager" height="400" align="center"/></p>
<br/>

Generally any 'template system', that you'd find in various applications like CMS, is composed by the **structure** (HTML), **style** (CSS) and **variables**, which are then replaced with other templates and contents on server-side and rendered on client.

This demos show examples of what is possible to achieve:
Webpage Demo - http://grapesjs.com/demo.html
Newsletter Demo - http://grapesjs.com/demo-newsletter-editor.html
