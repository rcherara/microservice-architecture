import React, { Component,Suspense } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';
import i18n from '../../config/i18n';
import LanguageSelector from './LanguageSelector'
import PropTypes from 'prop-types';

class AppNavbar extends Component {
  constructor(props) {
    super(props);
    this.state = { isOpen: false, myLanguage: i18n.locale };
    this.toggle = this.toggle.bind(this);
    this.i18n = this.toggle.bind(this);
  }
  toggleLanguage() {
    this.setState({
      myLanguage: !this.state.myLanguage
    });
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  clickIngredient = (ev) => {
    let val = ev.target.dataset.value;
    console.log(val);
    
 
  };
  componentWillUnmount(){
    // Called IMMEDIATELY before a component is unmounted
    // Good for cleaning up listeners
    //i18n.locale = this.state.myLanguage;
  };
  render() {
    return <Navbar color="dark" dark expand="md" >
      <NavbarBrand tag={Link} to="/">{i18n.t('navigation.home')}</NavbarBrand>

      <NavbarToggler onClick={this.toggle} />
      <Collapse isOpen={this.state.isOpen} navbar>
 
        <Nav className="ml-auto" navbar>
        <NavItem><Suspense fallback={<Loader />}>
          <LanguageSelector />
         
        </Suspense></NavItem>
          <NavItem>
            <NavLink href="/vehicle/new">{i18n.t('navigation.add')} </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="list-vehicles">{i18n.t('navigation.vehicles')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/about">{i18n.t('navigation.about')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/contact">{i18n.t('navigation.contact')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="https://rcherara.ca/rcherara/"> {i18n.t('navigation.settings')} </NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/login"> {i18n.t('navigation.login')} </NavLink>
          </NavItem>
        </Nav>
      </Collapse>
    </Navbar>
  }
}
// loading component for suspense fallback
const Loader = () => (
  <div className="App">   
    <div>loading...</div>
  </div>
);

AppNavbar.propTypes = {
  t: PropTypes.func.isRequired,
};
export default AppNavbar;