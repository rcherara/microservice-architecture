import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

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

  render() {
    return <Navbar color="dark" dark expand="md">
      <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
      <NavbarToggler onClick={this.toggle}/>
      <Collapse isOpen={this.state.isOpen} navbar>
        <Nav className="ml-auto" navbar>
          <NavItem>
            <NavLink
              href="/vehicle/new">New</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="vehicles">Vehicles</NavLink>
          </NavItem>
          <NavItem>
            <NavLink
              href="https://rcherara.ca/rcherara/">@rcherara</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="https://github.com/rcherara/">GitHub</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/about">About</NavLink>
          </NavItem>
          <NavItem>
            <NavLink href="/contact">Contact</NavLink>
          </NavItem>
        </Nav>
      </Collapse>
    </Navbar>;
  }
}
