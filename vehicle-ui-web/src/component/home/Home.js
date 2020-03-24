import React, { Component } from "react";
import "../../App.css";
import AppNavbar from "../shared/AppNavbar";
import { Link } from "react-router-dom";
import { Button, Container, Label } from "reactstrap";
//import { FormattedMessage } from "react-intl"; // IntlProvider
import i18n from "../../i18n";
import PropTypes from 'prop-types';

//import LocaleButton from '../shared/LocaleButton';
// Translation Higher Order Component
import {
  setTranslations,
  setDefaultLanguage,
  setLanguageCookie,
  setLanguage,
  translate,
} from 'react-switch-lang';
import en from "../../locales/en";
import ar from "../../locales/ar";
 
// Do this two lines only when setting up the application
setTranslations({ en, ar });
setDefaultLanguage('ar');



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
   // const ltag = i18n.locale;
    this.setState({ MessageFromServer: "new value" });
    document.title = i18n.t("home.welcome");
    fetch('/api/message?msg=welcome')
      .then(res => res.json())
      .then((MessageFromServer) => {
        this.setState({ MessageFromServer: MessageFromServer })
        console.log("Message from server with componentDidMount ", this.state.MessageFromServer)
      })
      .catch(console.log)
  }
  hello = () => {
    fetch("/api/time")
      .then(response => response.text())     
      .catch(reason => console.log('Promise has been rejected!'))
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
    fetch("/api/message?msg=welcome")
      .then(response => response.text())
      .then(MessageFromServer => {
        this.setState({ MessageFromServer: MessageFromServer });
      });
  };
  
  render() {
    const aaa = this.state.MessageFromServer; 
    const { t } = this.props;   
    const languageName = {
      en: "English",
      fr: "Français",
      ar: "عربي",
      de: "Deutsch",
    }
   
     console.log(" Tag LG   ", this.state.ltag);
    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <Button color="link">
            <Link to="/vehicles">{i18n.t("home.manage")}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-vehicles">{i18n.t("home.list")} </Link>
          </Button>
        </Container>
        <Container fluid>
          <Label>
            AAAA {this.state.MessageFromServer} BBBB {this.aaa} CCC {this.ltag} DDD {i18n.locale } 
          </Label>
          <br></br>
         1- {t('home.manage')}<br></br>
         2-  {t('home.manage', null, 'fr')}<br></br>
         3-  {t('hello', { name: 'World' })}<br></br>
         4-  {t('fallback')}<br></br>
          <br></br>
        <button type="button" onClick={this.handleSetLanguage('fr')}>
          Switch language to ARABIC
        </button>
          <br></br>
          <h1>
            {i18n.t("home.count", {
              countVehicles: this.state.VehicleCount
            })}
          </h1>
          <Label>From Vehicle Api Server : {this.state.message}</Label>
        </Container>
      </div>
    );
  }
}
//export default Home;

Home.propTypes = {
  t: PropTypes.func.isRequired,
};
 
export default translate(Home);