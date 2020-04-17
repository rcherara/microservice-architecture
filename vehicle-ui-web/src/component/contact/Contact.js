import React, { Component } from 'react';
import AppNavbar from '../containers/AppNavbar';
import Footer from "../containers/Footer";
import FadeGithub from "../containers/FadeGithub";
import FadeBlogs from "../containers/FadeBlogs";
import { Button, Container, Spinner, Progress } from "reactstrap";
import i18n from '../../config/i18n';

class Contact extends Component {
  state = {};

  componentDidMount() {
    setInterval(this.hello, 250);
    document.title = i18n.t("navigation.contact");
  };
  hello = () => {
    fetch('/api/contact')
      .then(response => response.text())
      .then(message => {
        this.setState({ message: message });
      });
  };
  render() {
    return (
      <div>
        <AppNavbar />
        <Container fluid>
          
          <div>
            <Spinner color="primary" />
            
            <Spinner color="success" />
           
            <Spinner color="warning" />
            <Spinner color="info" /><h1 className="App-title">CHERARA REDDAH</h1>
            <Spinner color="secondary" />
            <Spinner color="danger" />
            <Spinner color="dark" />
            <Spinner color="light" />
          </div>
          <br></br>
          
          <Progress color="danger" value="100" />
          <br></br>
          <FadeGithub />
          <FadeBlogs />
          <Button color="primary" href="mailto:cherara.reddah@icloud.com">Email</Button> {this.state.message}
          <br></br><br></br>
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

export default Contact;