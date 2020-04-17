import React, { Component } from "react";
import "../../css/App.css";
import AppNavbar from "../containers/AppNavbar";
import Footer from "../containers/Footer";
import { Link } from "react-router-dom";
import { Button, Container, Label } from "reactstrap";
import i18n from "../../config/i18n";
import PropTypes from 'prop-types';
import { setTranslations, setDefaultLanguage, setLanguageCookie, setLanguage, translate,} from 'react-switch-lang';
import en from "../../locales/en";
import ar from "../../locales/ar";
import { strings } from "../../config/i18n";
 
// Do this two lines only when setting up the application
setTranslations({ en, ar});
setDefaultLanguage(i18n.locale);
setLanguage(i18n.locale);
// If you want to remember selected language
setLanguageCookie();
class Home extends Component {
  state = { languages: [] };
  handleSetLanguage = (key) => () => {
    setLanguage(key);
  };
  componentDidMount() {
    setInterval(this.hello, 1000);
    setInterval(this.VehicleCount, 1000);
    setInterval(this.MessageFromServer, 1000);
    document.title = i18n.t("home.welcome");

  }

  hello = () => {
    fetch("/api/time",{
      method: 'GET', // *GET, POST, PUT, DELETE, etc.
      headers: {'Accept-Language': 'ar'}
    })
      .then(response => response.text())     
      .catch(reason => console.log('Call /api/time backend has been rejected!'))
      .then(message => {
        this.setState({ message: message });
        
      })
      .then(response => console.log(`The Vehicle API answer has been fulfilled ${response}`));
  };
  VehicleCount = () => {
    fetch("/api/vehicles/count")
      .then(response => response.text())
      .then(VehicleCount => {
        this.setState({ VehicleCount: VehicleCount });
      });
  };
  MessageFromServer = () => {
    fetch("/api/message?msg=welcome",{
      method: 'GET', // or 'PUT'
      headers: {
        'Accept-Language': '{i18n.locale }',    
      }
    })
      .then(response => response.text())
      .then(MessageFromServer => {
        this.setState({ MessageFromServer: MessageFromServer });
      });
  };
  
  render() {
    const aaa = this.state.MessageFromServer; 
    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <Button color="link">
            <Link to="/list-vehicles"> {strings('home.manage','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-vehicles">{strings('home.listVehicles','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-languages">{strings('home.listLanguages','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-countries">{strings('home.listCountries','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Label>
            -----
            <br></br> === MessageFromServer : {this.state.MessageFromServer} 
            <br></br> aaaa: {this.aaa} 
            <br></br> hello : {this.state.hello} 
            <br></br> i18n.locale  : {i18n.locale } 
          </Label>
          <br></br>
            1- {strings('home.manage','')} <br></br>
            2- {strings('home.manage','en')} <br></br>
            3-  {strings('home.count',{ countVehicles: '123' })} <br></br>
            4-    aaa = {aaa}    <br></br>
            5-  <Label>{strings('home.manage','')}</Label>
          <br></br>      
          <br></br>
          <h1>
            {i18n.t("home.count", {countVehicles: this.state.VehicleCount})}
          </h1>
          <Label>From Vehicle Api Server : {this.state.message}</Label>
        </Container>
        <Footer />
      </div>
    );
  }
}
//export default Home;

Home.propTypes = {
  t: PropTypes.func.isRequired,
};
 
export default translate(Home);