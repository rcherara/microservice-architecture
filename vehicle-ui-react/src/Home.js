import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    state = {};
 
  componentDidMount() {
      setInterval(this.hello, 250);
  }

  hello = () => {
      fetch('/api/hello')
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
          <Button color="link"><Link to="/vehicles">Manage Vehicles</Link></Button>
        </Container>
        <div className="App">
                <header className="App-header">
                  
                    <h1 className="App-title">{this.state.message}</h1>
                </header>
          </div>
      </div>
    );
  }
}

export default Home;