# Multi-Language-UI-Web-Vehicle in React Native

 This app  support English, Arabic, French, German, Spanish  and Italian languages. And use Spring-boot service Backend.

# Prerequisites
This UI requires basic knowledge of React Native. To set up your development machine, follow the official guide [here](http://reactnative.dev/docs/0.59/getting-started).

To make sure we are on the same page, following are the versions used in this tutorial -

Node v10.15.0
npm 6.4.1
yarn 1.16.0
react-native 0.59.9
react-native-localize 1.1.3
i18n-js 3.3.0

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

# Project Structure
`package.json` - Contains all the required dependencies for our React JS project. Most importantly, u can check the current version of React that you are using. It has all the scripts to start, build and eject our React app.


`public folder` - contains index.html. As react is used to build a single page application, we have this single HTML file to render all our components.Basically, it's an html template. It has a div element with id as root and all our components are rendered in this div with index.html as a single page for the complete react app. 



`src folder`- In this folder, we have all the global javascript and CSS files. All the different components that we will be building, sit here.



`index.js` - This is the top renderer of your react app.You can see below line which will actually render the App component(app.js) in the div element whose id is root and as discussed above this element is defined in index.html. Remember, Index.css is the global CSS.

`App.js` - Contains the definition our App component which actually gets rendered in the browser and this is the root component. It returns JSX which is a syntax extension to JavaScript. Actually, I find it very similar to old .jsp files without a $ sign. In JSX, to define an HTML class attribute, we actually use className instead of class. Remember, it follows camel-casing.



`npm run eject` - It ejects and copies all the configurations and scripts in our project to our local system in the folder config and script directory so that you can customize the default configurations.


## Available Scripts

In the project directory, you can run:

### `yarn start`

Runs the app in the development mode.<br />
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br />
You will also see any lint errors in the console.

### `yarn test`

Launches the test runner in the interactive watch mode.<br />
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `yarn build`

Builds the app for production to the `build` folder.<br />
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.<br />
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `yarn eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.



# Service Vehicles API

```shell
# running through the command line

git clone https://github.com/rcherara/building-a-microservice-architecture.git
cd building-a-microservice-architecture/vehicle-service
mvn spring-boot:run

# creates a new vehicle
curl -X POST -H "Content-Type: application/json" -d '{
    "title": "JavaScript",
    "description": "JS developers."
}' http://localhost:8081/api/vehicle

# lists all vehicles 
curl http://localhost:8081/api/vehicles

# updates the first vehicle changing its color and price
curl -X PUT -H "Content-Type: application/json" -d '{
    "id": 1,
    "color": "Red",
    "price": 33000
}' http://localhost:8081/api/vehicle

# tries to update an vehicle without informing the id
curl -X PUT -H "Content-Type: application/json" -d '{
     "color": "Red",
    "price": 33000
}' http://localhost:8081/api/vehicle
```

curl --location --request GET 'http://localhost:8081/api/message?msg=welcome' -H "Accept-Language: en"
curl --location --request GET 'http://localhost:8081/api/message?msg=welcome' -H "Accept-Language: fr"
curl --location --request GET 'http://localhost:8081/api/message?msg=welcome' -H "Accept-Language: ar"

# How to init and run this repos with npm:
```shell
git clone https://github.com/rcherara/vehicle-ui-react.git
cd vehicle-ui-react
npm install
npm run vehicle-ui-react
```

Then use it with production settings :
```shell
npm run release
npm run stage
```

Or in dev :
```shell
npm run dev
```
And finally, launch your favorite browser at https://localhost:3000/


# Production
In production, it is recommended to minify any JavaScript code that is included with your application. Minification can help your website load several times faster, especially as the size of your JavaScript source code grows.

Here's one way to set it up:

Install Node.js
Run npm init -y in your project folder (don't skip this step!)
Run npm install terser
Now, to minify a file called like_button.js, run in the terminal:

npx terser -c -m -o like_button.min.js -- like_button.js
This will produce a file called like_button.min.js with the minified code in the same directory. If you're typing this often, you can create an npm script to give this command a name.


# Internationalisation with i18n

Let’s face it, providing different language support on your web apps is probably a UX best practice and also most certainly increase whatever your conversion metrics are. That’s why your web apps should not be default hardcoded to your native language.


## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: https://facebook.github.io/create-react-app/docs/code-splitting

### Analyzing the Bundle Size

This section has moved here: https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size

### Making a Progressive Web App

This section has moved here: https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app

### Advanced Configuration

This section has moved here: https://facebook.github.io/create-react-app/docs/advanced-configuration

### Deployment

This section has moved here: https://facebook.github.io/create-react-app/docs/deployment

### `yarn build` fails to minify

This section has moved here: https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify


yarn add http-proxy-middleware



npm install --save bootstrap

npm install --save accept-language  npm install --save cookie-parser js-cookie

 $ npm install --save react-native-localize
# --- or ---
$ yarn add react-native-localize


$ npm install --save react-native-localize
# --- or ---
$ yarn add react-native-localize


sudo pip3 install pyicu


npm install react-switch-lang --save