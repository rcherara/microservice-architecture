import React, { Component} from 'react'
import { withRouter } from "react-router-dom";
import ApiServiceVehicle from "../../service/ApiServiceVehicle";
import { Button, Container } from "reactstrap";
import i18n from '../../config/i18n';
import AppNavbar from "../containers/AppNavbar";
import {  FaArrowCircleRight } from 'react-icons/fa';
 
 
 
class ListVehicleComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { vehicles: [] };
    
    this.deleteVehicle = this.deleteVehicle.bind(this);
    this.editVehicle = this.editVehicle.bind(this);
    this.addVehicle = this.addVehicle.bind(this);
    this.reloadVehicleList = this.reloadVehicleList.bind(this);
  }
 
  componentDidUpdate(prevProps) {


  }
  componentDidMount(prevProps) {
    this.reloadVehicleList(); 
    
  }
  reloadVehicleList() {
    ApiServiceVehicle.fetchVehicles().then(res => {
      this.setState({ vehicles: res.data });
    });
  }
  deleteVehicle(vehicleId) {
    ApiServiceVehicle.deleteVehicle(vehicleId).then(res => {
      this.setState({ message: "Vehicle deleted successfully." });
      this.setState({
        vehicles: this.state.vehicles.filter(
          vehicle => vehicle.id !== vehicleId
        )
      });
    });
  }
  editVehicle(id) {
    window.localStorage.setItem("id", id);
    this.props.history.push("/edit-vehicle/:"+{id});
  }
  viewVehicle(id) {
    window.localStorage.setItem("vehicleId", id);
    this.props.history.push("/view-vehicle");
  }
  addVehicle() {
    this.props.history.push("/add-vehicle");
  }
  
  render() {
     
    return (
      <div>
        <AppNavbar  />
        <Container fluid>
            <div className="float-right">
              <Button color="success" onClick={() => this.addVehicle()}  >
              {i18n.t("add.vehicle")} 
              </Button>
            </div>
            <h3 >{i18n.t("words.vehicles")}   <FaArrowCircleRight />  i18n.locale = {i18n.locale}-</h3>
            <section>  
              <div className="table-responsive text-nowrap">
                  <table id="tablePreview" className="table table-sm table-hover">
                
                    <thead>
                        <tr>
                        <th>#</th>
                        <th>{i18n.t("words.name")}</th>
                        <th>{i18n.t("words.plate")}</th>
                        <th>{i18n.t("words.year")}</th>
                        <th>{i18n.t("words.model")}</th>
                        <th>{i18n.t("words.vin")}</th>
                        <th>{i18n.t("words.mileage")}</th>
                        <th>{i18n.t("words.cost")}</th>
                        <th>{i18n.t("words.price")}</th>
                        <th>{i18n.t("words.position")}</th>
                        <th>{i18n.t("words.view")}</th>         
                        <th>{i18n.t("words.update")}</th>
                        <th>{i18n.t("words.delete")}</th>
                        </tr>
                    </thead>
            
                    <tbody>
                    {this.state.vehicles.map(vehicle => (
                        <tr  key={vehicle.id}>
                        <th scope="row">{vehicle.id}</th>
                        <td>{vehicle.name}</td>
                        <td>{vehicle.plate}</td>
                        <td>{vehicle.year}</td>
                        <td>{vehicle.model}</td>
                        <td>{vehicle.vin}</td>
                        <td>{vehicle.mileage}</td>
                        <td>{vehicle.cost}</td>
                        <td>{vehicle.price}</td>
                        <td>{vehicle.position}</td>
                        <td><button type="button" color="success"  className="btn btn-info"    onClick={() => this.viewVehicle(vehicle.id)} ><span className="ico"></span>{i18n.t("words.view")}</button></td>
                        <td><button type="button" color="success"  className="btn btn-success" onClick={() => this.editVehicle(vehicle.id)}   >{i18n.t("words.update")}</button></td>
                        <td><button type="button" color="success"  className="btn btn-danger"  onClick={() => this.deleteVehicle(vehicle.id)} >{i18n.t("words.delete")}</button></td>
                        </tr>
                        ))}
                      
                    </tbody>
                    <tfoot>
                        <tr>
                        <th>#</th>
                        <th>{i18n.t("words.name")}</th>
                        <th>{i18n.t("words.plate")}</th>
                        <th>{i18n.t("words.year")}</th>
                        <th>{i18n.t("words.model")}</th>
                        <th>{i18n.t("words.vin")}</th>
                        <th>{i18n.t("words.mileage")}</th>
                        <th>{i18n.t("words.cost")}</th>
                        <th>{i18n.t("words.price")}</th>
                        <th>{i18n.t("words.position")}</th>
                        <th>{i18n.t("words.view")}</th>                  
                        <th>{i18n.t("words.update")}</th>
                        <th>{i18n.t("words.delete")}</th>
                        </tr>
                    </tfoot>
                  </table>
              </div>
            </section>  
        </Container>
      </div>
    );
  }
}
 
export default  ListVehicleComponent;