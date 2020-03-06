import React, { Component }  from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import AppNavbar from './AppNavbar';

function MyResponsiveComponent() {
    const width = useWindowWidth(); // Our custom Hook
    return (
      <p>Window width is {width}</p>
    );
  }
  
class Message extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        message: "sffssa"    
      };
    }
  
    componentDidMount() {
      /* ... */
    }
  
    render() {
      return <div>{this.state.message}</div>;
    }
  }


  export default withRouter(Message);
