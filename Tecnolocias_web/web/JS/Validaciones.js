/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validaP(form){
    alert("Las contraseñas no coinciden");
    var a =form.pass.value;
    var b =form.pass.value; 
    if (a===b) {
        return true;
    } else {    // input is valid -- reset the error message
        alert('Las contraseñas no coinciden');
        return false;
    }
}