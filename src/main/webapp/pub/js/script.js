let submitForm = document.getElementById("signUpForm");
submitForm.addEventListener("submit", validatePassword);

function validatePassword(){


    let pTag = document.getElementById("PasswordErrorMessage");
    let passwordText = document.getElementById("password").value;


    let cpTag = document.getElementById("ConfirmPasswordErrorMessage");
    let cpasswordText = document.getElementById("confirmPassword").value;



    if ( passwordText === ""){

        pTag.innerHTML = "Password field cannot be empty"
        pTag.style.color = "red";

        return false;
    }

    else if(passwordText<8  ||  passwordText>20){

        /* document.signUpForm.lastName.focus();
        lastNameTag.appendChild(pTag); */

        pTag.innerHTML = "Password field must be within 8 - 20 characters "
        pTag.style.color = "red";

        return false;

    }
    else if( cpasswordText !== passwordText){
        cpTag.innerHTML = "Passwords do not match"
        cpTag.style.color = "red";
        return false;
    }

    else {
        /*   pTag.innerHTML = "This is not a valid email";
          pTag.style.color = "red"; */
        return true;
    }

}