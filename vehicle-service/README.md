# Vehicle API

## Dependencies
  - Java Runtime
  - Maven 
    - **MAC** - `brew install maven`
  - Docker Hub ID - _DID_

## Build Locally


```shell
git clone https://github.com/leefaus/person-api
cd person-api
mvn package
docker build -t {DID}/person-api .
cd target
docker run -e JARFILE=person-0.0.1-SNAPSHOT.jar -it {DID}/person-api
docker login --username={DID} --email=youremail@company.com
docker push {DID}/person-api
```


#  Running
To build and start the server simply type

$ mvn clean install
$ mvn spring-boot:run -Dserver.port=8081

# swagger UI

http://localhost:8081/swagger-ui.html#/

# DB 

/h2-console'. Database available at 'jdbc:h2:mem:testdb'


# React UI
You will need Java 8+, Node.js 8+, and Yarn installed

npm run test
npm run dev


# 

You can create, read, update, and delete vehcile with the following HTTPie commands.

http POST :8081/api/vehciles name='Dublin JUG' city=Dublin country=Ireland
http :8081/api/vehcile/1
http PUT :8081/api/vehcile/6 name='Dublin JUG' city=Dublin country=Ireland address=Downtown
http DELETE :8081/api/vehcile/6

# production
In production, it is recommended to minify any JavaScript code that is included with your application. Minification can help your website load several times faster, especially as the size of your JavaScript source code grows.

Here's one way to set it up:

Install Node.js
Run npm init -y in your project folder (don't skip this step!)
Run npm install terser
Now, to minify a file called like_button.js, run in the terminal:

npx terser -c -m -o like_button.min.js -- like_button.js
This will produce a file called like_button.min.js with the minified code in the same directory. If you're typing this often, you can create an npm script to give this command a name.