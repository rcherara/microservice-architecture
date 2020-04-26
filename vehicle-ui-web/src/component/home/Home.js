import React, { Component } from "react";
import "../../css/App.css";
import AppNavbar from "../containers/AppNavbar";
import Footer from "../containers/Footer";
import { Link } from "react-router-dom";
import { Button, Container, Label } from "reactstrap";
import i18n from "../../config/i18n";
import { strings } from "../../config/i18n";
import { FaHighlighter, FaFlag, FaGlobeAfrica, FaArrowCircleRight } from 'react-icons/fa';
import ApiServiceVehicle from "../../service/ApiServiceVehicle";
class Home extends Component {
  state = { languages: [],timeFromBackend:'' };

  componentDidMount() {
    setInterval(this.backendTime, 1000);
    setInterval(this.VehicleCount, 1000);
    setInterval(this.MessageFromServer, 1000);
    document.title = i18n.t("home.welcome");
    

  }

  backendTime = () => {
    fetch("/api/time",{
      method: 'GET', // *GET, POST, PUT, DELETE, etc.
      headers: {'Accept-Language': '{i18n.locale }'}
    })
      .then(response => response.text())     
      .catch(reason => console.log('Call /api/time backend has been rejected!'))
      .then(backendTime => {
        this.setState({ backendTime: backendTime });
        
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
        'Accept-Language': '{this.i18n.locale }',    
      }
    })
      .then(response => response.text())
      .then(MessageFromServer => {
        this.setState({ MessageFromServer: MessageFromServer });
      });
  };
  
  render() {
    
    return (
      <div>
        <AppNavbar />
        <Container fluid>
          <Button color="link">
            <Link to="/list-vehicles"><FaHighlighter /> {strings('home.manage','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button  color="link">
            <Link  to="/list-vehicles"><FaHighlighter /> {strings('home.listVehicles','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-languages"><FaGlobeAfrica /> {strings('home.listLanguages','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Button color="link">
            <Link to="/list-countries"><FaFlag /> {strings('home.listCountries','')}</Link>
          </Button>
        </Container>
        <Container fluid>
          <Label>
          <FaHighlighter /> International  message from backend API Server  : {this.state.MessageFromServer} 
            <br></br>  <FaHighlighter /> International Language from (i18n.locale)  : {i18n.locale } 
          </Label>
          <br></br>
          <FaHighlighter /> {strings('home.manage','')}  <FaHighlighter /> {strings('home.manage','fr')} <br></br>
        
          <i class="fas fa-thumbs-up"></i> <Label>{strings('home.manage','')}</Label>
          <br></br>      
          
            <FaArrowCircleRight /> {i18n.t("home.count", {countVehicles: this.state.VehicleCount})}
            <br></br> 
            <FaArrowCircleRight />  <Label class="fas fa-bars">1. Time from API Vehicle backend Server : {this.state.backendTime}</Label>
         </Container>
        
        <Footer />
      </div>
    );
  }
}

export default Home;
