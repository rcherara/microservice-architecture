import React from "react";
//import { Link } from "react-router-dom";
import PageNotFound from "../../images/where_vin.png";
import AppNavbar from "./AppNavbar";
class NotFoundPage extends React.Component {
  render() {
    return (
      <div >
        <AppNavbar />
        <div class="fullscreen">
          <img src={PageNotFound} alt="404 page"/>
        </div>

      </div>
    );
  }
}
export default NotFoundPage;
