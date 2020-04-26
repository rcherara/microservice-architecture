import React, { Component} from 'react'
import { withRouter } from "react-router-dom";
import ApiServiceLangugesPreference from "../../service/ApiServiceLanguagePreference";
import { Container } from "reactstrap";
import i18n from '../../config/i18n';
import AppNavbar from "../containers/AppNavbar";

class ListLanguagePreferenceComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { languages: [] };

    this.reloadLanguageList = this.reloadLanguageList.bind(this);
  }
  componentDidUpdate(prevProps) {

  }
  componentDidMount(prevProps) {
    this.reloadLanguageList(); 
  }
  reloadLanguageList() {
    ApiServiceLangugesPreference.fetchLanguages().then(res => {
      this.setState({ languages: res.data });
    });
  }
  render() {
    return (
      <div>
        <AppNavbar />
        <Container fluid> 
            <div className="float-right">
              photo
            </div>
            <h3>{i18n.t("navigation.language")}</h3>
            <section>  
              <div className="table-responsive text-nowrap">
                  <table id="tablePreview" className="table table-sm table-hover">               
                    <thead>
                        <tr>
                        <th>#</th>
                        <th>{i18n.t("words.language_code")}</th>
                        <th>{i18n.t("words.name")}</th>
                        <th>{i18n.t("words.name_in_native_language")}</th>
                        <th>{i18n.t("words.date_format")}</th>
                        <th>{i18n.t("words.currency")}</th>
                        </tr>
                    </thead>         
                    <tbody>
                    {this.state.languages.map(language => (
                        <tr  key={language.id}>
                        <th scope="row">{language.id}</th>
                        <td>{language.code}</td>
                        <td>{language.name}</td>
                        <td>{language.name_in_native_language}</td>
                        <td>{language.date_format}</td>
                        <td>{language.currency}</td>
                   
                      </tr>
                        ))}                     
                    </tbody>
                    <tfoot>
                        <tr>
                        <th>#</th>
                        <th>{i18n.t("words.language_code")}</th>
                        <th>{i18n.t("words.name")}</th>
                        <th>{i18n.t("words.name_in_native_language")}</th>
                        <th>{i18n.t("words.date_format")}</th>
                        <th>{i18n.t("words.currency")}</th>
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
export default withRouter(ListLanguagePreferenceComponent);