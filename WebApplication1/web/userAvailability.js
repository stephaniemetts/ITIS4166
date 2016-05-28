/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function askServer()
{
    var checkUsername = document.getElementById("theUsername").value;
    //window.alert(grabbedNumber);
    
    $.ajax({
    type: "POST",
    url: "checkUserAvailability",
    data: { sendUsername: checkUsername},
    success: doWhenDataComes
});

}

function doWhenDataComes(data, status)
{
    //window.alert(data);
    var theh4 = document.getElementById("usernameAvailable");
    theh4.innerHTML = data;
    var theh42 = document.getElementById("username2Available");
    theh42.innerHTML = data;
}