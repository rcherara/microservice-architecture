import axios from 'axios';

const Vehicle_API_BASE_URL = 'http://localhost:8081/api/vehicle';
const Vehicles_API_BASE_URL = 'http://localhost:8081/api/vehicles';
const MESSAGE_API_BASE_URL = 'http://localhost:8081/api/message';

class ApiService {

    fetchVehicles() {
        return axios.get(Vehicles_API_BASE_URL );
    }

    fetchVehicleById(vehicleId) {
        return axios.get(Vehicle_API_BASE_URL + '/' + vehicleId);
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
        return axios.get(MESSAGE_API_BASE_URL + '/' + messageName);
    }

}

export default new ApiService();