import React, { Component } from 'react';
import AppNavbar from '../shared/AppNavbar';

class Contact extends Component {
    state = {};
 
  componentDidMount() {
      setInterval(this.hello, 250);
  }

  hello = () => {
      fetch('/api/contact')
          .then(response => response.text())
          .then(message => {
              this.setState({message: message});
          });
  };
  render() {
    return (
      
      <div>     
        <AppNavbar/>
        <div className="App">
                <header className="App-header">
                  
                    <h1 className="App-title">{this.state.message}</h1>
                </header>
          </div>
      </div>
    );
  }
}

export default Contact;