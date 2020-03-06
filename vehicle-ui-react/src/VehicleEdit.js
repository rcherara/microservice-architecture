import React, { Component, useState }  from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import AppNavbar from './AppNavbar';
// import { InputGroup, InputGroupAddon, InputGroupText } from 'reactstrap';


class VehicleEdit extends Component {

  emptyItem = {
    id: '',
    name: '',
    year: '',
    vin: '',
    colour: '',
    mileage: '',
    position: '',
    location: '',
    tag: '',
    model: '',
    type: '',
    brand: '',
    engine: '',
    price: '',
    numOfWindows: '',
    AWD: '',
    electric: '',
    cost: ''
  };


  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem,
      listOpen: false,
      headerTitle: this.props.title
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    if (this.props.match.params.id !== 'new') {
      const vehicle = await (await fetch(`/api/vehicle/${this.props.match.params.id}`)).json();
      this.setState({item: vehicle});
    }
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/api/vehicle', {
      method: (item.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/vehicles');
  }

  render() {
    const {item} = this.state;
    const title = <h2>{item.id ? 'Edit  Vehicle' : 'Add Vehicle'}</h2>;

  
    return <div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
        <div className="row">
              <FormGroup className="col-md-4 mb-3">
                <Label for="name">Name</Label>
                <Input type="text" name="name" id="name" value={item.name || ''}
                        onChange={this.handleChange} autoComplete="name"/>
              </FormGroup>
              <FormGroup className="col-md-4 mb-3"> 
                <Label for="year">Year</Label>
                <Input type="text" name="year" id="year" value={item.year || ''}
                        onChange={this.handleChange} autoComplete="year"/>
              </FormGroup>
              <FormGroup className="col-md-4 mb-3">
                <Label for="vin">Vehicle Identification Number</Label>
                <Input type="text" name="vin" id="vin" value={item.vin || '' }
                      readOnly={true}  onChange={this.handleChange} autoComplete="vin"/>
              </FormGroup>
          </div>

          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="colour">Color</Label>
              <Input type="text" name="color" id="color" value={item.color || ''}
                     onChange={this.handleChange} autoComplete="color"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="mileage">Mileage</Label>
              <Input type="text" name="mileage" id="mileage" value={item.mileage || ''}
                     onChange={this.handleChange} autoComplete="mileage"/>
                            
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="price">Price</Label>
              <Input type="text" name="price" id="price" value={item.price || ''}
                     onChange={this.handleChange} autoComplete="price"/>
            </FormGroup>
         </div>

         <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="model">Model</Label>
              <Input type="text" name="model" id="model" value={item.model || ''}
                     onChange={this.handleChange} autoComplete="model"/>
            </FormGroup>

            <FormGroup className="col-md-4 mb-3">


            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="location">Location</Label>
              <Input type="text" name="location" id="location" value={item.location || ''}
                     onChange={this.handleChange} autoComplete="location"/>
                            
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="position">Position</Label>
              <Input type="text" name="position" id="position" value={item.position || ''}
                     onChange={this.handleChange} autoComplete="position"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="tag">Tag</Label>
              <Input type="text" name="tag" id="tag" value={item.tag || ''}
                     onChange={this.handleChange} autoComplete="tag"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="AWD">AWD</Label>
              <Input type="text" name="AWD" id="AWD" value={item.AWD || ''}
                     onChange={this.handleChange} autoComplete="AWD"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="cost">Cost</Label>
              <Input type="text" name="cost" id="cost" value={item.cost || ''}
                     readOnly={true} onChange={this.handleChange} autoComplete="cost"/>
            </FormGroup>

         </div>

         <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="numOfWindows">Model</Label>
              <Input type="text" name="numOfWindows" id="numOfWindows" value={item.numOfWindows || ''}
                     onChange={this.handleChange} autoComplete="numOfWindows"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="electric">Electric</Label>
              <Input type="text" name="electric" id="electric" value={item.electric || ''}
                     onChange={this.handleChange} autoComplete="electric"/>
                            
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="brand">Brand</Label>
              <Input type="text" name="brand" id="brand" value={item.brand || ''}
                     onChange={this.handleChange} autoComplete="brand"/>
            </FormGroup>
         </div>

         <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="tag">Engine</Label>
              <Input type="text" name="engine" id="engine" value={item.engine || ''}
                     onChange={this.handleChange} autoComplete="engine"/>
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="type">Type</Label>
              <Input type="text" name="type" id="type" value={item.type || ''}
                     onChange={this.handleChange} autoComplete="type"/>
                            
            </FormGroup>
            <FormGroup className="col-md-4 mb-3">
              <Label for="tyre">Tyre</Label>
              <Input type="text" name="tyre" id="tyre" value={item.tyre || ''}
                     onChange={this.handleChange} autoComplete="tyre"/>
            </FormGroup>
         </div>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/vehicles">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
    </div>
  }
}

export default withRouter(VehicleEdit);
