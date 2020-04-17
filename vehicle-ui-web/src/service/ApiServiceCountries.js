import axios from 'axios';
export const COUNTRY_API_BASE_URL  = 'https://restcountries.eu/rest/v2/';


class ApiServiceCountries {

    fetchCountries() {
        return axios.get(COUNTRY_API_BASE_URL );
    }

}

export default new ApiServiceCountries();