import axios from 'axios';

const Vehicle_API_BASE_URL = 'http://localhost:8081/api/vehicle';
const Vehicles_API_BASE_URL = 'http://localhost:8081/api/vehicles';
const MESSAGE_API_BASE_URL = 'http://localhost:8081/api/message';

const headers = {

    'Accept-Language': 'ar',
  };
 
   /* 'Content-Type': 'application/json',
  'X-Auth-Token': '97e0d315477f435489cf04904c9d0e6co', */

class ApiServiceVehicle {

    fetchVehicles() {
        return axios.get(Vehicles_API_BASE_URL );
    }

    fetchVehicleById(id) {
        try {
            // Load async data from an inexistent endpoint.
            let vehcilerData = axios.get(Vehicle_API_BASE_URL + '/' + id);
            return vehcilerData;
          } catch (e) {
            console.log(`😱 Axios request failed: ${e}`);
          }
    }

    deleteVehicle(vehicleId) {
        return axios.delete(Vehicle_API_BASE_URL + '/' + vehicleId);
    }

    addVehicle(vehicle) {
        return axios.post(""+Vehicle_API_BASE_URL, vehicle);
    }

    editVehicle(vehicle) {
        return axios.put(Vehicle_API_BASE_URL + '/' + vehicle.id, vehicle);
    }
    fetchMessageByName(messageName) {
        return axios.get(MESSAGE_API_BASE_URL + '/' + messageName, {headers});
    }
    fetchTime() {
        return axios.get(MESSAGE_API_BASE_URL + '/api/time', {headers});
    }
    
}

export default new ApiServiceVehicle();