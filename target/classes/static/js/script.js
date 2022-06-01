function chkFields() {
    if (document.getElementById("inputUsername").value === "" ||
        document.getElementById("inputPassword").value === "") {
        document.getElementById('regBtn').disabled = true;
    } else {
        document.getElementById('regBtn').disabled = false;
    }
}

function chkDB() {
    if (userOrder.value != null) {
        document.getElementById('OrderBtn').disabled = true;
    } else {
        document.getElementById('OrderBtn').disabled = false;
    }
}

function useVariable() {
    var tempUsername = userInfo;
}