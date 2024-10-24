document.getElementById("cliente-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let nome = document.getElementById("nome").value;
    let endereco = document.getElementById("endereco").value;
    let telefone = document.getElementById("telefone").value;

    fetch('http://localhost:8081/api/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nome: nome,
            endereco: endereco,
            telefone: telefone
        })
    })
    .then(response => response.json())
    .then(data => {
        alert("Cliente cadastrado com sucesso!");
        // Limpar o formulário
        document.getElementById("cliente-form").reset();
    })
    .catch(error => console.error('Erro ao cadastrar cliente:', error));
});
