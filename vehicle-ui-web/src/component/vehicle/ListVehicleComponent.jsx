import React, { Component } from 'react'
import ApiService from "../../service/ApiService";
//import { Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
//import i18n from '../../i18n';
import AppNavbar from '../shared/AppNavbar';


class ListVehicleComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {vehicles: []};
        this.deleteVehicle = this.deleteVehicle.bind(this);
        this.editVehicle = this.editVehicle.bind(this);
        this.addVehicle = this.addVehicle.bind(this);
        this.reloadVehicleList = this.reloadVehicleList.bind(this);
    }
    componentDidMount() {
        this.reloadVehicleList();
    }
    reloadVehicleList() {
        ApiService.fetchVehicles()
            .then((res) => {
                this.setState({vehicles: res.data})
            });
    }
    deleteVehicle(vehicleId) {
        ApiService.deleteVehicle(vehicleId)
           .then(res => {
               this.setState({message : 'Vehicle deleted successfully.'});
               this.setState({vehicles: this.state.vehicles.filter(vehicle => vehicle.id !== vehicleId)});
           })
    }
    editVehicle(id) {
        window.localStorage.setItem("vehicleId", id);
        this.props.history.push('/edit-vehicle');
    }
    addVehicle() {
        window.localStorage.removeItem("vehicleId");
        this.props.history.push('/add-vehicleId');
    }
    render() {
      
        return (
            <div>
                 <AppNavbar/>
                <h2 className="text-center">Vehicle Details </h2>
                <button className="btn btn-danger" style={{width:'100px'}} onClick={() => this.addVehicle()}> Add Vehicle</button>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th className="hidden">Id</th>
                            <th>Name</th>
                            <th>Year</th>
                            <th>vin</th>
                            <th>mileage</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.vehicles.map(
                        vehicle =>
                                    <tr key={vehicle.id}>
                                        <td>{vehicle.name}</td>
                                        <td>{vehicle.year}</td>
                                        <td>{vehicle.vin}</td>
                                        <td>{vehicle.mileage}</td>
                                        <td>{vehicle.price}</td>
                                        <td>
                                            <button className="btn btn-success" onClick={() => this.deleteVehicle(vehicle.id)}> Delete</button>
                                            <button className="btn btn-success" onClick={() => this.editVehicle(vehicle.id)} style={{marginLeft: '20px'}}> Edit</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
                
            </div>
        );
    }
}
export default ListVehicleComponent;