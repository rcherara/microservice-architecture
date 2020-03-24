class ItemService {

    constructor() {
        this.items = [
            { "id": 1, "vin": "SAD23SDSSDSS", "name": "test1 Mazda3", "plate": "SDE34422", "year": 2019, "position": "Alger", "location": "Rue Didouche Mourad", "tag": "WSDLKALK", "model": "SUV", "type": "Type", "brand": "sfasfa", "mileage": 23434.0, "color": "Red", "engine": "MEDIUM", "tyre": "SUMMER", "price": 23333.0, "numOfWindows": 6, "AWD": true, "cost": 1.2312312E7, "electric": false },
            { "id": 3, "vin": "SAD23SDSSD44", "name": "test2 Mazda6", "plate": "SDE34411", "year": 2020, "position": "Batna", "location": "Rue Ben Bouliad ", "tag": "WSDLKALK", "model": "SUV", "type": "Type", "brand": "sfasfa", "mileage": 23434.0, "color": "Red", "engine": "MEDIUM", "tyre": "SUMMER", "price": 23333.0, "numOfWindows": 6, "AWD": true, "cost": 1.2312312E7, "electric": false },
        ];
    }

    async retrieveItems() {
        return Promise.resolve(this.items);
    }

    async getItem(itemLink) {
        for (var i = 0; i < this.items.length; i++) {
            if (this.items[i].link === itemLink) {
                return Promise.resolve(this.items[i]);
            }
        }
        return null;
    }

    async createItem(item) {
        console.log("ItemService.createItem():");
        console.log(item);
        return Promise.resolve(item);
    }

    async deleteItem(itemId) {
        console.log("ItemService.deleteItem():");
        console.log("item ID:" + itemId);
    }

    async updateItem(item) {
        console.log("ItemService.updateItem():");
        console.log(item);
    }

}

export default ItemService;