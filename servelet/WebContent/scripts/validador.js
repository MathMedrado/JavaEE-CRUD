/**
 * Validação de formulário
 */
function validar(){
    let nome = frmContato.nome.value
    let quantidade = frmContato.quantidade.value

    if (nome === ""){
        alert("Preencha o campo Nome")
        frmConta.nome.focus() /*posiciona o cursor em cima do nome*/
        return false
    } else if (quantidade === ""){
        alert("Preencha o campo quantidade")
        frmConta.quantidade.focus() /*posiciona o cursor em cima do nome*/
        return false
    } else{
        document.forms["frmContato"].submit()
    }

}

