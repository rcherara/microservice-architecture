import React, { Redirect,Component } from 'react';
import './css/App.css';
import {  BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomeComponent  from './component/home/Home';
import ContactComponent  from './component/contact/Contact';
import AboutComponent  from './component/about/About';
import AddVehicleComponent from './component/vehicle/AddVehicleComponent'; 
import EditVehicleComponent from './component/vehicle/EditVehicleComponent'; 
import ListVehicleComponent from "./component/vehicle/ListVehicleComponent";
import ListLanguagePreferenceComponent from "./component/language/ListLanguagePreferenceComponent";  
import ListCountriesComponent from "./component/language/ListCountriesComponent";  
import NotFoundPageComponent  from './component/containers/NotFoundPage.jsx';
import VehicleList from './component/vehicle/VehicleList';
import VehicleEdit from './component/vehicle/VehicleEdit';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
  };
    
  }

  componentDidUpdate(prevProps) {
 
  }
  componentDidMount(){
    // Invoked once the component is mounted to the DOM
    // Good for making AJAX requests
  }
  static getDerivedStateFromProps(nextProps, prevState) {
    // The object you return from this function will
    // be merged with the current state.
  }
  componentWillUnmount(){
    // Called IMMEDIATELY before a component is unmounted
    // Good for cleaning up listeners
  }
  
  render() {
    
    return (   
      <Router >
        <Switch>
          <Route path='/' exact={true} component={HomeComponent }/>
          <Route path='/vehicles' exact={true} component={VehicleList}/>
          <Route path='/vehicle/:id' component={VehicleEdit}/>
          <Route path="/add-vehicle" component={AddVehicleComponent} />
          <Route path="/edit-vehicle:id" component={EditVehicleComponent} />
          <Route path="/list-vehicles" component={ListVehicleComponent} />
          <Route path="/list-languages" component={ListLanguagePreferenceComponent} />
          <Route path="/list-countries" component={ListCountriesComponent} />
          <Route exact path="/contact/" component={ContactComponent } />
          <Route exact path="/about/" component={AboutComponent } />
          <Route path="/*" component={NotFoundPageComponent } />
                    <Redirect to="/404" />          
          <Route>{'404'}</Route>
          
        </Switch>
      </Router>
    )
  }
}
export default (App);
