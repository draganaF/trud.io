export function validateEmail(email) {
    const re = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;
    return re.test(String(email).toLowerCase());
}

export function validateStringWithLettersOnly(stringToValidate) {
    const re = /^[a-zA-Z]+$/;
    return re.test(String(stringToValidate));
}

export function validateStringWithLettersAndNumbersOnly(stringToValidate) {
    const re = /^[a-zA-Z0-9]+$/;
    return re.test(String(stringToValidate));
}
  