import ballerina.lang.exceptions;
import ballerina.lang.system;

const string ageError = "age-error";
const string lowAgeError = "low-age";

function calculateLoanPayment(string name, int age, int amount, int months)(string) {
    double payment = 0;
    try{
        try{
            validateAge(age);
        } catch (exception e) {
            if( exceptions:getCategory(e) == "age-error" ){
                return "Error ..! " + exceptions:getMessage(e);
            }
            exception newE = {};
            exceptions:set(newE, "You are too young to apply a loan.", ageError);
            exceptions:setCause(newE, e);
            throw newE;
        }
        payment = amount/months;
    } catch (exception e) {
        string s = exceptions:getStackTrace(e);
        system:println(s);
        return s;
    }
    return "Your monthly payment is "+ payment;
}


function validateAge(int age){
    if(age > 50 ){
        exception overAge = {};
        exceptions:setMessage(overAge, "You should be under 50 years old to apply loan.");
        exceptions:setCategory(overAge, ageError);
        throw overAge;
    } else if ( age < 18) {
        exception underAge = {};
        exceptions:set(underAge, "You should be over 18 years old to apply loan.", lowAgeError);
        throw underAge;
    }
}