import React, { Component } from 'react';
import AppNavbar from '../shared/AppNavbar';
import i18n from '../../i18n';

class About extends Component {
    state = {};
 
  componentDidMount() {
      setInterval(this.hello, 250);
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
        <div className="App">
                <header className="App-header">                    
                    <h1 className="App-title">{i18n.t('navigation.about')} <br></br> {i18n.t('appName')}  <br></br>  {this.state.message}</h1>
                </header>
          </div>
      </div>
    );
  }
}

export default About;