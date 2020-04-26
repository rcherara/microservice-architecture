import React, { Component} from 'react'
import { withRouter } from "react-router-dom";
import ApiServiceCountries from "../../service/ApiServiceCountries";
import { Container } from "reactstrap";
import i18n from '../../config/i18n';
import AppNavbar from "../containers/AppNavbar";
import CountryIcon  from '../../images/img_country.png';

class ListCountriesComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { countries: [] };
    this.reloadLanguageList = this.reloadLanguageList.bind(this);
  }
  componentDidUpdate(prevProps) {
  }
  componentDidMount(prevProps) {
    this.reloadLanguageList();     
  }
  reloadLanguageList() {
    ApiServiceCountries.fetchCountries().then(res => {
      this.setState({ countries : res.data });
    });
  }
  render() {
    return (
      <div className="table-responsive-sm">
        <AppNavbar />
        <Container fluid>   
            <div className="float-right">
                <img src={CountryIcon} width="50" height="50" className="rounded float-left" alt="aligment" />
            </div>
            <h3> {i18n.t("navigation.countries")}</h3>  
            <small>
            <section >  
              <div className="table-responsive-sm text-nowrap">
                  <table id="tablePreview" className="table table-hover thread-dark">               
                    <thead>
                        <tr>
                        <th>{i18n.t("countries.flag")}</th>
                        <th>{i18n.t("countries.name")}</th>
                       
                        <th>{i18n.t("countries.nativeName")}</th>
                        <th>{i18n.t("countries.alpha2Code")}|{i18n.t("countries.capital")}</th>
                                   
                        <th>{i18n.t("countries.currenciesName")}</th>
                        
                        </tr>
                    </thead>         
                    <tbody>
                        {this.state.countries.map(country => (
                          <tr  key={country.name}>
                            <th scope="row"><div className="logo">
                                      <img src={country.flag} width="80" height="50" className="img-thumbnail" />
                                    </div></th>
                                <td width="5%"> {country.name} 
                                </td>
                                <td width="30%">{country.nativeName}</td>
                                <td width="10%">{country.alpha2Code}|{country.capital}</td>
                                                          
                                <td width="10%">{country.currencies.map(function(nodes) {
                                        return <div key={nodes.code}> {nodes.symbol } |  {nodes.name} </div>
                                    })}  
                                </td>
                              
                          </tr>                     
                        ))}                     
                    </tbody>
                    <tfoot>
                       <tr>
                       <th>{i18n.t("countries.flag")}</th>
                          <th>{i18n.t("countries.name")}</th>
                         
                          <th>{i18n.t("countries.nativeName")}</th>
                          <th>{i18n.t("countries.alpha2Code")}|{i18n.t("countries.capital")}</th>                         
                          
                                  
                          <th>{i18n.t("countries.currenciesName")}</th>
                                                   
                        </tr>
                    </tfoot>
                  </table>
              </div>
            </section> 
            </small> 
        </Container>
      </div>
    );
  }
}

export default withRouter(ListCountriesComponent);