
function validar() {
    let password = newPassword.senha.value
    let email = newPassword.email.value

    if (email == "") {
        alert('Preencha o campo "email"!')
    
    }else if(password.length < 10) {
        alert('Senha muito curta! A senha deve possuir pelo menos 10 dígitos')
        newPassword.senha.focus()
        return false
    
    }else {
        document.forms["newPassword"].submit()
    }
}