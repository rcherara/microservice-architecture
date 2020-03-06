import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import VehicleList from './VehicleList';
import VehicleEdit from './VehicleEdit';
import Contact from './Contact';
import About from './About';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/vehicles' exact={true} component={VehicleList}/>
          <Route path='/vehicle/:id' component={VehicleEdit}/>
          <Route exact path="/contact/" component={Contact} />
          <Route exact path="/about" component={About} />
          <Route>{'404'}</Route>
        </Switch>
      </Router>
    )
  }
}

export default App;
