import React, { Component } from 'react'
import { Link  } from 'react-router-dom';
import ApiServiceVehicle from "../../service/ApiServiceVehicle";
import i18n from '../../config/i18n';
import AppNavbar from '../containers/AppNavbar';
import { Button, Container, Form, FormGroup, Input, Label} from 'reactstrap';

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
            message: null,
            file: null,
        }
        this.saveVehicle = this.saveVehicle.bind(this);
        this.loadVehicle = this.loadVehicle.bind(this);
        this.file = this.handleFileChange.bind(this);
    }

    componentDidMount() {
        this.loadVehicle();
    }

    loadVehicle() {
      ApiServiceVehicle.fetchVehicleById(window.localStorage.getItem("id"))
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

    handleFileChange({target: {files}}) {
      const maxSize = 50000;
      const [file] = files;
  
      if (file.size <= maxSize) {
        alert('the file size is valid')
      } else {
        alert(
          `The file you are trying to upload is ${file.size} bytes. ` +
          `The maximum file size is ${maxSize} bytes.`
        )
      }
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveVehicle = (e) => {
        e.preventDefault();
        let vehicle = {id: this.state.id, name: this.state.name, year: this.state.year, vin: this.state.vin, mileage: this.state.mileage, price: this.state.price};
        ApiServiceVehicle.editVehicle(vehicle)
            .then(res => {
                this.setState({message : i18n.t('update.mess')});
                this.props.history.push('/vehicles');
            });
    }


    render() {
        const title = <h2> {i18n.t("update.vehicle")}</h2>;
        return <div>
          <AppNavbar/>
          <Container>
            {title}
            <Form onSubmit={this.handleSubmit}>
            <div className="row">
                  <FormGroup className="col-md-4 mb-3">
                    <Label for="name">Name {i18n.t("add.vehicle")}'</Label>
                    <Input type="text" name="name" id="name" value={this.state.name || ''}
                            onChange={this.handleChange} autoComplete="name"/>
                  </FormGroup>
                  <FormGroup className="col-md-4 mb-3"> 
                    <Label for="year">Year {i18n.t("add.vehicle")}'</Label>
                    <Input type="text" name="year" id="year" value={this.state.year || ''}
                            onChange={this.handleChange} autoComplete="year"/>
                  </FormGroup>
                  <FormGroup className="col-md-4 mb-3">
                    <Label for="vin">Vehicle Identification Number</Label>
                    <Input type="text" name="vin" id="vin" value={this.state.vin || '' }
                          readOnly={true}  onChange={this.handleChange} autoComplete="vin"/>
                  </FormGroup>
              </div>
    
              <div className="row">
                <FormGroup className="col-md-4 mb-3">
                  <Label for="colour">Color</Label>
                  <Input type="text" name="color" id="color" value={this.state.color || ''}
                         onChange={this.handleChange} autoComplete="color"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="mileage">Mileage</Label>
                  <Input type="text" name="mileage" id="mileage" value={this.state.mileage || ''}
                         onChange={this.handleChange} autoComplete="mileage"/>
                                
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="price">Price</Label>
                  <Input type="text" name="price" id="price" value={this.state.price || ''}
                         onChange={this.handleChange} autoComplete="price"/>
                </FormGroup>
             </div>
    
             <div className="row">
                <FormGroup className="col-md-4 mb-3">
                  <Label for="model">Model</Label>
                  <Input type="text" name="model" id="model" value={this.state.model || ''}
                         onChange={this.handleChange} autoComplete="model"/>
                </FormGroup>
    
                <FormGroup className="col-md-4 mb-3">
    
    
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="location">Location</Label>
                  <Input type="text" name="location" id="location" value={this.state.location || ''}
                         onChange={this.handleChange} autoComplete="location"/>
                                
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="position">Position</Label>
                  <Input type="text" name="position" id="position" value={this.state.position || ''}
                         onChange={this.handleChange} autoComplete="position"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="tag">Tag</Label>
                  <Input type="text" name="tag" id="tag" value={this.state.tag || ''}
                         onChange={this.handleChange} autoComplete="tag"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="AWD">AWD</Label>
                  <Input type="text" name="AWD" id="AWD" value={this.state.AWD || ''}
                         onChange={this.handleChange} autoComplete="AWD"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="cost">Cost</Label>
                  <Input type="text" name="cost" id="cost" value={this.state.cost || ''}
                         readOnly={true} onChange={this.handleChange} autoComplete="cost"/>
                </FormGroup>
    
             </div>
    
             <div className="row">
                <FormGroup className="col-md-4 mb-3">
                  <Label for="numOfWindows">Model</Label>
                  <Input type="text" name="numOfWindows" id="numOfWindows" value={this.state.numOfWindows || ''}
                         onChange={this.handleChange} autoComplete="numOfWindows"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="electric">Electric</Label>
                  <Input type="text" name="electric" id="electric" value={this.state.electric || ''}
                         onChange={this.handleChange} autoComplete="electric"/>
                                
                </FormGroup>
                
                <FormGroup className="col-md-4 mb-3">
                  <Label for="brand">Brand</Label>
                  <Input type="text" name="brand" id="brand" value={this.state.brand || ''}
                         onChange={this.handleChange} autoComplete="brand"/>
                </FormGroup>
             </div>
    
             <div className="row">
                <FormGroup className="col-md-4 mb-3">
                  <Label for="tag">Engine</Label>
                  <Input type="text" name="engine" id="engine" value={this.state.engine || ''}
                         onChange={this.handleChange} autoComplete="engine"/>
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="type">Type</Label>
                  <Input type="text" name="type" id="type" value={this.state.type || ''}
                         onChange={this.handleChange} autoComplete="type"/>
                                
                </FormGroup>
                <FormGroup className="col-md-4 mb-3">
                  <Label for="tyre">Tyre</Label>
                  <Input type="text" name="tyre" id="tyre" value={this.state.tyre || ''}
                         onChange={this.handleChange} autoComplete="tyre"/>
                  <input type="file" onChange={this.handleFileChange}/>
                </FormGroup>
             </div>
              <FormGroup>
                <Button variant="outline-primary" color="primary" type="submit">Save</Button>{' '}
                <Button color="secondary" tag={Link} to="/list-vehicles">Cancel</Button>
              </FormGroup>
            </Form>
          </Container>
        </div>
      }

}
export default EditUVehicleComponent;