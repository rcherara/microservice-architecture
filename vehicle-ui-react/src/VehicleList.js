import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';


class VehicleList extends Component {

  constructor(props) {
    super(props);
    this.state = {vehicles: [], isLoading: true};
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('/api/vehicles')
      .then(response => response.json())
      .then(data => this.setState({vehicles: data, isLoading: false}));
  }

  async remove(id) {
    await fetch(`/api/vehicle/${id}`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    }).then(() => {
      let updatedVehicle= [...this.state.vehicles].filter(i => i.id !== id);
      this.setState({vehicles: updatedVehicle});
    });
  }

  render() {
    const {vehicles, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const vehicleList = vehicles.map(vehicle => {
      const infovehicle = `${vehicle.name} ${vehicle.year }`;
      return <tr key={vehicle.id}>
        <td style={{whiteSpace: 'nowrap'}}>{vehicle.id}</td>
        <td>{infovehicle}</td>
        <td>{vehicle.year}</td>
        <td>{vehicle.model}</td>
        <td>{vehicle.vin}</td>
        <td>{vehicle.mileage}</td>
        <td>{vehicle.cost}</td>
        <td>{vehicle.price}</td>
        <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/vehicle/" + vehicle.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(vehicle.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/vehicle/new">Add Vehicle</Button>
          </div>
          <h3>rcherara.ca ----  Vehicles</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="1%">ID</th>
              <th width="20%">Name - Color</th>
              <th width="20%">Year</th>
              <th width="20%">Model</th>
              <th width="20%">VIN</th>
              <th width="20%">Mileage</th>
              <th width="20%">Cost</th>
              <th width="20%">Price</th>
              <th width="10%">Manage</th>
            </tr>
            </thead>
            <tbody>
            {vehicleList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default VehicleList;