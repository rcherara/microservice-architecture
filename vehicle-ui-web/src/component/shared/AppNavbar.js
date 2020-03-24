import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';
import i18n from '../../i18n';
//import { getLanguage, setLanguage, useTranslation } from 'react-multi-lang';

export default class AppNavbar extends Component {
  constructor(props) {
    super(props);
    this.state = {isOpen: false};
    this.toggle = this.toggle.bind(this);
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

  render() {
    //const t = useTranslation();
    const languages = [
			{ code: 'en', name: "ENGLISH" },
      { code: 'fr', name: "FRENCH"},
      { code: 'ar', name: "ARABIC"},
      { code: 'es', name: "ESPAGNOLE"},
      { code: 'it', name: "ITALIAN"}
		];
		const options = languages.map((language) => {
			return (
        <button onClick={() => language.code }>{language.name}</button>		
        
			);
		});
    return <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">{i18n.t('navigation.home')}</NavbarBrand>

      <div>{options}</div>

      <NavbarToggler onClick={this.toggle}/>
      <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>
          <NavItem>
            <NavLink
              href="/vehicle/new">{i18n.t('navigation.add')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="vehicles">{i18n.t('navigation.vehicles')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/about">{i18n.t('navigation.about')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/contact">{i18n.t('navigation.contact')}</NavLink>
          </NavItem>
          <NavItem>
            <NavLink
              href="https://rcherara.ca/rcherara/">@rcherara</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="https://github.com/rcherara/">GitHub</NavLink>
          </NavItem>
        </Nav>
      </Collapse>
    </Navbar>;
  }
}
