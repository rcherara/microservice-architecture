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
      <div>
        <AppNavbar />
        <Container fluid>   
            <div className="float-right">
                <img src={CountryIcon} width="50" height="50" className="rounded float-left" alt="aligment" />
            </div>
            <h3> {i18n.t("navigation.countries")}</h3>  
            <section>  
              <div className="table-responsive text-nowrap">
                  <table id="tablePreview" className="table table-sm table-hover">               
                    <thead>
                        <tr>
                        <th>{i18n.t("countries.name")}</th>
                        <th>{i18n.t("countries.flag")}</th>
                        <th>{i18n.t("countries.nativeName")}</th>
                        <th>{i18n.t("countries.alpha2Code")}</th>
                        <th>{i18n.t("countries.callingCodes")}</th>
                        <th>{i18n.t("countries.capital")}</th>
                        <th>{i18n.t("countries.region")}</th>
                        <th>{i18n.t("countries.subregion")}</th>
                        <th>{i18n.t("countries.population")}</th>
                        <th>{i18n.t("countries.currenciesSymbol")}</th>
                        <th>{i18n.t("countries.currenciesName")}</th>
                        </tr>
                    </thead>         
                    <tbody>
                        {this.state.countries.map(country => (
                          <tr  key={country.name}>
                            <th scope="row">{country.name}</th>
                                <td> <div className="logo">
                                      <img src={country.flag} width="10" height="70" className="img-thumbnail" />
                                    </div>
                                </td>
                                <td>{country.nativeName}</td>
                                <td>{country.alpha2Code}</td>
                                <td>{country.callingCodes}</td>
                                <td>{country.capital}</td>
                                <td>{country.region}</td>
                                <td>{country.subregion}</td>
                                <td>{country.population}</td>
                                <td>{country.currencies.map(function(nodes) {
                                        return <div key={nodes.code}> {nodes.symbol } </div>
                                    })}  
                                </td>
                                <td>{country.currencies.map(function(nodes) {
                                        return <div key={nodes.code}> {nodes.name}</div>
                                    })}  
                                </td>  
                          </tr>                     
                        ))}                     
                    </tbody>
                    <tfoot>
                       <tr>
                          <th>{i18n.t("countries.name")}</th>
                          <th>{i18n.t("countries.flag")}</th>
                          <th>{i18n.t("countries.nativeName")}</th>
                          <th>{i18n.t("countries.alpha2Code")}</th>
                          <th>{i18n.t("countries.callingCodes")}</th>
                          <th>{i18n.t("countries.capital")}</th>
                          <th>{i18n.t("countries.region")}</th>
                          <th>{i18n.t("countries.subregion")}</th>
                          <th>{i18n.t("countries.population")}</th>
                          <th>{i18n.t("countries.population")}</th>
                          <th>{i18n.t("countries.currenciesSymbol")}</th>
                          <th>{i18n.t("countries.currenciesName")}</th>                          
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

export default withRouter(ListCountriesComponent);