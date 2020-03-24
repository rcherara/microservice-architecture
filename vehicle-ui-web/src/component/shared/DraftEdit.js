import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label, FormText} from 'reactstrap';
import { InputGroup, InputGroupAddon, InputGroupText } from 'reactstrap';
import AppNavbar from '../AppNavbar';

class VehicleEdit extends Component {

  emptyItem = {
    id: '',
    name: '',
    year: '',
    vin: '',
    colour: '',
    mileage: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem
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
          <FormGroup>
            <Label for="name">Name</Label>
            <Input type="text" name="name" id="name" value={item.name || ''}
                   onChange={this.handleChange} autoComplete="name"/>
          </FormGroup>
          <FormGroup>
            <Label for="year">Year</Label>
            <Input type="text" name="year" id="year" value={item.year || ''}
                   onChange={this.handleChange} autoComplete="year"/>
          </FormGroup>
          <FormGroup>
            <Label for="vin">vin</Label>
            <Input type="text" name="vin" id="vin" value={item.vin || ''}
                   onChange={this.handleChange} autoComplete="vin"/>
          </FormGroup>
          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="colour">Colour</Label>
              <Input type="text" name="colour" id="colour" value={item.colour || ''}
                     onChange={this.handleChange} autoComplete="colour"/>
            </FormGroup>
            <FormGroup className="col-md-5 mb-3">
              <Label for="mileage">Mileage</Label>
              <Input type="text" name="mileage" id="mileage" value={item.mileage || ''}
                     onChange={this.handleChange} autoComplete="mileage"/>
            </FormGroup>
            <FormGroup className="col-md-3 mb-3">
              <Label for="price">Price</Label>
              <Input type="text" name="price" id="price" value={item.price || ''}
                     onChange={this.handleChange} autoComplete="price"/>
               <InputGroupAddon addonType="prepend">$</InputGroupAddon>
              <Input placeholder="Amount" min={0} max={1000000} type="number" step="1000" />
              <InputGroupAddon addonType="append">.00</InputGroupAddon>
            </FormGroup>
            <FormGroup>
        <Label for="exampleEmail">Email</Label>
        <Input type="email" name="email" id="exampleEmail" placeholder="with a placeholder" />
      </FormGroup>
      <FormGroup>
        <Label for="examplePassword">Password</Label>
        <Input type="password" name="password" id="examplePassword" placeholder="password placeholder" />
      </FormGroup>
      <FormGroup>
        <Label for="exampleSelect">Select</Label>
        <Input type="select" name="select" id="exampleSelect">
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </Input>
      </FormGroup>
      <FormGroup>
        <Label for="exampleSelectMulti">Select Multiple</Label>
        <Input type="select" name="selectMulti" id="exampleSelectMulti" multiple>
          <option>1</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </Input>
      </FormGroup>
      <FormGroup>
        <Label for="exampleText">Text Area</Label>
        <Input type="textarea" name="text" id="exampleText" />
      </FormGroup>
      <FormGroup>
        <Label for="exampleFile">File</Label>
        <Input type="file" name="file" id="exampleFile" />
        <FormText color="muted">
          This is some placeholder block-level help text for the above input.
          It's a bit lighter and easily wraps to a new line.
        </FormText>
      </FormGroup>
      <FormGroup tag="fieldset">
        <legend>Radio Buttons</legend>
        <FormGroup check>
          <Label check>
            <Input type="radio" name="radio1" />{' '}
            Option one is this and that—be sure to include why it's great
          </Label>
        </FormGroup>
        <FormGroup check>
          <Label check>
            <Input type="radio" name="radio1" />{' '}
            Option two can be something else and selecting it will deselect option one
          </Label>
        </FormGroup>
        <FormGroup check disabled>
          <Label check>
            <Input type="radio" name="radio1" disabled />{' '}
            Option three is disabled
          </Label>
        </FormGroup>
      </FormGroup>
      <FormGroup check>
        <Label check>
          <Input type="checkbox" />{' '}
          Check me out
        </Label>
      </FormGroup>
            <InputGroup>
              <InputGroupAddon addonType="prepend">$</InputGroupAddon>
              <Input placeholder="Amount" min={0} max={1000000} type="number" step="1000" />
              <InputGroupAddon addonType="append">.00</InputGroupAddon>
            </InputGroup>
           {/*  <Dropdown>
              <Dropdown.Toggle variant="success" id="dropdown-basic">
                Dropdown Button
              </Dropdown.Toggle>

              <Dropdown.Menu>
                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown> */}
          </div>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/vehicles">Cancel</Button>
          </FormGroup>
        </Form>
        <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>@</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="username" />
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>
            <Input addon type="checkbox" aria-label="Checkbox for following text input" />
          </InputGroupText>
        </InputGroupAddon>
        <Input placeholder="Check it out" />
      </InputGroup>
      <br />
      <InputGroup>
        <Input placeholder="username" />
        <InputGroupAddon addonType="append">
          <InputGroupText>@example.com</InputGroupText>
        </InputGroupAddon>
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">
          <InputGroupText>$</InputGroupText>
          <InputGroupText>$</InputGroupText>
        </InputGroupAddon>
        <Input placeholder="Dolla dolla billz yo!" />
        <InputGroupAddon addonType="append">
          <InputGroupText>$</InputGroupText>
          <InputGroupText>$</InputGroupText>
        </InputGroupAddon>
      </InputGroup>
      <br />
      <InputGroup>
        <InputGroupAddon addonType="prepend">$</InputGroupAddon>
        <Input placeholder="Amount" min={0} max={100} type="number" step="1" />
        <InputGroupAddon addonType="append">.00</InputGroupAddon>
      </InputGroup>
      </Container>
    </div>
  }
}

export default withRouter(VehicleEdit);