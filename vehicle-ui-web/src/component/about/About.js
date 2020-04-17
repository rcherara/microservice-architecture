import React, { Component } from 'react';
import AppNavbar from '../containers/AppNavbar';
import Footer from "../containers/Footer";
import i18n from '../../config/i18n';
import {  Container, Spinner, Progress } from "reactstrap";
class About extends Component {
    state = {};
 
  componentDidMount() {
      setInterval(this.hello, 250);
      document.title = i18n.t("navigation.about");
  }

  hello = () => {
      fetch('/api/message?msg=welcome')
          .then(response => response.text())
          .then(message => {
              this.setState({message: message});
          });
  };
  render() {
    return (     
      <div>     
        <AppNavbar/>

        <Container fluid>         
          <div>
            
            <h1 className="App-title">{i18n.t('navigation.about')} {i18n.t('appName')}</h1>
            <Spinner color="warning" />
            <Spinner color="info" />
            <Spinner color="light" />
            <Spinner color="dark" />
            <Spinner color="primary" />
            <Spinner color="secondary" />
            <Spinner color="success" />
            <Spinner color="danger" />
          </div>
          <Progress color="danger" value="100" />
          <br></br> <br></br>                          
           <h1 className="App-title"><br></br>  {this.state.message}</h1>
          <br></br> <br></br><br></br><br></br><br></br><br></br><br></br><br></br>
         
          <p class="m-0 text-center text-white">
          </p>
          <div>
            <Progress value={2 * 5} />
            <Progress color="success" value="25" />
            <Progress color="info" value={50} />
            <Progress color="warning" value={75} />
            <Progress color="danger" value="100" />
          </div>
        </Container>
        <Footer />
      </div>
    );
  }
}

export default About;