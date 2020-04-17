import axios from 'axios';

const Languages_API_BASE_URL = 'http://localhost:8081/api/languages';

class ApiServiceLanguagePreference {

    fetchLanguages() {
        return axios.get(Languages_API_BASE_URL );
    }

}

export default new ApiServiceLanguagePreference();