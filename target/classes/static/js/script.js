function chkFields() {
    if(document.getElementById("inputUsername").value==="" ||
        document.getElementById("inputPassword").value==="")
    {
        document.getElementById('regBtn').disabled = true;
    } else {
        document.getElementById('regBtn').disabled = false;
    }
}