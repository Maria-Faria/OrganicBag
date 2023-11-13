
function validar() {
    let password = newUser.senha.value
    let email = newUser.email.value
    let nome = newUser.nome.value
    let cpf = newUser.cpf.value

    if(password.length < 10) {
        alert('Senha muito curta! A senha deve possuir pelo menos 10 dígitos')
        newUser.senha.focus()
        return false
    
    }else if(email == "" || nome == "" || cpf == "") {
        alert('Preencha todos os campos obrigatórios corretamente!')

    }else if(cpf.length < 11 || cpf.length > 11) {
        alert("CPF inválido! Tente novamente!")    
    }
    
    else {
        document.forms["newUser"].submit()
    }
}