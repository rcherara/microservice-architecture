import React, { Component } from 'react'
//import axios from 'axios';
import ApiService from "../../service/ApiService";
import { Container} from 'reactstrap';
//import { Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';
import AppNavbar from '../shared/AppNavbar';
import i18n from '../../i18n';
class AddVehicleComponent extends Component{
    constructor(props){
        super(props);
        this.state ={
            id: '',
            name: '',
            year: '',
            vin: '',
            color: '',
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
            cost: '',
            message: null
        }
        this.saveVehicle = this.saveVehicle.bind(this);
    }
    saveVehicle = (e) => {
        e.preventDefault();
        let vehicle = {name: this.state.name, vin: this.state.vin, firstName: this.state.firstName, lastName: this.state.lastName, age: this.state.age, salary: this.state.salary};
        ApiService.addVehicle(vehicle)
            .then(res => {
                this.setState({message : 'Vehicle added successfully.'});
                this.props.history.push('/vehicles');
            });
    }
    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });
    render() {
        return(
            <div>
                <AppNavbar/>
                    <Container>
                    <h2 className="text-center"> {i18n.t('add.vehicle')} </h2>
                            <form>
                            <div className="form-group">
                                <label>Name:</label>
                                <input type="text" placeholder="name" name="name" className="form-control" value={this.state.name} onChange={this.onChange}/>
                            </div>
                            <div className="form-group">
                                <label>vin:</label>
                                <input type="vin" placeholder="vin" name="vin" className="form-control" value={this.state.vin} onChange={this.onChange}/>
                            </div>
                            <div className="form-group">
                                <label>Year:</label>
                                <input placeholder="year" name="year" className="form-control" value={this.state.year} onChange={this.onChange}/>
                            </div>
                            <div className="form-group">
                                <label>Color:</label>
                                <input placeholder="color" name="color" className="form-control" value={this.state.color} onChange={this.onChange}/>
                            </div>
                            <div className="form-group">
                                <label>mileage:</label>
                                <input type="number" placeholder="mileage" name="mileage" className="form-control" value={this.state.mileage} onChange={this.onChange}/>
                            </div>

                            <div className="form-group">
                                <label>price:</label>
                                <input type="number" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                            </div>
                            <button className="btn btn-success" onClick={this.saveVehicle}>Save</button>
                        </form>
                    </Container>
            
             </div>
        );
    }
}
export default AddVehicleComponent;