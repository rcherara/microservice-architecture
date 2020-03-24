class Validator {

    validateInputs(inputData) {
      let errorMsg = "";
      if(!inputData.name) {
        errorMsg +="Please enter name of this item.\n"
      }
      if(!inputData.summary) {
        errorMsg +="Please enter summary of this item.\n"
      }
      if(inputData.year.toString().match(/[^0-9]/g)) {
        errorMsg +="Year must be a number.\n"
      }
      if(inputData.country.length > 0 && !inputData.country.match(/^[a-z|A-Z][a-z|A-Z]$/)) {
        errorMsg +="Country code must be two letters.\n"
      }
      if(errorMsg.length == 0){
        return true;
      } else {
        alert(errorMsg);
        return false;
      }
    }
  }
  
  export default Validator;