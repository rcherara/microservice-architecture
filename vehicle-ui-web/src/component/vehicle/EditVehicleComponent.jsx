import React, { Component } from 'react'
import ApiService from "../../service/ApiService";
import i18n from '../../i18n';
import AppNavbar from '../shared/AppNavbar';

class EditUVehicleComponent extends Component {

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
        this.loadVehicle = this.loadVehicle.bind(this);
    }

    componentDidMount() {
        this.loadVehicle();
    }

    loadVehicle() {
        ApiService.fetchVehicleById(window.localStorage.getItem("id"))
            .then((res) => {
                let vehicle = res.data.result;
                this.setState({
                id: vehicle.id,
                name: vehicle.name,
                year: vehicle.year,
                vin: vehicle.vin,
                mileage: vehicle.mileage,
                price: vehicle.price,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveVehicle = (e) => {
        e.preventDefault();
        let vehicle = {id: this.state.id, name: this.state.name, year: this.state.year, vin: this.state.vin, mileage: this.state.mileage, price: this.state.price};
        ApiService.editUser(vehicle)
            .then(res => {
                this.setState({message : i18n.t('update.mess')});
                this.props.history.push('/vehicles');
            });
    }

    render() {
        return (
            <div>
                 <AppNavbar/>
                <h2 className="text-center"> {i18n.t('update.vehicle')} </h2>
                <form>

                    <div className="form-group">
                        <label>Name:</label>
                        <input type="text" placeholder="name" name="name" className="form-control" readonly="true" defaultValue={this.state.name}/>
                    </div>

                    <div className="form-group">
                        <label>Year:</label>
                        <input placeholder="year" name="year" className="form-control" value={this.state.year} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Vin:</label>
                        <input placeholder="vin" name="vin" className="form-control" value={this.state.vin} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Mileage:</label>
                        <input type="number" placeholder="mileage" name="mileage" className="form-control" value={this.state.mileage} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Price:</label>
                        <input type="number" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                    </div>

                    <button className="btn btn-success" onClick={this.saveUser}>Save</button>
                </form>
            </div>
        );
    }
}

export default EditUVehicleComponent;